package com.ss.utopia.api.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.Route;
import com.ss.utopia.api.pojo.User;
import com.ss.utopia.api.pojo.UserRole;
import com.ss.utopia.api.service.AirlineService;
import com.ss.utopia.api.service.UserService;

@Controller
public class ViewController {

	@Autowired
	AirlineService airline_service;
	
	@Autowired
	UserService user_service;
	
	
	@RequestMapping(path="/")
	public String home(HttpServletRequest request, Model model) {
		
		List<Route> routes = airline_service.findAllRoutes();
		model.addAttribute("routes", routes);
		return "home";
	}
	
	@PostMapping("/process_registration")
	public String addUser(User user){

		user.setUser_role(new UserRole(3, null));
		user_service.save(user);
		return "register_success";
	
	}
	
	
	@RequestMapping(path="/register")
	public String register(HttpServletRequest request, Model model) {
		User user = new User();
		user.setUser_role(new UserRole(3, null));
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(path="/admin")
	public String admin(HttpServletRequest request, Model model) {
		return "admin";
	}
	@RequestMapping(path="/agent")
	public String agent(HttpServletRequest request, Model model) {
		return "agent";
	}
	
	@RequestMapping(path="/traveler")
	public String traveler(HttpServletRequest request, Model model) {
		return "traveler";
	}
	
}
