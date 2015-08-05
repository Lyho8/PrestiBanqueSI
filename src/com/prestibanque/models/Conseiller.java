package com.prestibanque.models;

import java.util.ArrayList;

public class Conseiller extends Personne {
	private ArrayList<Client> clients = new ArrayList<>();

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
}
