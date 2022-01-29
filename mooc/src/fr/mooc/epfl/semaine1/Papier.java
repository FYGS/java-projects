/**
 * 
 */
package fr.mooc.epfl.semaine1;

/**
 * @author Fernand SOUALO
 *
 */
public class Papier {
	private int age;
	private int argent;

	public void ecrire(int age, int argent) {
		this.age = age;
		this.argent = argent;
	}
	
	public int lireAge() {
		return age;
	}
	
	public int lireArgent() {
		return argent;
	}
}
