/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3307
Source Database       : medical_assistant_db

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-04-30 18:53:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for disease_details_match
-- ----------------------------
DROP TABLE IF EXISTS `disease_details_match`;
CREATE TABLE `disease_details_match` (
  `KeyId` char(16) NOT NULL DEFAULT '' COMMENT '疾病id',
  `DiseaseName` varchar(32) DEFAULT '' COMMENT '疾病名',
  `PainPerception` varchar(64) DEFAULT '' COMMENT '疼痛的感觉',
  `PainRegion` varchar(64) DEFAULT '' COMMENT '疼痛的部位',
  `PainDuration` varchar(64) DEFAULT '' COMMENT '疼痛的持续时间',
  `SymptomWorsen` varchar(255) DEFAULT '' COMMENT '病症在什么情况下会恶化',
  `OtherFeaturesOfPain` varchar(255) DEFAULT '' COMMENT '疼痛的其它特征',
  `SymptomReason` varchar(255) DEFAULT '' COMMENT '何种因素可引发此症状',
  `SymptomRelieved` varchar(255) DEFAULT '' COMMENT '何种做法可减轻症状',
  `SymptomStart` varchar(255) DEFAULT '' COMMENT '症状何时开始',
  `SymptomWith` varchar(255) DEFAULT '' COMMENT '伴有',
  `SymptomFelling` varchar(255) DEFAULT '' COMMENT '你会感觉到(头晕特有属性)',
  `BloodPosition` varchar(255) DEFAULT '' COMMENT '血出现在(大便带血特有属性)',
  `OtherFeatures` varchar(255) DEFAULT '' COMMENT '症状的其它特征(视力问题特有属性)',
  `Coughing` varchar(255) DEFAULT '' COMMENT '咳嗽表现为(咳嗽特有属性)',
  `AffectedArea` varchar(255) DEFAULT '' COMMENT '受影响或累及部位为(足部或踝关节疼痛特有属性)',
  `SymptomAppears` varchar(255) DEFAULT '' COMMENT '病症出现在下面哪种情况之后(吞咽特有属性)',
  `SwallowFelling` varchar(255) DEFAULT '' COMMENT '吞咽时(吞咽特有属性)',
  `MatchingTimes` int(11) DEFAULT '0' COMMENT '匹配热度',
  `ModifyTime` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`KeyId`),
  FULLTEXT KEY `IDX_Full_AllFeatures` (`PainPerception`,`PainRegion`,`PainDuration`,`SymptomWorsen`,`OtherFeaturesOfPain`,`SymptomReason`,`SymptomRelieved`,`SymptomStart`,`SymptomWith`,`SymptomFelling`,`BloodPosition`,`OtherFeatures`,`Coughing`,`AffectedArea`,`SymptomAppears`,`SwallowFelling`),
  FULLTEXT KEY `IDX_Disease_Details_○` (`PainPerception`),
  FULLTEXT KEY `PainRegion` (`PainRegion`),
  FULLTEXT KEY `PainDuration` (`PainDuration`),
  FULLTEXT KEY `SymptomWorsen` (`SymptomWorsen`),
  FULLTEXT KEY `OtherFeaturesOfPain` (`OtherFeaturesOfPain`),
  FULLTEXT KEY `SymptomReason` (`SymptomReason`),
  FULLTEXT KEY `SymptomRelieved` (`SymptomRelieved`),
  FULLTEXT KEY `SymptomStart` (`SymptomStart`),
  FULLTEXT KEY `SymptomWith` (`SymptomWith`),
  FULLTEXT KEY `SymptomFelling` (`SymptomFelling`),
  FULLTEXT KEY `BloodPosition` (`BloodPosition`),
  FULLTEXT KEY `OtherFeatures` (`OtherFeatures`),
  FULLTEXT KEY `Coughing` (`Coughing`),
  FULLTEXT KEY `AffectedArea` (`AffectedArea`),
  FULLTEXT KEY `SymptomAppears` (`SymptomAppears`),
  FULLTEXT KEY `SwallowFelling` (`SwallowFelling`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease_details_match
-- ----------------------------
INSERT INTO `disease_details_match` VALUES ('baineizhangd8b69', '白内障', null, null, null, null, null, null, null, null, null, null, null, '|L_28|L_34|L_38|L_40|L_42|L_44|L_46|L_47|', null, null, null, null, '0', '2016-04-29 15:03:35');
INSERT INTO `disease_details_match` VALUES ('bangguangai0b836', '膀胱癌', null, null, null, '|D_14|', null, null, null, null, '|I_93|I_59|I_92|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('bangguangjieshi0', '膀胱结石', null, null, null, null, null, null, null, null, '|I_59|I_92|I_93|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('bangguangyan0b68', '膀胱炎', null, null, null, '|D_14|D_12|', null, '|F_33|', '|G_11|', null, '|I_93|I_156|I_59|I_81|I_92|I_16|', null, null, '|L_19|L_14|L_12|L_11|L_17|', null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('banyuebansiliea8', '半月板撕裂', '|A_14|', null, null, null, null, '|F_24|', null, null, '|I_149|I_217|I_150|I_220|I_136|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('bianmifbeb4efbeb', '便秘', '|A_13|', null, null, null, null, null, '|G_10|G_11|', null, '|I_50|I_49|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('biantaotiyan189a', '扁桃体炎', null, null, null, null, null, null, null, null, '|I_114|I_115|I_37|I_118|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('binjianyancecece', '髌腱炎', '|A_15|', null, null, '|D_18|', null, '|F_12|F_28|', null, null, null, null, null, null, null, '|N_11|', null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('bixiroubc9ebbebc', '鼻息肉', null, null, null, null, null, null, null, null, '|I_25|I_36|I_37|I_39|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('bizhonggepianqub', '鼻中隔偏曲', null, null, null, null, null, null, null, null, '|I_26|I_39|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('bnnsaisingoegheg', '臂丛神经损伤', null, null, null, null, null, null, null, null, '|I_67|', null, null, '|L_21|L_25|L_26|', null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('btsogiianuhdersi', '巴瑞特氏食道症', null, null, null, null, null, null, null, null, '|I_70|I_206|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('buhgusnnnkniiagc', '膀胱出口梗阻 (医博士问答)', null, null, null, '|D_12|', null, null, null, null, '|I_59|I_92|I_93|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('buuugggghnngguoe', '膀胱过度活动症', null, null, null, null, null, null, null, null, null, null, null, '|L_18|L_19|L_20|', null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('buwandghagncynii', '病毒性胃肠炎', '|A_13|', null, null, null, null, '|F_18|', null, '|H_10|', '|I_12|I_20|I_13|I_52|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('changgengzu09a22', '肠梗阻', '|A_13|', null, null, null, null, null, null, '|H_10|', '|I_17|I_12|I_20|I_13|I_50|I_52|I_58|', null, null, '|L_10|', null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('changquexue0bac2', '肠缺血', null, null, null, null, null, null, null, null, '|I_48|I_49|I_52|I_54|', null, '|K_10|K_11|', null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('citngntoxogjgoni', '丛集性头痛', null, '|B_14|', '|C_13|', null, '|E_14|', null, '|G_17|', null, '|I_109|I_173|I_175|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('cyozcyozcyozcyoz', '肠易激综合征', '|A_13|', null, null, null, null, '|F_21|F_18|', null, null, '|I_11|I_63|I_12|I_20|I_13|I_50|', null, null, '|L_10|', null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('dagufdagufdagufd', '短暂性脑缺血发作', null, null, null, null, null, null, null, null, '|I_190|I_191|I_176|', '|J_10|J_12|J_11|', null, '|L_31|L_37|L_38|L_30|L_41|', null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('danjieshi68e873b', '胆结石', '|A_11|A_10|', '|B_11|', null, null, null, '|F_18|', null, null, '|I_13|I_52|I_72|I_69|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('dixuetangzhenge8', '低血糖症', null, null, null, null, null, '|F_42|F_43|F_44|', null, null, '|I_107|I_211|I_108|I_212|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('dongjiejianb9bb6', '冻结肩', '|A_15|', null, null, '|D_25|D_27|', null, '|F_24|', null, null, '|I_136|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('duanhpezghinzaao', '带状疱疹', '|A_12|A_10|', null, null, null, null, null, null, '|H_13|', '|I_57|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('dxzunhaghaieogeo', '单核细胞增多症', null, null, null, null, null, null, null, null, '|I_107|I_108|I_57|I_114|I_37|I_118|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('enuiatuinhjacrbo', '二尖瓣脱垂', null, null, null, null, null, null, null, null, '|I_211|I_108|I_148|I_28|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('feidongmaigaoyaa', '肺动脉高压', null, null, null, '|D_21|D_23|', null, null, null, '|H_12|', '|I_40|I_119|I_122|I_47|I_124|I_42|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('feishuansaia9b02', '肺栓塞', null, null, null, null, null, '|F_48|', null, '|H_11|H_13|', '|I_213|I_40|I_148|I_107|I_129|I_123|I_215|I_133|I_214|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:36');
INSERT INTO `disease_details_match` VALUES ('feiwenzhenge89a3', '飞蚊症', null, null, null, null, null, null, null, null, null, null, null, '|L_39|', null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('feiyanab288eab28', '肺炎', null, null, null, null, null, '|F_31|F_10|', null, '|H_13|H_11|', '|I_110|I_129|M_11|I_130|I_37|I_28|I_122|I_148|I_107|I_146|I_124|I_123|I_16|I_214|I_44|', null, null, null, '|M_13|M_11|M_10|', null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('fengwozuzhiyan29', '蜂窝组织炎', null, null, null, null, null, null, null, null, '|I_247|I_248|', null, null, null, null, '|N_14|', null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('fhgjnsnnagiaynxu', '风湿性关节炎', '|A_15|', null, null, '|D_25|', '|E_10|', '|F_12|F_28|', null, null, '|I_122|I_219|I_136|', null, null, null, null, '|N_10|', null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('fixegugwnkngoian', '非溃疡性胃痛', '|A_12|', null, null, null, null, '|F_21|', '|G_12|', null, '|I_63|I_52|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('foiyiignuxiemnag', '非过敏性鼻炎', null, null, null, null, null, null, null, null, '|I_25|I_37|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('fugaoyan49789e9e', '附睾炎', null, null, null, '|D_14|', null, null, null, null, '|I_81|I_84|I_86|I_16|I_93|I_94|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('fugugoushan9ab25', '腹股沟疝', null, null, null, '|D_11|', null, null, null, null, '|I_86|I_90|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('fuxie88e88e88e88', '腹泻', '|A_13|', null, null, null, null, null, null, null, '|I_12|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('ganglieb28e98eb2', '肛裂', null, null, null, null, null, '|F_17|', null, null, '|I_56|I_18|I_22|I_53|', null, '|K_11|K_10|', null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('ganyanbing2e2e2e', '干眼病', null, null, null, null, null, '|F_50|', null, null, '|I_234|I_235|I_240|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('ganyinghuadedede', '肝硬化', null, null, null, null, null, null, null, null, '|I_245|I_147|', null, null, null, null, '|N_13|', null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('gaogaixuezheng89', '高钙血症', null, null, null, null, null, null, null, null, '|I_13|I_21|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('gaowanaie94b7ede', '睾丸癌', null, null, null, null, null, null, null, null, '|I_84|I_86|I_90|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('gaowanyane7e94db', '睾丸炎', null, null, null, null, null, null, null, null, '|I_82|I_84|I_86|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('gaoxueya8a899ebe', '高血压', null, null, null, null, null, '|F_42|F_43|', null, null, '|I_211|I_37|I_28|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:37');
INSERT INTO `disease_details_match` VALUES ('genjianduanliefb', '跟腱断裂', null, null, null, null, null, '|F_28|F_24|', null, null, '|I_134|I_251|I_255|I_252|I_108|', null, null, null, null, '|N_14|N_19|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('genjianyanfefefe', '跟腱炎', null, null, null, null, null, '|F_24|F_28|', null, null, '|I_134|', null, null, null, null, '|N_15|N_18|N_19|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('gmzegnihnihgejsn', '骨筋膜室综合征', null, null, null, null, null, '|D_23|', '|G_15|', null, null, null, null, null, null, '|N_14|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('gnbhnoiyaeigneux', '过敏性鼻炎 (花粉热)', null, null, null, null, null, '|F_26|F_52|', null, null, '|I_38|I_24|I_25|I_29|I_109|I_233|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('gohnznhazegageno', '干燥综合征', null, null, null, null, null, null, null, null, '|I_194|I_202|I_34|I_45|', null, null, null, null, null, null, '|P_10|', '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('gongjishidiao188', '共济失调', null, null, null, null, null, null, null, null, '|I_184|I_186|I_191|', '|J_12|', null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('goxnigqehiteiauu', '股骨头缺血性坏死', '|A_15|', null, null, '|D_18|', null, '|F_24|F_32|', null, null, '|I_136|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('guanxinbing08af6', '冠心病', null, null, null, null, null, '|F_46|', '|G_15|', '|H_13|H_12|', '|I_148|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('guguanjieyan8ba8', '骨关节炎', '|A_20|A_15|', null, null, '|D_25|D_26|D_18|D_30|', '|E_10|', '|F_12|F_28|F_24|F_54|', null, null, '|I_223|I_134|I_136|', null, null, null, null, '|N_15|N_18|N_10|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('guowonangzhong89', '腘窝囊肿', '|A_15|', null, null, '|D_18|', null, '|F_12|F_28|', null, null, '|I_218|', null, null, null, null, '|N_12|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('guzhishusong8aab', '骨质疏松', '|A_20|', null, null, '|D_30|D_18|', null, '|F_24|F_12|', null, null, '|I_227|I_228|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('harihooesaucnunj', '后交叉韧带损伤', '|A_14|', null, null, '|D_18|', null, '|F_24|', null, null, '|I_149|I_217|', null, null, null, null, '|N_10|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('hbagginnbianxuan', '黄斑变性', null, null, null, null, null, null, null, null, null, null, null, '|L_33|L_34|L_40|L_45|L_46|', null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('heinnjzxaajuijon', '化学药品溅入眼睛 (急救中心)', null, null, null, null, null, '|F_24|', null, null, '|L_38|I_233|I_234|I_237|I_238|I_24|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('hjue/bhiozaauuig', '踝/脚部骨折', null, null, null, null, null, '|F_24|', null, null, '|I_149|I_134|I_217|I_254|I_141|', null, null, null, null, '|N_15|N_18|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('hngjnonnaniayaxu', '化脓性关节炎', null, null, null, null, null, '|F_24|F_12|', null, null, '|I_149|I_219|I_221|I_136|I_222|', null, null, null, null, '|N_10|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('hongmoyan98e9898', '虹膜炎', null, null, null, null, null, '|F_24|F_51|', null, null, '|L_38|I_238|I_242|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('houyan98695e9869', '喉炎', null, null, null, null, null, null, null, null, '|I_35|I_34|I_45|', null, null, null, '|M_13|M_11|', null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('huanangyan1e1e1e', '滑囊炎', '|A_15|', null, null, '|D_24|D_28|D_18|', null, '|F_28|F_12|F_24|', null, null, '|I_134|I_254|I_136|', null, null, null, null, '|N_19|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('huiyanyana4eb5c8', '会厌炎', null, null, null, null, null, null, null, null, '|I_35|I_112|I_116|I_47|I_43|I_115|I_45|I_46|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('IgnixaagngbItini', 'II型糖尿病', null, null, null, null, null, null, null, null, null, null, null, '|L_20|', null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jagaioiuomnbnyxd', '巨细胞动脉炎', '|A_16|A_17|A_19|', '|B_15|', null, null, null, null, null, null, '|I_160|I_16|I_178|I_179|I_182|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jantingongtnzxog', '紧张性头痛', '|A_19|A_16|', '|B_15|', '|C_11|', null, null, '|F_21|F_29|', '|G_17|', null, '|I_37|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jhggyaxaanznggii', '间质性膀胱炎', null, null, null, '|D_14|D_13|D_12|', null, '|F_34|', null, null, '|I_93|I_156|I_92|I_154|I_59|', null, null, '|L_19|L_12|', null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jhgijhgijhgijhgi', '间质性肺疾病', null, null, null, '|D_21|D_23|', null, null, null, '|H_12|', '|M_11|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jiagan2b497e2b49', '甲肝', null, null, null, null, null, '|F_18|', null, null, '|I_69|I_13|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jianbangtuojiu98', '肩膀脱臼', '|A_14|', null, null, null, null, '|F_24|', null, null, '|I_134|I_135|I_137|I_138|I_139|I_140|I_141|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jianbangtuoli988', '肩膀脱离', '|A_14|', null, null, null, null, '|F_24|', null, null, '|I_134|I_135|I_136|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jianxiusunshang9', '肩袖损伤', '|A_14|A_15|', null, null, '|D_24|D_27|', null, '|F_24|F_12|F_28|', null, null, '|I_136|I_140|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jianyuanyan199cd', '睑缘炎', null, null, null, null, null, null, null, null, '|I_234|I_236|I_240|I_24|I_242|I_244|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jiaxingtongfeng7', '假性痛风', '|A_15|', null, null, null, null, null, null, null, '|I_248|I_247|I_61|', null, null, null, null, '|N_10|', null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jiazhuangxianai2', '甲状腺癌', null, null, null, null, null, null, null, null, '|I_207|I_116|I_35|I_45|', null, null, null, null, null, null, '|P_10|', '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jiechangxirou3ab', '结肠息肉', null, null, null, null, null, null, null, null, '|I_12|I_49|I_50|', null, '|K_10|K_11|', null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jiemoxiachuxue39', '结膜下出血', null, null, null, null, null, null, null, null, '|I_243|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jiezhichangai3bb', '结直肠癌', '|A_13|', null, null, null, null, null, null, null, '|I_48|I_18|I_12|I_13|I_20|I_50|I_49|I_51|I_10|I_53|', null, '|K_10|', null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jijianyanc8e8828', '肌腱炎', '|A_15|', null, null, '|D_18|', null, '|F_24|F_28|', null, null, '|I_136|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jingmaiquzhang98', '静脉曲张', null, null, null, null, null, null, '|G_20|', null, '|I_249|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jingzhuibing882a', '颈椎病', null, null, null, null, '|E_10|', '|F_24|', '|G_16|', null, '|I_67|I_68|I_142|I_21|I_143|I_37|I_145|', null, null, '|L_26|L_22|', null, null, null, null, '0', '2016-04-29 15:03:38');
INSERT INTO `disease_details_match` VALUES ('jinshi19fb8e19fb', '近视', null, null, null, null, null, null, null, null, '|I_37|I_162|I_166|I_168|', null, null, '|L_47|', null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jiujingzhongdu2b', '酒精中毒', null, null, null, null, null, '|F_16|', null, null, '|I_66|I_75|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jixingbidouyan5a', '急性鼻窦炎', null, null, null, null, null, null, null, null, '|I_33|I_34|I_35|I_27|I_37|I_109|I_36|I_113|I_16|I_30|I_23|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jiyanhepianzhi1b', '鸡眼和胼胝', null, null, null, null, null, '|F_28|', null, null, null, null, null, null, null, '|N_15|N_16|', null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jizegqihngqgennn', '经前期综合征', null, null, null, null, null, null, null, null, '|I_97|I_100|I_13|I_101|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jizhuzhongliuab8', '脊柱肿瘤', '|A_20|', null, null, '|D_25|', null, null, null, null, '|I_223|I_224|I_225|I_226|I_229|I_230|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jmgzegnnghnienge', '肌筋膜疼痛综合症', null, null, null, '|D_15|', null, null, null, null, null, null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jnyijnyijnyijnyi', '局限性硬皮病', null, null, null, null, null, null, null, null, '|I_199|I_203|I_70|', null, null, null, null, null, null, '|P_10|', '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('juieiaajannizgje', '甲状腺结节', null, null, null, null, null, null, null, null, '|I_10|I_116|', null, null, null, null, null, null, '|P_10|', '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('juingjeajuingjea', '甲状腺功能亢进症（甲亢）', null, null, null, null, null, null, null, null, '|I_210|I_107|I_108|I_148|I_212|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('juingteannniighx', '甲状腺功能减退症', null, null, null, null, null, null, null, null, '|I_14|I_15|I_19|I_21|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('juioannghxhiaanz', '甲状腺肿', null, null, null, null, null, null, null, null, '|I_205|I_116|I_34|', null, null, null, null, null, null, '|P_10|', '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('junjiaginnxngxig', '痉挛性斜颈', null, null, null, null, '|E_10|E_11|', null, null, null, '|I_136|I_144|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('jynbiagienynmhag', '结膜炎 (红眼病)', null, null, null, null, null, '|F_51|', null, null, '|I_233|I_236|I_238|I_240|I_24|I_242|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('keluoenbingb98d5', '克罗恩病', '|A_13|', null, null, null, null, null, null, null, '|I_48|I_57|I_61|I_13|I_52|I_49|I_62|I_18|I_12|I_20|I_101|I_16|I_10|', null, '|K_11|K_10|', '|L_10|', null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('khugxuaexgixnniu', '抗生素相关性腹泻', null, null, null, null, null, '|F_23|', null, '|H_10|', '|I_13|I_16|I_18|I_52|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('knghayiegugjanan', '溃疡性结肠炎', '|A_13|', null, null, null, null, null, null, null, '|I_48|I_57|I_18|I_61|I_55|I_12|I_20|I_13|I_101|I_49|I_62|I_16|I_10|', null, '|K_11|K_10|', '|L_10|', null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('konghuangzheng08', '恐慌症', null, null, null, null, null, '|F_43|F_25|', null, '|H_11|', '|I_128|I_185|I_125|I_198|I_129|I_211|I_132|I_148|I_40|I_119|I_52|I_107|I_124|I_71|I_121|', '|J_11|', null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('kouqiangganzao39', '口腔干燥', null, null, null, null, null, null, null, null, '|I_194|I_200|', null, null, null, null, null, null, '|P_10|', '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('kuanbuguzheba83b', '髋部骨折', '|A_14|', null, null, '|D_28|D_18|', null, '|F_24|', null, null, '|I_149|I_151|I_152|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('kuejcunnjaynhuak', '髋关节髋臼盂唇损伤', '|A_14|A_15|', null, null, null, null, '|F_24|F_12|', null, null, '|I_150|I_136|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('lanweiyan19e958b', '阑尾炎', '|A_10|A_15|', '|B_13|', null, null, null, '|F_19|', '|G_13|', null, '|I_12|I_13|I_50|I_101|I_52|I_58|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('laoshilaohua180a', '老视（老花）', null, null, null, null, null, null, null, null, '|I_37|I_162|I_166|I_169|', null, null, '|L_46|', null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('leiguguzhebebebe', '肋骨骨折', null, null, null, null, null, '|F_24|F_48|F_49|', null, '|H_13|', null, null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('leiruanguyanba2b', '肋软骨炎', null, null, null, null, null, '|F_48|F_49|', null, '|H_13|H_12|', null, null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('lhnnnnhuaggcaoao', '卵巢囊肿', null, null, null, '|D_13|D_14|D_18|', null, null, null, null, '|I_100|I_105|I_92|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('linbashuizhongbb', '淋巴水肿', null, null, null, null, null, null, null, null, '|I_246|', null, null, null, null, '|N_14|', null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('linbingb76e8beb7', '淋病', null, null, null, '|D_14|D_17|D_13|', null, null, null, null, '|I_93|I_81|I_153|I_92|I_154|I_103|I_16|', null, null, '|L_17|', null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('lixolixolixolixo', '链球菌性喉炎', null, null, null, null, null, null, null, null, '|I_35|I_201|I_117|I_114|I_118|I_16|I_115|', null, null, null, null, null, '|O_11|', '|P_11|P_10|', '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('lngaguxalninmuig', '流行性感冒（流感）', null, null, null, null, null, '|F_31|', null, null, '|I_35|I_111|I_110|I_37|I_109|I_28|I_147|I_38|I_107|I_16|I_108|', null, null, null, '|M_13|M_11|', null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('lvxingzhefuxie58', '旅行者腹泻', null, null, null, null, null, '|F_18|', null, '|H_10|', '|I_20|I_16|I_52|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('lxhxexungzawixun', '良性阵发性位置性眩晕', null, null, null, null, null, '|F_40|D_22|', null, null, '|I_52|I_190|', '|J_10|', null, null, null, null, null, null, '0', '2016-04-29 15:03:39');
INSERT INTO `disease_details_match` VALUES ('manxingbidouyan2', '慢性鼻窦炎', null, null, null, null, null, null, null, null, '|I_23|I_28|I_30|I_31|I_33|I_34|I_36|I_37|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('meidua6ea6ea6ea6', '梅毒', null, null, null, null, null, null, null, null, '|I_28|I_87|I_106|I_16|I_90|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('meiniaibing5b802', '梅尼埃病', null, null, null, null, null, null, null, null, '|I_52|I_188|I_189|I_31|I_193|', '|J_10|J_12|', null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('mnaginzxegisnbag', '慢性阻塞性肺病', null, null, null, '|D_22|D_23|D_19|D_21|', null, '|F_12|D_22|D_23|F_11|F_26|', null, '|H_12|', '|I_148|I_123|I_28|I_147|', null, null, null, '|M_12|M_11|', null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('mnbgmnbgmnbgmnbg', '慢性阴部疼痛', null, null, null, '|D_13|', null, null, null, null, '|I_104|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('mnnnhioensonanug', '慢性肾功能衰竭 (尿毒症)', null, null, null, null, null, null, null, null, '|I_48|I_69|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('mnqtonpangingtag', '慢性盆腔疼痛', null, null, null, '|D_16|D_13|D_14|', null, null, null, null, null, null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('msiunjiunldegohn', '莫顿神经瘤', null, null, null, null, null, null, null, null, '|A_12|I_141|', null, null, null, null, '|N_16|', null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('muwaifan78586ebe', '拇外翻', null, null, null, null, null, '|F_28|', null, null, '|I_134|I_254|', null, null, null, null, '|N_16|', null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('naawagiueunxgili', '颞下颌关节紊乱病', '|A_16|', null, null, null, null, '|F_38|', '|G_17|', null, '|I_170|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('nalnshhinagheaug', '扭伤和拉伤', '|A_14|', null, null, '|D_28|D_18|', '|E_11|', '|F_28|F_24|F_30|F_29|', null, null, '|I_223|I_134|I_254|I_137|I_217|I_248|I_149|I_136|I_108|I_230|', null, null, null, null, '|N_15|N_18|N_10|', null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('naoliu19488e1948', '脑瘤', null, null, null, null, '|E_13|', null, null, null, '|I_171|I_160|I_181|I_66|I_52|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('naomoyan18898e4e', '脑膜炎', '|A_17|', null, null, null, '|E_11|', null, null, null, '|I_66|I_37|I_172|I_52|I_177|I_16|I_180|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('naoyan19488e1948', '脑炎', '|A_16|A_17|', null, null, null, '|E_12|', null, null, null, '|I_172|I_177|I_16|I_180|I_181|I_66|I_52|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('neeaaaigyshiyyno', '尿液颜色异常', null, null, null, null, null, null, null, null, null, null, null, '|L_11|L_13|L_14|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('niaoluganranfa0b', '尿路感染', null, null, null, '|D_14|D_12|', null, null, null, null, '|I_93|I_92|I_16|I_59|', null, null, '|L_19|L_14|L_12|L_11|L_17|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('niaoshijinfefefe', '尿失禁', null, null, null, null, null, null, null, null, null, null, null, '|L_15|L_18|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('pailuantong2b9de', '排卵痛', null, null, null, null, null, null, null, null, '|I_13|I_102|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('penqiangyan6985b', '盆腔炎', null, null, null, '|D_13|D_17|', null, null, null, null, '|I_100|I_103|I_105|I_16|I_92|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('piantoutongfb841', '偏头痛', '|A_16|A_17|A_18|', '|B_14|B_15|', '|C_12|', '|D_29|', null, '|F_36|F_37|F_21|', '|G_15|G_17|', null, '|I_180|I_52|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('pingzuzheng3bb69', '平足症', null, null, null, null, null, null, null, null, null, null, null, null, null, '|N_17|', null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('pinxueba4b8eba4b', '贫血', null, null, null, '|D_21|D_23|', null, null, null, '|H_11|H_12|', '|I_40|I_119|I_37|I_122|I_124|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('putaomoyan1e1e1e', '葡萄膜炎', null, null, null, null, null, null, null, null, '|L_38|I_237|I_238|I_239|I_242|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('putongganmaoe998', '普通感冒', null, null, null, null, null, '|F_31|', null, null, '|I_35|I_34|I_110|I_24|I_37|I_109|I_28|I_38|I_45|I_25|I_32|', null, null, null, '|M_13|M_11|', null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qiaasqiaasqiaasq', '前交叉韧带损伤', '|A_14|', null, null, '|D_18|', null, '|F_24|', null, null, '|I_149|I_217|I_220|', null, null, null, null, '|N_10|', null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qianjiac55e8bec5', '嵌甲', null, null, null, null, null, null, null, null, '|I_134|I_254|', null, null, null, null, '|N_16|', null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qianliexianaid98', '前列腺癌', null, null, null, '|D_12|D_13|D_14|', null, null, null, null, '|I_85|I_59|I_92|I_93|I_94|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qianliexianyand9', '前列腺炎', null, null, null, '|D_10|D_14|D_12|', null, null, null, null, '|I_93|I_156|I_94|I_59|I_92|I_85|I_16|', null, null, '|L_19|L_11|L_17|L_20|L_16|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qinaladniiaxeief', '前列腺肥大', null, null, null, null, null, null, null, null, null, null, null, '|L_11|L_15|L_16|L_19|L_20|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qingguangyan28d8', '青光眼', null, null, null, null, null, null, null, null, '|I_167|I_241|I_242|I_52|I_164|I_238|I_37|I_165|', null, null, '|L_44|L_31|L_41|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qishiyan985a6e6e', '憩室炎', '|A_14|', null, null, null, null, '|F_19|', null, null, '|I_18|I_12|I_13|I_50|I_52|I_49|I_16|', null, '|K_11|', null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qixiong406e9be40', '气胸', null, null, null, null, null, '|F_10|F_24|', null, '|H_11|', '|I_40|I_123|I_124|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('qznhqznhqznhqznh', '强直性脊柱炎', '|A_20|', null, null, '|D_25|', null, '|F_12|', null, null, '|I_48|I_223|I_28|I_228|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('rgignananetuhubz', '乳糖不耐症', '|A_13|', null, null, null, null, '|F_18|', '|G_14|', null, '|I_63|I_12|I_20|I_13|I_52|I_72|', null, null, '|L_10|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('rumixie394ebbe39', '乳糜泻', '|A_13|', null, null, null, null, '|F_18|', '|G_14|', null, '|I_48|I_79|I_12|I_20|I_13|I_57|', null, null, '|L_10|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('ruoshi1bcb5e1bcb', '弱视', null, null, null, null, null, null, null, null, null, null, null, '|L_29|', null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('sajonhnghntasinc', '三叉神经痛', '|A_17|', '|B_16|', '|C_10|', null, null, '|F_39|', null, null, null, null, null, null, null, null, null, null, '0', '2016-04-29 15:03:40');
INSERT INTO `disease_details_match` VALUES ('sanguang395a6e5e', '散光', null, null, null, null, null, null, null, null, '|I_37|I_162|I_166|', null, null, '|L_33|L_35|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('seruo88e88e88e88', '色弱', null, null, null, null, null, null, null, null, null, null, null, '|L_27|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shengzhiqiyouf99', '生殖器疣', null, null, null, '|D_13|', null, null, null, null, '|I_104|I_87|I_99|I_83|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shenjieshieeeeee', '肾结石', '|A_11|', '|B_10|', null, null, null, null, null, null, '|I_91|I_59|I_64|I_52|I_155|I_92|I_85|I_84|I_16|', null, null, '|L_19|L_14|L_11|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shenyushenyane88', '肾盂肾炎', null, null, null, '|D_14|D_12|', null, null, null, null, '|I_93|I_91|I_59|I_155|I_92|I_85|I_16|', null, null, '|L_19|L_14|L_11|L_17|L_20|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shiguanaif9ea73a', '食管癌', null, null, null, null, null, null, null, null, '|I_10|I_209|I_34|I_45|', null, null, null, null, null, '|O_12|O_13|', '|P_10|P_11|', '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shiguanjingluanf', '食管痉挛', null, null, null, null, null, '|F_45|', null, '|H_13|H_12|', '|I_206|I_204|I_70|I_115|', null, null, null, null, null, null, '|P_11|P_10|', '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shishenjingyan69', '视神经炎', null, null, null, null, null, null, null, null, '|I_167|', null, null, '|L_30|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shiwangmotuoli69', '视网膜脱离', null, null, null, null, null, null, null, null, null, null, null, '|L_31|L_32|L_37|L_39|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shiwuguominfa993', '食物过敏', null, null, null, null, null, '|F_18|', '|G_14|', null, '|I_12|I_73|I_76|I_78|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('shiwuzhongdufa38', '食物中毒', null, null, null, null, null, '|F_18|', null, '|H_10|', '|I_13|I_12|I_52|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('siuyeohnxinhasan', '肾小球肾炎', null, null, null, null, null, null, null, null, '|I_245|', null, null, null, null, '|N_13|', null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('szpenqzhhangihei', '生殖器疱疹', null, null, null, '|D_14|D_16|D_13|', null, null, null, null, '|I_93|I_106|I_87|I_16|I_99|I_83|I_28|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('tinwobaagabinosn', '糖尿病视网膜病变', null, null, null, null, null, null, null, null, '|I_163|', null, null, '|L_39|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('tongfengb9997e7e', '痛风', '|A_14|', null, null, null, null, '|F_54|', null, null, '|A_12|I_219|I_134|I_254|I_222|I_248|I_61|', null, null, null, null, '|N_14|N_15|N_18|N_10|N_16|', null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('tongjingb9797e7e', '痛经', '|A_13|', null, null, '|D_17|', null, '|F_20|', null, null, '|I_100|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('tuoshui148eb8e14', '脱水', null, null, null, null, null, null, null, null, '|I_192|I_194|I_196|', '|J_11|', null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('tuugujzxoihijjon', '脱臼(急救中心)', '|A_14|', null, null, null, null, '|F_24|', null, null, '|I_149|I_217|I_135|I_137|', null, null, null, null, '|N_10|N_11|', null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('wagenzegunhanhng', '腕管综合征', null, null, null, null, null, '|F_35|', '|G_15|', null, '|I_157|I_67|', null, null, '|L_21|L_22|L_24|L_25|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('waijingjia6e6e6e', '外胫夹', null, null, null, null, null, '|F_24|', '|G_15|', null, '|I_250|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('weiqingtan3e3e3e', '胃轻瘫', null, null, null, null, null, null, null, null, '|I_70|I_72|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('weiyan38388e3838', '胃炎', '|A_12|', null, null, null, null, '|F_16|', null, null, '|I_48|I_68|I_52|I_49|', null, '|K_10|', null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('weizhuore38e8738', '胃灼热', null, null, null, null, null, '|F_45|F_47|', '|G_12|', '|H_13|H_12|', '|I_216|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('wifuwifuwifuwifu', '胃食管反流病', null, null, null, null, null, '|F_45|F_47|', '|G_12|', '|H_13|H_12|', '|I_35|I_34|I_70|I_216|I_43|I_115|I_206|I_77|I_45|I_204|I_146|I_133|', null, null, null, '|M_12|M_11|', null, '|O_10|', '|P_10|', '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xiaochuane5e9539', '哮喘', null, null, null, '|D_23|D_19|', null, '|D_23|F_11|F_14|F_27|F_10|', null, '|H_11|H_12|', '|I_148|I_146|I_124|I_126|I_133|', null, null, null, '|M_12|M_11|', null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xinbaoyan35eb5f8', '心包炎', null, null, null, null, null, '|F_47|F_48|', '|G_18|', '|H_13|H_12|', '|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xinfangzhandong3', '心房颤动', null, null, null, null, null, '|F_42|F_43|', null, null, '|I_211|I_108|I_148|I_28|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xinlishuaijie39b', '心力衰竭', null, null, null, '|D_22|D_23|', null, '|D_22|D_23|', null, '|H_11|H_12|', '|I_42|I_41|I_245|I_28|I_122|I_148|I_40|I_131|I_123|I_133|I_127|', null, null, null, null, '|N_13|', null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xinlvshichang38b', '心律失常', null, null, null, null, null, '|F_42|F_43|', null, null, '|I_198|I_211|I_197|I_28|I_183|I_148|I_212|I_108|I_71|I_210|', '|J_11|', null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xiongmoyan8e8e8e', '胸膜炎', null, null, null, '|D_20|', null, '|F_48|F_49|F_10|', null, '|H_11|H_13|H_12|', '|I_148|M_11|I_123|I_130|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xngoanuziznbaigf', '心脏病发作', null, null, null, null, null, '|F_22|', null, '|H_13|', '|I_65|I_213|I_67|I_148|I_52|I_107|I_71|', '|J_11|', null, null, null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xnugijayginauean', '膝关节滑囊炎', '|A_15|', null, null, '|D_28|D_18|', null, '|F_24|F_12|F_28|', null, null, '|I_219|I_136|', null, null, null, null, '|N_11|', null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xueniao018e8ae01', '血尿', null, null, null, null, null, null, null, null, null, null, null, '|L_11|', null, null, null, null, '0', '2016-04-29 15:03:41');
INSERT INTO `disease_details_match` VALUES ('xueshuan0a688e1e', '血栓', null, null, null, null, null, '|F_53|', null, null, '|I_247|I_248|I_249|', null, null, null, null, '|N_14|', null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('xugaaxughnyiakno', '消化性溃疡', '|A_12|', null, null, null, null, '|F_21|F_16|', '|G_12|', null, '|I_48|I_68|I_18|I_52|I_49|I_74|I_60|', null, '|K_10|', null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yaagugaosjzxnmhi', '眼角膜擦伤(急救中心)', null, null, null, null, null, '|F_24|', null, null, '|L_38|I_234|I_238|I_240|I_24|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yanhouaid95b5e2e', '咽喉癌', null, null, null, null, null, null, null, null, '|I_208|I_35|', null, null, null, null, null, '|O_12|O_13|', '|P_10|', '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yaoatondnouzetnx', '有先兆的偏头痛', null, null, null, null, null, null, null, null, '|I_37|', null, null, '|L_30|L_31|L_32|L_36|', null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yindaoganzao4988', '阴道干燥', null, null, null, '|D_13|', null, null, null, null, '|I_104|I_92|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yindaoyan49e9988', '阴道炎', null, null, null, '|D_14|D_13|', null, null, null, null, '|I_102|I_104|I_154|I_103|', null, null, '|L_17|', null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yinglixingguzhe4', '应力性骨折', null, null, null, null, null, '|F_28|', null, null, '|I_134|', null, null, null, null, '|N_15|N_18|', null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yinshishidiaoe9a', '饮食失调', null, null, null, null, null, null, null, null, '|I_48|I_12|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yiweirenshen28cb', '异位妊娠', null, null, null, null, null, null, null, null, '|I_96|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yixianyan08e8838', '胰腺炎', '|A_14|', '|B_12|', null, null, null, '|F_18|F_16|', '|G_13|', null, '|I_48|I_13|I_52|I_65|I_58|I_16|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yiyuantiganran39', '衣原体感染', null, null, null, '|D_14|D_13|', null, null, null, null, '|I_93|I_81|I_154|I_103|I_84|', null, null, '|L_17|', null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('ynghigjenyinjieg', '阴茎硬结症', null, null, null, '|D_13|', null, null, null, null, '|I_80|I_88|I_89|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('ynniaoanhunzkigg', '阴囊肿块', null, null, null, null, null, null, null, null, '|I_84|I_86|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('youjzxngijonhouu', '眼中有异物(急救中心)', null, null, null, null, null, '|F_24|', null, null, '|L_38|I_234|I_167|I_237|I_238|I_24|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yuanshicf8e9becf', '远视', null, null, null, null, null, null, null, null, '|I_37|I_162|I_166|I_169|', null, null, '|L_46|', null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('yuejingguoduo889', '月经过多', null, null, null, '|D_17|', null, null, null, null, '|I_98|I_105|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zaggnzzyhduooxhn', '足部在空中旅行时肿胀 (医博士问答)', null, null, null, null, null, '|F_53|', '|G_19|G_20|', null, null, null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zalnnahhnigyioem', '针眼 (麦粒肿)', null, null, null, null, null, '|F_51|', null, null, '|I_232|I_233|I_238|I_24|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zenbiosinnwegbhi', '周围神经病变', null, null, null, null, null, null, null, null, '|A_12|I_141|I_159|I_68|I_157|', null, null, '|L_25|L_26|L_23|', null, '|N_15|N_18|', null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zgoignmenoiwegei', '子宫内膜异位症', '|A_13|', null, null, '|D_14|D_17|D_13|', null, '|F_20|', null, null, '|I_102|I_101|I_100|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhangqi038e88e03', '胀气', '|A_13|', null, null, null, null, '|F_18|', '|G_14|', null, '|I_63|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhichangyan4ab2b', '直肠炎', null, null, null, null, null, null, null, null, '|I_49|I_54|I_55|', null, '|K_11|', null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhichuang47e9779', '痔疮', null, null, null, null, null, '|F_17|', null, null, '|I_55|I_56|', null, '|K_11|', null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhiguanjieququeb', '趾关节屈曲', null, null, null, null, null, null, null, null, null, null, null, null, null, '|N_16|', null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhigutong68eb97a', '跖骨痛', null, null, null, null, null, '|F_28|', null, null, '|I_134|A_12|', null, null, null, null, '|N_16|', null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhiqiguanyanf94b', '支气管炎', null, null, null, null, null, '|F_31|F_10|F_27|F_26|', null, '|H_12|', '|I_35|I_148|I_16|I_109|I_133|I_44|', null, null, null, '|M_13|M_12|M_10|', null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhongeryandedede', '中耳炎', null, null, null, null, null, null, null, null, '|I_189|I_16|I_31|I_193|', '|J_10|', null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zhongfengd4eb98a', '中风', '|A_17|', null, null, null, null, null, null, null, '|I_161|I_158|I_174|I_66|I_191|I_176|I_187|I_52|I_160|I_107|I_177|I_190|I_195|', '|J_10|J_12|J_11|', null, '|L_25|L_31|L_43|L_37|L_38|L_30|L_41|L_21|', null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zigongjiliu0a9ed', '子宫肌瘤', null, null, null, '|D_13|D_14|D_17|', null, null, null, null, '|I_98|I_100|I_102|I_92|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zigongneimoai0aa', '子宫内膜癌', null, null, null, '|D_13|D_17|', null, null, null, null, '|I_95|I_98|I_102|I_103|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zinujahipcunuhat', '椎间盘突出', '|A_20|A_14|', null, null, '|D_18|D_30|', '|E_10|E_11|', '|F_12|F_28|F_24|', null, null, '|I_223|I_142|I_145|I_136|I_226|I_230|I_229|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('znjngidacoihgigm', '主动脉夹层动脉瘤', null, null, null, null, null, '|F_24|', null, '|H_13|', '|I_107|I_213|I_148|I_52|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zuazzuazzuazzuaz', '椎管狭窄症', '|A_20|', null, null, '|D_25|D_18|D_30|', '|E_10|', '|F_12|F_28|F_24|', null, null, '|I_223|I_142|I_21|I_143|I_145|I_226|I_230|I_229|', null, null, null, null, null, null, null, '0', '2016-04-29 15:03:42');
INSERT INTO `disease_details_match` VALUES ('zudijinmoyan396b', '足底筋膜炎', null, null, null, null, null, '|F_54|F_28|', null, null, '|I_134|', null, null, null, null, '|N_19|', null, null, '0', '2016-04-29 15:03:43');
INSERT INTO `disease_details_match` VALUES ('zudiyou368ebbe36', '足底疣', null, null, null, null, null, null, null, null, null, null, null, null, null, '|N_16|N_19|', null, null, '0', '2016-04-29 15:03:43');
INSERT INTO `disease_details_match` VALUES ('zxiaidylgeinuhix', '直立性低血压', null, null, null, null, null, '|F_41|', null, null, '|I_190|', '|J_11|', null, null, null, null, null, null, '0', '2016-04-29 15:03:43');
INSERT INTO `disease_details_match` VALUES (' uheiuaggnhbrunn', ' 髌骨软化症', '|A_15|', null, null, '|D_30|D_25|D_18|', null, '|F_12|F_28|', null, null, null, null, null, null, null, '|N_11|', null, null, '0', '2016-04-29 15:03:43');
