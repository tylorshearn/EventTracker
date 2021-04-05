-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dreamdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dreamdb` ;

-- -----------------------------------------------------
-- Schema dreamdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dreamdb` DEFAULT CHARACTER SET utf8 ;
USE `dreamdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(12) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `profile_picture` VARCHAR(5000) NOT NULL DEFAULT 'https://www.vecteezy.com/free-vector/sky' COMMENT 'Attribution\n<a href=\"https://www.vecteezy.com/free-vector/sky\">Sky Vectors by Vecteezy</a>',
  `created_on` DATETIME NOT NULL DEFAULT current_timestamp,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dream`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dream` ;

CREATE TABLE IF NOT EXISTS `dream` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` TEXT(500) NOT NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  `dreamt_on` DATETIME NOT NULL DEFAULT current_timestamp,
  `description` TEXT NOT NULL,
  `user_id` INT NOT NULL,
  `effect` TEXT NOT NULL,
  `kind` VARCHAR(45) NOT NULL COMMENT 'Normal\n\nDaydream\n\nLucid dream\n\nFalse Awakening Dream\n\nNightmare',
  PRIMARY KEY (`id`),
  INDEX `fk_dream_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_dream_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS dreamuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'dreamuser'@'localhost' IDENTIFIED BY 'dreamuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'dreamuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `dreamdb`;
INSERT INTO `user` (`id`, `username`, `password`, `profile_picture`, `created_on`, `is_active`) VALUES (1, 'Founder', 'World01!', '\'https://www.vecteezy.com/free-vector/sky\'', DEFAULT, 1);
INSERT INTO `user` (`id`, `username`, `password`, `profile_picture`, `created_on`, `is_active`) VALUES (2, 'Not Active', 'password', DEFAULT, DEFAULT, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dream`
-- -----------------------------------------------------
START TRANSACTION;
USE `dreamdb`;
INSERT INTO `dream` (`id`, `title`, `is_active`, `dreamt_on`, `description`, `user_id`, `effect`, `kind`) VALUES (1, 'Beach', 1, DEFAULT, 'Was at the beach.', 1, 'Calming', 'Normal');
INSERT INTO `dream` (`id`, `title`, `is_active`, `dreamt_on`, `description`, `user_id`, `effect`, `kind`) VALUES (2, 'Forest', 0, DEFAULT, 'Was chased by a bear.', 1, 'Scary', 'Nightmare');

COMMIT;

