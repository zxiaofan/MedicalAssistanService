/*
 * 文件名：RebuildDataBaseBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RebuildDataBaseBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年4月28日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business.impl;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zxiaofan.MedicalAssistanService.business.IRebuildDataBaseBusiness;
import com.zxiaofan.MedicalAssistanService.constant.Constant;
import com.zxiaofan.MedicalAssistanService.constant.ConstantApi;
import com.zxiaofan.MedicalAssistanService.dao.IDrmedDao;
import com.zxiaofan.MedicalAssistanService.model.bo.DiseaseDetailsBo;
import com.zxiaofan.MedicalAssistanService.model.bo.FeatureMapBo;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;
import com.zxiaofan.MedicalAssistanService.util.Logging;
import com.zxiaofan.MedicalAssistanService.util.StringUtils;

/**
 * 
 * @author yunhai
 */
@Component("rebuildDataBaseBusiness")
public class RebuildDataBaseBusiness implements IRebuildDataBaseBusiness {
    /**
     * 数据服务.
     */
    @Resource(name = "drmedDao")
    private IDrmedDao drmedDao;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void buildFeatureMatch() {
        Map<String, String> nameChar = StringUtils.initNameCharMap(Constant.path_desc_field, 1, 2, true);
        List<SymptomDetailsBo> listSymp = drmedDao.querySymptoms();
        Map<String, String> map = getEveryAttribute(listSymp);
        Map<String, String> featureMap = new HashMap<>();
        String[] arr;
        for (String key : map.keySet()) {
            String prefix = nameChar.get(key) + "_";
            HashSet<String> set = new HashSet<>();
            arr = map.get(key).split("\\|");
            int i = 10;
            for (String str : arr) {
                if (!"".equals(str) && set.add(str)) {
                    featureMap.put(str, prefix + (i++));
                }
            }
        }
        File file = new File(Constant.path_Symptom_Key);
        try {
            FileUtils.writeStringToFile(file, new Gson().toJson(featureMap), Constant.ENCODE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<FeatureMapBo> list = new ArrayList<>();
        for (Entry<String, String> entry : featureMap.entrySet()) {
            FeatureMapBo bo = new FeatureMapBo();
            bo.setFeatureName(entry.getKey());
            bo.setFeatureId(entry.getValue());
            list.add(bo);
        }
        drmedDao.insertFeatureMap(list);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void buildNewDiseaseDiteals() {
        List<DiseaseDetailsBo> list = drmedDao.queryAllDiseaseFeature();
        String json = new Gson().toJson(list);
        // System.out.println(json);
        try {
            initFeatureKeyMap();
            json = json.replaceAll("\\(", "@@").replaceAll("\\)", "@k@");
            String newKey;
            for (String key : ConstantApi.featureKeyMap.keySet()) {
                newKey = key;
                newKey = key.replaceAll("\\(", "@@").replaceAll("\\)", "@k@");
                json = json.replaceAll("\\|" + newKey + "\\|", "|" + ConstantApi.featureKeyMap.get(key) + "|");
            }
            json = json.replaceAll("@@", "(").replaceAll("@k@", ")");
            // 写入本地
            File file = new File(Constant.path_Disease_Feature_Key);
            FileUtils.writeStringToFile(file, json, Constant.ENCODE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list = new Gson().fromJson(json, new TypeToken<List<DiseaseDetailsBo>>() {
        }.getType());
        // 入库
        for (DiseaseDetailsBo bo : list) {
            bo.setTableName("disease_details_match");
            drmedDao.updateDiseaseByKeyId(bo);
        }
    }

    /**
     * 利用反射get并拼接相同属性的字段.
     * 
     * @param List<Object>
     *            list
     * @throws Exception
     */
    private Map<String, String> getEveryAttribute(List<? extends Object> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object bo = list.get(0); // 默认list中所有Object类型相同
        Map<String, String> map = new HashMap<String, String>();
        try {
            Class<? extends Object> clazz = bo.getClass();
            Field[] fields = bo.getClass().getDeclaredFields(); // 获得属性
            for (Field field : fields) {
                StringBuffer value = new StringBuffer();
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod(); // 获得get方法
                for (Object object : list) {
                    Object o = getMethod.invoke(object); // 执行get方法返回一个Object
                    if (o instanceof java.lang.String) { // 此处只需返回值为String的字段
                        value.append((String) getMethod.invoke(object));// 因原数据已有分隔符|，故无需增加
                    }
                }
                if (!value.toString().isEmpty()) {
                    map.put(getMethod.getName().substring(3), value.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 初始化Map(症状-key).
     * 
     */
    private static void initFeatureKeyMap() {
        if (!ConstantApi.featureKeyMap.isEmpty()) {
            return;
        }
        File file = new File(Constant.path_Symptom_Key);
        String featureKey = null;
        try {
            featureKey = FileUtils.readFileToString(file, Constant.ENCODE);
            ConstantApi.featureKeyMap = new Gson().fromJson(featureKey, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            Logging.log.error(e.getMessage());
        }
    }
}
