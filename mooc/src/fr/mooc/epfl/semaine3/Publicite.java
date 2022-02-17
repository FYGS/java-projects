/**
 * 
 */
package fr.mooc.epfl.semaine3;

/**
 * @author Fernand SOUALO
 *
 */
public class Publicite extends Courrier {
	public Publicite(double poids, boolean estExpress, String adresseDestination) {
		super(poids, estExpress, adresseDestination);
	}
	
	
	@Override
	public double affranchirNormal() {
		return 5.0 * poids / 1000.;
	}
	
	@Override
	public void afficher() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String str = "Publicite\n";
		str += super.toString();
		return str;
	}
}
