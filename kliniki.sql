-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: kliniki
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `id1122`
--

DROP TABLE IF EXISTS `id1122`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id1122` (
  `bloodExams` varchar(2) DEFAULT NULL,
  `PeeExams` varchar(2) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id1122`
--

LOCK TABLES `id1122` WRITE;
/*!40000 ALTER TABLE `id1122` DISABLE KEYS */;
INSERT INTO `id1122` VALUES ('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994'),('Y','Y','1994');
/*!40000 ALTER TABLE `id1122` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `id2332`
--

DROP TABLE IF EXISTS `id2332`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id2332` (
  `bloodExams` varchar(2) DEFAULT NULL,
  `PeeExams` varchar(2) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id2332`
--

LOCK TABLES `id2332` WRITE;
/*!40000 ALTER TABLE `id2332` DISABLE KEYS */;
INSERT INTO `id2332` VALUES ('Y','Y','2008'),('Y','Y','2001'),('N','Y','2003'),('Y','Y','2003'),('Y','Y','2001');
/*!40000 ALTER TABLE `id2332` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `id5647`
--

DROP TABLE IF EXISTS `id5647`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id5647` (
  `bloodExams` varchar(2) DEFAULT NULL,
  `PeeExams` varchar(2) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id5647`
--

LOCK TABLES `id5647` WRITE;
/*!40000 ALTER TABLE `id5647` DISABLE KEYS */;
INSERT INTO `id5647` VALUES ('Y','Y','2012'),('Y','N','2010'),('N','Y','2010');
/*!40000 ALTER TABLE `id5647` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `surname` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `birthdate` varchar(20) DEFAULT NULL,
  `afm` varchar(20) NOT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`afm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES ('temenaros','nikolaos','1992','1122','Mixelwn 18','2102480731'),('Ntok','Stef','1992','2332','25 martiou','2102211122'),('Latsinoglou','Nikolaos','1993','5647','karaiskou 23','6982233443');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-25 17:04:31
