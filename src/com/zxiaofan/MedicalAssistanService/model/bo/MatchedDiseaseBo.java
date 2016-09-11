/*
 * 文件名：MatchedDiseaseBo.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MatchedDiseaseBo.java
 * 修改人：yunhai
 * 修改时间：2016年4月30日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.model.bo;

/**
 * 匹配的Disease信息
 * 
 * @author yunhai
 */
public class MatchedDiseaseBo {
    private String keyId;

    private String diseaseName;

    private int rank = 0;

    /**
     * 设置keyId.
     * 
     * @return 返回keyId
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * 获取keyId.
     * 
     * @param keyId
     *            要设置的keyId
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    /**
     * 设置diseaseName.
     * 
     * @return 返回diseaseName
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * 获取diseaseName.
     * 
     * @param diseaseName
     *            要设置的diseaseName
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    /**
     * 设置rank.
     * 
     * @return 返回rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * 获取rank.
     * 
     * @param rank
     *            要设置的rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

}
