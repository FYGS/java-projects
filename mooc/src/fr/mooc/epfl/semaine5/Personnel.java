/**
 * 
 */
package fr.mooc.epfl.semaine5;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
public class Personnel {
	private ArrayList<Employe> employes;
	
	public Personnel() {
		employes = new ArrayList<Employe>();
	}
	
	public void ajouterEmploye(Employe e) {
		if (e != null) {
			employes.add(e);
		}
	}
	
	public void afficherSalaires() {
		for (Employe empl : employes) {
			String str = empl.getNom();
			str += " gagne " + empl.calculerSalaire() + " francs.";
			System.out.println(str);
		}
	}
	
	public int taille() {
		return employes.size();
	}
	
	public double salaireMoyen() {
		double somme = 0.;
		for (Employe empl : employes) {
			somme += empl.calculerSalaire();
		}
		
		return somme / taille();
	}
}
