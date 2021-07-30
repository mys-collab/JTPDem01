/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/7/27 17:52:32                           */
/*==============================================================*/


drop table if exists truckinfo;

/*==============================================================*/
/* Table: truckinfo                                             */
/*==============================================================*/
CREATE TABLE `truckinfo` (
                             `id` varchar(32) NOT NULL COMMENT '唯一id',
                             `drivingCode` varchar(12) DEFAULT NULL COMMENT '驾驶证号',
                             `name` varchar(12) DEFAULT NULL COMMENT '姓名',
                             `phone` varchar(11) DEFAULT NULL COMMENT '电话',
                             `username` varchar(12) DEFAULT NULL COMMENT '用户名 默认为驾驶证号后6位',
                             `password` varchar(12) DEFAULT '123456' COMMENT '密码',
                             `email` varchar(16) DEFAULT NULL COMMENT '邮箱',
                             `version` int(11) DEFAULT '0' COMMENT '状态:0：在岗，1：不在岗，默认在岗',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


