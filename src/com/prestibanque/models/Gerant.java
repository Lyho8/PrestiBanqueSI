package com.prestibanque.models;

import java.util.ArrayList;

public class Gerant extends Personne {
	private ArrayList<Conseiller> conseillers = new ArrayList<>();

	public ArrayList<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(ArrayList<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
}
