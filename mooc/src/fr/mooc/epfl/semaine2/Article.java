/**
 * 
 */
package fr.mooc.epfl.semaine2;

/**
 * @author Fernand SOUALO
 *
 */
public class Article {
	private String nom;
	private double prix;
	private boolean enSolde;
	
	public Article(String nom, double prix, boolean enSolde) {
		this.nom = nom;
		this.prix = prix;
		this.enSolde = enSolde;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		if (prix >= 0.0) {
			this.prix = prix;
		}
	}

	/**
	 * @return the enSolde
	 */
	public boolean isEnSolde() {
		return enSolde;
	}

	/**
	 * @param enSolde the enSolde to set
	 */
	public void setEnSolde(boolean enSolde) {
		this.enSolde = enSolde;
	}
	
}
