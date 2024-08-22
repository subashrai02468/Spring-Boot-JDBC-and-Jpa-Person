package com.subashrai.databasedemo;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subashrai.databasedemo.entity.Person;
import com.subashrai.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		logger.info("Inserting -> {}", 
				repository.insert(new Person("Tara", "Berlin", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		
		repository.deleteById(10002);

		logger.info("All users -> {}", repository.findAll());
	}
}

/*
 * A logger in the context of programming is a tool or component used to record
 * log messages during the execution of a software application. Logging is
 * crucial for debugging, monitoring, and auditing software behavior, especially
 * in production environments.
 */


/*
 * A JDBC DAO (Data Access Object) is a design pattern commonly used in Java to
 * separate the data persistence logic from the business logic in an
 * application. In the context of Spring, a JDBC DAO involves using the Spring
 * JDBC module to perform database operations.
 */