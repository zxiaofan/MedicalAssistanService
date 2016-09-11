/*
 * 文件名：EnumdescField.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： EnumdescField.java
 * 修改人：yunhai
 * 修改时间：2016年4月19日
 * 修改内容：新增
 */
package com.zxiaofan.MedicalAssistanService.Enum;

/**
 * 
 * @author yunhai
 */
public enum EnumdescField {
    DiseaseName("疾病名", "DiseaseName"), PainPerception("疼痛的感觉", "PainPerception"), PainRegion("疼痛部位", "PainRegion"), //
    PainDuration("疼痛持续时间", "PainDuration"), SymptomWorsen("病症在什么情况下会恶化", "SymptomWorsen"), OtherFeaturesOfPain("疼痛的其它特征", "OtherFeaturesOfPain"), //
    SymptomReason("何种因素可引发此症状", "SymptomReason"), SymptomRelieved("何种做法可减轻症状", "SymptomRelieved"), SymptomStart("症状何时开始", "SymptomStart"), //
    SymptomWith("伴有", "SymptomWith"), SymptomFelling("你会感觉到", "SymptomFelling"), BloodPosition("血出现在", "BloodPosition"), OtherFeatures("症状的其它特征", "OtherFeatures"), //
    Coughing("咳嗽表现为", "Coughing"), AffectedArea("受影响或累及部位为", "AffectedArea"), SymptomAppears("病症出现在下面哪种情况之后", "SymptomAppears");
    private final String value;

    private final String desc;

    private EnumdescField(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * 设置value.
     * 
     * @return 返回value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置desc.
     * 
     * @return 返回desc
     */
    public String getDesc() {
        return desc;
    }
}
