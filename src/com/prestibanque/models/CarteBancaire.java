package com.prestibanque.models;

import java.lang.ref.WeakReference;

public abstract class CarteBancaire {
	public WeakReference<Client> clientRef;

	public Client getClient() {
		return clientRef.get();
	}

	public void setClient(Client client) {
		this.clientRef = new WeakReference<Client>(client);
	}
}
