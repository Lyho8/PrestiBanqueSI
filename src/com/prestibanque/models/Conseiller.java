package com.prestibanque.models;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class Conseiller extends Personne {
	private ArrayList<Client> clients = new ArrayList<>();
	private WeakReference<Gerant> gerantRef;

	public Conseiller() {
		super("nom", "prenom");
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
		for(Client c : clients) {
			c.setConseiller(this);
		}
	}

	public Gerant getGerant() {
		return gerantRef.get();
	}

	public void setGerant(Gerant gerant) {
		this.gerantRef = new WeakReference<Gerant>(gerant);
	}

	public void addClient(Client client) {
		getClients().add(client);
		client.setConseiller(this);
	}
}
