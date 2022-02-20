/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class Programmeur extends Employe {
	public static final int FACTEUR_GAIN_PROJETS = 200;
	
	private int nombreProjetsAcheves;
	
	public Programmeur(String nom, int revenu, int nombreProjetsAcheves, int taux) {
		super(nom, revenu, taux);
		this.nombreProjetsAcheves = nombreProjetsAcheves;
	}
	
	public int getNombreProjetsAcheves() {
		return nombreProjetsAcheves;
	}
	
	@Override
	public String toString() {
		String str  = super.toString();
		       str += "  A mené à bien " +  getNombreProjetsAcheves() + " projets\n";
		return str;
	}
	
	@Override
	protected String newEmployeStr() {
		return super.newEmployeStr() + ", c'est un programmeur.";
	}
	
	@Override
	protected double salaireBase() {
		double salaire = super.salaireBase();
		       salaire += FACTEUR_GAIN_PROJETS * nombreProjetsAcheves;
		return salaire;
	}
}
