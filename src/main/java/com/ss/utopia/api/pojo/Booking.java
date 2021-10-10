package com.ss.utopia.api.pojo;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.sun.istack.NotNull;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Boolean is_active;
	private String confirmation_code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public String getConfirmation_code() {
		return confirmation_code;
	}
	public void setConfirmation_code(String confirmation_code) {
		this.confirmation_code = confirmation_code;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", is_active=" + is_active + ", confirmation_code=" + confirmation_code + "]";
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="booking_id", nullable=false)
	//@NotNull
	List<Passenger> passengers;
	
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
//	public BookingAgent getBooking_agent() {
//		return booking_agent;
//	}
//	public void setBooking_agent(BookingAgent booking_agent) {
//		this.booking_agent = booking_agent;
//	}
//	public BookingUser getBooking_user() {
//		return booking_user;
//	}
//	public void setBooking_user(BookingUser booking_user) {
//		this.booking_user = booking_user;
//	}
//	
//	public BookingPayment getBooking_payment() {
//		return booking_payment;
//	}
//	public void setBooking_payment(BookingPayment booking_payment) {
//		this.booking_payment = booking_payment;
//	}
//	public FlightBookings getFlight_bookings() {
//		return flight_bookings;
//	}
//	
//	
//	public void setFlight_bookings(FlightBookings flight_bookings) {
//		this.flight_bookings = flight_bookings;
//	}
//	
//	@OneToOne(fetch = FetchType.LAZY)
//	BookingPayment booking_payment;
//	
//	@OneToOne(fetch = FetchType.LAZY)
//	FlightBookings flight_bookings;
//	
//	
//	@OneToOne(targetEntity=BookingGuest.class, fetch = FetchType.LAZY)
//	BookingGuest booking_guest;
	
//	@OneToOne(targetEntity=BookingAgent.class, fetch = FetchType.LAZY)
//	BookingAgent booking_agent;
//	
//	@OneToOne(targetEntity=BookingUser.class, fetch = FetchType.LAZY)
//	BookingUser booking_user;

	
	

	
	
}
