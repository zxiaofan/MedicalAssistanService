/*
 * 文件名：QueryMatchServiceImpl.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： QueryMatchServiceImpl.java
 * 修改人：yunhai
 * 修改时间：2016年4月30日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.zxiaofan.MedicalAssistanService.Enum.EnumAPI;
import com.zxiaofan.MedicalAssistanService.business.IQueryDiseaseDataBusiness;
import com.zxiaofan.MedicalAssistanService.constant.ConstantApi;
import com.zxiaofan.MedicalAssistanService.dao.IAPIDao;
import com.zxiaofan.MedicalAssistanService.model.bo.DoctorsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.HospitalsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.MatchedDiseaseBo;
import com.zxiaofan.MedicalAssistanService.model.bo.UserInfoBo;
import com.zxiaofan.MedicalAssistanService.model.vo.DetailsFeaturesVo;
import com.zxiaofan.MedicalAssistanService.service.IAPIService;
import com.zxiaofan.MedicalAssistanService.util.ChineseToEnglish;
import com.zxiaofan.MedicalAssistanService.util.CommonCheckUtils;
import com.zxiaofan.MedicalAssistanService.util.Logging;
import com.zxiaofan.MedicalAssistanService.util.StringUtils;

/**
 * @author yunhai
 */
@Component("apiService")
@WebService(endpointInterface = "com.zxiaofan.MedicalAssistanService.service.IAPIService")
public class APIService implements IAPIService {
    /**
     * 查询业务层.
     */
    @Resource(name = "queryDiseaseDataBusiness")
    private IQueryDiseaseDataBusiness queryDiseaseDataBusiness;

    /**
     * API数据层.
     */
    @Resource(name = "apiDao")
    private IAPIDao apiDao;

    @Resource(name = "logging")
    private Logging logging;

    private static List<HospitalsInfoBo> hosEmpty = new ArrayList<>();

    private static List<DoctorsInfoBo> docEmpty = new ArrayList<>();

    static {
        HospitalsInfoBo bo_e = new HospitalsInfoBo();
        bo_e.setHospitalName("当你看到此消息时表明：①您输入的疾病名不正确或不具备代表性；②本系统暂未收录该疾病");
        bo_e.setAddress("请选择就近医院，确诊病情");
        bo_e.setTelePhone("您可拨打120或当地就医电话");
        hosEmpty.add(bo_e);
        DoctorsInfoBo bo_d = new DoctorsInfoBo();
        bo_d.setDocName("当你看到此消息时表明：①您输入的疾病名不正确或不具备代表性；②本系统暂未收录该疾病");
        bo_d.setDocHospital("请选择就近医院，确诊病情;或拨打120或当地就医电话");
        docEmpty.add(bo_d);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String queryDiseaseBySymptom(String param) {
        Gson gson = new Gson();
        List<String> list = null;
        try {
            list = gson.fromJson(param, List.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            logging.log.error("Gson转换异常:" + param);
            return null;
        }
        HashSet<String> set = new HashSet<>(list); // 利用hashSet去重
        list.clear();
        list.addAll(set);
        StringUtils.initFeatureKeyMap();
        List<String> listKey = new ArrayList<>(list.size()); // 不能list.size()
        for (int i = 0; i < list.size(); i++) {
            if (ConstantApi.featureKeyMap.get(list.get(i)) != null) {
                listKey.add(ConstantApi.featureKeyMap.get(list.get(i)));
            }
        }
        if (listKey == null || listKey.isEmpty()) {
            logging.log.error("症状转key异常:" + list);
            return null;
        }
        List<DetailsFeaturesVo> detailsFeaturesVos = queryDiseaseDataBusiness.queryMatchedDisease(listKey);
        if (CommonCheckUtils.isEmpty(detailsFeaturesVos)) {
            return null;
        }
        String result = gson.toJson(detailsFeaturesVos);
        logging.log.warn("查询disease成功By症状(queryDiseaseBySymptom):" + list);
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String queryDiseaseKeyIdBySymptom(String param) {
        Gson gson = new Gson();
        List<String> list = null;
        try {
            list = gson.fromJson(param, List.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            logging.log.error("Gson转换异常:" + param);
            return null;
        }
        HashSet<String> set = new HashSet<>(list); // 利用hashSet去重
        list.clear();
        list.addAll(set);
        List<MatchedDiseaseBo> listKeyId = queryDiseaseDataBusiness.queryMatchedDiseaseKeyId(list);
        if (CommonCheckUtils.isEmpty(listKeyId)) {
            return null;
        }
        String result = gson.toJson(listKeyId);
        logging.log.warn("查询diseaseKeyId成功By症状(queryDiseaseKeyIdBySymptom):" + list);
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String queryDoctorsByDisease(String diseaseName) {
        Gson gson = new Gson();
        // 防注入
        String DiseasePinyin = ChineseToEnglish.getPingYinOk(diseaseName);
        List<DoctorsInfoBo> listDoc = queryDiseaseDataBusiness.queryDoctorsByDisease(DiseasePinyin);
        if (CommonCheckUtils.isEmpty(listDoc)) {
            return gson.toJson(docEmpty);
        }
        String result = gson.toJson(listDoc);
        logging.log.warn("查询医生信息成功By疾病名(queryDoctorsByDisease):" + diseaseName);
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String queryHospitalsByDisease(String diseaseName) {
        Gson gson = new Gson();
        // 防注入
        String DiseasePinyin = ChineseToEnglish.getPingYinOk(diseaseName);
        List<HospitalsInfoBo> listHos = queryDiseaseDataBusiness.queryHospitalsByDisease(DiseasePinyin);
        String result = null;
        if (CommonCheckUtils.isEmpty(listHos)) {
            return gson.toJson(hosEmpty);
        }
        result = gson.toJson(listHos);
        logging.log.warn("查询医院信息成功By疾病名(queryHospitalsByDisease):" + diseaseName);
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String register(String userInfo) {
        UserInfoBo bo = null;
        Gson gson = new Gson();
        try {
            bo = gson.fromJson(userInfo, UserInfoBo.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            logging.log.error("Gson转换异常:" + userInfo);
            return EnumAPI.fail_error.getDesc();
        }
        if (!StringUtils.isLegal(bo.getUserName(), bo.getPassWord())) {
            logging.log.warn("用户名或密码非法:" + bo.getUserName());
            return EnumAPI.fail_illegal.getDesc();
        }
        // 密码transient处理，不会记录日志
        logging.log.warn("用户注册:" + gson.toJson(bo));
        return apiDao.register(bo);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean login(String name, String pwd) {
        if (!StringUtils.isLegal(name, pwd)) {
            logging.log.warn("用户名或密码非法:" + name + "," + pwd);
            return false;
        }
        UserInfoBo bo = new UserInfoBo();
        bo.setUserName(name);
        bo.setPassWord(pwd);
        boolean result = apiDao.login(bo);
        logging.log.warn("用户 " + name + " 登录:" + (result ? "成功" : "失败"));
        return result;
    }

}
