/**
 * 
 */
package fr.mooc.epfl.semaine5;

/**
 * @author Fernand SOUALO
 *
 */
public class Vendeur extends EmployeAChiffreAffaire {
	public final static int BASE = 400;
	public Vendeur(String prenom, String nom, int age, String annee, int chiffreAffaire) {
		super(prenom, nom, age, annee, chiffreAffaire);
	}
	
	@Override
	public String prefix() {
		// TODO Auto-generated method stub
		return "Le vendeur ";
	}
	
	@Override
	public double calculerSalaire() {
		double salaire = super.calculerSalaire();
		salaire += BASE;
		return salaire;
	}

}
