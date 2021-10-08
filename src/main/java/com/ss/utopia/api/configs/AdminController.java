package com.ss.utopia.api.configs;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.api.pojo.Airport;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	public final String welcome = "Welcome Admin";
	
	@RequestMapping()
	public String welcome() {
		return "adminHome";
	}
	
	
	
	@RequestMapping(path = "/create", method = RequestMethod.GET)	
	public String showForm(Model model) {
		return "hello ";
//		Airport airport = new Airport();
//		model.addAttribute("airport", airport);
//		return "register_airport";
	}
	
	@PostMapping(path = "/create/airport")	
	public String submitAirport(@ModelAttribute("airport") Airport airport ) {
		System.out.println(airport);
		return "create airport successful";
	}

}
