-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2016 a las 19:19:21
-- Versión del servidor: 5.7.11-log
-- Versión de PHP: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prestamodispositivosdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivo`
--

DROP TABLE IF EXISTS `dispositivo`;
CREATE TABLE IF NOT EXISTS `dispositivo` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `marca` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `modelo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `cantidad` int(4) NOT NULL,
  `imagen` mediumblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadosolicitud`
--

DROP TABLE IF EXISTS `estadosolicitud`;
CREATE TABLE IF NOT EXISTS `estadosolicitud` (
  `id` int(1) NOT NULL,
  `estado` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `estadosolicitud`
--

INSERT INTO `estadosolicitud` (`id`, `estado`) VALUES
(1, 'Cancelada'),
(2, 'Agendada'),
(3, 'Cerrada'),
(4, 'Devuelta'),
(5, 'Activa'),
(6, 'Demorada'),
(7, 'Abortada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(2) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE IF NOT EXISTS `solicitud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `dispositivo` int(4) NOT NULL,
  `cantidad` int(2) NOT NULL,
  `fechainicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fechafin` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `fechasolicitud` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estadosolicitud` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `documento` (`usuario`),
  KEY `dispositivo` (`dispositivo`),
  KEY `estadosolicitud` (`estadosolicitud`),
  KEY `estadosolicitud_2` (`estadosolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
CREATE TABLE IF NOT EXISTS `tipodocumento` (
  `id` int(1) NOT NULL,
  `tipo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`id`, `tipo`) VALUES
(1, 'Cédula de Ciudadanía'),
(2, 'Tarjeta de Identidad'),
(3, 'Cédula de Extranjería');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `documento` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `tipodocumento` int(1) NOT NULL,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `correoelectronico` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `rol` int(2) NOT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contrasena` text COLLATE utf8_spanish_ci NOT NULL,
  `nombreusuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`nombreusuario`) USING BTREE,
  UNIQUE KEY `nombreusuario` (`nombreusuario`),
  KEY `usuario_tipodocumento` (`tipodocumento`),
  KEY `rol` (`rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `solicitud_dispositivo` FOREIGN KEY (`dispositivo`) REFERENCES `dispositivo` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `solicitud_estadosolicitud` FOREIGN KEY (`estadosolicitud`) REFERENCES `estadosolicitud` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `solicitud_nombreusuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`nombreusuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_rol` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_tipodocumento` FOREIGN KEY (`tipodocumento`) REFERENCES `tipodocumento` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
