-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 23, 2020 at 08:20 AM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `market`
--

-- --------------------------------------------------------

--
-- Table structure for table `oauth_role`
--

CREATE TABLE `oauth_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `role_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oauth_role`
--

INSERT INTO `oauth_role` (`id`, `role_name`, `role_status`) VALUES
(1, 'ROLE_ADMIN', 'active'),
(2, 'ROLE_USER', 'active'),
(3, 'ROLE_USER2', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_user`
--

CREATE TABLE `oauth_user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `role` int(5) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `role_entity_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table user for auth';

--
-- Dumping data for table `oauth_user`
--

INSERT INTO `oauth_user` (`id`, `first_name`, `last_name`, `username`, `password`, `address`, `tel`, `gender`, `role`, `status`, `role_entity_id`) VALUES
(13, 'artt', 'user is admin', 'artt', '$2a$10$66zwH6NN4L/7yZ.MsPvtqe8syfa/gCoVl8tIlak/TnyVECJd/54oS', '0', '', '', 1, 'active', NULL),
(23, 'นาย อมร', 'นอนวัด', 'amon', '$2a$10$CfBJ44Hr6qBXBBKoWoRQku/1g8QlMtPz8Ee8qZAY4MJ0c6aKCvAtO', '0', '', '', 2, 'active', NULL),
(27, 'นายสมร', 'สกุลสัง', 'smon', '$2a$10$BPEUT/JX2v/VvNDakNj5qOZh0AoqH.dq3kxx9gP5PTdCmsfVPgery', '0', '', '', 2, 'active', NULL),
(28, 'ดวงพร', 'ดี', 'joy', '$2a$10$vdP48j/3/BOb.z1usXS.XuUy8HI9jpDUWkqNdLvQuqH9EZaW6lIx.', '0', '', '', 2, 'active', NULL),
(29, 'joyy', 'dj', 'kkk', '$2a$10$GugL/KdFL0g4PMM88YbQy.e9HZ4qIdKgoZ6hx7xRBL2tpjQdgRzZm', 'dddde', '123456789', 'f', 3, 'active', NULL),
(30, 'joyy', 'dj', 'ttt', '$2a$10$Frq7pKtGaNSFXXfELphRqeIhxoKh7fnSjCCjRgyLrXd7HZv3YFa82', 'dddde', '123456789', 'f', 2, 'active', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_order`
--

CREATE TABLE `tb_order` (
  `order_id` int(5) NOT NULL,
  `id` int(5) NOT NULL,
  `shop_id` int(5) NOT NULL,
  `pd_id` int(5) NOT NULL,
  `order_name` varchar(50) NOT NULL,
  `order_date` varchar(50) NOT NULL,
  `order_number` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_order`
--

INSERT INTO `tb_order` (`order_id`, `id`, `shop_id`, `pd_id`, `order_name`, `order_date`, `order_number`) VALUES
(1, 1, 1, 1, 'uj', 'y', 0),
(2, 1, 1, 1, 'hhhhhh', 'hh', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_payment`
--

CREATE TABLE `tb_payment` (
  `pm_id` int(5) NOT NULL,
  `id` int(5) NOT NULL,
  `pd_id` int(5) NOT NULL,
  `pm_totalpric` decimal(10,4) NOT NULL,
  `pm_img` varchar(50) NOT NULL,
  `pm_date` varchar(100) NOT NULL,
  `pm_status` varchar(3) NOT NULL,
  `pm_parcel` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_payment`
--

INSERT INTO `tb_payment` (`pm_id`, `id`, `pd_id`, `pm_totalpric`, `pm_img`, `pm_date`, `pm_status`, `pm_parcel`) VALUES
(1, 1, 1, '0.0000', 'l', 'l', 'l', '0'),
(2, 2, 111, '1.0000', 'ffs', 'hh', 'gg', '0'),
(3, 2, 111, '1.0000', 'ffs', 'hh', 'gg', '0');

-- --------------------------------------------------------

--
-- Table structure for table `tb_product`
--

CREATE TABLE `tb_product` (
  `pd_id` int(5) NOT NULL,
  `shop_id` int(5) NOT NULL,
  `pd_name` varchar(50) NOT NULL,
  `pd_img` varchar(50) NOT NULL,
  `pd_price` decimal(10,4) DEFAULT NULL,
  `pd_details` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_product`
--

INSERT INTO `tb_product` (`pd_id`, `shop_id`, `pd_name`, `pd_img`, `pd_price`, `pd_details`) VALUES
(1, 1, 'k', 'k', '0.0000', 'k');

-- --------------------------------------------------------

--
-- Table structure for table `tb_report`
--

CREATE TABLE `tb_report` (
  `rp_id` int(11) NOT NULL,
  `id` int(5) NOT NULL,
  `shop_id` int(5) NOT NULL,
  `pd_id` int(5) NOT NULL,
  `rp_product` varchar(50) NOT NULL,
  `rp_trackingnumber` varchar(13) NOT NULL,
  `rp_date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_report`
--

INSERT INTO `tb_report` (`rp_id`, `id`, `shop_id`, `pd_id`, `rp_product`, `rp_trackingnumber`, `rp_date`) VALUES
(1, 1, 1, 1, 'k', 'k', 'k'),
(2, 1, 1, 1, 'h', 'h', 'h'),
(3, 1, 111, 1, 'ffs', 'hh', 'gg');

-- --------------------------------------------------------

--
-- Table structure for table `tb_shop`
--

CREATE TABLE `tb_shop` (
  `shop_id` int(5) NOT NULL,
  `id` int(5) NOT NULL,
  `shop_name` varchar(50) NOT NULL,
  `shop_img` varchar(50) NOT NULL,
  `shop_address` varchar(100) NOT NULL,
  `shop_tel` varchar(10) NOT NULL,
  `bank_account_no` varchar(10) NOT NULL,
  `bank_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_shop`
--

INSERT INTO `tb_shop` (`shop_id`, `id`, `shop_name`, `shop_img`, `shop_address`, `shop_tel`, `bank_account_no`, `bank_name`) VALUES
(1, 1, '111', 'sdkd', 'ffkffs', '111', '0', ''),
(2, 1, '111', 'sdkd', 'ffkffs', '111', '0', '');

-- --------------------------------------------------------

--
-- Table structure for table `tb_systembank`
--

CREATE TABLE `tb_systembank` (
  `id` int(5) NOT NULL,
  `bank_account` varchar(10) NOT NULL,
  `bank_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_systembank`
--

INSERT INTO `tb_systembank` (`id`, `bank_account`, `bank_name`) VALUES
(1, '1234567890', 'joy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `oauth_role`
--
ALTER TABLE `oauth_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth_user`
--
ALTER TABLE `oauth_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl5alypubd40lwejc45vl35wjb` (`role`),
  ADD KEY `FKcgvlbw3uxs532jje6xsul0v8o` (`role_entity_id`);

--
-- Indexes for table `tb_order`
--
ALTER TABLE `tb_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `tb_order` (`id`);

--
-- Indexes for table `tb_payment`
--
ALTER TABLE `tb_payment`
  ADD PRIMARY KEY (`pm_id`),
  ADD KEY `tb_pament` (`id`),
  ADD KEY `pd_id` (`pd_id`);

--
-- Indexes for table `tb_product`
--
ALTER TABLE `tb_product`
  ADD PRIMARY KEY (`pd_id`),
  ADD KEY `tb_product` (`shop_id`);

--
-- Indexes for table `tb_report`
--
ALTER TABLE `tb_report`
  ADD PRIMARY KEY (`rp_id`),
  ADD KEY `tb_repot` (`id`),
  ADD KEY `tb_report` (`pd_id`);

--
-- Indexes for table `tb_shop`
--
ALTER TABLE `tb_shop`
  ADD PRIMARY KEY (`shop_id`),
  ADD KEY `tb_shop` (`id`);

--
-- Indexes for table `tb_systembank`
--
ALTER TABLE `tb_systembank`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `oauth_role`
--
ALTER TABLE `oauth_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `oauth_user`
--
ALTER TABLE `oauth_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `tb_order`
--
ALTER TABLE `tb_order`
  MODIFY `order_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tb_payment`
--
ALTER TABLE `tb_payment`
  MODIFY `pm_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_product`
--
ALTER TABLE `tb_product`
  MODIFY `pd_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tb_report`
--
ALTER TABLE `tb_report`
  MODIFY `rp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_shop`
--
ALTER TABLE `tb_shop`
  MODIFY `shop_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tb_systembank`
--
ALTER TABLE `tb_systembank`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `oauth_user`
--
ALTER TABLE `oauth_user`
  ADD CONSTRAINT `FKcgvlbw3uxs532jje6xsul0v8o` FOREIGN KEY (`role_entity_id`) REFERENCES `oauth_role` (`id`),
  ADD CONSTRAINT `FKl5alypubd40lwejc45vl35wjb` FOREIGN KEY (`role`) REFERENCES `oauth_role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
