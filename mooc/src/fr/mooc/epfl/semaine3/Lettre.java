/**
 * 
 */
package fr.mooc.epfl.semaine3;

/**
 * @author Fernand SOUALO
 *
 */
public class Lettre extends Courrier {
	private Format format;
	
	public Lettre(double poids, boolean estExpress, String adresseDestination, Format format) {
		super(poids, estExpress, adresseDestination);
		this.format = format;
	}
	
	@Override
	public double affranchirNormal() {
		double tarifDeBase = format == Format.A4 ? 2.50 : 3.50;
		return tarifDeBase + 1.0 * poids / 1000.;
	}
	
	@Override
	public void afficher() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String str = "Lettre\n";
		str += super.toString();
		str += "  Format : " + format + "\n";
		return str;
	}
}
