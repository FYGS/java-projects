/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class Postulant {
	private final String nom;
	private int nombreElecteurs;
	
	public Postulant(String nom, int nombreElecteurs) {
		this.nom = nom;
		this.nombreElecteurs = nombreElecteurs;
	}
	
	public Postulant(String nom) {
		this(nom, 0);
	}
	
	public Postulant(Postulant autre) {
		this.nom = autre.nom;
		this.nombreElecteurs = autre.nombreElecteurs;
	}
	
	public void elect() {
		this.nombreElecteurs++;
	}
	
	public void init() {
		this.nombreElecteurs = 0;
	}
	
	public int getVotes() {
		return nombreElecteurs;
	}
	
	public String getNom() {
		return nom;
	}
}
