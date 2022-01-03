package composants;
/**
 * Cette classe permet de représenter les pièces du jeu de modèle 0.
 */
public class PieceM0 extends Piece {
    /**
     * A Faire (07/05/2021 TD Finalisée)
     * 
     * Constructeur permettant de construire une pièce de modèle 0 et d'orientation 0.
     */
    public PieceM0(){
        super(0,false,true,true,false); 
    }
    
    /**
     * A Faire (07/05/2021 TD Finalisée)
     * 
     * Méthode permettant de créer une copie de la pièce (un nouvel objet Java).
     * @return Une copie de la pièce.
     */
    public Piece copy(){
        Piece piece = new PieceM0();
        piece.setOrientation(this.getOrientationPiece());
        return piece;
    }
}