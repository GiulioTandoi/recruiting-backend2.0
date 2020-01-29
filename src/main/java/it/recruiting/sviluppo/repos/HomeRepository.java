package it.recruiting.sviluppo.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.recruiting.sviluppo.entities.Profilo;

@Repository(value = "it.recruiting.sviluppo.repos.HomeRepository")
public interface HomeRepository extends CrudRepository<Profilo, Long>{
	
	public ArrayList<Profilo> findAll();
	public ArrayList<Profilo> findByNome(String nome);
	// Nella seguente query i paramentri ti ricerca sono quelli che passo come argomento e sono nominati con l'annotazione @Param in modo che nella query abbiano lo stesso nome 
	@Query ("SELECT P FROM Profilo as P WHERE P.nome LIKE %:value% OR P.cognome LIKE %:value% OR P.qualifica LIKE %:value%")
	public ArrayList<Profilo> findByNomeOrCognomeOrQualificaIsContaining(@Param("value") String value);
	
}
