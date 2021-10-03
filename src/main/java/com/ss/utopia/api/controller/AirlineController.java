package com.ss.utopia.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.api.dao.AirplaneRepository;
import com.ss.utopia.api.pojo.Airplane;
import com.ss.utopia.api.pojo.AirplaneType;
import com.ss.utopia.api.pojo.Airport;
import com.ss.utopia.api.service.AirlineService;

@RestController
public class AirlineController {

	@Autowired
	AirlineService airline_service;
	
	@Autowired
	AirplaneRepository repo;
	
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
	
	@RequestMapping(path = "/lms/airplane_types/save", method = RequestMethod.GET)
	public Airplane saveAirplane() {
		Airport p = new Airport();
		p.setCity("asdf");
		p.setIataId("KFC");
		
		Airplane a = new Airplane();
		a.setType_id(14);
		
		AirplaneType at = new AirplaneType();
		at.setId(20000);
		at.setMax_capacity(100000);

			return airline_service.save(a);
			//airline_service.save(at);
		
	}
	
	
	
	
}
