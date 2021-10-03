package com.ss.utopia.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ss.utopia.api.dao.AirportRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= AirportRepository.class)
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		
		
		
	}

}