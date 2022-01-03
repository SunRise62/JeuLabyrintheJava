package tests;

import partie.ElementsPartie;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import composants.Objet;
import composants.Plateau;
import composants.Utils;

public class TestElementsPartie {

	public static void main(String[] args) {
		
		// Saisie des diff�rents param�tres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		
		// Cr�ation de la fen�tre de jeu et affichage de la fen�tre 
		int nbJoueurs=((Integer)parametresJeu[0]).intValue(); // R�cup�ration du nombre de joueurs
		IG.creerFenetreJeu("- TestElementsPartie",nbJoueurs); // On cr�e la fen�tre
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu); 
		ElementsPartie elementsPartie = new ElementsPartie(joueurs);
		
		// Change les pi�ces du plateau
		Plateau plateau = elementsPartie.getPlateau();
        for (int i=0;i<7;i++)
            for (int j=0;j<7;j++)
                IG.changerPiecePlateau(i, j, plateau.getPiece(i,j).getModelePiece(), plateau.getPiece(i,j).getOrientationPiece());
        IG.changerPieceHorsPlateau(elementsPartie.getPieceLibre().getModelePiece(),elementsPartie.getPieceLibre().getOrientationPiece());
        
        // Place des objets sur le plateau
     	Objet objet[] = elementsPartie.getObjets();
     	for(int i=0; i<objet.length; i++) {
     		IG.placerObjetPlateau(i,objet[i].getPosLignePlateau(),objet[i].getPosColonnePlateau());
     	}
     	
        // Changement des caract�ristiques des joueurs avec les param�tres choisis
        for (int i=0;i<nbJoueurs;i++) {
     		IG.changerNomJoueur(i, joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
     		IG.changerImageJoueur(i, joueurs[i].getNumeroImagePersonnage());
     		IG.placerJoueurSurPlateau(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne());
     		Objet tmp[] = joueurs[i].getObjetsJoueur();
        	for (int j=0;j<6;j++){
        		IG.changerObjetJoueur(i,tmp[j].getNumeroObjet(),j);
        	}
        }
        
        // Affiche le message
        String message[]={
                            "",
                            "Cliquer pour continuer ...",
                            };
        String message2[]={
                "",
                "Choisissez une entr�e ...",
                "(une des fl�ches)",
                };
        String message3[]={
                "",
                "C'est termin� ! ",
                "Cliquer pour quitter ..."
                };
        IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.rendreVisibleFenetreJeu();  // On rend visible la fen�tre de jeu
        IG.attendreClic();
		IG.afficherMessage(message2);
		IG.miseAJourAffichage();
		
		for (int k=0; k < 4 ; k++) {
			IG.miseAJourAffichage();
			int tmp [] = joueurs[0].choisirOrientationEntree(elementsPartie);
			elementsPartie.getPieceLibre().setOrientation(tmp[0]);
			elementsPartie.insertionPieceLibre(tmp[1]);
		}
		IG.afficherMessage(message3);
		IG.miseAJourAffichage();
		IG.attendreClic();
		// Fermer le jeu
 		IG.fermerFenetreJeu();
        System.exit(0);
	}

}
