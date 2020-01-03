package it.recruiting.sviluppo.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.recruiting.sviluppo.entities.Profilo;
import it.recruiting.sviluppo.entities.Response;
import it.recruiting.sviluppo.entities.Selezionatore;
import it.recruiting.sviluppo.pojo.AggiuntaPreferitoPojo;
import it.recruiting.sviluppo.repos.PreferitiRepository;
import it.recruiting.sviluppo.repos.SelezionatoreRepository;
import it.recruiting.sviluppo.services.ProfiloService;
import it.recruiting.sviluppo.services.SelezionatoreService;



@RestController
@CrossOrigin(origins= "http://localhost:3000", maxAge = 3600, allowedHeaders = "*")
public class SelezionatoreController {

	@Autowired
	SelezionatoreRepository repo;
	
	@Autowired
	SelezionatoreService selezionatoreService;
	
	@Autowired
	ProfiloService profiloService;
	
	@GetMapping(path="dettagliSelezionatore")
	public Selezionatore visualizzaDettagli (@RequestParam(value="id") int id ) throws SQLException{
		
		
		Selezionatore selezionatore= repo.findById(id);
		
		return selezionatore;
	}
//	
//	//==================================================== Preferiti ===================================================================
	
	@PostMapping(path="inserisciPreferito")
	public String inserisciPreferito(@RequestBody AggiuntaPreferitoPojo pPojo) throws SQLException{
		
		System.out.println(pPojo.getIdSelezionatore() + " "+ pPojo.getIdProfilo());
		profiloService.insertInListaPreferiti(pPojo);
		return new String ("Aggiunta effettuata!");
		
	}
	
	@GetMapping(path="listaPreferiti")
	public Response mostraListaPreferiti (@RequestParam(value="id_selezionatore") int id ) throws SQLException{
		
		
		// TODO devo chiamare un metodo del service che matcha Elencopreferiti e Profili sul db tramite 
		// gli id e restituisce un arraylist di profilo 
		
		ArrayList<Profilo> favouritesList = selezionatoreService.getFavourites(id);
		
		if(favouritesList.isEmpty()) {
			return null;
		}
		
		Response response= new Response(favouritesList.size(), favouritesList);
		
		return response;
		
	}
//	
//	@GetMapping(path="linkPreferito")
//	public String ottieniLink(@RequestParam(value="id") int id) throws SQLException {
//		
//		String link=null;
//		link= pDAO.ottieniLink(id);
//		return link;
//		
//	}
//	
//	@GetMapping(path="profilo")
//	public Profilo ottieniDettaglioPreferito(@RequestParam(value="id") int id) throws SQLException{
//		
//		Profilo p= pDAO.dettaglioPreferito(id);
//		return p;
//	}

//	
//	// ===================================================== Modifica dati profilo ======================================================
//	
//	@PostMapping(path="modificaDettagli")
//	public @ResponseBody Selezionatore aggiornaProfilo (@RequestBody RegistrazionePojo selezionatore) throws SQLException{
//		Selezionatore s = sd.updateSelezionatore(selezionatore);
//		return s;
//	}
//	
////	@PostMapping(path="modificaEmail")
////	public @ResponseBody Selezionatore aggiornaEmail (@RequestBody RegistrazionePojo regPojo) throws SQLException {
////		
////		
////		Selezionatore selezionatore = sd.updateEmail(regPojo.getEmail(), regPojo.getId());
////		
////		return selezionatore;
////	}
////	
////	@PostMapping(path="modificaNome")
////	public @ResponseBody Selezionatore aggiornaNome (@RequestBody RegistrazionePojo regPojo) throws SQLException {
////		
////		
////		Selezionatore selezionatore = sd.updateNome(regPojo.getNome(), regPojo.getId());
////		
////		return selezionatore;
////	}
////	
////	@PostMapping(path="modificaCognome")
////	public @ResponseBody Selezionatore aggiornaCognome (@RequestBody RegistrazionePojo regPojo) throws SQLException {
////		
////		
////		Selezionatore selezionatore = sd.updateCognome(regPojo.getCognome(), regPojo.getId());
////		
////		return selezionatore;
////	}
////	
////	@PostMapping(path="modificaStato")
////	public @ResponseBody Selezionatore aggiornaStato (@RequestBody RegistrazionePojo regPojo) throws SQLException {
////		
////		
////		Selezionatore selezionatore = sd.updateStato(regPojo.getStato(), regPojo.getId());
////		
////		return selezionatore;
////	}
//	
//	// ===================================================== Ottieni Link alla ListaPreferiti ===========================================
//	
//	@GetMapping(path="ottieniLinkLista")
//	public String ottieniLinLista (@RequestParam(value="id") int id) {
//		
//		String link= "http://localhost:8080/listaPreferiti";
//		link =link.concat("?id="+id);
//		
//		return link;
//	}
//	
//	
}
