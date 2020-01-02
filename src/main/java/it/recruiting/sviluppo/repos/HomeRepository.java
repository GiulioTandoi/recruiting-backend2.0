package it.recruiting.sviluppo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.recruiting.sviluppo.entities.Profilo;

@Repository
public interface HomeRepository extends CrudRepository<Profilo, Long>{
	
	public ArrayList<Profilo> findAll();
	
}
