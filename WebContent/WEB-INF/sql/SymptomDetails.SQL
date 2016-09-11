USE medical_assistant_db;

CREATE TABLE
IF NOT EXISTS Symptom_Details (
	KeyId CHAR (16) NOT NULL DEFAULT '' COMMENT '症状id',
	IsAdult tinyint unsigned NOT NULL DEFAULT 1 COMMENT '成人',
	SymptomName VARCHAR (16) NULL DEFAULT '' COMMENT '症状名',
	PainPerception VARCHAR (64) NULL DEFAULT '' COMMENT '疼痛的感觉',
	PainRegion VARCHAR (64) NULL DEFAULT '' COMMENT '疼痛部位',
	PainDuration VARCHAR (64) NULL DEFAULT '' COMMENT '疼痛持续时间',
	SymptomWorsen VARCHAR (255) NULL DEFAULT '' COMMENT '病症在什么情况下会恶化',
	OtherFeaturesOfPain VARCHAR (255) NULL DEFAULT '' COMMENT '疼痛的其它特征',
	SymptomReason VARCHAR (255) NULL DEFAULT '' COMMENT '何种因素可引发此症状',
	SymptomRelieved VARCHAR (255) NULL DEFAULT '' COMMENT '何种做法可减轻症状',
	SymptomStart VARCHAR (255) NULL DEFAULT '' COMMENT '症状何时开始',
	SymptomWith VARCHAR (255) NULL DEFAULT '' COMMENT '伴有',
	SymptomFelling VARCHAR (255) NULL DEFAULT '' COMMENT '你会感觉到(头晕特有属性)',
	BloodPosition VARCHAR (255) NULL DEFAULT '' COMMENT '血出现在(大便带血特有属性)',
	OtherFeatures VARCHAR (255) NULL DEFAULT '' COMMENT '症状的其它特征(视力问题特有属性)',
	Coughing VARCHAR (255) NULL DEFAULT '' COMMENT '咳嗽表现为(咳嗽特有属性)',
	AffectedArea VARCHAR (255) NULL DEFAULT '' COMMENT '受影响或累及部位为(足部或踝关节疼痛特有属性)',
	SymptomAppears VARCHAR (255) NULL DEFAULT '' COMMENT '病症出现在下面哪种情况之后(吞咽特有属性)',
	TreatmentAdvice VARCHAR (255) NULL DEFAULT '' COMMENT '就诊建议',
	SwallowFelling VARCHAR (255) NULL DEFAULT '' COMMENT '吞咽时',
	ModifyTime datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '修改时间',
	PRIMARY KEY (KeyId),
	INDEX IDX_Symptom_Details_○ (SymptomWith)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '医疗助手症状描述表:';
