/**
 * 
 */
package fr.mooc.epfl.semaine4;

/**
 * @author Fernand SOUALO
 *
 */
public class Jeu {
	private Carte[] cartes;
	private int tailleMax;
	private int index;
	
	public Jeu(int tailleMax) {
		cartes = new Carte[tailleMax];
		this.tailleMax = tailleMax;
		index = 0;
		System.out.println("On change de main");
	}
	
	public void piocher(Carte carte) {
		if (index < tailleMax) {
			cartes[index] = carte;
			index++;
		}
		else {
			System.out.println("Jeu impossible");
		}
	}
	
	public void afficher() {
		for (int i = 0; i < index; i++) {
			cartes[i].afficher();
		}
	}
	
	public void joue() {
		System.out.println("Je joue une carte...");
		int i = 0;
		while (cartes[i] == null && i < index) {
			i++;
		}
		
		if (index > 0) {
			System.out.println("La carte jouee est :");
			cartes[i].afficher();
			cartes[i] = null;
		}
		else {
			System.out.println("Plus de cartes");
		}
	}
}
