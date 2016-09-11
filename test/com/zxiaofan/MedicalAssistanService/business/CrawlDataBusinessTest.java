/*
 * 文件名：CrawlDataBusinessTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CrawlDataBusinessTest.java
 * 修改人：yunhai
 * 修改时间：2016年4月18日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.business.impl.CrawlDataBusiness;
import com.zxiaofan.MedicalAssistanService.business.impl.DataWriteBusiness;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;
import com.zxiaofan.MedicalAssistanService.util.HttpUtils;

/**
 * @author yunhai
 */
public class CrawlDataBusinessTest extends BaseTest {
    @Autowired
    private CrawlDataBusiness crawlDataBusiness;

    @Autowired
    private DataWriteBusiness dataWriteBusiness;

    @Test
    public void test() throws Exception {
        crawlDataBusiness.crawDiseaseDetails("泌尿问题");
        // crawlDataBusiness.getExistingDisease();
    }

    /**
     * 获取disease数据，可多次执行.
     * 
     * @throws Exception
     */
    @Test
    public void testCrawDiseaseDetails() throws Exception {
        crawlDataBusiness.crawDiseaseDetails("视力问题");
    }

    @Test
    public void testCrawByDesc() {
        try {
            Map<String, SymptomDetailsBo> map = crawlDataBusiness.crawDrmedData("吞咽困难", 2);
            // String path = "WebContent/WEB-INF/config/desc-field.ini";
            // String str = FileUtils.readFileToString(new File(path), "utf-8");
            // Map<String, String> map = readTextFile(path, "utf-8");
            System.out.println(map);
            dataWriteBusiness.insertAllSymptomDetails(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsoupPost() throws Exception {
        String url = "http://www.drmed.cn/self-diagnosis/headaches-adult";
        // Map<String, String> map = new HashMap<>();
        // map.put("specifics[]", "A-4");
        // map.put("specifics[]", "H-11");
        // map.put("emergency", "<p>头痛若伴有以下表现，需即刻就诊：</p><ul><li>头痛发作突然且程度剧烈</li><li>伴有发热、颈僵、皮疹、意识混乱、癫痫、视物重影、无力、麻木或言语困难</li><li>头部外伤后出现的头痛</li><li>休息及服用止痛药后头痛仍继续加重</li></ul>");
        // Document doc = HttpUtils.jsoupPostDoc(url, map);
        // System.out.println(doc.html());
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair("specifics[]", ".*"));
        // param.add(new BasicNameValuePair("specifics[]", "H-11"));
        param.add(new BasicNameValuePair("emergency", "<p>头痛若伴有以下表现，需即刻就诊：</p><ul><li>头痛发作突然且程度剧烈</li><li>伴有发热、颈僵、皮疹、意识混乱、癫痫、视物重影、无力、麻木或言语困难</li><li>头部外伤后出现的头痛</li><li>休息及服用止痛药后头痛仍继续加重</li></ul>"));
        Document doc = HttpUtils.jsoupPostDoc(url, param);
        System.out.println(doc.html());
    }
}
