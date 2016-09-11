/*
 * 文件名：IHaodfDao.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IHaodfDao.java
 * 修改人：yunhai
 * 修改时间：2016年5月4日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao;

import java.util.List;

import com.zxiaofan.MedicalAssistanService.model.bo.DoctorsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.HospitalsInfoBo;

/**
 * 
 * @author yunhai
 */
public interface IHaodfDao {
    /**
     * 入库haodf医生信息.
     * 
     * @param bo
     * 
     */
    public boolean insertHaodfDoc(DoctorsInfoBo bo);

    /**
     * 入库haodf医院信息.
     * 
     */
    public boolean insertHaodfHos();

    /**
     * 根据diseaseNamePinYin获取DiseaseName的KeyId信息.
     * 
     * @param diseaseNamePinYin
     * @return
     */
    public List<String> getKeyIdByDiseaseNamePinYin(String diseaseNamePinYin);

    /**
     * 查询所有医生keyId及disease.
     * 
     * @return
     */
    public List<DoctorsInfoBo> queryAllKeyIdAndDiseaseName();

    /**
     * 根据KeyId更新disease信息.
     * 
     * @param bo
     * @return
     */
    public boolean updateDocDiseaseByKeyId(DoctorsInfoBo bo);

    /**
     * 插入医院数据.
     * 
     * @param bo
     */
    public boolean insertHaodfHos(HospitalsInfoBo bo);

    /**
     * 更新医院信息(主要是Disease信息).
     * 
     * @param bo
     */
    public boolean updateHaodfHos(HospitalsInfoBo bo);

    /**
     * 查询某省份的医院名.
     * 
     * @param provence
     * @return
     */
    public List<String> queryHosByProvence(String provence);

    /**
     * 根据diseaseName查询现有医院名及disease信息.
     * 
     * @param diseaseName
     * @return
     */
    public List<HospitalsInfoBo> queryExistHos();

    /**
     * queryDoctorsByDisease
     * 
     * @param diseasePinyin
     * @return
     */
    public List<DoctorsInfoBo> queryDoctorsByDisease(String diseasePinyin);

    /**
     * 查询匹配的【医院信息】By DiseaseName.
     * 
     * @param diseasePinyin
     * @return
     */
    public List<HospitalsInfoBo> queryHospitalsByDisease(String diseasePinyin);
}
