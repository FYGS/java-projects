/**
 * 
 */
package fr.mooc.epfl.semaine1;

/**
 * @author Fernand SOUALO
 *
 */
public class Magicien {
	private int ageDevine;
	private int argentDevine;
	
	public void tourDeMagie(Spectateur spectateur, Assistant assistant) {
		System.out.println("[Magicien] un petit tour de magie...");
		Papier papier = new Papier();
		// Les instructions du magicien
		spectateur.ecrire(papier);
		assistant.lire(papier);
		assistant.calculerMentalement();
		calculer(assistant.annoncer());
		annoncer();
	}

	private void calculer(int resultatRecu) {
		resultatRecu += 115;
		ageDevine = resultatRecu / 100;
		argentDevine = resultatRecu % 100;
	}
	
	private void annoncer() {
		System.out.print("[Magicien] - hum... je vois que vous êtes agé de ");
		System.out.println(ageDevine + " ans et que vous avez " + argentDevine + " francs suisses en poche !");
	}
}
