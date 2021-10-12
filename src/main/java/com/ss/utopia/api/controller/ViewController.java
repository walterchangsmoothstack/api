package com.ss.utopia.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.Route;
import com.ss.utopia.api.service.AirlineService;

@Controller
public class ViewController {

	@Autowired
	AirlineService airline_service;
	
	@RequestMapping(path="/")
	public String home(HttpServletRequest request, Model model) {
		
		List<Route> routes = airline_service.findAllRoutes();
		model.addAttribute("routes", routes);
		return "home";
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
