/*
 * 文件名：EnumdescField.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： EnumAPI.java
 * 修改人：yunhai
 * 修改时间：2016年4月19日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.Enum;

/**
 * 
 * @author yunhai
 */
public enum EnumAPI {
    success("success", "success"), fail_error("fail_error", "error"), fail_illegal("fail_illegal", "非法参数(参数5到15位.用户名必须为字母或数字,密码至少包含字母和数字)"), //
    existUser("existUser", "该用户已注册");
    private final String value;

    private final String desc;

    private EnumAPI(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * 设置value.
     * 
     * @return 返回value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置desc.
     * 
     * @return 返回desc
     */
    public String getDesc() {
        return desc;
    }
}
