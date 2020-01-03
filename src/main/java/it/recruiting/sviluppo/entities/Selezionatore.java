package it.recruiting.sviluppo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// E' importante che ci sia un'Entity per ogni tabella del DB così che i metodi di query JPA siano più accurati e possano funzionare collegando
// direttamente il nome del Generics impolementato dalla CrudRepository con il nome della tabella sul DB 
@Entity
@Table(name = "Selezionatore")
public class Selezionatore { 

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "stato")
	private String stato;
	
	public Selezionatore () {
		
	}
	
	public Selezionatore(String nome, String cognome, String email, String stato, String password) {
		
		this.nome= nome;
		this.cognome= cognome;
		this.email= email;
		this.stato = stato;
		this.password= password;
		
	}
	
	public String getStato() {
		return stato;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "Selezionatore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", password=" + password
				+ ", email=" + email + ", stato=" + stato + "]";
	}
	
}
