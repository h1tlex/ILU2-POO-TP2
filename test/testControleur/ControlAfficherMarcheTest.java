package testControleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlAfficherMarche;
import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
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
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche,"Constructeur vide");
	}
	
	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		
		assertNotNull(controlAfficherMarche.donnerInfosMarche());
		
		village.installerVendeur(abraracourcix, "fleurs", nbEtal);
		controlAfficherMarche = new ControlAfficherMarche(village);
		
		assertEquals(controlAfficherMarche.donnerInfosMarche().length,3);
			
	}


}
