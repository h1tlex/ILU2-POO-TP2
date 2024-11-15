package testControleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private Village village;
	private Chef abraracourcix;
	private Etal etal;
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
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal, "Constructeur ne doit pas être null");
	}
	
	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);	
		
		assertTrue(controlPrendreEtal.resteEtals());
		
		village = new Village("le village des irréductibles", 10, 0);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);	
		
		assertFalse(controlPrendreEtal.resteEtals());
		
		village = new Village("le village des irréductibles", 10, 1);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);	
		village.installerVendeur(abraracourcix, "fleurs", 1);
		
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);	
		Gaulois gaulois = new Gaulois("Obelix", 10);
		village.ajouterHabitant(gaulois);
		
		System.out.println(controlPrendreEtal.prendreEtal("n'existe pas", "rien", 0));
		System.out.println(controlPrendreEtal.prendreEtal("Abraracourcix", "potion", 10));
		System.out.println(controlPrendreEtal.prendreEtal("Obelix", "fleurs", 10));
		
		assertFalse(controlPrendreEtal.prendreEtal("n'existe pas", "rien", 0) == 1);
		assertTrue(controlPrendreEtal.prendreEtal("n'existe pas", "rien", 0) == -1);
		assertNotEquals(controlPrendreEtal.prendreEtal("Abraracourcix", "potion", 10),-1);
		assertNotEquals(controlPrendreEtal.prendreEtal("Obelix", "fleurs", 10),-1);

	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);	
		assertFalse(controlPrendreEtal.verifierIdentite("n'existe pas"));
		assertTrue(controlPrendreEtal.verifierIdentite("Abraracourcix"));

	}

}
