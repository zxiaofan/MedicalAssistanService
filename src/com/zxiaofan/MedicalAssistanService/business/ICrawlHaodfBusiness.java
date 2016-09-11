/*
 * 文件名：ICrawHaodfBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ICrawHaodfBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年5月4日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business;

/**
 * @author yunhai
 */
public interface ICrawlHaodfBusiness {
    /**
     * 抓取haodf医生信息.
     * 
     */
    public void crawHaodfDoc(String diseaseName);

    /**
     * 抓取haodf医院信息By disease.
     * 
     */
    public void crawHaodfHos(String diseaseName);

    /**
     * 抓取haodf医院信息 By 省份.
     * 
     */
    public void crawHaodfHosList(String provence);
}
