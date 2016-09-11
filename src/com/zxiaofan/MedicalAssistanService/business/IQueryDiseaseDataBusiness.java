/*
 * 文件名：IQueryDiseaseDataBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IQueryDiseaseDataBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年4月26日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

import java.util.List;

import com.zxiaofan.MedicalAssistanService.model.bo.DoctorsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.HospitalsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.MatchedDiseaseBo;
import com.zxiaofan.MedicalAssistanService.model.vo.DetailsFeaturesVo;

/**
 * @author yunhai
 */
public interface IQueryDiseaseDataBusiness {

    /**
     * 查询匹配的disease.
     * 
     * @param listParam
     */
    public List<DetailsFeaturesVo> queryMatchedDisease(List<String> listParam);

    /**
     * 查询匹配数据的KeyId等关键信息.
     * 
     * @param list
     */
    public List<MatchedDiseaseBo> queryMatchedDiseaseKeyId(List<String> list);

    /**
     * 查询匹配的医生信息By DiseaseName.
     * 
     * @param diseasePinyin
     * @return
     */
    public List<DoctorsInfoBo> queryDoctorsByDisease(String diseasePinyin);

    /**
     * 查询匹配的【医院信息】By DiseaseName
     * 
     * @param diseasePinyin
     * @return
     */
    public List<HospitalsInfoBo> queryHospitalsByDisease(String diseasePinyin);

}
