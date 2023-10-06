-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema OSBB_Diagram_SECOND
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema OSBB_Diagram_SECOND
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OSBB_Diagram_SECOND` DEFAULT CHARACTER SET utf8 ;
USE `OSBB_Diagram_SECOND` ;

-- -----------------------------------------------------
-- Table `OSBB_Diagram_SECOND`.`residents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OSBB_Diagram_SECOND`.`residents` (
  `resident_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `family_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `car` TINYINT NOT NULL,
  PRIMARY KEY (`resident_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OSBB_Diagram_SECOND`.`buildings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OSBB_Diagram_SECOND`.`buildings` (
  `building_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `number` TINYINT(5) NOT NULL,
  PRIMARY KEY (`building_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OSBB_Diagram_SECOND`.`apartments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OSBB_Diagram_SECOND`.`apartments` (
  `apartment_id` INT NOT NULL AUTO_INCREMENT,
  `building_id` INT NOT NULL,
  `area` INT NULL,
  PRIMARY KEY (`apartment_id`),
  INDEX `id_idx` (`building_id` ASC) VISIBLE,
  CONSTRAINT `building_id`
    FOREIGN KEY (`building_id`)
    REFERENCES `OSBB_Diagram_SECOND`.`buildings` (`building_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OSBB_Diagram_SECOND`.`osbb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OSBB_Diagram_SECOND`.`osbb` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `resident_id` INT NOT NULL,
  `salary` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`resident_id` ASC) VISIBLE,
  CONSTRAINT `resident_id`
    FOREIGN KEY (`resident_id`)
    REFERENCES `OSBB_Diagram_SECOND`.`residents` (`resident_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OSBB_Diagram_SECOND`.`resident_apartment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OSBB_Diagram_SECOND`.`resident_apartment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `resident_id` INT NOT NULL,
  `apartment_id` INT NOT NULL,
  `status` ENUM('Власник', 'Орендар') NOT NULL,
  INDEX `apartment_id_idx` (`apartment_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `resident_ap_id`
    FOREIGN KEY (`resident_id`)
    REFERENCES `OSBB_Diagram_SECOND`.`residents` (`resident_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `apartment_id`
    FOREIGN KEY (`apartment_id`)
    REFERENCES `OSBB_Diagram_SECOND`.`apartments` (`apartment_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OSBB_Diagram_SECOND`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OSBB_Diagram_SECOND`.`roles` (
  `role_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OSBB_Diagram_SECOND`.`resident_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OSBB_Diagram_SECOND`.`resident_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_id` INT NOT NULL,
  `resident_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `resident_id_idx` (`resident_id` ASC) VISIBLE,
  CONSTRAINT `resident_role_id`
    FOREIGN KEY (`resident_id`)
    REFERENCES `OSBB_Diagram_SECOND`.`osbb` (`resident_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `OSBB_Diagram_SECOND`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
