/*
 * 文件名：HaodfDaoTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HaodfDaoTest.java
 * 修改人：yunhai
 * 修改时间：2016年5月5日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.constant.Constant_Haodf;
import com.zxiaofan.MedicalAssistanService.util.StringUtils;

/**
 * @author yunhai
 */
public class HaodfDaoTest extends BaseTest {
    @Autowired
    private IHaodfDao haodfDao;

    /**
     * Test method for {@link com.zxiaofan.MedicalAssistanService.dao.impl.HaodfDao#getDiseaseNameByKeyId(java.lang.String)}.
     */
    @Test
    public void testGetDiseaseNameByKeyId() {
        Map<String, String> mapPolyphone = StringUtils.initNameCharMap(Constant_Haodf.path_Polyphone, 0, 1, true);
        if (mapPolyphone.containsKey("﻿bangguangai")) {
            System.out.println(123);
        }
        // List<String> str = haodfDao.getKeyIdByDiseaseNamePinYin("|1234");
        // System.out.println(str);
        // List<DoctorsInfoBo> map = haodfDao.queryAllKeyIdAndDiseaseName();
        // System.out.println(new Gson().toJson(map));
    }
}
