package tests;

import grafix.interfaceGraphique.IG;
import composants.Objet;

public class TestObjet {
	public static void main(String[] args) {
		// Une petite d�monstration conernant l'interface graphique
		
		// Saisie des diff�rents param�tres
		Object parametres[];
		parametres=IG.saisirParametres(); // On ouvre la fen�tre de param�trage pour la saisie
		
		// Cr�ation de la fen�tre de jeu et affichage de la fen�tre 
		int nbJoueurs=((Integer)parametres[0]).intValue(); // R�cup�ration du nombre de joueurs
		IG.creerFenetreJeu("Le labyrinthe",nbJoueurs); // On cr�e la fen�tre
		IG.rendreVisibleFenetreJeu();  // On rend visible la fen�tre de jeu
		
		// Place des objets sur le plateau
		Objet objet[] = Objet.nouveauxObjets();
		for(int i=0; i<objet.length; i++) {
			IG.placerObjetPlateau(i,objet[i].getPosLignePlateau(),objet[i].getPosColonnePlateau());
		}
		
		// Affiche le message
        String message[]={
                		    "",
                            "Cliquer pour quitter ...",
                        	};
        IG.afficherMessage(message); 
        IG.miseAJourAffichage();
        IG.attendreClic();
        
		// Fermer le jeu
 		IG.fermerFenetreJeu();
        System.exit(0);
	}
}
