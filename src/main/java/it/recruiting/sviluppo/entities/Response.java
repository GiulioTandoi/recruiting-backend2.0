package it.recruiting.sviluppo.entities;

import java.util.ArrayList;

public class Response {

	private int count;
	private ArrayList<Profilo> profili;

	public int getCount() {
		return count;
	}

	public ArrayList<Profilo> getProfili() {
		return profili;
	}

	public Response(int count, ArrayList<Profilo> profili) {
		this.profili = profili;
		this.count = count;
	}

}
