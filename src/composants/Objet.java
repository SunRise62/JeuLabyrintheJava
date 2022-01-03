package composants;


/**
 * 
 * Cette classe permet de repr�senter chacun des objets du jeu.
 *
 */
public class Objet {

	private int numObjet; // Le num�ro de l'objet (un entier entre 0 et 17).
	private int posLignePlateau; // La ligne du plateau sur laquelle est �ventuellement pos� l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private int posColonnePlateau; // La colonne du plateau sur laquelle est �ventuellement pos� l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private boolean surPlateau; // Indique si l'objet est sur le plateau ou non (true : sur le plateau, false : hors du plateau).

	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * Constructeur permettant de construire un objet qui est initialement hors du plateau.
	 * 
	 * @param numObjet Le num�ro de l'objet.
	 */
	public Objet(int numObjet) {
		this.numObjet = numObjet;
	}

	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * M�thode permettant de g�n�rer un tableau contenant les 18 objets du jeu.
	 * Les objets seront positionn�es al�atoirement sur le plateau.  Deux objets ne pourront pas �tre sur une m�me case (m�me ligne et m�me colonne).
	 * 
	 * @return Un tableau de 18 objets initialis�s pour une partie du jeu. Chaque objet a une position g�n�r�e al�atoirement. Les positions sont diff�rentes pour deux objets distincts.
	 *
	 */
	public static Objet[] nouveauxObjets(){
		Objet objets[] = new Objet[18];
		int lignes[] = Utils.genereTabIntAleatoirement(7);
		int colonnes[] = Utils.genereTabIntAleatoirement(7);
		
		for(int i=0; i<objets.length; i++) {
			objets[i] = new Objet(i);
			objets[i].positionneObjet(lignes[Utils.genererEntier(6)],colonnes[Utils.genererEntier(6)]);
			for(int j=0; j<i; j++) {
				if((objets[i].getPosLignePlateau() == objets[j].getPosLignePlateau()) & (objets[i].getPosColonnePlateau() == objets[j].getPosColonnePlateau())) {
					objets[i].positionneObjet(lignes[Utils.genererEntier(6)],colonnes[Utils.genererEntier(6)]);
					j = 0;
				}
			}
		}
		
		return objets;
	}

	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * M�thode retournant le num�ro de l'objet.
	 * 
	 * @return Le num�ro de l'objet.
	 */
	public int getNumeroObjet() {
		return numObjet; 
	}

	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * M�thode retournant le num�ro de la ligne sur laquelle se trouve l'objet.
	 * 
	 * @return Le num�ro de la ligne sur laquelle se trouve l'objet.
	 */
	public int getPosLignePlateau() {
		return posLignePlateau; 
	}

	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * M�thode retournant le num�ro de la colonne sur laquelle se trouve l'objet.
	 * 
	 * @return Le num�ro de la colonne sur laquelle se trouve l'objet.
	 */
	public int getPosColonnePlateau() {
		return posColonnePlateau; 
	}
	
	
	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * M�thode permettant de positionner l'objet sur une ligne et une colonne donn�es en param�tre.
	 * 
	 * @param lignePlateau Un entier compris entre 0 et 6.
	 * @param colonnePlateau Un entier compris entre 0 et 6.
	 */
	public void positionneObjet(int lignePlateau,int colonnePlateau){
		this.posLignePlateau = lignePlateau;
		this.posColonnePlateau = colonnePlateau;
		surPlateau = true;
	}

	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * M�thode permettant d'enlever l'objet du plateau.
	 * 
	 */
	public void enleveDuPlateau(){
		posLignePlateau = -1;
		posColonnePlateau = -1;
		surPlateau = false;
	}
	
	/**
	 * 
	 * A Faire (16/05/2021 DV Finalis�)
	 * 
	 * M�thode indiquant si l'objet est sur le plateau au non.
	 * 
	 * @return true si l'objet est sur le plateau, false sinon.
	 */
	public boolean surPlateau() {
		if((posLignePlateau != -1) & (posColonnePlateau != -1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�thode permettant d'obtenir une repr�sentation d'un objet sous forme de cha�ne de caract�res.
	 */
	@Override
	public String toString() {
		return "Objet [numObjet=" + numObjet + ", posLignePlateau=" + posLignePlateau + ", posColonnePlateau="
				+ posColonnePlateau + ", surPlateau=" + surPlateau + "]";
	}

	/**
	 * 
	 * M�thode permettant de copier l'objet.
	 * 
	 * @return Une copie de l'objet.
	 */
	public Objet copy(){
		Objet objet=new Objet(numObjet);
		objet.posLignePlateau=posLignePlateau;
		objet.posColonnePlateau=posColonnePlateau;
		objet.surPlateau=surPlateau;
		return objet;
	}

	/**
	 * Programme testant quelques m�thodes de la classe Objet.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		System.out.println("*** G�n�ration et affichage des 18 objets ... ***");
		Objet objetsJeu[]=nouveauxObjets();
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
		System.out.println("*** On enl�ve les 18 objets du plateau ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			 objetsJeu[i].enleveDuPlateau();
		System.out.println("*** On affiche de nouveau les 18 objets ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
	}
	
}