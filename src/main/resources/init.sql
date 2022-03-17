CREATE DATABASE IF NOT EXISTS `employee_management`;

USE `employee_management`;

CREATE TABLE IF NOT EXISTS `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL UNIQUE,
  `dob` date NOT NULL,
  `gender` varchar(10),
  PRIMARY KEY (`id`)
);
