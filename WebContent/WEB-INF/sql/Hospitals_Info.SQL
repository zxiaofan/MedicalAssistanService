USE Medical_Assistant_DB;

CREATE TABLE
IF NOT EXISTS Hospitals_Info (
	KeyId CHAR (16) NOT NULL DEFAULT '' COMMENT '医院id(医院名)',
	HospitalName VARCHAR (32) NOT NULL DEFAULT '' COMMENT '医院名',
	HospitalProvince VARCHAR (16) NULL DEFAULT '' COMMENT '医院省份',
	HospitalCity VARCHAR (16) NULL DEFAULT '' COMMENT '医院城市',
	HospitalLevel VARCHAR (16) NULL DEFAULT '' COMMENT '医院级别',
	Address VARCHAR (255) NULL DEFAULT '' COMMENT '医院地址',
	TelePhone VARCHAR (1024) NULL DEFAULT '' COMMENT '联系电话',
	ThanksLetterNum INT (4) NULL DEFAULT 0 COMMENT '感谢信数量',
	DiseaseName text COMMENT '诊断疾病',
	DiseaseNamePinYin text COMMENT '诊断疾病拼音(拼音，竖线分割，全文索引)',
	Url VARCHAR (255) NULL DEFAULT '' COMMENT '医院网址(haodf)',
	ModifyTime datetime NOT NULL DEFAULT now() COMMENT '修改时间',
	PRIMARY KEY (KeyId),
	FULLTEXT IDX_Doctors_Info_○ (DiseaseNamePinYin),
	INDEX IDX_HospitalName_○ (HospitalName),
	INDEX IDX_HospitalProvince_○ (HospitalProvince),
	INDEX IDX_HospitalLevel_○ (HospitalLevel),
	INDEX IDX_HospitalCity_○ (HospitalCity)
);