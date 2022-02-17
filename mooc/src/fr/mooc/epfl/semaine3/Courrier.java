/**
 * 
 */
package fr.mooc.epfl.semaine3;

/**
 * @author Fernand SOUALO
 *
 */
public abstract class Courrier {
	protected double poids;
	protected boolean estExpress;
	protected String adresseDestination;
	
	public Courrier(double poids, boolean estExpress, String adresseDestination) {
		this.poids = poids;
		this.estExpress = estExpress;
		this.adresseDestination = adresseDestination;
	}
	
	public abstract void afficher();
	
	public abstract double affranchirNormal();
	
	public double affranchir() {
		double prix = .0;
		if (!estInvalide()) {
			prix = affranchirNormal();
			if (estExpress) {
				prix *= 2;
			}
		}
		return prix;
	}
	
	
	public boolean estInvalide() {
		return adresseDestination.isEmpty();
	}
	
	@Override
	public String toString() {
		String expressStr = estExpress ? "oui" : "non";
		String str = estInvalide() ? "(Courrier invalide)\n" : "";
		str += "  Poids : " + poids + " grammes\n";
		str += "  Express : " + expressStr + "\n";
		str += "  Destination : " + adresseDestination + "\n";
		str += "  Prix : " + affranchir() + " CHF\n";
		return str;
	}
}
