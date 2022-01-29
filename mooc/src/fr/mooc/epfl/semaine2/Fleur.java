/**
 * 
 */
package fr.mooc.epfl.semaine2;

/**
 * @author Fernand SOUALO
 *
 */
public class Fleur {
	@SuppressWarnings("unused")
	private String nom;
	private String couleur;
	
	public Fleur(String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
		System.out.println(nom + " fraichement cueillie");
	}
	
	public Fleur(Fleur autreFleur) {
		couleur = autreFleur.couleur;
		System.out.print("Fragile corolle taillée ");
	}
	
	public void eclore() {
		System.out.println("veiné de " + couleur);
	}
	
	@Override
	public String toString() {
		return "qu'un simple souffle";
	}
}
