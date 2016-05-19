-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.9-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 book 的数据库结构
CREATE DATABASE IF NOT EXISTS `book` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `book`;


-- 导出  表 book.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `Admin_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Admin_Username` varchar(20) NOT NULL,
  `Admin_Password` varchar(50) NOT NULL,
  `Admin_Name` varchar(25) NOT NULL,
  `Admin_Sex` varchar(20) NOT NULL,
  `Admin_Tel` varchar(20) NOT NULL,
  PRIMARY KEY (`Admin_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  book.admin 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT IGNORE INTO `admin` (`Admin_ID`, `Admin_Username`, `Admin_Password`, `Admin_Name`, `Admin_Sex`, `Admin_Tel`) VALUES
	(1, '0131124848', '123', '米泽双', '男', '18848111413');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


-- 导出  表 book.bookinfo 结构
CREATE TABLE IF NOT EXISTS `bookinfo` (
  `Book_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Book_Isbn` varchar(20) NOT NULL,
  `Book_Name` varchar(20) NOT NULL,
  `Book_Type` varchar(10) NOT NULL,
  `Book_Price` double NOT NULL,
  `Book_Balance` int(11) NOT NULL,
  `Book_Author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Book_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  book.bookinfo 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `bookinfo` DISABLE KEYS */;
INSERT IGNORE INTO `bookinfo` (`Book_ID`, `Book_Isbn`, `Book_Name`, `Book_Type`, `Book_Price`, `Book_Balance`, `Book_Author`) VALUES
	(1, '0001', '人', '小说', 25.5, 5, '卡勒德'),
	(2, '0002', '乖', '小说', 23.2, 4, '大冰'),
	(11, '0003', '百年孤独', '小说', 23.7, 5, '马尔克斯'),
	(12, '0004', '摆渡人', '小说', 20.3, 5, '麦克福尔'),
	(13, '0005', '灿烂千阳', '小说', 16.9, 5, '卡勒德'),
	(14, '0006', '岛上书店', '小说', 24.1, 5, '泽文 '),
	(15, '0007', '无声告白', '小说', 24.2, 5, '孙璐'),
	(16, '0008', 'C++', '教材', 100, 4, 'Stanley');
/*!40000 ALTER TABLE `bookinfo` ENABLE KEYS */;


-- 导出  表 book.borrowinfo 结构
CREATE TABLE IF NOT EXISTS `borrowinfo` (
  `Book_ID` int(11) DEFAULT NULL,
  `Book_Isbn` varchar(20) NOT NULL,
  `Book_Name` varchar(20) NOT NULL,
  `Book_Type` varchar(20) NOT NULL,
  `Student_ID` int(11) NOT NULL,
  `Student_Username` varchar(50) NOT NULL,
  `Student_Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  book.borrowinfo 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `borrowinfo` DISABLE KEYS */;
INSERT IGNORE INTO `borrowinfo` (`Book_ID`, `Book_Isbn`, `Book_Name`, `Book_Type`, `Student_ID`, `Student_Username`, `Student_Name`) VALUES
	(16, '0008', 'C++', '教材', 1, '0131124848', '米泽双'),
	(2, '0002', '乖', '小说', 1, '0131124848', '米泽双'),
	(16, '0008', 'C++', '教材', 1, '0131124848', '米泽双'),
	(2, '0002', '乖', '小说', 1, '0131124848', '米泽双');
/*!40000 ALTER TABLE `borrowinfo` ENABLE KEYS */;


-- 导出  表 book.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `Student_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Student_Username` varchar(50) DEFAULT NULL,
  `Student_Password` varchar(50) DEFAULT NULL,
  `Student_Name` varchar(50) DEFAULT NULL,
  `Student_Sex` varchar(50) DEFAULT NULL,
  `Student_Professional` varchar(50) DEFAULT NULL,
  `Student_Up` int(11) DEFAULT NULL,
  PRIMARY KEY (`Student_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  book.student 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT IGNORE INTO `student` (`Student_ID`, `Student_Username`, `Student_Password`, `Student_Name`, `Student_Sex`, `Student_Professional`, `Student_Up`) VALUES
	(1, '0131124848', '123', '米泽双', '男', '软件工程', 2),
	(2, '0131124774', '123', '高强', '男', '文学', 5),
	(5, '0131124736', '123', '陈睿钦', '男', '软件工程', 5),
	(6, '0131122229', '123', '郭嘉琪', '男', '软件工程', 5),
	(7, '0131124297', '123', '李金洋', '男', '软件工程', 5);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
