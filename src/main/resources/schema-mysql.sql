CREATE TABLE IF NOT EXISTS `register1` (
  `account` VARCHAR(20) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `name` VARCHAR(20) NULL,
  `age` INT NULL,
  `city` VARCHAR(10) NULL,
  `reg_time` DATETIME NULL,
  `active` TINYINT NOT NULL,
  `register1col` VARCHAR(45) NULL,
  PRIMARY KEY (`account`)
  );
