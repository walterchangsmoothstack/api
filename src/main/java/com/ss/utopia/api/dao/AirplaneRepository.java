package com.ss.utopia.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.api.pojo.Airplane;


public interface AirplaneRepository extends JpaRepository<Airplane, Integer>{

		
		
		Optional<Airplane> findById(Integer airplane_id);
		
		Airplane save(Airplane airplane);

		boolean existsById(Integer airplane_id);
}
