/**
 * 
 */
package fr.mooc.epfl.semaine2;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
public class Caddie {
	private ArrayList<Achat> achats;
	
	public Caddie() {
		achats = new ArrayList<>();
	}
	
	public boolean remplir(Article article, int quantite) {
		Achat achat = new Achat(article, quantite);
		return achats.add(achat);
	}
	
	public Achat getAchat(int index) {
		if (index >= 0 && index < nombreAchat()) {
			return achats.get(index);
		}
		return null;
	}
	
	public int nombreAchat() {
		return achats.size();
	}
}
