-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.5.37-0+wheezy1

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
-- Current Database: `mydb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mydb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mydb`;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `bairro` varchar(200) DEFAULT NULL,
  `cidade` varchar(200) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'asdasd','sadas','dsada',NULL,NULL,NULL),(2,'sadasd','sdasd','asda',NULL,NULL,NULL),(3,'sadasd','sdasd','asda',NULL,NULL,NULL),(4,'sadasd','sdasd','asda',NULL,NULL,NULL),(5,'sadasd','sdasd','asda',NULL,NULL,NULL),(6,'sadasd','sdasd','asda',NULL,NULL,NULL),(7,'adasda','123123','123123',NULL,NULL,NULL),(8,'3453453','wqeqeqw','qweewqe',NULL,NULL,NULL),(9,'3453453','wqeqeqw','qweewqe',NULL,NULL,NULL),(10,'3453453','wqeqeqw','qweewqe',NULL,NULL,NULL),(11,'546456','21313','13123',NULL,NULL,NULL),(12,'546456','21313','13123',NULL,NULL,NULL),(13,'34234','sdasdas','asdasd',NULL,NULL,NULL),(14,'sadas','sdasd','asda',NULL,NULL,NULL),(15,'asdasd','sadas','asd',NULL,NULL,NULL),(29,'asdasd','asdsad','asda',NULL,NULL,NULL),(30,'asdas','asdasd','asdasd',NULL,NULL,NULL),(31,'123123','asdas','asdas',NULL,NULL,NULL),(32,'Kevim','asdasd','asdas',NULL,NULL,NULL),(33,'adasd','asdasd','asdasd',NULL,NULL,NULL);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Direito`
--

DROP TABLE IF EXISTS `Direito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Direito` (
  `id` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Direito`
--

LOCK TABLES `Direito` WRITE;
/*!40000 ALTER TABLE `Direito` DISABLE KEYS */;
INSERT INTO `Direito` VALUES (1,'Cadastrar administrador'),(2,'Cadastrar pizza'),(3,'Alterar usuario'),(4,'Efetuar pedido');
/*!40000 ALTER TABLE `Direito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupo`
--

DROP TABLE IF EXISTS `Grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `ativo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupo`
--

LOCK TABLES `Grupo` WRITE;
/*!40000 ALTER TABLE `Grupo` DISABLE KEYS */;
INSERT INTO `Grupo` VALUES (1,'Administrador',''),(2,'Usuario',''),(3,'Cozinheiro','');
/*!40000 ALTER TABLE `Grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupo_Direito`
--

DROP TABLE IF EXISTS `Grupo_Direito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupo_Direito` (
  `id_grupo` int(11) NOT NULL,
  `id_direito` int(11) NOT NULL,
  PRIMARY KEY (`id_grupo`,`id_direito`),
  KEY `fk_Grupo_Direito_1` (`id_grupo`),
  KEY `fk_Grupo_Direito_2` (`id_direito`),
  CONSTRAINT `fk_Grupo_Direito_1` FOREIGN KEY (`id_grupo`) REFERENCES `Grupo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Grupo_Direito_2` FOREIGN KEY (`id_direito`) REFERENCES `Direito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupo_Direito`
--

LOCK TABLES `Grupo_Direito` WRITE;
/*!40000 ALTER TABLE `Grupo_Direito` DISABLE KEYS */;
INSERT INTO `Grupo_Direito` VALUES (1,1),(2,4);
/*!40000 ALTER TABLE `Grupo_Direito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupo_Usuario`
--

DROP TABLE IF EXISTS `Grupo_Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupo_Usuario` (
  `id_grupo` int(11) NOT NULL,
  `login` varchar(40) NOT NULL,
  PRIMARY KEY (`id_grupo`,`login`),
  KEY `fk_Grupo_Usuario_1` (`login`),
  KEY `fk_Grupo_Usuario_2` (`id_grupo`),
  CONSTRAINT `fk_Grupo_Usuario_1` FOREIGN KEY (`login`) REFERENCES `Usuario` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Grupo_Usuario_2` FOREIGN KEY (`id_grupo`) REFERENCES `Grupo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupo_Usuario`
--

LOCK TABLES `Grupo_Usuario` WRITE;
/*!40000 ALTER TABLE `Grupo_Usuario` DISABLE KEYS */;
INSERT INTO `Grupo_Usuario` VALUES (1,'admin'),(2,'login');
/*!40000 ALTER TABLE `Grupo_Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `login` varchar(40) NOT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `ativo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('12312','123',''),('admin','admin',''),('asdasd','123',NULL),('lemanoman','123',''),('login','123',''),('sadasd','123','');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario_Cliente`
--

DROP TABLE IF EXISTS `Usuario_Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario_Cliente` (
  `id_cliente` int(11) NOT NULL,
  `login` varchar(40) NOT NULL,
  PRIMARY KEY (`id_cliente`,`login`),
  KEY `fk_Usuario_Cliente_1` (`login`),
  KEY `fk_Usuario_Cliente_2` (`id_cliente`),
  CONSTRAINT `fk_Usuario_Cliente_1` FOREIGN KEY (`login`) REFERENCES `Usuario` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Cliente_2` FOREIGN KEY (`id_cliente`) REFERENCES `Cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario_Cliente`
--

LOCK TABLES `Usuario_Cliente` WRITE;
/*!40000 ALTER TABLE `Usuario_Cliente` DISABLE KEYS */;
INSERT INTO `Usuario_Cliente` VALUES (29,'asdasd'),(30,'sadasd'),(31,'12312'),(32,'lemanoman'),(33,'login');
/*!40000 ALTER TABLE `Usuario_Cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-04 14:49:53
