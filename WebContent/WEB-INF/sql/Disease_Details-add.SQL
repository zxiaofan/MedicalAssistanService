USE medical_assistant_db;

ALTER  TABLE Disease_Details ADD(
	DiabetesTypes text COMMENT '糖尿病类型',
	DiabetesDiagnosis text COMMENT '糖尿病诊断',
	DiabetesPrediabetes text COMMENT '前驱糖尿病',
	DiabetesTypeI text COMMENT 'Ⅰ型糖尿病',
	DiabetesTypeII text COMMENT 'Ⅱ型糖尿病',
	GDM text NULL COMMENT '妊娠糖尿病',
	DiabetesFootCare text COMMENT '糖尿病足部护理',
	NutritionAdvice text COMMENT '营养和饮食建议'
)