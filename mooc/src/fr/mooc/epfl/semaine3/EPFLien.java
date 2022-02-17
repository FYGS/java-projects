/**
 * 
 */
package fr.mooc.epfl.semaine3;

/**
 * @author Fernand SOUALO
 *
 */
public abstract class EPFLien {
	protected String nom;
	protected int annee;
	
	public EPFLien(String nom, int annee) {
		this.nom = nom;
		this.annee = annee;
	}
	
	public void afficher() {
		System.out.print(this);
	}
	
	public boolean estEtudiant() {
		return false;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "  Nom : " + nom + "\n";
		str += "  Annee : " + annee + "\n";
		return str;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}
}
