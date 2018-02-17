-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: librarydb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Steven','King'),(2,'Taras','Shevchenko'),(3,'Ivan','Franko'),(4,'Dan','Brown');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available_counter` int(11) DEFAULT NULL,
  `full_description` varchar(255) DEFAULT NULL,
  `general_counter` int(11) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `mainAuthor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm1t3yvw5i7olwdf32cwuul7ta` (`genre_id`),
  KEY `FKmtq7slqp5pbg0rhuwv49o2akp` (`mainAuthor_id`),
  CONSTRAINT `FKm1t3yvw5i7olwdf32cwuul7ta` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `FKmtq7slqp5pbg0rhuwv49o2akp` FOREIGN KEY (`mainAuthor_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,5,'Interesting.',5,'The Da Vinci Code','https://static.rogerebert.com/uploads/movie/movie_poster/the-da-vinci-code-2006/large_e5Tlc0mNhb9TvgCZknmnd3XaaKU.jpg',1,4),(2,3,'Interesting.',3,'Interesting.','https://static.rogerebert.com/uploads/movie/movie_poster/the-da-vinci-code-2006/large_e5Tlc0mNhb9TvgCZknmnd3XaaKU.jpg',3,2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_author` (
  `collaborationBooks_id` int(11) NOT NULL,
  `collaborationAuthors_id` int(11) NOT NULL,
  KEY `FKmdk88sr3yf4evo62it0yth18v` (`collaborationAuthors_id`),
  KEY `FK7ilifu5fj5ijs26mdr306c8mf` (`collaborationBooks_id`),
  CONSTRAINT `FK7ilifu5fj5ijs26mdr306c8mf` FOREIGN KEY (`collaborationBooks_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKmdk88sr3yf4evo62it0yth18v` FOREIGN KEY (`collaborationAuthors_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_author`
--

LOCK TABLES `book_author` WRITE;
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_id_user_id`
--

DROP TABLE IF EXISTS `book_id_user_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_id_user_id` (
  `book_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `FKgfxw2ox5fuo5f5psbnp2wt5l0` (`user_id`),
  KEY `FKcds3d2bd31vh9cm2vrkvd5urc` (`book_id`),
  CONSTRAINT `FKcds3d2bd31vh9cm2vrkvd5urc` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKgfxw2ox5fuo5f5psbnp2wt5l0` FOREIGN KEY (`user_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_id_user_id`
--

LOCK TABLES `book_id_user_id` WRITE;
/*!40000 ALTER TABLE `book_id_user_id` DISABLE KEYS */;
INSERT INTO `book_id_user_id` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `book_id_user_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `login` varchar(14) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `home_address` varchar(255) DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,12,'Ghjjjjjdd','Sdss','111','111',NULL,NULL,NULL),(2,23,'dfgh','dfghj','222','222',NULL,NULL,NULL),(3,34,'erty','erty','333','333',NULL,NULL,NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_book`
--

DROP TABLE IF EXISTS `client_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_book` (
  `Client_id` int(11) NOT NULL,
  `readedBooks_id` int(11) NOT NULL,
  KEY `FK9xteam0rw49v7pox9e5ie9dut` (`readedBooks_id`),
  KEY `FKg2viu9e7dv1836s7wdb0tfd1u` (`Client_id`),
  CONSTRAINT `FK9xteam0rw49v7pox9e5ie9dut` FOREIGN KEY (`readedBooks_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKg2viu9e7dv1836s7wdb0tfd1u` FOREIGN KEY (`Client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_book`
--

LOCK TABLES `client_book` WRITE;
/*!40000 ALTER TABLE `client_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copy_of_book`
--

DROP TABLE IF EXISTS `copy_of_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copy_of_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pages_amount` int(11) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9s1k4asdfybo80qnnrw7md7nf` (`book_id`),
  CONSTRAINT `FK9s1k4asdfybo80qnnrw7md7nf` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copy_of_book`
--

LOCK TABLES `copy_of_book` WRITE;
/*!40000 ALTER TABLE `copy_of_book` DISABLE KEYS */;
INSERT INTO `copy_of_book` VALUES (1,232,'2001-01-20',1),(2,232,'2001-01-20',1),(3,434,'2001-01-20',2),(4,434,'2001-01-20',2);
/*!40000 ALTER TABLE `copy_of_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genre_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Detective'),(2,'Drama'),(3,'Science-fiction'),(4,'Fantasy'),(5,'Autobiography ');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrowing_time` datetime DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  `copyOfBook_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh7qtmtak8l4hmuu2g8amoc0dv` (`copyOfBook_id`),
  KEY `FK1ufs3xmmtk2yl6sbghs568in3` (`user_id`),
  CONSTRAINT `FK1ufs3xmmtk2yl6sbghs568in3` FOREIGN KEY (`user_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKh7qtmtak8l4hmuu2g8amoc0dv` FOREIGN KEY (`copyOfBook_id`) REFERENCES `copy_of_book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-17 18:34:17
