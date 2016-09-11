package com.zxiaofan.MedicalAssistanService.model.bo;

import java.util.Date;

/**
 * @author yunhai(Default)
 *
 */

public class DoctorsInfoBo {
    /**
     * @医生id
     */
    private String keyId;

    /**
     * @医生名字
     */
    private String docName;

    /**
     * @诊断疾病
     */
    private String diseaseName;

    /**
     * @诊断疾病拼音
     */
    private String diseaseNamePinYin;

    /**
     * @医生职称
     */
    private String docTitle;

    /**
     * @所属医院
     */
    private String docHospital;

    /**
     * @所属科室
     */
    private String docDepart;

    /**
     * @患者推荐热度
     */
    private double recommendHeat;

    /**
     * @医生擅长
     */
    private String docAdept;

    /**
     * @执业经历
     */
    private String practiceExperience;

    /**
     * @感谢信数量
     */
    private Integer thanksLetterNum;

    /**
     * @医生详细Url
     */
    private String urlDoc;

    /**
     * @修改时间
     */
    private Date modifyTime;

    /**
     * @ 构造函数
     */
    public DoctorsInfoBo() {
    }

    /**
     * @return 医生id
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * @param keyId
     *            医生id.
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    /**
     * @return 医生名字
     */
    public String getDocName() {
        return docName;
    }

    /**
     * @param docName
     *            医生名字.
     */
    public void setDocName(String docName) {
        this.docName = docName;
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
     * @param diseaseName
     *            诊断疾病拼音.
     */
    public void setDiseaseNamePinYin(String diseaseNamePinYin) {
        this.diseaseNamePinYin = diseaseNamePinYin;
    }

    /**
     * @return 医生职称
     */
    public String getDocTitle() {
        return docTitle;
    }

    /**
     * @param docTitle
     *            医生职称.
     */
    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    /**
     * @return 所属医院
     */
    public String getDocHospital() {
        return docHospital;
    }

    /**
     * @param docHospital
     *            所属医院.
     */
    public void setDocHospital(String docHospital) {
        this.docHospital = docHospital;
    }

    /**
     * @return 所属科室
     */
    public String getDocDepart() {
        return docDepart;
    }

    /**
     * @param docDepart
     *            所属科室.
     */
    public void setDocDepart(String docDepart) {
        this.docDepart = docDepart;
    }

    /**
     * @return 患者推荐热度
     */
    public double getRecommendHeat() {
        return recommendHeat;
    }

    /**
     * @param recommendHeat
     *            患者推荐热度.
     */
    public void setRecommendHeat(double recommendHeat) {
        this.recommendHeat = recommendHeat;
    }

    /**
     * @return 医生擅长
     */
    public String getDocAdept() {
        return docAdept;
    }

    /**
     * @param docAdept
     *            医生擅长.
     */
    public void setDocAdept(String docAdept) {
        this.docAdept = docAdept;
    }

    /**
     * @return 执业经历
     */
    public String getPracticeExperience() {
        return practiceExperience;
    }

    /**
     * @param practiceExperience
     *            执业经历.
     */
    public void setPracticeExperience(String practiceExperience) {
        this.practiceExperience = practiceExperience;
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
     * @return 医生详细Url
     */
    public String getUrlDoc() {
        return urlDoc;
    }

    /**
     * @param urlDoc
     *            医生详细Url.
     */
    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
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
