package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu;
		String[] donneesEtal;
		vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		
		if(!vendeurReconnu) {
				System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!\n");
		} else {
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			boolean etalOccupe = Boolean.valueOf(donneesEtal[0]);
			int quantiteVendu = Integer.valueOf(donneesEtal[4]);
			int quantiteInitial = Integer.valueOf(donneesEtal[3]);
			String produit = donneesEtal[2];
			
			if(etalOccupe) {
				System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + " " + produit +".\n" );
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée!\n");
			}
		}
	}

}
