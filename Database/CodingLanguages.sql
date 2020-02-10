-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eventdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eventdb` ;

-- -----------------------------------------------------
-- Schema eventdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eventdb` DEFAULT CHARACTER SET utf8 ;
USE `eventdb` ;

-- -----------------------------------------------------
-- Table `language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `language` ;

CREATE TABLE IF NOT EXISTS `language` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `creation_year` VARCHAR(45) NULL,
  `desciption` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library` ;

CREATE TABLE IF NOT EXISTS `library` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `documentation_url` VARCHAR(20000) NOT NULL,
  `language_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_library_language_idx` (`language_id` ASC),
  CONSTRAINT `fk_library_language`
    FOREIGN KEY (`language_id`)
    REFERENCES `language` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `language`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventdb`;
INSERT INTO `language` (`id`, `name`, `creation_year`, `desciption`) VALUES (1, 'Java', '1995', 'Java is a programming language and computing platform first released by Sun Microsystems in 1995. There are lots of applications and websites that will not work unless you have Java installed, and more are created every day. Java is fast, secure, and reliable. From laptops to datacenters, game consoles to scientific supercomputers, cell phones to the Internet, Java is everywhere!');
INSERT INTO `language` (`id`, `name`, `creation_year`, `desciption`) VALUES (2, 'C++', '1985', 'C++ is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language, or \"C with Classes\". The language has expanded significantly over time, and modern C++ has object-oriented, generic, and functional features in addition to facilities for low-level memory manipulation. It is almost always implemented as a compiled language, and many vendors provide C++ compilers, including the Free Software Foundation, LLVM, Microsoft, Intel, Oracle, and IBM, so it is available on many platforms.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `library`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventdb`;
INSERT INTO `library` (`id`, `name`, `documentation_url`, `language_id`) VALUES (1, 'java.lang', 'https://docs.oracle.com/javase/8/docs/api/java/lang/package-summary.html', 1);
INSERT INTO `library` (`id`, `name`, `documentation_url`, `language_id`) VALUES (2, 'java.util', 'https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html', 1);

COMMIT;

