/*
 * 文件名：QueryDiseaseDataBusiness.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： QueryDiseaseDataBusiness.java
 * 修改人：yunhai
 * 修改时间：2016年4月26日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zxiaofan.MedicalAssistanService.business.IQueryDiseaseDataBusiness;
import com.zxiaofan.MedicalAssistanService.constant.Constant;
import com.zxiaofan.MedicalAssistanService.dao.IDrmedDao;
import com.zxiaofan.MedicalAssistanService.dao.IHaodfDao;
import com.zxiaofan.MedicalAssistanService.model.bo.DoctorsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.HospitalsInfoBo;
import com.zxiaofan.MedicalAssistanService.model.bo.MatchedDiseaseBo;
import com.zxiaofan.MedicalAssistanService.model.vo.DetailsFeaturesVo;
import com.zxiaofan.MedicalAssistanService.util.StringUtils;

/**
 * @author yunhai
 */
@Component("queryDiseaseDataBusiness")
public class QueryDiseaseDataBusiness implements IQueryDiseaseDataBusiness {
    @Resource(name = "drmedDao")
    private IDrmedDao drmedDao;

    @Resource(name = "haodfDao")
    private IHaodfDao haodfDao;

    private final int returnDiseaseNum = 16; // 返回的疾病数量的最大值

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<DetailsFeaturesVo> queryMatchedDisease(List<String> listParam) {
        List<MatchedDiseaseBo> list = queryMatchedDiseaseKeyId(listParam);
        List<MatchedDiseaseBo> listget = new ArrayList<>();
        int num2 = 0;
        for (int i = 0; i < list.size(); i++) {
            MatchedDiseaseBo bo = list.get(i);
            listget.add(bo);
            if (bo.getRank() > 1) {
                num2++;
            }
            // 权重大于等于2的数据达到7条时，则不返回权重为1的数据
            // 有权重大于等于2的数据时，则权重为1的数据最多返回6条
            if ((num2 > 6 && bo.getRank() < 2) || (num2 > 0 && bo.getRank() < 2 && i > 6)) {
                break;
            }
        }
        List<DetailsFeaturesVo> listResult = drmedDao.queryMatchedDisease(listget);
        Map<String, DetailsFeaturesVo> map = new HashMap<>();
        for (DetailsFeaturesVo vo : listResult) {
            map.put(vo.getKeyId(), vo);
        }

        List<DetailsFeaturesVo> result = new ArrayList<>();
        for (MatchedDiseaseBo bo : listget) {
            DetailsFeaturesVo votemp = new DetailsFeaturesVo();
            votemp = map.get(bo.getKeyId());
            votemp.setRank(bo.getRank());
            result.add(votemp);
        }
        return result;
    }

    /**
     * 构造查询排名的sql.
     * 
     * @param listParam
     * @return
     */
    private String buildQueryRankSql(List<String> listParam) {
        StringBuffer buffer = new StringBuffer();
        Map<String, String> mapCharName = StringUtils.initNameCharMap(Constant.path_desc_field, 1, 2, false);
        String key, param;
        buffer.append("SELECT KeyId,DiseaseName,(");
        for (int i = 0; i < listParam.size(); i++) {
            param = listParam.get(i);
            key = mapCharName.get(param.charAt(0) + "");
            buffer.append("IF(MATCH (");
            buffer.append(key);
            buffer.append(") AGAINST (");
            buffer.append("'" + param + "'");
            buffer.append("),1,0)");
            if (i < listParam.size() - 1) {
                buffer.append("+");
            }
        }
        buffer.append(") as rank ");
        buffer.append("FROM disease_details_match WHERE ");
        buffer.append(Constant.sql_MatchAgainst);
        buffer.append(" ('");
        for (String par : listParam) {
            buffer.append(par + " ");
        }
        buffer.append("')");
        buffer.append(" ORDER BY rank DESC");
        return buffer.toString();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<MatchedDiseaseBo> queryMatchedDiseaseKeyId(List<String> listParam) {
        String sql = buildQueryRankSql(listParam);
        sql += " limit " + returnDiseaseNum + ";"; // 限制返回数量
        return drmedDao.queryMatchedDiseaseKeyId(sql);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<DoctorsInfoBo> queryDoctorsByDisease(String diseasePinyin) {
        return haodfDao.queryDoctorsByDisease(diseasePinyin);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<HospitalsInfoBo> queryHospitalsByDisease(String diseasePinyin) {
        return haodfDao.queryHospitalsByDisease(diseasePinyin);
    }

}
