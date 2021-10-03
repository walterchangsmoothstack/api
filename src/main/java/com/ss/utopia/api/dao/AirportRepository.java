package com.ss.utopia.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.api.pojo.Airport;



public interface AirportRepository extends JpaRepository<Airport, String> {

	
	
	Optional<Airport> findById(String airportCode);
	

	
	
}
