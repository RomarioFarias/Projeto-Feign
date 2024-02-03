package com.carro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories(basePackages = {"com.carro.repository", "ps.squeal"})
public class CarroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarroApplication.class, args);
	}

}
