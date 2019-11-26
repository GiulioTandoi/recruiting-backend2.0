package it.recruiting.sviluppo.repos;

import org.springframework.data.repository.CrudRepository;

import it.recruiting.sviluppo.entities.Selezionatore;

public interface SelezionatoreRepository extends CrudRepository<Selezionatore, Long> {

	// Estendendo la classe CrudRepository posso dichiarare dei metodi in questo modo che attraverso la chiave "find" oppure "order"
	// preimposta il metodo a fare operazioni come la Select oppure l'order By e poi 
	public Selezionatore findByMailAndPassword(String mail, String password);
	
}
