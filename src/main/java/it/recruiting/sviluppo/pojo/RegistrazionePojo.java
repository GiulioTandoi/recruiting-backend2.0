package it.recruiting.sviluppo.pojo;

public class RegistrazionePojo {

	private int id;
	private String nome;
	private String cognome;
	private String password;
	private String email;
	private String stato;

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

	RegistrazionePojo(String nome, String cognome, String password, String email, String stato) {

		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.stato = stato;
	}

}
