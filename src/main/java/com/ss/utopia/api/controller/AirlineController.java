package com.ss.utopia.api.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ss.utopia.api.dao.AirplaneRepository;
import com.ss.utopia.api.dao.AirplaneTypeRepository;
import com.ss.utopia.api.dao.AirportRepository;
import com.ss.utopia.api.dao.RouteRepository;
import com.ss.utopia.api.pojo.Airplane;
import com.ss.utopia.api.pojo.AirplaneType;
import com.ss.utopia.api.pojo.Airport;
import com.ss.utopia.api.pojo.Route;
import com.ss.utopia.api.service.AirlineService;


@RestController
@RequestMapping("/lms")
public class AirlineController {

	@Autowired
	AirlineService airline_service;
	
	@Autowired
	AirplaneRepository airplane_repository;
	
	@Autowired
	AirplaneTypeRepository airplane_type_repository;
	
	@Autowired
	AirportRepository airport_repository;
	
	
	@Autowired
	RouteRepository route_repository;
	
	@GetMapping("/user")
	public String userAndAgent() {
		return "For Booking";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "For Manipulating";
	}
	@GetMapping("/guest")
	public String everyone() {
		return "For Reading";
	}
	
	
	
	@RequestMapping(path = "/lms/airports/{airport_code}", method = RequestMethod.GET)
	public ResponseEntity<Airport> getAirportById(@PathVariable String airport_code) {
		return ResponseEntity.ok().body(airline_service.getAirportById(airport_code));
	}
	@RequestMapping(path = "/lms/airports", method = RequestMethod.GET)
	public ResponseEntity<List<Airport>> findAllAirports() {
		return ResponseEntity.ok().body(airline_service.findAllAirports());
	}
	
	@RequestMapping(path = "/lms/airplanes", method = RequestMethod.GET)
	public ResponseEntity<List<Airplane>> findAllAirplanes() {
		return ResponseEntity.ok().body(airline_service.findAllAirplanes());
	}
	@RequestMapping(path = "/lms/airplanes/{airplane_id}", method = RequestMethod.GET)
	public ResponseEntity<Airplane> getAirplaneById(@PathVariable Integer airplane_id) {
		return ResponseEntity.ok().body(airline_service.getAirplaneById(airplane_id));
	}
	@RequestMapping(path = "/lms/airplane_types/{airplane_type_id}", method = RequestMethod.GET)
	public ResponseEntity<AirplaneType> getAirplaneTypeById(@PathVariable Integer airplane_type_id) {
		return ResponseEntity.ok().body(airline_service.getAirplaneTypeById(airplane_type_id));
	}
	@RequestMapping(path = "/lms/airplane_types", method = RequestMethod.GET)
	public ResponseEntity<List<AirplaneType>> findAllAirplaneTypes() {
		return ResponseEntity.ok().body(airline_service.findAllAirplaneTypes());
	}
	
	@RequestMapping(path = "/lms/save/airplane", method = RequestMethod.GET)
	public ResponseEntity<List<AirplaneType>> saveAirplane(@RequestBody Airplane airplane) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/airplane").toUriString());
		return ResponseEntity.created(uri).body(airline_service.findAllAirplaneTypes());
	}
	
	
	@RequestMapping(path = "/lms/find/airplane_type/{airplane_type_id}", method = RequestMethod.GET)
	public ResponseEntity<List<Airplane>> findAirplanesByType(@PathVariable Integer airplane_type_id) {
		return ResponseEntity.ok().body(airplane_repository.findByType(airplane_type_id));
	}
	
	
	@RequestMapping(path = "/lms/find/destination_airports/{airport_code}", method = RequestMethod.GET)
	public ResponseEntity<List<Route>> findValidDestinationAirport(@PathVariable String airport_code) {
			return ResponseEntity.ok().body(airline_service.getAirportById(airport_code).getAs_origin());
		}
	
	@Transactional
	@GetMapping("/find/insert")
	public void test() {

//		airline_service.deleteAirport(airline_service.getAirportById("YYY").getIataId());

//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
		
		
//		Employee employee = em.find(Employee.class, 1);
//
//		  em.getTransaction().begin();
//		  em.remove(employee);
//		  em.getTransaction().commit();
		
		//airline_service.deleteAirplane(8);
		//airplane_type_repository.testdelete(101);
		airline_service.deleteAirplaneType(101);
//		session.getTransaction().commit();
//		session.close();
		//airline_service.deleteAirport("YYY");
		
//		Airport a = new Airport();
//		a.setIataId("YYY");
//		a.setCity("Yellowstone");
		//airport_repository.save(a);
		}
	
	
//	@RequestMapping(path = "/lms/findAllRoutes/{airport_code}", method = RequestMethod.GET)
//	public ResponseEntity<List<Airport>> findAllRoutes(@PathVariable String airport_code){
//		return ResponseEntity.ok().body(airport_repository.findAllRoutes(airport_code));
//		
//		
//	}
//	
//	@RequestMapping(path = "/lms/routes/{airport_code}", method = RequestMethod.GET)
//	public ResponseEntity<List<Route>> findAllRoutes(@PathVariable String airport_code) {
//		Airport a = new Airport();
//		a.setIataId(airport_code);
//		return a.getRoutes();
//	}
	
	
	
	
	
	
	
}
