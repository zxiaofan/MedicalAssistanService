/*
 * 文件名：DiseaseDetailsBo.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DiseaseDetailsBo.java
 * 修改人：yunhai
 * 修改时间：2016年4月22日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.model.bo;

import java.util.Date;

/**
 * 
 * 疾病详细
 * 
 * @author yunhai
 */
public class DiseaseDetailsBo {
    /**
     * @表名.
     */
    private String tableName;

    /**
     * @疾病id
     */
    private String keyId;

    /**
     * @疾病名
     */
    private String diseaseName;

    /**
     * @疼痛的感觉
     */
    private String painPerception;

    /**
     * @疼痛的部位
     */
    private String painRegion;

    /**
     * @疼痛的持续时间
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
     * @概述
     */
    private String summary;

    /**
     * @症状
     */
    private String symptomDetails;

    /**
     * @病因
     */
    private String causeOfDisease;

    /**
     * @风险因素
     */
    private String riskFactor;

    /**
     * @诊断
     */
    private String diagnosis;

    /**
     * @并发症
     */
    private String complications;

    /**
     * @治疗
     */
    private String treatment;

    /**
     * @预防
     */
    private String prevention;

    /**
     * @自我护理
     */
    private String selfCare;

    /**
     * @非常规疗法
     */
    private String unCommonTreat;

    /**
     * @何时求医
     */
    private String seeDoctorTime;

    /**
     * @症状和并发症
     */
    private String symptomAndComplications;

    /**
     * @治疗和预防
     */
    private String treatmentAndPrevention;

    /**
     * @筛查和诊断
     */
    private String screenAndDiagnosis;

    /**
     * @补充疗法
     */
    private String replacementTherapy;

    /**
     * @诊断和治疗
     */
    private String diagnosisAndTreatment;

    /**
     * @糖尿病类型
     */
    private String diabetesTypes;

    /**
     * @糖尿病诊断
     */
    private String diabetesDiagnosis;

    /**
     * @前驱糖尿病
     */
    private String diabetesPrediabetes;

    /**
     * @Ⅰ型糖尿病
     */
    private String diabetesTypeI;

    /**
     * @Ⅱ型糖尿病
     */
    private String diabetesTypeII;

    /**
     * @妊娠糖尿病
     */
    private String gDM;

    /**
     * @糖尿病足部护理
     */
    private String diabetesFootCare;

    /**
     * @营养和饮食建议
     */
    private String nutritionAdvice;

    /**
     * @辅助疗法
     */
    private String adjuvantTherapy;

    /**
     * @疾病Url
     */
    private String urlDisease;

    /**
     * @匹配热度
     */
    private Integer matchingTimes;

    /**
     * @修改时间
     */
    private Date modifyTime;

    /**
     * @ 构造函数
     */
    public DiseaseDetailsBo() {
    }

    /**
     * @return 疾病id
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * @param keyId
     *            疾病id.
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    /**
     * @return 疾病名
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * @param diseaseName
     *            疾病名.
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
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
     * @return 疼痛的部位
     */
    public String getPainRegion() {
        return painRegion;
    }

    /**
     * @param painRegion
     *            疼痛的部位.
     */
    public void setPainRegion(String painRegion) {
        this.painRegion = painRegion;
    }

    /**
     * @return 疼痛的持续时间
     */
    public String getPainDuration() {
        return painDuration;
    }

    /**
     * @param painDuration
     *            疼痛的持续时间.
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
     * @return 吞咽时
     */
    public String getSwallowFelling() {
        return swallowFelling;
    }

    /**
     * @param swallowFelling
     *            吞咽时.
     */
    public void setSwallowFelling(String swallowFelling) {
        this.swallowFelling = swallowFelling;
    }

    /**
     * @return 概述
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary
     *            概述.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return 症状
     */
    public String getSymptomDetails() {
        return symptomDetails;
    }

    /**
     * @param symptomDetails
     *            症状.
     */
    public void setSymptomDetails(String symptomDetails) {
        this.symptomDetails = symptomDetails;
    }

    /**
     * @return 病因
     */
    public String getCauseOfDisease() {
        return causeOfDisease;
    }

    /**
     * @param causeOfDisease
     *            病因.
     */
    public void setCauseOfDisease(String causeOfDisease) {
        this.causeOfDisease = causeOfDisease;
    }

    /**
     * @return 风险因素
     */
    public String getRiskFactor() {
        return riskFactor;
    }

    /**
     * @param riskFactor
     *            风险因素.
     */
    public void setRiskFactor(String riskFactor) {
        this.riskFactor = riskFactor;
    }

    /**
     * @return 诊断
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * @param diagnosis
     *            诊断.
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * @return 并发症
     */
    public String getComplications() {
        return complications;
    }

    /**
     * @param complications
     *            并发症.
     */
    public void setComplications(String complications) {
        this.complications = complications;
    }

    /**
     * @return 治疗
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     * @param treatment
     *            治疗.
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    /**
     * @return 预防
     */
    public String getPrevention() {
        return prevention;
    }

    /**
     * @param prevention
     *            预防.
     */
    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    /**
     * @return 自我护理
     */
    public String getSelfCare() {
        return selfCare;
    }

    /**
     * @param selfCare
     *            自我护理.
     */
    public void setSelfCare(String selfCare) {
        this.selfCare = selfCare;
    }

    /**
     * @return 非常规疗法
     */
    public String getUnCommonTreat() {
        return unCommonTreat;
    }

    /**
     * @param unCommonTreat
     *            非常规疗法.
     */
    public void setUnCommonTreat(String unCommonTreat) {
        this.unCommonTreat = unCommonTreat;
    }

    /**
     * @return 何时求医
     */
    public String getSeeDoctorTime() {
        return seeDoctorTime;
    }

    /**
     * @param seeDoctorTime
     *            何时求医.
     */
    public void setSeeDoctorTime(String seeDoctorTime) {
        this.seeDoctorTime = seeDoctorTime;
    }

    /**
     * @return 症状和并发症
     */
    public String getSymptomAndComplications() {
        return symptomAndComplications;
    }

    /**
     * @param symptomAndComplications
     *            症状和并发症.
     */
    public void setSymptomAndComplications(String symptomAndComplications) {
        this.symptomAndComplications = symptomAndComplications;
    }

    /**
     * @return 治疗和预防
     */
    public String getTreatmentAndPrevention() {
        return treatmentAndPrevention;
    }

    /**
     * @param treatmentAndPrevention
     *            治疗和预防.
     */
    public void setTreatmentAndPrevention(String treatmentAndPrevention) {
        this.treatmentAndPrevention = treatmentAndPrevention;
    }

    /**
     * @return 筛查和诊断
     */
    public String getScreenAndDiagnosis() {
        return screenAndDiagnosis;
    }

    /**
     * @param screenAndDiagnosis
     *            筛查和诊断.
     */
    public void setScreenAndDiagnosis(String screenAndDiagnosis) {
        this.screenAndDiagnosis = screenAndDiagnosis;
    }

    /**
     * @return 补充疗法
     */
    public String getReplacementTherapy() {
        return replacementTherapy;
    }

    /**
     * @param replacementTherapy
     *            补充疗法.
     */
    public void setReplacementTherapy(String replacementTherapy) {
        this.replacementTherapy = replacementTherapy;
    }

    /**
     * @return 诊断和治疗
     */
    public String getDiagnosisAndTreatment() {
        return diagnosisAndTreatment;
    }

    /**
     * @param diagnosisAndTreatment
     *            诊断和治疗.
     */
    public void setDiagnosisAndTreatment(String diagnosisAndTreatment) {
        this.diagnosisAndTreatment = diagnosisAndTreatment;
    }

    /**
     * @return 糖尿病类型
     */
    public String getDiabetesTypes() {
        return diabetesTypes;
    }

    /**
     * @param diabetesTypes
     *            糖尿病类型.
     */
    public void setDiabetesTypes(String diabetesTypes) {
        this.diabetesTypes = diabetesTypes;
    }

    /**
     * @return 糖尿病诊断
     */
    public String getDiabetesDiagnosis() {
        return diabetesDiagnosis;
    }

    /**
     * @param diabetesDiagnosis
     *            糖尿病诊断.
     */
    public void setDiabetesDiagnosis(String diabetesDiagnosis) {
        this.diabetesDiagnosis = diabetesDiagnosis;
    }

    /**
     * @return 前驱糖尿病
     */
    public String getDiabetesPrediabetes() {
        return diabetesPrediabetes;
    }

    /**
     * @param diabetesPrediabetes
     *            前驱糖尿病.
     */
    public void setDiabetesPrediabetes(String diabetesPrediabetes) {
        this.diabetesPrediabetes = diabetesPrediabetes;
    }

    /**
     * @return Ⅰ型糖尿病
     */
    public String getDiabetesTypeI() {
        return diabetesTypeI;
    }

    /**
     * @param diabetesTypeI
     *            Ⅰ型糖尿病.
     */
    public void setDiabetesTypeI(String diabetesTypeI) {
        this.diabetesTypeI = diabetesTypeI;
    }

    /**
     * @return Ⅱ型糖尿病
     */
    public String getDiabetesTypeII() {
        return diabetesTypeII;
    }

    /**
     * @param diabetesTypeII
     *            Ⅱ型糖尿病.
     */
    public void setDiabetesTypeII(String diabetesTypeII) {
        this.diabetesTypeII = diabetesTypeII;
    }

    /**
     * @return 妊娠糖尿病
     */
    public String getGDM() {
        return gDM;
    }

    /**
     * @param gDMt
     *            妊娠糖尿病.
     */
    public void setGDM(String gDMt) {
        this.gDM = gDMt;
    }

    /**
     * @return 糖尿病足部护理
     */
    public String getDiabetesFootCare() {
        return diabetesFootCare;
    }

    /**
     * @param diabetesFootCare
     *            糖尿病足部护理.
     */
    public void setDiabetesFootCare(String diabetesFootCare) {
        this.diabetesFootCare = diabetesFootCare;
    }

    /**
     * @return 营养和饮食建议
     */
    public String getNutritionAdvice() {
        return nutritionAdvice;
    }

    /**
     * @param nutritionAdvice
     *            营养和饮食建议.
     */
    public void setNutritionAdvice(String nutritionAdvice) {
        this.nutritionAdvice = nutritionAdvice;
    }

    /**
     * @return 辅助疗法
     */
    public String getAdjuvantTherapy() {
        return adjuvantTherapy;
    }

    /**
     * @param adjuvantTherapy
     *            辅助疗法.
     */
    public void setAdjuvantTherapy(String adjuvantTherapy) {
        this.adjuvantTherapy = adjuvantTherapy;
    }

    /**
     * @return 疾病Url
     */
    public String getUrlDisease() {
        return urlDisease;
    }

    /**
     * @param urlDisease
     *            疾病Url.
     */
    public void setUrlDisease(String urlDisease) {
        this.urlDisease = urlDisease;
    }

    /**
     * @return 匹配热度
     */
    public Integer getMatchingTimes() {
        return matchingTimes;
    }

    /**
     * @param matchingTimes
     *            匹配热度.
     */
    public void setMatchingTimes(Integer matchingTimes) {
        this.matchingTimes = matchingTimes;
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
}
