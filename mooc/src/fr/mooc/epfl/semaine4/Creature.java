/**
 * 
 */
package fr.mooc.epfl.semaine4;

/**
 * @author Fernand SOUALO
 *
 */
public class Creature extends Carte {
	private String nom;
	private int degats;
	private int vie;
	
	public Creature(int cout, String nom, int degats, int vie) {
		super(cout);
		this.nom = nom;
		this.degats = degats;
		this.vie = vie;
		System.out.println("Une nouvelle creature.");
	}
	
	@Override
	public void afficher() {
		String str = "Une creature " + nom + " " + degats + "/" + vie;
		System.out.println(str);
		
	}
}
