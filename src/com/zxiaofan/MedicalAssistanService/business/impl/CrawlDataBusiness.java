/*
 * 文件名：CrawlDataBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CrawlDataBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年4月18日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business.impl;

import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zxiaofan.MedicalAssistanService.business.ICrawlDataBusiness;
import com.zxiaofan.MedicalAssistanService.constant.Constant;
import com.zxiaofan.MedicalAssistanService.dao.IDrmedDao;
import com.zxiaofan.MedicalAssistanService.model.bo.DiseaseDetailsBo;
import com.zxiaofan.MedicalAssistanService.model.bo.DiseasePostParamBo;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;
import com.zxiaofan.MedicalAssistanService.util.ChineseToEnglish;
import com.zxiaofan.MedicalAssistanService.util.HttpUtils;
import com.zxiaofan.MedicalAssistanService.util.Logging;
import com.zxiaofan.MedicalAssistanService.util.StringUtils;

/**
 * 数据打底
 * 
 * @author yunhai
 */
@Component("crawlDataBusiness")
public class CrawlDataBusiness implements ICrawlDataBusiness {
    @Autowired
    private IDrmedDao drmedDao;

    @Resource(name = "logging")
    private Logging logging;

    public CrawlDataBusiness() {
        // initDescFieldMap(Constant.path_desc_field);
    }

    /**
     * 症状连接url Map.
     */
    Map<String, String> symptomUrlsMap = new HashMap<>();

    /**
     * 疾病url Map.
     */
    Map<String, String> diseaseUrlsMap = new HashMap<>();

    /**
     * 症状描述.
     */
    Map<String, SymptomDetailsBo> symptomMap = new HashMap<>();

    /**
     * 症状-字段描述.
     */
    static Map<String, String> descFieldMap = new HashMap<>();

    /**
     * 已入库的disease数据.
     */
    static List<String> listExistingDisease = new ArrayList<>();

    @Override
    public Map<String, SymptomDetailsBo> crawDrmedData(String desc, int personType) throws Exception {
        initDescFieldMap(Constant.path_desc_field);
        Map<String, SymptomDetailsBo> map = new HashMap<>();
        if (personType != 2) {
            map = crawDrmed(desc, personType);
        } else {
            map.putAll(crawDrmed(desc, 1));
            map.putAll(crawDrmed(desc, 0));
        }
        File file = new File(Constant.path_Symptom_Details);
        FileUtils.writeStringToFile(file, new Gson().toJson(map), Constant.ENCODE);
        return map;
    }

    @Override
    public Map<String, SymptomDetailsBo> crawDrmedDataAll(int personType) throws Exception {
        Map<String, SymptomDetailsBo> map = new HashMap<>();
        if (personType != 2) {
            map = crawDrmed(null, personType);
        } else {
            map.putAll(crawDrmed(null, 1));
            map.putAll(crawDrmed(null, 0));
        }
        File file = new File(Constant.path_Symptom_Details);
        FileUtils.writeStringToFile(file, new Gson().toJson(map), Constant.ENCODE);
        return map;
    }

    /**
     * 抓取drmed数据.
     * 
     * @param personType
     *            1:成人；0：儿童；2：成人+儿童
     * 
     * @throws Exception
     * 
     */
    private Map<String, SymptomDetailsBo> crawDrmed(String desc, int personType) throws Exception {
        Map<String, SymptomDetailsBo> mapAll = new HashMap<>();
        // get每个症状的绝对URL
        Document docURL = HttpUtils.JsoupGetDoc(Constant.url_self_diagnosis);
        // Document docURL = Jsoup.parse(FileUtils.readFileToString(new File("test/com/zxiaofan/testData/drmed症状主页Response.html"), Constant.ENCODE));
        Elements elementsURL = null;
        if (personType == 1) {
            elementsURL = docURL.select("#adult").select("a[href]"); // 成人症状
        } else if (personType == 0) {
            elementsURL = docURL.select("#child").select("a[href]"); // 小孩症状
        } else {
            elementsURL = docURL.getElementsByClass("symptoms").select("a[href]"); // 成人+小孩症状
        }
        for (Element ele : elementsURL) {
            symptomUrlsMap.put(StringUtils.formatStr(ele.text()), ele.attr("abs:href")); // 症状，url
        }
        SymptomDetailsBo bo = null;
        if (desc != null && symptomUrlsMap.containsKey(desc)) {
            bo = getDataByDesc(symptomUrlsMap, desc);
            if (personType == 0) {
                bo.setIsAdult(0);
            }
            mapAll.put(desc, bo);
        } else {
            for (Entry<String, String> entry : symptomUrlsMap.entrySet()) {
                bo = getDataByDesc(symptomUrlsMap, entry.getKey());
                if (personType == 0) {
                    bo.setIsAdult(0);
                }
                mapAll.put(entry.getKey(), bo);
            }
        }
        return mapAll;
    }

    /**
     * 根据症状描述抓取数据.
     * 
     * @param symptomUrlsMap2
     * @param desc
     * @return
     */
    private SymptomDetailsBo getDataByDesc(Map<String, String> symptomUrlsMap, String desc) {
        Document docSymp = HttpUtils.JsoupGetDoc(symptomUrlsMap.get(desc));
        // Document docSymp = Jsoup.parse(FileUtils.readFileToString(new File("test/com/zxiaofan/testData/headaches-adult.html"), "utf-8"));
        StringBuffer treatAdvice = new StringBuffer();
        treatAdvice.append("|");
        treatAdvice.append(docSymp.getElementsByClass("emergency").select("p").text().trim()).append("|");
        for (Element ele1 : docSymp.getElementsByClass("emergency").select("li")) {
            treatAdvice.append(ele1.text().trim()).append("|"); // 一行行提取，避用text()以避免值中有空格的情形
        }
        Elements elementsSympName = docSymp.getElementsByClass("specifics").select("h3"); // 当前症状描述名集合
        Elements elementsSymp = docSymp.getElementsByClass("specific");

        int index = 0;
        SymptomDetailsBo bo = new SymptomDetailsBo();
        bo.setSymptomName(desc);
        String fieldSym = ""; // 入库字段
        for (Element ele : elementsSympName) {
            StringBuffer value = new StringBuffer();
            value.append("|");
            fieldSym = ele.text().trim();
            for (Element ele1 : elementsSymp.get(index++).select("label")) {
                value.append(ele1.text().trim()).append("|"); // 一行行提取，避用text()以避免值中有空格的情形
            }
            try {
                setSpecialAttribute(fieldSym, value.toString().replaceAll(" ", ""), bo);
            } catch (Exception e) {
                logging.log.error(e.getMessage() + "fieldSym:" + fieldSym + ",value:" + value.toString().replaceAll(" ", ""));
            }
        }
        bo.setTreatmentAdvice(treatAdvice.toString());
        bo.setModifyTime(new Date());
        // 疼痛持续时间PainDuration去除多余空格
        if (bo.getPainDuration() != null && !bo.getPainDuration().isEmpty()) {
            bo.setPainDuration(bo.getPainDuration().replaceAll(" ", ""));
        }
        // break;
        return bo;
    }

    /**
     * 利用反射设置特殊属性.
     * 
     * @param desc
     * @param value
     * @param bo
     * @throws Exception
     */
    private boolean setSpecialAttribute(String desc, String value, Object bo) {
        try {
            String fieldNameUpper = descFieldMap.get(desc);
            String fieldNameLower = fieldNameUpper.substring(0, 1).toLowerCase() + fieldNameUpper.substring(1);
            Field field = bo.getClass().getDeclaredField(fieldNameLower);
            field.setAccessible(true);
            // PropertyDescriptor pd = new PropertyDescriptor(fieldName, bo.getClass()); // get属性描述器
            Method mSet = bo.getClass().getDeclaredMethod("set" + fieldNameUpper, String.class);
            // Method mGet = bo.getClass().getMethod("get" + fieldName); // get方法
            mSet.invoke(bo, value); // 调用setter方法设置属性值
            // Method wM = pd.getWriteMethod();// 获得写方法
            // wM.invoke(bo, (String) value1);
        } catch (Exception e) {
            e.printStackTrace();
            logging.log.error(e.getCause().getMessage() + ",setSpecialAttribute异常:" + "desc:" + desc + ",value:" + value + ",bo:" + bo.getClass());
            return false;
        }
        return true;
    }

    /**
     * 利用反射get特殊属性.
     * 
     * @param desc
     * @param value
     * @param bo
     * @throws Exception
     */
    private String getSpecialAttribute(String desc, String value, Object bo) {
        try {
            String fieldNameUpper = descFieldMap.get(desc);
            String fieldNameLower = fieldNameUpper.substring(0, 1).toLowerCase() + fieldNameUpper.substring(1);
            Field field = bo.getClass().getDeclaredField(fieldNameLower);
            field.setAccessible(true);
            PropertyDescriptor pd = new PropertyDescriptor(fieldNameUpper, bo.getClass()); // get属性描述器
            Method mGet = bo.getClass().getMethod("get" + fieldNameUpper); // get方法
            Method wM = pd.getWriteMethod();// 获得写方法
            value = (String) wM.invoke(bo, (String) value);
        } catch (Exception e) {
            e.printStackTrace();
            logging.log.error(e.getCause().getMessage() + ",getSpecialAttribute异常:" + "desc:" + desc + ",value:" + value + ",bo:" + bo.getClass());
            return null;
        }
        return value;
    }

    /**
     * 读取症状字段，生成Map.
     * 
     * @param path
     *            配置文件路径
     * @param encode
     *            编码
     */
    private static void initDescFieldMap(String path) {
        if (!descFieldMap.isEmpty()) {
            return;
        }
        try {
            File file = new File(path);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), Constant.ENCODE);
            BufferedReader ins = new BufferedReader(read);
            String dataLine = "";
            String[] descField = {};
            while (null != (dataLine = ins.readLine())) {
                if (!"".equals(dataLine)) {
                    descField = dataLine.split("=");
                    descFieldMap.put(descField[0], descField[1]);
                }
            }
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawDiseaseDetails(String desc) throws Exception {
        if (desc != null) {
            CrawDisease(desc);
        } else {
            CrawDisease(null);
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void crawPostParam() throws Exception {
        if (Constant.symptomUrlsMap == null || Constant.symptomUrlsMap.isEmpty()) {
            initSymptomUrlsMap();
        }
        Map<String, String> symptomUrlsMap = Constant.symptomUrlsMap;
        List<DiseasePostParamBo> list = new ArrayList<>();// 症状名，症状url,post参数
        for (Entry<String, String> entry : symptomUrlsMap.entrySet()) {
            StringBuffer buferParam = new StringBuffer();
            DiseasePostParamBo bo = new DiseasePostParamBo();
            String symptomUrl = entry.getValue();
            Document doc = HttpUtils.JsoupGetDoc(symptomUrl);
            Elements eles = doc.getElementsByClass("specific").select("input");
            for (Element ele : eles) {
                buferParam.append(ele.attr("value").trim()).append("|");
            }
            bo.setSymptomName(entry.getKey());
            bo.setUrl(symptomUrl);
            bo.setParam(buferParam.toString());
            String treatAdvice = StringUtils.formatStr(doc.getElementsByClass("emergency").first().html());
            treatAdvice = treatAdvice.substring(treatAdvice.indexOf("<p>"));
            bo.setTreatmentAdvice(treatAdvice);
            list.add(bo);
        }
        File file = new File(Constant.path_postParam);
        FileUtils.writeStringToFile(file, new Gson().toJson(list), Constant.ENCODE);
    }

    @Override
    public void crawDiseaseDetails() throws Exception {
        CrawDisease(null);
    }

    /**
     * 可指定抓取某个症状下的disease.
     * 
     * @param desc
     * @throws IOException
     * @throws Exception
     */
    private void CrawDisease(String desc) throws IOException, Exception {
        initDescFieldMap(Constant.path_desc_field);
        listExistingDisease = getExistingDisease(); // 已入库的disease数据
        File file = new File(Constant.path_postParam);
        String json = FileUtils.readFileToString(file, Constant.ENCODE);
        List<DiseasePostParamBo> list = new ArrayList<>();// 症状名，症状url,post参数
        list = new Gson().fromJson(json, new TypeToken<List<DiseasePostParamBo>>() {
        }.getType());
        for (DiseasePostParamBo postBo : list) {
            if (desc != null && !desc.equals(postBo.getSymptomName())) {
                continue;
            }
            int RepeatTime = Constant.RepeatTime; // 每种病症随机查X次数据
            logging.log.warn("postUrl(重复" + RepeatTime + "次):" + postBo.getSymptomName() + postBo.getUrl());
            while (RepeatTime-- > 0) {
                getDiseaseDataAndInsertByRandom(postBo);
            }
        }
    }

    /**
     * 获取当前数据库中已有的数据，避免重复查询入库.
     * 
     * @return
     */
    public List<String> getExistingDisease() {
        return drmedDao.selectExistingDisease();
    }

    /**
     * 随机构造入参，获取disease数据，并入库.
     * 
     * @param postBo
     * @throws Exception
     */
    private void getDiseaseDataAndInsertByRandom(DiseasePostParamBo postBo) throws Exception {
        List<NameValuePair> param = buildPostParamByRandom(postBo);
        Document doc = HttpUtils.jsoupPostDoc(postBo.getUrl(), param);
        // File file1 = new File("test/com/zxiaofan/testData/headaches-adult-A4-H11.html");
        // String json1 = FileUtils.readFileToString(file1);
        // Document doc = Jsoup.parse(json1);
        Elements elesDisease = doc.getElementsByClass("specifics").first().getElementsByClass("disease");
        Elements elesDiv = doc.getElementsByClass("specifics").first().select("div");
        String urlDisease = ""; // 疾病绝对url
        for (int i = 1; i < elesDisease.size(); i++) {
            Element disease = elesDisease.get(i);
            Element div = elesDiv.get(i);
            // 构造入库model
            DiseaseDetailsBo bo = new DiseaseDetailsBo();
            bo.setDiseaseName(disease.ownText());
            urlDisease = Constant.url_base + disease.select("a[href]").attr("href");
            bo.setUrlDisease(urlDisease);
            Elements lis = div.select("li");
            Map<String, String> mapli = new HashMap<>();
            String[] arr;
            for (Element li : lis) {
                arr = li.text().replaceAll(" ", "").split("：");
                if (!mapli.containsKey(arr[0])) {
                    mapli.put(arr[0], "|" + arr[1] + "|");
                } else {
                    mapli.put(arr[0], mapli.get(arr[0]) + arr[1] + "|");
                }
            }
            if (mapli.isEmpty()) {
                continue;
            }
            Map<String, String> map = null;
            if (listExistingDisease.contains(bo.getDiseaseName())) {// 数据库已存在当前disease，判断是否需要更新
                Map<String, String> detailsMap = drmedDao.getDiseaseBykeyId(ChineseToEnglish.creatKeyId(bo.getDiseaseName()));
                map = isNeedUpdateDisease(mapli, detailsMap);
                if (map == null) {
                    continue;
                } else {
                    logging.log.warn("Disease数据即将更新:" + bo.getDiseaseName() + ",原数据:" + detailsMap + ",新数据:" + map);
                    mapli = map;
                }
            }
            // get disease 详细
            Document docDisease = HttpUtils.JsoupGetDoc(urlDisease);
            if (docDisease == null) {
                logging.log.warn(bo.getDiseaseName() + "获取详细时返回null,URL:" + urlDisease);
                if (urlDisease.contains(" ")) {
                    urlDisease = urlDisease.replaceAll(" ", "-");
                    docDisease = HttpUtils.JsoupGetDoc(urlDisease);
                    if (docDisease == null) {
                        logging.log.warn(bo.getDiseaseName() + "获取详细时返回null,URL:" + urlDisease);
                    } else {
                        logging.log.warn(bo.getDiseaseName() + "获取详细 正常,URL:" + urlDisease);
                    }
                } else {
                    continue;
                }
            }
            String summary = docDisease.getElementsByClass("textarea").first().html(); // 将标签一起存入数据库，便于后期展示
            // summary = summary.substring(summary.indexOf(" ") + 1);
            mapli.put("概述", summary);
            Elements elesGuide = docDisease.getElementById("content_side").getElementsByClass("guide").select("a[href]");
            Document doc1;
            String value;
            Element ele;
            String desc;
            for (int j = 1; j < elesGuide.size(); j++) {
                ele = elesGuide.get(j);
                doc1 = HttpUtils.JsoupGetDoc(ele.attr("abs:href"));
                desc = ele.text();
                desc = desc.substring(desc.indexOf(".") + 1).replaceAll(" ", "");
                value = doc1.getElementsByClass("textarea").first().html();
                // value = value.substring(value.indexOf(" ") + 1);
                mapli.put(desc, value);
            }
            boolean setSpecial = true;
            for (Entry<String, String> entry : mapli.entrySet()) {
                setSpecial = setSpecialAttribute(entry.getKey(), entry.getValue(), bo);
                if (!setSpecial) {
                    logging.log.error("setSpecialAttribute异常,其url为:" + bo.getUrlDisease());
                    break;
                }
            }
            if (!setSpecial) {
                continue; // 只要有一个属性设置失败，就不入库了
            }
            if (map != null) { // 数据需要更新
                if (drmedDao.updateDiseaseByKeyId(bo)) {
                    logging.log.warn("更新成功:" + bo.getDiseaseName());
                } else {
                    logging.log.warn("更新失败:" + bo.getDiseaseName());
                }
                continue;
            }
            // 入库成功，则加入map
            if (drmedDao.insertDiseaseOne(bo)) {
                listExistingDisease.add(bo.getDiseaseName());
                logging.log.warn("入库成功:" + bo.getDiseaseName());
            }
        }
        logging.log.warn("--------------------");
    }

    /**
     * 数据库中已有disease，判断是否需要更新数据.
     * 
     * @param mapli
     *            网页新抓数据
     * @param detailsMap
     *            数据库原有数据
     * @return
     */
    private Map<String, String> isNeedUpdateDisease(Map<String, String> mapli, Map<String, String> detailsMap) {
        Map<String, String> map = new HashMap<>(mapli); // 若直接赋值，两map一旦改变将互相影响
        boolean bool = true; // 需要更新
        for (Entry<String, String> entry : mapli.entrySet()) {
            String value = detailsMap.get(descFieldMap.get(entry.getKey())); // 数据库中的字段值
            String newValue = entry.getValue(); // 此处存新抓网页数据；下面才表示入库value
            List<String> listold = new ArrayList<>();
            List<String> listnew = new ArrayList<>();
            if (!newValue.equals(value)) {
                if (value != null) {
                    listold = new ArrayList<>(Arrays.asList(value.split("\\|"))); // aslist无法addAll
                }
                if (newValue != null) {
                    listnew = new ArrayList<>(Arrays.asList(newValue.split("\\|")));
                }
                if (value == null || !listold.containsAll(listnew)) { // listnew不可能为null，so无需考虑呢
                    bool = false;
                }
                listold.addAll(listnew);
                HashSet<String> set = new HashSet<>(listold);
                newValue = set.toString().replaceAll(", ", "|");
                newValue = newValue.substring(1, newValue.length() - 1) + "|";
            }
            map.put(entry.getKey(), newValue);
        }
        if (bool) {
            return null;
        }
        return map;
    }

    /**
     * 随机构造post参数.
     * 
     * @param bo
     * @return
     */
    private List<NameValuePair> buildPostParamByRandom(DiseasePostParamBo bo) {
        List<NameValuePair> list = new ArrayList<>();
        String[] arrParam = bo.getParam().split("\\|");
        int numMax = Math.min(5, arrParam.length);// 最多5个入参
        int index = 0; // 入参索引
        int num = (int) (Math.random() * (numMax - 1)) + 1; // 实际入参个数,不能为0
        for (int i = 0; i < num; i++) {
            index = (int) (Math.random() * arrParam.length);
            list.add(new BasicNameValuePair("specifics[]", arrParam[index]));
        }
        list.add(new BasicNameValuePair("emergency", bo.getTreatmentAdvice()));
        logging.log.warn("postParam:" + new Gson().toJson(list));
        logging.log.warn("细节如下:");
        return list;
    }

    /**
     * 初始化症状url map.
     * 
     */
    private static void initSymptomUrlsMap() {
        Map<String, String> symUrlsMap = new HashMap<>();
        Document docURL = HttpUtils.JsoupGetDoc(Constant.url_self_diagnosis);
        // Document docURL = Jsoup.parse(FileUtils.readFileToString(new File("test/com/zxiaofan/testData/drmed症状主页Response.html"), Constant.ENCODE));
        Elements elementsURL = docURL.select("#adult").select("a[href]");
        for (Element ele : elementsURL) {
            symUrlsMap.put(StringUtils.formatStr(ele.text()), ele.attr("abs:href")); // 症状，url
        }
        Constant.symptomUrlsMap = symUrlsMap;
    }
}
