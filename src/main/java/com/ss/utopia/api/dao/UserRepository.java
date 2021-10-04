package com.ss.utopia.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.User;

public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByUsername(String userName);

}
