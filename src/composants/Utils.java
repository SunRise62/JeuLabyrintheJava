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
	 * A Faire (07/05/2021 TD Finalisée)
	 * 
	 * Méthode permettant de générer aléatoirement un nombre entier.
	 * 
	 * @param max Le nombre entier maximal pouvant etre retourné.
	 * @return Un nombre entier compris entre 0 et max (inclus).
	 */
	public static int genererEntier(int max){
		int value = generateur.nextInt(max);
        return value;
	}
	/**
	 * A Faire (10/05/2021 ED Finalisée)
	 * 
	 * Méthode permettant de générer un tableau d'entiers dont la longueur longTab est donnée en paramètre.
	 * Le tableau généré doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
	 * dans le tableau doit être aléatoire.
	 * 
	 * @param longTab La longueur du tableau.
	 * @return Un tableau contenant les entiers 0,...,longTab-1 placés aléatoirement dans le tableau.
	 */
	public static void swap(int[] tab, int i, int j) {
		   int c = tab[i];
		   tab[i] = tab[j];
		   tab[j] = c;
	}
	public static int[] genereTabIntAleatoirement(int longTab){
		int tab[]= new int[longTab]; //création du tableau d'entier
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
	 * Programme testant la mÃ©thode genereTabIntAleatoirement.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		int tab[]=genereTabIntAleatoirement(18);
		for (int i=0;i<tab.length;i++)
			System.out.print(tab[i]+" ");

	}

}