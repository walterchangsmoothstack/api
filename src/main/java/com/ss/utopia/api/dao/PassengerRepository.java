package com.ss.utopia.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.api.pojo.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
