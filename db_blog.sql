/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.49 : Database - db_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_blog`;

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `summary` varchar(400) DEFAULT NULL COMMENT '摘要',
  `releaseDate` datetime DEFAULT NULL COMMENT '发表时间',
  `clickHit` int(11) DEFAULT NULL COMMENT '点击数',
  `replyHit` int(11) DEFAULT NULL COMMENT '评论数',
  `content` text COMMENT '内容',
  `typeId` int(11) DEFAULT NULL COMMENT '所属博客典型',
  `keyWord` varchar(200) DEFAULT NULL COMMENT '关键字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='博客表';

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`title`,`summary`,`releaseDate`,`clickHit`,`replyHit`,`content`,`typeId`,`keyWord`) values (1,'java从入门到入土','去他妈的前端','2020-03-04 23:05:51',0,0,'<p>浩浩星河谁为主，万古青史我来书!</p>',1,'修仙'),(2,'我爱Java','java是世界上最好的语言','2020-03-04 23:16:54',0,0,'<p>lovelovelovelovelovelovelovelovelovelovelovelovelovelovelovelovelovelove</p>',2,'爱'),(3,'完美世界','随便','2020-03-04 08:00:00',0,0,'<p>完美世界并不完美，天道有缺，何况这世间本就完美</p>',3,'美'),(4,'2','2','2020-03-04 23:18:32',0,0,'<p>2</p>',4,'2'),(5,'3','3','2020-03-04 23:18:57',0,0,'<p>3</p>',5,'3'),(6,'4','4','2020-03-04 23:20:55',0,0,'<p>4</p>',6,'4'),(7,'5','5','2020-03-04 23:25:44',0,0,'<p>5</p>',7,'5'),(8,'6','6','2020-03-05 12:17:53',0,0,'<p>666666</p><p><br></p><p><br></p>',8,'6'),(9,'1','1','2020-03-05 13:19:52',0,0,'<p>1</p>',9,'1'),(10,'测试一','一','2020-03-06 19:08:39',0,0,'1',1,'1'),(11,'测试二','二','2020-03-06 19:08:39',0,0,'2',2,'2'),(12,'测试三','三','2020-03-06 19:08:39',0,0,'3',3,'3'),(13,'测试四','四','2020-03-06 19:08:39',0,0,'4',4,'5');

/*Table structure for table `t_blogger` */

DROP TABLE IF EXISTS `t_blogger`;

CREATE TABLE `t_blogger` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `profile` text COMMENT '个人信息',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sign` varchar(100) DEFAULT NULL COMMENT '个性签名',
  `imageName` varchar(100) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='博主';

/*Data for the table `t_blogger` */

insert  into `t_blogger`(`id`,`userName`,`password`,`profile`,`nickName`,`sign`,`imageName`) values (1,'joker','1234','<p>天空下的夜我一人行走2</p>','庭前云落2','阁下何不同风起，扶摇直上九万里2',NULL);

/*Table structure for table `t_blogtype` */

DROP TABLE IF EXISTS `t_blogtype`;

CREATE TABLE `t_blogtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `orderNo` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='博客类型';

/*Data for the table `t_blogtype` */

insert  into `t_blogtype`(`id`,`typeName`,`orderNo`) values (1,'Mysql',1),(2,'学习记录',2),(3,'错误日志',3),(4,'面试题',4),(5,'微信小程序',5),(6,'日常总结',6),(7,'Spring Cloud',7),(8,'工具',8),(9,'NuxtJS',9),(10,'Linux',10),(11,'Maven',11),(12,'Java',12),(13,'测试一',13),(14,'测试二',14),(15,'测试三',15),(16,'测试四',16);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userIp` varchar(50) DEFAULT NULL COMMENT '评论者IP',
  `blogId` int(11) DEFAULT NULL COMMENT '被评论博客的主键',
  `content` varchar(1000) DEFAULT NULL COMMENT '评论内容',
  `commentDate` datetime DEFAULT NULL COMMENT '评论时间',
  `state` int(11) DEFAULT NULL COMMENT '评论状态：0未审核1审核',
  PRIMARY KEY (`id`),
  KEY `blogId` (`blogId`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blogId`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='评论内容';

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`userIp`,`blogId`,`content`,`commentDate`,`state`) values (1,'127.0.0.1',1,'厉害了我的哥','2020-03-06 19:14:22',0),(2,'127.0.0.2',2,'大神收下我的膝盖','2020-03-06 19:14:22',0),(3,'127.0.0.3',3,'高手啊','2020-03-05 16:43:53',0),(4,'127.0.0.4',4,'写的是什么玩意，垃圾','2020-03-05 16:43:53',0),(5,'127.0.0.4',5,'就这？有手就行','2020-03-05 16:46:07',2),(6,'127.0.0.4',6,'没有手','2020-03-05 16:46:07',1),(7,'127.0.0.4',7,'阿伟666','2020-03-05 16:46:07',2);

/*Table structure for table `t_link` */

DROP TABLE IF EXISTS `t_link`;

CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `linkName` varchar(100) DEFAULT NULL COMMENT '网站名称',
  `linkUrl` varchar(500) DEFAULT NULL COMMENT '网站地址',
  `orderNo` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接';

/*Data for the table `t_link` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
