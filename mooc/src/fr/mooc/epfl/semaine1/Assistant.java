/**
 * 
 */
package fr.mooc.epfl.semaine1;

/**
 * @author Fernand SOUALO
 *
 */
public class Assistant {
	private int age;
	private int argent;
	private int resultat;
	
	public void lire(Papier papier) {
		System.out.println("[Assistant] (je lis le papier)");
		age = papier.lireAge();
		argent = papier.lireArgent();
	}
	
	public void calculerMentalement() {
		System.out.println("[Assistant] (je calcule mentalement)");
		resultat = ((age * 2 + 5) * 50 + argent) - 365;
	}
	
	public int annoncer() {
		System.out.println("[Assistant] J'annonce : " + resultat + " !");
		return resultat;
	}
}
