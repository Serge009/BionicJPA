-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Час створення: Жов 03 2014 р., 13:40
-- Версія сервера: 5.5.20
-- Версія PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- БД: `global_bionic`
--

-- --------------------------------------------------------

--
-- Структура таблиці `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `address` varchar(300) NOT NULL,
  `email` varchar(90) NOT NULL,
  `ccNo` varchar(20) NOT NULL,
  `ccType` varchar(60) NOT NULL,
  `maturity` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп даних таблиці `customer`
--

INSERT INTO `customer` (`id`, `name`, `address`, `email`, `ccNo`, `ccType`, `maturity`) VALUES
(1, 'Dan Nelis', 'Vosselaar st. 19, Trnaut, Belgium', 'Dan@adw.com', '11345694671214', 'MasterCard', '2014-07-31'),
(2, 'Mark Wolf', 'Olaf st. 11, Stockholm, Sweden', 'mwolf@yahoo.com', '44402356988712', 'Visa', '2012-09-30'),
(3, 'Stein Brown', 'Oxford st. 223, Stockholm, Sweden', 'steinB@yahoo.com', '41233576012434', 'Visa', '2015-11-30');

-- --------------------------------------------------------

--
-- Структура таблиці `merchant`
--

CREATE TABLE IF NOT EXISTS `merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `charge` decimal(5,2) NOT NULL,
  `period` smallint(6) NOT NULL,
  `minSum` decimal(19,2) NOT NULL,
  `bankName` varchar(100) NOT NULL,
  `swift` varchar(40) NOT NULL,
  `account` varchar(20) NOT NULL,
  `total` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Дамп даних таблиці `merchant`
--

INSERT INTO `merchant` (`id`, `name`, `charge`, `period`, `minSum`, `bankName`, `swift`, `account`, `total`) VALUES
(1, 'Jim Smith Ltd.', '5.10', 1, '100.00', 'Chase Manhatten', 'AA245BXW', '247991002', '0.00'),
(2, 'Domby and sun Co.', '2.80', 2, '20.00', 'Paribas', 'XTW2NNM', '1188532009', '0.00'),
(3, 'Victoria Shop', '3.40', 3, '500.00', 'Swedbank', 'SWEE34YY', '557880234', '0.00'),
(4, 'Software & Digital goods', '4.90', 1, '160.00', 'Credi Leone', 'FRTOPM', '367920489', '0.00');

-- --------------------------------------------------------

--
-- Структура таблиці `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `merchantId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `goods` varchar(500) NOT NULL,
  `total` decimal(15,2) NOT NULL,
  `charge` decimal(15,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_PayMer` (`merchantId`),
  KEY `fk_PayCus` (`customerId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Дамп даних таблиці `payment`
--

INSERT INTO `payment` (`id`, `dt`, `merchantId`, `customerId`, `goods`, `total`, `charge`) VALUES
(1, '2012-07-12 07:00:14', 3, 1, 'CD Europe Maps', '12.08', '0.00'),
(2, '2012-06-22 15:21:10', 4, 3, 'NOD32 Antivirus', '33.80', '0.00'),
(3, '2012-07-01 21:00:17', 1, 1, 'Railway return ticket Brussel-Paris', '255.58', '0.00'),
(4, '2012-07-06 08:22:40', 1, 2, 'Railway ticket Stockholm - Oslo', '1325.00', '0.00'),
(5, '2012-07-10 08:10:45', 3, 2, 'CD African music', '7.65', '0.00'),
(6, '2012-06-30 09:00:00', 2, 1, 'Acer computer', '654.00', '0.00'),
(7, '2012-07-02 19:28:50', 4, 2, 'NOD32 Antivirus', '33.80', '0.00'),
(8, '2012-07-08 23:12:53', 4, 3, 'MS Office', '400.23', '0.00'),
(9, '2012-07-15 19:28:50', 2, 2, 'Dell computer', '768.00', '0.00');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk_PayCus` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `fk_PayMer` FOREIGN KEY (`merchantId`) REFERENCES `merchant` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
