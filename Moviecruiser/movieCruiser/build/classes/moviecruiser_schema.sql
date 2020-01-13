-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviecruiser` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `moviecruiser` ;

-- -----------------------------------------------------
-- Table `moviecruiser`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`movies` (
  `mo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mo_title` VARCHAR(100) NULL DEFAULT NULL,
  `mo_box_office` BIGINT(20) NULL DEFAULT NULL,
  `mo_active` VARCHAR(3) NULL DEFAULT NULL,
  `mo_date_of_launch` DATE NULL DEFAULT NULL,
  `mo_genre` VARCHAR(45) NULL DEFAULT NULL,
  `mo_has_teaser` VARCHAR(3) NULL DEFAULT NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `moviecruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `moviecruiser`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`favorites` (
  `fs_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fs_us_id` INT(11) NULL DEFAULT NULL,
  `fs_mo_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fs_id`),
  INDEX `fs_mo_id_idx` (`fs_mo_id` ASC),
  INDEX `fs_us_id_idx` (`fs_us_id` ASC),
  CONSTRAINT `fs_mo_id`
    FOREIGN KEY (`fs_mo_id`)
    REFERENCES `moviecruiser`.`movies` (`mo_id`),
  CONSTRAINT `fs_us_id`
    FOREIGN KEY (`fs_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
