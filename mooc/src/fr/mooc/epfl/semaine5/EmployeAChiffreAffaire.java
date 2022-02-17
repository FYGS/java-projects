/**
 * 
 */
package fr.mooc.epfl.semaine5;


/**
 * @author Fernand SOUALO
 *
 */
public class EmployeAChiffreAffaire extends Employe implements AChiffreDAffaire {
	private int chiffreAffaire;

	public EmployeAChiffreAffaire(String prenom, String nom, int age, String annee, int chiffreAffaire) {
		super(prenom, nom, age, annee);
		this.chiffreAffaire = chiffreAffaire;
	}

	@Override
	public double calculerSalaire() {
		return POURCENTAGE * chiffreAffaire;
	}

}
