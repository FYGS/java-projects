/**
 * 
 */
package fr.mooc.epfl.semaine5;

/**
 * @author Fernand SOUALO
 *
 */
public class Technicien extends Employe {
	private int unite;
	
	public Technicien(String prenom, String nom, int age, String annee, int unite) {
		super(prenom, nom, age, annee);
		this.unite = unite;
	}

	@Override
	public double calculerSalaire() {
		return unite * 5.;
	}

	@Override
	public String prefix() {
		return "Le technicien ";
	}
}
