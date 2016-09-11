/*
 * 文件名：CrawHaodfBusinessTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CrawHaodfBusinessTest.java
 * 修改人：yunhai
 * 修改时间：2016年5月4日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxiaofan.MedicalAssistanService.BaseTest;

/**
 * 
 * @author yunhai
 */
public class CrawHaodfBusinessTest extends BaseTest {
    @Autowired
    private ICrawlHaodfBusiness crawHaodfBusiness;

    /**
     * Test method for {@link com.zxiaofan.MedicalAssistanService.business.impl.CrawlHaodfBusiness#crawHaodfDoc()}.
     */
    @Test
    public void testCrawHaodfDoc() {
        crawHaodfBusiness.crawHaodfDoc("感冒");
    }

    /**
     * Test method for {@link com.zxiaofan.MedicalAssistanService.business.impl.CrawlHaodfBusiness#crawHaodfHos()}.
     */
    @Test
    public void testCrawHaodfHos() {
    }

}
