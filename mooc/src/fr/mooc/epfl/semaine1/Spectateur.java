/**
 * 
 */
package fr.mooc.epfl.semaine1;

import java.util.Scanner;

/**
 * @author Fernand SOUALO
 *
 */
public class Spectateur {
	private int age;
	private int argent;
	
	private final static Scanner clavier = new Scanner(System.in);
	
	public void arriver() {
		System.out.println("[Spectateur] (j'entre en scène)");
		System.out.println("Quel age ai-je ?");
		age = clavier.nextInt();
		do {
			System.out.println("Combien d'argent ai-je en poche (<100) ?");
			argent = clavier.nextInt();
		} while (argent >= 100);
		System.out.println("[Spectateur] (j'ai un montant qui convient)");
	}
	
	public void ecrire(Papier papier) {
		System.out.println("[Spectateur] (j'écris le papier)");
		papier.ecrire(age, argent);
	}
}
