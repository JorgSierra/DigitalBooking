-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema digitalbooking
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `digitalbooking`;
CREATE SCHEMA IF NOT EXISTS `digitalbooking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `digitalbooking` ;

-- -----------------------------------------------------
-- User create
-- -----------------------------------------------------

-- Create user
CREATE USER IF NOT EXISTS 'newuser'@'localhost' identified by 'password';
-- Give Access
GRANT ALL ON digitalbooking.* TO 'newuser'@'localhost';

-- -----------------------------------------------------
-- Table `digitalbooking`.`caracteristicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`caracteristicas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `icono` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`categorias` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(250) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `url_imagen` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`ubicaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`ubicaciones` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ciudad` VARCHAR(250) NOT NULL,
  `pais` VARCHAR(250) NOT NULL,
  `continente` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`productos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(250) NOT NULL,
  `titulo` VARCHAR(250) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `precio` DOUBLE NOT NULL,
  `categoria` BIGINT NOT NULL,
  `ubicacion` BIGINT NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longitud` DOUBLE NOT NULL,
  `direccion` VARCHAR(250) NOT NULL,
  `distancia` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `categoria` (`categoria` ASC) VISIBLE,
  INDEX `ciudad` (`ubicacion` ASC) VISIBLE,
  CONSTRAINT `productos_ibfk_1`
    FOREIGN KEY (`categoria`)
    REFERENCES `digitalbooking`.`categorias` (`id`),
  CONSTRAINT `productos_ibfk_2`
    FOREIGN KEY (`ubicacion`)
    REFERENCES `digitalbooking`.`ubicaciones` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`imagenes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(250) NOT NULL,
  `url_img` VARCHAR(250) NOT NULL,
  `id_producto` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_producto` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `imagenes_ibfk_1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `digitalbooking`.`productos` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`tipoliticas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`tipoliticas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`politicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`politicas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(250) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `id_tipolitica` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_politicas_tipopoliticas1_idx` (`id_tipolitica` ASC) VISIBLE,
  CONSTRAINT `fk_politicas_tipopoliticas1`
    FOREIGN KEY (`id_tipolitica`)
    REFERENCES `digitalbooking`.`tipoliticas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`productos_caracteristicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`productos_caracteristicas` (
  `id_producto` BIGINT NOT NULL,
  `id_caracteristica` BIGINT NOT NULL,
  PRIMARY KEY (`id_producto`, `id_caracteristica`),
  INDEX `id_caracteristica` (`id_caracteristica` ASC) VISIBLE,
  CONSTRAINT `productos_caracteristicas_ibfk_1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `digitalbooking`.`productos` (`id`),
  CONSTRAINT `productos_caracteristicas_ibfk_2`
    FOREIGN KEY (`id_caracteristica`)
    REFERENCES `digitalbooking`.`caracteristicas` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`productos_politicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`productos_politicas` (
  `id_producto` BIGINT NOT NULL,
  `id_politica` BIGINT NOT NULL,
  PRIMARY KEY (`id_producto`, `id_politica`),
  INDEX `id_politica` (`id_politica` ASC) VISIBLE,
  CONSTRAINT `productos_politicas_ibfk_1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `digitalbooking`.`productos` (`id`),
  CONSTRAINT `productos_politicas_ibfk_2`
    FOREIGN KEY (`id_politica`)
    REFERENCES `digitalbooking`.`politicas` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `digitalbooking`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `apellido` VARCHAR(60) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `encriptado` TINYINT(1) NOT NULL,
  `codigo_verificacion` VARCHAR(64) NULL,
  `enabled` TINYINT(1) NOT NULL,
  `ciudad` VARCHAR(60) NOT NULL,
  `id_rol` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuarios_roles1_idx` (`id_rol` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_roles1`
    FOREIGN KEY (`id_rol`)
    REFERENCES `digitalbooking`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `digitalbooking`.`puntuaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`puntuaciones` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_producto` BIGINT NOT NULL,
  `valor` INT NOT NULL,
  `id_usuario` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_producto` (`id_producto` ASC) VISIBLE,
  INDEX `fk_puntuaciones_usuarios1_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `puntuaciones_ibfk_1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `digitalbooking`.`productos` (`id`),
  CONSTRAINT `fk_puntuaciones_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `digitalbooking`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `digitalbooking`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`reservas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `hora_inicio` TIME NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  `datos_vendedor` VARCHAR(255) NULL,
  `vacuna_covid` TINYINT(1) NULL,
  `id_producto` BIGINT NOT NULL,
  `id_usuario` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reservas_productos1_idx` (`id_producto` ASC) VISIBLE,
  INDEX `fk_reservas_usuarios1_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_reservas_productos1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `digitalbooking`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `digitalbooking`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `digitalbooking`.`likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `digitalbooking`.`likes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_usuario` BIGINT NOT NULL,
  `id_producto` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_likes_usuarios1_idx` (`id_usuario` ASC) VISIBLE,
  INDEX `fk_likes_productos1_idx` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_likes_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `digitalbooking`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_likes_productos1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `digitalbooking`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
