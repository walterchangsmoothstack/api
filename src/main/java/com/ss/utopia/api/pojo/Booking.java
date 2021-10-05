package com.ss.utopia.api.pojo;

import java.util.List;
import java.util.Optional;

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
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="booking_id", referencedColumnName="id")
	List<Passenger> passengers;
	public List<Passenger> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id", referencedColumnName="booking_id")
	BookingPayment booking_payment;
	
	
//	public Booking getBooking() {
//		return null;
//	}
//	public void setBooking(Booking booking) {
//		
//	}

	
//	@OneToOne(mappedBy="id")
//	BookingAgent booking_agent;
//	
//	@OneToOne(mappedBy="id")
//	BookingUser booking_user;
	
	
}
