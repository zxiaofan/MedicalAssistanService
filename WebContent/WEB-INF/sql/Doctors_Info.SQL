USE medical_assistant_db;

CREATE TABLE
IF NOT EXISTS Doctors_Info (
	KeyId CHAR (16) NOT NULL DEFAULT '' COMMENT '医生id(根据医院+科室-姓名生成)',
	DocName VARCHAR (16) NOT NULL DEFAULT '' COMMENT '医生名字',
	DiseaseName VARCHAR (255) NOT NULL DEFAULT '' COMMENT '诊断疾病(竖线分割)',
	DiseaseNamePinYin VARCHAR (255) NOT NULL DEFAULT '' COMMENT '诊断疾病(拼音，竖线分割，全文索引)',
	DocTitle VARCHAR (16) NOT NULL DEFAULT '' COMMENT '医生职称',
	DocHospital VARCHAR (16) NOT NULL DEFAULT '' COMMENT '所属医院',
	DocDepart VARCHAR (16) NOT NULL DEFAULT '' COMMENT '所属科室',
	RecommendHeat DOUBLE NULL DEFAULT NULL COMMENT '患者推荐热度',
	DocAdept VARCHAR (2048) NULL DEFAULT '' COMMENT '医生擅长',
	PracticeExperience text COMMENT '执业经历',
	ThanksLetterNum INT (4) NULL DEFAULT 0 COMMENT '感谢信数量',
	UrlDoc VARCHAR (128) NULL DEFAULT '' COMMENT '医生详细Url',
	ModifyTime datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (KeyId),
	FULLTEXT IDX_Doctors_Info_○ (DiseaseNamePinYin)
)