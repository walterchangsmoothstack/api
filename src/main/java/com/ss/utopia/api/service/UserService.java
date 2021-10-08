package com.ss.utopia.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	public void deletePassenger(Integer passenger_id) {
		passenger_repository.deleteById(passenger_id);
	}
	

	

	
	
	

	
		
	
	
	
	
}
