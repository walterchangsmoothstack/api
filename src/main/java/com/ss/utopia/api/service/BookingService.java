package com.ss.utopia.api.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.api.dao.BookingRepository;
import com.ss.utopia.api.dao.FlightRepository;
import com.ss.utopia.api.dao.PassengerRepository;
import com.ss.utopia.api.dao.UserRepository;
import com.ss.utopia.api.pojo.Booking;
import com.ss.utopia.api.pojo.BookingType;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.Passenger;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository booking_repository;
	
	@Autowired
	PassengerRepository passenger_repository;
	
	@Autowired
	FlightRepository flight_repository;
	
	@Autowired
	UserRepository user_repository;
	
	
	public List<Booking> findAllBookings(){
		System.out.println(booking_repository.findAll());
		return booking_repository.findAll();
	}
	
	public List<Passenger> getPassengerByBooking(List<Booking> bookings){

		return bookings.stream().map(x -> passenger_repository.getPassengerByBookingId(x.getId())).flatMap(List::stream).collect(Collectors.toList());
	}
	
	public List<Booking> getBookingByUsernameQuery(String username){
		return booking_repository.getBookingsByUser(username);

	}
	
	public List<Booking> getBookingByUsername(String username){
		return user_repository.findByUsername(username).get().getBookingMethod()
				.stream().map(b -> ((BookingType)b).getBooking()).collect(Collectors.toList());
	}
	public Passenger save(Passenger passenger) {
		return passenger_repository.save(passenger);
	}
	
	public List<Flight> getFlightByBookingId(List<Booking> bookings){
		return bookings.stream().map(x -> flight_repository.getFlightByBooking(x.getId())).collect(Collectors.toList());
	}
	
	public Booking getBookingById(Integer booking_id) {
		return booking_repository.getById(booking_id);
	}
	
	public void deletePassengerById(Integer passenger_id) {
		passenger_repository.deleteById(passenger_id);
	}
	
	public void deleteBookingById(Integer booking_id) {
		booking_repository.deleteById(booking_id);
	}
	
	public String generateConfirmationCode() {
		String s = "";
		Random random = new Random();
		for(int i =0; i<50; i++) {
			if(Math.random() > 0.5) {
			s+= Math.random() > 0.5 ? Character.toUpperCase((char)(random.nextInt(26)+97)) :
				(char)(random.nextInt(26)+97);
			}
			else {
				s+= random.nextInt(10);
			}
		}
		
		return s;
	}
	

}
