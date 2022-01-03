package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet de représenter un ensemble d'élements composant une partie de jeu.
 * 
 */
public class ElementsPartie {

	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numéros.
	private Plateau plateau; 	// Le plateau des pièces.
	private Piece pieceLibre; 	// La pièce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.

	/**
	 * 
	 * A Faire (31/05/2021 DV Finalis�)
	 *  
	 * Constructeur permettant de générer et d'initialiser l'ensemble des éléments d'une partie (sauf les joueurs qui sont donnés en paramètres).
	 * 
	 * Un plateau est créé en placant 49 oièces de manière aléatoire (utilisation de la méthode placerPiecesAleatoierment de la classe Plateau).
	 * La pièce restante (celle non présente sur le plateau) est affectée �  la pièce libre.
	 * Les 18 objets sont créés avec des positions aléatoires sur le plateau (utilisation de la méthode Objet.nouveauxObjets)
	 * et distribuées aux différents joueurs (utilisation de la méthode attribuerObjetsAuxJoueurs).
	 * 
	 * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribués (c'est au constructeur de le faire).
	 */
	public ElementsPartie(Joueur[] joueurs) {
		this.joueurs = joueurs;
		plateau = new Plateau();
		pieceLibre = plateau.placerPiecesAleatoirement();
		objets = Objet.nouveauxObjets();
		nombreJoueurs = joueurs.length;
		attribuerObjetsAuxJoueurs();	
	}

	/**
	 * Un simple constructeur.
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param objets Les 18 objets de la partie.
	 * @param plateau Le plateau de jeu.
	 * @param pieceLibre La pièce libre (la pièce hors plateau).
	 */
	public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
		this.joueurs=joueurs;
		nombreJoueurs=joueurs.length;
		this.objets=objets;
		this.plateau=plateau;
		this.pieceLibre=pieceLibre;
	}

	/**
	 * A Faire (31/05/2021 DV Finalis�)
	 * 
	 * Méthode permettant d'attribuer les objets aux différents joueurs de manière aléatoire.
	 */
	private void attribuerObjetsAuxJoueurs(){
		int stock[] = Utils.genereTabIntAleatoirement(18);
		Objet tmp[] = new Objet[objets.length / nombreJoueurs];
		for(int i = 0; i < nombreJoueurs; i++) {
			for(int j = 0; j < tmp.length; j++) {
				tmp[j] = objets[stock[j+(tmp.length*i)]];
			}
			joueurs[i].setObjetsJoueur(tmp);
		}	
	}

	/**
	 * A Faire (31/05/2021 DV Finalis�)
	 * 
	 * Méthode permettant de récupérer les joueurs de la partie.
	 * @return Les joueurs de la partie.
	 */
	public Joueur[] getJoueurs() {
		return joueurs; 
	}


	/**
	 * A Faire (31/05/2021 DV Finalis�)
	 * 
	 * Méthode permettant de récupérer les pièces de la partie.
	 * @return Les objets de la partie.
	 */
	public Objet[] getObjets() {
		return objets; 
	}


	/**
	 * A Faire (31/05/2021 DV Finalis�)
	 * 
	 * Méthode permettant de récupérer le plateau de pièces de la partie.
	 * @return Le plateau de pièces.
	 */
	public Plateau getPlateau() {
		return plateau; 
	}


	/**
	 * A Faire (31/05/2021 DV Finalis�)
	 * 
	 * Méthode permettant de récupérer la pièce libre de la partie.
	 * @return La pièce libre.
	 */
	public Piece getPieceLibre() {
		return pieceLibre; 
	}


	/**
	 * A Faire (31/05/2021 DV Finalis�)
	 * 
	 * Méthode permettant de récupérer le nombre de joueurs de la partie.
	 * @return Le nombre de joueurs.
	 */
	public int getNombreJoueurs() {
		return nombreJoueurs; 
	}


	/**
	 * A Faire (01/06/2021 DV Finalis�)
	 * 
	 * Méthode modifiant les différents éléments de la partie suite �  l'insertion de la pièce libre dans le plateau.
	 * 
	 * @param choixEntree L'entrée choisie pour réaliser l'insertion (un nombre entre 0 et 27).
	 */
	public void insertionPieceLibre(int choixEntree){
	    if(0 <= choixEntree && choixEntree < 7) {
	        Piece tmp = plateau.getPiece(0,choixEntree);
	        plateau.positionnePiece(pieceLibre,0,choixEntree);
	        pieceLibre = plateau.getPiece(6,choixEntree);
        	for(int j = 0; j < nombreJoueurs; j++) {
        		if(joueurs[j].getPosColonne() == choixEntree) {
        			if(joueurs[j].getPosLigne() == 6) {
        				joueurs[j].setPosition(0,choixEntree);
        			} else {
        				joueurs[j].setPosition((joueurs[j].getPosLigne()+1),choixEntree);
        			}
        			IG.placerJoueurPrecis(j,joueurs[j].getPosLigne(),choixEntree,1,1);
        		}
        	}
        	for(int i = 0; i < objets.length; i++) {
        		if(objets[i].getPosColonnePlateau() == choixEntree) {
        			IG.enleverObjetPlateau(objets[i].getPosLignePlateau(),choixEntree);
        			if(objets[i].getPosLignePlateau() == 6) {
        				objets[i].positionneObjet(0,choixEntree);
        			} else {
        				objets[i].positionneObjet((objets[i].getPosLignePlateau())+1,choixEntree);
        			}
        		}
        	}
	        for(int i = 0; i < 6; i++) {
	            Piece tmp2 = plateau.getPiece(i+1,choixEntree);
	            plateau.positionnePiece(tmp,i+1,choixEntree);
	            tmp = tmp2;
	        }
	    }
	    if(7 <= choixEntree && choixEntree < 14) {
	        Piece tmp = plateau.getPiece((choixEntree-7),0);
	        for(int j = 0; j < nombreJoueurs; j++) {
        		if(joueurs[j].getPosLigne() == (choixEntree-7)) {
        			if(joueurs[j].getPosColonne() == 0) {
        				joueurs[j].setPosition((choixEntree-7),6);
        			} else {
        				joueurs[j].setPosition((choixEntree-7),(joueurs[j].getPosColonne()-1));
        			}
        			IG.placerJoueurPrecis(j,(choixEntree-7),joueurs[j].getPosColonne(),1,1);
        		}
        	}
        	for(int i = 0; i < objets.length; i++) {
        		if(objets[i].getPosLignePlateau() == (choixEntree-7)) {
        			IG.enleverObjetPlateau((choixEntree-7),objets[i].getPosColonnePlateau());
        			if(objets[i].getPosColonnePlateau() == 0) {
        				objets[i].positionneObjet((choixEntree-7),6);
        			} else {
        				objets[i].positionneObjet((choixEntree-7),(objets[i].getPosColonnePlateau())-1);
        			}
        		}
        	}
	        for(int i = 0; i < 6; i++) {
	            plateau.positionnePiece(plateau.getPiece((choixEntree-7),i+1),(choixEntree-7),i);
	        }
	        plateau.positionnePiece(pieceLibre,(choixEntree-7),6);
	        pieceLibre = tmp;
	    }
	    if(14 <= choixEntree && choixEntree < 21) {
	        Piece tmp = plateau.getPiece(6,(20-choixEntree));
	        plateau.positionnePiece(pieceLibre,6,(20-choixEntree));
	        pieceLibre = plateau.getPiece(0,(20-choixEntree));
        	for(int j = 0; j < nombreJoueurs; j++) {
        		if(joueurs[j].getPosColonne() == (20-choixEntree)) {
        			if(joueurs[j].getPosLigne() == 0) {
        				joueurs[j].setPosition(6,(20-choixEntree));
        			} else {
        				joueurs[j].setPosition((joueurs[j].getPosLigne()-1),(20-choixEntree));
        			}
        			IG.placerJoueurPrecis(j,joueurs[j].getPosLigne(),(20-choixEntree),1,1);
        		}
        	}
        	for(int i = 0; i < objets.length; i++) {
        		if(objets[i].getPosColonnePlateau() == (20-choixEntree)) {
        			IG.enleverObjetPlateau(objets[i].getPosLignePlateau(),(20-choixEntree));
        			if(objets[i].getPosLignePlateau() == 0) {
        				objets[i].positionneObjet(6,(20-choixEntree));
        			} else {
        				objets[i].positionneObjet((objets[i].getPosLignePlateau())-1,(20-choixEntree));
        			}
        		}
        	}
	        for(int i = 0; i < 6; i++) {
	            tmp = plateau.getPiece(i+1,(20-choixEntree));
	            plateau.positionnePiece(tmp,i,(20-choixEntree));
	        }    
	    }
	    if(21 <= choixEntree && choixEntree < 28) {
	        Piece tmp = plateau.getPiece((27-choixEntree),0);
	        plateau.positionnePiece(pieceLibre,(27-choixEntree),0);
	        pieceLibre = plateau.getPiece((27-choixEntree),6);
	        for(int j = 0; j < nombreJoueurs; j++) {
        		if(joueurs[j].getPosLigne() == (27-choixEntree)) {
        			if(joueurs[j].getPosColonne() == 6) {
        				joueurs[j].setPosition((27-choixEntree),0);
        			} else {
        				joueurs[j].setPosition((27-choixEntree),(joueurs[j].getPosColonne()+1));
        			}
        			IG.placerJoueurPrecis(j,(27-choixEntree),joueurs[j].getPosColonne(),1,1);
        		}
        	}
        	for(int i = 0; i < objets.length; i++) {
        		if(objets[i].getPosLignePlateau() == (27-choixEntree)) {
        			IG.enleverObjetPlateau((27-choixEntree),objets[i].getPosColonnePlateau());
        			if(objets[i].getPosColonnePlateau() == 6) {
        				objets[i].positionneObjet((27-choixEntree),0);
        			} else {
        				objets[i].positionneObjet((27-choixEntree),(objets[i].getPosColonnePlateau())+1);
        			}
        		}
        	}
	        for(int i = 0; i < 6; i++) {
	            Piece tmp2 = plateau.getPiece((27-choixEntree),i+1);
	            plateau.positionnePiece(tmp,(27-choixEntree),i+1);
	            tmp = tmp2;
	        }    
	    }
	    for (int i=0;i<7;i++) {
            for (int j=0;j<7;j++) {
                IG.changerPiecePlateau(i, j, plateau.getPiece(i,j).getModelePiece(), plateau.getPiece(i,j).getOrientationPiece());
            }
		}
     	for(int i=0; i < objets.length; i++) {
     		if((objets[i].getPosLignePlateau() != -1) & (objets[i].getPosColonnePlateau() != -1)) {
     			IG.placerObjetPlateau(i,objets[i].getPosLignePlateau(),objets[i].getPosColonnePlateau());
     		}
     	}
        IG.changerPieceHorsPlateau(pieceLibre.getModelePiece(),pieceLibre.getOrientationPiece());
	} 

	/**
	 * Méthode retournant une copie.
	 * 
	 * @return Une copie des éléments.
	 */
	public ElementsPartie copy(){
		Objet[] nouveauxObjets=new Objet[(this.objets).length];
		for (int i=0;i<objets.length;i++)
			nouveauxObjets[i]=(this.objets[i]).copy();
		Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++)
			nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
		Plateau nouveauPlateau=(this.plateau).copy();
		Piece nouvellePieceLibre=(this.pieceLibre).copy();
		ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre); 
		return nouveauxElements;
	}


}