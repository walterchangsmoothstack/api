/**
 * 
 */
package com.ss.utopia.api.entity;

/**
 * @author Walter Chang
 *
 */
public class Airplane {

	@Override
	public String toString() {
		return "Airplane [type=" + type.getAirplaneTypeId() + ", airplaneId=" + airplaneId + "]";
	}
	private AirplaneType type;
	private Integer airplaneId;
	
	public Airplane(Integer airplaneId, AirplaneType type) {
		this.type = type;
		this.airplaneId = airplaneId;
	}
	public Airplane() {
		
	}
	public AirplaneType getType() {
		return type;
	}
	public void setType(AirplaneType type) {
		this.type = type;
	}
	public Integer getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}
	
}
