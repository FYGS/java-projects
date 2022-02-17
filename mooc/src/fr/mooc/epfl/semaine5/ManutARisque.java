/**
 * 
 */
package fr.mooc.epfl.semaine5;


/**
 * @author Fernand SOUALO
 *
 */
public class ManutARisque extends Manutentionnaire implements ARisque {
	public ManutARisque(String prenom, String nom, int age, String annee, int heure) {
		super(prenom, nom, age, annee, heure);
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}
}
