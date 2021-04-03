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
  `dream_points` INT NOT NULL DEFAULT 0,
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
  `is_complete` TINYINT NOT NULL DEFAULT 0,
  `started_on` DATETIME NOT NULL DEFAULT current_timestamp,
  `description` TEXT NULL,
  `points_rewarded` INT NULL,
  `finished_on` DATETIME NULL,
  `user_id` INT NOT NULL,
  `goal_date` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dream_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_dream_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `track`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `track` ;

CREATE TABLE IF NOT EXISTS `track` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  `started_on` DATETIME NOT NULL DEFAULT current_timestamp,
  `finished_on` DATETIME NULL,
  `is_complete` TINYINT NOT NULL DEFAULT 0,
  `dream_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_track_dream1_idx` (`dream_id` ASC),
  CONSTRAINT `fk_track_dream1`
    FOREIGN KEY (`dream_id`)
    REFERENCES `dream` (`id`)
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
INSERT INTO `user` (`id`, `username`, `password`, `profile_picture`, `dream_points`, `created_on`, `is_active`) VALUES (1, 'Founder', 'World01!', '\'https://www.vecteezy.com/free-vector/sky\'', 0, DEFAULT, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dream`
-- -----------------------------------------------------
START TRANSACTION;
USE `dreamdb`;
INSERT INTO `dream` (`id`, `title`, `is_active`, `is_complete`, `started_on`, `description`, `points_rewarded`, `finished_on`, `user_id`, `goal_date`) VALUES (1, 'Make $100 Trading Stocks This Week', 1, 0, DEFAULT, 'Trade', 1, NULL, 1, '2021-04-09 00:00:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `track`
-- -----------------------------------------------------
START TRANSACTION;
USE `dreamdb`;
INSERT INTO `track` (`id`, `title`, `description`, `is_active`, `started_on`, `finished_on`, `is_complete`, `dream_id`) VALUES (1, 'Buy Stock', 'Buy Shares', 1, DEFAULT, NULL, 0, 1);

COMMIT;

