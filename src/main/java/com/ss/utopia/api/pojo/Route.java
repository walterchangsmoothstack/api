package com.ss.utopia.api.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="route")
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String origin_id;
	private String destination_id;
	
	
	public Integer getId() {
		return id;
	}


	public String getOrigin_id() {
		return origin_id;
	}


	public void setOrigin_id(String origin_id) {
		this.origin_id = origin_id;
	}


	public String getDestination_id() {
		return destination_id;
	}


	public void setDestination_id(String destination_id) {
		this.destination_id = destination_id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Route [id=" + id + ", origin_id=" + origin_id + ", destination_id=" + destination_id + "]";
	}


	


	

}
