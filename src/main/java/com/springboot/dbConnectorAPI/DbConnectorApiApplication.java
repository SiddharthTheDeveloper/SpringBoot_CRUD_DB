package com.springboot.dbConnectorAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbConnectorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbConnectorApiApplication.class, args);
		System.out.println("Hello DB API");
	}

}
