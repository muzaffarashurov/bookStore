-- liquibase formatted sql

-- changeset Khasanboy-Akbarov:create-publisher-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='publisher';
CREATE TABLE `bookstore`.`publisher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NULL,
  `city` VARCHAR(255) NULL,
  `name` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) NULL,
  `zip` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

-- changeset Khasanboy-Akbarov:create-book-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='book';
CREATE TABLE `bookstore`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `isbn` VARCHAR(45) NOT NULL,
  `publisher_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC) VISIBLE,
  CONSTRAINT `publisher_id`
    FOREIGN KEY (`publisher_id`)
    REFERENCES `bookstore`.`publisher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- changeset Khasanboy-Akbarov:create-author-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='author';
CREATE TABLE `bookstore`.`author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Khasanboy-Akbarov:create-author_book-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='author_book';
CREATE TABLE `bookstore`.`author_book` (
  `author_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`author_id`, `book_id`),
  INDEX `book_id_idx` (`book_id` ASC) VISIBLE,
  CONSTRAINT `author_id`
    FOREIGN KEY (`author_id`)
    REFERENCES `bookstore`.`author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `book_id`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- changeset Khasanboy-Akbarov:create-my_book-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='my_book';
CREATE TABLE `bookstore`.`my_book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `publisher_id` INT NULL,
  `isbn` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
