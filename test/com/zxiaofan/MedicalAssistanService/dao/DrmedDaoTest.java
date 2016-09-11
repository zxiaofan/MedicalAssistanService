/*
 * 文件名：DrmedDaoTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DrmedDaoTest.java
 * 修改人：yunhai
 * 修改时间：2016年4月27日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.model.bo.DiseaseDetailsBo;

/**
 * 
 * @author yunhai
 */
public class DrmedDaoTest extends BaseTest {
    @Autowired
    private IDrmedDao drmedDao;

    /**
     * Test method for {@link com.zxiaofan.MedicalAssistanService.dao.impl.DrmedDao#getDiseaseBykeyId(java.lang.String)}.
     */
    @Test
    public void testGetDiseaseBykeyId() {
        DiseaseDetailsBo bo = new DiseaseDetailsBo();
        bo.setKeyId("123");
        bo.setDiseaseName("name");
        drmedDao.updateDiseaseByKeyId(bo);
    }

    @Test
    public void testQuerySymptoms() {
        drmedDao.querySymptoms();
    }

}
