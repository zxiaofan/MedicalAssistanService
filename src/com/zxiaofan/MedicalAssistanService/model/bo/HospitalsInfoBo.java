/*
 * 文件名：HospitalsInfoBo.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HospitalsInfoBo.java
 * 修改人：yunhai
 * 修改时间：2016年5月7日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.model.bo;

import java.util.Date;

/**
 * 
 * @author yunhai
 */
public class HospitalsInfoBo {

    /**
     * @医院名
     */
    private String hospitalName;

    /**
     * @医院省份
     */
    private String hospitalProvince;

    /**
     * @医院城市
     */
    private String hospitalCity;

    /**
     * @医院级别
     */
    private String hospitalLevel;

    /**
     * @医院地址
     */
    private String address;

    /**
     * @联系电话
     */
    private String telePhone;

    /**
     * @感谢信数量
     */
    private Integer thanksLetterNum;

    /**
     * @诊断疾病
     */
    private String diseaseName;

    /**
     * @诊断疾病拼音
     */
    private String diseaseNamePinYin;

    /**
     * @医院网址(haodf)
     */
    private String url;

    /**
     * @修改时间
     */
    private Date modifyTime;

    /**
     * @ 构造函数
     */
    public HospitalsInfoBo() {
    }

    /**
     * @return 医院名
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName
     *            医院名.
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return 医院省份
     */
    public String getHospitalProvince() {
        return hospitalProvince;
    }

    /**
     * @param hospitalProvince
     *            医院省份.
     */
    public void setHospitalProvince(String hospitalProvince) {
        this.hospitalProvince = hospitalProvince;
    }

    /**
     * @return 医院城市
     */
    public String getHospitalCity() {
        return hospitalCity;
    }

    /**
     * @param hospitalCity
     *            医院城市.
     */
    public void setHospitalCity(String hospitalCity) {
        this.hospitalCity = hospitalCity;
    }

    /**
     * @return 医院级别
     */
    public String getHospitalLevel() {
        return hospitalLevel;
    }

    /**
     * @param hospitalLevel
     *            医院级别.
     */
    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    /**
     * @return 医院地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            医院地址.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 联系电话
     */
    public String getTelePhone() {
        return telePhone;
    }

    /**
     * @param telePhone
     *            联系电话.
     */
    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    /**
     * @return 感谢信数量
     */
    public Integer getThanksLetterNum() {
        return thanksLetterNum;
    }

    /**
     * @param thanksLetterNum
     *            感谢信数量.
     */
    public void setThanksLetterNum(Integer thanksLetterNum) {
        this.thanksLetterNum = thanksLetterNum;
    }

    /**
     * @return 诊断疾病
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * @param diseaseName
     *            诊断疾病.
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    /**
     * @return 诊断疾病拼音
     */
    public String getDiseaseNamePinYin() {
        return diseaseNamePinYin;
    }

    /**
     * @param diseaseNamePinYin
     *            诊断疾病拼音.
     */
    public void setDiseaseNamePinYin(String diseaseNamePinYin) {
        this.diseaseNamePinYin = diseaseNamePinYin;
    }

    /**
     * @return 医院网址(haodf)
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            医院网址(haodf).
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     *            修改时间.
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
