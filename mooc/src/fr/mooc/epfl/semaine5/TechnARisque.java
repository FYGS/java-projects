/**
 * 
 */
package fr.mooc.epfl.semaine5;


/**
 * @author Fernand SOUALO
 *
 */
public class TechnARisque extends Technicien implements ARisque {
	public TechnARisque(String prenom, String nom, int age, String annee, int unite) {
		super(prenom, nom, age, annee, unite);
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}

}
