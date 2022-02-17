/**
 * 
 */
package fr.mooc.epfl.semaine4;

/**
 * @author Fernand SOUALO
 *
 */
public class Sortilege extends Carte {
	private String nom;
	private String explication;
	
	public Sortilege(int cout, String nom, String explication) {
		super(cout);
		this.nom = nom;
		this.explication = explication;
		System.out.println("Un sortilege de plus.");
	}
	
	@Override
	public void afficher() {
		String str = "Un sortilege " + nom;
		System.out.println(str);
		
	}
}
