package it.recruiting.sviluppo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ElencoPreferiti {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column ( name = "idprofilo")
	private int idProfilo;
	@Column(name = "idselezionatore")
	private int idSelezionatore;
	
	public ElencoPreferiti () {
		
	}

	public ElencoPreferiti(int idProfilo, int idSelezionatore) {
		super();
		this.idProfilo = idProfilo;
		this.idSelezionatore = idSelezionatore;
	}

	public int getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	public int getIdSelezionatore() {
		return idSelezionatore;
	}

	public void setIdSelezionatore(int idSelezionatore) {
		this.idSelezionatore = idSelezionatore;
	}
	
	
	
}
