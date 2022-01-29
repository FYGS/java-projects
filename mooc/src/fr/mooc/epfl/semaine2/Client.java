/**
 * 
 */
package fr.mooc.epfl.semaine2;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
public class Client {
	private String nom;
	private String ville;
	private boolean estFemme;
	private ArrayList<Compte> comptes;

	public Client(String nom, String ville, boolean estFemme) {
		this.nom = nom;
		this.ville = ville;
		this.estFemme = estFemme;
		comptes = new ArrayList<>();
	}

	public void afficher() {
		System.out.println(toString());
		comptes.forEach(compte -> compte.afficher());
	}

	@Override
	public String toString() {
		String str = "Client";
		str += estFemme ? "e " : " ";
		str += nom + " de " + ville;
		return str;
	}

	public boolean addCompte(Compte compte) {
		return comptes.add(compte);
	}

	public Compte getCompte(int index) {
		if (index >= 0 && index < comptes.size()) {
			return comptes.get(index);
		}
		return null;
	}

	public boolean removeCompte(Compte compte) {
		if (comptes.contains(compte)) {
			return comptes.remove(compte);
		}
		return false;
	}

	public void bouclerComptes() {
		comptes.forEach(c -> c.boucler());
	}
}
