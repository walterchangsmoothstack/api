package com.ss.utopia.api.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking_guest")
public class BookingGuest extends BookingType {
	
	@Id
	private Integer booking_id;
	private String email;
	private String phone;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="booking_id", referencedColumnName="id")
	Booking booking;

	@Override
	public String toString() {
		return "BookingGuest [booking_id=" + booking_id + ", email=" + email + ", phone=" + phone + "]";
	}

	public Integer getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
