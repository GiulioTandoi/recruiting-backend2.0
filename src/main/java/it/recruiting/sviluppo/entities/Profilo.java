package it.recruiting.sviluppo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Profilo")
public class Profilo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "eta")
	private int eta;
	@Column(name = "qualifica")
	private String qualifica;
	@Column(name = "disponibilita")
	private String disponibilita;
	@Column(name = "link")
	private String link;
	@Column(name= "image")
	private String image;
	
	public Profilo () {
		
	}
	
	public Profilo(int id, String nome, String cognome, int eta, String qualifica, String disponibilita ,String link, String imagePath) {
		
		this.nome= nome;
		this.cognome= cognome;
		this.eta= eta;
		this.qualifica= qualifica;
		this.disponibilita= disponibilita;
		this.link = link;
		this.id=id;
		this.image = imagePath;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public int getEta() {
		return eta;
	}
	
	public String getQualifica() {
		return qualifica;
	}
	
	public String getDisponibilita() {
		return disponibilita;
	}

	public String getLink() {
		return link;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String imagePath) {
		this.image = imagePath;
	}
	
	
	@Override
	public String toString() {
		return "Profilo [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", qualifica="
				+ qualifica + ", disponibilita=" + disponibilita + ", link=" + link + "]";
	}

}
