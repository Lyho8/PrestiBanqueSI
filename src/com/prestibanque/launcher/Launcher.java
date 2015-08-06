package com.prestibanque.launcher;

import java.util.Date;

import com.prestibanque.models.*;
import com.prestibanque.services.AgenceService;
import com.prestibanque.services.ConseillerService;

public class Launcher {

	public static void main(String[] args) {
		// création de l'agence, de son gérant et d'un conseiller
		Agence a = new Agence("12345", new Date());
		
		Gerant g = new Gerant();
		a.setGerant(g);
		
		Conseiller c = new Conseiller();
		g.getConseillers().add(c);
		
		// création d'un client qui a -5001€ sur un de ses comptes et 500€ sur l'autre
		Client client = new Client("Durand", "Jean", "2 rue des billes", "Paris", 75099, "+33.1.78.15.99.01.11");
		client.setCompteCourant(new CompteCourant(1, -5001, new Date()));
		client.setCompteEpargne(new CompteEpargne(1, 500, new Date()));
		c.getClients().add(client);
		
		// audit de l'agence qui renvoie "false" car le client a un compte à découvert de plus de 5 000€
		AgenceService aServ = new AgenceService(a);
		System.out.println("Audit de l'agence ? " + aServ.audit());
		
		// transfert d'argent pour avoir un bon prochain audit
		ConseillerService cServ = new ConseillerService(c);
		cServ.transfertEpargneVersCourant(client, 10);
		
		// cette fois, l'audit de l'agence renvoie "true" car le découvert du client n'est plus que de 4 991€ (< 5 000€)
		System.out.println("Audit de l'agence ? " + aServ.audit());
		
		// un conseiller ne peut pas faire un transfert d'argent pour un client qu'il ne conseille pas
		Client clientExterne = new Client("Gosling", "James", "2, rue du Soleil", "Île de Java", 12345, "+49.555-4874");
		boolean transfertReussi = cServ.transfertEpargneVersCourant(clientExterne, 10);
		System.out.println("Le transfert " + (transfertReussi ? "a" : "n'a pas") + " réussi");
	}

}
