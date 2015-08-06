package com.prestibanque.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prestibanque.models.*;

public class ConseillerServiceTest {
	private ConseillerService service;
	private Conseiller conseiller;
	private Client client;
	private CompteCourant cc;
	private CompteEpargne ce;
	
    @Before
    public void setUp() {
		conseiller = new Conseiller();
		service = new ConseillerService(conseiller);
		client = new Client("Golsing", "James", "2 rue du Soleil", "Microsystems", 123456, "01-555-1487");
		cc = new CompteCourant(1, 45_126, new Date());
		ce = new CompteEpargne(2, 1_654, new Date());
		
		client.setCompteCourant(cc);
		client.setCompteEpargne(ce);
		
		conseiller.getClients().add(client);
    }
    
    @After
    public void tearUp() {
    	service = null;
    	conseiller = null;
    	client = null;
    	cc = null;
    	ce = null;
    }

	@Test
	public void testTransfertCourantVersEpargne() {
		assertFalse(service.transfertCourantVersEpargne(client, 46_000));
		assertTrue(service.transfertCourantVersEpargne(client, 45_000));
	}

	@Test
	public void testTransfertEpargneVersCourant() {
		assertFalse(service.transfertEpargneVersCourant(client, 2_000));
		assertTrue(service.transfertEpargneVersCourant(client, 1_000));
	}

	@Test
	public void testSimulationCredit() {
		assertTrue(service.simulationCredit(10000, 50000, 36, 0.5f));
	}

	@Test
	public void testGestionPatrimoine() {
		assertFalse(service.gestionPatrimoine(client));
	}

}
