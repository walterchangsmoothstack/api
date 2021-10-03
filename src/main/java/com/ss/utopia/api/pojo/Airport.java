package com.ss.utopia.api.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airport")
public class Airport {
	

	@Id
	private String iataId;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Airport [airportId=" + iataId + ", city=" + city + "]";
	}
	public String getIataId() {
		return iataId;
	}
	public void setIataId(String iataId) {
		this.iataId = iataId;
	}
	
	
	
}