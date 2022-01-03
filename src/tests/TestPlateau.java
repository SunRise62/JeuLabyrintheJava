package tests;

import grafix.interfaceGraphique.IG;
import composants.Plateau;
import composants.Piece;


public class TestPlateau {
    
    public static void main(String[] args) {
        
        // Saisie des diff�rents param�tres
        Object parametres[];
        parametres=IG.saisirParametres(); // On ouvre la fen�tre de param�trage pour la saisie
        
        // Cr�ation de la fen�tre de jeu et affichage de la fen�tre 
        int nbJoueurs=((Integer)parametres[0]).intValue(); // R�cup�ration du nombre de joueurs
        IG.creerFenetreJeu("Le labyrinthe",nbJoueurs); // On cr�e la fen�tre
        IG.rendreVisibleFenetreJeu();  // On rend visible la fen�tre de jeu
                
        
        // Affiche le message
        String message[]={
                            "",
                            "Cliquer pour continuer ...",
                            };
        IG.afficherMessage(message); 
        IG.miseAJourAffichage();
        IG.attendreClic();
        
        //cr�ation du tableau et de la piece ext�rieure
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoirement();
        IG.attendreClic();
        IG.miseAJourAffichage();
        IG.attendreClic();
        
        
        //chemin
        System.out.print("La liste des chemins trouv�s � partir de la case (1,1) : ");
        int[][] objet = null;
        for(int i=0; i < 7; i++) {
        	for(int j = 0; j<7; j++) {
        		objet = plateau.calculeChemin(1, 1, 2, 2);
        		//if (objet[i][j] == -1){
        			//System.out.print("");
        		//}
        		//else
        			System.out.print(objet[i][j]+" ");
        	}
        }
        
        
        
        //afficher chemin avec bille 
        IG.placerBilleSurPlateau(0, 0, 1, 1, 2);
        IG.placerBilleSurPlateau(0, 4, 1, 1, 2);
        
        IG.attendreClic();
        IG.miseAJourAffichage();
        
        
        // Fermer le jeu
        IG.attendreClic();
        IG.fermerFenetreJeu();
        System.exit(0);
        
    }
    
}