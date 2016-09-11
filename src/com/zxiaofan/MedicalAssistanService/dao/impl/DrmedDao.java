/*
 * 文件名：DrmedDao.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DrmedDao.java
 * 修改人：yunhai
 * 修改时间：2016年4月19日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.zxiaofan.MedicalAssistanService.dao.IDrmedDao;
import com.zxiaofan.MedicalAssistanService.dao.SQLAdapter;
import com.zxiaofan.MedicalAssistanService.model.bo.DiseaseDetailsBo;
import com.zxiaofan.MedicalAssistanService.model.bo.FeatureMapBo;
import com.zxiaofan.MedicalAssistanService.model.bo.MatchedDiseaseBo;
import com.zxiaofan.MedicalAssistanService.model.bo.SymptomDetailsBo;
import com.zxiaofan.MedicalAssistanService.model.vo.DetailsFeaturesVo;
import com.zxiaofan.MedicalAssistanService.util.ChineseToEnglish;

/**
 * 
 * @author yunhai
 */
@Component("drmedDao")
public class DrmedDao extends BaseDaoImpl implements IDrmedDao {

    @Override
    public boolean insertOne(SymptomDetailsBo bo) {
        boolean result = false;
        bo.setTableName("symptom_details");
        bo.setModifyTime(new Date());
        if (bo.getIsAdult() == 0) {
            bo.setKeyId(ChineseToEnglish.creatKeyId(bo.getSymptomName() + "child"));
        } else {
            bo.setKeyId(ChineseToEnglish.creatKeyId(bo.getSymptomName()));
        }
        try {
            result = sqlSessionWrite.insert("drmedData.insertOne", bo) > 0;
        } catch (Exception e) {
            if (e.getCause().getMessage().contains("Duplicate entry")) {
                logging.log.error(e.getCause().getMessage() + ",症状名：" + new Gson().toJson(bo));
            } else {
                logging.log.error(e.getMessage() + "insertOne:" + new Gson().toJson(bo));
            }
        }
        return result;
    }

    @Override
    public boolean insertDiseaseOne(DiseaseDetailsBo bo) {
        boolean result = false;
        bo.setTableName("disease_details");
        bo.setModifyTime(new Date());
        bo.setKeyId(ChineseToEnglish.creatKeyId(bo.getDiseaseName()));
        try {
            result = sqlSessionWrite.insert("drmedData.insertDiseaseOne", bo) > 0;
        } catch (Exception e) {
            if (e.getCause().getMessage().contains("Duplicate entry")) {
                logging.log.error(e.getCause().getMessage() + ",疾病名：" + bo.getDiseaseName());
            } else {
                logging.log.error(e.getCause().getMessage() + ",insertDiseaseOne:" + new Gson().toJson(bo));
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<String> selectExistingDisease() {
        // String sql = "SELECT DiseaseName FROM disease_details ";
        List<String> queryResultList = null;
        try {
            queryResultList = sqlSessionRead.selectList("drmedData.selectExistingDisease");
        } catch (Exception e) {
            logging.log.error(e.getCause().getMessage());
        }
        logging.log.warn("selectExistingDisease:" + queryResultList);
        return queryResultList;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Map<String, String> getDiseaseBykeyId(String keyId) {
        Map<String, String> map = null;
        try {
            map = sqlSessionRead.selectOne("drmedData.getDiseaseBykeyId", keyId);
        } catch (Exception e) {
            logging.log.error("getDiseaseBykeyId:" + e.getCause().getMessage());
        }
        return map;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean updateDiseaseByKeyId(DiseaseDetailsBo bo) {
        boolean result = false;
        if (bo.getTableName() == null || "".equals(bo.getTableName())) {
            bo.setTableName("disease_details");
        }
        bo.setModifyTime(new Date());
        bo.setKeyId(ChineseToEnglish.creatKeyId(bo.getDiseaseName()));
        try {
            result = sqlSessionWrite.update("drmedData.updateDiseaseByKeyId", bo) > 0;
        } catch (Exception e) {
            if (e.getCause().getMessage().contains("Duplicate entry")) {
                logging.log.error(e.getCause().getMessage() + ",疾病名：" + bo.getDiseaseName());
            } else {
                logging.log.error(e.getCause().getMessage() + ",updateDiseaseByKeyId:" + new Gson().toJson(bo));
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<SymptomDetailsBo> querySymptoms() {
        List<SymptomDetailsBo> queryResultList = null;
        List<Map<String, String>> list = new ArrayList<>();
        try {
            queryResultList = sqlSessionRead.selectList("drmedData.querySymptoms");
        } catch (Exception e) {
            logging.log.error(e.getCause().getMessage());
        }
        return queryResultList;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean insertFeatureMap(List<FeatureMapBo> list) {
        boolean result = false;
        try {
            result = sqlSessionWrite.insert("drmedData.insertFeatureMap", list) > 0;
        } catch (Exception e) {
            if (e.getCause().getMessage().contains("Duplicate entry")) {
                logging.log.error(e.getCause().getMessage());
            } else {
                logging.log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<DiseaseDetailsBo> queryAllDiseaseFeature() {
        List<DiseaseDetailsBo> queryResultList = null;
        try {
            queryResultList = sqlSessionRead.selectList("drmedData.queryAllDiseaseFeature");
        } catch (Exception e) {
            logging.log.error(e.getCause().getMessage());
        }
        return queryResultList;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<MatchedDiseaseBo> queryMatchedDiseaseKeyId(String sql) {
        List<MatchedDiseaseBo> queryResultList = null;
        try {
            queryResultList = sqlSessionRead.selectList("queryServiceMapper.queryMatchedDiseaseKeyId", new SQLAdapter(sql));
        } catch (Exception e) {
            logging.log.error(e.getCause().getMessage() + "sql:" + sql);
        }
        return queryResultList;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<DetailsFeaturesVo> queryMatchedDisease(List<MatchedDiseaseBo> listKeyId) {
        List<DetailsFeaturesVo> queryResultList = null;
        try {
            queryResultList = sqlSessionRead.selectList("queryServiceMapper.queryMatchedDisease", listKeyId);
        } catch (Exception e) {
            e.printStackTrace();
            logging.log.error(e.getCause().getMessage());
        }
        return queryResultList;
    }
}
