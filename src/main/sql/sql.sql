/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/7/27 17:52:32                           */
/*==============================================================*/


drop table if exists truckinfo;

/*==============================================================*/
/* Table: truckinfo                                             */
/*==============================================================*/
create table truckinfo
(
   id                   int not null auto_increment comment '唯一id',
   DrivingCode          varchar(12) comment '驾驶证号',
   name                 varchar(12) comment '姓名',
   phone                varchar(11) comment '电话',
   username             varchar(12) comment '用户名 默认为驾驶证号后6位',
   password             varchar(12) default '123456' comment '密码',
   email                varchar(16) comment '邮箱',
   version              int default 0 comment '状态:0：在岗，1：不在岗，默认在岗',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

