package com.prestibanque.services;

import com.prestibanque.models.*;

public class ConseillerService {
	private Conseiller conseiller;

	public ConseillerService(Conseiller conseiller) {
		super();
		this.conseiller = conseiller;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public boolean transfertCourantVersEpargne(Client client, float montant) {
		return transfertDeFond(client.getCompteCourant(), client.getCompteEpargne(), montant);
	}

	public boolean transfertEpargneVersCourant(Client client, float montant) {
		return transfertDeFond(client.getCompteEpargne(), client.getCompteCourant(), montant);
	}

	private boolean transfertDeFond(Compte source, Compte destination, float montant) {
		if (source == null || destination == null || source.getSolde() < montant) {
			return false;
		}

		source.setSolde(source.getSolde() - montant);
		destination.setSolde(destination.getSolde() + montant);

		return true;
	}

	public boolean simulationCredit(float salaire, float montant, int duree, float taux) {
		return (montant * taux / 100f / duree) < salaire;
	}

	public boolean gestionPatrimoine(Client client) {
		float argentTotal = 0f;
		if (client.getCompteCourant() != null) {
			argentTotal += client.getCompteCourant().getSolde();
		}
		if (client.getCompteEpargne() != null) {
			argentTotal += client.getCompteEpargne().getSolde();
		}
		return argentTotal > 500000f;
	}
}
