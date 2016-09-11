/*
 * 文件名：DataWriteBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DataWriteBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年4月19日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zxiaofan.MedicalAssistanService.business.IDataWriteBusiness;
import com.zxiaofan.MedicalAssistanService.dao.IDrmedDao;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;
import com.zxiaofan.MedicalAssistanService.util.ChineseToEnglish;
import com.zxiaofan.MedicalAssistanService.util.CommonCheckUtils;
import com.zxiaofan.MedicalAssistanService.util.Logging;

/**
 * 
 * @author yunhai
 */
@Component("dataWriteBusiness")
public class DataWriteBusiness implements IDataWriteBusiness {
    /**
     * 数据服务.
     */
    @Resource(name = "drmedDao")
    private IDrmedDao drmedDao;

    @Resource(name = "logging")
    private Logging logging;

    /**
     * 写入所有症状信息.
     * 
     * @return 结果
     * @throws Exception
     */
    @Override
    public boolean insertAllSymptomDetails(Map<String, SymptomDetailsBo> map) {
        Collection<SymptomDetailsBo> listBos = map.values();
        List<SymptomDetailsBo> list = new ArrayList<>(listBos);
        if (CommonCheckUtils.isEmpty(listBos)) {
            return false; // 为空则不插入，后期记日志
        }
        for (SymptomDetailsBo bo : list) {
            drmedDao.insertOne(bo);
        }
        return true; // 暂无实际意义
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean insertOne(SymptomDetailsBo bo) {
        if (bo == null) {
            return false;
        }
        bo.setKeyId(ChineseToEnglish.creatKeyId(bo.getSymptomName()));
        return drmedDao.insertOne(bo);
    }

    /**
     * Reflect.
     * 
     * list中字段类型可能不同，为保证通用性，暂未将公共字段提出，为优化效率，可针对相同参数的list重构代码。
     * 
     * 针对实际开发，可封装代码使其支持list嵌套 .
     * 
     * @param listSrcBos
     * @param n
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private void modelToSQLBo(Object objectDest, Object objectSrc) throws Exception {
        final Field[] fieldSrc = objectSrc.getClass().getDeclaredFields();
        System.out.println(fieldSrc.toString());
        final Field[] fieldDest = objectDest.getClass().getDeclaredFields();// 获取实体类的所有属性，返回Field数组
        Map<String, Object> mapSrc = new HashMap<String, Object>();
        for (Field field : fieldSrc) {
            mapSrc.put(field.getName(), field.getType().toString());
        }
        String name = "";
        String type = "";
        for (Field field : fieldDest) {
            name = field.getName(); // 获取属性的名字
            type = field.getGenericType().toString(); // 获取属性的类型
            if (mapSrc.containsKey(name) && mapSrc.get(name).equals(type)) {
                field.setAccessible(true);
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), objectDest.getClass()); // get属性描述器
                String fieldName = field.getName();
                fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method mGet = objectSrc.getClass().getMethod("get" + fieldName);
                Object value = mGet.invoke(objectSrc); // 调用getter方法获取属性值
                Method wM = pd.getWriteMethod();// 获得写方法
                if (type.equals("int") || type.equals("class java.lang.Integer")) {
                    wM.invoke(objectDest, (Integer) value);
                } else if (type.equals("short")) {
                    wM.invoke(objectDest, (Short) value);
                } else if (type.equals("double")) {
                    wM.invoke(objectDest, (Double) value);
                } else if (type.equals("boolean")) {
                    wM.invoke(objectDest, (Boolean) value);
                } else if (type.equals("class java.util.Date")) {
                    wM.invoke(objectDest, (Date) value);
                } else { // String
                    wM.invoke(objectDest, (String) value);
                }
            }
        }
    }

}
