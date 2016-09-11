USE medical_assistant_db;

CREATE TABLE
IF NOT EXISTS Feature_Matching (
	Id INT (4) NOT NULL AUTO_INCREMENT COMMENT '自增Id',
	FeatureName VARCHAR (32) NOT NULL DEFAULT '' COMMENT '特征名',
	FeatureId VARCHAR (6) NOT NULL DEFAULT '' COMMENT '特征Id(A_10)',
	ModifyTime datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
	PRIMARY KEY (Id),
	INDEX IDX_Feature_Matching_○ (FeatureName, FeatureId)
)