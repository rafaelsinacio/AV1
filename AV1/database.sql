-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2025 at 03:40 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `av1`
--

-- --------------------------------------------------------

--
-- Table structure for table `equipe`
--

CREATE TABLE `equipe` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipe`
--

INSERT INTO `equipe` (`id`, `nome`) VALUES
(1, 'Red Bull Racing'),
(2, 'Ferrari'),
(3, 'Mercedes'),
(4, 'McLaren'),
(5, 'Aston Martin'),
(6, 'Alpine'),
(7, 'Haas'),
(8, 'Williams'),
(9, 'Alfa Romeo Racing'),
(10, 'AlphaTauri');

-- --------------------------------------------------------

--
-- Table structure for table `piloto`
--

CREATE TABLE `piloto` (
  `id` bigint(20) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `idade` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `equipe_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `piloto`
--

INSERT INTO `piloto` (`id`, `categoria`, `idade`, `nome`, `equipe_id`) VALUES
(2, 'Formula 1', 26, 'Max Verstappen', 1),
(3, 'Formula 1', 27, 'Charles Leclerc', 2),
(4, 'Formula 1', 25, 'George Russell', 3),
(5, 'Formula 1', 25, 'Lando Norris', 4),
(6, 'Formula 1', 23, 'Oscar Piastri', 4),
(7, 'Formula 1', 43, 'Fernando Alonso', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `piloto`
--
ALTER TABLE `piloto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdm5jypq73akthstdca6mrgot1` (`equipe_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `piloto`
--
ALTER TABLE `piloto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `piloto`
--
ALTER TABLE `piloto`
  ADD CONSTRAINT `FKdm5jypq73akthstdca6mrgot1` FOREIGN KEY (`equipe_id`) REFERENCES `equipe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
