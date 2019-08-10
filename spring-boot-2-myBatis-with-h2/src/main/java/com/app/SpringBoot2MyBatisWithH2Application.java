package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.domain.Student;
import com.app.repository.StudentMyBatisRepository;

@SpringBootApplication
public class SpringBoot2MyBatisWithH2Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentMyBatisRepository repository;

    public static void main(String[] args) {
	SpringApplication.run(SpringBoot2MyBatisWithH2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

	logger.info("------------------------------------");

	logger.info("Select all Student:");
	logger.info("All users Now -> {}", repository.findAll());

	logger.info("Insert a new record with ID as 3L:");
	repository.insert(new Student(3L, "John", "A1234657"));
	logger.info("All users Now -> {}", repository.findAll());

	logger.info("UPdate student with id as 1L");
	repository.update(new Student(1L, "Brook", "E9876500"));
	logger.info("All users Now -> {}", repository.findAll());

	logger.info("Delete student with id as 2L");
	repository.deleteById(2L);
	logger.info("All users Now -> {}", repository.findAll());

	logger.info("------------------------------------");
    }
}