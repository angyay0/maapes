-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2015 a las 11:25:43
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `maapesdb`
--
CREATE DATABASE IF NOT EXISTS `maapesdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `maapesdb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `idQuestion` int(100) NOT NULL,
  `text` varchar(255) NOT NULL,
  `rgt` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `answer`
--

INSERT INTO `answer` (`id`, `idQuestion`, `text`, `rgt`) VALUES
(1, 1, 'Cuevana', 0),
(2, 1, 'Creeper', 1),
(3, 1, 'Zombie', 0),
(4, 2, 'Un Malo', 0),
(5, 2, 'Steve Sin Ojos', 1),
(6, 3, 'Si', 1),
(7, 3, 'No', 0),
(8, 3, 'Hay que jugar para saber', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE IF NOT EXISTS `ciudades` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `idEstado` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`id`, `nombre`, `idEstado`) VALUES
(1, 'Tuxtla Gutierrez', 1),
(2, 'Guadalajara', 2),
(4, 'Villahermosa', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE IF NOT EXISTS `estados` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`id`, `nombre`) VALUES
(1, 'Chiapas'),
(2, 'Jalisco'),
(3, 'Tabasco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mpersonas`
--

CREATE TABLE IF NOT EXISTS `mpersonas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `idCiudad` bigint(20) NOT NULL,
  `claveAcceso` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `mpersonas`
--

INSERT INTO `mpersonas` (`id`, `nombres`, `apellidos`, `direccion`, `telefono`, `idCiudad`, `claveAcceso`) VALUES
(1, 'Algun Tester', 'De Algun Test', '5a Test Nte 432', '1234567890', 1, NULL),
(2, 'Toribio', 'López Azcarraga', '5ta Ote Nte', '9612035323', 2, NULL),
(3, 'Toribio', 'López Azcarraga', '5ta Ote Nte', '9612035323', 4, NULL),
(4, 'Mauri', 'Agueda', 'Cualquiera', '2343213456', 1, '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `idSection` int(100) NOT NULL,
  `text` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `question`
--

INSERT INTO `question` (`id`, `idSection`, `text`) VALUES
(1, 1, '¿Como se llama el mounstro verde que explota?'),
(2, 1, '¿Quien es herobrine?'),
(3, 2, '¿Existen las ak47 en este juego?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `idRol` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRol`, `nombre`, `descripcion`) VALUES
(1, 'admin', 'Acceso a la administración del sistema');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `section`
--

CREATE TABLE IF NOT EXISTS `section` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `section`
--

INSERT INTO `section` (`id`, `title`) VALUES
(1, 'Minecraft'),
(2, 'COD'),
(3, 'Smash Bros.'),
(4, 'Generica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `test`
--

INSERT INTO `test` (`id`, `title`) VALUES
(1, 'Game Test'),
(3, 'Titanium Certification Test'),
(4, 'UnrealEngine Certification Test'),
(5, 'sometesst'),
(7, 'Mangel Test'),
(8, 'Cualquier Test'),
(9, 'Antidoping');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `testsection`
--

CREATE TABLE IF NOT EXISTS `testsection` (
  `id` int(11) NOT NULL,
  `idTest` int(11) NOT NULL,
  `idSection` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `testsection`
--

INSERT INTO `testsection` (`id`, `idTest`, `idSection`) VALUES
(1, 1, 1),
(2, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `try`
--

CREATE TABLE IF NOT EXISTS `try` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idTest` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `useranswer`
--

CREATE TABLE IF NOT EXISTS `useranswer` (
  `idTry` int(11) NOT NULL,
  `idAnswer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariorol`
--

CREATE TABLE IF NOT EXISTS `usuariorol` (
  `idUsuario` bigint(20) NOT NULL,
  `idRol` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuariorol`
--

INSERT INTO `usuariorol` (`idUsuario`, `idRol`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` bigint(20) NOT NULL,
  `nombrePrefijo` varchar(255) DEFAULT NULL,
  `nombreNombre` varchar(255) DEFAULT NULL,
  `nombreApellidoPaterno` varchar(255) DEFAULT NULL,
  `nombreApellidoMaterno` varchar(255) DEFAULT NULL,
  `nombrePosfijo` varchar(255) DEFAULT NULL,
  `nombreIniciales` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) NOT NULL,
  `claveAcceso` varchar(255) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombrePrefijo`, `nombreNombre`, `nombreApellidoPaterno`, `nombreApellidoMaterno`, `nombrePosfijo`, `nombreIniciales`, `nombreUsuario`, `claveAcceso`) VALUES
(1, 'Mauri', 'Mauri', 'Agueda', 'Cruz', 'Mauri', 'MA', 'Mauri', '12345');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
