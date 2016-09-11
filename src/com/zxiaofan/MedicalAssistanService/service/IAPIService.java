/*
 * 文件名：IQueryMatchService.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IQueryMatchService.java
 * 修改人：yunhai
 * 修改时间：2016年4月30日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.service;

import javax.jws.WebService;

/**
 * 查询服务
 * 
 * @author yunhai
 */
@WebService
public interface IAPIService {
    /**
     * 根据disease的KeyId查询匹配的disease特征数据.
     * 
     * @param param
     *            症状
     * @return 匹配结果
     */
    public String queryDiseaseBySymptom(String param);

    /**
     * 查询匹配的disease的KeyId和DiseaseName.
     * 
     * @param param
     *            症状
     * @return 匹配的KeyId
     */
    public String queryDiseaseKeyIdBySymptom(String param);

    /**
     * 查询匹配的【医生信息】By DiseaseName.
     * 
     * @param DiseaseName
     *            疾病名（疾病名+KeyId <queryMatchedDiseaseKeyId直接返回结果> ）
     * @return 匹配的医生信息
     */
    public String queryDoctorsByDisease(String diseaseName);

    /**
     * 查询匹配的【医院信息】By DiseaseName.
     * 
     * @param DiseaseName
     *            疾病名（疾病名+KeyId <queryMatchedDiseaseKeyId直接返回结果> ）
     * @return 匹配的医院信息
     */
    public String queryHospitalsByDisease(String diseaseName);

    /**
     * 注册账号.
     * 
     * @param userInfo
     *            用户信息
     * @return 注册结果
     */
    public String register(String userInfo);

    /**
     * 登陆.
     * 
     * @param name
     * @param pwd
     * @return 登陆结果
     */
    public boolean login(String name, String pwd);
}
