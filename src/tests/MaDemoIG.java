package tests;

import grafix.interfaceGraphique.IG;

public class MaDemoIG {
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
		int numObjet=0;
		for (int i=0;i<7;i++)
			for (int j=0;j<7;j++)
				if(numObjet < 18)
					IG.placerObjetPlateau((numObjet++)%18,i,j);
					IG.miseAJourAffichage();
		
		// Place les joueurs sur la ligne du milieu
		for (int i=0;i<nbJoueurs;i++)
		if(i<nbJoueurs)
			IG.placerJoueurPrecis(0, 3, 0, 1, 0);
			IG.placerJoueurPrecis(1, 3, 6, 1, 2);
			IG.placerJoueurSurPlateau(2, 28, 2);
		IG.miseAJourAffichage();
        
        // Change les pi�ces du plateau
        for (int i=0;i<7;i++)
            for (int j=0;j<7;j++)
                IG.changerPiecePlateau(i, j, 2, 0);
        		IG.miseAJourAffichage();
        		
        // Change la pi�ce hors du plateau
        IG.changerPieceHorsPlateau(1,0);
        IG.miseAJourAffichage();
        
        // Changement des caract�ristiques des joueurs avec les param�tres choisis
        for (int i=0;i<nbJoueurs;i++)
     		IG.changerNomJoueur(i, (String)parametres[1+(3*i)]+" ("+(String)parametres[2+(3*i)]+")");
        for (int i=0;i<nbJoueurs;i++)
			IG.changerImageJoueur(i, ((Integer)parametres[3+(3*i)]).intValue());
        IG.miseAJourAffichage();
        
        // Attribution des objets aux joueurs
        for (int i=0;i<nbJoueurs;i++)
        	for (int j=0;j<6;j++){
        		IG.changerObjetJoueur(i,j+(i*6),j);
        	}
		IG.miseAJourAffichage();
		
        // Affiche le message
        String message[]={
                    "",
                    "Bonjour ",
                    "Cliquer pour continuer ...",
                    ""
                	};
         IG.afficherMessage(message); 
         IG.miseAJourAffichage();
         IG.attendreClic();
         
        // Execution des 4 clics
        for (int i=0;i<nbJoueurs;i++)
        	if(i<nbJoueurs)
 				IG.placerJoueurPrecis(0, 3, 0, 1, 1);
 				IG.placerJoueurPrecis(1, 3, 6, 1, 1);
 		IG.placerBilleSurPlateau(3, 0, 1, 0, 0);
 		 IG.placerBilleSurPlateau(3, 6, 1, 2, 0);
 		 IG.miseAJourAffichage();
 		 IG.enleverObjetPlateau(0,0);
 		 IG.changerObjetJoueurAvecTransparence(0, 0, 0);
 		 for (int i=0;i<7;i++)
 	            for (int j=0;j<7;j++)
 	                IG.changerPiecePlateau(i, j, 2, 1);
 	        IG.changerPieceHorsPlateau(1,0);    
 		 String message1[]={
  				"",
  				"Apr�s le clic 1 ",
  				"Cliquer pour continuer ...",
  				""
  		 };
  		 IG.afficherMessage(message1); 
  		 IG.miseAJourAffichage();
  		 IG.attendreClic();
  		 IG.miseAJourAffichage();
         
 		 for (int i=0;i<nbJoueurs;i++)
 			 if(i<nbJoueurs)
 				 IG.placerJoueurPrecis(0, 3, 0, 1, 2);
 				 IG.placerJoueurPrecis(1, 3, 6, 1, 0);
 		 IG.placerBilleSurPlateau(3, 0, 1, 1, 0);
 		 IG.placerBilleSurPlateau(3, 6, 1, 1, 0);
 		 IG.miseAJourAffichage();	
 		 IG.enleverObjetPlateau(0,1);
 		 IG.changerObjetJoueurAvecTransparence(0, 1, 1);
 		 for (int i=0;i<7;i++)
 	            for (int j=0;j<7;j++)
 	                IG.changerPiecePlateau(i, j, 2, 2);
 	        IG.changerPieceHorsPlateau(1,1);    
 		 String message2[]={
  				"",
  				"Apr�s le clic 2 ",
  				"Cliquer pour continuer ...",
  				""
  		 };
  		 IG.afficherMessage(message2); 
  		 IG.miseAJourAffichage();
  		 IG.attendreClic();
  		 
 		 for (int i=0;i<nbJoueurs;i++)
 			 if(i<nbJoueurs)
 				 IG.placerJoueurPrecis(0, 3, 0, 1, 3);
 				 IG.placerJoueurPrecis(1, 3, 6, 1, -1);
 		 IG.placerBilleSurPlateau(3, 0, 1, 2, 0);
 		 IG.placerBilleSurPlateau(3, 6, 1, 0, 0);
 		 IG.miseAJourAffichage();
 		 IG.enleverObjetPlateau(0,2);
 		 IG.changerObjetJoueurAvecTransparence(0, 2, 2);
 		 for (int i=0;i<7;i++)
 	            for (int j=0;j<7;j++)
 	                IG.changerPiecePlateau(i, j, 2, 3);
 	        IG.changerPieceHorsPlateau(1,0);   
 		 String message3[]={
  				"",
  				"Apr�s le clic 3 ",
  				"Cliquer pour continuer ...",
  				""
  		 };
  		 IG.afficherMessage(message3); 
  		 IG.miseAJourAffichage();
  		 IG.attendreClic();
  		 IG.miseAJourAffichage();
 		 
         for (int i=0;i<nbJoueurs;i++)
 			 if(i<nbJoueurs)
 		 IG.placerJoueurPrecis(0, 3, 0, 1, 4);
 				IG.placerJoueurPrecis(1, 3, 6, 1, -2);
 		 IG.placerBilleSurPlateau(3, 1, 1, 0, 0);
 		 IG.placerBilleSurPlateau(3, 5, 1, 2, 0);
 		 IG.miseAJourAffichage();
 		 IG.enleverObjetPlateau(0,3);
 		 IG.changerObjetJoueurAvecTransparence(0, 3, 3);
 		 for (int i=0;i<7;i++)
 	            for (int j=0;j<7;j++)
 	                IG.changerPiecePlateau(i, j, 2, 0);
 	        IG.changerPieceHorsPlateau(1,1);    
 		 String message4[]={
  		 		"",
  		 		"Apr�s le clic 4 ",
  		 		"Cliquer pour continuer ...",
  		 		""
  		 };
  		 IG.afficherMessage(message4); 
  		 IG.miseAJourAffichage();
  		 IG.attendreClic();
  		 IG.miseAJourAffichage();

         // Visu gagnant
         IG.attendreClic();
         IG.afficherGagnant(0);
         IG.miseAJourAffichage();
         message[0]="";
         message[1]="Cliquez sur une fl�che";
         message[2]="pour quitter !";
         IG.afficherMessage(message);
         IG.miseAJourAffichage();
         
         // Attente d'un clic sur une entr�e
         IG.attendreChoixEntree();
         message[0]="";
         message[1]="Arr�t du programme";
         message[2]="dans 2 secondes !";
         IG.afficherMessage(message);
         IG.miseAJourAffichage();
         IG.pause(2000);
         IG.fermerFenetreJeu();
         System.exit(0);
         
	}
}