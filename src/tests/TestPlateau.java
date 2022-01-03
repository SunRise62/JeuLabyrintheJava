package tests;

import grafix.interfaceGraphique.IG;
import composants.Plateau;
import composants.Piece;


public class TestPlateau {
    
    public static void main(String[] args) {
        
        // Saisie des différents paramètres
        Object parametres[];
        parametres=IG.saisirParametres(); // On ouvre la fenêtre de paramétrage pour la saisie
        
        // Création de la fenêtre de jeu et affichage de la fenêtre 
        int nbJoueurs=((Integer)parametres[0]).intValue(); // Récupération du nombre de joueurs
        IG.creerFenetreJeu("Le labyrinthe",nbJoueurs); // On crée la fenêtre
        IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu
                
        
        // Affiche le message
        String message[]={
                            "",
                            "Cliquer pour continuer ...",
                            };
        IG.afficherMessage(message); 
        IG.miseAJourAffichage();
        IG.attendreClic();
        
        //création du tableau et de la piece extérieure
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoirement();
        IG.attendreClic();
        IG.miseAJourAffichage();
        IG.attendreClic();
        
        
        //chemin
        System.out.print("La liste des chemins trouvés à partir de la case (1,1) : ");
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