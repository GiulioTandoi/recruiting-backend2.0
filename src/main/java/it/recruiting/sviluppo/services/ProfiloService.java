package it.recruiting.sviluppo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.recruiting.sviluppo.entities.ElencoPreferiti;
import it.recruiting.sviluppo.entities.Profilo;
import it.recruiting.sviluppo.pojo.AggiuntaPreferitoPojo;
import it.recruiting.sviluppo.repos.PreferitiRepository;
import it.recruiting.sviluppo.repos.ProfiloRepository;

@Service
public class ProfiloService {

	@Autowired
	ProfiloRepository profiloRepo;

	@Autowired
	PreferitiRepository preferitiRepo;

	public boolean insertInListaPreferiti(AggiuntaPreferitoPojo pojo) {
		ElencoPreferiti elencoPreferiti = new ElencoPreferiti();
		elencoPreferiti.setIdProfilo(pojo.getIdProfilo());
		elencoPreferiti.setIdSelezionatore(pojo.getIdSelezionatore());
		preferitiRepo.save(elencoPreferiti);
		return true;
	}

	public Profilo showStandardProfileDetails(int id) {

		Profilo profilo = profiloRepo.findById(id);
		return profilo;

	}

}
