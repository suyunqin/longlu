/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.21-log : Database - jboa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jboa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jboa`;

/*Table structure for table `biz_leave` */

DROP TABLE IF EXISTS `biz_leave`;

CREATE TABLE `biz_leave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createid` int(11) DEFAULT NULL COMMENT '创建人',
  `reason` varchar(200) DEFAULT NULL COMMENT '请假原因',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `starttime` datetime DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '结束时间',
  `optime` datetime DEFAULT NULL COMMENT '处理时间',
  `opid` int(11) DEFAULT NULL COMMENT '处理人',
  `opresult` varchar(200) DEFAULT NULL COMMENT '处理结果',
  `opdes` varchar(200) DEFAULT NULL COMMENT '处理意见',
  `nextopid` int(11) DEFAULT NULL COMMENT '下一个要处理的人',
  `state` int(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `biz_leave` */

INSERT  INTO `biz_leave`(`id`,`createid`,`reason`,`createtime`,`starttime`,`endtime`,`optime`,`opid`,`opresult`,`opdes`,`nextopid`,`state`) VALUES 
(16,1,'请假一天','2015-12-15 15:19:15','2015-12-15 15:07:00','2015-12-16 15:07:00','2015-12-15 15:19:15',1,NULL,NULL,1,2),
(17,1,'我要请假','2015-12-15 15:47:35','2015-12-15 15:47:00','2015-12-16 15:47:00','2015-12-15 15:47:35',1,NULL,NULL,1,3),
(22,1,'阿萨德','2015-12-18 14:29:18','2015-12-18 14:29:00','2015-12-18 14:29:00','2015-12-18 14:29:18',1,NULL,NULL,1,1),
(23,1,'阿萨德','2015-12-18 15:44:43','2015-12-18 15:44:00','2015-12-19 15:44:00','2015-12-18 15:44:43',1,NULL,NULL,1,4),
(24,1,'111','2015-12-18 17:16:28','2015-12-18 17:16:00','2015-12-18 17:16:00','2015-12-18 17:16:28',1,NULL,NULL,1,1),
(25,1,'111','2015-12-18 17:16:29','2015-12-18 17:16:00','2015-12-18 17:16:00','2015-12-18 17:16:29',1,NULL,NULL,1,1),
(26,1,'111','2015-12-18 17:16:30','2015-12-18 17:16:00','2015-12-18 17:16:00','2015-12-18 17:16:30',1,NULL,NULL,1,1),
(27,1,'11','2015-12-22 09:04:01','2015-12-22 09:03:00','2015-12-23 09:03:00','2015-12-22 09:04:01',1,NULL,NULL,1,1),
(28,1,'阿萨德','2015-12-22 09:06:57','2015-12-22 09:06:00','2015-12-23 09:06:00','2015-12-22 09:06:57',1,NULL,NULL,1,1),
(29,1,'阿萨德','2015-12-22 09:06:59','2015-12-22 09:06:00','2015-12-23 09:06:00','2015-12-22 09:06:59',1,NULL,NULL,1,1),
(30,1,'阿萨德','2015-12-22 09:06:59','2015-12-22 09:06:00','2015-12-23 09:06:00','2015-12-22 09:06:59',1,NULL,NULL,1,1),
(31,1,'阿萨德','2015-12-22 09:07:00','2015-12-22 09:06:00','2015-12-23 09:06:00','2015-12-22 09:07:00',1,NULL,NULL,1,1);

/*Table structure for table `sys_department` */

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '部门名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_department` */

insert  into `sys_department`(`id`,`name`) values (1,'人事部'),(2,'平台研发部'),(3,'产品设计部'),(4,'财务部'),(5,'总裁办公室');

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL COMMENT '字典值，valuefield',
  `name` varchar(20) DEFAULT NULL COMMENT '显示的值，namefield',
  `typeid` int(11) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`sid`,`name`,`typeid`) values (1,1,'通过',1),(2,2,'打回',1),(3,3,'拒绝',1);

/*Table structure for table `sys_dict_map` */

DROP TABLE IF EXISTS `sys_dict_map`;

CREATE TABLE `sys_dict_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) DEFAULT NULL COMMENT '字典类型',
  `rem` varchar(200) DEFAULT NULL COMMENT '字典作用描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dict_map` */

insert  into `sys_dict_map`(`id`,`typeid`,`rem`) values (1,1,'请假是否被审批');

/*Table structure for table `sys_emp` */

DROP TABLE IF EXISTS `sys_emp`;

CREATE TABLE `sys_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(26) DEFAULT NULL COMMENT '工号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `posid` int(11) DEFAULT NULL COMMENT '职位id',
  `pass` varchar(26) DEFAULT '000' COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_emp` */

insert  into `sys_emp`(`id`,`sn`,`name`,`deptid`,`posid`,`pass`) values (1,'000','张总',5,2,'000'),(2,'001','李晓伟',2,1,'000'),(3,'002','张平',2,2,'000'),(4,'003','叶宁',3,3,'000'),(5,'004','王小明',1,4,'000');

/*Table structure for table `sys_position` */

DROP TABLE IF EXISTS `sys_position`;

CREATE TABLE `sys_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_cn` varchar(10) DEFAULT NULL COMMENT '职位中文名',
  `name_en` varchar(20) DEFAULT NULL COMMENT '职位英文名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_position` */

insert  into `sys_position`(`id`,`name_cn`,`name_en`) values (1,'员工','staff'),(2,'总经理','generalmanager'),(3,'财务','cashier'),(4,'部门经理','manager');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
