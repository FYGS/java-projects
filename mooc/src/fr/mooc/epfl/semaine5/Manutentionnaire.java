/**
 * 
 */
package fr.mooc.epfl.semaine5;

/**
 * @author Fernand SOUALO
 *
 */
public class Manutentionnaire extends Employe {

private int heure;
	
	public Manutentionnaire(String prenom, String nom, int age, String annee, int heure) {
		super(prenom, nom, age, annee);
		this.heure = heure;
	}

	@Override
	public double calculerSalaire() {
		return heure * 65.;
	}

	@Override
	public String prefix() {
		return "Le manut. ";
	}

}
