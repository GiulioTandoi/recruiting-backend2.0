package it.recruiting.sviluppo.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.recruiting.sviluppo.entities.Profilo;
import it.recruiting.sviluppo.services.ProfiloService;

@RestController
@CrossOrigin(origins= "http://localhost:3000", maxAge = 3600, allowedHeaders = "*")
public class ProfiloController {

	@Autowired
	ProfiloService profiloService;
	
	@GetMapping(path="profilo")
	public Profilo ottieniDettaglioPreferito(@RequestParam(value="id") int id) throws SQLException{
		
		Profilo profilo = profiloService.showStandardProfileDetails(id);
		return profilo;
	}
}
