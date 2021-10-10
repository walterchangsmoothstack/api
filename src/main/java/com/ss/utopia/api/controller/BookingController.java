package com.ss.utopia.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ss.utopia.api.pojo.Booking;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.Passenger;
import com.ss.utopia.api.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService booking_service;

	@GetMapping(path = "/booking/all")
	public ResponseEntity<List<Booking>> findAllBookings() {
		return ResponseEntity.ok().body(booking_service.findAllBookings());

	}

	@GetMapping(path = "/booking/passengers/all")
	public ResponseEntity<List<Passenger>> findAllPassengers() {
		return ResponseEntity.ok().body(booking_service.findAllPassengers());

	}

	////////////////// Just use get User ->
	////////////////// user.getBooking_Methods().getBookings()//////////////////////
	////////////////// These queries provide ALL information of the users.
	////////////////// //////////////////////////////
	////////////////// Use another query to avoid retrieving more information than
	////////////////// is needed.////////////

	@GetMapping(path = "/user/{username}/bookings")
	public ResponseEntity<List<Booking>> getUserBooking(@PathVariable String username) {
		return ResponseEntity.ok().body(booking_service.getBookingByUsername(username));
	}

	@GetMapping(path = "/user/{username}/bookings/passengers")
	public ResponseEntity<List<Passenger>> getPassengersFromUsername(@PathVariable String username) {
		List<Booking> bookings = booking_service.getBookingByUsername(username);
		List<Passenger> passengers = new ArrayList<>();
		for (Booking b : bookings) {
			passengers.addAll(b.getPassengers());
		}
		return ResponseEntity.ok().body(passengers);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping(path = "/booking/{username}/bookings")
	public ResponseEntity<List<Booking>> getBookingByUsername(@PathVariable String username) {
		return ResponseEntity.ok().body(booking_service.getBookingByUsernameQuery(username));
	}

	@GetMapping(path = "/booking/{username}/bookings/flights")
	public ResponseEntity<List<Flight>> getFlightByUsername(@PathVariable String username) {

		return ResponseEntity.ok()
				.body(booking_service.getFlightByBookingId(booking_service.getBookingByUsernameQuery(username)).stream()
						.filter(distinctByKey(Flight::getId)).collect(Collectors.toList()));
	}

	@GetMapping(path = "/booking/{username}/bookings/flights/passengers")
	public ResponseEntity<List<Passenger>> getPassengerByUsername(@PathVariable String username) {
		return ResponseEntity.ok()
				.body(booking_service.getPassengerByBooking(booking_service.getBookingByUsernameQuery(username)));

	}

	@Transactional
	@GetMapping("/booking/cancel/{booking_id}")
	public ResponseEntity<Boolean> cancelBooking(@PathVariable Integer booking_id) {
		Booking booking = booking_service.getBookingById(booking_id);
		booking.setIs_active(Boolean.FALSE);
		booking.setConfirmation_code(booking_service.generateConfirmationCode());
		return ResponseEntity.ok().body(Boolean.TRUE);
	}

//	@GetMapping("/booking/cancel/{booking_id}")
//	public ResponseEntity<Boolean> cancelBooking(@PathVariable Integer booking_id) {
//		Booking booking = booking_service.getBookingById(booking_id);
//		booking.setIs_active(Boolean.FALSE);
//		booking.setConfirmation_code(booking_service.generateConfirmationCode());
//		return ResponseEntity.ok().body(Boolean.TRUE);
//	}

	@PostMapping("/booking/update/passenger")
	public Passenger updatePassengers(@RequestBody Passenger passenger) {
		return booking_service.save(passenger);
	}

	@PostMapping("/booking/add/booking")
	public Booking addBooking(@RequestBody Booking booking) {
		return booking_service.save(booking);
	}
	
	@PostMapping("/booking/add/booking/booking_agent/{agent_id}/{flight_id}")
	public Booking addBookingByAgent(@RequestBody Passenger passenger, @PathVariable Integer agent_id,
			@PathVariable Integer flight_id) {
		return booking_service.saveBookingAgentBooking(passenger, agent_id, flight_id);
	}
	
//	@PostMapping("/booking/add/booking/booking_agent/{agent_id}/{flight_id}")
//	public Booking addBookingByAgent(@RequestBody List<Passenger> passengers, @PathVariable Integer agent_id,
//			@PathVariable Integer flight_id) {
//		return booking_service.saveBookingAgentBooking(booking, agent_id, flight_id);
//	}
	
	@PostMapping("/add/booking_user/userId={user_id}/flightId={flight_id}")
	public ResponseEntity<Booking> addBookingByUser(@RequestBody Passenger passenger, @PathVariable Integer user_id,
			@PathVariable Integer flight_id) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/add/booking_user").toUriString());

		return ResponseEntity.created(uri).body(booking_service.saveBookingUserBooking(passenger, user_id, flight_id));
	}
	

	@PostMapping("/booking/add/passenger")
	public Passenger addPassenger(@RequestBody Passenger passenger) {
		return booking_service.save(passenger);
	}

	@GetMapping("/booking/delete/passenger/{passenger_id}")
	public ResponseEntity<?> deletePassengerById(@PathVariable Integer passenger_id) {
		booking_service.deletePassengerById(passenger_id);

		return ResponseEntity.noContent().build();
	}

	@Transactional
	@GetMapping("/booking/delete/{booking_id}")
	public ResponseEntity<?> deleteBookingById(@PathVariable Integer booking_id) {
		booking_service.deleteBookingById(booking_id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/booking/find/{booking_id}")
	public ResponseEntity<Booking> findBookingById(@PathVariable Integer booking_id) {
		return ResponseEntity.ok().body(booking_service.findBookingById(booking_id));
	}

	@GetMapping("/booking/passenger/find/{passenger_id}")
	public ResponseEntity<Passenger> findPassengerById(@PathVariable Integer passenger_id) {
		return ResponseEntity.ok().body(booking_service.findPassengerById(passenger_id));
	}

	/*
	 * Check for uniques by
	 * attribute @https://stackoverflow.com/questions/23699371/java-8-distinct-by-
	 * property
	 */
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}

}
