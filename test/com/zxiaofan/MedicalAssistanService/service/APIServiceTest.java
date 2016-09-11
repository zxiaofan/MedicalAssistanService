/*
 * 文件名：QueryMatchServiceImplTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： QueryMatchServiceImplTest.java
 * 修改人：yunhai
 * 修改时间：2016年4月30日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.model.bo.UserInfoBo;

/**
 * 
 * @author yunhai
 */
public class APIServiceTest extends BaseTest {
    @Autowired
    private IAPIService queryMatchService;

    /**
     * Test method for {@link com.zxiaofan.MedicalAssistanService.service.impl.APIService#queryMatchedDisease(java.lang.String)}.
     */
    @Test
    public void testQueryMatchedDisease() {
        List<String> list = new ArrayList<>();
        list.add("手臂疼痛");
        // list.add("腰部弯曲1");
        String result = queryMatchService.queryDiseaseBySymptom(new Gson().toJson(list));
        System.out.println(result);
    }

    @Test
    public void testQueryMatchedDiseaseKeyId() {
        List<String> list = new ArrayList<>();
        list.add("A_15");
        list.add("I_136");
        String result = queryMatchService.queryDiseaseKeyIdBySymptom(new Gson().toJson(list));
        System.out.println(result);
    }

    @Test
    public void testQueryDoctorsByDisease() {
        String result = queryMatchService.queryDoctorsByDisease("髌骨软化症");
        System.out.println(result);
    }

    @Test
    public void testQueryHospitalsByDisease() {
        String result = queryMatchService.queryHospitalsByDisease("白内障");
        System.out.println(result);
    }

    @Test
    public void testRegister() {
        UserInfoBo bo = new UserInfoBo();
        bo.setUserName("xiao1fan");
        bo.setPassWord("xxx123");
        bo.setUserType(1);
        String result = queryMatchService.register(new Gson().toJson(bo));
        System.out.println(result);
    }
}
