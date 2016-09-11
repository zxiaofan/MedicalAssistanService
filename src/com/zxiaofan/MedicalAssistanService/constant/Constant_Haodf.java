/*
 * 文件名：Constant_Haodf.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Constant_Haodf.java
 * 修改人：yunhai
 * 修改时间：2016年5月4日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.constant;

/**
 * 
 * @author yunhai
 */
public class Constant_Haodf {
    // URL Start //
    /**
     * haodf查询医生/医院信息，url前缀.
     */
    public static String Url_Haodf_Doc_Prefix = "http://www.haodf.com/jibing/";

    /**
     * haodf查询医生信息，四川地区url后缀.
     */
    public static String Url_Haodf_Doc_Suffix_1 = "/daifu_1_sichuan.htm";

    public static String Url_Haodf_Doc_Suffix_2 = "/daifu_2_sichuan.htm";

    /**
     * haodf查询医生信息，全国地区url后缀.
     */
    public static String Url_Haodf_Doc_Suffix_ = "/daifu_1.htm";

    /**
     * haodf查询医院信息，四川地区url后缀(第1页).
     */
    public static String Url_Haodf_Hos_Suffix_Sichuan = "/yiyuan.htm?province=sichuan&page=";

    public static String Url_Haodf_Hos_Suffix_QuanGuo = "/yiyuan.htm?&page=";

    /**
     * 医院信息第N页,URL后缀.
     */
    public static String Url_Haodf_Hos_Suffix_Sichuan_Page = "&page=";

    /**
     * 医院列表前缀.
     */
    public static String Url_Haodf_Hos_List_Prefix = "http://www.haodf.com/yiyuan/";

    /**
     * 医院列表后缀.
     */
    public static String Url_Haodf_Hos_List_Suffix = "/list.htm";

    /**
     * 所有省份.
     */
    public static String Url_Haodf_Hos_List_All = "http://www.haodf.com/yiyuan/all/list.htm";

    // URL End //

    ////// local path //////
    public static String path_Polyphone = "WebContent/WEB-INF/config/Polyphone.ini";
}
