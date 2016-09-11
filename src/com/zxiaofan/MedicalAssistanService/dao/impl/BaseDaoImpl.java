package com.zxiaofan.MedicalAssistanService.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.zxiaofan.MedicalAssistanService.util.Logging;

/**
 * 获取数据库连接.
 * 
 * @author yunhai
 *
 */
@Component("baseDao")
public class BaseDaoImpl {

    @Resource(name = "logging")
    protected Logging logging;

    /**
     * 写库.
     */
    @Resource(name = "sqlSession")
    protected SqlSessionTemplate sqlSessionWrite;

    /**
     * 读库.
     */
    @Resource(name = "sqlSession")
    protected SqlSessionTemplate sqlSessionRead;

    /**
     * 设置sqlSessionWrite.
     * 
     * @return 返回sqlSessionWrite
     */
    public SqlSessionTemplate getSqlSessionWrite() {
        return sqlSessionWrite;
    }

    /**
     * 获取sqlSessionWrite.
     * 
     * @param sqlSessionWrite
     *            要设置的sqlSessionWrite
     */
    public void setSqlSessionWrite(SqlSessionTemplate sqlSessionWrite) {
        this.sqlSessionWrite = sqlSessionWrite;
    }

    /**
     * 设置sqlSessionRead.
     * 
     * @return 返回sqlSessionRead
     */
    public SqlSessionTemplate getSqlSessionRead() {
        return sqlSessionRead;
    }

    /**
     * 获取sqlSessionRead.
     * 
     * @param sqlSessionRead
     *            要设置的sqlSessionRead
     */
    public void setSqlSessionRead(SqlSessionTemplate sqlSessionRead) {
        this.sqlSessionRead = sqlSessionRead;
    }

}
