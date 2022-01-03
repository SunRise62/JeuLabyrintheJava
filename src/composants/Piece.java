package composants;

/**
 * 
 * Cette classe permet de représenter les différentes pièces du jeu.
 * 
 */
abstract public class Piece {

	private int modelePiece; 		// Le modèle de la pièce
	private int orientationPiece; 	// L'orientation de la pièce
	private boolean[] pointsEntree; // Les points d'entrée indice 0 pour le haut, 1 pour la droite, 2 pour le bas et 3 pour la gauche.

	/**
	 * A Faire (07/05/2021 ED Finalisé)
	 * 
	 * Constructeur permettant de créer une pièce d'un modèle avec l'orientation 0.
	 * @param modelePiece Le modèle de la pièce.
	 * @param pointEntreeHaut Un booléen indiquant si la pièce a un point d'entrée en haut.
	 * @param pointEntreeDroite Un booléen indiquant si la pièce a un point d'entrée Ã  droite.
	 * @param pointEntreeBas Un booléen indiquant si la pièce a un point d'entrèe en bas.
	 * @param pointEntreeGauche Un booléen indiquant si la pièce a un point d'entrèe Ã  gauche.
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
	 * Méthode retournant un String représentant la pièce.
	 */
	@Override
	public String toString() {
		return "[m:"+modelePiece+"|o:"+orientationPiece+"|pe:"+pointsEntree[0]+" "+pointsEntree[1]+" "+pointsEntree[2]+" "+pointsEntree[3]+"]";
	}
	
	/**
	 * A Faire (07/05/2021 ED Finalisé)
	 * 
	 * Méthode permettant de rotationner une pièce dans le sens d'une horloge.
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
	 * A Faire (07/05/2021 ED Finalisé)
	 * 
	 * Méthode permettant d'orienter une pièce vers une orientation spécifique.
	 * @param orientationPiece Un entier correspondant Ã  la nouvelle orientation de la pièce.
	 */
	public void setOrientation(int orientationPiece){
		this.orientationPiece = orientationPiece;
	}

	/**
	 * A Faire (07/05/2021 ED Finalisé)
	 * 
	 * Méthode retournant le modèle de la pièce.
	 * @return Un entier correspondant au modèle de la pièce.
	 */
	public int getModelePiece() {
		return modelePiece;
	}

	/**
	 * A Faire (07/05/2021 ED Finalisé)
	 * 
	 * Méthode retournant l'orientation de la pièce.
	 * @return un entier retournant l'orientation de la pièce.
	 */
	public int getOrientationPiece() {
		return orientationPiece;
	}

	/**
	 * A Faire (07/05/2021 ED Finalisé)
	 * 
	 * Méthode indiquant si il existe un point d'entrée Ã  une certaine position (0: en haut, 1: Ã  droite, 2: en bas, 3: Ã  gauche).
	 * @param pointEntree L'indice/la position du point d'entrée.
	 * @return true si il y a un point d'entrée, sinon false.
	 */
	public boolean getPointEntree(int pointEntree){
        return pointsEntree[pointEntree];
    }
	
	/**
	 * A Faire (07/05/2021 ED Finalisée)
	 * 
	 * Méthode permettant de créer un tableau contenant toutes les pièces du jeu (les 50 pièces).
	 * Le tableau contiendra 20 pièces du modèle 0, 12 pièces du modèle 1 et 18 pièces du modèle 2.
	 * L'orientation de chaque pièce sera aléatoire.
	 * @return Un tableau contenant toutes les pièces du jeu.
	 */
	public static Piece[] nouvellesPieces(){
		// A Compléter (A Faire après les classes PieceM0, PieceM1 et PieceM2)
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
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public abstract Piece copy();
		
}