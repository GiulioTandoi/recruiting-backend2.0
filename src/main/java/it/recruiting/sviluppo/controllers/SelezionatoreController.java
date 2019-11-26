package it.recruiting.sviluppo.controllers;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import DAO.PreferitiDAO;
import DAO.SelezionatoreDAO;
import model.Profilo;
import model.Selezionatore;
import pojo.AggiuntaPreferitoPojo;
import pojo.RegistrazionePojo;

@RestController
@CrossOrigin(origins= "http://localhost:3000", maxAge = 3600, allowedHeaders = "*")
public class SelezionatoreController {
	
	SelezionatoreDAO sd = new SelezionatoreDAO (conn );
	PreferitiDAO pDAO = new PreferitiDAO(conn);
	@GetMapping(path="dettagliSelezionatore")
	public Selezionatore visualizzaDettagli (@RequestParam(value="id") int id ) throws SQLException{
		
		
		Selezionatore selezionatore= sd.profiloSelezionatore(id);
		
		return selezionatore;
	}
	
	//==================================================== Preferiti ===================================================================
	
	@PostMapping(path="inserisciPreferito")
	public String inserisciPreferito(@RequestBody AggiuntaPreferitoPojo pPojo) throws SQLException{
		
		System.out.println(pPojo.getIdSelezionatore() + " "+ pPojo.getIdProfilo());
		pDAO.insertListaPreferiti(pPojo.getIdSelezionatore(), pPojo.getIdProfilo());
		
		return new String ("Aggiunta effettuata!");
		
	}
	
	@GetMapping(path="listaPreferiti")
	public Response mostraListaPreferiti (@RequestParam(value="id_selezionatore") int id ) throws SQLException{
		
		
		ArrayList<Profilo> listaPreferiti= pDAO.mostraPreferiti(id);
		
		if(listaPreferiti.isEmpty()) {
			return null;
		}
		
		Response response= new Response(listaPreferiti.size(), listaPreferiti);
		
		return response;
		
	}
	
	@GetMapping(path="linkPreferito")
	public String ottieniLink(@RequestParam(value="id") int id) throws SQLException {
		
		String link=null;
		link= pDAO.ottieniLink(id);
		return link;
		
	}
	
	@GetMapping(path="profilo")
	public Profilo ottieniDettaglioPreferito(@RequestParam(value="id") int id) throws SQLException{
		
		Profilo p= pDAO.dettaglioPreferito(id);
		return p;
	}
	//===================================================== Home ========================================================================
	
	@GetMapping(path="home")
	public Response home() throws SQLException{
		
		ArrayList<Profilo> listaProfiliHome = new ArrayList<Profilo>();
		listaProfiliHome= sd.home();
		
		Response response = new Response(listaProfiliHome.size(), listaProfiliHome);
		
		return response;
		
		
		
	}
	
	// ===================================================== Modifica dati profilo ======================================================
	
	@PostMapping(path="modificaDettagli")
	public @ResponseBody Selezionatore aggiornaProfilo (@RequestBody RegistrazionePojo selezionatore) throws SQLException{
		Selezionatore s = sd.updateSelezionatore(selezionatore);
		return s;
	}
	
//	@PostMapping(path="modificaEmail")
//	public @ResponseBody Selezionatore aggiornaEmail (@RequestBody RegistrazionePojo regPojo) throws SQLException {
//		
//		
//		Selezionatore selezionatore = sd.updateEmail(regPojo.getEmail(), regPojo.getId());
//		
//		return selezionatore;
//	}
//	
//	@PostMapping(path="modificaNome")
//	public @ResponseBody Selezionatore aggiornaNome (@RequestBody RegistrazionePojo regPojo) throws SQLException {
//		
//		
//		Selezionatore selezionatore = sd.updateNome(regPojo.getNome(), regPojo.getId());
//		
//		return selezionatore;
//	}
//	
//	@PostMapping(path="modificaCognome")
//	public @ResponseBody Selezionatore aggiornaCognome (@RequestBody RegistrazionePojo regPojo) throws SQLException {
//		
//		
//		Selezionatore selezionatore = sd.updateCognome(regPojo.getCognome(), regPojo.getId());
//		
//		return selezionatore;
//	}
//	
//	@PostMapping(path="modificaStato")
//	public @ResponseBody Selezionatore aggiornaStato (@RequestBody RegistrazionePojo regPojo) throws SQLException {
//		
//		
//		Selezionatore selezionatore = sd.updateStato(regPojo.getStato(), regPojo.getId());
//		
//		return selezionatore;
//	}
	
	// ===================================================== Ottieni Link alla ListaPreferiti ===========================================
	
	@GetMapping(path="ottieniLinkLista")
	public String ottieniLinLista (@RequestParam(value="id") int id) {
		
		String link= "http://localhost:8080/listaPreferiti";
		link =link.concat("?id="+id);
		
		return link;
	}
	
	
}
