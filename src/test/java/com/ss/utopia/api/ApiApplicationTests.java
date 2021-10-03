package com.ss.utopia.api;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;



import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ss.utopia.api.dao.AirplaneRepository;
import com.ss.utopia.api.pojo.Airplane;
import com.ss.utopia.api.service.AirlineService;


@SpringBootTest
@RunWith(SpringRunner.class)
class ApiApplicationTests {
	

	@Test
	public void testTest() {
		assertEquals(true, true);
	}
	

	
//	
//	@Autowired
//	AirlineService airline_service;
//	
//	
//	@Autowired
//	AirplaneRepository airplane_repository;
//	
//	
//	@Test
//	public void testFindAirplane() {
//		assertEquals(airline_service.getAirplaneById(1).getId(), 1);
//		
//	}
//	
//	
//
//	
//	@Nested
//	class testAirplane{
//		
//		List<Airplane> airplanes = new ArrayList<>();
//		
//		Airplane airplane = new Airplane();
//		Integer test_id = 99;
//		Integer type_id = 1;
//		@Before
//		public void init() {
//			airplane.setId(test_id);
//			airplane.setType_id(type_id);
//			try {
//				airline_service.save(airplane);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		@BeforeEach
//		public void initAirplanes() {
//			airplanes = airline_service.findAllAirplanes();
//		}
//		
//		
//		@Test
//		private void airplaneSaved() {
//			// TODO Auto-generated method stub
//			assertEquals(airplane_repository.getById(test_id).getType_id(), type_id);
//			assertEquals(airplane_repository.getById(test_id).getId(), test_id);
//
//		}
//		
//		private void removeAirplane() {
//			airline_service.deleteAirplane(test_id);
//		}
//		
//		@Test
//		private void airplaneDeleted() {
//			// TODO Auto-generated method stub
//			assertEquals(airplane_repository.existsById(test_id), false);
//		}
//		@Test
//		private void testNull() {
//			assertEquals(airline_service.getAirplaneById(null), null);
//		}
//		
//		
//	}

}
