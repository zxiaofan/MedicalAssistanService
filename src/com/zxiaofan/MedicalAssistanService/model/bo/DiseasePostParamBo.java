/*
 * 文件名：PostParamBo.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： PostParamBo.java
 * 修改人：xiaofan
 * 修改时间：2016年4月23日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.model.bo;

/**
 * 疾病post参数
 * 
 * @author xiaofan
 */
public class DiseasePostParamBo {
    /**
     * 症状名.
     */
    private String symptomName;

    /**
     * 症状url（post url）.
     */
    private String url;

    /**
     * 可用于post的参数（用|分隔）.
     */
    private String param;

    /**
     * 就诊建议.
     */
    private String treatmentAdvice;

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getTreatmentAdvice() {
        return treatmentAdvice;
    }

    public void setTreatmentAdvice(String treatmentAdvice) {
        this.treatmentAdvice = treatmentAdvice;
    }
}
