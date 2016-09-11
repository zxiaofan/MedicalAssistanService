package com.zxiaofan.MedicalAssistanService.dao;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * 提供数据库连接.
 * 
 * @author 云海
 *
 */
public interface IBaseDao {
    /**
     * 设置读库接口.
     * 
     * @param sqlSessionTemplate
     *            数据库模板类
     */
    void setSqlSessionRead(SqlSessionTemplate sqlSessionTemplate);

    /**
     * 设置写库接口.
     * 
     * @param sessionTemplate
     *            数据库模板类
     */
    void setSqlSessionWrite(SqlSessionTemplate sessionTemplate);

    /**
     * 设置库接口.
     * 
     * @param sessionTemplate
     *            数据库模板类
     */
    void setSqlSession(SqlSessionTemplate sessionTemplate);

    /**
     * 获取读库接口.
     * 
     * @return 数据库模板类
     */
    SqlSessionTemplate getSqlSessionRead();

    /**
     * 获取写库接口.
     * 
     * @return 数据库模板类
     */
    SqlSessionTemplate getSqlSessionWrite();

    /**
     * 获取库接口.
     * 
     * @return 数据库模板类
     */
    SqlSessionTemplate getSqlSession();
}
