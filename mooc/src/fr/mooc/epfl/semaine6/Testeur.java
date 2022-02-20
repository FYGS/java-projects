/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class Testeur extends Employe {
	public static final int FACTEUR_GAIN_ERREURS = 10;
	
	private int nombreErreursCorriges;
	
	public Testeur(String nom, int revenu, int nombreErreursCorriges, int taux) {
		super(nom, revenu, taux);
		this.nombreErreursCorriges = nombreErreursCorriges;
	}
	
	public int getNombreErreursCorriges() {
		return nombreErreursCorriges;
	}
	
	@Override
	public String toString() {
		String str  = super.toString();
	       str += "  A corrigé " +  getNombreErreursCorriges() + " erreurs.\n";
	return str;
	}
	
	@Override
	protected String newEmployeStr() {
		return super.newEmployeStr() + ", c'est un testeur.";
	}
	
	@Override
	protected double salaireBase() {
		double salaire = super.salaireBase();
		       salaire += FACTEUR_GAIN_ERREURS * nombreErreursCorriges;
		return salaire;
	}
}
