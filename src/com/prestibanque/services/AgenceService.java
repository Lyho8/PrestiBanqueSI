package com.prestibanque.services;

import com.prestibanque.models.*;

public class AgenceService {
	private Agence agence;

	public AgenceService(Agence agence) {
		super();
		this.agence = agence;
	}

	public Agence getAgence() {
		return agence;
	};
	
	public boolean audit() {
		for(Conseiller conseiller : agence.getGerant().getConseillers()) {
			for(Client client : conseiller.getClients()) {
				float decouvertMaximum = (client.isEntreprise() ? -50000f : -5000f);
				
				if(client.getCompteCourant() != null && client.getCompteCourant().getSolde() < decouvertMaximum) {
					return false;
				}
				if(client.getCompteEpargne() != null && client.getCompteEpargne().getSolde() < decouvertMaximum) {
					return false;
				}
			}
		}
		return true;
	}
}
