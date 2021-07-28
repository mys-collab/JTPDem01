# Host: localhost  (Version: 5.5.53)
# Date: 2021-07-28 17:28:20
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `position` tinyint(3) DEFAULT NULL COMMENT '管理员0 财务人员1 司机2',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "users"
#

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','123456',0),(2,'cwry','123456',1),(3,'sj','123456',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
