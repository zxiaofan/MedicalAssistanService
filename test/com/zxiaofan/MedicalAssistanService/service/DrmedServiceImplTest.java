/*
 * 文件名：DrmedServiceImplTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DrmedServiceImplTest.java
 * 修改人：yunhai
 * 修改时间：2016年4月22日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;

/**
 * @author yunhai
 */
public class DrmedServiceImplTest extends BaseTest {
    @Resource(name = "drmedService")
    private IDrmedService drmedService;

    /**
     * Test method for {@link com.zxiaofan.MedicalAssistanService.service.impl.DrmedServiceImpl#crawDrmedDataAll()}.
     */
    @Test
    public void testCrawDrmedDataAll() {
        Map<String, SymptomDetailsBo> map = drmedService.crawDrmedDataAll();
        drmedService.insertAllSymptomDetails(map);
    }

    @Test
    public void testCrawDisease() {
        drmedService.crawPostParam();
    }

}
