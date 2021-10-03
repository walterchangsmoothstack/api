package com.ss.utopia.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.api.pojo.Airport;
import com.ss.utopia.api.pojo.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	
}
