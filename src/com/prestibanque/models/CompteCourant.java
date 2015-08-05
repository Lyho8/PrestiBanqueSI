package com.prestibanque.models;

import java.util.Date;

public class CompteCourant extends Compte {
	
	private float decouvertAutorise = 1000.0f;
	
	public CompteCourant(int numero) {
		super(numero);
	}

	public CompteCourant(int numero, float solde, Date ouverture) {
		super(numero, solde, ouverture);
	}

	public float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

}
