/**
 * 
 */
package fr.mooc.epfl.semaine3;

/**
 * @author Fernand SOUALO
 *
 */
public class Colis extends Courrier {
	private double volume;
	
	public Colis(double poids, boolean estExpress, String adresseDestination, double volume) {
		super(poids, estExpress, adresseDestination);
		this.volume = volume;
	}
	
	@Override
	public double affranchir() {
		double prix = .0;
		if (!estInvalide()) {
			prix = .25 * volume + 1.0 * poids / 1000.;
			if (estExpress) {
				prix *= 2;
			}
		}
		return prix;
	}
	
	@Override
	public double affranchirNormal() {
		return .25 * volume + 1.0 * poids;
	}
	
	@Override
	public void afficher() {
		System.out.println(this);
	}
	
	@Override
	public boolean estInvalide() {
		return super.estInvalide() || volume > 50.0;
	}
	
	@Override
	public String toString() {
		String str = "Colis\n";
		str += super.toString();
		str += "  Volume : " + volume + " litres\n";
		return str;
	}
}
