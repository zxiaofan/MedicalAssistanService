/*
 * 文件名：IDrmedDao.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IDrmedDao.java
 * 修改人：yunhai
 * 修改时间：2016年4月18日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao;

import java.util.List;
import java.util.Map;

import com.zxiaofan.MedicalAssistanService.model.bo.DiseaseDetailsBo;
import com.zxiaofan.MedicalAssistanService.model.bo.FeatureMapBo;
import com.zxiaofan.MedicalAssistanService.model.bo.MatchedDiseaseBo;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;
import com.zxiaofan.MedicalAssistanService.model.vo.DetailsFeaturesVo;

/**
 * 
 * @author yunhai
 */
public interface IDrmedDao {
    /**
     * 写入所有症状信息.
     * 
     * @param map
     *            症状集合map
     * @return 结果
     */
    // public boolean insertAllSymptomDetails(List<SymptomDetailsBo> map);

    /**
     * 写入单条症状信息.
     * 
     * @param bo
     *            症状
     * @return 结果
     */
    public boolean insertOne(SymptomDetailsBo bo);

    /**
     * 写入单条疾病信息.
     * 
     * @param bo
     *            疾病
     * @return 结果
     */
    public boolean insertDiseaseOne(DiseaseDetailsBo bo);

    /**
     * get数据库中一有的disease数据.
     * 
     */
    public List<String> selectExistingDisease();

    /**
     * 查询匹配的disease.
     * 
     * @param list
     */
    public List<DetailsFeaturesVo> queryMatchedDisease(List<MatchedDiseaseBo> list);

    /**
     * 通过KeyId获取Disease数据.
     * 
     * @param creatKeyId
     * @return
     */
    public Map<String, String> getDiseaseBykeyId(String keyId);

    /**
     * 根据KeyId更新disease数据.
     * 
     * @param bo
     * @return
     */
    public boolean updateDiseaseByKeyId(DiseaseDetailsBo bo);

    /**
     * 查询症状.
     * 
     * @return
     */
    public List<SymptomDetailsBo> querySymptoms();

    /**
     * 插入feature Map数据.
     * 
     * @param list
     * @return
     */
    public boolean insertFeatureMap(List<FeatureMapBo> list);

    /**
     * 查询所有disease的feature字段.
     * 
     * @return
     */
    public List<DiseaseDetailsBo> queryAllDiseaseFeature();

    /**
     * 查询匹配的KeyId等数据信息.
     * 
     * @param sql
     * @return
     */
    public List<MatchedDiseaseBo> queryMatchedDiseaseKeyId(String sql);

}
