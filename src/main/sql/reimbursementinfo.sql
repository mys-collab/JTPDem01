/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : test2021

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 28/07/2021 14:25:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reimbursementinfo
-- ----------------------------
DROP TABLE IF EXISTS `reimbursementinfo`;
CREATE TABLE `reimbursementinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `driving_code` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `applicant` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报销申请人',
  `type` enum('汽油费','卡车维修费') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报销类型',
  `money` int NOT NULL COMMENT '报销金额',
  `month` int NOT NULL COMMENT '报销月份',
  `application_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '报销申请日期',
  `state` enum('已提交','审批通过','驳回') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已提交' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of reimbursementinfo
-- ----------------------------
INSERT INTO `reimbursementinfo` VALUES (3, '123456789', 'lsx', '汽油费', 2222, 8, '2021-07-28 13:35:19', '已提交');

SET FOREIGN_KEY_CHECKS = 1;
