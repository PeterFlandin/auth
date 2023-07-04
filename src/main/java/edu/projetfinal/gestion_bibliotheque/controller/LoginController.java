package edu.projetfinal.gestion_bibliotheque.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/demo/")
public class LoginController {
	
	@GetMapping("/*")
	@RolesAllowed("SUBSCRIBER")
	public String getUser () {
		return "User";
	}
	
	@RolesAllowed("LIBRARIAN")
	@GetMapping("/*")
	public String getAdmin() {
		return "admin";
	}
	
	

};
