package com.ss.utopia.api.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ss.utopia.api.dao.AirplaneDAO;
import com.ss.utopia.api.dao.AirplaneRepository;
import com.ss.utopia.api.dao.AirplaneTypeRepository;
import com.ss.utopia.api.dao.AirportRepository;
import com.ss.utopia.api.dao.FlightRepository;
import com.ss.utopia.api.dao.RouteRepository;
import com.ss.utopia.api.pojo.Airplane;
import com.ss.utopia.api.pojo.AirplaneType;
import com.ss.utopia.api.pojo.Airport;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.Route;

@Service
public class AirlineService {

	@Autowired
	AirplaneDAO adao;

	@Autowired
	AirportRepository airport_repository;

	@Autowired
	AirplaneRepository airplane_repository;

	@Autowired
	AirplaneTypeRepository airplane_type_repository;
	
	@Autowired
	FlightRepository flight_repository;
	
	@Autowired
	RouteRepository route_repository;

	public List<Airport> findAllAirports() {
		return airport_repository.findAll();
	}

	public Airport getAirportById(String airport_code) {
		if(airport_code == null) {
			return null;
		}	
		return airport_repository.findById(airport_code.toUpperCase()).get();

	}

	public void deleteAirport(String airport_code) {
		airport_repository.deleteById(airport_code);
	}

	public Airport save(Airport airport) {
		try {
			return airport_repository.saveAndFlush(airport);
		} catch (IllegalArgumentException e) {
			// e.printStackTrace();
			return null;
		}

	}

	public List<Airplane> findAllAirplanes() {
		return airplane_repository.findAll();
	}

	public Airplane getAirplaneById(Integer airplane_id) {
		return airplane_repository.findById(airplane_id).get();
	}

	public Airplane save(Airplane airplane) {
		try {

			return airplane_repository.save(airplane);
			
		} catch (IllegalArgumentException e) {

			// e.printStackTrace();
			return null;
		}
	}

	public void deleteAirplane(Integer airplane_id) {
		airplane_repository.deleteById(airplane_id);
	}

	public AirplaneType getAirplaneTypeById(Integer airplane_type_id) {
		return airplane_type_repository.findById(airplane_type_id).get();
	}

	public List<AirplaneType> findAllAirplaneTypes() {
		return airplane_type_repository.findAll();
	}

	public AirplaneType save(AirplaneType airplane_type) {
		try {
			return airplane_type_repository.save(airplane_type);
		} catch (IllegalArgumentException e) {
			// e.printStackTrace();
			return null;
		}
	}

	public void deleteAirplaneType(Integer airplane_type_id) {
		airplane_type_repository.deleteById(airplane_type_id);
	}
	
	
	public Flight save(Flight flight) {try {

		return flight_repository.save(flight);
		
	} catch (IllegalArgumentException e) {

		// e.printStackTrace();
		return null;
	}
	}
	
	public List<Flight> findAllFlights(){
		return flight_repository.findAll();
	}
	
	public Flight getFlightById(Integer flight_id) {
		return flight_repository.existsById(flight_id) ? flight_repository.getById(flight_id) : null;
	}
	
	
	public void deleteFlight(Integer flight_id) {
		flight_repository.deleteById(flight_id);
	}
	
	
	public Route save(Route route) {try {

		return route_repository.save(route);
		
	} catch (IllegalArgumentException e) {

		// e.printStackTrace();
		return null;
	}
	}
	
	public List<Route> findAllRoutes(){
		return route_repository.findAll();
	}
	
	public Route getRouteById(Integer route_id) {
		return route_repository.existsById(route_id) ? route_repository.getById(route_id) : null;
	}
	
	
	public void deleteRoute(Integer route_id) {
		route_repository.deleteById(route_id);
	}
}