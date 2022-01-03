package tests;

import grafix.interfaceGraphique.IG;
import composants.Objet;

public class TestObjet {
	public static void main(String[] args) {
		// Une petite démonstration conernant l'interface graphique
		
		// Saisie des différents paramètres
		Object parametres[];
		parametres=IG.saisirParametres(); // On ouvre la fenêtre de paramétrage pour la saisie
		
		// Création de la fenêtre de jeu et affichage de la fenêtre 
		int nbJoueurs=((Integer)parametres[0]).intValue(); // Récupération du nombre de joueurs
		IG.creerFenetreJeu("Le labyrinthe",nbJoueurs); // On crée la fenêtre
		IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu
		
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
