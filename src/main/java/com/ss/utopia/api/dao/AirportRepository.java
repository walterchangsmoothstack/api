package com.ss.utopia.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ss.utopia.api.pojo.Airport;



public interface AirportRepository extends JpaRepository<Airport, String> {

	
//	@Query("SELECT r.destination_id, a.city FROM airport a JOIN route r WHERE ?1 = r.origin_id")
//	public List<Airport> findAllRoutes(String airportCode);
	
	Optional<Airport> findById(String airportCode);
	

	
	
}
