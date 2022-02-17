/**
 * 
 */
package fr.mooc.epfl.semaine5;

/**
 * @author Fernand SOUALO
 *
 */
public abstract class Employe {
	private final String nom;
	private final String prenom;
	private int age;
	private String annee;
	
	public Employe(String prenom, String nom, int age, String annee) {
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
		this.annee = annee;
	}
	
	public abstract double calculerSalaire();
	
	public String getNom() {
		return prefix() + prenom + " " + nom;
	}
	
	public String prefix() {
		return "L'employé ";
	}

}
