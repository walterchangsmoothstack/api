package com.ss.utopia.api.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.api.dao.BookingAgentRepository;
import com.ss.utopia.api.dao.BookingGuestRepository;
import com.ss.utopia.api.dao.BookingPaymentRepository;
import com.ss.utopia.api.dao.BookingRepository;
import com.ss.utopia.api.dao.BookingUserRepository;
import com.ss.utopia.api.dao.FlightBookingsRepository;
import com.ss.utopia.api.dao.FlightRepository;
import com.ss.utopia.api.dao.PassengerRepository;
import com.ss.utopia.api.dao.UserRepository;
import com.ss.utopia.api.pojo.Booking;
import com.ss.utopia.api.pojo.BookingAgent;
import com.ss.utopia.api.pojo.BookingPayment;
import com.ss.utopia.api.pojo.BookingType;
import com.ss.utopia.api.pojo.BookingUser;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.FlightBookings;
import com.ss.utopia.api.pojo.Passenger;

@Service
public class BookingService {

	@Autowired
	BookingPaymentRepository booking_payment_repository;

	@Autowired
	FlightBookingsRepository flight_bookings_repository;

	@Autowired
	BookingAgentRepository booking_agent_repository;

	@Autowired
	BookingUserRepository booking_user_repository;

	@Autowired
	BookingGuestRepository booking_guest_repository;

	@Autowired
	BookingRepository booking_repository;

	@Autowired
	PassengerRepository passenger_repository;

	@Autowired
	FlightRepository flight_repository;

	@Autowired
	UserRepository user_repository;

	@Autowired
	SessionFactory sessionFactory;

	public List<Booking> findAllBookings() {
		return booking_repository.findAll();
	}

	public List<Passenger> findAllPassengers() {
		return passenger_repository.findAll();
	}

	public List<Passenger> getPassengerByBooking(List<Booking> bookings) {

		return bookings.stream().map(x -> passenger_repository.getPassengerByBookingId(x.getId())).flatMap(List::stream)
				.collect(Collectors.toList());
	}

	public List<Booking> getBookingByUsernameQuery(String username) {
		return booking_repository.getBookingsByUser(username);

	}

	public List<Booking> getBookingByUsername(String username) {
		return user_repository.findByUsername(username).get().getBookingMethod().stream()
				.map(b -> ((BookingType) b).getBooking()).collect(Collectors.toList());
	}

	public Passenger save(Passenger passenger) {
		return passenger_repository.save(passenger);
	}

	public Booking save(Booking booking) {
		return booking_repository.save(booking);
	}

	public List<Flight> getFlightByBookingId(List<Booking> bookings) {
		return bookings.stream().map(x -> flight_repository.getFlightByBooking(x.getId())).collect(Collectors.toList());
	}

	public Booking findBookingById(Integer booking_id) {
		return booking_repository.findById(booking_id).get();
	}

	public Booking getBookingById(Integer booking_id) {
		return booking_repository.getById(booking_id);
	}

	public Passenger findPassengerById(Integer passenger_id) {
		return passenger_repository.findById(passenger_id).get();
	}

	public void deletePassengerById(Integer passenger_id) {
		passenger_repository.deleteById(passenger_id);
	}

	public void deleteBookingById(Integer booking_id) {
		booking_repository.deleteById(booking_id);
	}

	public Booking saveBookingAgentBooking(Passenger passenger, Integer user_id, Integer flight_id) {

		Booking booking = new Booking();
		booking.setConfirmation_code(generateConfirmationCode());
		booking.setIs_active(Boolean.TRUE);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		booking = booking_repository.save(booking);

		passenger.setBooking_id(booking.getId());

		BookingAgent booking_agent = new BookingAgent();
		booking_agent.setBooking_id(booking.getId());
		booking_agent.setAgent_id(user_id);

		BookingPayment booking_payment = new BookingPayment();
		booking_payment.setBooking_id(booking.getId());
		booking_payment.setRefunded(Boolean.FALSE);
		booking_payment.setStripe_id(generateStripeId());

		FlightBookings flight_bookings = new FlightBookings();
		flight_bookings.setBooking_id(booking.getId());
		flight_bookings.setFlight_id(flight_id);

		passenger_repository.save(passenger);
		booking_agent_repository.save(booking_agent);
		flight_bookings_repository.save(flight_bookings);
		booking_payment_repository.save(booking_payment);

		tx.commit();
		session.close();

		return booking;

	}

	public Booking saveBookingUserBooking(Passenger passenger, Integer user_id, Integer flight_id) {

		Booking booking = new Booking();
		booking.setConfirmation_code(generateConfirmationCode());
		booking.setIs_active(Boolean.TRUE);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		booking = booking_repository.save(booking);

		passenger.setBooking_id(booking.getId());

		BookingUser booking_user = new BookingUser();
		booking_user.setBooking_id(booking.getId());
		booking_user.setUser_id(user_id);

		BookingPayment booking_payment = new BookingPayment();
		booking_payment.setBooking_id(booking.getId());
		booking_payment.setRefunded(Boolean.FALSE);
		booking_payment.setStripe_id(generateStripeId());

		FlightBookings flight_bookings = new FlightBookings();
		flight_bookings.setBooking_id(booking.getId());
		flight_bookings.setFlight_id(flight_id);

		passenger_repository.save(passenger);
		booking_user_repository.save(booking_user);
		flight_bookings_repository.save(flight_bookings);
		booking_payment_repository.save(booking_payment);

		tx.commit();
		session.close();

		return booking;

	}

	public String generateConfirmationCode() {
		String s = "";
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			if (Math.random() > 0.5) {
				s += Math.random() > 0.5 ? Character.toUpperCase((char) (random.nextInt(26) + 97))
						: (char) (random.nextInt(26) + 97);
			} else {
				s += random.nextInt(10);
			}
		}

		return s;
	}

	public String generateStripeId() {
		String s = "";
		Random random = new Random();
		for (int i = 0; i < 25; i++) {
			if (Math.random() > 0.5) {
				s += Math.random() > 0.5 ? Character.toUpperCase((char) (random.nextInt(26) + 97))
						: (char) (random.nextInt(26) + 97);
			} else {
				s += random.nextInt(10);
			}
		}

		return s;
	}

}
