package it.recruiting.sviluppo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.recruiting.sviluppo.repos.SelezionatoreRepository;

//Questa è la classe in cui ho i metodi che sfruttano i metodi definiti dalla repository, e questi metodi saranno utilizzati nel controller 
// durante le chiamate
@Service
public class SelezionatoreService {
	
	@Autowired
	SelezionatoreRepository selezonatoreRepo ;
	

	

}
