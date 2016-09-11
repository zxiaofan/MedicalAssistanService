/*
 * 文件名：SQLAdapter.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SQLAdapter.java
 * 修改人：yunhai
 * 修改时间：2016年4月30日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao;

/**
 * @author yunhai
 */
public class SQLAdapter {
    String sql;

    public SQLAdapter(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
