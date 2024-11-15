package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private Etal etal;
	
	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean achatPossible = false;
		int vendeurChoisi;
		boolean verification = controlAcheterProduit.verifierIdentite(nomAcheteur);
		
		if (!verification) {
			System.out.println("Je suis désolé " + nomAcheteur + ", il faut être un habitant du village pour commercer ici.\n");
			
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Quel produit voulez-vous acheter?\n");
			String produit = Clavier.entrerChaine(question.toString());
			
			Gaulois[] vendeurs = controlAcheterProduit.getVendeurs(produit);
			
			// si le marché est vide
			if(vendeurs == null) {
				System.out.println("Le marché est vide, revenez plus tard.\n");
			}
			// si le produit n'existe pas
			else if(vendeurs.length<1) {
				System.out.println("Ce produit n'existe pas au marché, revenez plus tard.\n");
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
				etal = controlAcheterProduit.trouverEtalVendeur(vendeurs[vendeurChoisi-1]);
				// choisir nombre de produit à acheter
				int nbProduitAcheter = Clavier.entrerEntier("Choisir combien de " + produit + "à acheter\n");
				// acheter produit
				controlAcheterProduit.acheterProduit(vendeurs[vendeurChoisi-1].getNom(), nbProduitAcheter);
				
				System.out.println("Produits acheter avec success ! \n");

		} else {
				System.out.println("Pas de produits acheter. \n");
			}
		}
	}
}
