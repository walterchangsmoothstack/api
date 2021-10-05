package com.ss.utopia.api.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.ss.utopia.api.service.UserService;


@RestController
@RequestMapping("/lms")
public class UserController {

	
	@Autowired
	UserService user_service;
	
	@Autowired
	BookingRepository booking_repository;
	
	@Autowired
	UserRepository user_repository;
	
	@Autowired
	FlightRepository flight_repository;
	
	@GetMapping("/user/find/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		return ResponseEntity.ok().body(user_service.findByUsername(username));
	}
	
	@GetMapping("/user/find/{username}/booking_methods")
	public ResponseEntity<List<?>> getAgentBookin(@PathVariable String username) {
		return ResponseEntity.ok().body(user_service.findByUsername(username).getBookingMethod());
	}	
	@GetMapping("/user/find/{username}/booking_methods/booking")
	public ResponseEntity<List<Booking>> getUserBooking(@PathVariable String username) {
		return ResponseEntity.ok().body(user_service.getBookingByUsername(username));
	}	
	@GetMapping("/user/find/{username}/booking_methods/passengers")
	public ResponseEntity<List<Passenger>> getPassengersFromUsername(@PathVariable String username) {
		List<Booking> bookings = user_service.getBookingByUsername(username);
		List<Passenger> passengers = new ArrayList<>();
		for(Booking b : bookings) {
			passengers.addAll(b.getPassengers());
		}
		return ResponseEntity.ok().body(passengers);
	}
	
	@Transactional	
	@GetMapping("/user/delete/{username}")
	public void delete(@PathVariable Integer username) {
		user_service.deleteUser(username);
		//user_repository.deleteById(username);
	}
	

	
	@GetMapping("/user/get/{username}/bookings")
	public List<Booking> getBookingByUsername(@PathVariable String username) {
		return user_service.getBookingByUsernameQuery(username);
	}
	
	@GetMapping("/user/get/{username}/bookings/flights")
	public List<Flight> getFlightByUsername(@PathVariable String username) {
		return user_service.getFlightByBookingId(user_service.getBookingByUsername(username))
				.stream().filter(distinctByKey(Flight::getId)).collect(Collectors.toList());
	}
	
	
	/* Check for uniques by attribute @https://stackoverflow.com/questions/23699371/java-8-distinct-by-property*/
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	
//	@GetMapping("/user/get/{booking_id}/flights")
//	public List<Flight> getFlightByBooking(@PathVariable Integer booking_id) {
//		return flight_repository.getFlightByBooking(121);
//	}
	
}
