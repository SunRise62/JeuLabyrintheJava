package composants;

import java.util.Date;
import java.util.Random;

/**
 * 
 * Classe contenant quelques fonctions utilitaires.
 * 
 */
public class Utils {
	
	private static Random generateur=new Random((new Date().getTime()));

	/**
	 * A Faire (07/05/2021 TD Finalis�e)
	 * 
	 * M�thode permettant de g�n�rer al�atoirement un nombre entier.
	 * 
	 * @param max Le nombre entier maximal pouvant etre retourn�.
	 * @return Un nombre entier compris entre 0 et max (inclus).
	 */
	public static int genererEntier(int max){
		int value = generateur.nextInt(max);
        return value;
	}
	/**
	 * A Faire (10/05/2021 ED Finalis�e)
	 * 
	 * M�thode permettant de g�n�rer un tableau d'entiers dont la longueur longTab est donn�e en param�tre.
	 * Le tableau g�n�r� doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
	 * dans le tableau doit �tre al�atoire.
	 * 
	 * @param longTab La longueur du tableau.
	 * @return Un tableau contenant les entiers 0,...,longTab-1 plac�s al�atoirement dans le tableau.
	 */
	public static void swap(int[] tab, int i, int j) {
		   int c = tab[i];
		   tab[i] = tab[j];
		   tab[j] = c;
	}
	public static int[] genereTabIntAleatoirement(int longTab){
		int tab[]= new int[longTab]; //cr�ation du tableau d'entier
		//Random generateur=new Random((new Date().getTime())); 
		for(int i = 0; i<longTab; i++) {
			tab[i] = i;
		}
		for(int i = 0; i<longTab; i++) {
			int j = genererEntier(longTab);
			swap(tab,i,j);
		}
		
		return tab;
	}
	
	/**
	 * Programme testant la méthode genereTabIntAleatoirement.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		int tab[]=genereTabIntAleatoirement(18);
		for (int i=0;i<tab.length;i++)
			System.out.print(tab[i]+" ");

	}

}