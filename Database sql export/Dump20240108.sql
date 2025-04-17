-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: green
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `a_id` int(10) NOT NULL AUTO_INCREMENT,
  `a_email` varchar(100) DEFAULT NULL,
  `a_pass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'gemba@gmail.com','asd'),(2,'chubi@gmail.com','123'),(3,'kabaraya@gmail.com','kabara'),(4,'buwahahah@gmail.com','1221');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `c_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_id` int(10) NOT NULL,
  `date` date DEFAULT NULL,
  `u_id` int(10) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`c_id`,`p_id`),
  KEY `p_id` (`p_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`) ON DELETE CASCADE,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (77,1,'2024-01-01',1,5,'YES'),(78,2,'2024-01-01',1,1,'YES');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `c_id` int(100) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) DEFAULT NULL,
  `category_image` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Vegetables','images/vegetables.jpeg'),(2,'fruits','images/fruits.jpeg'),(3,'Frozen','images/Meat.jpeg'),(4,'Beverages','images/Beverages.jpg'),(5,'Dairy Products','images/Dairy.jpeg'),(6,'Grocery','images/Gro.jpeg'),(7,'Snaks','images/snacks.jpeg'),(8,'Cereals','images/cereals.jpg'),(9,'Pulses','images/pulses.jpg'),(10,'Desserts','images/desserts.jpg'),(11,'Pet Products','images/dog-food.jpg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdet`
--

DROP TABLE IF EXISTS `orderdet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdet` (
  `o_id` int(10) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `orderStatus` varchar(15) DEFAULT NULL,
  `u_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`o_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `orderdet_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdet`
--

LOCK TABLES `orderdet` WRITE;
/*!40000 ALTER TABLE `orderdet` DISABLE KEYS */;
INSERT INTO `orderdet` VALUES (7,'2023-12-29',1425,'Canceled',1),(8,'2023-12-29',761,'Canceled',1),(12,'2023-12-29',903,'Processing',1),(13,'2023-12-29',1278,'Order Received',2),(14,'2023-12-29',653,'Canceled',2),(15,'2023-12-31',1460,'Processing',1);
/*!40000 ALTER TABLE `orderdet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderproduct`
--

DROP TABLE IF EXISTS `orderproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderproduct` (
  `o_id` int(10) NOT NULL,
  `p_id` int(10) NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  PRIMARY KEY (`o_id`,`p_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `orderproduct_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderproduct`
--

LOCK TABLES `orderproduct` WRITE;
/*!40000 ALTER TABLE `orderproduct` DISABLE KEYS */;
INSERT INTO `orderproduct` VALUES (7,4,5),(7,5,1),(8,6,1),(8,7,1),(12,3,5),(12,4,1),(13,1,1),(13,2,1),(13,3,1),(13,4,1),(13,5,1),(14,2,1),(14,4,1),(15,1,5),(15,2,1),(15,3,1);
/*!40000 ALTER TABLE `orderproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `p_id` int(10) NOT NULL AUTO_INCREMENT,
  `c_id` int(100) DEFAULT NULL,
  `pName` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `image` varchar(10000) DEFAULT NULL,
  `stock` int(10) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `availability` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `category` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'Potatoes 500g',NULL,'null',4996,174,'YES'),(2,1,'Red Onion 250g',NULL,NULL,5000,200,'Yes'),(3,1,'Pumpkin 500g',NULL,NULL,5000,90,'Yes'),(4,1,'Snake gourd 500g',NULL,NULL,5000,153,'Yes'),(5,1,'Carrot',NULL,NULL,5000,360,'Yes'),(6,2,'Sugar Plantain 500g',NULL,NULL,5000,131,'Yes'),(7,2,'Papaw 1000g',NULL,NULL,5000,330,'Yes'),(8,2,'Royal Gala Apple 500g',NULL,NULL,5000,1200,'Yes'),(9,2,'Red Grapes 500g',NULL,NULL,5000,965,'Yes'),(10,2,'Wood Apple 1000g',NULL,NULL,5000,318,'Yes'),(11,3,'Finest Frozen Duck 1pc',NULL,NULL,499,9900,'Yes'),(12,3,'Goldi Chickhen Sausages 240g',NULL,NULL,500,540,'Yes'),(14,2,'Green Apple 1Kg',NULL,'Null',4500,800,'NO');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT,
  `fName` varchar(20) DEFAULT NULL,
  `lName` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `pNo` int(10) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'GemBa','Nugeko','gembanuge@gmail.com','1212','madampe',710773633),(2,'mage','chubi','gembapixels@gmail.com','1122','gallenkanda',710770771),(3,'tharuka','pathiranage','nadeeshanipeshala@gmail.com','2222','pipi',712342313);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermsg`
--

DROP TABLE IF EXISTS `usermsg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usermsg` (
  `msg_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT NULL,
  `u_msg` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`msg_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `usermsg_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermsg`
--

LOCK TABLES `usermsg` WRITE;
/*!40000 ALTER TABLE `usermsg` DISABLE KEYS */;
INSERT INTO `usermsg` VALUES (3,1,'wassap nigger'),(4,2,'kohomada bro? ada wahi wage neda? redi tika geta gathnam hoda\r\n');
/*!40000 ALTER TABLE `usermsg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-08 18:04:56
