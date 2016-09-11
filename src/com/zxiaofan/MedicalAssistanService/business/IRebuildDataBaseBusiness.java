/*
 * 文件名：IRebuildDataBaseBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IRebuildDataBaseBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年4月28日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

/**
 * 重构数据库，生成特征匹配表和disease全文索引表
 * 
 * @author yunhai
 */
public interface IRebuildDataBaseBusiness {
    /**
     * 构造特征匹配表.
     * 
     */
    public void buildFeatureMatch();

    /**
     * 构建新的疾病详细表（英文字符）.
     * 
     */
    public void buildNewDiseaseDiteals();

}
