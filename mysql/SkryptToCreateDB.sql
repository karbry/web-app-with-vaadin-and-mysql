CREATE SCHEMA `webapp` ;

CREATE TABLE `employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Salary` varchar(50) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `StartDate` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
ALTER TABLE employees CHANGE COLUMN `ID` `ID` INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 689;
INSERT INTO `webapp`.`employees` (`FirstName`, `LastName`, `Email`, `Salary`, `Role`, `StartDate`) 
VALUES ('Rowena', 'Leeming', 'rleeming0@bbc.co.uk', '6000', 'Food Chemist', '2019-11-05'),
('Alvinia', 'Delong', 'adff0@bbc.co.uk', '4600', 'Recruiting Manager', '2013-11-19'),
('Mariele', 'Huke', 'mhuke4@washingtonpost.com', '8000', 'Research Assistant IV', '2013-11-19');

SELECT * FROM employees;