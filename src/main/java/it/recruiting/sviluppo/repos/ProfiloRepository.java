package it.recruiting.sviluppo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.recruiting.sviluppo.entities.Profilo;

@Repository(value = "it.recruiting.sviluppo.repos.ProfiloRepository")
public interface ProfiloRepository extends CrudRepository<Profilo, Long> {

	// Ritorna la lista di profili passandogli tutti gli id dei profili preferiti
	// che devo tirare fuori
	// Spring data JPA usa l'In finale per oerazioni di questo genere
	public ArrayList<Profilo> findByIdIn(ArrayList<Integer> idProfilo);

	public Profilo findById(int id);
}
