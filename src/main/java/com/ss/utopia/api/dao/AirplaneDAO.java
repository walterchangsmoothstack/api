package com.ss.utopia.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.utopia.api.pojo.Airplane;

@Component
public class AirplaneDAO {

	
	@Autowired
	AirplaneRepository repo;
	
	public Airplane save(Airplane a) {
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
		return repo.save(a);
	}
}
