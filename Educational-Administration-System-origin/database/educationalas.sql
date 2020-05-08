-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.5.0-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 educationalas 的数据库结构
CREATE DATABASE IF NOT EXISTS `educationalas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `educationalas`;

-- 导出  表 educationalas.classgrade 结构
CREATE TABLE IF NOT EXISTS `classgrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` char(10) NOT NULL,
  `class_id` char(10) NOT NULL,
  `grade` float unsigned DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `makeup` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  educationalas.classgrade 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `classgrade` DISABLE KEYS */;
/*!40000 ALTER TABLE `classgrade` ENABLE KEYS */;

-- 导出  表 educationalas.classinfo 结构
CREATE TABLE IF NOT EXISTS `classinfo` (
  `id` char(10) NOT NULL,
  `name` char(20) NOT NULL,
  `hour` int(11) unsigned NOT NULL,
  `capacity` int(11) unsigned NOT NULL,
  `year` char(10) NOT NULL DEFAULT '',
  `start_week` int(2) unsigned NOT NULL DEFAULT 0,
  `end_week` int(2) unsigned NOT NULL DEFAULT 0,
  `teacher_id` char(10) NOT NULL,
  `teacher_name` char(18) NOT NULL,
  `credit` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `year` (`year`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  educationalas.classinfo 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `classinfo` DISABLE KEYS */;
INSERT INTO `classinfo` (`id`, `name`, `hour`, `capacity`, `year`, `start_week`, `end_week`, `teacher_id`, `teacher_name`, `credit`) VALUES
	('0001', '数据结构', 2, 100, '2019年春', 1, 8, '1', '连', 2),
	('0002', '计算机网络', 2, 120, '2020年春', 1, 14, '2', '朱', 3);
/*!40000 ALTER TABLE `classinfo` ENABLE KEYS */;

-- 导出  表 educationalas.classschedule 结构
CREATE TABLE IF NOT EXISTS `classschedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` char(10) NOT NULL,
  `time` time NOT NULL,
  `day` int(10) unsigned NOT NULL DEFAULT 0,
  `classroom` char(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  educationalas.classschedule 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `classschedule` DISABLE KEYS */;
INSERT INTO `classschedule` (`id`, `class_id`, `time`, `day`, `classroom`) VALUES
	(1, '001', '10:05:00', 1, '三教304'),
	(2, '001', '08:00:00', 2, '三教303'),
	(3, '001', '13:30:00', 3, '三教102');
/*!40000 ALTER TABLE `classschedule` ENABLE KEYS */;

-- 导出  表 educationalas.comment 结构
CREATE TABLE IF NOT EXISTS `comment` (
  `class_id` char(10) NOT NULL,
  `class_name` char(20) NOT NULL,
  `teacher_id` char(10) NOT NULL,
  `teacher_name` char(18) NOT NULL,
  `content` char(200) NOT NULL,
  `student_id` char(10) NOT NULL,
  PRIMARY KEY (`class_id`),
  KEY `teacher_name` (`teacher_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  educationalas.comment 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`class_id`, `class_name`, `teacher_id`, `teacher_name`, `content`, `student_id`) VALUES
	('0001', '数据结构', '0011', '李', 'good', '2017011294');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- 导出  表 educationalas.electiveinfo 结构
CREATE TABLE IF NOT EXISTS `electiveinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_id` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 正在导出表  educationalas.electiveinfo 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `electiveinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `electiveinfo` ENABLE KEYS */;

-- 导出  表 educationalas.profprogram 结构
CREATE TABLE IF NOT EXISTS `profprogram` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `specialty` char(20) NOT NULL,
  `class_id` char(10) NOT NULL,
  `class_name` char(20) NOT NULL,
  `credit` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `specialty` (`specialty`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业培养方案';

-- 正在导出表  educationalas.profprogram 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `profprogram` DISABLE KEYS */;
/*!40000 ALTER TABLE `profprogram` ENABLE KEYS */;

-- 导出  表 educationalas.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `id` char(10) NOT NULL,
  `name` char(18) NOT NULL,
  `gender` int(1) NOT NULL,
  `department` char(20) NOT NULL,
  `specialty` char(20) NOT NULL,
  `class` char(20) NOT NULL,
  `age` int(11) NOT NULL,
  `admission_time` year(4) NOT NULL,
  `address` char(40) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `specialty` (`specialty`,`department`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  educationalas.student 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `name`, `gender`, `department`, `specialty`, `class`, `age`, `admission_time`, `address`, `tel`) VALUES
	('2017011294', '蒋予捷', 0, '信息工程与技术学院', '计算机科学与技术', '17-1', 21, '2017', NULL, NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 导出  表 educationalas.teacher 结构
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` char(10) NOT NULL,
  `name` char(18) NOT NULL,
  `gender` int(11) unsigned NOT NULL,
  `department` char(20) NOT NULL,
  `title` char(10) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `department` (`department`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  educationalas.teacher 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `name`, `gender`, `department`, `title`, `tel`) VALUES
	('0021000011', '连', 1, '信息科学与技术', NULL, NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- 导出  表 educationalas.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `name` char(10) NOT NULL,
  `password` char(20) NOT NULL,
  `type` char(3) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  educationalas.user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`name`, `password`, `type`) VALUES
	('2017011316', '2017011316', '学生');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
