package it.recruiting.sviluppo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.recruiting.sviluppo.entities.Selezionatore;

@Repository(value = "it.recruiting.sviluppo.repos.SelezionatoreRepository")
public interface SelezionatoreRepository extends CrudRepository<Selezionatore, Long> {

	// Estendendo la classe CrudRepository posso dichiarare dei metodi in questo
	// modo che attraverso la chiave "find" oppure "order"
	// preimposta il metodo a fare operazioni come la Select oppure l'order By e poi
	// !!IMPORTANTE per ogni entity esiste una repository, non è detto il contrario
	// come in questo caso, non esiste un'entity Home
	public Selezionatore findByEmailAndPassword(String email, String password);

	public Selezionatore findById(int id);

	public Selezionatore findByEmail(String email);

}
