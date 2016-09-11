/*
 * 文件名：ICrawlDataBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ICrawlDataBusiness.java
 * 修改人：xiaofan
 * 修改时间：2016年4月21日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

import java.util.Map;

import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;

/**
 * @author xiaofan
 */
public interface ICrawlDataBusiness {
    /**
     * 根据病症描述抓取指定数据.
     * 
     * @param desc
     *            病症描述
     *
     * @param personType
     *            1:成人；0：儿童；2：成人+儿童
     * @return 病症详细
     * @throws Exception
     */
    public Map<String, SymptomDetailsBo> crawDrmedData(String desc, int personType) throws Exception;

    /**
     * 抓取所有病症数据.
     * 
     * @param personType
     *            1:成人；0：儿童；2：成人+儿童
     * @return
     * @throws Exception
     */
    public Map<String, SymptomDetailsBo> crawDrmedDataAll(int personType) throws Exception;

    /**
     * 根据疾病名抓取对应详细数据.
     * 
     * @param desc
     *            病症描述
     * 
     * @return 病症详细
     * @throws Exception
     */
    public void crawDiseaseDetails(String desc) throws Exception;

    /**
     * 抓取疾病post参数（症状名，url|postparam）.
     * 
     * @return
     * @throws Exception
     */
    public void crawPostParam() throws Exception;

    /**
     * 抓取疾病详细数据.
     * 
     * @return
     * @throws Exception
     */
    public void crawDiseaseDetails() throws Exception;
}
