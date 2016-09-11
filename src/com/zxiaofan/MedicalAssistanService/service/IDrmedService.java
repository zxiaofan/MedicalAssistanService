/*
 * 文件名：IDrmedService.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IDrmedService.java
 * 修改人：yunhai
 * 修改时间：2016年4月18日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service;

import java.util.Map;

import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;

/**
 * 
 * @author yunhai
 */
public interface IDrmedService {
    /**
     * 根据病症描述抓取指定数据.
     * 
     * @param desc
     *            病症描述
     * @return 病症详细
     * @throws Exception
     */
    public Map<String, SymptomDetailsBo> crawDrmedData(String desc);

    /**
     * 抓取所有病症数据.
     * 
     * @return
     * @throws Exception
     */
    public Map<String, SymptomDetailsBo> crawDrmedDataAll();

    /**
     * 写入所有症状信息.
     * 
     * @return 结果
     * @throws Exception
     */
    public boolean insertAllSymptomDetails(Map<String, SymptomDetailsBo> map);

    /**
     * 写入单条症状信息.
     * 
     * @param bo
     * @return
     */
    public boolean insertOne(SymptomDetailsBo bo);

    /**
     * 抓取所有post参数（症状名，url|postParam）.
     * 
     */
    public void crawPostParam();

}
