/*
 * 文件名：StringUtils.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringUtils.java
 * 修改人：yunhai
 * 修改时间：2016年4月19日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.util;

/**
 * 
 * @author yunhai
 */

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ChineseToEnglish {
    /**
     * 生成KeyId.
     * 
     * @param param
     * @return
     */
    public static String creatKeyId(String param) {
        param = param.replaceAll(" ", "").replaceAll("（", "").replaceAll("）", "").replaceAll("\\)", "").replaceAll("\\(", "");
        StringBuffer buffer = new StringBuffer(getPingYin(param));
        StringBuffer bufferASCII = new StringBuffer(getCnASCII(param));
        StringBuffer result = new StringBuffer();
        int index = buffer.length();
        int i = 0;
        if (index >= 16) {
            while (result.length() < 16) {
                result.append(buffer.charAt(i));
                i = (i + 5) % index;
            }
        }
        if (index < 16) {
            result.append(buffer);
            while (result.length() < 16) {
                if (index == 5) {
                    index = 3;
                }
                i = (i + 5) % index;
                result.append(bufferASCII.charAt(i));
            }
        }
        return result.toString();
    }

    // 将汉字转换为全拼
    public static String getPingYin(String src) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];
                } else
                    t4 += java.lang.Character.toString(t1[i]);
            }
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    // 将汉字转换为全拼,并替换部分多音字
    public static String getPingYinOk(String src) {
        src = getPingYin(src);
        src = src.replaceAll("bangguang", "pangguang");
        return src;
    }

    // 返回中文的首字母
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    // 将字符串转移为ASCII码
    public static String getCnASCII(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bGBK = cnStr.getBytes();
        for (int i = 0; i < bGBK.length; i++) {
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
        }
        return strBuf.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPingYin("小（繁("));
        System.out.println(getPinYinHeadChar("小xiaofan繁"));
        System.out.println(getCnASCII("小（繁"));
    }
}
