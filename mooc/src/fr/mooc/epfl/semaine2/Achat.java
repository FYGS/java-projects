/**
 * 
 */
package fr.mooc.epfl.semaine2;

/**
 * @author Fernand SOUALO
 *
 */
public class Achat {
	private Article article;
	private int quantite;
	
	public Achat(Article article, int quantite) {
		this.article = article;
		this.quantite = quantite;
	}
	
	public void afficher() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
//		"Petit-lait : 2.5 x 6 = 7.5 Frs (1/2 prix)";
		String solde = article.isEnSolde() ? " (1/2 prix)" : "";
		String str = article.getNom() + " : " + article.getPrix();
		str += " x " + quantite + " = ";
		str += prixAchat() + " Frs" + solde;
		return str;
	}
	
	public double prixAchat() {
		double rabais = 1.;
		if (article.isEnSolde()) {
			rabais = 0.5;
		}
		return article.getPrix() * quantite * rabais;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		if (quantite >= 0) {
			this.quantite = quantite;
		}
	}
}
