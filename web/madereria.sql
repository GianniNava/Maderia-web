-- MySQL dump 10.16  Distrib 10.1.22-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: madereria
-- ------------------------------------------------------
-- Server version	10.1.22-MariaDB

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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id` int(200) NOT NULL,
  `arbol` varchar(15) DEFAULT NULL,
  `largo` decimal(3,2) DEFAULT NULL,
  `ancho` decimal(3,2) DEFAULT NULL,
  `alto` decimal(3,2) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `imagen` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Roble',0.40,0.10,2.54,45.00,'roble.jpg'),(2,'Roble',0.40,0.30,2.54,120.00,'roble.jpg'),(3,'Nogal',0.40,0.10,2.54,35.00,'nogal.jpg'),(4,'Nogal',0.40,0.30,2.54,110.00,'nogal.jpg'),(5,'Cerezo',0.40,0.10,2.54,50.00,'cerezo.jpg'),(6,'Cerezo',0.40,0.30,2.54,125.00,'cerezo.jpg'),(7,'Abedul',0.40,0.10,2.54,25.00,'abedul.jpg'),(8,'Abedul',0.40,0.30,2.54,100.00,'abedul.jpg'),(9,'Alamo',0.40,0.10,2.54,25.00,'alamo.jpg'),(10,'Alamo',0.40,0.30,2.54,100.00,'alamo.jpg'),(11,'Aliso',0.40,0.10,2.54,40.00,'aliso.jpg'),(12,'Aliso',0.40,0.30,2.54,115.00,'aliso.jpg'),(13,'Roble',0.80,0.10,2.54,90.00,'roble.jpg'),(14,'Roble',0.80,0.30,2.54,260.00,'roble.jpg'),(15,'Nogal',0.80,0.10,2.54,80.00,'nogal.jpg'),(16,'Nogal',0.80,0.30,2.54,250.00,'nogal.jpg'),(17,'Cerezo',0.80,0.10,2.54,95.00,'cerezo.jpg'),(18,'Cerezo',0.80,0.30,2.54,265.00,'cerezo.jpg'),(19,'Abedul',0.80,0.10,2.54,70.00,'abedul.jpg'),(20,'Abedul',0.80,0.30,2.54,240.00,'abedul.jpg'),(21,'Alamo',0.80,0.10,2.54,70.00,'alamo.jpg'),(22,'Alamo',0.80,0.30,2.54,240.00,'alamo.jpg'),(23,'Aliso',0.80,0.10,2.54,85.00,'aliso.jpg'),(24,'Aliso',0.80,0.30,2.54,255.00,'aliso.jpg'),(25,'Roble',1.20,0.10,2.54,130.00,'roble.jpg'),(26,'Roble',1.20,0.30,2.54,320.00,'roble.jpg'),(27,'Nogal',1.20,0.10,2.54,120.00,'nogal.jpg'),(28,'Nogal',1.20,0.30,2.54,310.00,'nogal.jpg'),(29,'Cerezo',1.20,0.10,2.54,135.00,'cerezo.jpg'),(30,'Cerezo',1.20,0.30,2.54,325.00,'cerezo.jpg'),(31,'Abedul',1.20,0.10,2.54,110.00,'abedul.jpg'),(32,'Abedul',1.20,0.30,2.54,300.00,'abedul.jpg'),(33,'Alamo',1.20,0.10,2.54,110.00,'alamo.jpg'),(34,'Alamo',1.20,0.30,2.54,300.00,'alamo.jpg'),(35,'Aliso',1.20,0.10,2.54,125.00,'aliso.jpg'),(36,'Aliso',1.20,0.30,2.54,315.00,'aliso.jpg');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-12  1:08:24
