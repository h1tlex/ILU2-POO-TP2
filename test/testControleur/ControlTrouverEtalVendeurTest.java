package testControleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlTrouverEtalVendeur;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois gaulois;
	private Etal etal;	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation testControlTrouverEtalVendeur...\n");
		village = new Village("le village des irréductibles", 10, 5);
		
		etal = new Etal();
		gaulois = new Gaulois("Babayega",5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		village.ajouterHabitant(gaulois);
		etal.occuperEtal(gaulois, "fleurs", 10);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("None"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Abraracourcix"));		
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Babayega"));
	}

}
