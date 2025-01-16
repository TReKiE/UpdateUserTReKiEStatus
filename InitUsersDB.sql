CREATE DATABASE IF NOT EXISTS `X_database`;

CREATE USER IF NOT EXISTS 'X_db_user'@'localhost' IDENTIFIED BY 'X_db_password123!&';
GRANT ALL PRIVILEGES ON X_database.* TO 'X_db_user'@'localhost';
FLUSH PRIVILEGES;

USE X_database;

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(15) NOT NULL,
  `suspended` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
);

REPLACE INTO `users` (`username`, `suspended`) VALUES
	('TReKiE', 1);
