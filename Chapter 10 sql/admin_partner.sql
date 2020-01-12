-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: admin
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `partner`
--

DROP TABLE IF EXISTS `partner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `call_center` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `partner_number` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `business_number` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `ceo_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `registered_at` datetime DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner`
--

LOCK TABLES `partner` WRITE;
/*!40000 ALTER TABLE `partner` DISABLE KEYS */;
INSERT INTO `partner` VALUES (1,'컴퓨터-전자제품1 호점','REGISTERED','서울시 강남구 1번길941호','070-0054-0065','010-1111-0000','2418021061','1 대표','2019-11-07 04:03:02',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(2,'컴퓨터-전자제품2 호점','UNREGISTERED','서울시 강남구 2번길751호','070-0057-0060','010-1111-0000','8860157702','2 대표','2019-10-05 08:01:08','2019-04-07 03:01:06','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(3,'컴퓨터-전자제품3 호점','REGISTERED','서울시 강남구 3번길511호','070-0039-0048','010-1111-0000','727900103','3 대표','2019-01-10 11:04:03',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(4,'컴퓨터-전자제품4 호점','UNREGISTERED','서울시 강남구 4번길81호','070-0020-0076','010-1111-0000','8110505074','4 대표','2019-08-01 07:07:03','2019-05-10 01:02:09','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(5,'컴퓨터-전자제품5 호점','UNREGISTERED','서울시 강남구 5번길131호','070-0013-0074','010-1111-0000','7060506795','5 대표','2019-09-02 04:10:03','2019-09-09 10:03:08','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(6,'컴퓨터-전자제품6 호점','REGISTERED','서울시 강남구 6번길931호','070-0082-0010','010-1111-0000','7664001406','6 대표','2019-10-07 09:01:08',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(7,'컴퓨터-전자제품7 호점','REGISTERED','서울시 강남구 7번길871호','070-0079-0065','010-1111-0000','6155423227','7 대표','2019-07-04 11:10:11',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(8,'컴퓨터-전자제품8 호점','REGISTERED','서울시 강남구 8번길681호','070-0070-0084','010-1111-0000','2923447028','8 대표','2019-10-03 09:02:03',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(9,'컴퓨터-전자제품9 호점','UNREGISTERED','서울시 강남구 9번길991호','070-0028-0009','010-1111-0000','2679397509','9 대표','2019-10-08 06:09:09','2019-04-08 05:09:02','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',1),(10,'의류1 호점','UNREGISTERED','서울시 강남구 1번길81호','070-0060-0052','010-1111-0001','7765114281','1 대표','2019-03-10 10:02:03','2019-09-01 08:02:02','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(11,'의류2 호점','UNREGISTERED','서울시 강남구 2번길841호','070-0067-0059','010-1111-0001','5231769282','2 대표','2019-08-07 01:04:03','2019-09-01 07:11:07','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(12,'의류3 호점','REGISTERED','서울시 강남구 3번길411호','070-0093-0040','010-1111-0001','8929130733','3 대표','2019-02-01 04:09:05',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(13,'의류4 호점','REGISTERED','서울시 강남구 4번길231호','070-0081-0018','010-1111-0001','6252820094','4 대표','2019-11-09 08:09:11',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(14,'의류5 호점','REGISTERED','서울시 강남구 5번길771호','070-0060-0083','010-1111-0001','6942357485','5 대표','2019-02-11 06:11:08',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(15,'의류6 호점','UNREGISTERED','서울시 강남구 6번길681호','070-0081-0045','010-1111-0001','4510382916','6 대표','2019-04-05 09:11:03','2019-04-04 11:02:06','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(16,'의류7 호점','UNREGISTERED','서울시 강남구 7번길501호','070-0099-0025','010-1111-0001','6571104037','7 대표','2019-01-07 03:09:09','2019-02-10 04:10:07','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(17,'의류8 호점','UNREGISTERED','서울시 강남구 8번길261호','070-0083-0087','010-1111-0001','3457322638','8 대표','2019-07-01 04:05:07','2019-09-07 01:02:10','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(18,'의류9 호점','REGISTERED','서울시 강남구 9번길751호','070-0046-0052','010-1111-0001','6453491559','9 대표','2019-02-11 07:06:01',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',2),(19,'멀티샵1 호점','REGISTERED','서울시 강남구 1번길711호','070-0046-0009','010-1111-0002','1330470321','1 대표','2019-02-07 01:04:10',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(20,'멀티샵2 호점','UNREGISTERED','서울시 강남구 2번길821호','070-0095-0072','010-1111-0002','1731633112','2 대표','2019-07-08 10:08:02','2019-07-07 08:03:09','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(21,'멀티샵3 호점','UNREGISTERED','서울시 강남구 3번길61호','070-0082-0072','010-1111-0002','7255610613','3 대표','2019-04-06 09:04:10','2019-10-09 03:03:09','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(22,'멀티샵4 호점','UNREGISTERED','서울시 강남구 4번길281호','070-0073-0070','010-1111-0002','3820463464','4 대표','2019-07-06 02:02:05','2019-07-08 04:04:04','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(23,'멀티샵5 호점','REGISTERED','서울시 강남구 5번길01호','070-0060-0095','010-1111-0002','7017107345','5 대표','2019-01-01 08:04:03',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(24,'멀티샵6 호점','REGISTERED','서울시 강남구 6번길531호','070-0047-0011','010-1111-0002','6446265696','6 대표','2019-04-05 05:03:11',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(25,'멀티샵7 호점','UNREGISTERED','서울시 강남구 7번길141호','070-0015-0051','010-1111-0002','7634949827','7 대표','2019-11-06 02:11:11','2019-07-08 07:06:10','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(26,'멀티샵8 호점','REGISTERED','서울시 강남구 8번길961호','070-0015-0063','010-1111-0002','2406297518','8 대표','2019-04-07 06:06:05',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(27,'멀티샵9 호점','REGISTERED','서울시 강남구 9번길271호','070-0040-0037','010-1111-0002','9149273399','9 대표','2019-04-01 03:05:03',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',3),(28,'인테리어1 호점','REGISTERED','서울시 강남구 1번길331호','070-0047-0088','010-1111-0003','7189937281','1 대표','2019-03-08 11:05:03',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(29,'인테리어2 호점','UNREGISTERED','서울시 강남구 2번길811호','070-0094-0044','010-1111-0003','4413655682','2 대표','2019-02-01 02:04:10','2019-05-08 06:03:06','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(30,'인테리어3 호점','UNREGISTERED','서울시 강남구 3번길301호','070-0010-0092','010-1111-0003','6746203903','3 대표','2019-05-06 02:02:01','2019-06-06 01:01:04','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(31,'인테리어4 호점','REGISTERED','서울시 강남구 4번길331호','070-0069-0033','010-1111-0003','8864326914','4 대표','2019-05-11 11:04:02',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(32,'인테리어5 호점','UNREGISTERED','서울시 강남구 5번길311호','070-0055-0022','010-1111-0003','9867740105','5 대표','2019-09-07 08:10:01','2019-11-10 04:10:02','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(33,'인테리어6 호점','REGISTERED','서울시 강남구 6번길11호','070-0083-0022','010-1111-0003','187286786','6 대표','2019-04-03 07:07:07',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(34,'인테리어7 호점','UNREGISTERED','서울시 강남구 7번길281호','070-0036-0044','010-1111-0003','2572199397','7 대표','2019-01-03 10:08:10','2019-08-05 03:05:05','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(35,'인테리어8 호점','UNREGISTERED','서울시 강남구 8번길311호','070-0095-0043','010-1111-0003','791093758','8 대표','2019-07-06 09:02:08','2019-02-04 05:10:10','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(36,'인테리어9 호점','UNREGISTERED','서울시 강남구 9번길701호','070-0082-0076','010-1111-0003','4927658659','9 대표','2019-07-07 09:09:08','2019-03-02 06:09:09','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',4),(37,'음식1 호점','UNREGISTERED','서울시 강남구 1번길911호','070-0086-0007','010-1111-0004','7624110671','1 대표','2019-08-02 08:04:03','2019-09-11 03:03:06','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',5),(38,'음식2 호점','REGISTERED','서울시 강남구 2번길191호','070-0080-0094','010-1111-0004','4725591002','2 대표','2019-03-06 08:03:11',NULL,'2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',5),(39,'음식3 호점','UNREGISTERED','서울시 강남구 3번길951호','070-0087-0085','010-1111-0004','9416227183','3 대표','2019-04-02 02:07:08','2019-07-08 03:02:07','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',5),(40,'음식4 호점','UNREGISTERED','서울시 강남구 4번길481호','070-0087-0052','010-1111-0004','9892183184','4 대표','2019-07-03 09:11:01','2019-10-02 08:03:08','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',5),(41,'음식5 호점','UNREGISTERED','서울시 강남구 5번길711호','070-0007-0064','010-1111-0004','2228516645','5 대표','2019-04-05 04:11:01','2019-10-08 02:07:06','2019-10-06 12:45:47','AdminServer','2019-10-06 12:45:47','AdminServer',5),(42,'음식6 호점','REGISTERED','서울시 강남구 6번길711호','070-0034-0027','010-1111-0004','2827285816','6 대표','2019-06-04 01:01:02',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',5),(43,'음식7 호점','REGISTERED','서울시 강남구 7번길941호','070-0036-0033','010-1111-0004','6404912747','7 대표','2019-05-06 09:08:07',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',5),(44,'음식8 호점','UNREGISTERED','서울시 강남구 8번길671호','070-0042-0020','010-1111-0004','2480514018','8 대표','2019-10-03 07:01:07','2019-06-02 06:11:04','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',5),(45,'음식9 호점','UNREGISTERED','서울시 강남구 9번길331호','070-0053-0031','010-1111-0004','4994974769','9 대표','2019-09-09 03:11:10','2019-09-06 08:03:02','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',5),(46,'스포츠1 호점','REGISTERED','서울시 강남구 1번길951호','070-0097-0026','010-1111-0005','5923667671','1 대표','2019-01-11 08:06:04',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(47,'스포츠2 호점','UNREGISTERED','서울시 강남구 2번길511호','070-0080-0098','010-1111-0005','220096342','2 대표','2019-11-06 06:06:08','2019-10-10 03:03:08','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(48,'스포츠3 호점','REGISTERED','서울시 강남구 3번길311호','070-0050-0067','010-1111-0005','4457754603','3 대표','2019-03-07 01:01:07',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(49,'스포츠4 호점','REGISTERED','서울시 강남구 4번길811호','070-0011-0005','010-1111-0005','6417687754','4 대표','2019-07-01 06:02:05',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(50,'스포츠5 호점','REGISTERED','서울시 강남구 5번길901호','070-0098-0066','010-1111-0005','8651314535','5 대표','2019-06-04 01:07:01',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(51,'스포츠6 호점','UNREGISTERED','서울시 강남구 6번길291호','070-0041-0096','010-1111-0005','1842507826','6 대표','2019-05-11 06:10:03','2019-06-06 10:08:07','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(52,'스포츠7 호점','UNREGISTERED','서울시 강남구 7번길331호','070-0011-0047','010-1111-0005','9236340267','7 대표','2019-08-08 07:08:11','2019-06-11 10:03:05','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(53,'스포츠8 호점','REGISTERED','서울시 강남구 8번길211호','070-0026-0077','010-1111-0005','8732290018','8 대표','2019-10-01 02:11:04',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(54,'스포츠9 호점','REGISTERED','서울시 강남구 9번길501호','070-0068-0063','010-1111-0005','2507798809','9 대표','2019-05-05 03:08:10',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',6),(55,'쇼핑몰1 호점','REGISTERED','서울시 강남구 1번길961호','070-0100-0026','010-1111-0006','5034427191','1 대표','2019-10-09 10:04:05',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(56,'쇼핑몰2 호점','REGISTERED','서울시 강남구 2번길151호','070-0034-0045','010-1111-0006','8092876352','2 대표','2019-09-09 11:11:10',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(57,'쇼핑몰3 호점','UNREGISTERED','서울시 강남구 3번길611호','070-0091-0015','010-1111-0006','2764450423','3 대표','2019-02-03 08:03:02','2019-09-09 06:10:01','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(58,'쇼핑몰4 호점','UNREGISTERED','서울시 강남구 4번길181호','070-0089-0045','010-1111-0006','7617639234','4 대표','2019-04-07 09:09:04','2019-05-06 10:10:03','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(59,'쇼핑몰5 호점','UNREGISTERED','서울시 강남구 5번길711호','070-0001-0060','010-1111-0006','4225858345','5 대표','2019-05-06 06:04:09','2019-04-01 09:06:07','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(60,'쇼핑몰6 호점','UNREGISTERED','서울시 강남구 6번길181호','070-0075-0054','010-1111-0006','8637976596','6 대표','2019-02-09 11:05:01','2019-01-01 08:04:07','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(61,'쇼핑몰7 호점','REGISTERED','서울시 강남구 7번길591호','070-0024-0087','010-1111-0006','5344368647','7 대표','2019-04-07 01:09:09',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(62,'쇼핑몰8 호점','UNREGISTERED','서울시 강남구 8번길771호','070-0031-0091','010-1111-0006','314456758','8 대표','2019-03-05 10:05:03','2019-06-04 09:03:09','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(63,'쇼핑몰9 호점','REGISTERED','서울시 강남구 9번길131호','070-0070-0022','010-1111-0006','98350989','9 대표','2019-06-04 07:04:02',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',7),(64,'면세점1 호점','UNREGISTERED','서울시 강남구 1번길61호','070-0043-0100','010-1111-0007','6258457801','1 대표','2019-11-06 04:01:09','2019-09-03 02:03:03','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(65,'면세점2 호점','REGISTERED','서울시 강남구 2번길591호','070-0095-0024','010-1111-0007','2750211312','2 대표','2019-05-04 07:07:04',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(66,'면세점3 호점','REGISTERED','서울시 강남구 3번길11호','070-0008-0043','010-1111-0007','5799758303','3 대표','2019-07-04 06:09:05',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(67,'면세점4 호점','UNREGISTERED','서울시 강남구 4번길111호','070-0055-0026','010-1111-0007','6009521424','4 대표','2019-05-08 02:04:11','2019-09-07 09:04:08','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(68,'면세점5 호점','REGISTERED','서울시 강남구 5번길921호','070-0011-0011','010-1111-0007','7878751235','5 대표','2019-06-09 11:09:10',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(69,'면세점6 호점','REGISTERED','서울시 강남구 6번길401호','070-0065-0062','010-1111-0007','3314038336','6 대표','2019-06-09 08:07:05',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(70,'면세점7 호점','UNREGISTERED','서울시 강남구 7번길321호','070-0057-0025','010-1111-0007','7000733277','7 대표','2019-01-08 02:04:07','2019-09-08 08:04:01','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(71,'면세점8 호점','REGISTERED','서울시 강남구 8번길81호','070-0063-0014','010-1111-0007','7051921598','8 대표','2019-06-08 04:05:09',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(72,'면세점9 호점','UNREGISTERED','서울시 강남구 9번길21호','070-0052-0043','010-1111-0007','5412017379','9 대표','2019-03-04 04:08:03','2019-07-06 10:10:11','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',8),(73,'화장1 호점','REGISTERED','서울시 강남구 1번길641호','070-0062-0078','010-1111-0008','9651596421','1 대표','2019-01-11 08:05:01',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(74,'화장2 호점','UNREGISTERED','서울시 강남구 2번길341호','070-0035-0070','010-1111-0008','860248962','2 대표','2019-05-11 06:09:09','2019-09-11 08:02:07','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(75,'화장3 호점','UNREGISTERED','서울시 강남구 3번길841호','070-0053-0033','010-1111-0008','3539192323','3 대표','2019-06-03 01:03:02','2019-01-03 07:01:11','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(76,'화장4 호점','UNREGISTERED','서울시 강남구 4번길661호','070-0031-0083','010-1111-0008','1922458534','4 대표','2019-04-08 03:06:09','2019-06-10 10:03:10','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(77,'화장5 호점','UNREGISTERED','서울시 강남구 5번길351호','070-0005-0013','010-1111-0008','8966079775','5 대표','2019-01-10 03:06:09','2019-10-02 02:04:02','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(78,'화장6 호점','REGISTERED','서울시 강남구 6번길31호','070-0025-0053','010-1111-0008','2920502676','6 대표','2019-11-10 04:03:08',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(79,'화장7 호점','REGISTERED','서울시 강남구 7번길411호','070-0072-0069','010-1111-0008','2220913317','7 대표','2019-11-07 07:08:07',NULL,'2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(80,'화장8 호점','UNREGISTERED','서울시 강남구 8번길271호','070-0079-0100','010-1111-0008','9810567818','8 대표','2019-04-03 09:10:02','2019-08-04 04:09:05','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9),(81,'화장9 호점','UNREGISTERED','서울시 강남구 9번길231호','070-0050-0098','010-1111-0008','670691409','9 대표','2019-08-01 06:07:03','2019-01-11 09:11:05','2019-10-06 12:45:48','AdminServer','2019-10-06 12:45:48','AdminServer',9);
/*!40000 ALTER TABLE `partner` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-06 12:54:33
