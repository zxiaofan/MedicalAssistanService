/*
 * 文件名：HaodfDao.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HaodfDao.java
 * 修改人：yunhai
 * 修改时间：2016年5月4日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.zxiaofan.MedicalAssistanService.dao.IHaodfDao;
import com.zxiaofan.MedicalAssistanService.dao.SQLAdapter;
import com.zxiaofan.MedicalAssistanService.model.bo.DoctorsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.HospitalsInfoBo;

/**
 * @author yunhai
 */
@Component("haodfDao")
public class HaodfDao extends BaseDaoImpl implements IHaodfDao {

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean insertHaodfDoc(DoctorsInfoBo bo) {
        boolean result = false;
        bo.setModifyTime(new Date());
        try {
            result = sqlSessionWrite.insert("drmedData.insertHaodfDocOne", bo) > 0;
        } catch (Exception e) {
            logging.log.error(e.getMessage() + "insertHaodfDocOne:" + new Gson().toJson(bo));
            e.printStackTrace();
            return false;
        }
        if (!result) {
            logging.log.warn(bo.getDocHospital() + "-" + bo.getDocDepart() + "-" + bo.getDocName() + "-" + bo.getDiseaseName() + "-【入库失败】");
        } else {
            logging.log.warn(bo.getDocHospital() + "-" + bo.getDocDepart() + "-" + bo.getDocName() + "-" + bo.getDiseaseName() + "-【入库成功】");
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean insertHaodfHos() {
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<String> getKeyIdByDiseaseNamePinYin(String diseaseNamePinYin) {
        List<String> result = null;
        String sql = buildGetKeyIdSql(diseaseNamePinYin, "DiseaseNamePinYin", "doctors_info", "KeyId");
        try {
            result = sqlSessionRead.selectList("drmedData.getKeyIdByDiseaseNamePinYin", new SQLAdapter(sql));
        } catch (Exception e) {
            logging.log.error(e.getMessage() + "getKeyIdByDiseaseNamePinYin:" + sql);
        }
        return result;
    }

    /**
     * 构造查询KeyId的sql.
     * 
     * @param against
     *            against
     * @param match
     *            待匹配字段
     * @param tableName
     *            表名
     * @param selectField
     *            待查询字段
     * @return
     */
    private String buildGetKeyIdSql(String against, String match, String tableName, String selectField) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT ").append(selectField);
        buffer.append(" FROM ").append(tableName);
        if (against == null || "".equals(against)) {
            return buffer.toString();
        }
        buffer.append(" WHERE MATCH (");
        buffer.append(match).append(")");
        buffer.append(" AGAINST");
        buffer.append(" (\"");
        buffer.append(against);
        buffer.append("\")");
        return buffer.toString();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<DoctorsInfoBo> queryAllKeyIdAndDiseaseName() {
        List<DoctorsInfoBo> result = null;
        try {
            result = sqlSessionRead.selectList("drmedData.queryAllKeyIdAndDiseaseName", "");
        } catch (Exception e) {
            logging.log.error(e.getMessage() + "queryAllKeyIdAndDiseaseName.");
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean updateDocDiseaseByKeyId(DoctorsInfoBo bo) {
        boolean result = false;
        bo.setModifyTime(new Date());
        try {
            result = sqlSessionWrite.update("drmedData.updateDocDiseaseByKeyId", bo) > 0;
        } catch (Exception e) {
            if (e.getCause().getMessage().contains("Duplicate entry")) {
                logging.log.error(e.getCause().getMessage() + ",疾病名：" + bo.getDiseaseName());
            } else {
                logging.log.error(e.getCause().getMessage() + ",updateDocDiseaseByKeyId:" + new Gson().toJson(bo));
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean insertHaodfHos(HospitalsInfoBo bo) {
        boolean result = false;
        bo.setModifyTime(new Date());
        try {
            result = sqlSessionWrite.insert("drmedData.insertHaodfHosOne", bo) > 0;
        } catch (Exception e) {
            logging.log.error(e.getMessage() + "insertHaodfHosOne:" + new Gson().toJson(bo));
            e.printStackTrace();
            return false;
        }
        if (!result) {
            logging.log.warn("【医院信息入库失败】:" + bo.getHospitalCity() + "-" + bo.getHospitalName());
        } else {
            logging.log.warn("【医院信息入库成功】:" + bo.getHospitalCity() + "-" + bo.getHospitalName());
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean updateHaodfHos(HospitalsInfoBo bo) {
        boolean result = false;
        bo.setModifyTime(new Date());
        try {
            result = sqlSessionWrite.update("drmedData.updateHaodfHos", bo) > 0;
        } catch (Exception e) {
            logging.log.error(e.getMessage() + "updateHaodfHos:" + new Gson().toJson(bo));
            e.printStackTrace();
            return false;
        }
        if (!result) {
            logging.log.warn("【医院信息更新失败】:" + bo.getHospitalCity() + "-" + bo.getHospitalName() + "-" + bo.getDiseaseName());
        } else {
            logging.log.warn("【医院信息更新成功】:" + bo.getHospitalCity() + "-" + bo.getHospitalName() + "-" + bo.getDiseaseName());
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<String> queryHosByProvence(String provence) {
        List<String> result = null;
        try {
            result = sqlSessionRead.selectList("drmedData.queryHosByProvence", provence);
        } catch (Exception e) {
            logging.log.error(e.getMessage() + ",queryHosByProvence:" + provence);
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<HospitalsInfoBo> queryExistHos() {
        // String pinyin = ChineseToEnglish.getPingYin(diseaseName);
        // if (pinyin.contains("bangguang")) {
        // pinyin = pinyin.replaceAll("bangguang", "pangguang");
        // }
        List<HospitalsInfoBo> result = null;
        String sql = buildGetKeyIdSql(null, "DiseaseNamePinYin", "Hospitals_Info", "HospitalName,DiseaseName,DiseaseNamePinYin");
        try {
            result = sqlSessionRead.selectList("drmedData.queryExistHosByDisease", new SQLAdapter(sql));
        } catch (Exception e) {
            logging.log.error(e.getMessage() + ",queryExistHosByDisease:" + sql);
        }
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<DoctorsInfoBo> queryDoctorsByDisease(String diseasePinyin) {
        String selectField = "`KeyId`, `DocName`, `DocTitle`, `DocHospital`, `DocDepart`, `RecommendHeat`, `DocAdept`, `PracticeExperience`, `ThanksLetterNum`, `UrlDoc`, `ModifyTime`";
        String sql = buildGetKeyIdSql("|" + diseasePinyin + "|", "DiseaseNamePinYin", "doctors_info", selectField);
        // 医生推荐默认按照感谢信数量和推荐热度排序
        sql += " ORDER BY ThanksLetterNum DESC,RecommendHeat DESC;";
        List<DoctorsInfoBo> list = null;
        try {
            list = sqlSessionRead.selectList("queryServiceMapper.queryDoctorsByDisease", new SQLAdapter(sql));
        } catch (Exception e) {
            logging.log.error(e.getMessage() + ",queryDoctorsByDisease:" + sql);
        }
        return list;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<HospitalsInfoBo> queryHospitalsByDisease(String diseasePinyin) {
        String selectField = "`HospitalName`, `HospitalProvince`, `HospitalCity`, `HospitalLevel`, `Address`, `TelePhone`, `ThanksLetterNum`, `Url`, `ModifyTime`";
        String sql = buildGetKeyIdSql("|" + diseasePinyin + "|", "DiseaseNamePinYin", "Hospitals_Info", selectField);
        // 默认优先展示四川成都地区的医院，随后按照感谢信数量和医院等级展示。
        sql += " ORDER BY HospitalProvince='四川' DESC,HospitalCity='成都' DESC,ThanksLetterNum DESC,HospitalLevel DESC;";
        List<HospitalsInfoBo> list = null;
        try {
            list = sqlSessionRead.selectList("queryServiceMapper.queryHospitalsByDisease", new SQLAdapter(sql));
        } catch (Exception e) {
            logging.log.error(e.getMessage() + ",queryDoctorsByDisease:" + sql);
        }
        return list;
    }
}
