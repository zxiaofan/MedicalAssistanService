/*
 * 文件名：IDataWriteBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IDataWriteBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年4月21日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

import java.util.Map;

import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;

/**
 * 
 * @author yunhai
 */
public interface IDataWriteBusiness {
    public boolean insertAllSymptomDetails(Map<String, SymptomDetailsBo> map);

    public boolean insertOne(SymptomDetailsBo bo);
}
