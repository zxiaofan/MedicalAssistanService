/*
 * 文件名：IHaodfService.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IHaodfService.java
 * 修改人：yunhai
 * 修改时间：2016年5月5日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service;

/**
 * @author yunhai
 */
public interface IHaodfService {
    /**
     * craw Doc数据.
     * 
     */
    public void crawHaodfDoc();

    /**
     * craw Hos数据.
     * 
     */
    public void crawHaodfHos();

    /**
     * craw 医院列表数据.
     * 
     */
    public void crawHaodfHosList();
}
