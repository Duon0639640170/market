-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 26, 2020 at 04:09 PM
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
  `address` varchar(100) DEFAULT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `role` int(5) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `role_entity_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table user for auth';

--
-- Dumping data for table `oauth_user`
--

INSERT INTO `oauth_user` (`id`, `first_name`, `last_name`, `username`, `password`, `address`, `tel`, `gender`, `role`, `status`, `role_entity_id`) VALUES
(13, 'artt', 'user is admin', 'artt', '$2a$10$66zwH6NN4L/7yZ.MsPvtqe8syfa/gCoVl8tIlak/TnyVECJd/54oS', '0235550000', '0123456789', 'F', 1, 'active', NULL),
(23, 'นาย อมร', 'นอนวัด', 'amon', '$2a$10$CfBJ44Hr6qBXBBKoWoRQku/1g8QlMtPz8Ee8qZAY4MJ0c6aKCvAtO', '0', '', '', 2, 'active', NULL),
(27, 'นายสมร', 'สกุลสัง', 'smon', '$2a$10$BPEUT/JX2v/VvNDakNj5qOZh0AoqH.dq3kxx9gP5PTdCmsfVPgery', 'บ้านโคกเสือเฒ่า', '1111123456', 'M', 2, 'active', NULL),
(28, 'ดวงพร', 'พลเยี่ยม', 'joy', '$2a$10$vdP48j/3/BOb.z1usXS.XuUy8HI9jpDUWkqNdLvQuqH9EZaW6lIx.', 'ร้อยเอ็ด', '0636547895', 'f', 2, 'active', NULL),
(40, 'newshop', 'lastname', 'newShop', '$2a$10$SbohNx9xhTH9NSCZFJ615O88Hq5qzE1EWZn3uFZ9tan3ZGHuydvMO', 'bkk', '0844444444', 'F', 2, 'active', NULL),
(42, 'กนกพร', 'ทองหล่อ', 'pukgy', '$2a$10$PHaw2xb573MfEp75H8RzWuITSUmdOQc9KTOP30QFiv0SIvQ.WNPs2', 'ผดุงวิถี1 ต.ตลาด อ.เมือง  จ.มหาสารคาม', '0639640170', 'F', 2, 'active', NULL),
(43, 'ผึ้ง', 'เชื้อกุล', 'pueng', '$2a$10$qwegonDB2YyCHkYqJh3naune86a1WGsJfQRAoTYWT58cVc5LVONKa', '11 ซอยนครสวรรค์ 6/3, ถนนนครสวรรค์, ตำบลตลาด อำเภอเมืองมหาสารคาม จังหวัดมหาสารคาม, 44000 043 743 130', '0639640170', 'F', 2, 'active', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_order`
--

CREATE TABLE `tb_order` (
  `order_id` int(5) NOT NULL,
  `id` int(5) NOT NULL,
  `shop_id` int(5) DEFAULT NULL,
  `pd_id` int(5) DEFAULT NULL,
  `order_ref` varchar(255) NOT NULL,
  `order_name` varchar(50) DEFAULT NULL,
  `order_date` varchar(50) DEFAULT NULL,
  `order_number` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_order`
--

INSERT INTO `tb_order` (`order_id`, `id`, `shop_id`, `pd_id`, `order_ref`, `order_name`, `order_date`, `order_number`) VALUES
(25, 42, 21, 19, '1', 'ordername', '2020-08-23 23:04:24.314', 1),
(26, 42, 21, 22, '1', 'ordername', '2020-08-23 23:18:23.758', 1),
(27, 28, 21, 19, '1', 'ordername', '2020-08-24 10:29:48.215', 1),
(28, 28, 21, 19, '1', 'ordername', '2020-08-24 10:34:17.162', 2),
(29, 28, 21, 19, '1', 'ordername', '2020-08-24 10:37:52.843', 2),
(30, 28, 21, 19, '1', 'ordername', '2020-08-24 10:46:48.063', 2),
(31, 28, 21, 21, '1', 'ordername', '2020-08-24 10:46:48.063', 4),
(32, 28, 21, 23, '1', 'ordername', '2020-08-24 10:46:48.063', 3),
(33, 28, 21, 19, '1', 'ordername', '2020-08-24 10:50:36.399', 2),
(34, 28, 21, 21, '1', 'ordername', '2020-08-24 10:50:36.399', 4),
(35, 28, 21, 23, '1', 'ordername', '2020-08-24 10:50:36.399', 3),
(36, 28, 40, 27, '1', 'ordername', '2020-08-24 10:50:36.399', 1),
(37, 28, 40, 25, '1', 'ordername', '2020-08-24 11:16:30.945', 2),
(38, 28, 40, 24, '1', 'ordername', '2020-08-24 11:16:30.945', 2),
(39, 28, 21, 19, '1', 'ordername', '2020-08-24 15:04:46.127', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_payment`
--

CREATE TABLE `tb_payment` (
  `pm_id` int(5) NOT NULL,
  `id` int(5) NOT NULL,
  `dr_adress` varchar(255) NOT NULL,
  `dr_status` varchar(50) NOT NULL,
  `order_ref` varchar(255) NOT NULL,
  `pm_totalpric` decimal(10,4) NOT NULL,
  `pm_img` varchar(50) DEFAULT NULL,
  `pm_date` varchar(100) DEFAULT NULL,
  `pm_status` varchar(3) DEFAULT NULL,
  `tracking_no` varchar(15) DEFAULT NULL,
  `pm_no` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_payment`
--

INSERT INTO `tb_payment` (`pm_id`, `id`, `dr_adress`, `dr_status`, `order_ref`, `pm_totalpric`, `pm_img`, `pm_date`, `pm_status`, `tracking_no`, `pm_no`) VALUES
(19, 42, 'ร้อยเอ็ด', '', '1', '100.0000', '99416959_749382465805837_4777800677533417472_n.jpg', '24-08-2020', 'Y', '12345675851TH', '42-23082020230431');

-- --------------------------------------------------------

--
-- Table structure for table `tb_product`
--

CREATE TABLE `tb_product` (
  `pd_id` int(5) NOT NULL,
  `shop_id` int(5) NOT NULL,
  `type_id` int(11) NOT NULL,
  `pd_name` varchar(50) DEFAULT NULL,
  `pd_img` varchar(50) DEFAULT NULL,
  `pd_price` decimal(10,4) DEFAULT NULL,
  `pd_details` varchar(50) DEFAULT NULL,
  `pd_number` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_product`
--

INSERT INTO `tb_product` (`pd_id`, `shop_id`, `type_id`, `pd_name`, `pd_img`, `pd_price`, `pd_details`, `pd_number`) VALUES
(19, 21, 2, 'กล้วยน้ำว้า', 'กล้วย.jpg', '100.0000', 'หอม อร่อย', 4),
(21, 21, 2, 'ขนุน', 'ขนุน.jpg', '15.0000', 'หวาน อร่อย เนื้อแน่น สะดวกต่อการรับประทาน', 10),
(22, 21, 2, 'แตงโม', 'แตงโม.jpg', '20.0000', 'กรอบ อร่อย ไร้เม็ด หวาน ฉ่ำน้ำ', 10),
(23, 21, 1, 'บวบ', 'มะบวบ.jpg', '15.0000', 'สด ใหม่ ไร้สารพิษ', 10),
(24, 40, 1, 'เสื่อ', 'b.jpg', '300.0000', 'ทนทาน ใช้สำหรับปูนั่ง นอน ทำมาจากธรรมชาติ', 10),
(25, 40, 1, 'ตะกร้าไม้หวาย', 'f.jpg', '300.0000', 'ทำมาจากธรรมชาติ ทนทานต่อการใช้งาน', 10),
(26, 40, 1, 'มวย', 'a.jpg', '150.0000', 'ทำมาจากวัสดุธรรมชาติ ทนนทานต่อการโดนความร้อน', 10),
(27, 40, 1, 'สุ่มไก่', 'i.jpg', '200.0000', 'ทำมาจากวัสดุธรรมชาติ ทนทาน ', 10);

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
(21, 27, 'กินอยู่แบบพอเพียง', 'ff.jpg', 'โพนทอง จ.ร้อยเอ็ด', '0639640170', '0123589641', 'กสิกร'),
(24, 40, 'ShopName', 'd.jpg', 'MAHASARAKHAM', '0877777545', '021114545', 'KTB');

-- --------------------------------------------------------

--
-- Table structure for table `tb_systembank`
--

CREATE TABLE `tb_systembank` (
  `id` int(5) NOT NULL,
  `bank_account` varchar(10) NOT NULL,
  `bank_name` varchar(100) NOT NULL,
  `account_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_systembank`
--

INSERT INTO `tb_systembank` (`id`, `bank_account`, `bank_name`, `account_name`) VALUES
(1, '1230033333', 'กสิกร', 'ขายออนไลน์าา'),
(2, '1234567890', 'กรุงไทย', 'ขายออนไลน์'),
(3, '123456789', 'กรุงไทย', 'ขายของออนไลน์');

-- --------------------------------------------------------

--
-- Table structure for table `tb_type`
--

CREATE TABLE `tb_type` (
  `type_id` int(5) NOT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `type_detail` varchar(255) DEFAULT NULL,
  `type_status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_type`
--

INSERT INTO `tb_type` (`type_id`, `type_name`, `type_detail`, `type_status`) VALUES
(1, 'ผัก', 'ผักสด', 'active'),
(2, 'ผลไม้', 'ผลไม้สด', 'active'),
(3, 'อาหาาร', 'อาหารดอง', 'active'),
(4, 'เสื้อผ้า', 'เสื้อผ้า', 'active'),
(5, 'เครื่องจักสาน', 'เครื่องจักสาน', 'active'),
(6, 'อื่นๆ', 'อื่นๆ', 'active');

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
  ADD KEY `tb_pament` (`id`);

--
-- Indexes for table `tb_product`
--
ALTER TABLE `tb_product`
  ADD PRIMARY KEY (`pd_id`),
  ADD KEY `tb_product` (`shop_id`),
  ADD KEY `type_id` (`type_id`);

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
-- Indexes for table `tb_type`
--
ALTER TABLE `tb_type`
  ADD PRIMARY KEY (`type_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `tb_order`
--
ALTER TABLE `tb_order`
  MODIFY `order_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `tb_product`
--
ALTER TABLE `tb_product`
  MODIFY `pd_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `tb_report`
--
ALTER TABLE `tb_report`
  MODIFY `rp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_shop`
--
ALTER TABLE `tb_shop`
  MODIFY `shop_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `tb_type`
--
ALTER TABLE `tb_type`
  MODIFY `type_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
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
