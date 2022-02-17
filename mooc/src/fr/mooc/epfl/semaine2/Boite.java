/**
 * 
 */
package fr.mooc.epfl.semaine2;

import fr.mooc.epfl.semaine3.Courrier;

/**
 * @author Fernand SOUALO
 *
 */
public class Boite {
	private Courrier[] courriers;
	private int index;
	
	public Boite(int taille) {
		courriers = new Courrier[taille];
		this.index = 0;
	}
	
	public void ajouterCourrier(Courrier courrier) {
		if (index < courriers.length) {
			courriers[index] = courrier;
			++index;
		} else {
			System.out.println("La boite est pleine !");
		}
	}
	
	public double affranchir() {
		double total = .0;
		for(int i = 0; i < index; i++) {
			total += courriers[i].affranchir();
		}
		return total;
	}
	
	public int courriersInvalides() {
		int nbreInvalide = 0;
		for(int i = 0; i < index; i++) {
			if (courriers[i].estInvalide()) {
				nbreInvalide += 1;
			}
		}
		return nbreInvalide;
	}
	
	public void afficher() {
		for(int i = 0; i < index; i++) {
			courriers[i].afficher();
		}
	}
}
