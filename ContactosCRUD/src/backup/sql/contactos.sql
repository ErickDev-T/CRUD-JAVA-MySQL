-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.33 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para contactos
DROP DATABASE IF EXISTS `contactos`;
CREATE DATABASE IF NOT EXISTS `contactos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `contactos`;

-- Volcando estructura para tabla contactos.tbl_redes_sociales
DROP TABLE IF EXISTS `tbl_redes_sociales`;
CREATE TABLE IF NOT EXISTS `tbl_redes_sociales` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='Esta tabla guarda las informaciones referentes a las redes sociales que puden ver la agenda de contactos.';

-- Volcando datos para la tabla contactos.tbl_redes_sociales: ~0 rows (aproximadamente)
DELETE FROM `tbl_redes_sociales`;
/*!40000 ALTER TABLE `tbl_redes_sociales` DISABLE KEYS */;
INSERT INTO `tbl_redes_sociales` (`Id`, `Nombre`, `Direccion`) VALUES
	(1, 'facebook', 'http://wwww.facebook.com/rosannarosario');
/*!40000 ALTER TABLE `tbl_redes_sociales` ENABLE KEYS */;

-- Volcando estructura para tabla contactos.tbl_usuarios
DROP TABLE IF EXISTS `tbl_usuarios`;
CREATE TABLE IF NOT EXISTS `tbl_usuarios` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `Telefonos` varchar(13) DEFAULT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='Esta tabla guarda las informaciones referentes a los usuarios que puden ver la agenda de contactos.';

-- Volcando datos para la tabla contactos.tbl_usuarios: ~5 rows (aproximadamente)
DELETE FROM `tbl_usuarios`;
/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` (`Id`, `Nombres`, `Apellidos`, `Telefonos`, `Correo`) VALUES
	(1, 'Jorge', 'Feliz', '809-567-8900', 'jess@gmail.com'),
	(2, 'Miguel', 'Perez', '809-567-8900', 'mperez@gmail.com'),
	(3, 'Jose', 'Mojica', '809-567-8923', 'jomojica@gmail.com'),
	(4, 'Alexander', 'Fleming', '809-567-5678', 'jalex@gmail.com'),
	(5, 'Angel', 'Estevez', '809-566-3067', 'esteveza@gmail.com'),
	(6, 'Jesus Manuel', 'Mendoza', '809-567-8900', 'jeque@gmail.com'),
	(7, 'Schaquile', 'Oneill', '890-678-4573', 'chaq@correo.com');
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
