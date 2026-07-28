-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbhospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbhospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbhospital` DEFAULT CHARACTER SET utf8 ;
USE `dbhospital` ;

-- -----------------------------------------------------
-- Table `dbhospital`.`speciality`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbhospital`.`speciality` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `description` (`description` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbhospital`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbhospital`.`doctor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `id_speciality` INT(11) NULL DEFAULT NULL,
  `status` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `first_name` (`first_name` ASC, `last_name` ASC, `id_speciality` ASC),
  INDEX `fk_id_speciality` (`id_speciality` ASC),
  CONSTRAINT `fk_id_speciality`
    FOREIGN KEY (`id_speciality`)
    REFERENCES `dbhospital`.`speciality` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbhospital`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbhospital`.`patient` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `birth_date` DATE NULL DEFAULT NULL,
  `status` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `first_name` (`first_name` ASC, `last_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbhospital`.`timetable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbhospital`.`timetable` (
  `id` INT(11) NOT NULL,
  `_day` INT(11) NOT NULL,
  `hour_start` TIME NOT NULL,
  `hour_end` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbhospital`.`timetablexdoctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbhospital`.`timetablexdoctor` (
  `id` INT(11) NOT NULL,
  `id_doctor_TXD` INT(11) NOT NULL,
  `id_timetable_TXD` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_timetablexdoctor_timetable1_idx` (`id_timetable_TXD` ASC),
  INDEX `fk_id_doctor_TXD` (`id_doctor_TXD` ASC),
  CONSTRAINT `fk_id_doctor_TXD`
    FOREIGN KEY (`id_doctor_TXD`)
    REFERENCES `dbhospital`.`doctor` (`id`),
  CONSTRAINT `fk_timetablexdoctor_timetable1`
    FOREIGN KEY (`id_timetable_TXD`)
    REFERENCES `dbhospital`.`timetable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbhospital`.`turn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbhospital`.`turn` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_patient_T` INT(11) NULL DEFAULT NULL,
  `id_doctor_T` INT(11) NULL DEFAULT NULL,
  `turn_date` DATE NULL DEFAULT NULL,
  `turn_hour_start` TIME NULL DEFAULT NULL,
  `turn_hour_end` TIME NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `status` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_patient_T` (`id_patient_T` ASC, `id_doctor_T` ASC),
  INDEX `fk_id_doctor_T` (`id_doctor_T` ASC),
  CONSTRAINT `fk_id_doctor_T`
    FOREIGN KEY (`id_doctor_T`)
    REFERENCES `dbhospital`.`doctor` (`id`),
  CONSTRAINT `fk_id_patient_T`
    FOREIGN KEY (`id_patient_T`)
    REFERENCES `dbhospital`.`patient` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
