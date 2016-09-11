/*
 * 文件名：HaodfService.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HaodfService.java
 * 修改人：yunhai
 * 修改时间：2016年5月5日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service.impl;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zxiaofan.MedicalAssistanService.business.ICrawlHaodfBusiness;
import com.zxiaofan.MedicalAssistanService.constant.Constant_Haodf;
import com.zxiaofan.MedicalAssistanService.dao.IDrmedDao;
import com.zxiaofan.MedicalAssistanService.service.IHaodfService;
import com.zxiaofan.MedicalAssistanService.util.HttpUtils;

/**
 * @author yunhai
 */
@Component("haodfService")
public class HaodfService implements IHaodfService {
    @Autowired
    private ICrawlHaodfBusiness crawHaodfBusiness;

    @Autowired
    private IDrmedDao drmedDao;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawHaodfDoc() {
        List<String> list = drmedDao.selectExistingDisease();
        for (String diseaseName : list) {
            crawHaodfBusiness.crawHaodfDoc(diseaseName);
        }
    }

    public void crawHaodfDoc(String diseaseName) {
        crawHaodfBusiness.crawHaodfDoc(diseaseName);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawHaodfHos() {
        List<String> list = drmedDao.selectExistingDisease();
        for (String diseaseName : list) {
            crawHaodfBusiness.crawHaodfHos(diseaseName);
        }
    }

    public void crawHaodfHos(String diseaseName) {
        crawHaodfBusiness.crawHaodfHos(diseaseName);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawHaodfHosList() {
        Document doc = HttpUtils.JsoupGetDoc(Constant_Haodf.Url_Haodf_Hos_List_All);
        Elements eles = doc.getElementById("el_tree_1000000").getElementsByClass("kstl").select("a");
        crawHaodfBusiness.crawHaodfHosList("北京");
        for (Element ele : eles) {
            crawHaodfBusiness.crawHaodfHosList(ele.text().trim());
        }
    }

    public void crawHaodfHosList(String provence) {
        crawHaodfBusiness.crawHaodfHosList(provence);
    }
}
