package composants;

/**
 * 
 * Cette classe permet de repr�senter les diff�rentes pi�ces du jeu.
 * 
 */
abstract public class Piece {

	private int modelePiece; 		// Le mod�le de la pi�ce
	private int orientationPiece; 	// L'orientation de la pi�ce
	private boolean[] pointsEntree; // Les points d'entr�e indice 0 pour le haut, 1 pour la droite, 2 pour le bas et 3 pour la gauche.

	/**
	 * A Faire (07/05/2021 ED Finalis�)
	 * 
	 * Constructeur permettant de cr�er une pi�ce d'un mod�le avec l'orientation 0.
	 * @param modelePiece Le mod�le de la pi�ce.
	 * @param pointEntreeHaut Un bool�en indiquant si la pi�ce a un point d'entr�e en haut.
	 * @param pointEntreeDroite Un bool�en indiquant si la pi�ce a un point d'entr�e �  droite.
	 * @param pointEntreeBas Un bool�en indiquant si la pi�ce a un point d'entr�e en bas.
	 * @param pointEntreeGauche Un bool�en indiquant si la pi�ce a un point d'entr�e �  gauche.
	 */
	public Piece(int modelePiece,boolean pointEntreeHaut,boolean pointEntreeDroite,boolean pointEntreeBas,boolean pointEntreeGauche){
		this.modelePiece = modelePiece;
		boolean[] pointEntree = new boolean[4];
		pointEntree[0] = pointEntreeHaut;
		pointEntree[1] = pointEntreeDroite;
		pointEntree[2] = pointEntreeBas;
		pointEntree[3] = pointEntreeGauche;
		this.pointsEntree = pointEntree;
		this.orientationPiece = 0;
	}
	
	/**
	 * M�thode retournant un String repr�sentant la pi�ce.
	 */
	@Override
	public String toString() {
		return "[m:"+modelePiece+"|o:"+orientationPiece+"|pe:"+pointsEntree[0]+" "+pointsEntree[1]+" "+pointsEntree[2]+" "+pointsEntree[3]+"]";
	}
	
	/**
	 * A Faire (07/05/2021 ED Finalis�)
	 * 
	 * M�thode permettant de rotationner une pi�ce dans le sens d'une horloge.
	 */
	public void rotation(){
        if (modelePiece == 1) {
            if (orientationPiece == 0) { 
            	orientationPiece = 1; 
            	pointsEntree[0] = false; 
            	pointsEntree[1] = true; 
            	pointsEntree[2] = false; 
            	pointsEntree[3] = true;
            }
            else orientationPiece = 0;
            pointsEntree[0] = true; 
        	pointsEntree[1] = false; 
        	pointsEntree[2] = true; 
        	pointsEntree[3] = false;
        }
        if (modelePiece == 0) {
            if (orientationPiece < 3) orientationPiece += 1;
            else orientationPiece = 0;
            pointsEntree[0] = false; 
        	pointsEntree[1] = true; 
        	pointsEntree[2] = true; 
        	pointsEntree[3] = false;
        	if (orientationPiece == 1) {
        		pointsEntree[0] = false; 
            	pointsEntree[1] = false; 
            	pointsEntree[2] = true; 
            	pointsEntree[3] = true;
        	}
        	if (orientationPiece == 2) {
        		pointsEntree[0] = true; 
            	pointsEntree[1] = false; 
            	pointsEntree[2] = false; 
            	pointsEntree[3] = true;
        	}
        	if (orientationPiece == 3) {
        		pointsEntree[0] = true; 
            	pointsEntree[1] = true; 
            	pointsEntree[2] = false; 
            	pointsEntree[3] = false;
        	}
        }
        if (modelePiece == 2) {
            if (orientationPiece < 3) orientationPiece += 1;
            else orientationPiece = 0;
            pointsEntree[0] = true; 
        	pointsEntree[1] = true; 
        	pointsEntree[2] = false; 
        	pointsEntree[3] = true;
        	if (orientationPiece == 1) {
        		pointsEntree[0] = true; 
            	pointsEntree[1] = true; 
            	pointsEntree[2] = true; 
            	pointsEntree[3] = false;
        	}
        	if (orientationPiece == 2) {
        		pointsEntree[0] = false; 
            	pointsEntree[1] = true; 
            	pointsEntree[2] = true; 
            	pointsEntree[3] = true;
        	}
        	if (orientationPiece == 3) {
        		pointsEntree[0] = true; 
            	pointsEntree[1] = false; 
            	pointsEntree[2] = true; 
            	pointsEntree[3] = true;
        	}
        }
    }
	
	/**
	 * A Faire (07/05/2021 ED Finalis�)
	 * 
	 * M�thode permettant d'orienter une pi�ce vers une orientation sp�cifique.
	 * @param orientationPiece Un entier correspondant �  la nouvelle orientation de la pi�ce.
	 */
	public void setOrientation(int orientationPiece){
		this.orientationPiece = orientationPiece;
	}

	/**
	 * A Faire (07/05/2021 ED Finalis�)
	 * 
	 * M�thode retournant le mod�le de la pi�ce.
	 * @return Un entier correspondant au mod�le de la pi�ce.
	 */
	public int getModelePiece() {
		return modelePiece;
	}

	/**
	 * A Faire (07/05/2021 ED Finalis�)
	 * 
	 * M�thode retournant l'orientation de la pi�ce.
	 * @return un entier retournant l'orientation de la pi�ce.
	 */
	public int getOrientationPiece() {
		return orientationPiece;
	}

	/**
	 * A Faire (07/05/2021 ED Finalis�)
	 * 
	 * M�thode indiquant si il existe un point d'entr�e �  une certaine position (0: en haut, 1: �  droite, 2: en bas, 3: �  gauche).
	 * @param pointEntree L'indice/la position du point d'entr�e.
	 * @return true si il y a un point d'entr�e, sinon false.
	 */
	public boolean getPointEntree(int pointEntree){
        return pointsEntree[pointEntree];
    }
	
	/**
	 * A Faire (07/05/2021 ED Finalis�e)
	 * 
	 * M�thode permettant de cr�er un tableau contenant toutes les pi�ces du jeu (les 50 pi�ces).
	 * Le tableau contiendra 20 pi�ces du mod�le 0, 12 pi�ces du mod�le 1 et 18 pi�ces du mod�le 2.
	 * L'orientation de chaque pi�ce sera al�atoire.
	 * @return Un tableau contenant toutes les pi�ces du jeu.
	 */
	public static Piece[] nouvellesPieces(){
		// A Compl�ter (A Faire apr�s les classes PieceM0, PieceM1 et PieceM2)
		Piece pieces[] = new Piece[50];
		for(int i=0; i<20; i++) {
			pieces[i] = new PieceM0();
			pieces[i].setOrientation(Utils.genererEntier(3));
			for(int j=0; j<4; j++) {
				pieces[i].rotation();
			}
		}
		for(int i=20; i<32; i++) {
			pieces[i] = new PieceM1();
			pieces[i].setOrientation(Utils.genererEntier(1));
			for(int j=0; j<2; j++) {
				pieces[i].rotation();
			}
		}
		for(int i=32; i<50; i++) {
			pieces[i] = new PieceM2();
			pieces[i].setOrientation(Utils.genererEntier(3));
			for(int j=0; j<4; j++) {
				pieces[i].rotation();
			}
		}
		return pieces;
	}
	
	/**
	 * M�thode permettant de cr�er une copie de la pi�ce (un nouvelle objet Java).
	 * @return Une copie de la pi�ce.
	 */
	public abstract Piece copy();
		
}