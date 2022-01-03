package tests;

import grafix.interfaceGraphique.IG;
import composants.Plateau;
import composants.Utils;
import composants.Piece;
import joueurs.Joueur;

public class TestJoueur {

	public static void main(String[] args) {
		// Saisie des différents paramètres
        Object parametres[];
        parametres=IG.saisirParametres(); // On ouvre la fenêtre de paramétrage pour la saisie
        
        // Initialisation des joueurs
        Joueur joueurs[] = Joueur.nouveauxJoueurs(parametres);
        
        // Création de la fenêtre de jeu et affichage de la fenêtre 
        int nbJoueurs = joueurs.length; // Récupération du nombre de joueurs
        IG.creerFenetreJeu("Le labyrinthe",nbJoueurs); // On crée la fenêtre
        
        //création du tableau et de la piece extérieure
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoirement();
        
        // Placement des pièces
        for (int i=0;i<7;i++) {
            for (int j=0;j<7;j++) {
            	IG.changerPiecePlateau(i, j, plateau.getPiece(i,j).getModelePiece(), plateau.getPiece(i,j).getOrientationPiece());
            }
        }
        
        // Change la pièce hors du plateau
        IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(),pieceHorsPlateau.getOrientationPiece());
        
        // Changement des caractéristiques des joueurs avec les paramètres choisis
        for (int i=0;i<nbJoueurs;i++)
     		IG.changerNomJoueur(i, joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
        for (int i=0;i<nbJoueurs;i++)
			IG.changerImageJoueur(i, joueurs[i].getNumeroImagePersonnage());
        
        // Place les joueurs à leur emplacement initial
        for (int i=0; i < nbJoueurs; i++)
			IG.placerJoueurSurPlateau(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne());
        
        // Affiche le message
        String message[]={
                            "",
                            "Cliquer pour continuer ...",
                            };
        IG.afficherMessage(message); 
        IG.miseAJourAffichage();
        IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu
        IG.attendreClic();
        
        for (int i=0; i<nbJoueurs; i++) {
        	String message1[]={
                    "",
                    "Au tour de "+joueurs[i].getNomJoueur(),
                    "Sélectionner une case ..."
                    };
        	IG.afficherMessage(message1); 
        	IG.miseAJourAffichage();
        	int position[] = joueurs[i].choisirCaseArrivee(null);
        	int chemin[][] = plateau.calculeChemin(joueurs[i].getPosLigne(),joueurs[i].getPosColonne(),position[0],position[1]);
        	for(int j = 0; j < 7; j++) {
            	for(int k = 0; k < 7; k++) {
            		if(chemin[j][k] == 0) {
            			IG.placerJoueurSurPlateau(joueurs[i].getNumJoueur(),j,k);
            		}
            	}
            }
        	IG.miseAJourAffichage();
        }
        
	}

}
