package com.prestibanque.launcher;

import java.util.Date;

import com.prestibanque.models.*;
import com.prestibanque.services.AgenceService;
import com.prestibanque.services.ConseillerService;

public class Launcher {

	public static void main(String[] args) {
		Agence a = new Agence("12345", new Date());
		
		Gerant g = new Gerant();
		a.setGerant(g);
		
		Conseiller c = new Conseiller();
		g.getConseillers().add(c);
		
		Client client = new Client("Durand", "Jean", "2 rue des billes", "Paris", 75099, "+33.1.78.15.99.01.11");
		client.setCompteCourant(new CompteCourant(1, -5001, new Date()));
		client.setCompteEpargne(new CompteEpargne(1, 500, new Date()));
		c.getClients().add(client);
		
		AgenceService aServ = new AgenceService(a);
		System.out.println("Audit de l'agence ? " + aServ.audit());
		
		ConseillerService cServ = new ConseillerService(c);
		cServ.transfertEpargneVersCourant(client, 10);
		System.out.println("Audit de l'agence ? " + aServ.audit());
	}

}
