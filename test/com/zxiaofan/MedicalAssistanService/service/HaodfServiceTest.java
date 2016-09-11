/*
 * 文件名：HaodfServiceTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HaodfServiceTest.java
 * 修改人：yunhai
 * 修改时间：2016年5月5日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.model.bo.DoctorsInfoBo;
import com.zxiaofan.MedicalAssistanService.service.impl.HaodfService;
import com.zxiaofan.MedicalAssistanService.util.ChineseToEnglish;

/**
 * 
 * @author yunhai
 */
public class HaodfServiceTest extends BaseTest {
    @Autowired
    private HaodfService haodfService;

    @Test
    public void testCrawHaodfDoc() {
        haodfService.crawHaodfDoc();
    }

    @Test
    public void testCrawHaodfDocByName() {
        haodfService.crawHaodfDoc("鼻息肉");
    }

    @Test
    public void testCrawHaodfHos() {
        haodfService.crawHaodfHos();
    }

    @Test
    public void testCrawHaodfHosByName() {
        haodfService.crawHaodfHos("淋病");
    }

    @Test
    public void testCrawHaodfHosListByName() {
        haodfService.crawHaodfHosList("四川");
    }

    @Test
    public void crawHaodfHosList() {
        haodfService.crawHaodfHosList();
    }

    @Test
    public void testKeyId() {
        String thanksLeterNum = "25.12.";
        if (thanksLeterNum.matches("[0-9]+[\\.]{0,1}[0-9]+")) {
            System.out.println(111);
        }
        DoctorsInfoBo bo = new DoctorsInfoBo();
        bo.setDocHospital("华西医院");
        bo.setDocDepart("耳鼻咽喉-头颈外科");
        bo.setDocName("李昌林");
        System.out.println(ChineseToEnglish.getCnASCII(bo.getDocName()));
        String keyId = ChineseToEnglish.creatKeyId(bo.getDocName() + bo.getDocHospital() + bo.getDocDepart() + ChineseToEnglish.getCnASCII(bo.getDocName()));
        System.out.println(keyId);
        bo.setDocName("刘永惠");
        keyId = ChineseToEnglish.creatKeyId(bo.getDocName() + bo.getDocHospital() + bo.getDocDepart() + ChineseToEnglish.getCnASCII(bo.getDocName()));
        System.err.println(keyId);
    }

}
