package com.ss.utopia.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ss.utopia.api.pojo.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	
	@Query(value="SELECT b.id, b.confirmation_code, b.is_active FROM user u, booking_agent ba, booking_user bu, booking b WHERE u.username = ?1 AND u.id = ba.agent_id AND ba.booking_id = b.id OR u.username = ?1 AND u.id = bu.user_id AND bu.booking_id = b.id GROUP BY b.id", nativeQuery=true)
	public List<Booking> getBookingsByUser(String username);
	
}
