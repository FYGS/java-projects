/**
 * 
 */
package fr.mooc.epfl.semaine4;

/**
 * @author Fernand SOUALO
 *
 */
public abstract class Carte {
	private int cout;
	
	public Carte(int cout) {
		this.cout = cout;
	}
	
	public abstract void afficher();
}
