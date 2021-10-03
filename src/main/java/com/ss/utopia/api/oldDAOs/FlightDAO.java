/**
 * 
 */
package com.ss.utopia.api.oldDAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ss.utopia.api.entity.Airplane;
import com.ss.utopia.api.entity.AirplaneType;
import com.ss.utopia.api.entity.Airport;
import com.ss.utopia.api.entity.Flight;
import com.ss.utopia.api.entity.Route;

/**
 * @author Walter Chang
 *
 */
@Component
public class FlightDAO extends BaseDAO<Flight>{

//	public FlightDAO(Connection conn) {
//		super(conn);
//	}
	
//	public Connection getConnection() throws SQLException {
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		Connection conn = (Connection) DriverManager.getConnection(
//				"jdbc:mysql://localhost/utopia",
//				"root", "");
//		return conn;
//	}
	
	
	
	public void addFlight(Flight flight) throws SQLException, ClassNotFoundException {
		
		
		savePK("INSERT INTO flight (id, route_id, airplane_id, departure_time, reserved_seats, "
				+ "seat_price) VALUES(?,?,?,?,?,?)", 
				new Object[] {flight.getId(), flight.getRoute().getRouteId(), flight.getAirplane().getAirplaneId(), 
						flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice()});
	}
	public void updateFlight(Flight flight) throws SQLException, ClassNotFoundException {
		save("UPDATE flight SET route_id = ? , airplane_id = ?, "
				+ " departure_time = ?, reserved_seats = ?, seat_price =? WHERE id = ?", 
				new Object[] {flight.getRoute().getRouteId(), flight.getAirplane().getAirplaneId()
						, flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice()
						, flight.getId()});
	}
	
	public void deleteFlight(Integer id) throws SQLException, ClassNotFoundException {
		save("DELETE FROM flight WHERE id = ?",
				new Object[] {id});
	}
	
	public List<Flight> readFlight() throws ClassNotFoundException, SQLException {
		return read("SELECT f.id, f.route_id, f.airplane_id, f.departure_time, f.reserved_seats, f.seat_price, a_t.max_capacity, a_t.id AS type_id, r.origin_id, r.destination_id "
				+ "FROM flight f  "
				+ "JOIN airplane a ON a.id = f.airplane_id "
				+ "JOIN airplane_type a_t ON a_t.id = a.type_id "
				+ "JOIN route r ON r.id = f.route_id", null);
	}
	
//	public List<Flight> readFlight() throws ClassNotFoundException, SQLException {
//		return read("SELECT * FROM flight", null);
//	}
		
	public List<Flight> readFlightByRoute(Route route) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight WHERE route_id = ?", new Object[] {route.getRouteId()});
	}
	
	public List<Flight> readFlightById(Integer flight_id) throws ClassNotFoundException, SQLException {
		System.out.println(flight_id);
		return read("SELECT f.id, f.route_id, f.airplane_id, f.departure_time, f.reserved_seats, f.seat_price, a_t.max_capacity, a_t.id AS type_id, r.origin_id, r.destination_id "
				+ "FROM flight f  "
				+ "JOIN airplane a ON a.id = f.airplane_id "
				+ "JOIN airplane_type a_t ON a_t.id = a.type_id "
				+ "JOIN route r ON r.id = f.route_id "
				+ "WHERE f.id = ?", new Object[] {flight_id});	
		
	}
	
	protected List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flightList = new ArrayList<>();
		while(rs.next()) { 
			Flight flight = new Flight();
			flight.setId(rs.getInt("id"));
			flight.setAirplane(new Airplane(rs.getInt("airplane_id"), new AirplaneType(rs.getInt("type_id"), rs.getInt("max_capacity"))));
			flight.setRoute(new Route(rs.getInt("route_id"), rs.getString("origin_id"), rs.getString("destination_id")));
			flight.setDepartureTime(rs.getTimestamp("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flightList.add(flight);
	}
		return flightList;
	}
	

	
}
