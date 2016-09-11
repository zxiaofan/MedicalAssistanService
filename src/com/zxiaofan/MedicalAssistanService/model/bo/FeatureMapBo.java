/*
 * 文件名：FeatureMapBo.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： FeatureMapBo.java
 * 修改人：yunhai
 * 修改时间：2016年4月28日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.model.bo;

/**
 * 
 * @author yunhai
 */
public class FeatureMapBo {
    /**
     * 特证名.
     */
    private String featureName;

    /**
     * 特征值.
     */
    private String featureId;

    /**
     * 设置featureName.
     * 
     * @return 返回featureName
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * 获取featureName.
     * 
     * @param featureName
     *            要设置的featureName
     */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    /**
     * 设置featureId.
     * 
     * @return 返回featureId
     */
    public String getFeatureId() {
        return featureId;
    }

    /**
     * 获取featureId.
     * 
     * @param featureId
     *            要设置的featureId
     */
    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

}
