/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.20 : Database - foodmall
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`foodmall` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `foodmall`;

/*Table structure for table `association` */

DROP TABLE IF EXISTS `association`;

CREATE TABLE `association` (
  `FID1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主食Id',
  `FID2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '副食Id',
  PRIMARY KEY (`FID1`,`FID2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `association` */

insert  into `association`(`FID1`,`FID2`) values 
('1','2'),
('1','3'),
('1','4'),
('2','3'),
('2','4'),
('2','5'),
('2','6'),
('2','7'),
('2','8');

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `CID` int NOT NULL AUTO_INCREMENT COMMENT '购物项ID',
  `FID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主食Id',
  `UID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属用户',
  `count` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '数量',
  `cost` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总价格',
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

/*Table structure for table `charge` */

DROP TABLE IF EXISTS `charge`;

CREATE TABLE `charge` (
  `CID` int NOT NULL AUTO_INCREMENT COMMENT '充值表ID',
  `chargeTime` datetime DEFAULT NULL COMMENT '充值时间',
  `chargeMoney` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '充值金额',
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账户余额',
  `UID` varchar(32) DEFAULT NULL COMMENT '所属用户',
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `charge` */

insert  into `charge`(`CID`,`chargeTime`,`chargeMoney`,`account`,`UID`) values 
(2,'2020-11-29 10:29:48','128','456.0','8080'),
(3,'2020-11-29 10:31:03','4','460.0','8080');

/*Table structure for table `evaluation` */

DROP TABLE IF EXISTS `evaluation`;

CREATE TABLE `evaluation` (
  `EID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价Id',
  `FID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜品名称',
  `UID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评价用户',
  `eva` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜品评价',
  `grade` double DEFAULT NULL COMMENT '评价等级',
  `evaluteTime` datetime DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `evaluation` */

insert  into `evaluation`(`EID`,`FID`,`UID`,`eva`,`grade`,`evaluteTime`) values 
('1','1','8080','好支持',5,'2020-11-11 11:35:57'),
('2','2','8080','好好吃',4,'2020-11-10 11:36:23'),
('202011301141916305','1','8080','下次我还来',5,'2020-11-30 16:57:22'),
('202011302123181139','1','8080','下次我还来',5,'2020-11-30 17:23:51'),
('20201130508109100','1','8080','真的太好吃了吧',5,'2020-11-30 16:48:30'),
('3','1','111','真不错',4,'2020-11-26 11:36:52');

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `FID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主食Id',
  `foodName` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主食名称',
  `price` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '价格',
  `category` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类别，粤、闽等',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `purchase` int DEFAULT NULL COMMENT '购买次数',
  `grade` double DEFAULT NULL COMMENT '评分平均数',
  `evaTimes` int DEFAULT NULL COMMENT '评价次数',
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`FID`,`foodName`,`price`,`category`,`photo`,`purchase`,`grade`,`evaTimes`) values 
('1','姜葱鸡','100','粤菜',NULL,7,4.8,22),
('1010','测试鸡','100','闽南菜','/foodPhoto/2020112914077021fcd9f5434f06a9f91b44dfecb5a9.',2,2,2),
('10101','测试鸡','100','闽南菜','/foodPhoto/202011291408b38c86b2e2414e9e86a29ff075473c80.',NULL,5,NULL),
('101011','测试鸡','100','闽南菜','/foodPhoto/20201129141492cf865fe2954f44b80b8b7621df64fb.',NULL,5,NULL),
('1010111','测试鸡鸭','100','闽南菜','E:\\DataBasePhoto\\foodImg\\2020113000406a6ad79c576b49678b95cef328e697d0.jpg',0,0,0),
('2','豉油鸭','200','粤菜',NULL,2,NULL,NULL),
('3','大闸蟹','300','湘菜',NULL,NULL,NULL,NULL),
('4','酱油','1','调味品',NULL,NULL,NULL,NULL),
('5','糖','1','调味品',NULL,NULL,NULL,NULL),
('6','醋','2','调味品',NULL,NULL,NULL,NULL),
('7','盐','1','调味品',NULL,NULL,NULL,NULL),
('8','猪肉','100','北京菜',NULL,NULL,NULL,NULL);

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `OID` varchar(32) NOT NULL COMMENT '所属订单号',
  `FID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单中的菜品id',
  `UID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属用户',
  `count` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买数量',
  `money` varchar(32) DEFAULT NULL COMMENT '所花金额',
  `payTime` time DEFAULT NULL COMMENT '下单时间',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单类型，未上菜，已上菜，未评价,已评价',
  PRIMARY KEY (`OID`,`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`OID`,`FID`,`UID`,`count`,`money`,`payTime`,`status`) values 
('20201130399088941','1','8080','6','600','17:38:55','未上菜'),
('20201130399088941','2','8080','1','200','17:39:08','未上菜');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `OID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单Id',
  `UID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属用户Id',
  `createTime` datetime DEFAULT NULL COMMENT '下单时间',
  `totalCost` varchar(32) DEFAULT NULL COMMENT '总金额数',
  PRIMARY KEY (`OID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`OID`,`UID`,`createTime`,`totalCost`) values 
('1','1','2020-12-08 00:30:21','900'),
('2','1','2020-12-17 00:30:28','800'),
('20201130399088941','8080','2020-11-30 17:38:52','800');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像',
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户余额',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastLogin` datetime DEFAULT NULL COMMENT '上一次登录时间',
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`UID`,`username`,`password`,`avatar`,`account`,`createTime`,`lastLogin`) values 
('1','小张','123',NULL,'800000','2021-03-03 00:27:45','2020-12-07 13:15:46'),
('2','小王','123',NULL,'96532','2020-12-16 00:29:58',NULL),
('3','小李','123',NULL,'9000','2020-12-01 00:30:04',NULL),
('808012','王五112','123',NULL,'100000','2020-11-29 08:54:06',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
