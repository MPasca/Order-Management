-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2021 at 09:57 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `warehousedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(120) NOT NULL,
  `telephone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `name`, `email`, `address`, `telephone`) VALUES
(1, 'John Doe', 'johnDoe@domain.com', 'Some random street no 42', '0712345678'),
(2, 'Test', 'test@test.com', 'test', '0787654321'),
(3, 'testReflection', 'test@reflection.com', 'agndfgoias', '0712345555'),
(5, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(6, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(7, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(8, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(9, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(10, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(11, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(12, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(13, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222'),
(14, 'Jane Doe', 'abcd@abcd.com', 'Str Ceahlau, nr 77, Cluj-Napoca, Cluj', '+40722222222');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `clientId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `clientId`, `productId`, `quantity`) VALUES
(1, 1, 1, 3),
(2, 1, 2, 3),
(3, 1, 2, 5),
(4, 2, 2, 1),
(5, 1, 1, 1),
(6, 1, 1, 1),
(7, 14, 12, 5),
(8, 5, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `quantity`, `price`) VALUES
(1, 'test', 20, 0.99),
(2, 'newName', 44, 1.2),
(3, 'toDelete', 12, 2.34),
(4, 'toDelete', 11, 2.34),
(5, 'toDelete', 12, 2.34),
(6, 'toDelete', 12, 2.34),
(7, 'toDelete', 12, 2.34),
(8, 'toDelete', 12, 2.34),
(9, 'toDelete', 12, 2.34),
(10, 'toDelete', 12, 2.34),
(11, 'toDelete', 12, 2.34),
(12, 'toDelete', 7, 2.34);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
