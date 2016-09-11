/*
 * 文件名：SymptomDetailsBo.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SymptomDetailsBo.java
 * 修改人：yunhai
 * 修改时间：2016年4月18日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.model.bo;

import java.util.Date;

/**
 * 
 * @author yunhai
 */
public class SymptomDetailsBo {
    /**
     * 表名.
     */
    private String tableName;

    /**
     * @症状id
     */
    private String keyId;

    /**
     * @成人
     */
    private Integer isAdult = 1;

    /**
     * @症状名
     */
    private String symptomName;

    /**
     * @疼痛的感觉
     */
    private String painPerception;

    /**
     * @疼痛部位
     */
    private String painRegion;

    /**
     * @疼痛持续时间
     */
    private String painDuration;

    /**
     * @病症在什么情况下会恶化
     */
    private String symptomWorsen;

    /**
     * @疼痛的其它特征
     */
    private String otherFeaturesOfPain;

    /**
     * @何种因素可引发此症状
     */
    private String symptomReason;

    /**
     * @何种做法可减轻症状
     */
    private String symptomRelieved;

    /**
     * @症状何时开始
     */
    private String symptomStart;

    /**
     * @伴有
     */
    private String symptomWith;

    /**
     * @你会感觉到
     */
    private String symptomFelling;

    /**
     * @血出现在
     */
    private String bloodPosition;

    /**
     * @症状的其它特征
     */
    private String otherFeatures;

    /**
     * @咳嗽表现为
     */
    private String coughing;

    /**
     * @受影响或累及部位为
     */
    private String affectedArea;

    /**
     * @病症出现在下面哪种情况之后
     */
    private String symptomAppears;

    /**
     * @吞咽时
     */
    private String swallowFelling;

    /**
     * @就诊建议
     */
    private String treatmentAdvice;

    /**
     * @修改时间
     */
    private Date modifyTime;

    /**
     * @ 构造函数
     */
    public SymptomDetailsBo() {
    }

    /**
     * @return 症状id
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * @param keyId
     *            症状id.
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    /**
     * @return 成人
     */
    public Integer getIsAdult() {
        return isAdult;
    }

    /**
     * @param isAdult
     *            成人.
     */
    public void setIsAdult(Integer isAdult) {
        this.isAdult = isAdult;
    }

    /**
     * @return 症状名
     */
    public String getSymptomName() {
        return symptomName;
    }

    /**
     * @param symptomName
     *            症状名.
     */
    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    /**
     * @return 疼痛的感觉
     */
    public String getPainPerception() {
        return painPerception;
    }

    /**
     * @param painPerception
     *            疼痛的感觉.
     */
    public void setPainPerception(String painPerception) {
        this.painPerception = painPerception;
    }

    /**
     * @return 疼痛部位
     */
    public String getPainRegion() {
        return painRegion;
    }

    /**
     * @param painRegion
     *            疼痛部位.
     */
    public void setPainRegion(String painRegion) {
        this.painRegion = painRegion;
    }

    /**
     * @return 疼痛持续时间
     */
    public String getPainDuration() {
        return painDuration;
    }

    /**
     * @param painDuration
     *            疼痛持续时间.
     */
    public void setPainDuration(String painDuration) {
        this.painDuration = painDuration;
    }

    /**
     * @return 病症在什么情况下会恶化
     */
    public String getSymptomWorsen() {
        return symptomWorsen;
    }

    /**
     * @param symptomWorsen
     *            病症在什么情况下会恶化.
     */
    public void setSymptomWorsen(String symptomWorsen) {
        this.symptomWorsen = symptomWorsen;
    }

    /**
     * @return 疼痛的其它特征
     */
    public String getOtherFeaturesOfPain() {
        return otherFeaturesOfPain;
    }

    /**
     * @param otherFeaturesOfPain
     *            疼痛的其它特征.
     */
    public void setOtherFeaturesOfPain(String otherFeaturesOfPain) {
        this.otherFeaturesOfPain = otherFeaturesOfPain;
    }

    /**
     * @return 何种因素可引发此症状
     */
    public String getSymptomReason() {
        return symptomReason;
    }

    /**
     * @param symptomReason
     *            何种因素可引发此症状.
     */
    public void setSymptomReason(String symptomReason) {
        this.symptomReason = symptomReason;
    }

    /**
     * @return 何种做法可减轻症状
     */
    public String getSymptomRelieved() {
        return symptomRelieved;
    }

    /**
     * @param symptomRelieved
     *            何种做法可减轻症状.
     */
    public void setSymptomRelieved(String symptomRelieved) {
        this.symptomRelieved = symptomRelieved;
    }

    /**
     * @return 症状何时开始
     */
    public String getSymptomStart() {
        return symptomStart;
    }

    /**
     * @param symptomStart
     *            症状何时开始.
     */
    public void setSymptomStart(String symptomStart) {
        this.symptomStart = symptomStart;
    }

    /**
     * @return 伴有
     */
    public String getSymptomWith() {
        return symptomWith;
    }

    /**
     * @param symptomWith
     *            伴有.
     */
    public void setSymptomWith(String symptomWith) {
        this.symptomWith = symptomWith;
    }

    /**
     * @return 你会感觉到
     */
    public String getSymptomFelling() {
        return symptomFelling;
    }

    /**
     * @param symptomFelling
     *            你会感觉到.
     */
    public void setSymptomFelling(String symptomFelling) {
        this.symptomFelling = symptomFelling;
    }

    /**
     * @return 血出现在
     */
    public String getBloodPosition() {
        return bloodPosition;
    }

    /**
     * @param bloodPosition
     *            血出现在.
     */
    public void setBloodPosition(String bloodPosition) {
        this.bloodPosition = bloodPosition;
    }

    /**
     * @return 症状的其它特征
     */
    public String getOtherFeatures() {
        return otherFeatures;
    }

    /**
     * @param otherFeatures
     *            症状的其它特征.
     */
    public void setOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
    }

    /**
     * @return 咳嗽表现为
     */
    public String getCoughing() {
        return coughing;
    }

    /**
     * @param coughing
     *            咳嗽表现为.
     */
    public void setCoughing(String coughing) {
        this.coughing = coughing;
    }

    /**
     * @return 受影响或累及部位为
     */
    public String getAffectedArea() {
        return affectedArea;
    }

    /**
     * @param affectedArea
     *            受影响或累及部位为.
     */
    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }

    /**
     * @return 病症出现在下面哪种情况之后
     */
    public String getSymptomAppears() {
        return symptomAppears;
    }

    /**
     * @param symptomAppears
     *            病症出现在下面哪种情况之后.
     */
    public void setSymptomAppears(String symptomAppears) {
        this.symptomAppears = symptomAppears;
    }

    /**
     * @return 就诊建议
     */
    public String getTreatmentAdvice() {
        return treatmentAdvice;
    }

    /**
     * @param treatmentAdvice
     *            就诊建议.
     */
    public void setTreatmentAdvice(String treatmentAdvice) {
        this.treatmentAdvice = treatmentAdvice;
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

    /**
     * 设置tableName.
     * 
     * @return 返回tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 获取tableName.
     * 
     * @param tableName
     *            要设置的tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSwallowFelling() {
        return swallowFelling;
    }

    public void setSwallowFelling(String swallowFelling) {
        this.swallowFelling = swallowFelling;
    }
}
