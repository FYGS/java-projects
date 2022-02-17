/**
 * 
 */
package fr.mooc.epfl.semaine5;

/**
 * @author Fernand SOUALO
 *
 */
public class Representant extends EmployeAChiffreAffaire {
	public final static int BASE = 800;
	public Representant(String prenom, String nom, int age, String annee, int chiffreAffaire) {
		super(prenom, nom, age, annee, chiffreAffaire);
	}
	
	@Override
	public double calculerSalaire() {
		double salaire = super.calculerSalaire();
		salaire += BASE;
		return salaire;
	}
	
	@Override
	public String prefix() {
		// TODO Auto-generated method stub
		return "Le représentant ";
	}

}
