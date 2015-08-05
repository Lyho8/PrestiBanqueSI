package com.prestibanque.models;

import java.util.Date;

public class CompteEpargne extends Compte {
	private float remuneration = 3.0f;

	public CompteEpargne(int numero) {
		super(numero);
	}

	public CompteEpargne(int numero, float solde, Date ouverture) {
		super(numero, solde, ouverture);
	}

	public float getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(float remuneration) {
		this.remuneration = remuneration;
	}
}
