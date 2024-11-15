package testControleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlAcheterProduit;
import controleur.ControlTrouverEtalVendeur;
import controleur.ControlVerifierIdentite;
import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
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
	void testControlAcheterProduit() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertNotNull(controlAcheterProduit,"constructeur vide");
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		
		assertFalse(controlAcheterProduit.verifierIdentite("n'existe pas"));
		assertTrue(controlAcheterProduit.verifierIdentite("Abraracourcix"));
	}
	
	@Test
	void testGetVendeurs() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		
		assertNull(controlAcheterProduit.getVendeurs(null));
		assertNull(controlAcheterProduit.getVendeurs("None"));
		
		village.installerVendeur(abraracourcix, "Fleurs", nbEtal);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);	
		
		assertNotNull(controlAcheterProduit.getVendeurs("Fleurs"));
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		
		assertNull(controlAcheterProduit.trouverEtalVendeur(null));
		assertNull(controlAcheterProduit.trouverEtalVendeur(abraracourcix));
		
		village.installerVendeur(abraracourcix, "Fleurs", nbEtal);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		
		assertNotNull(controlAcheterProduit.trouverEtalVendeur(abraracourcix));

	}
	
	@Test
	void testAcheterProduit() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		
		assertEquals(controlAcheterProduit.acheterProduit("Abraracourcix", 0),0);
		assertNotEquals(controlAcheterProduit.acheterProduit("Abraracourcix", 1),1);
		
		village.installerVendeur(abraracourcix, "Fleurs", nbEtal);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);

		assertEquals(controlAcheterProduit.acheterProduit("Abraracourcix", 4),4);
		assertEquals(controlAcheterProduit.acheterProduit("Abraracourcix", 1),1);
		assertEquals(controlAcheterProduit.acheterProduit("Abraracourcix", 1),0);
	}

}
