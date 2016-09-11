/*
 * 文件名：ConstantApi.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ConstantApi.java
 * 修改人：yunhai
 * 修改时间：2016年5月26日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunhai
 */
public class ConstantApi {
    public static String Reg_Char_Num = "[a-zA-Z0-9]{5,15}";

    public static String Reg_Char_Num_Punctuation = "[a-zA-Z0-9\\.,]+";

    public static String Reg_Char_Pwd = "(?=.*[A-Za-z])(?=.*[0-9])[a-zA-Z0-9,.]{5,15}"; // 至少包含字母和数字，允许标点，5到15个字符

    public static Map<String, String> featureKeyMap = new HashMap<>(); // 症状-key("手臂疼痛":"I_67")
}
