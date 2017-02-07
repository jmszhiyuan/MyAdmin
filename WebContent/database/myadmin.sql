-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2017-01-15 15:06:46
-- 服务器版本： 5.7.14
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myadmin`
--
CREATE DATABASE IF NOT EXISTS `myadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `myadmin`;

-- --------------------------------------------------------

--
-- 表的结构 `ma_gender`
--

DROP TABLE IF EXISTS `ma_gender`;
CREATE TABLE `ma_gender` (
  `id` tinyint(3) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ma_gender`
--

INSERT INTO `ma_gender` (`id`, `gender`) VALUES
(1, '男'),
(2, '女');

-- --------------------------------------------------------

--
-- 表的结构 `ma_level`
--

DROP TABLE IF EXISTS `ma_level`;
CREATE TABLE `ma_level` (
  `id` tinyint(3) NOT NULL,
  `level` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ma_level`
--

INSERT INTO `ma_level` (`id`, `level`) VALUES
(1, '一级'),
(2, '二级'),
(3, '三级');

-- --------------------------------------------------------

--
-- 表的结构 `ma_menu`
--

DROP TABLE IF EXISTS `ma_menu`;
CREATE TABLE `ma_menu` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `icon` varchar(20) NOT NULL,
  `title` varchar(30) NOT NULL,
  `url` varchar(50) NOT NULL,
  `parent` int(10) DEFAULT NULL,
  `level` tinyint(3) NOT NULL,
  `status` tinyint(3) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ma_menu`
--

INSERT INTO `ma_menu` (`id`, `name`, `icon`, `title`, `url`, `parent`, `level`, `status`) VALUES
(1, 'System', 'icon-add', '系统管理', '#', NULL, 1, 1),
(2, 'Application', 'icon-edit', '应用管理', '#', NULL, 1, 1),
(3, 'Menu', 'icon-remove', '菜单', 'menu', 2, 2, 1),
(4, 'User', 'icon-tip', '用户', 'user', 1, 2, 1);

-- --------------------------------------------------------

--
-- 表的结构 `ma_status`
--

DROP TABLE IF EXISTS `ma_status`;
CREATE TABLE `ma_status` (
  `id` tinyint(3) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ma_status`
--

INSERT INTO `ma_status` (`id`, `status`) VALUES
(1, '正常'),
(2, '无效'),
(3, '屏蔽'),
(4, '删除');

-- --------------------------------------------------------

--
-- 表的结构 `ma_user`
--

DROP TABLE IF EXISTS `ma_user`;
CREATE TABLE `ma_user` (
  `id` int(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `gender` tinyint(3) NOT NULL,
  `birthday` date NOT NULL,
  `status` tinyint(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ma_user`
--

INSERT INTO `ma_user` (`id`, `username`, `email`, `password`, `realname`, `gender`, `birthday`, `status`) VALUES
(1, 'admin', 'admin@letsgo.com', 'hO5NAhxw3mY=', '超级管理员', 1, '1971-02-26', 1),
(2, 'zhiyuan', 'zhiyuan@letsgo.com', 'OWcMwkxSV2A=', '支援', 1, '1971-02-26', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ma_gender`
--
ALTER TABLE `ma_gender`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_level`
--
ALTER TABLE `ma_level`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_menu`
--
ALTER TABLE `ma_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_status`
--
ALTER TABLE `ma_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_user`
--
ALTER TABLE `ma_user`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `ma_gender`
--
ALTER TABLE `ma_gender`
  MODIFY `id` tinyint(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `ma_level`
--
ALTER TABLE `ma_level`
  MODIFY `id` tinyint(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用表AUTO_INCREMENT `ma_menu`
--
ALTER TABLE `ma_menu`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `ma_status`
--
ALTER TABLE `ma_status`
  MODIFY `id` tinyint(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `ma_user`
--
ALTER TABLE `ma_user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
