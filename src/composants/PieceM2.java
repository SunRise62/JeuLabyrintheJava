package composants;
/**
 * Cette classe permet de représenter les pièces du jeu de modèle 2.
 */
public class PieceM2 extends Piece {
    /**
     * A Faire (07/05/2021 TD Finalisée)
     * 
     * Constructeur permettant de construire une pièce de modèle 2 et d'orientation 0.
     */
    public PieceM2() {
        super(2,true,true,false,true); 
    }
    
    /**
     * A Faire (07/05/2021 TD Finalisée)
     * 
     * Méthode permettant de créer une copie de la pièce (un nouvel objet Java).
     * @return Une copie de la pièce.
     */
    public Piece copy(){
        Piece piece = new PieceM2();
        piece.setOrientation(this.getOrientationPiece());
        return piece;
    }
}