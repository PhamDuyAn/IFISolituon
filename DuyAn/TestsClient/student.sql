-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th9 27, 2017 lúc 06:50 AM
-- Phiên bản máy phục vụ: 10.1.26-MariaDB
-- Phiên bản PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `student`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Address`
--

CREATE TABLE `Address` (
  `address_id` int(10) NOT NULL,
  `line_1_number_building` varchar(50) NOT NULL,
  `line_2_number_street` varchar(50) NOT NULL,
  `line_3_area_locality` varchar(50) NOT NULL,
  `town_city` varchar(50) NOT NULL,
  `state_province` varchar(50) NOT NULL,
  `country_code` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Clients`
--

CREATE TABLE `Clients` (
  `client_id` int(10) NOT NULL,
  `currency_code` varchar(50) NOT NULL,
  `client_name` varchar(100) NOT NULL,
  `client_from_date` varchar(20) NOT NULL,
  `kpi_avg_billable_rate` varchar(50) NOT NULL,
  `kpi_billings_to_date` varchar(50) NOT NULL,
  `kpi_client_project_count` varchar(50) NOT NULL,
  `other_client_details` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Client_addresses`
--

CREATE TABLE `Client_addresses` (
  `client_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  `date_address_from` varchar(50) NOT NULL,
  `date_address_to` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Projects`
--

CREATE TABLE `Projects` (
  `project_id` int(10) NOT NULL,
  `client_id` int(10) NOT NULL,
  `project_name` varchar(50) NOT NULL,
  `project_start_date` varchar(50) NOT NULL,
  `project_end_date` varchar(50) NOT NULL,
  `project_description` varchar(50) NOT NULL,
  `other_project_details` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Ref_Curencies`
--

CREATE TABLE `Ref_Curencies` (
  `currency_code` varchar(50) NOT NULL,
  `currency_name` varchar(50) NOT NULL,
  `nominal_echange_rate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Ref_Roles`
--

CREATE TABLE `Ref_Roles` (
  `role_code` varchar(50) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `eg_Project_Manager` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Services`
--

CREATE TABLE `Services` (
  `service_code` varchar(50) NOT NULL,
  `parent_service_code` varchar(50) NOT NULL,
  `service_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `Services`
--

INSERT INTO `Services` (`service_code`, `parent_service_code`, `service_name`) VALUES
('sv01', 'sv01', 'Khach hang');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Services_on_Projects`
--

CREATE TABLE `Services_on_Projects` (
  `service_code` varchar(50) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `Services_on_Projects`
--

INSERT INTO `Services_on_Projects` (`service_code`, `project_id`) VALUES
('sv01', 1),
('sv01', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Staff`
--

CREATE TABLE `Staff` (
  `staff_id` int(10) NOT NULL,
  `staff_name` varchar(50) NOT NULL,
  `gender_MF` varchar(50) NOT NULL,
  `date_of_birth` varchar(50) NOT NULL,
  `daily_cost` varchar(50) NOT NULL,
  `daily_rate` varchar(50) NOT NULL,
  `date_joined` varchar(50) NOT NULL,
  `date_left` varchar(50) NOT NULL,
  `other_staff_details` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Staff_on_Projects`
--

CREATE TABLE `Staff_on_Projects` (
  `staff_on_project_perioc_id` int(10) NOT NULL,
  `project_id` int(10) NOT NULL,
  `staff_id` int(10) NOT NULL,
  `role_code` varchar(50) NOT NULL,
  `from_datetime` varchar(50) NOT NULL,
  `to_datetime` varchar(50) NOT NULL,
  `hourty_rate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `idStudent` int(10) NOT NULL,
  `nameStudent` varchar(100) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `addressStudent` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `Address`
--
ALTER TABLE `Address`
  ADD PRIMARY KEY (`address_id`);

--
-- Chỉ mục cho bảng `Clients`
--
ALTER TABLE `Clients`
  ADD PRIMARY KEY (`client_id`),
  ADD KEY `fk_currency_code` (`currency_code`);

--
-- Chỉ mục cho bảng `Client_addresses`
--
ALTER TABLE `Client_addresses`
  ADD PRIMARY KEY (`client_id`),
  ADD KEY `fk_address_id` (`address_id`);

--
-- Chỉ mục cho bảng `Projects`
--
ALTER TABLE `Projects`
  ADD PRIMARY KEY (`project_id`),
  ADD KEY `fk_client_id` (`client_id`);

--
-- Chỉ mục cho bảng `Ref_Curencies`
--
ALTER TABLE `Ref_Curencies`
  ADD PRIMARY KEY (`currency_code`);

--
-- Chỉ mục cho bảng `Ref_Roles`
--
ALTER TABLE `Ref_Roles`
  ADD PRIMARY KEY (`role_code`);

--
-- Chỉ mục cho bảng `Services`
--
ALTER TABLE `Services`
  ADD PRIMARY KEY (`service_code`);

--
-- Chỉ mục cho bảng `Services_on_Projects`
--
ALTER TABLE `Services_on_Projects`
  ADD KEY `fk_service_code` (`service_code`);

--
-- Chỉ mục cho bảng `Staff`
--
ALTER TABLE `Staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- Chỉ mục cho bảng `Staff_on_Projects`
--
ALTER TABLE `Staff_on_Projects`
  ADD PRIMARY KEY (`staff_on_project_perioc_id`),
  ADD KEY `fk_staff_id` (`staff_id`),
  ADD KEY `fk_role_code` (`role_code`),
  ADD KEY `fk_project_id_service` (`project_id`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`idStudent`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `Projects`
--
ALTER TABLE `Projects`
  MODIFY `project_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `Staff`
--
ALTER TABLE `Staff`
  MODIFY `staff_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `Staff_on_Projects`
--
ALTER TABLE `Staff_on_Projects`
  MODIFY `staff_on_project_perioc_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `Clients`
--
ALTER TABLE `Clients`
  ADD CONSTRAINT `fk_currency_code` FOREIGN KEY (`currency_code`) REFERENCES `Ref_Curencies` (`currency_code`);

--
-- Các ràng buộc cho bảng `Client_addresses`
--
ALTER TABLE `Client_addresses`
  ADD CONSTRAINT `fk_address_id` FOREIGN KEY (`address_id`) REFERENCES `Address` (`address_id`),
  ADD CONSTRAINT `fk_client_addres` FOREIGN KEY (`client_id`) REFERENCES `Clients` (`client_id`);

--
-- Các ràng buộc cho bảng `Projects`
--
ALTER TABLE `Projects`
  ADD CONSTRAINT `fk_client_id` FOREIGN KEY (`client_id`) REFERENCES `Clients` (`client_id`);

--
-- Các ràng buộc cho bảng `Services_on_Projects`
--
ALTER TABLE `Services_on_Projects`
  ADD CONSTRAINT `fk_service_code` FOREIGN KEY (`service_code`) REFERENCES `Services` (`service_code`);

--
-- Các ràng buộc cho bảng `Staff_on_Projects`
--
ALTER TABLE `Staff_on_Projects`
  ADD CONSTRAINT `fk_project_id_service` FOREIGN KEY (`project_id`) REFERENCES `Projects` (`project_id`),
  ADD CONSTRAINT `fk_project_id_staff` FOREIGN KEY (`project_id`) REFERENCES `Projects` (`project_id`),
  ADD CONSTRAINT `fk_role_code` FOREIGN KEY (`role_code`) REFERENCES `Ref_Roles` (`role_code`),
  ADD CONSTRAINT `fk_staff_id` FOREIGN KEY (`staff_id`) REFERENCES `Staff` (`staff_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
