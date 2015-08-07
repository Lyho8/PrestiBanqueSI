package com.prestibanque.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prestibanque.models.Agence;
import com.prestibanque.models.Client;
import com.prestibanque.models.CompteCourant;
import com.prestibanque.models.CompteEpargne;
import com.prestibanque.models.Conseiller;
import com.prestibanque.models.Gerant;

public class AgenceServiceTest {
	private AgenceService service;
	private Agence agence;
	private Conseiller conseiller;
	private Client client;
	private CompteCourant cc;
	private CompteEpargne ce;

	@Before
	public void setUp() throws Exception {
		agence = new Agence("SH123", new Date());
		service = new AgenceService(agence);
		
		Gerant gerant = new Gerant();
		agence.setGerant(gerant);
		
		conseiller = new Conseiller();
		gerant.addConseiller(conseiller);
		
		client = new Client("Golsing", "James", "2 rue du Soleil", "Microsystems", 123456, "01-555-1487");
		cc = new CompteCourant(1, 45_126, new Date());
		ce = new CompteEpargne(2, 1_654, new Date());
		
		client.setCompteCourant(cc);
		client.setCompteEpargne(ce);
		
		conseiller.addClient(client);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
		agence = null;
		conseiller = null;
		client = null;
		cc = null;
		ce = null;
	}

	@Test
	public void testGetAgence() {
		assertTrue(service.getAgence() == agence);
	}

	@Test
	public void testAudit() {
		assertTrue(service.audit());
		cc.setSolde(-6_000);
		assertFalse(service.audit());
	}

}
