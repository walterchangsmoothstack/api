/**
 * 
 */
package com.ss.utopia.api.entity;

/**
 * @author Walter Chang
 *
 */
public class AirplaneType {
	@Override
	public String toString() {
		return "AirplaneType [airplaneTypeId=" + airplaneTypeId + ", maxCapacity=" + maxCapacity + "]";
	}
	private Integer airplaneTypeId;
	private Integer maxCapacity;
	
	public AirplaneType(Integer airplaneTypeId, Integer maxCapacity) {
		this.airplaneTypeId = airplaneTypeId;
		this.maxCapacity = maxCapacity;
	}
	
	public AirplaneType() {
		
	}
	
	public Integer getAirplaneTypeId() {
		return airplaneTypeId;
	}
	public void setAirplaneTypeId(Integer airplaneId) {
		this.airplaneTypeId = airplaneId;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
