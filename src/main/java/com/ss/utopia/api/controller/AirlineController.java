package com.ss.utopia.api.controller;

import java.sql.SQLException;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.api.dao.AirplaneRepository;
import com.ss.utopia.api.dao.AirportRepository;
import com.ss.utopia.api.pojo.Airplane;
import com.ss.utopia.api.pojo.AirplaneType;
import com.ss.utopia.api.pojo.Airport;
import com.ss.utopia.api.service.AirlineService;


@RestController
public class AirlineController {

	@Autowired
	AirlineService airline_service;
	
	@Autowired
	AirplaneRepository airplane_repository;
	
	@Autowired
	AirportRepository airport_repository;
	
	@RequestMapping(path = "/lms/airports/{airport_code}", method = RequestMethod.GET)
	public Airport getAirportById(@PathVariable String airport_code) {
		return airline_service.getAirportById(airport_code);
	}
	@RequestMapping(path = "/lms/airports", method = RequestMethod.GET)
	public List<Airport> findAllAirports() {
		return airline_service.findAllAirports();
	}
	
	@RequestMapping(path = "/lms/airplanes", method = RequestMethod.GET)
	public List<Airplane> findAllAirplanes() {
		return airline_service.findAllAirplanes();
	}
	@RequestMapping(path = "/lms/airplanes/{airplane_id}", method = RequestMethod.GET)
	public Airplane getAirplaneById(@PathVariable Integer airplane_id) {
		return airline_service.getAirplaneById(airplane_id);
	}
	@RequestMapping(path = "/lms/airplane_types/{airplane_type_id}", method = RequestMethod.GET)
	public AirplaneType getAirplaneTypeById(@PathVariable Integer airplane_type_id) {
		return airline_service.getAirplaneTypeById(airplane_type_id);
	}
	@RequestMapping(path = "/lms/airplane_types", method = RequestMethod.GET)
	public List<AirplaneType> findAllAirplaneTypes() {
		return airline_service.findAllAirplaneTypes();
	}
	
	@Transactional
	@RequestMapping(path = "/lms/find/airplane_type/{airplane_type_id}", method = RequestMethod.GET)
	public List<Airplane> findAirplanesByType(@PathVariable Integer airplane_type_id) {
		return airplane_repository.findByType(airplane_type_id);
	}
//	@RequestMapping(path = "/lms/findAllRoutes/{airport_code}", method = RequestMethod.GET)
//	public List<Airport> findAllRoutes(@PathVariable String airport_code){
//		return airport_repository.findAllRoutes(airport_code);
//		
//		
//	}
//	
//	@RequestMapping(path = "/lms/routes/{airport_code}", method = RequestMethod.GET)
//	public List<Route> findAllRoutes(@PathVariable String airport_code) {
//		Airport a = new Airport();
//		a.setIataId(airport_code);
//		return a.getRoutes();
//	}
	
	
	
	
	
	
	
}
