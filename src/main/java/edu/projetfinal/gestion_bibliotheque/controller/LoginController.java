package edu.projetfinal.gestion_bibliotheque.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {


	    @GetMapping("/librarian")
	    public String helloSecure() {
	        return "Hello Autour Du Code librarian !";
	    }

	    @GetMapping("/subscriber")
	    public String helloUser() {
	        return "Hello Autour Du Code user!";
	    }
	
}

