package it.recruiting.sviluppo.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.recruiting.sviluppo.pojo.LoginControllerPojo;
import it.recruiting.sviluppo.services.SelezionatoreService;

@RestController
@CrossOrigin(origins= "http://localhost:3000", maxAge = 3600, allowedHeaders = "*")
public class LoginController {

	@Autowired
	SelezionatoreService selezionatoreService;
	
	
	@RequestMapping(value="login",  method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Integer> loginUser (@RequestBody LoginControllerPojo logPojo) throws SQLException {
		
		int id = selezionatoreService.login(logPojo.getEmail(), logPojo.getPassword());
		if (id==-1) {
			
			return new ResponseEntity<>( id, HttpStatus.BAD_REQUEST );  // ResponseEntity è un oggetto usato per ritornare qualcosa nel body
			//della post al frontend e questo qualcosa è l'id che il dao ottiene dalla query
			
		}
		
		return new ResponseEntity<>(id, HttpStatus.OK);
		
	}		
	
	
}
	

