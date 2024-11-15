package testControleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlLibererEtal;
import controleur.ControlTrouverEtalVendeur;
import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
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
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"Constructeur vide");
	}
	
	@Test
	void testLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		
		assertNull(controlLibererEtal.libererEtal("n'existe pas"));
		
		village.installerVendeur(abraracourcix, "fleurs", nbEtal);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		
		assertNotNull(controlLibererEtal.libererEtal("Abraracourcix"));
	}
	
	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		
		assertFalse(controlLibererEtal.isVendeur("n'existe pas"));
		
		village.installerVendeur(abraracourcix, "fleurs", nbEtal);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		
		assertTrue(controlLibererEtal.isVendeur("Abraracourcix"));
	}

}
