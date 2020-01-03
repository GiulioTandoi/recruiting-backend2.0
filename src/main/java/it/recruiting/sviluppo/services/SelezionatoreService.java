package it.recruiting.sviluppo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.recruiting.sviluppo.entities.ElencoPreferiti;
import it.recruiting.sviluppo.entities.Profilo;
import it.recruiting.sviluppo.entities.Selezionatore;
import it.recruiting.sviluppo.repos.PreferitiRepository;
import it.recruiting.sviluppo.repos.ProfiloRepository;
import it.recruiting.sviluppo.repos.SelezionatoreRepository;

//Questa è la classe in cui ho i metodi che sfruttano i metodi definiti dalla repository, e questi metodi saranno utilizzati nel controller 
// durante le chiamate
@Service
public class SelezionatoreService {
	
	@Autowired
	SelezionatoreRepository selezionatoreRepo;
	
	@Autowired
	PreferitiRepository preferitiRepo;
	
	@Autowired
	ProfiloRepository profiloRepo;
	
	public int login ( String email, String password ) {
		System.out.println("Email and password: "+email + " "+ password );
		Selezionatore selezionatore = selezionatoreRepo.findByEmailAndPassword(email,password);
		System.out.println(selezionatore);
		return selezionatore.getId();
	}
	
	
	public boolean registration(Selezionatore selezionatore) {
		
		int idVerifica = selezionatoreRepo.save(selezionatore).getId();
		if (idVerifica>1) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfRegistered (String email) {
		
		Selezionatore selezionatore = selezionatoreRepo.findByEmail(email);
		if (selezionatore!=null) {
			return false;
		}
		return true;
		
	}
	
	public ArrayList<Profilo> getFavourites (int idSelezionatore){
		
		ArrayList <Integer> idProfiliPreferiti = new ArrayList<Integer>();
		
		ArrayList<ElencoPreferiti> idFavourites = preferitiRepo.findByIdSelezionatore(idSelezionatore);
		System.out.println("IdFavourites: "+ idFavourites);
		for (ElencoPreferiti preferito : idFavourites) {
			idProfiliPreferiti.add(preferito.getIdProfilo());
		}
		System.out.println("IdProfiliPreferiti: "+idProfiliPreferiti);
		ArrayList<Profilo> favourites = profiloRepo.findByIdIn(idProfiliPreferiti);
		System.out.println("Favourites: "+favourites);
		return favourites;
		
	}
	

}
