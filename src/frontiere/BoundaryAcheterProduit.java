package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean achatPossible;
		boolean verification = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!verification) {
			System.out.println("Je suis désolé " + nomAcheteur + ", il faut être un habitant du village pour commercer ici.\n");
			
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Quel produit voulez-vous acheter?\n");
			String produit = Clavier.entrerChaine(question.toString());
			
			achatPossible = controlAcheterProduit.controlAcheterProduit(produit);
			
			if(achatPossible) {
				System.out.println("Produits acheter avec success ! \n");
			} else {
				System.out.println("Pas de produits acheter. \n");
			}
		}
	}
}
