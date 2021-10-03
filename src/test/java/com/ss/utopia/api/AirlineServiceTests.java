package com.ss.utopia.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.ss.utopia.api.dao.AirplaneRepository;
import com.ss.utopia.api.dao.AirplaneTypeRepository;
import com.ss.utopia.api.dao.AirportRepository;
import com.ss.utopia.api.dao.FlightRepository;
import com.ss.utopia.api.pojo.Airplane;
import com.ss.utopia.api.pojo.AirplaneType;
import com.ss.utopia.api.pojo.Airport;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.service.AirlineService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AirlineServiceTests {
		
		@Autowired
		AirlineService airline_service;
		
		
		@Autowired
		AirplaneRepository airplane_repository;
		
		
		@Autowired
		AirplaneTypeRepository airplane_type_repository;
		
		
		@Autowired
		AirportRepository airport_repository;
		
		@Autowired
		FlightRepository flight_repository;
		
		
//		@Nested
//		public 	class testAirplane{
//						
//			Airplane airplane = new Airplane();
//			
//
//			Integer bad_id = 9999999;
//			Integer good_id;
//			Integer type_id = 1;
//		
//			
//			public void init() {
//				airplane.setType_id(type_id);
//				this.airplane = airline_service.save(airplane);
//				this.good_id = airplane.getId();
//				this.type_id = airplane.getType_id();
//			}
//			
//			public void tearDown() {
//				airline_service.deleteAirplane(good_id);
//			}
//			
//			@Test
//			public void testFindAirplane() {
//
//				assertEquals(airline_service.getAirplaneById(1).getId(), 1);
//				
//			}
//			
//			@Transactional
//			@Test
//			public void testTypeId() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getAirplaneById(good_id).getType_id(), type_id);
//				tearDown();
//			}
//			
//			@Test
//			public void testId() {
//				init();
//				assertEquals(airplane_repository.getById(airplane.getId()).getId(), airplane.getId());
//				tearDown();
//			}
//			
//			
//			
//			
//			@Test
//			public void isDeleted() {
//				init();
//				tearDown();
//				assertEquals(airplane_repository.existsById(airplane.getId()), false);
//			}
//			@Test
//			public void testNull() {
//				 assertThrows(InvalidDataAccessApiUsageException.class,
//				            ()->{
//				            airline_service.getAirplaneById(null);
//				            });
//			}
//			@Test
//			public void testFalse() {
//				 assertThrows(NoSuchElementException.class,
//				            ()->{
//				            airline_service.getAirplaneById(bad_id);
//				            });
//			}
//			
//			
//		}
//		
//		
//		
//		@Nested
//		public 	class testAirplaneType{
//						
//			AirplaneType airplane_type = new AirplaneType();
//			
//
//			Integer bad_id = 9999999;
//			Integer good_id;
//			Integer maximum_capacity = 100;
//		
//			
//			public void init() {
//				airplane_type.setMax_capacity(maximum_capacity);
//				this.airplane_type = airline_service.save(airplane_type);
//				this.good_id = airplane_type.getId();
//				this.maximum_capacity = airplane_type.getMax_capacity();
//			}
//			
//			public void tearDown() {
//				airline_service.deleteAirplaneType(good_id);
//			}
//			
//			@Test
//			public void testFindAirplaneType() {
//
//				assertEquals(airline_service.getAirplaneTypeById(1).getId(), 1);
//				
//			}
//			
//			@Transactional
//			@Test
//			public void testMaxCapacity() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getAirplaneTypeById(good_id).getMax_capacity(), maximum_capacity);
//				tearDown();
//			}
//			
//			@Test
//			public void testId() {
//				init();
//				assertEquals(airplane_type_repository.getById(airplane_type.getId()).getId(), airplane_type.getId());
//				tearDown();
//			}
//			
//			
//			
//			
//			@Test
//			public void isDeleted() {
//				init();
//				tearDown();
//				assertEquals(airplane_type_repository.existsById(good_id), false);
//			}
//			@Test
//			public void testNull() {
//				 assertThrows(InvalidDataAccessApiUsageException.class,
//				            ()->{
//								 airline_service.getAirplaneTypeById(null);
//				            });
//			}
//			
//			@Test
//			public void testFalse() {
//				 assertThrows(NoSuchElementException.class,
//				            ()->{
//				            airline_service.getAirplaneTypeById(bad_id);
//				            });
//			}
//			
//			
//			
//		}
//		
//		
//		
//		@Nested
//		public 	class testAirport{
//						
//			Airport airport = new Airport();
//			
//
//			String bad_id = "ABCD";
//			String good_id = "ABC";
//			String city = "Chino Hills";
//		
//			
//			public void init() {
//				airport.setCity(city);
//				airport.setIataId(good_id);
//				this.airport = airline_service.save(airport);
//				this.good_id = airport.getIataId();
//				this.city = airport.getCity();
//			
//			}
//			
//			public void tearDown() {
//				airline_service.deleteAirport(good_id);
//			}
//			
//			@Test
//			public void testFindAirport() {
//
//				assertEquals(airline_service.getAirportById("LAX").getCity(), "Los Angeles");
//				
//			}
//			
//			@Transactional
//			@Test
//			public void testCity() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getAirportById(good_id).getCity(), city);
//				tearDown();
//			}
//			
//			@Test
//			public void testId() {
//				init();
//				assertEquals(airline_service.getAirportById(airport.getIataId()).getIataId(), good_id);
//				tearDown();
//			}
//			
//			
//			
//			
//			@Test
//			public void isDeleted() {
//				init();
//				tearDown();
//				assertEquals(airport_repository.existsById(good_id), false);
//			}
//			@Test
//			public void testNull() {
//				 assertThrows(InvalidDataAccessApiUsageException.class,
//				            ()->{
//								 airline_service.getAirportById(null);
//				            });
//			}
//			
//			@Test
//			public void testFalse() {
//				 assertThrows(NoSuchElementException.class,
//				            ()->{
//				            airline_service.getAirportById(bad_id);
//				            });
//			}
//			
//			
//			
//		}
//		
//		
//		@Nested
//		public 	class testFlight{
//						
//			Flight flight = new Flight();
//			
//
//			Integer good_id;
//			Integer bad_id = 999;
//			Integer route_id = 490;
//			LocalDateTime dt = LocalDateTime.now();
//			Integer airplane_id = 14;
//			Integer reserved_seats = 0;
//			Float seat_price = (float) 100.0;
//		
//			
//			public void init() {
//				flight.setRouteId(route_id);
//				flight.setAirplaneId(airplane_id);
//				flight.setDepartureTime(dt);
//				flight.setReservedSeats(reserved_seats);
//				flight.setSeatPrice(seat_price);
//				
//				this.flight = airline_service.save(flight);
//				this.good_id = flight.getId();
//				this.route_id = flight.getRouteId();
//				this.airplane_id = flight.getAirplaneId();
//				this.reserved_seats = flight.getReservedSeats();
//				this.seat_price = flight.getSeatPrice();
//				this.dt = flight.getDepartureTime();
//			}
//			
//			public void tearDown() {
//				airline_service.deleteFlight(good_id);
//			}
//			
//			@Transactional
//			@Test
//			public void testRoute() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getFlightById(good_id).getRouteId(), route_id);
//				tearDown();
//			}
//			
//			@Transactional
//			@Test
//			public void testAirplane() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getFlightById(good_id).getAirplaneId(), airplane_id);
//				tearDown();
//			}
//			@Transactional
//			@Test
//			public void testDate() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getFlightById(good_id).getDepartureTime(), dt);
//				tearDown();
//			}
//			
//			@Transactional
//			@Test
//			public void testReservedSeats() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getFlightById(good_id).getReservedSeats(), reserved_seats);
//				tearDown();
//			}
//			@Transactional
//			@Test
//			public void testSeatPrice() {
//				// TODO Auto-generated method stub
//				init();
//				assertEquals(airline_service.getFlightById(good_id).getSeatPrice(), seat_price);
//				tearDown();
//			}
//			
//			
//			
//			
//			@Test
//			public void testId() {
//				init();
//				assertEquals(airline_service.getFlightById(good_id).getId(), good_id);
//				tearDown();
//			}
//			
//			
//			
//			
//			@Test
//			public void isDeleted() {
//				init();
//				tearDown();
//				assertEquals(flight_repository.existsById(good_id), false);
//			}
//			@Test
//			public void testNull() {
//				 assertThrows(InvalidDataAccessApiUsageException.class,
//				            ()->{
//								 airline_service.getFlightById(null);
//				            });
//			}
//			
//			@Transactional
//			@Test
//			public void testFalse() {
//				assertEquals(null, airline_service.getFlightById(bad_id));
////				assertEquals(false, flight_repository.existsById(bad_id));
//
//				
//			}
//			
//			
//			
//		}

	
}
