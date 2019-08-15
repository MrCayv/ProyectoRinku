-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 15-08-2019 a las 00:02:20
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rinku`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `id` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cant_entregas` int(11) NOT NULL,
  `cubrio_turno` int(11) NOT NULL,
  `usu_creador` int(11) DEFAULT NULL,
  `creado` timestamp NULL DEFAULT NULL,
  `usu_modificador` int(11) DEFAULT NULL,
  `modificado` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`id`, `id_empleado`, `fecha`, `cant_entregas`, `cubrio_turno`, `usu_creador`, `creado`, `usu_modificador`, `modificado`, `status`) VALUES
(1, 2, '2019-08-12', 2, 0, 2, '2019-08-13 06:00:00', NULL, '2019-08-13 06:00:00', 1),
(2, 3, '2019-08-13', 3, 1, 1, '2019-08-13 06:00:00', 1, '2019-08-13 06:00:00', 1),
(3, 1, '2019-08-14', 3, 0, 1, '2019-08-14 09:44:00', NULL, '2019-08-14 09:44:00', 1),
(4, 4, '2019-07-31', 5, 0, 1, '2019-08-14 10:14:26', NULL, '2019-08-14 10:14:26', 1),
(5, 2, '2019-09-01', 4, 1, 1, '2019-08-14 10:14:47', NULL, '2019-08-14 10:14:47', 1),
(6, 2, '2019-08-15', 1, 0, 1, '2019-08-14 10:48:33', NULL, '2019-08-14 10:48:33', 1),
(7, 2, '2019-08-23', 2, 1, 1, '2019-08-14 12:42:53', NULL, '2019-08-14 12:42:53', 1),
(8, 4, '2019-08-16', 3, 1, 1, '2019-08-14 12:43:13', NULL, '2019-08-14 12:43:13', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `rol` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `usu_creador` int(11) DEFAULT NULL,
  `creado` timestamp NULL DEFAULT NULL,
  `usu_modificador` int(11) DEFAULT NULL,
  `modificado` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`id`, `nombre`, `rol`, `tipo`, `usu_creador`, `creado`, `usu_modificador`, `modificado`, `status`) VALUES
(1, 'Antonio Yamaguchi', 1, 1, 1, '2019-08-13 06:00:00', NULL, '2019-08-13 06:00:00', 1),
(2, 'Francisco', 3, 2, 1, '2019-08-13 23:54:44', 1, '2019-08-14 00:06:23', 1),
(3, 'Cargador', 2, 1, 1, '2019-08-14 00:06:52', 1, '2019-08-14 00:06:54', 0),
(4, 'Chuy Lopez', 1, 1, 1, '2019-08-14 10:13:57', NULL, '2019-08-14 10:13:57', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `usu_creador` int(11) DEFAULT NULL,
  `creado` timestamp NULL DEFAULT NULL,
  `usu_modificador` int(11) DEFAULT NULL,
  `modificado` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `password`, `nombre`, `usu_creador`, `creado`, `usu_modificador`, `modificado`, `status`) VALUES
(1, 'admin', 'admin', 'Administrador', 1, '2019-08-13 06:00:00', 1, '2019-08-13 22:57:28', 1),
(2, 'cesar', 'cesar', 'Cesar Yamaguchi', 1, '2019-08-13 22:05:35', 1, '2019-08-13 23:07:59', 1),
(3, 'joel', 'joel', 'Joel Castañeda', 1, '2019-08-13 22:07:17', 1, '2019-08-13 23:16:35', 1),
(4, 'paul', 'paul', 'Paul', 1, '2019-08-13 22:12:02', 1, '2019-08-13 23:16:27', 0),
(5, 'julio', 'julio', 'Julio Ernesto', 1, '2019-08-13 22:12:28', NULL, '2019-08-13 22:12:28', 1),
(6, 'bayo', 'bayo', 'Jose', 1, '2019-08-13 23:16:48', NULL, '2019-08-13 23:16:48', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `usu_creador` (`usu_creador`),
  ADD KEY `usu_modificador` (`usu_modificador`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usu_creador` (`usu_creador`),
  ADD KEY `usu_modificador` (`usu_modificador`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usu_creador` (`usu_creador`),
  ADD KEY `usu_modificador` (`usu_modificador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `trabajadores` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`usu_creador`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientos_ibfk_3` FOREIGN KEY (`usu_modificador`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD CONSTRAINT `trabajadores_ibfk_1` FOREIGN KEY (`usu_creador`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `trabajadores_ibfk_2` FOREIGN KEY (`usu_modificador`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`usu_creador`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`usu_modificador`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
