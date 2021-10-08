package com.ss.utopia.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ss.utopia.api.dao.BookingRepository;
import com.ss.utopia.api.dao.FlightRepository;
import com.ss.utopia.api.dao.UserRepository;
import com.ss.utopia.api.pojo.Booking;
import com.ss.utopia.api.pojo.BookingAgent;
import com.ss.utopia.api.pojo.BookingType;
import com.ss.utopia.api.pojo.BookingUser;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.Passenger;
import com.ss.utopia.api.pojo.User;
import com.ss.utopia.api.service.BookingService;
import com.ss.utopia.api.service.UserService;


@RestController
public class UserController {

	private final String welcomePrompt = "Welcome. What user are you?";
	
	@Autowired
	UserService user_service;
	
	@Autowired
	BookingService booking_service;
	
	@Autowired
	BookingRepository booking_repository;
	
	@Autowired
	UserRepository user_repository;
	
	@Autowired
	FlightRepository flight_repository;

	
	@GetMapping(path = "/user/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		return ResponseEntity.ok().body(user_service.findByUsername(username));
	}
	
	@GetMapping(path = "/user/{username}/booking_methods")
	public ResponseEntity<List<?>> getAgentBookin(@PathVariable String username) {
		return ResponseEntity.ok().body(user_service.findByUsername(username).getBookingMethod());
	}	

	
	@Transactional	
	@GetMapping(path = "/user/{username}/delete")
	public void delete(@PathVariable Integer username) {
		user_service.deleteUser(username);
		//user_repository.deleteById(username);
	}
	

}
