/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : ibm_mq

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-08-31 18:30:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hnyc_regionalism_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_regionalism_info`;
CREATE TABLE `hnyc_regionalism_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `regionalismCode` varchar(30) DEFAULT NULL COMMENT '行政区划代码',
  `regionalismName` varchar(50) DEFAULT NULL COMMENT '行政区划名称',
  `codeFullName` varchar(255) DEFAULT NULL,
  `regionalismLevelClass` varchar(30) DEFAULT NULL COMMENT '行政区划级别分类',
  `regionalismArea` varchar(30) DEFAULT NULL COMMENT '所属片区分类',
  `superRegionalism` varchar(30) DEFAULT NULL COMMENT '上级行政区划名称',
  `status` char(1) DEFAULT NULL COMMENT '启用标识',
  `codeGbm` varchar(64) DEFAULT NULL,
  `codeLevel` varchar(12) DEFAULT NULL,
  `codePurview` varchar(32) DEFAULT NULL,
  `codeSuper` varchar(64) DEFAULT NULL,
  `creator` varchar(32) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `modifier` varchar(64) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55485 DEFAULT CHARSET=utf8 COMMENT='行政区划信息表';

-- ----------------------------
-- Table structure for hnyc_employee_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_employee_info`;
CREATE TABLE `hnyc_employee_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `personCode` varchar(30) DEFAULT NULL COMMENT '人员编码',
  `cnName` varchar(30) DEFAULT NULL COMMENT '中文名字',
  `idNum` varchar(18) DEFAULT NULL COMMENT '身份证编号',
  `sex` varchar(30) DEFAULT NULL COMMENT '性别',
  `nation` varchar(30) DEFAULT NULL COMMENT '民族',
  `birthday` varchar(30) DEFAULT NULL COMMENT '出生日期',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `nativePlace` varchar(30) DEFAULT NULL COMMENT '籍贯',
  `eduCode` varchar(30) DEFAULT NULL COMMENT '学历',
  `graduateSchool` varchar(30) DEFAULT NULL COMMENT '毕业学校',
  `entranceDate` varchar(10) DEFAULT NULL COMMENT '入学时间',
  `graduateDate` varchar(10) DEFAULT NULL COMMENT '毕业时间',
  `eductionalSystme` varchar(30) DEFAULT NULL COMMENT '学制',
  `studyForm` varchar(30) DEFAULT NULL COMMENT '学习形式',
  `degreeCode` varchar(6) DEFAULT NULL COMMENT '学位',
  `degreeDept` varchar(30) DEFAULT NULL COMMENT '学位授予单位',
  `degreeDate` varchar(10) DEFAULT NULL COMMENT '学位授予时间',
  `speciality` varchar(30) DEFAULT NULL COMMENT '专业',
  `pCode` varchar(30) DEFAULT NULL COMMENT '政治面貌',
  `marryCode` varchar(30) DEFAULT NULL COMMENT '婚姻状况',
  `homeTel` varchar(64) DEFAULT NULL COMMENT '家庭电话',
  `health` varchar(30) DEFAULT NULL COMMENT '健康状况',
  `beginWorkDate` varchar(10) DEFAULT NULL COMMENT '参加工作时间',
  `iftranWork` varchar(30) DEFAULT NULL COMMENT '是否部队转业干部',
  `ifeServiceman` varchar(30) DEFAULT NULL COMMENT '是否部队退役干部',
  `onduty_date` varchar(10) DEFAULT NULL COMMENT '入本单位时间',
  `Insystem_date` varchar(30) DEFAULT NULL COMMENT '入本系统时间',
  `workDate` varchar(10) DEFAULT NULL COMMENT '参加工作年限',
  `stationCode` varchar(30) DEFAULT NULL COMMENT '岗位',
  `job` varchar(30) DEFAULT NULL COMMENT '现岗位职务',
  `stationDate` varchar(10) DEFAULT NULL COMMENT '现岗位起始时间',
  `stationType` varchar(30) DEFAULT NULL COMMENT '人员职务分类',
  `titleTechPost` varchar(30) DEFAULT NULL COMMENT '职称',
  `dealLevel` varchar(30) DEFAULT NULL COMMENT '享受待遇级别',
  `dealDate` varchar(10) DEFAULT NULL COMMENT '现待遇时间',
  `jobType` varchar(30) DEFAULT NULL COMMENT '用工形式',
  `pactType` varchar(30) DEFAULT NULL COMMENT '劳动合同制用工形式',
  `workSpec` varchar(30) DEFAULT NULL COMMENT '现从事专业',
  `strongSuit` varchar(30) DEFAULT NULL COMMENT '特长',
  `personet1` varchar(30) DEFAULT NULL COMMENT '从业人员分类',
  `personet2` varchar(30) DEFAULT NULL COMMENT '人员性质类别',
  `endowmentInsurance` varchar(30) DEFAULT NULL COMMENT '参加养老保险标志',
  `idlenessInsurance` varchar(30) DEFAULT NULL COMMENT '参加失业保险标志',
  `workInjure` varchar(30) DEFAULT NULL COMMENT '参加工伤保险标志',
  `medicare` varchar(30) DEFAULT NULL COMMENT '参加医疗保险标志',
  `bearingNisurance` varchar(30) DEFAULT NULL COMMENT '参加生育保险标志',
  `registerType` varchar(30) DEFAULT NULL COMMENT '户口性质',
  `reisterAdress` varchar(50) DEFAULT NULL COMMENT '户口所在地',
  `specialties` varchar(30) DEFAULT NULL COMMENT '特殊项标识',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(12) DEFAULT NULL COMMENT '手机号码',
  `officeTel` varchar(64) DEFAULT NULL COMMENT '办公电话',
  `connectAddr` varchar(100) DEFAULT NULL COMMENT '家庭地址',
  `otherInfo` varchar(254) DEFAULT NULL COMMENT '备注',
  `corpCode` varchar(30) DEFAULT NULL COMMENT '所属单位',
  `deptCode` varchar(30) DEFAULT NULL COMMENT '所属部门',
  `employeeCode` varchar(10) DEFAULT NULL COMMENT '工号',
  `userId` varchar(254) NOT NULL DEFAULT '' COMMENT '账户',
  `status` varchar(1) DEFAULT NULL COMMENT '状态',
  `orderNo` varchar(10) DEFAULT NULL COMMENT '排序号',
  `mailenAbled` varchar(10) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `personuuId` varchar(128) DEFAULT NULL,
  `ondutyDate` timestamp NULL DEFAULT NULL,
  `insystemDate` timestamp NULL DEFAULT NULL,
  `isShortTerm` varchar(255) DEFAULT NULL,
  `accountNature` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27645 DEFAULT CHARSET=utf8 COMMENT='人员信息表';

-- ----------------------------
-- Table structure for hnyc_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_dept_info`;
CREATE TABLE `hnyc_dept_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `deptCode` varchar(30) DEFAULT NULL COMMENT '部门代码',
  `deptName` varchar(30) DEFAULT NULL COMMENT '部门名称',
  `deptFullName` varchar(200) DEFAULT NULL COMMENT '部门全称',
  `deptInCorp` varchar(30) DEFAULT NULL COMMENT '所属组织结构',
  `superDeptCode` varchar(30) DEFAULT NULL COMMENT '上级部门名称',
  `deptType` varchar(30) DEFAULT NULL COMMENT '部门类型',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `codePurview` varchar(10) DEFAULT NULL,
  `codeGbm` varchar(20) DEFAULT NULL,
  `codeLevel` varchar(10) DEFAULT NULL,
  `codeLeaf` varchar(30) DEFAULT NULL,
  `codeOrder` varchar(30) DEFAULT NULL,
  `viewCode` varchar(64) DEFAULT NULL,
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT NULL COMMENT '修改人',
  `modifyTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1796 DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Table structure for hnyc_cig_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_cig_info`;
CREATE TABLE `hnyc_cig_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `cigCode` varchar(30) DEFAULT NULL COMMENT '卷烟代码',
  `cigName` varchar(50) DEFAULT NULL COMMENT '卷烟名称',
  `cigHelper` varchar(30) DEFAULT NULL COMMENT '简码',
  `codeFullName` varchar(255) DEFAULT NULL,
  `maker` varchar(64) DEFAULT NULL,
  `cigTrademark` varchar(30) DEFAULT NULL COMMENT '卷烟品牌',
  `barCode` varchar(30) DEFAULT NULL COMMENT '条包装条形码',
  `hbarCode` varchar(30) DEFAULT NULL COMMENT '小包装条形码',
  `xbarCode` varchar(30) DEFAULT NULL COMMENT '件包装条形码',
  `cigNewsign` varchar(30) DEFAULT NULL COMMENT '烟支长度规格',
  `tar` decimal(6,3) DEFAULT NULL COMMENT '焦油含量',
  `nicotine` decimal(6,3) DEFAULT NULL COMMENT '烟气盐碱',
  `factory` varchar(30) DEFAULT NULL COMMENT '生产点',
  `cigState` varchar(30) DEFAULT NULL COMMENT '卷烟类型(香型)',
  `classCode` varchar(30) DEFAULT NULL COMMENT '卷烟价类(等级标识)',
  `packageType` varchar(30) DEFAULT NULL COMMENT '包装类型',
  `packageCode` varchar(30) DEFAULT NULL COMMENT '卷烟计量单位',
  `cigCategory` varchar(30) DEFAULT NULL COMMENT '商品分类',
  `manufacturer` varchar(30) DEFAULT NULL COMMENT '生产厂商',
  `status` varchar(30) DEFAULT NULL COMMENT '状态',
  `codeList` varchar(30) DEFAULT NULL COMMENT '省公司目录',
  `codeGbm` varchar(30) DEFAULT NULL COMMENT '国际码',
  `f_senior` varchar(30) DEFAULT NULL COMMENT '名优烟标识',
  `f_stress` varchar(30) DEFAULT NULL COMMENT '重点牌号标识',
  `f_trademarkHundreds` varchar(30) DEFAULT NULL COMMENT '百牌号标识',
  `f_isinside` varchar(30) DEFAULT NULL COMMENT '产地类别',
  `city` varchar(30) DEFAULT NULL COMMENT '所属城市',
  `codeName` varchar(30) DEFAULT NULL COMMENT '省码',
  `kindCig` varchar(30) DEFAULT NULL COMMENT '卷烟档次分类',
  `spce` varchar(30) DEFAULT NULL COMMENT '规格属性',
  `reasonStockDay` varchar(30) DEFAULT NULL COMMENT '合理库存天数',
  `stockPeriod` varchar(30) DEFAULT NULL COMMENT '进货周期',
  `safeStockDay` varchar(30) DEFAULT NULL COMMENT '安全库存天数',
  `riskDay` varchar(30) DEFAULT NULL COMMENT '风险天数',
  `lifeCycle` varchar(30) DEFAULT NULL COMMENT '商品生命周期',
  `province` varchar(30) DEFAULT NULL COMMENT '所属省份',
  `producingArea` varchar(30) DEFAULT NULL COMMENT '产地',
  `mainColor` varchar(30) DEFAULT NULL COMMENT '主体颜色',
  `codePurview` varchar(30) DEFAULT NULL,
  `is_tobacco` varchar(30) DEFAULT NULL,
  `is_short` varchar(30) DEFAULT NULL,
  `is_burstHeads` varchar(30) DEFAULT NULL,
  `creator` varchar(30) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `modifier` varchar(30) DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1553 DEFAULT CHARSET=utf8 COMMENT='卷烟规格信息表';

-- ----------------------------
-- Table structure for hnyc_provide_bealer_base_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_provide_bealer_base_info`;
CREATE TABLE `hnyc_provide_bealer_base_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `providerCode` varchar(30) DEFAULT NULL COMMENT '供应商编码',
  `providerName` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `providerSimply` varchar(50) DEFAULT NULL COMMENT '供应商简称',
  `corpKind` varchar(30) DEFAULT NULL COMMENT '企业性质',
  `province` varchar(30) DEFAULT NULL COMMENT '企业所在省份',
  `area` varchar(30) DEFAULT NULL COMMENT '地区',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `postalCode` varchar(6) DEFAULT NULL COMMENT '邮政编码',
  `fa` varchar(15) DEFAULT NULL COMMENT '传真',
  `email` varchar(30) DEFAULT NULL COMMENT 'email',
  `http` varchar(50) DEFAULT NULL COMMENT '网址',
  `Bank` varchar(30) DEFAULT NULL COMMENT '开户银行',
  `accounts` varchar(30) DEFAULT NULL COMMENT '银行账号',
  `taNumber` varchar(30) DEFAULT NULL COMMENT '税号',
  `licence` varchar(30) DEFAULT NULL COMMENT '烟草专卖生产(批发)许可证',
  `businessLicence` varchar(30) DEFAULT NULL COMMENT '工商营业执照号码',
  `member1` varchar(30) DEFAULT NULL COMMENT '网上交易会员号1',
  `member2` varchar(30) DEFAULT NULL COMMENT '网上交易会员号2',
  `isPivot` char(1) DEFAULT NULL COMMENT '是否重点企业',
  `superior` varchar(30) DEFAULT NULL COMMENT '上级主管部门或单位',
  `superiorIndustry` varchar(30) DEFAULT NULL COMMENT '所属工业公司',
  `synopsis` varchar(200) DEFAULT NULL COMMENT '简介',
  `providerType` varchar(30) DEFAULT NULL COMMENT '供应商类型',
  `corpOration` varchar(12) DEFAULT NULL COMMENT '法人代表',
  `status` char(1) DEFAULT NULL COMMENT '启用标识 (1:启用， 0:禁用)',
  `orderNo` varchar(10) DEFAULT NULL COMMENT '排序号',
  `codeGbm` varchar(30) DEFAULT NULL COMMENT '国际码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=375 DEFAULT CHARSET=utf8 COMMENT='供应商信息表';

-- ----------------------------
-- Table structure for hnyc_trademark_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_trademark_info`;
CREATE TABLE `hnyc_trademark_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `trademarkCode` varchar(30) DEFAULT NULL COMMENT '品牌代码',
  `trademarkName` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `codeFullName` varchar(255) DEFAULT NULL COMMENT '编码全称',
  `f_isInside` varchar(30) DEFAULT NULL COMMENT '产地类型',
  `producingArea` varchar(30) DEFAULT NULL COMMENT '产地',
  `maker` varchar(30) DEFAULT NULL COMMENT '供应商',
  `f_senior` char(1) DEFAULT NULL COMMENT '名优烟商标',
  `f_stress` char(1) DEFAULT NULL COMMENT '重点烟牌号',
  `f_trademarkHundreds` char(1) DEFAULT NULL COMMENT '百牌号标识',
  `province` varchar(30) DEFAULT NULL COMMENT '所属省份',
  `status` char(1) DEFAULT NULL COMMENT '启用标识 (1:启用， 0:禁用)',
  `codeGbm` varchar(30) DEFAULT NULL COMMENT '国际码',
  `factory` varchar(30) DEFAULT NULL COMMENT '卷烟生产企业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8 COMMENT='卷烟品牌信息表';

-- ----------------------------
-- Table structure for hnyc_corp_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_corp_info`;
CREATE TABLE `hnyc_corp_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `deptCode` varchar(32) DEFAULT NULL COMMENT '单位编码',
  `deptName` varchar(32) DEFAULT NULL COMMENT '单位名称',
  `corpCode` varchar(30) DEFAULT NULL COMMENT '组织代码',
  `corpFullName` varchar(200) DEFAULT NULL COMMENT '组织机构名称',
  `corpName` varchar(50) DEFAULT NULL COMMENT '组织代码简称',
  `corpType` varchar(30) DEFAULT NULL COMMENT '机构类型',
  `corpProperty` varchar(30) DEFAULT NULL COMMENT '经营性质',
  `corpRegionalism` varchar(30) DEFAULT NULL COMMENT '所属行政区划',
  `corpArea` varchar(30) DEFAULT NULL COMMENT '所属片区分类',
  `superDeptCode` varchar(128) DEFAULT NULL COMMENT '上级单位编码',
  `postalCode` varchar(6) DEFAULT NULL COMMENT '邮政编码',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `tel` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `fa` varchar(20) DEFAULT NULL COMMENT '传真',
  `email` varchar(30) DEFAULT NULL COMMENT 'email',
  `http` varchar(100) DEFAULT NULL COMMENT '单位网址',
  `superCorpCode` varchar(30) DEFAULT NULL COMMENT '上级单位代码',
  `province` varchar(30) DEFAULT NULL COMMENT '省份',
  `invoiceLabel` varchar(100) DEFAULT NULL COMMENT '发票抬头',
  `tarate` decimal(4,2) DEFAULT NULL COMMENT '税率',
  `taNumber` varchar(30) DEFAULT NULL COMMENT '税号',
  `accounts` varchar(30) DEFAULT NULL COMMENT '账号',
  `status` varchar(30) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8 COMMENT='组织信息表';

-- ----------------------------
-- Table structure for hnyc_feedback_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_feedback_info`;
CREATE TABLE `hnyc_feedback_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `msgId` varchar(64) NOT NULL COMMENT 'xml报文ID',
  `stateCode` varchar(32) DEFAULT NULL COMMENT '反馈状态码',
  `stateDesc` varchar(32) DEFAULT NULL COMMENT '反馈状态描述',
  `wsMark` varchar(32) DEFAULT NULL COMMENT '反馈本方系统服务标识',
  `wsMethod` varchar(32) DEFAULT NULL COMMENT '保持原样反馈',
  `wsParam` varchar(32) DEFAULT NULL COMMENT '保持原样反馈',
  `currTime` timestamp NULL DEFAULT NULL COMMENT '系统当前时间',
  `sendContent` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COMMENT='消息反馈信息表';

-- ----------------------------
-- Table structure for hnyc_head_info
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_head_info`;
CREATE TABLE `hnyc_head_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `msgId` varchar(64) DEFAULT NULL COMMENT 'xml报文ID',
  `wsMark` varchar(32) DEFAULT NULL COMMENT '发送系统标识',
  `wsMethod` varchar(32) DEFAULT NULL COMMENT '说明是否是编码数据',
  `wsParam` varchar(32) DEFAULT NULL COMMENT '具体是哪个基础数据',
  `recvTime` timestamp NULL DEFAULT NULL,
  `currTime` timestamp NULL DEFAULT NULL COMMENT '发送时间',
  `currUser` varchar(32) DEFAULT NULL COMMENT '接受系统名称',
  `recvInfo` varchar(3000) DEFAULT NULL COMMENT '接收的消息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='消息报头信息表';

-- ----------------------------
-- Table structure for leaf_breed_info
-- ----------------------------
DROP TABLE IF EXISTS `leaf_breed_info`;
CREATE TABLE `leaf_breed_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `breed_code` varchar(30) DEFAULT NULL COMMENT '品种代码',
  `breed_name` varchar(30) DEFAULT NULL COMMENT '品种名称',
  `type_code` varchar(30) DEFAULT NULL COMMENT '烟叶类型编码',
  `production_flag` char(1) DEFAULT NULL COMMENT '收购使用 (0:否 1:是)',
  `move_flag` char(1) DEFAULT NULL COMMENT '调拨使用 (0:否 1:是)',
  `parch_flag` char(1) DEFAULT NULL COMMENT '复烤使用 (0:否 1:是)',
  `other_flag` char(1) DEFAULT NULL COMMENT '其他系统使用 (0:否 1:是)',
  `end_flag` char(1) DEFAULT NULL COMMENT '是否末级 (0:否 1:是)',
  `code_flag` char(1) DEFAULT NULL COMMENT '启用标志 (0:否 1:是)',
  `cog_type` char(1) DEFAULT NULL COMMENT '认定方式 (0:否 1:是)',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '品种国际码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='烟叶品种信息表';

-- ----------------------------
-- Table structure for leaf_big_grade_info
-- ----------------------------
DROP TABLE IF EXISTS `leaf_big_grade_info`;
CREATE TABLE `leaf_big_grade_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `big_grade_code` varchar(30) DEFAULT NULL COMMENT '大等级代码',
  `big_grade_name` varchar(50) DEFAULT NULL COMMENT '大等级名称',
  `production_flag` varchar(1) DEFAULT NULL COMMENT '收购使用',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '部位国际码',
  `code_flag` char(1) DEFAULT NULL COMMENT '启用标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='烟叶大等级信息表';

-- ----------------------------
-- Table structure for leaf_type_info
-- ----------------------------
DROP TABLE IF EXISTS `leaf_type_info`;
CREATE TABLE `leaf_type_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(30) DEFAULT NULL COMMENT '类型代码',
  `type_name` varchar(30) DEFAULT NULL COMMENT '类型名称',
  `production_flag` char(1) DEFAULT NULL COMMENT '收购使用 (0:否 1:是)',
  `move_flag` char(1) DEFAULT NULL COMMENT '调拨使用 (0:否 1:是)',
  `parch_flag` char(1) DEFAULT NULL COMMENT '复烤使用 (0:否 1:是)',
  `other_flag` char(1) DEFAULT NULL COMMENT '其他系统使用 (0:否 1:是)',
  `end_flag` char(1) DEFAULT NULL COMMENT '是否末级 (0:否 1:是)',
  `code_flag` char(1) DEFAULT NULL COMMENT '启用标志 (0:否 1:是)',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '类型国际码 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='烟叶类型信息表';

-- ----------------------------
-- Table structure for leaf_part_info
-- ----------------------------
DROP TABLE IF EXISTS `leaf_part_info`;
CREATE TABLE `leaf_part_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `part_code` varchar(30) DEFAULT NULL COMMENT '部位代码',
  `part_name` varchar(50) DEFAULT NULL COMMENT '部位名称',
  `type_code` varchar(30) DEFAULT NULL COMMENT '所属类型',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '部位国际码',
  `code_flag` varchar(1) DEFAULT NULL COMMENT '启用标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='烟叶部位信息表';

-- ----------------------------
-- Table structure for leaf_grade_info
-- ----------------------------
DROP TABLE IF EXISTS `leaf_grade_info`;
CREATE TABLE `leaf_grade_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `grade_code` varchar(30) DEFAULT NULL COMMENT '等级代码',
  `grade_name` varchar(30) DEFAULT NULL COMMENT '等级名称',
  `leaf_grade` varchar(30) DEFAULT NULL COMMENT '烟叶等级',
  `big_grade_code` varchar(30) DEFAULT NULL COMMENT '大等级编码',
  `level_code` varchar(30) DEFAULT NULL COMMENT '级别编码',
  `type_code` varchar(30) DEFAULT NULL COMMENT '类型编码',
  `part_code` varchar(30) DEFAULT NULL COMMENT '部位编码',
  `color_code` varchar(30) DEFAULT NULL COMMENT '颜色编码',
  `state_code` varchar(30) DEFAULT NULL COMMENT '国别编码',
  `state_code_name` varchar(50) DEFAULT NULL COMMENT '国别名称',
  `production_flag` char(1) DEFAULT NULL COMMENT '收购使用 (0:否 1:是)',
  `move_flag` char(1) DEFAULT NULL COMMENT '调拨使用 (0:否 1:是)',
  `parch_flag` char(1) DEFAULT NULL COMMENT '复烤使用 (0:否 1:是)',
  `other_flag` char(1) DEFAULT NULL COMMENT '其他系统使用 (0:否 1:是)',
  `end_flag` char(1) DEFAULT NULL COMMENT '是否末级 (0:否 1:是)',
  `code_flag` char(1) DEFAULT NULL COMMENT '启用标志 (0:否 1:是)',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '等级国际码 (0:否 1:是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='烟叶等级信息';

-- ----------------------------
-- Table structure for leaf_shape_info
-- ----------------------------
DROP TABLE IF EXISTS `leaf_shape_info`;
CREATE TABLE `leaf_shape_info` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `shape_code` varchar(30) DEFAULT NULL COMMENT '形态编码',
  `shape_name` varchar(30) DEFAULT NULL COMMENT '形态名称',
  `move_flag` char(1) DEFAULT NULL COMMENT '调拨使用 (0:否 1：是)',
  `parch_flag` char(1) DEFAULT NULL COMMENT '复烤使用 (0:否 1：是)',
  `end_flag` char(1) DEFAULT NULL COMMENT '是否末级 (0:否 1：是)',
  `code_flag` char(1) DEFAULT NULL COMMENT '启用标志 (0:否 1：是)',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '品种编码 (0:否 1：是)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='烟叶形态信息表';

-- ----------------------------
-- Table structure for leaf_level_info
-- ----------------------------
DROP TABLE IF EXISTS `leaf_level_info`;
CREATE TABLE `leaf_level_info` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `color_code` varchar(30) DEFAULT NULL COMMENT '颜色代码',
  `color_name` varchar(30) DEFAULT NULL COMMENT '颜色名称',
  `type_code` varchar(30) DEFAULT NULL COMMENT '类型编号',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '颜色国际码',
  `code_flag` char(1) DEFAULT NULL COMMENT '启用标志'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='烟叶级别信息表';

-- ----------------------------
-- Table structure for hnyc_ws_param
-- ----------------------------
DROP TABLE IF EXISTS `hnyc_ws_param`;
CREATE TABLE `hnyc_ws_param` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT '主键ID',
  `code` varchar(50) DEFAULT NULL COMMENT '参数编码',
  `memo` varchar(400) DEFAULT NULL COMMENT '备注说明',
  `value` varchar(200) DEFAULT NULL COMMENT '参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标识信息表';

-- ----------------------------
-- Table structure for feedback_status
-- ----------------------------
DROP TABLE IF EXISTS `feedback_status`;
CREATE TABLE `feedback_status` (
  `statusCode` varchar(4) NOT NULL COMMENT '状态码',
  `desc` varchar(255) NOT NULL COMMENT '状态描述',
  `type` varchar(2) NOT NULL COMMENT '反馈状态类型（0：调用过程中出错； 1：调用成功; 2:其他）',
  PRIMARY KEY (`statusCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='反馈状态表';

-- ----------------------------
-- Table structure for coleaf_color_info
-- ----------------------------
DROP TABLE IF EXISTS `coleaf_color_info`;
CREATE TABLE `coleaf_color_info` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `color_code` varchar(30) DEFAULT NULL COMMENT '颜色代码',
  `color_name` varchar(30) DEFAULT NULL COMMENT '颜色名称',
  `type_code` varchar(30) DEFAULT NULL COMMENT '类型编码',
  `code_gbm` varchar(30) DEFAULT NULL COMMENT '颜色国际码',
  `code_flag` char(1) DEFAULT NULL COMMENT '启用标志'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='烟叶颜色信息表';
