CREATE DATABASE  IF NOT EXISTS `batman` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `batman`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: batman
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caretaker_details`
--

DROP TABLE IF EXISTS `caretaker_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caretaker_details` (
  `caretaker_id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `block` int(11) DEFAULT NULL,
  `email_id` varchar(50) NOT NULL,
  `mobile_num` int(11) NOT NULL,
  `caretaker_username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`caretaker_id`),
  UNIQUE KEY `email_id` (`email_id`),
  UNIQUE KEY `mobile_num` (`mobile_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caretaker_details`
--

LOCK TABLES `caretaker_details` WRITE;
/*!40000 ALTER TABLE `caretaker_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `caretaker_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fines`
--

DROP TABLE IF EXISTS `fines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fines` (
  `student_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  KEY `student_fines` (`student_id`),
  CONSTRAINT `fines_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fines`
--

LOCK TABLES `fines` WRITE;
/*!40000 ALTER TABLE `fines` DISABLE KEYS */;
INSERT INTO `fines` VALUES (101,500,'Drinking in the hostel'),(102,250,'Destruction of hostel property'),(101,200,NULL),(102,400,NULL),(104,400,NULL),(106,400,NULL);
/*!40000 ALTER TABLE `fines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('','E3B0C44298FC1C149AFBF4C8996FB92427AE41E4649B934CA495991B7852B855'),('anish97','688787D8FF144C502C7F5CFFAAFE2CC588D86079F9DE88304C26B0CB99CE91C6'),('DBA','664ACDF6CA619F7E9DFCFB667586997040ABBBA480EF555B2E79A6A9674BCA7C'),('jkl','268F277C6D766D31334FDA0F7A5533A185598D269E61C76A805870244828A5F1'),('photo','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8'),('Ram','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8'),('req','65E84BE33532FB784C48129675F9EFF3A682B27168C0EA744B2CF58EE02337C5'),('student','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8'),('user','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8'),('vbn','D0F3B856258B40866E1757EA386BD543962671DE46AAEFC82177B8BEF3DA88B3'),('warden1','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8'),('warden2','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8'),('Warden3','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8'),('warden5','5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `from_id` varchar(200) DEFAULT NULL,
  `to_id` varchar(200) DEFAULT NULL,
  `message` varchar(10000) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES ('stud','photo','Hello World','first'),('photo',NULL,'send this message to all','waddupp'),('photo',NULL,'send this message to all','waddupp'),('photo','stud','send this message to all','waddupp'),('photo',NULL,'sdfsvsdfvf','asdff'),('photo',NULL,'sdfsvsdfvf','asdff'),('photo','stud','sdfsvsdfvf','asdff'),('warden5',NULL,'hello ;)','Welcome to mit'),('warden5',NULL,'hello ;)','Welcome to mit');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_details`
--

DROP TABLE IF EXISTS `parent_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent_details` (
  `student_id` int(11) NOT NULL,
  `P_name` varchar(20) DEFAULT NULL,
  `mobile_num` mediumtext,
  `email_id` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_details`
--

LOCK TABLES `parent_details` WRITE;
/*!40000 ALTER TABLE `parent_details` DISABLE KEYS */;
INSERT INTO `parent_details` VALUES (101,'rahim','9876543210','xvxjh','csgdfs'),(102,'tahir','8876543210','xfsdvxjh','cfsgdfs'),(104,'tuiir','8896543210','axfsdvxjh','acfsgdfs'),(106,'quiir','8896543210','exfsdvxjh','aacfsgdfs');
/*!40000 ALTER TABLE `parent_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `room_no` int(11) DEFAULT NULL,
  `block` int(11) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `mobile_num` varchar(20) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `student_username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (101,'Anish Prabhu','1997-08-16',325,9,NULL,NULL,NULL,NULL,NULL,NULL),(102,'Rahul Kumar','1998-03-12',434,10,NULL,NULL,NULL,NULL,NULL,NULL),(104,'guru','1997-12-01',323,9,5,'dh@gmail.com','9999999999','it','mit','Ram'),(106,'qwerty','1997-08-01',234,5,1,'dasfjh','888888888','pq','mit','req');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER upd_check AFTER DELETE ON student
     FOR EACH ROW
     BEGIN
         INSERT INTO X_STUDENT VALUES(OLD.student_id,OLD.name,OLD.dateOfBirth,OLD.room_no,OLD.block,OLD.semester,OLD.email_id,OLD.mobile_num,OLD.course,OLD.address,OLD.student_username);
Delete from login where username=OLD.student_username;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `warden_details`
--

DROP TABLE IF EXISTS `warden_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warden_details` (
  `warden_id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `phone_no` varchar(20) DEFAULT NULL,
  `block_no` varchar(20) DEFAULT NULL,
  `warden_username` varchar(20) NOT NULL,
  PRIMARY KEY (`warden_id`),
  UNIQUE KEY `warden_username` (`warden_username`),
  CONSTRAINT `warden_details_ibfk_1` FOREIGN KEY (`warden_username`) REFERENCES `login` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warden_details`
--

LOCK TABLES `warden_details` WRITE;
/*!40000 ALTER TABLE `warden_details` DISABLE KEYS */;
INSERT INTO `warden_details` VALUES (11,'asd','ad','asd','photo'),(20,'ram','988762423','6','Warden3'),(67,'asd','123456789','4','warden5'),(101,'RAJU','8343241412','1','warden2'),(109,NULL,NULL,NULL,'vbn'),(1234,'anish','7890765','89','anish97'),(1239,'qwe','12','12','warden1');
/*!40000 ALTER TABLE `warden_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watchlist`
--

DROP TABLE IF EXISTS `watchlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `watchlist` (
  `student_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `reason` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watchlist`
--

LOCK TABLES `watchlist` WRITE;
/*!40000 ALTER TABLE `watchlist` DISABLE KEYS */;
INSERT INTO `watchlist` VALUES (101,'Anish parbhu',NULL,NULL),(102,'Rahul kumar',NULL,NULL),(104,'guru',NULL,NULL),(106,'querty',NULL,NULL);
/*!40000 ALTER TABLE `watchlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `x_student`
--

DROP TABLE IF EXISTS `x_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `x_student` (
  `student_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `room_no` int(11) DEFAULT NULL,
  `block` int(11) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `mobile_num` varchar(20) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `student_username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `x_student`
--

LOCK TABLES `x_student` WRITE;
/*!40000 ALTER TABLE `x_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `x_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'batman'
--

--
-- Dumping routines for database 'batman'
--
/*!50003 DROP PROCEDURE IF EXISTS `factory_reset` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `factory_reset`()
BEGIN
       Delete from caretaker_details;
 Delete from warden_details;
 Delete from student;
 Delete from login where username<>'DBA';
 Delete from fines;
 Delete from messages;
Delete from watchlist;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sendALL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sendALL`(in fromID varchar(20), in message varchar(200), in subject varchar(20))
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE a VARCHAR(20);
  DECLARE cur1 CURSOR FOR SELECT student_username from student;
 
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN cur1;

  read_loop: LOOP
    FETCH cur1 INTO a;
    IF done THEN
      LEAVE read_loop;
    END IF;
    insert into messages values(fromID, a, message, subject); 
  END LOOP;
  CLOSE cur1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-07 10:11:47
