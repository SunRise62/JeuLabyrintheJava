package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import joueurs.JoueurOrdinateur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les éléments de la partie.
	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numéros.
	private Plateau plateau; 	// Le plateau des pièces.
	private Piece pieceLibre; 	// La pièce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// On affiche l'ensemble des éléments
		joueurs = elementsPartie.getJoueurs();	
		objets = elementsPartie.getObjets();	
		plateau = elementsPartie.getPlateau();		
		pieceLibre = elementsPartie.getPieceLibre();	 	
		nombreJoueurs = elementsPartie.getNombreJoueurs();
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
        for (int i=0;i<nombreJoueurs;i++) {
     		IG.changerNomJoueur(i, joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
     		IG.changerImageJoueur(i, joueurs[i].getNumeroImagePersonnage());
     		IG.placerJoueurPrecis(i,joueurs[i].getPosLigne(),joueurs[i].getPosColonne(),1,1);
     		Objet tmp[] = joueurs[i].getObjetsJoueur();
        	for (int j=0; j < (objets.length / joueurs.length) ; j++){
        		IG.changerObjetJoueur(i,tmp[j].getNumeroObjet(),j);
        	}
        }
        IG.miseAJourAffichage();
		IG.rendreVisibleFenetreJeu();
	}

	/**
	 * Méthode permettant de paramètrer et initialiser les éléments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des différents paramètres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Création des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Création des éléments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de lancer une partie.
	 */
	public void lancer(){
		int tmp[] = new int[2];
		boolean fini = true;
		while(fini) {
			for (int i=0; i < nombreJoueurs; i++) {
				IG.changerJoueurSelectionne(i);
				Objet objsJrs[] = joueurs[i].getObjetsJoueur();
	        	String message1[]={
	                    "",
	                    "Au tour de "+joueurs[i].getNomJoueur(),
	                    "Orientez la pi�ce hors plateau puis",
	                    "Choisissez une entr�e ...",
	                    "(une des fl�ches)",
	                    };
	        	String message2[]={
	                    "",
	                    "Au tour de "+joueurs[i].getNomJoueur(),
	                    "S�lectionner une case ..."
	                    };
	        	IG.afficherMessage(message1); 
	        	IG.miseAJourAffichage();
				tmp = joueurs[i].choisirOrientationEntree(elementsPartie);
				if(pieceLibre.getModelePiece() == 1) {
					while(pieceLibre.getOrientationPiece() != 1) {
						pieceLibre.rotation();
					}
				} 
				else { 
					while(pieceLibre.getOrientationPiece() != 3) {
						pieceLibre.rotation();
						}
					}
				for(int a = 0; a <= tmp[0]; a++) {
					pieceLibre.rotation();
				}
	        	IG.miseAJourAffichage();
				elementsPartie.insertionPieceLibre(tmp[1]);
				pieceLibre = elementsPartie.getPieceLibre();
	        	IG.afficherMessage(message2);
	        	IG.miseAJourAffichage();
	        	int position[] = joueurs[i].choisirCaseArrivee(elementsPartie);
	        	int chemin[][] = plateau.calculeChemin(joueurs[i].getPosLigne(),joueurs[i].getPosColonne(),position[0],position[1]);
	        	if(chemin != null){
		        	for(int j = 0; j < 7; j++) {
		            	for(int k = 0; k < 7; k++) {
		            		if((chemin[j][k] > -1) & (j == position[0]) & (k == position[1])) {
		            			joueurs[i].setPosition(j,k);
		            			IG.placerJoueurPrecis(joueurs[i].getNumJoueur(),j,k,1,1);
		            		}
		            	}
		            }
	        	}
	        	for(int j = 0; j < objets.length; j++) {
	        		if(joueurs[i].getNombreObjetsRecuperes() < 6) {
		        		if((objets[j].getPosLignePlateau() == position[0]) & (objets[j].getPosColonnePlateau() == position[1]) & (objets[j].getNumeroObjet() == objsJrs[joueurs[i].getNombreObjetsRecuperes()].getNumeroObjet())) {
		        			IG.enleverObjetPlateau(position[0], position[1]);
		        			objets[j].enleveDuPlateau();
		        			IG.changerObjetJoueurAvecTransparence(i,objsJrs[joueurs[i].getNombreObjetsRecuperes()].getNumeroObjet(),joueurs[i].getNombreObjetsRecuperes());
		        			joueurs[i].recupererObjet();
		        		}
	        		}
	        	}
	        	if(joueurs[i].getNombreObjetsRecuperes() == (objets.length / joueurs.length)) {
					fini = false;
					IG.afficherGagnant(i);
					// Fermer le jeu
					String message[]={
			                "",
			                "C'est termin� ! ",
			                "Cliquer pour quitter ..."
			                };
			        IG.afficherMessage(message);
			        IG.miseAJourAffichage();
			        IG.attendreClic();
			 		IG.fermerFenetreJeu();
			        System.exit(0);
	        	}
	        }
		}
	}

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		while(true){
			Partie partie = new Partie();
			partie.lancer();
		}
	}

}