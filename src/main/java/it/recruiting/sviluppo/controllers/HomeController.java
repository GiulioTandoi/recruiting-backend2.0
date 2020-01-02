package it.recruiting.sviluppo.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.recruiting.sviluppo.entities.Profilo;
import it.recruiting.sviluppo.entities.Response;
import it.recruiting.sviluppo.repos.HomeRepository;

@RestController
@CrossOrigin(origins= "http://localhost:3000", maxAge = 3600, allowedHeaders = "*")
public class HomeController {

	@Autowired
	HomeRepository repo;
	
	@GetMapping(path="home")
	public Response home() throws SQLException{
		
		ArrayList<Profilo> listaProfiliHome = new ArrayList<Profilo>();
		listaProfiliHome= repo.findAll();
		
		Response response = new Response(listaProfiliHome.size(), listaProfiliHome);
		
		return response;
		
	}
}
