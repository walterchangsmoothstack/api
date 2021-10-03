/**
 * 
 */
package com.ss.utopia.api.entity;

import java.util.List;

/**
 * @author Walter Chang
 *TODO List<Routes> routes
 */
public class Airport {


	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", city=" + city + "]";
	}
	private String airportId;
	private String city;

	private List<Route> routes;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAirportId() {
		return airportId;
	}
	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	
	
	
	
}
