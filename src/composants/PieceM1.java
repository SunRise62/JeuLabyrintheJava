package composants;
/**
 * Cette classe permet de repr�senter les pi�ces du jeu de mod�le 1.
 */
public class PieceM1 extends Piece {
    /**
     * A Faire (07/05/2021 TD Finalis�e)
     * 
     * Constructeur permettant de construire une pi�ce de mod�le 1 et d'orientation 0.
     */
    public PieceM1() {
        super(1,true,false,true,false); 
    }
    
    /**
     * A Faire (07/05/2021 TD Finalis�e)
     * 
     * M�thode permettant de cr�er une copie de la pi�ce (un nouvel objet Java).
     * @return Une copie de la pi�ce.
     */
    public Piece copy(){
        Piece piece = new PieceM1();
        piece.setOrientation(this.getOrientationPiece());
        return piece;
    }
}