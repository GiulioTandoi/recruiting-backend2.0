package it.recruiting.sviluppo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.recruiting.sviluppo.entities.ElencoPreferiti;

@Repository(value = "it.recruiting.sviluppo.repos.PreferitiRepository")
public interface PreferitiRepository extends CrudRepository<ElencoPreferiti, Long> {

	public ArrayList<ElencoPreferiti> findByIdSelezionatore(int idselezionatore);

}
