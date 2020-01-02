package it.recruiting.sviluppo.controllers;

import java.sql.SQLException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.recruiting.sviluppo.entities.Selezionatore;
import it.recruiting.sviluppo.pojo.RegistrazionePojo;
import it.recruiting.sviluppo.risorse.Stringhe;
import it.recruiting.sviluppo.services.SelezionatoreService;


@RestController
@CrossOrigin(origins= "http://localhost:3000", maxAge = 3600, allowedHeaders = "*")
public class RegistrationController {
	
	SelezionatoreService controller =new SelezionatoreService();
	Selezionatore selezionatore = null;
	@PostMapping("registration")
	public @ResponseBody ResponseEntity<String> registrationUser(@RequestBody RegistrazionePojo regPojo) throws SQLException {

		
//		if (!controller.checkIfRegistered(regPojo.getEmail())) {
//			
//			return new ResponseEntity<>(Stringhe.UTENTEESISTENTE, HttpStatus.CONFLICT);
//			
//		}else {
			selezionatore = new Selezionatore(regPojo.getNome(), regPojo.getCognome(),
				regPojo.getPassword(), regPojo.getEmail(), regPojo.getStato());
//		}
		// effettuo la registrazione
		boolean creato = controller.registration(selezionatore);
		if (creato){
			
			return new ResponseEntity<>(Stringhe.SUCCESSOREGISTRAZIONE, HttpStatus.CREATED); 
			
			
		}else {		
		
			return new ResponseEntity<>(Stringhe.REGISTRAZIONEFALLITA, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}
