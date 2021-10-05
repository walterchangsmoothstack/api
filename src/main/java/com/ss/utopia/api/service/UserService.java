package com.ss.utopia.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.api.dao.BookingAgentRepository;
import com.ss.utopia.api.dao.BookingRepository;
import com.ss.utopia.api.dao.BookingUserRepository;
import com.ss.utopia.api.dao.FlightRepository;
import com.ss.utopia.api.dao.PassengerRepository;
import com.ss.utopia.api.dao.UserRepository;
import com.ss.utopia.api.pojo.Booking;
import com.ss.utopia.api.pojo.BookingType;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.Passenger;
import com.ss.utopia.api.pojo.User;

@Service
public class UserService {

	
	@Autowired
	UserRepository user_repository;
	
	@Autowired
	BookingAgentRepository booking_agent_repository;

	@Autowired
	BookingUserRepository booking_user_repository;
	
	@Autowired
	PassengerRepository passenger_repository;
	
	@Autowired
	BookingRepository booking_repository;
	
	@Autowired
	FlightRepository flight_repository;
	
	public User findByUsername(String username) {
		return user_repository.findByUsername(username).get();
	}
	
	public User save(User user) {
		return user_repository.save(user);
	}
	
	public void deleteUser(Integer user_id) {
		user_repository.deleteById(user_id);
	}
	
	public List<Booking> getBookingByUsername(String username){
		return user_repository.findByUsername(username).get().getBookingMethod()
				.stream().map(b -> ((BookingType)b).getBooking()).collect(Collectors.toList());
	}
	public Passenger save(Passenger passenger) {
		return passenger_repository.save(passenger);
	}
	public void deletePassenger(Integer passenger_id) {
		passenger_repository.deleteById(passenger_id);
	}
	
	public List<Booking> getBookingByUsernameQuery(String username){
		return booking_repository.getBookingsByUser(username);

	}
	
	public List<Flight> getFlightByBookingId(List<Booking> bookings){
		return bookings.stream().map(x -> flight_repository.getFlightByBooking(x.getId())).collect(Collectors.toList());
	}
	
	
	

	
		
	
	
	
	
}