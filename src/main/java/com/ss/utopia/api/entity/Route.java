/**
 * 
 */
package com.ss.utopia.api.entity;

/**
 * @author Walter Chang
 *
 */
public class Route {
	@Override
	public String toString() {
		return "Route [originAirport=" + originAirport + ", destinationAirport=" + destinationAirport + ", routeId="
				+ routeId + "]";
	}
	private String originAirport;
	private String destinationAirport;
	private Integer routeId;
	
	public Route (Integer routeId, String originAirport, String destinationAirport){
		this.routeId = routeId;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
	}
	public Route() {
		
	}
	
	public String getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	

}
