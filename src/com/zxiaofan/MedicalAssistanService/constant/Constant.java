/*
 * 文件名：Constant.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Constant.java
 * 修改人：yunhai
 * 修改时间：2016年4月18日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yunhai
 */
public class Constant {
    public static final String ENCODE = "UTF-8";

    public static final int timeOut = 15000;

    public static final int RepeatTime = 8; // 每种病症随机查8次数据

    ////// URL //////
    /**
     * 选择一个症状.
     */
    public static String url_self_diagnosis = "http://www.drmed.cn/self-diagnosis";

    /**
     * 主页.
     */
    public static String url_base = "http://www.drmed.cn";

    ////// URL END //////

    ////// local path //////
    public static String path_desc_field = "com/zxiaofan/config/data/desc-field.ini";

    /**
     * 抓取疾病数据post参数存放位置.
     */
    public static String path_postParam = "src/com/zxiaofan/config/data/SymptomUrlParamMap.txt";

    /**
     * 抓取症状信息存放位置.
     */
    public static String path_Symptom_Details = "src/com/zxiaofan/config/data/Symptom_Details.txt";

    /**
     * 症状-键值 匹配 路径.
     */
    public static String path_Symptom_Key = "com/zxiaofan/config/data/Symptom_Key.txt";

    /**
     * Disease索引特征数据 路径.
     */
    public static String path_Disease_Feature_Key = "src/com/zxiaofan/config/data/Disease_Feature_Key.txt";

    ///// local path END /////
    /**
     * 症状连接url Map.
     */
    public static Map<String, String> symptomUrlsMap = new HashMap<>();

    /**
     * 疾病url Map(只存已入库的数据).
     */
    public static Map<String, String> diseaseUrlsMap = new HashMap<>();

    /**
     * 症状名，症状url|post参数.
     */
    public static Map<String, String> symptomUrlParamMap = new HashMap<>();

    /////

    //// SQL Start ////
    /**
     * 查询时match against的sql.
     */
    public static String sql_MatchAgainst = "MATCH (PainPerception,PainRegion,PainDuration,SymptomWorsen,OtherFeaturesOfPain,SymptomReason,SymptomRelieved,SymptomStart,SymptomWith,SymptomFelling,BloodPosition,OtherFeatures,Coughing,AffectedArea,SymptomAppears,SwallowFelling) AGAINST";

    //// SQL END ////
}
