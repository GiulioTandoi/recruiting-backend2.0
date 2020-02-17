package it.recruiting.sviluppo.pojo;

public class AggiuntaPreferitoPojo {

	private int idSelezionatore;
	private int idProfilo;

	public int getIdSelezionatore() {
		return idSelezionatore;
	}

	public int getIdProfilo() {
		return idProfilo;
	}

	public AggiuntaPreferitoPojo(int idSelezionatore, int idProfilo) {

		this.idProfilo = idProfilo;
		this.idSelezionatore = idSelezionatore;
	}

}
