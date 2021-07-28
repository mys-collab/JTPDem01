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

 Date: 28/07/2021 16:36:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lorryinfo
-- ----------------------------
DROP TABLE IF EXISTS `lorryinfo`;
CREATE TABLE `lorryinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `license` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数字与字母的组合',
  `state` enum('0','1','2') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0：正常，1：维修，2：报废',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `license`(`license`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lorryinfo
-- ----------------------------
INSERT INTO `lorryinfo` VALUES (5, 'string', '1');

SET FOREIGN_KEY_CHECKS = 1;
