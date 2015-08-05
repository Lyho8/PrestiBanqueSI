package com.prestibanque.models;

import java.util.Date;

public class Agence {
	private String identification;
	private Date creation;
	private Gerant gerant;

	public Agence(String identification, Date creation) {
		super();
		this.identification = identification;
		this.creation = creation;
	}

	public Date getCreation() {
		return creation;
	}

	public String getIdentification() {
		return identification;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
}
