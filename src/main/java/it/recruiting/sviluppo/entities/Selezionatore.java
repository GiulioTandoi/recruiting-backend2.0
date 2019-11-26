package it.recruiting.sviluppo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Selezionatore")
public class Selezionatore { 

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
	
	public Selezionatore(String nome, String cognome, String email, String stato) {
		
		this.nome= nome;
		this.cognome= cognome;
		this.email= email;
		this.stato = stato;
		
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
