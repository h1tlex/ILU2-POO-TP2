package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Etal etal;
	private Gaulois gaulois;


	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		boolean nomAcheteurConnu = controlVerifierIdentite.verifierIdentite(nomVendeur);
		if(!nomAcheteurConnu) {
			return false;
		}
		return true;
	}
	
	public Gaulois[] getVendeurs(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public Etal trouverEtalVendeur(Gaulois gaulois) {
		return village.rechercherEtal(gaulois);
	}
	
	public int acheterProduit(String nomVendeur,int nbProduit) {
		boolean vendeurValide = verifierIdentite(nomVendeur);	
		gaulois = village.trouverHabitant(nomVendeur);
		etal = trouverEtalVendeur(gaulois);
		if(vendeurValide) {
			if(etal != null) {
			return etal.acheterProduit(nbProduit);
			}
		}
		return 0;
	}
	
	
}
