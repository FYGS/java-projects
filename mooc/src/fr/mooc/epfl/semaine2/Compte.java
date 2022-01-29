/**
 * 
 */
package fr.mooc.epfl.semaine2;

/**
 * @author Fernand SOUALO
 *
 */
public class Compte {
	protected double taux;
	protected double solde;
	protected String nom;

	public Compte(String nom, double solde, double taux) {
		this.nom = nom;
		this.solde = solde;
		this.taux = taux;
	}

	protected void afficher() {
		System.out.println(toString());
	}

	@Override
	public String toString() {

		return "   Compte " + nom + ":     " + solde + " francs";
	}

	public double boucler() {
		setSolde(solde * (1 + taux));
		return solde;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		if (solde > 0.0) {
			this.solde = solde;
		} else {
			this.solde = 0.0;
		}
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

}
