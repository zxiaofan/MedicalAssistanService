/*
 * 文件名：RebuildDataBaseBusinessTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RebuildDataBaseBusinessTest.java
 * 修改人：yunhai
 * 修改时间：2016年4月28日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.business.impl.RebuildDataBaseBusiness;

/**
 * @author yunhai
 */
public class RebuildDataBaseBusinessTest extends BaseTest {
    @Autowired
    private RebuildDataBaseBusiness rebuildDataBaseBusiness;

    /**
     * Test method for {@link com.zxiaofan.MedicalAssistanService.business.impl.RebuildDataBaseBusiness#getSpecialAttribute(java.util.List, java.lang.Object)}.
     */
    @Test
    public void testGetSpecialAttribute() {
        // rebuildDataBaseBusiness.buildFeatureMatch();
        rebuildDataBaseBusiness.buildNewDiseaseDiteals();
    }

    @Test
    public void testMatcher() {
        String json = "|123|456|789|";
        Matcher matcher = Pattern.compile("\\|123\\|").matcher(json);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "|aaa|");
        }
        matcher.appendTail(sb);
        System.err.println(sb.toString());
    }

}
