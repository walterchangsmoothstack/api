package com.ss.utopia.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ss.utopia.api.dao.BookingRepository;
import com.ss.utopia.api.pojo.Booking;
import com.ss.utopia.api.service.AirlineService;
import com.ss.utopia.api.service.BookingService;



@SpringBootApplication
@EnableJpaRepositories()
public class ApiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("password"));
	
		

		
	}

}
