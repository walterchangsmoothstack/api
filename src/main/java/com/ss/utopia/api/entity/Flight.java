/**
 * 
 */
package com.ss.utopia.api.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Walter Chang
 *
 */
public class Flight {

	@Override
	public String toString() {
		return "Flight [id=" + id + ", route=" + route.getRouteId() + " "+route.getOriginAirport()+"-"+route.getDestinationAirport()+ ", airplane=" + airplane + ", reservedSeats=" + reservedSeats
				+ ", departureTime=" + departureTime + ", seatPrice=" + seatPrice + "]";
	}
	private Integer id;
	private Route route;
	private Airplane airplane;
	private Integer reservedSeats;
	private Timestamp departureTime;
	private Float seatPrice;
	
	
	public Flight(Integer id, Route route, Airplane airplane, Integer reservedSeats, Timestamp departureTime,
			Float seatPrice) {
		super();
		this.id = id;
		this.route = route;
		this.airplane = airplane;
		this.reservedSeats = reservedSeats;
		this.departureTime = departureTime;
		this.seatPrice = seatPrice;
	}
	public Flight() {

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public Timestamp getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}
	public Float getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
}
