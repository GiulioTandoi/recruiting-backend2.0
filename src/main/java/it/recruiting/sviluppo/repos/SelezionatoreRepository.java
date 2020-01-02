package it.recruiting.sviluppo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.recruiting.sviluppo.entities.Selezionatore;

@Repository(value = "it.recruiting.sviluppo.repos.SelezionatoreRepository")
public interface SelezionatoreRepository extends CrudRepository<Selezionatore, Long> {

	// Estendendo la classe CrudRepository posso dichiarare dei metodi in questo modo che attraverso la chiave "find" oppure "order"
	// preimposta il metodo a fare operazioni come la Select oppure l'order By e poi 
	public Selezionatore findByEmailAndPassword(String email, String password);
	public boolean findById(int id);
	public Selezionatore findByEmail ( String email);
}
