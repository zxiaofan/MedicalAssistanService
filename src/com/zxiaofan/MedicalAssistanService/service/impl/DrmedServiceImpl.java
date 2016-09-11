/*
 * 文件名：DrmedServiceImpl.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DrmedServiceImpl.java
 * 修改人：yunhai
 * 修改时间：2016年4月22日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zxiaofan.MedicalAssistanService.business.ICrawlDataBusiness;
import com.zxiaofan.MedicalAssistanService.business.IDataWriteBusiness;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;
import com.zxiaofan.MedicalAssistanService.service.IDrmedService;

/**
 * 
 * @author yunhai
 */
@Component("drmedService")
public class DrmedServiceImpl implements IDrmedService {
    /**
     * 抓取业务层.
     */
    @Resource(name = "crawlDataBusiness")
    private ICrawlDataBusiness crawlDataBusiness;

    /**
     * 入库业务层.
     */
    @Resource(name = "dataWriteBusiness")
    private IDataWriteBusiness dataWriteBusiness;

    /**
     * {@inheritDoc}.
     */
    @Override
    public Map<String, SymptomDetailsBo> crawDrmedData(String desc) {
        Map<String, SymptomDetailsBo> map = new HashMap<>();
        try {
            map = crawlDataBusiness.crawDrmedData(desc, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Map<String, SymptomDetailsBo> crawDrmedDataAll() {
        Map<String, SymptomDetailsBo> map = new HashMap<>();
        try {
            map = crawlDataBusiness.crawDrmedDataAll(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean insertAllSymptomDetails(Map<String, SymptomDetailsBo> map) {
        return dataWriteBusiness.insertAllSymptomDetails(map);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean insertOne(SymptomDetailsBo bo) {
        return dataWriteBusiness.insertOne(bo);
    }

    public void crawPostParam() {
        try {
            crawlDataBusiness.crawPostParam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
