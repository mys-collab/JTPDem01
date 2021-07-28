/*
Navicat MySQL Data Transfer

Source Server         : springdb
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : test2021

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2021-07-28 16:41:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_information
-- ----------------------------
DROP TABLE IF EXISTS `order_information`;
CREATE TABLE `order_information` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `address` varchar(255) NOT NULL COMMENT '送货地址',
  `date` date NOT NULL COMMENT '送货日期',
  `time` varchar(125) NOT NULL COMMENT '送货时间',
  `driver` varchar(125) NOT NULL COMMENT '送货司机',
  `truck` varchar(125) NOT NULL DEFAULT '' COMMENT '送货卡车',
  `is_compensate` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有额',
  `compensate` decimal(20,3) DEFAULT '0.000' COMMENT '额外奖励',
  `total` decimal(20,3) NOT NULL COMMENT '总价',
  `gap` int(11) NOT NULL COMMENT '距离',
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of order_information
-- ----------------------------
INSERT INTO `order_information` VALUES ('1', '湖南益阳', '2021-07-28', '上午', '赵志文', '湘07jx', '0', '0.000', '300.000', '1');
INSERT INTO `order_information` VALUES ('2', '湖南长沙', '2021-07-28', '下午', '张三', '沪0898', '1', '500.000', '800.000', '3');
