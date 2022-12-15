-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: perfumeria
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_perfume` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) NOT NULL,
  `costo` int NOT NULL,
  `cantidad` int NOT NULL,
  `img` varchar(2000) NOT NULL,
  PRIMARY KEY (`id_perfume`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'guess 1981 eau de toilette',3400,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304697/guess_fp7jig.png'),(2,'jesus del pozo eau de toilette halloween',1920,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304697/morado_lq8zax.png'),(3,'Guess Seductive',3220,75,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304697/guessgold_umzwgp.png'),(4,'Perry Ellis 360',2220,375,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304698/perriElis_dmyxzc.png'),(5,'Katy Perry',3400,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304656/katyPerry_mqusec.png'),(6,'rose goldea eau de parfum',2320,300,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304655/janeDoe_mdun8f.png'),(7,'Paco Rabanne Invictus',5220,150,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304656/invictus_pswdy6.png'),(8,'ferragamo',1220,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304655/ferragamo_tomugp.png'),(9,'bath and body works noir men',2920,200,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304605/Noir_rzkrkh.png'),(10,'Calvin Klein Be',4220,155,'https://res.cloudinary.com/rookiesquad/image/upload/v1670305005/cK_vpgaqn.png'),(11,'Dolce & Gabbana K',2220,275,'https://res.cloudinary.com/rookiesquad/image/upload/v1670305006/DG_ipx4t4.bmp'),(12,'Ferrari',1400,125,'https://res.cloudinary.com/rookiesquad/image/upload/v1670305005/ferrari_dktnzx.png'),(13,'Bleu Supreme',920,300,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304606/bleu_a5h3ft.png'),(14,'adidas team five',1220,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304606/eauAdidas_u79vcw.png'),(15,'Paw Patrol',520,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304606/pawPatrol_aytngz.png'),(16,'desenho nas nubes',720,175,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304580/desenho_sw0aof.png'),(17,'Cenicienta',900,155,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304579/Cenicienta_z9gr0b.png'),(18,'Minnie',420,200,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304580/Minnie_sq0fap.png'),(19,'ferrioni blue terrier',890,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670305005/FERRION_htmphd.png'),(20,'tous baby tous',520,100,'https://res.cloudinary.com/rookiesquad/image/upload/v1670304578/TousBaby_doflla.png'),(21,'Rafa Marquez Classic',1423,200,'https://res.cloudinary.com/rookiesquad/image/upload/v1670991198/czthaknls1tuguhmkgwt.jpg\"');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-14 16:11:59
