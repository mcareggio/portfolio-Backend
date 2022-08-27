-- Wed Aug  3 18:40:18 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bbdd_portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bbdd_portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bbdd_portfolio` DEFAULT CHARACTER SET utf8 ;
USE `bbdd_portfolio` ;

-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`provincia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `provincia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`localidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `localidad` VARCHAR(45) NOT NULL,
  `provincia_id` INT NOT NULL,
  PRIMARY KEY (`id`, `provincia_id`),
  INDEX `fk_localidad_provincia1_idx` (`provincia_id` ASC) VISIBLE,
  CONSTRAINT `fk_localidad_provincia1`
    FOREIGN KEY (`provincia_id`)
    REFERENCES `bbdd_portfolio`.`provincia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`Usuarios` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nombredeusuario` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `numerocasa` VARCHAR(45) NULL,
  `dpto` INT NULL,
  `piso` INT NULL,
  `localidad_id` INT NOT NULL,
  PRIMARY KEY (`id`, `localidad_id`),
  UNIQUE INDEX `nombredeusuario_UNIQUE` (`nombredeusuario` ASC) VISIBLE,
  INDEX `fk_Usuarios_localidad_idx` (`localidad_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_localidad`
    FOREIGN KEY (`localidad_id`)
    REFERENCES `bbdd_portfolio`.`localidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`Habilidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`Habilidades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `texto` VARCHAR(45) NOT NULL,
  `iconpath` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`Estudios_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`Estudios_categoria` (
  `id` INT NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`Proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`Proyectos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `about` VARCHAR(45) NULL,
  `weblink` VARCHAR(45) NULL,
  `githublink` VARCHAR(200) NULL,
  `devlanguage` VARCHAR(45) NOT NULL,
  `Estudios_categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Estudios_categoria_id`),
  INDEX `fk_Proyectos_Estudios_categoria1_idx` (`Estudios_categoria_id` ASC) VISIBLE,
  CONSTRAINT `fk_Proyectos_Estudios_categoria1`
    FOREIGN KEY (`Estudios_categoria_id`)
    REFERENCES `bbdd_portfolio`.`Estudios_categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`Proyectos_img`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`Proyectos_img` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(200) NOT NULL,
  `Proyectos_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Proyectos_id`),
  INDEX `fk_Proyectos_img_Proyectos1_idx` (`Proyectos_id` ASC) VISIBLE,
  CONSTRAINT `fk_Proyectos_img_Proyectos1`
    FOREIGN KEY (`Proyectos_id`)
    REFERENCES `bbdd_portfolio`.`Proyectos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`Acerca_de_mi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`Acerca_de_mi` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `parrafo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdd_portfolio`.`Estudios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdd_portfolio`.`Estudios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `institucion` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
