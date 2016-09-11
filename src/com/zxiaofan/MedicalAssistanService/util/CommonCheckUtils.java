package com.zxiaofan.MedicalAssistanService.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常规检查辅助类.
 * 
 * @author yunhai
 *
 */
public class CommonCheckUtils {

    /**
     * 添加方法注释.
     * 
     * @param value
     *            校验参数
     * @return true or false
     */
    public static boolean isNull(String value) {
        if (null == value || value.trim().isEmpty() || "null".equals(value.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 添加方法注释.
     * 
     * @param o
     *            校验参数
     * @return true or false
     */
    public static boolean isNotEmpty(Object... o) {
        if (null != o && o.length > 0) {
            for (Object obj : o) {
                if (null == obj) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 添加方法注释.
     * 
     * @param s
     *            校验参数
     * @return true or false
     */
    public static boolean isNotEmpty(String... s) {
        if (null != s && s.length > 0) {
            for (String str : s) {
                if (null == str || "".equals(str.trim())) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 添加方法注释.
     * 
     * @param o
     *            校验参数
     * @return true or false
     */
    public static boolean isEmpty(Object... o) {
        if (null == o || o.length == 0) {
            return true;
        }
        for (Object obj : o) {
            if (null != obj) {
                return false;
            }
        }
        return true;
    }

    /**
     * 添加方法注释.
     * 
     * @param c
     *            校验map
     * @return true or false
     */
    public static boolean isNotEmpty(Map<?, ?> c) {
        if (null != c && !c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 添加方法注释.
     * 
     * @param c
     *            校验map
     * @return true or false.
     */
    public static boolean isEmpty(Map<?, ?> c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 添加方法注释.
     * 
     * @param c
     *            校验集合
     * @return true or false
     */
    public static boolean isNotEmpty(Collection<?> c) {
        if (null != c && !c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 添加方法注释.
     * 
     * @param c
     *            校验集合
     * @return true or false
     */
    public static boolean isEmpty(Collection<?> c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 添加方法注释.
     * 
     * @param str
     *            字符串
     * @return true or false
     */
    public static boolean isEmpty(String str) {
        if (null == str || str.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 添加方法注释.
     * 
     * @param str
     *            校验集合
     * @return true or false
     */
    public static boolean isNotEmpty(String str) {
        if (null != str && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 是否是11位手机号码.
     * 
     * @param phoneNo
     *            手机号码
     * @return true or false
     */
    public static boolean validPhoneNo(String phoneNo) {
        if (isNotEmpty(phoneNo)) {
            return phoneNo.matches("^1\\d{10}");
        }
        return false;
    }

    /**
     * 是否是数字.
     * 
     * @param value
     *            手机号码
     * @return true or false
     */
    public static boolean isNumber(String value) {
        if (isNotEmpty(value)) {
            return value.matches("\\d+");
        }
        return false;
    }

    /**
     * 校验邮箱.
     * 
     * @param email
     *            邮箱
     * @return true or false
     */
    public static boolean emailFormat(String email) {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[_|-|//.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
}
