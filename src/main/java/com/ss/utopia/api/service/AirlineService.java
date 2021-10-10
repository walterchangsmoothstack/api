package com.ss.utopia.api.service;

import java.time.LocalDate;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
		if (airport_code == null) {
			return null;
		}
		return airport_repository.getAirportById(airport_code.toUpperCase()).get();

	}

	public List<Route> findAllRoutes() {
		return route_repository.findAll();
	}

	public Route getRouteById(Integer route_id) {
		return route_repository.existsById(route_id) ? route_repository.getById(route_id) : null;
	}

	public List<AirplaneType> findAllAirplaneTypes() {
		return airplane_type_repository.findAll();
	}

	public AirplaneType getAirplaneTypeById(Integer airplane_type_id) {
		return airplane_type_repository.findById(airplane_type_id).get();
	}

	public List<Airplane> findAllAirplanes() {
		return airplane_repository.findAll();
	}

	public Airplane getAirplaneById(Integer airplane_id) {
		return airplane_repository.findById(airplane_id).get();
	}

	public List<Flight> findAllFlights() {
		return flight_repository.findAll();
	}

	public Flight getFlightById(Integer flight_id) {
		return flight_repository.existsById(flight_id) ? flight_repository.getById(flight_id) : null;
	}

	public Airport save(Airport airport) {
		try {
			return airport_repository.saveAndFlush(airport);
		} catch (IllegalArgumentException e) {
			return null;
		}

	}

	public Route save(Route route) {
		try {

			return route_repository.save(route);

		} catch (IllegalArgumentException e) {

			// e.printStackTrace();
			return null;
		}
	}

	public Airplane save(Airplane airplane) {
		try {

			return airplane_repository.save(airplane);

		} catch (IllegalArgumentException e) {

			return null;
		}
	}

	public AirplaneType save(AirplaneType airplane_type) {
		try {
			return airplane_type_repository.save(airplane_type);
		} catch (IllegalArgumentException e) {
			// e.printStackTrace();
			return null;
		}
	}

	public Flight save(Flight flight) {
		try {

			return flight_repository.save(flight);

		} catch (IllegalArgumentException e) {

			// e.printStackTrace();
			return null;
		}
	}

	@Transactional
	public Optional<Airport> update(Airport airport) {

		if (airport_repository.existsById(airport.getIataId().toUpperCase())) {
			Airport airport_to_save = airport_repository.getAirportById(airport.getIataId()).get();
			if (airport.getCity() != null) {
				airport_to_save.setCity(airport.getCity());
			}
			return Optional.of(airport_to_save);
		}

		return Optional.empty();
	}

	@Transactional
	public Optional<Route> update(Route route) {
		if (route_repository.existsById(route.getId())) {
			Route route_to_save = route_repository.findById(route.getId()).get();
			if (route.getOrigin_id() != null) {
				route_to_save.setOrigin_id(route.getOrigin_id());
			}
			if (route.getDestination_id() != null) {
				route_to_save.setDestination_id(route.getDestination_id());
			}

			return Optional.of(route_to_save);
		}
		return Optional.empty();
	}

	public Optional<AirplaneType> update(AirplaneType airplane_type) {
		if (airplane_type_repository.existsById(airplane_type.getId())) {
			airplane_type_repository.save(airplane_type);
			return Optional.of(airplane_type);
		}
		return Optional.empty();
	}

	public Optional<Airplane> update(Airplane airplane) {
		if (airplane_repository.existsById(airplane.getId())) {
			airplane_repository.save(airplane);
			return Optional.of(airplane);
		}
		return Optional.empty();
	}

	@Transactional
	public Optional<Flight> update(Flight flight) {
		if (flight_repository.existsById(flight.getId())) {
			Flight flight_to_save = flight_repository.findById(flight.getId()).get();
			if (flight.getAirplane_id() != null) {
				flight_to_save.setAirplane_id(flight.getAirplane_id());
			}
			if (flight.getRoute_id() != null) {
				flight_to_save.setRoute_id(flight.getRoute_id());
			}
			if (flight.getDeparture_time() != null) {
				flight_to_save.setDeparture_time(flight.getDeparture_time());
			}
			if (flight.getReserved_seats() != null) {
				flight_to_save.setReserved_seats(flight.getReserved_seats());
			}
			if (flight.getSeat_price() != null) {
				flight_to_save.setSeat_price(flight.getSeat_price());
			}
			return Optional.of(flight_to_save);
		}
		return Optional.empty();
	}

	/* JpaRepository custom query to handle String airport_code */
	public void deleteAirportById(String airport_code) {

		airport_repository.deleteAirportById(airport_code.toUpperCase());
	}

	public void deleteRoute(Integer route_id) {
		route_repository.deleteById(route_id);
	}

	public void deleteAirplaneType(Integer airplane_type_id) {
		airplane_type_repository.deleteById(airplane_type_id);
	}

	public void deleteAirplane(Integer airplane_id) {
		airplane_repository.deleteById(airplane_id);
	}

	public void deleteFlight(Integer flight_id) {
		flight_repository.deleteById(flight_id);
	}

	/* Special Queries */

	public List<Flight> findFlightByRoute(Integer route_id) {
		return flight_repository.findAll().stream().filter(x -> x.getRoute_id() == route_id)
				.collect(Collectors.toList());
	}

	public List<Flight> findFlightByAirplane(Integer airplane_id) {
		return flight_repository.findAll().stream().filter(x -> x.getAirplane_id() == airplane_id)
				.collect(Collectors.toList());
	}

//	public List<Flight> filterFlightByDate(List<Flight> flights, LocalDate after, LocalDate before) {
//		if (after == null)
//			after = LocalDate.now();
//		if (before == null)
//			before = LocalDate.now().plusYears(10);
//		flights.stream().filter(x -> x.getDeparture_time().isBefore(before.atStartOfDay())
//				&& x.getDeparture_time().isAfter(after.atStartOfDay())).collect(Collectors.toList());
//	}

//	public List<Airplane> filterAirplaneByMaxCapacity(Integer min, Integer max) {
//		if (min == null)
//			min = 0;
//		if (max == null)
//			max = Integer.MAX_VALUE;
//		Integer min_final = min;
//		Integer max_final = max;
//		return airplane_type_repository.findAll().stream()
//				.filter(x -> x.getMax_capacity() >= min_final && x.getMax_capacity() <= max_final)
//				.map(x -> airplane_repository.findByType(x.getId())).collect(Collectors.toList()).stream().flatMap(List::stream)
//		        .collect(Collectors.toList());
//	}

}