/*
 * 文件名：CrawHaodfBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CrawHaodfBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年5月4日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.zxiaofan.MedicalAssistanService.business.ICrawlHaodfBusiness;
import com.zxiaofan.MedicalAssistanService.constant.Constant_Haodf;
import com.zxiaofan.MedicalAssistanService.dao.IHaodfDao;
import com.zxiaofan.MedicalAssistanService.model.bo.DoctorsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.HospitalsInfoBo;
import com.zxiaofan.MedicalAssistanService.util.ChineseToEnglish;
import com.zxiaofan.MedicalAssistanService.util.CommonCheckUtils;
import com.zxiaofan.MedicalAssistanService.util.HttpUtils;
import com.zxiaofan.MedicalAssistanService.util.Logging;
import com.zxiaofan.MedicalAssistanService.util.StringUtils;

/**
 * 
 * @author yunhai
 */
@Component("crawlHaodfBusiness")
public class CrawlHaodfBusiness implements ICrawlHaodfBusiness {

    @Resource(name = "logging")
    private Logging logging;

    @Resource(name = "haodfDao")
    private IHaodfDao haodfDao;

    /**
     * 现有医院By disease.
     */
    private Map<String, HospitalsInfoBo> mapexistDis = new HashMap<>();

    /**
     * 多音字.
     */
    private Map<String, String> mapPolyphone = new HashMap<>();

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawHaodfDoc(String diseaseName) {
        logging.log.warn("-------" + diseaseName + " Starting...");
        String diseaseNamePinYin = ChineseToEnglish.getPingYin(diseaseName);
        // 默认只查询第一页的医生信息
        String url = Constant_Haodf.Url_Haodf_Doc_Prefix + diseaseNamePinYin + Constant_Haodf.Url_Haodf_Doc_Suffix_1;
        Document doc = HttpUtils.JsoupGetDoc(url);
        if (doc == null) {
            if (mapPolyphone.isEmpty()) {
                mapPolyphone = StringUtils.initNameCharMap(Constant_Haodf.path_Polyphone, 0, 1, true);
            }
            if (mapPolyphone.containsKey(diseaseNamePinYin) || diseaseNamePinYin.contains("bangguang")) {
                if (diseaseNamePinYin.contains("bangguang")) {
                    diseaseNamePinYin = diseaseNamePinYin.replaceAll("bangguang", "pangguang");
                } else {
                    diseaseNamePinYin = mapPolyphone.get(diseaseNamePinYin);
                }
                if (diseaseNamePinYin != null) {
                    url = Constant_Haodf.Url_Haodf_Doc_Prefix + diseaseNamePinYin + Constant_Haodf.Url_Haodf_Doc_Suffix_1;
                    doc = HttpUtils.JsoupGetDoc(url);
                }
            }
            if (doc == null) {
                logging.log.warn(diseaseName + "(" + diseaseNamePinYin + ")无推荐医生(⊙o⊙)…无效url:" + url);
                return;
            }
        }
        // 测试专用
        // Document doc = null;
        // try {
        // doc = Jsoup.parse(FileUtils.readFileToString(new File("test/com/zxiaofan/testData/haodf-ganmao.html"), Constant.ENCODE));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // 有空格表示这个div继承了两个class，注意小数点
        Elements eles = doc.select(".fs").select(".hp_doc").select(".clearfix").get(0).getElementsByClass("hp_doc_box_serviceStar").select(".lh180");// getElementsByClass("fs hp_doc clearfix")对空格无效
        if (eles == null) {
            logging.log.warn(diseaseName + "(" + diseaseNamePinYin + ")四川地区无推荐医生(⊙o⊙)…无效url:" + url);
            url = Constant_Haodf.Url_Haodf_Doc_Prefix + diseaseNamePinYin + Constant_Haodf.Url_Haodf_Doc_Suffix_;
            doc = HttpUtils.JsoupGetDoc(url);
            eles = doc.select(".fs").select(".hp_doc").select(".clearfix").get(0).getElementsByClass("hp_doc_box_serviceStar").select(".lh180");
            if (eles == null) {
                logging.log.warn(diseaseName + "(" + diseaseNamePinYin + ")全国地区无推荐医生(⊙o⊙)…无效url:" + url);
                return;
            }
        }
        int index = 0;
        String recommendHeat;
        List<DoctorsInfoBo> listDoc = haodfDao.queryAllKeyIdAndDiseaseName();// 所有医生KeyId和Disease信息
        Map<String, DoctorsInfoBo> mapKeyDis = new HashMap<>();
        for (DoctorsInfoBo bo : listDoc) {
            mapKeyDis.put(bo.getKeyId(), bo);
        }
        for (Element ele : eles) {
            DoctorsInfoBo bo = new DoctorsInfoBo();
            String hospital = ele.getElementsByClass("ml10").text().trim();
            index = hospital.lastIndexOf("医院");
            bo.setDocHospital(hospital.substring(0, index + 2));
            bo.setDocDepart(hospital.substring(index + 2, hospital.length()));
            bo.setDocName(ele.select("a[href]").first().text());
            String keyId = ChineseToEnglish.creatKeyId(bo.getDocName() + bo.getDocHospital() + bo.getDocDepart() + ChineseToEnglish.getCnASCII(bo.getDocName()));
            bo.setKeyId(keyId);

            if (mapKeyDis.keySet().contains(keyId)) { // 当前医生已入库
                logging.log.warn(bo.getDocHospital() + "-" + bo.getDocDepart() + "-" + bo.getDocName() + " 【已入库】");
                // 判断是否需要更新医生disease信息
                if (!mapKeyDis.get(keyId).getDiseaseName().contains("|" + diseaseName + "|")) { // 未包含当前数据，更新
                    if (!"".equals(mapKeyDis.get(keyId).getDiseaseName())) {
                        bo.setDiseaseName(mapKeyDis.get(keyId).getDiseaseName() + diseaseName + "|");
                        bo.setDiseaseNamePinYin(mapKeyDis.get(keyId).getDiseaseNamePinYin() + diseaseNamePinYin + "|");
                    } else {
                        bo.setDiseaseName("|" + mapKeyDis.get(keyId).getDiseaseName() + diseaseName + "|");
                        bo.setDiseaseNamePinYin("|" + mapKeyDis.get(keyId).getDiseaseNamePinYin() + diseaseNamePinYin + "|");
                    }

                    updateDiseaseBykeyId(bo);
                    logging.log.warn("更新-" + bo.getDocName() + "-医生disease信息!");
                }
                continue;
            }
            bo.setDiseaseName("|" + diseaseName + "|");
            bo.setDiseaseNamePinYin("|" + diseaseNamePinYin + "|");
            bo.setUrlDoc(ele.select("a[href]").first().attr("href"));
            recommendHeat = ele.getElementsByClass("blue").text().trim();
            if (recommendHeat.matches("[0-9]+[\\.]{0,1}[0-9]+")) {
                bo.setRecommendHeat(Double.valueOf(recommendHeat));
            } else {
                bo.setRecommendHeat(0);
            }
            bo.setDocTitle(ele.getElementsByClass("ml15").text().trim());

            // get details
            Document docDetails = HttpUtils.JsoupGetDoc(bo.getUrlDoc());
            if (docDetails == null) {
                logging.log.warn(bo.getDocHospital() + "-" + bo.getDocDepart() + "-" + bo.getDocName() + "-获取医生详细返回null," + bo.getUrlDoc());
                continue;
            }
            String s1 = docDetails.select("script").html();
            s1 = StringUtils.convertUnicode(s1);
            docDetails = Jsoup.parse(s1);
            Element eleDet = docDetails.getElementsByClass("doctor_about").first();
            if (eleDet == null) {
                logging.log.warn(bo.getDocHospital() + "-" + bo.getDocDepart() + "-" + bo.getDocName() + "-获取医生详细返回null," + bo.getUrlDoc());
                continue;
            }
            try {
                String docTitle = null;
                try {
                    docTitle = eleDet.getElementsByClass("middletr").select("tr").select("tr:contains(职　　称：)").select("td").get(2).text();
                } catch (Exception e) {
                    Thread.sleep(500);
                    docTitle = eleDet.getElementsByClass("middletr").select("tr").select("tr:contains(职　　称：)").select("td").get(2).text();
                }
                bo.setDocTitle(docTitle); // 更新职称
                if (eleDet.getElementById("full_DoctorSpecialize") != null) {
                    bo.setDocAdept(eleDet.getElementById("full_DoctorSpecialize").text().trim());
                } else {
                    bo.setDocAdept(eleDet.getElementsByClass("middletr").select("tr").select("tr:contains(擅　　长：").select("td").get(2).text());
                }
                String thanksLeterNum = eleDet.select(".button_halfgxx").first().select("span").text();
                if (thanksLeterNum.matches("[0-9]+")) {
                    bo.setThanksLetterNum(Integer.valueOf(thanksLeterNum));
                } else {
                    bo.setThanksLetterNum(0);
                }
                if (eleDet.getElementById("full") != null) {
                    bo.setPracticeExperience(eleDet.getElementById("full").text().trim().replace("<< 收起", ""));
                } else {
                    bo.setPracticeExperience(eleDet.getElementsByClass("middletr").select("tr").select("tr:contains(执业经历：)").text().trim().replace("<< 收起", ""));
                }
            } catch (Exception e) {
                logging.log.warn("获取医生[" + bo.getDocName() + "]详细信息异常,url:" + bo.getUrlDoc());
                logging.log.warn("parase:" + eleDet.html());
                logging.log.error("error:", e);
                break;
            }
            if (CommonCheckUtils.isNotEmpty(bo)) { // 入库
                haodfDao.insertHaodfDoc(bo);
            }
        }
        logging.log.warn("-------" + diseaseName + " End...");
    }

    /**
     * 根据KeyId更新disease信息.
     * 
     * @param bo
     */
    private boolean updateDiseaseBykeyId(DoctorsInfoBo bo) {
        return haodfDao.updateDocDiseaseByKeyId(bo);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawHaodfHos(String diseaseName) {
        logging.log.warn("-------" + diseaseName + " Hospital Starting...");
        Element ele = hasHosData(diseaseName, 1);
        if (ele == null) {
            return;
        }
        // 开始解析
        // 解析数据页数
        int pageNum = 1;
        String pageStr = "";
        Elements elesPage = ele.getElementsByClass("pt10");
        if (elesPage == null || elesPage.isEmpty()) {
            return;
        }
        List<HospitalsInfoBo> existHosByDisease = haodfDao.queryExistHos();
        if (existHosByDisease != null && !existHosByDisease.isEmpty()) {
            for (HospitalsInfoBo bo : existHosByDisease) {
                mapexistDis.put(bo.getHospitalName(), bo);
            }
        }
        elesPage = elesPage.first().getElementsByClass("page_turn");
        if (elesPage != null && elesPage.size() > 0) {
            pageStr = elesPage.first().getElementsByClass("page_turn_a").select("a:contains(共)").select("a:contains(页)").select("font").text();
            if (pageStr.matches("[0-9]+")) {
                pageNum = Integer.valueOf(pageStr);
            } else {
                logging.log.warn("---获取医院信息分页数目转换异常,原数据:" + elesPage.html());
                logging.log.warn("---分页数目解析数据:" + pageStr);
            }
        }
        analyseHosDataAndInsert(ele, diseaseName); // 分析首页数据
        for (int i = 2; i <= pageNum; i++) { // 抓取其他所有医院信息
            ele = hasHosData(diseaseName, i);
            analyseHosDataAndInsert(ele, diseaseName);
        }
    }

    /**
     * 是否包含医院数据.
     * 
     * @param diseaseName
     * @param diseaseNamePinYin
     * @param i
     *            第i页数据
     * @return
     */
    private Element hasHosData(String diseaseName, int i) {
        String diseaseNamePinYin = ChineseToEnglish.getPingYin(diseaseName);
        String url = Constant_Haodf.Url_Haodf_Doc_Prefix + diseaseNamePinYin + Constant_Haodf.Url_Haodf_Hos_Suffix_Sichuan + i;
        // String url = "http://www.haodf.com/jibing/jiujingzhongdu/yiyuan.htm?province=fujian";
        Document doc = HttpUtils.JsoupGetDoc(url);
        if (doc == null) {
            if (diseaseNamePinYin.contains("bangguang")) {
                diseaseNamePinYin = diseaseNamePinYin.replaceAll("bangguang", "pangguang");
                url = Constant_Haodf.Url_Haodf_Doc_Prefix + diseaseNamePinYin + Constant_Haodf.Url_Haodf_Hos_Suffix_Sichuan + i;
                doc = HttpUtils.JsoupGetDoc(url);
            }
            if (doc == null) {
                logging.log.warn(diseaseName + "(" + diseaseNamePinYin + ")无推荐医院(⊙o⊙)…无效url:" + url);
                return null;
            }
        }
        // System.out.println(doc.html());
        Element ele = doc.getElementById("left_con");
        if (ele.getElementsByClass("hp_hos_table").first() == null) {
            logging.log.warn(diseaseName + "(" + diseaseNamePinYin + ")【四川】无推荐医院…");
            url = Constant_Haodf.Url_Haodf_Doc_Prefix + diseaseNamePinYin + Constant_Haodf.Url_Haodf_Hos_Suffix_QuanGuo + i;
            doc = HttpUtils.JsoupGetDoc(url);
            ele = doc.getElementById("left_con");
            if (ele.getElementsByClass("hp_hos_table").first() == null) {
                logging.log.warn(diseaseName + "(" + diseaseNamePinYin + ")【全国】无推荐医院…无效");
            }
        }
        return ele;
    }

    /**
     * 分析医院数据并入库.
     * 
     * @param diseaseName
     * 
     * @param element.getElementsByClass(className)
     */
    private void analyseHosDataAndInsert(Element element, String diseaseName) {
        Elements elesHosList = element.getElementsByClass("con_list");
        String diseaseNamePinYin = ChineseToEnglish.getPingYin(diseaseName);
        if (diseaseNamePinYin.contains("bangguang")) {
            diseaseNamePinYin = diseaseNamePinYin.replaceAll("bangguang", "pangguang");
        }
        String str = "";
        for (Element ele : elesHosList) {
            HospitalsInfoBo bo = new HospitalsInfoBo();
            Elements eles = ele.select("td");
            bo.setHospitalName(eles.get(0).text().trim());
            // 判断是否需要更新disease信息，或是直接入库
            String oldDis = "|";
            String oldDisPY = "|";
            if (mapexistDis.get(bo.getHospitalName()) != null) {
                if ((mapexistDis.get(bo.getHospitalName()).getDiseaseName()) != null) {
                    oldDis = mapexistDis.get(bo.getHospitalName()).getDiseaseName();
                    oldDisPY = mapexistDis.get(bo.getHospitalName()).getDiseaseNamePinYin();
                }
                if (oldDis != null && oldDis.contains("|" + diseaseName + "|")) {
                    continue;
                }
            }
            bo.setDiseaseName(oldDis + diseaseName + "|");
            bo.setDiseaseNamePinYin(oldDisPY + diseaseNamePinYin + "|");
            bo.setHospitalCity(eles.get(1).text().trim());
            bo.setHospitalLevel(eles.get(2).text().trim());
            str = eles.get(3).select("span").text().trim();
            // if (str.matches("[0-9]+")) { // 该疾病获得好评大夫
            // bo.setAlikeDocNum(Integer.valueOf(str));
            // }
            // str = eles.get(4).select("a").text().trim();
            // if (str.matches("[0-9]+")) { // 该疾病获得投票数
            // bo.setVotes(Integer.valueOf(str));
            // }

            // 判断直接入库还是更新disease信息

            if (CommonCheckUtils.isNotEmpty(bo)) { // 入库
                haodfDao.updateHaodfHos(bo);
            }
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawHaodfHosList(String provence) {
        logging.log.warn("-------" + provence + " Hospital List Starting...");
        List<String> existHosName = haodfDao.queryHosByProvence(provence);
        String url = Constant_Haodf.Url_Haodf_Hos_List_Prefix + ChineseToEnglish.getPingYin(provence) + Constant_Haodf.Url_Haodf_Hos_List_Suffix;
        Document doc = HttpUtils.JsoupGetDoc(url);
        if (doc == null) {
            logging.log.warn("-------" + provence + " 无数据");
            return;
        }
        Element eleAll = doc.getElementsByClass("bxmd").get(1);
        Elements elesCity = eleAll.getElementsByClass("m_title_green");
        Elements elesHos = eleAll.getElementsByClass("m_ctt_green");
        for (int i = 0; i < elesCity.size(); i++) {
            Elements eHos = elesHos.get(i).select("li");
            for (Element ele : eHos) {
                HospitalsInfoBo bo = new HospitalsInfoBo();
                bo.setHospitalName(ele.select("a").text().trim());
                if (existHosName.contains(bo.getHospitalName())) {
                    logging.log.warn("--" + bo.getHospitalName() + "已入库,勿重复入库!!");
                    continue;
                }
                bo.setHospitalCity(elesCity.get(i).text().trim());
                bo.setUrl(ele.select("a[href]").attr("abs:href"));
                Document docHosDetail = HttpUtils.JsoupGetDoc(bo.getUrl());
                if (docHosDetail == null) {
                    logging.log.warn("-------" + bo.getHospitalName() + " 返回详细数据异常");
                    continue;
                }
                try {
                    String level = docHosDetail.getElementsByClass("area").get(1).getElementsByClass("panelA_blue").first().select("p").first().ownText().trim().replace("(", "").replace(")", "");
                    bo.setHospitalLevel(level);
                    Elements eleHosDetTR = docHosDetail.getElementsByClass("area").get(1).getElementsByClass("panelA_blue").first().select("tr");
                    bo.setAddress(eleHosDetTR.select("td:contains(地　　址：)").text().trim().replace("地　　址：", ""));
                    bo.setTelePhone(eleHosDetTR.select("td:contains(电　　话：)").text().trim().replace("电　　话：", ""));
                    String thanksNum = null;
                    try {
                        thanksNum = docHosDetail.getElementById("hosthank").getElementsByClass("toptr").first().select("span").text().trim();
                        if (thanksNum.matches("[0-9]+")) {
                            bo.setThanksLetterNum(Integer.valueOf(thanksNum));
                        } else {
                            logging.log.warn(bo.getHospitalName() + "--解析感谢信数量异常,设为0,转换内容:" + thanksNum + ",url:" + bo.getUrl());
                            bo.setThanksLetterNum(0);
                        }
                    } catch (Exception e) {
                        logging.log.warn(bo.getHospitalName() + "--解析感谢信数量异常,设为0,url:" + bo.getUrl());
                        bo.setThanksLetterNum(0);
                    }
                } catch (NumberFormatException e) {
                    logging.log.error("解析异常,Data:" + docHosDetail.html());
                }
                bo.setHospitalProvince(provence);
                haodfDao.insertHaodfHos(bo);
            }
        }
    }

}
