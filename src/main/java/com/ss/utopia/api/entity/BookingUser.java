/**
 * 
 */
package com.ss.utopia.api.entity;

/**
 * @author Walter Chang
 *
 */
public class BookingUser {
@Override
	public String toString() {
		return "BookingUser [bookingId=" + bookingId + ", id=" + id + "]";
	}

private Integer bookingId;
private Integer id;

public Integer getBookingId() {
	return bookingId;
}

public void setBookingId(Integer bookingId) {
	this.bookingId = bookingId;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
}
