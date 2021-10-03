package com.ss.utopia.api.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="route")
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Airport origin_id;
	private Airport destination_id;
	
	
	public Integer getId() {
		return id;
	}


	public Airport getOrigin_id() {
		return origin_id;
	}


	public void setOrigin_id(Airport origin_id) {
		this.origin_id = origin_id;
	}


	public Airport getDestination_id() {
		return destination_id;
	}


	public void setDestination_id(Airport destination_id) {
		this.destination_id = destination_id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	




	

}
