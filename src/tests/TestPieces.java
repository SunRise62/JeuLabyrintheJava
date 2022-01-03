package tests;

import grafix.interfaceGraphique.IG;
import composants.Piece;
import composants.Utils;

public class TestPieces {
	public static void main(String[] args) {
		// Une petite démonstration conernant l'interface graphique
		
		// Saisie des différents paramètres
		Object parametres[];
		parametres=IG.saisirParametres(); // On ouvre la fenêtre de paramétrage pour la saisie
		
		// Création de la fenêtre de jeu et affichage de la fenêtre 
		int nbJoueurs=((Integer)parametres[0]).intValue(); // Récupération du nombre de joueurs
		IG.creerFenetreJeu("Le labyrinthe",nbJoueurs); // On crée la fenêtre
		IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu
        
		// Change les pièces du plateau
        for (int i=0;i<7;i++)
            for (int j=0;j<7;j++)
                IG.changerPiecePlateau(i, j, 0, 0);
        		IG.miseAJourAffichage();
        		
        // Affiche le message
        String message[]={
                		    "",
                            "Cliquer pour continuer ...",
                        	};
        IG.afficherMessage(message); 
        IG.miseAJourAffichage();
        IG.attendreClic();
        
        
        // Plateau aléatoire
        Piece plateau[] = Piece.nouvellesPieces();
        int numObjet = 0;
        for (int i=0;i<7;i++) {
            for (int j=0;j<7;j++) {
            	plateau[numObjet].setOrientation(Utils.genererEntier(3));
                IG.changerPiecePlateau(i, j, plateau[numObjet].getModelePiece(), plateau[numObjet].getOrientationPiece());
        		numObjet += 1;
            }
        }
        
        // Change la pièce hors du plateau
        plateau[49].setOrientation(Utils.genererEntier(3));
        IG.changerPieceHorsPlateau(plateau[49].getModelePiece(),plateau[49].getOrientationPiece());
        IG.miseAJourAffichage();
        IG.attendreClic();
        
        // Execution des 4 clics
        for (int a=0; a<4; a++) {
        	numObjet = 0;
        	for (int i=0;i<7;i++) {
 	            for (int j=0;j<7;j++){
 	            	plateau[numObjet].rotation();
 	            	IG.changerPiecePlateau(i, j, plateau[numObjet].getModelePiece(), plateau[numObjet].getOrientationPiece());
 	        		numObjet += 1;
 	            }
        	}
        	plateau[49].rotation();
        	IG.changerPieceHorsPlateau(plateau[49].getModelePiece(),plateau[49].getOrientationPiece());
        	System.out.println(plateau[49].toString());
        	IG.miseAJourAffichage();
        	IG.attendreClic();
        }
        
  		 // Fermer le jeu
  		 IG.fermerFenetreJeu();
         System.exit(0);
        		
	}
}
