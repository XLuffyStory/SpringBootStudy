CREATE DATABASE springboot_vue_chapter05 DEFAULT CHARACTER SET utf8;

USE springboot_vue_chapter05;

CREATE TABLE book(
id INT(11) NOT NULL AUTO_INCREMENT,
NAME VARCHAR(128) DEFAULT NULL,
author VARCHAR(64) DEFAULT NULL,
PRIMARY KEY (id)
)ENGINE = INNODB DEFAULT CHARSET = utf8;

USE springboot_vue_chapter05;
DELETE FROM book;
INSERT INTO book(id, NAME, author) VALUES (1,'三国演义', '罗贯中'), (2,'水浒传', '施耐庵');