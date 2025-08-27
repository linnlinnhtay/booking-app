/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 9.1.0 : Database - booking
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`booking` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `booking`;

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `UserPackage_Id` bigint NOT NULL,
  `ClassSchedule_Id` bigint NOT NULL,
  `BookingStatus` int DEFAULT NULL COMMENT '=1=BOOKED,2=CANCELED,3=WAITLIST,4=CHECKED_IN',
  `CanceledTime` datetime DEFAULT NULL,
  `CreatedTime` datetime DEFAULT NULL,
  `UpdatedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserPackage_Id` (`UserPackage_Id`),
  KEY `ClassSchedule_Id` (`ClassSchedule_Id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`UserPackage_Id`) REFERENCES `user_package` (`Id`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`ClassSchedule_Id`) REFERENCES `class_schedule` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `booking` */

/*Table structure for table `class_schedule` */

DROP TABLE IF EXISTS `class_schedule`;

CREATE TABLE `class_schedule` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CountryCode` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `RequiredCredits` decimal(10,2) DEFAULT NULL,
  `MaxPerson` int DEFAULT NULL,
  `StartTime` datetime DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `CreatedTime` datetime DEFAULT NULL,
  `UpdatedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `class_schedule` */

insert  into `class_schedule`(`Id`,`Title`,`CountryCode`,`RequiredCredits`,`MaxPerson`,`StartTime`,`EndTime`,`CreatedTime`,`UpdatedTime`) values 
(1,'Yoga Class','SG',1.00,5,'2025-08-27 19:16:08','2025-08-27 20:16:19','2025-08-26 19:16:43',NULL),
(2,'Gym Class','SG',5000.00,3,'2025-08-28 00:59:25','2025-08-29 00:59:31','2025-08-27 00:59:37',NULL);

/*Table structure for table `gym_package` */

DROP TABLE IF EXISTS `gym_package`;

CREATE TABLE `gym_package` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CountryCode` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Credits` decimal(10,2) DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `ExpiryDays` int DEFAULT NULL,
  `CreatedTime` datetime DEFAULT NULL,
  `UpdatedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `gym_package` */

insert  into `gym_package`(`Id`,`Name`,`CountryCode`,`Credits`,`Price`,`ExpiryDays`,`CreatedTime`,`UpdatedTime`) values 
(1,'Basic (SG)','SG',500.00,10000.00,30,NULL,NULL),
(2,'Premium (SG)','SG',1000.00,20000.00,60,NULL,NULL),
(3,'Basic (MM)','MM',500.00,10000.00,30,NULL,NULL),
(4,'Premium (MM)','MM',1000.00,20000.00,60,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Password` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Status` int DEFAULT NULL COMMENT '1=Active,2=Inactive',
  `CreatedTime` datetime DEFAULT NULL,
  `UpdatedTime` datetime DEFAULT NULL,
  `Token` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`Id`,`Name`,`Password`,`Email`,`Status`,`CreatedTime`,`UpdatedTime`,`Token`) values 
(1,'linlin','123456','linlin@gmail.com',1,'2025-08-26 11:49:15','2025-08-27 00:49:28','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsaW5saW5AZ21haWwuY29tIiwiaXNzIjoiQm9va2luZ0FwcCIsImlhdCI6MTc1NjIzMjM2OCwiZXhwIjoxNzU2MjM1OTY4fQ.aih4ojd7CFR41qwy7op3Wr2IZBFdFJoo-yvhQw3l-Yk');

/*Table structure for table `user_package` */

DROP TABLE IF EXISTS `user_package`;

CREATE TABLE `user_package` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `User_Id` bigint NOT NULL,
  `GymPackage_Id` bigint NOT NULL,
  `RemainingCredits` decimal(10,2) DEFAULT NULL,
  `PurchaseDate` datetime DEFAULT NULL,
  `ExpiryDate` datetime DEFAULT NULL,
  `Status` int DEFAULT NULL,
  `CreatedTime` datetime DEFAULT NULL,
  `UpdatedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `User_Id` (`User_Id`),
  KEY `GymPackage_Id` (`GymPackage_Id`),
  CONSTRAINT `user_package_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `user` (`Id`),
  CONSTRAINT `user_package_ibfk_2` FOREIGN KEY (`GymPackage_Id`) REFERENCES `gym_package` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user_package` */

insert  into `user_package`(`Id`,`User_Id`,`GymPackage_Id`,`RemainingCredits`,`PurchaseDate`,`ExpiryDate`,`Status`,`CreatedTime`,`UpdatedTime`) values 
(1,1,1,497.00,'2025-08-26 17:52:42','2025-09-25 17:52:42',1,'2025-08-26 17:52:42','2025-08-27 01:12:31'),
(2,1,2,1000.00,'2025-08-26 17:57:05','2025-10-25 17:57:05',1,'2025-08-26 17:57:05',NULL),
(4,1,3,500.00,'2025-08-26 17:58:56','2025-09-25 17:58:56',1,'2025-08-26 17:58:56',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
