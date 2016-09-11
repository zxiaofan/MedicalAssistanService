/*
 * 文件名：APIDao.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： APIDao.java
 * 修改人：yunhai
 * 修改时间：2016年5月26日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.zxiaofan.MedicalAssistanService.Enum.EnumAPI;
import com.zxiaofan.MedicalAssistanService.dao.IAPIDao;
import com.zxiaofan.MedicalAssistanService.model.bo.UserInfoBo;

/**
 * @author yunhai
 */
@Component("apiDao")
public class APIDao extends BaseDaoImpl implements IAPIDao {

    /**
     * {@inheritDoc}.
     */
    @Override
    public String register(UserInfoBo bo) {
        if (existUser(bo.getUserName())) {
            return EnumAPI.existUser.getDesc();
        }
        bo.setModifyTime(new Date());
        int result = Integer.MIN_VALUE;
        try {
            result = sqlSessionWrite.insert("apiMapper.register", bo);
        } catch (Exception e) {
            e.printStackTrace();
            logging.log.error("注册入库异常:" + e.getMessage() + "注册信息:" + new Gson().toJson(bo));
        }
        if (result > 0) {
            return EnumAPI.success.getValue();
        }
        return EnumAPI.fail_error.getDesc();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean login(UserInfoBo bo) {
        String query = "";
        try {
            query = sqlSessionRead.selectOne("apiMapper.login", bo);
        } catch (Exception e) {
            e.printStackTrace();
            logging.log.error(e.getCause().getMessage() + new Gson().toJson(bo));
        }
        return bo.getUserName().equals(query) ? true : false; // query可能为null，置后
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean existUser(String name) {
        String query = "";
        try {
            query = sqlSessionRead.selectOne("apiMapper.existUser", name);
        } catch (Exception e) {
            e.printStackTrace();
            logging.log.error(e.getCause().getMessage());
        }
        return name.equals(query) ? true : false; // query可能为null，置后
    }

}
