package it.recruiting.sviluppo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.recruiting.sviluppo.entities.Selezionatore;
import it.recruiting.sviluppo.repos.SelezionatoreRepository;

//Questa è la classe in cui ho i metodi che sfruttano i metodi definiti dalla repository, e questi metodi saranno utilizzati nel controller 
// durante le chiamate
@Service
public class SelezionatoreService {
	
	@Autowired
	SelezionatoreRepository selezionatoreRepo;
	
	public int login ( String mail, String password ) {
		 
		Selezionatore selezionatore = selezionatoreRepo.findByEmailAndPassword(mail,password);
		
		return selezionatore.getId();
	}
	
	
	public boolean registration(Selezionatore selezionatore) {
		
		int idVerifica = selezionatoreRepo.save(selezionatore).getId();
		if (idVerifica>1) {
			return true;
		}
		return false;
	}
	
//	public boolean checkIfRegistered (String email) {
//		
//		Selezionatore selezionatore = selezionatoreRepo.findByMail(email);
//		if (selezionatore!=null) {
//			return false;
//		}
//		return true;
//		
//	}
	

}
