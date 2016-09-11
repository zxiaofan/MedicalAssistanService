/*
 * 文件名：IAPIDao.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IAPIDao.java
 * 修改人：yunhai
 * 修改时间：2016年5月26日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao;

import com.zxiaofan.MedicalAssistanService.model.bo.UserInfoBo;

/**
 * API数据操作
 * 
 * @author yunhai
 */
public interface IAPIDao {
    /**
     * 注册账号.
     * 
     * @param bo
     *            注册信息
     * @return 注册结果
     */
    public String register(UserInfoBo bo);

    /**
     * 登陆.
     * 
     * @param name
     * @param pwd
     * @return 登陆结果
     */
    public boolean login(UserInfoBo bo);

    /**
     * 该用户是否存在.
     * 
     * @param name
     * @return 是否存在
     */
    public boolean existUser(String name);

}
