package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private Etal etal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

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

	public boolean controlAcheterProduit(String produit) {
		int vendeurChoisi;
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		boolean achatPossible = false;
		// si le marché est vide
		if(vendeurs== null) {
			System.out.println("Le marché est vide, revenez plus tard.\n");
		}
		// si le produit n'existe pas
		else if(vendeurs.length<1) {
			System.out.println("Ce produit n'existe pas au marché, revenez plus tard.\n");
			return achatPossible;
			
		} else { // liste des vendeurs qui vend le produit
			achatPossible = true;
			System.out.println("Vendeurs qui proposent le produit " + produit + ".\n");
			for(int i = 1; i <= vendeurs.length ; i++) {
				System.out.println(i +" - " + vendeurs[i-1] + "\n");
			}
		}
		// choisir vendeur
		if(achatPossible) {
			
			do {
				vendeurChoisi = Clavier.entrerEntier("Choisir un vendeur de la liste :\n");
			}while(vendeurChoisi > vendeurs.length || vendeurChoisi < 1); // boucle erreur input
			
			// trouver etal vendeur
			etal = village.rechercherEtal(vendeurs[vendeurChoisi-1]);
			
			// choisir nombre de produit à acheter
			int nbProduitAcheter = Clavier.entrerEntier("Choisir combien de " + produit + "à acheter\n");
			// acheter produit
			nbProduitAcheter = etal.acheterProduit(nbProduitAcheter);
		}
		
		return achatPossible;
	}
}
