package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		
		if(infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.\n");
		} else {
			System.out.println(nomAcheteur + ", vous trouvez au marché: \n");
			for(int i = 0; i< infosMarche.length-2; i+=3) {
				System.out.println("- vendeur :" + infosMarche[i] + " qui vend " + infosMarche[i+1] + " " + infosMarche[i+2] );
				
			}
		}
	}
}
