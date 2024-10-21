package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu;
		boolean etalDisponible;
		String produit;
		int nbProduit;
		int numEtal;
		
		StringBuilder text = new StringBuilder();
		nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if(!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + "mais il faut être un habitant du village pour commercer ici.\n");
		} else {
			
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			
			etalDisponible = controlPrendreEtal.resteEtals();
			
			if(!etalDisponible) {
				System.out.println("Désolé "+ nomVendeur + " je n'ai plus d'étals qui ne soit pas déjà occupé.");
			} else {
				//installerVendeur(nomVendeur);
				
				text.append("C'est parfait, il me reste un étal pour vous!\n");
				text.append("Il me faudra quelques renseignements :\n");
				text.append("	Quel produit souhaitez-vous vendre?\n");
				produit = Clavier.entrerChaine(text.toString());
				nbProduit = Clavier.entrerEntier("	Combien souhaitez-vous en vendre?\n");
				
				numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if(numEtal != -1) {
					System.out.println("Le vendeur "+ nomVendeur + " s'est installé à l'étal n° "+ numEtal+1);
				}	
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
