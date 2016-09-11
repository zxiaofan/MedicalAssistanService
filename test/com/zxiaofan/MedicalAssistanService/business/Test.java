/*
 * 文件名：Test.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test.java
 * 修改人：yunhai
 * 修改时间：2016年4月19日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

import javax.annotation.Resource;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zxiaofan.MedicalAssistanService.BaseTest;
import com.zxiaofan.MedicalAssistanService.constant.ConstantApi;
import com.zxiaofan.MedicalAssistanService.util.HttpUtils;
import com.zxiaofan.MedicalAssistanService.util.Logging;
import com.zxiaofan.MedicalAssistanService.util.StringUtils;

/**
 * @author yunhai
 */
public class Test extends BaseTest {
    @Resource(name = "dataWriteBusiness")
    private IDataWriteBusiness business;

    @Resource(name = "logging")
    private Logging logging;

    @org.junit.Test
    public void main() throws Exception {
        // logging.log.error("info");
        Document docDisease = HttpUtils.JsoupGetDoc("http://www.drmed.cn/tension-headache");
        // Document docDisease = Jsoup.parse(FileUtils.readFileToString(new File("test/com/zxiaofan/testData/tension-headache.html"), "utf-8"));
        String summary = docDisease.getElementsByClass("textarea").first().text();
        summary = summary.substring(summary.indexOf(" ") + 1);
        Elements elesGuide = docDisease.getElementById("content_side").getElementsByClass("guide").select("a[href]");
        String desc;
        for (int i = 1; i < elesGuide.size(); i++) {
            Element ele = elesGuide.get(i);
            desc = ele.text();
            desc = desc.substring(desc.indexOf(".") + 1).trim();
            Document doc = HttpUtils.JsoupGetDoc(ele.attr("abs:href"));
            String str = doc.getElementsByClass("textarea").first().text();
            str = str.substring(str.indexOf(" ") + 1);
            System.err.println(str);
        }
        System.out.println("");
    }

    @org.junit.Test
    public void test() {
        // System.out.println(StringUtils.legal("32a.", ConstantApi.Reg_Char_Num));
        // System.out.println(StringUtils.legal("32a.,,", ConstantApi.Reg_Char_Num_Punctuation));
        System.out.println(StringUtils.legal("a1111,", ConstantApi.Reg_Char_Pwd));
    }
}
