# Host: localhost  (Version: 5.5.53)
# Date: 2021-07-28 17:28:00
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "persistent_logins"
#

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "persistent_logins"
#

/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
INSERT INTO `persistent_logins` VALUES ('admin','LzplUTIns0LmHXE0N86tyA==','nC5qCSwZmzUxuTlgd6EPzA==','2021-07-28 17:10:06');
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
