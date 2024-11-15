package testControleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlAfficherVillage;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private Village village;
	private Chef abraracourcix;
	int nbVillageoisMaximum = 10;
	int nbEtal = 5;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...\n");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomsVillageois().length,"Village ne peut pas être vide");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0],"Abraracourcix");
		
		Gaulois gaulois = new Gaulois("Obelix",10);
		village.ajouterHabitant(gaulois);
		controlAfficherVillage = new ControlAfficherVillage(village);

		assertEquals(controlAfficherVillage.donnerNomsVillageois()[1],"Obelix");
		assertNotEquals(controlAfficherVillage.donnerNomsVillageois()[1],"n'existe pas");
		



		
	}
	
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage.donnerNomVillage(),"Village doit avoir un nom");
		assertEquals("le village des irréductibles",controlAfficherVillage.donnerNomVillage());
		assertNotEquals("",controlAfficherVillage.donnerNomVillage());
		
	}
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(),nbEtal);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(),-1);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(),0);

		village = new Village("le village des irréductibles", 10, 0);
		controlAfficherVillage = new ControlAfficherVillage(village);
		
		assertEquals(controlAfficherVillage.donnerNbEtals(),0);

		



	}
}
