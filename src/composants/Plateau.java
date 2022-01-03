package composants;

/**
 * Cette classe permet de g�rer un plateau de jeu constitu� d'une grille de pi�ces (grille de 7 lignes sur 7 colonnes).
 *
 */
public class Plateau {

	private Piece plateau[][]; // La grille des pi�ces.

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de construire un plateau vide (sans pi�ces) et d'une taille de 7 lignes sur 7 colonnes.
	 */
	public Plateau() {
        plateau = new Piece[7][7];
    }

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode permettant de placer une pi�ce sur le plateau.
	 * 
	 * @param piece La pi�ce �  placer.
	 * @param lignePlateau La ligne du plateau sur laquelle sera plac�e la pi�ce (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau sur laquelle sera plac�e la pi�ce (une entier entre 0 et 6).
	 */
	public void positionnePiece(Piece piece,int lignePlateau,int colonnePlateau){
		plateau[lignePlateau][colonnePlateau] = piece;	
    }

	/**
	 * A Faire (13/05/2021 TD EnCours)
	 * 
	 * Méthode retournant une pi�ce se trouvant sur le plateau � un emplacement sp�cifique.
	 * 
	 * @param lignePlateau La ligne du plateau  (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau (un entier entre 0 et 6).
	 * @return La pi�ce se trouvant sur la ligne lignePlateau et la colonne colonnePlateau. Si il n'y a pas de pi�ce, null est retourn�.
	 */
	public Piece getPiece(int lignePlateau,int colonnePlateau){
        return plateau[lignePlateau][colonnePlateau]; 
    }

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 *  
	 * M�thode permettant de placer al�atoirement 49 pi�ces du jeu sur le plateau.
	 * L'orientation des pi�ces est al�atoire. Les pi�ces utilis�es doivent �tre des nouvelles pi�ces g�n�r�es �  partir de la m�thode Piece.nouvellesPieces.
	 * Parmi les 50 pi�ces du jeu, la pi�ce qui n'a pas �t� plac�e sur le plateau est retourn�e par la m�thode.
	 * 
	 * @return La seule pi�ce qui n'a pas �t� plac�e sur le plateau
	 */
	public Piece placerPiecesAleatoirement(){
		Piece tab[] = Piece.nouvellesPieces();
		int tmp[] = Utils.genereTabIntAleatoirement(50);
		int count = 0;
		for (int i=0;i<7;i++) {
            for (int j=0;j<7;j++) {
            	plateau[i][j] = tab[tmp[count]];
            	count++;
            }
        }
		return tab[tab.length - 1];
	}

	/**
	 * 
	 * M�thode utilitaire permettant de tester si les positions pas�es en param�tre sont les positions de deux cases diff�rentes et adjacentes d'une grille de 7 lignes sur 7 colonnes.
	 *  
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les les positions pass�es en param�tre sont les positions de deux cases diff�rentes et adjacentes d'une grille de 7 lignes sur 7 colonnes, false sinon.
	 */
	private static boolean casesAdjacentes(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if((posLigCase1 == posLigCase2) & (posColCase1 == posColCase2)){
			return false;
		}
		else if((posLigCase2 < 0) | (posColCase2 < 0) | (posLigCase2 > 6) | (posColCase2 > 6)){
			return false;
		}
		else if((posLigCase1+1 == posLigCase2) | (posLigCase1-1 == posLigCase2) | (posColCase1+1 == posColCase2) | (posColCase1-1 == posColCase2)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode permettant de tester si les positions pass�es en param�tre sont les positions de deux cases diff�rentes et adjacentes 
	 * de la grille de jeu et qu'il est possible de passer d'une case � l'autre compte tenu des deux pi�ces pos�es sur les deux cases du plateau.
	 * 
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les positions pass�es en param�tre sont les positions de deux cases diff�rentes et adjacentes de la grille de jeu et qu'il est possible de passer d'une case � l'autre compte tenu des deux pi�ces pos�es sur les deux cases du plateau, false sinon.
	 */
	private boolean passageEntreCases(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if(casesAdjacentes(posLigCase1, posColCase1, posLigCase2, posColCase2)) {
			if((posLigCase1 > posLigCase2) & (plateau[posLigCase1][posColCase1].getPointEntree(0)) & (plateau[posLigCase2][posColCase2].getPointEntree(2))) {
				return true;
			}
			if((posColCase2 > posColCase1) & (plateau[posLigCase1][posColCase1].getPointEntree(1)) & (plateau[posLigCase2][posColCase2].getPointEntree(3))) {
				return true;
			}
			if((posLigCase2 > posLigCase1) & (plateau[posLigCase1][posColCase1].getPointEntree(2)) & (plateau[posLigCase2][posColCase2].getPointEntree(0))) {
				return true;
			}
			if((posColCase1 > posColCase2) & (plateau[posLigCase1][posColCase1].getPointEntree(3)) & (plateau[posLigCase2][posColCase2].getPointEntree(1))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode permettant de retourner un �ventuel chemin entre deux cases du plateau compte tenu des pi�ces pos�es sur le plateau.
	 * Dans le cas o� il n'y a pas de chemin entre les deux cases, la valeur null est retourn�e.
	 * Dans le cas o� il existe un chemin, un chemin possible est retourn� sous forme d'un tableau d'entiers �  deux dimensions.
	 * La premi�re dimension correspond aux cases du plateau � emprunter pour aller de la case de d�part �  la case d'arriv�e.
	 * Dans ce tableau, chaque case est un tableau de deux entiers avec le premier entier qui correspond � la ligne de la case et
	 * le second entier qui correspond � la colonne de la case. La premi�re case d'un chemin retourn� correspond toujours 
	 * � la case (posLigCaseDep,posColCaseDep) et la derni�re case correspond toujours � la case (posLigCaseArr,posColCaseArr).
	 *
	 * @param posLigCaseDep La ligne de la case de d�part (un entier compris entre 0 et 6).
	 * @param posColCaseDep La colonne de la case de d�part (un entier compris entre 0 et 6).
	 * @param posLigCaseArr La ligne de la case d'arriv�e (un entier compris entre 0 et 6).
	 * @param posColCaseArr La colonne de la case d'arriv�e (un entier compris entre 0 et 6).
	 * @return null si il n'existe pas de chemin entre les deux case, return un chemin sinon.
	 */
	public int[][] calculeChemin(int posLigCaseDep,int posColCaseDep,int posLigCaseArr,int posColCaseArr) {
		int resultat[][] = new int[7][7];
		for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                resultat[i][j] = -1;
            }
		}
		resultat[posLigCaseDep][posColCaseDep] = 0;
		int val = 0;
		while(resultat[posLigCaseArr][posColCaseArr] == -1) {
	        for(int i = 0; i < 7; i++) {
	        	for(int j = 0; j < 7; j++) {
		        	if(passageEntreCases(i,j,i-1,j) && (resultat[i][j] != -1)){
		        		resultat[i-1][j] = val + 1;
		        	}
		       		if(passageEntreCases(i,j,i+1,j) && (resultat[i][j] != -1)){
		       			resultat[i+1][j] = val + 1;
		       		}
		       		if(passageEntreCases(i,j,i,j-1) && (resultat[i][j] != -1)){
		       			resultat[i][j-1] = val + 1;
		       		}
		       		if(passageEntreCases(i,j,i,j+1) && (resultat[i][j] != -1)){
		       			resultat[i][j+1] = val + 1;
	        		}
		       		if(val > 100000){
		       			return null;
		       		}
		       		val++;
	        	}
	        }
        }
		return resultat;
	}
	
	/**
	 * 
	 * M�thode permettant de calculer un chemin d�taill� (chemin entre sous-cases) �  partir d'un chemin entre cases.
	 *  
	 * @param chemin Un tableau repr�sentant un chemin de cases.
	 * @param numJoueur Le num�ro du joueur pour lequel nous souaitons construire un chemin d�taill�.
	 * 
	 * @return Le chemin d�taill� correspondant au chemin de positions de pi�ces donn�es en param�tre et pour le num�ro de joueur donn�.
	 */
	public int[][] calculeCheminDetaille(int[][] chemin,int numJoueur){
		if (chemin.length==1)
			return new int[0][0];
		int[][] cheminDetaille=new int[chemin.length*5][4];
		int pos=0;
		int col,lig,colS,ligS;
		for (int i=0;i<chemin.length-1;i++){
			lig=chemin[i][0];
			col=chemin[i][1];
			ligS=chemin[i+1][0];
			colS=chemin[i+1][1];
			if (ligS<lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
			}
			else if (ligS>lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
			} else if (colS<col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
			} else if (colS>col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
			}
		}
		cheminDetaille[pos][0]=chemin[chemin.length-1][0];
		cheminDetaille[pos][1]=chemin[chemin.length-1][1];
		cheminDetaille[pos][2]=1;
		cheminDetaille[pos++][3]=1;

		int debut=0;
		if ((numJoueur==0)&&((cheminDetaille[pos-2][2]==0)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==1)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==2)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==0))) pos--;
		if ((numJoueur==0)&&((cheminDetaille[1][2]==0)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==1)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==2)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==0))) debut++;

		int[][] resultat=new int[pos-debut][4];
		for (int i=debut;i<pos;i++)
			for (int j=0;j<4;j++)
				resultat[i-debut][j]=cheminDetaille[i][j];
		return resultat;	
	}

	/**
	 * 
	 * M�thode retournant une copie du plateau avec des copies de ses pi�ces.
	 * 
	 * @return Une copie du plateau avec une copie de toutes ses pi�ces.
	 */
	public Plateau copy(){
		Plateau plateau=new Plateau();
		for (int ligne=0;ligne<7;ligne++)
			for (int colonne=0;colonne<7;colonne++)
				plateau.positionnePiece((this.plateau[ligne][colonne]).copy(), ligne, colonne);
		return plateau;
	}

}