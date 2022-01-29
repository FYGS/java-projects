/**
 * 
 */
package fr.mooc.epfl.semaine2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Fernand SOUALO
 *
 */
public class Caisse {
	private int numero;
	private double totalCompte;
	
	public Caisse(int numero, double totalCompte) {
		this.numero = numero;
		this.totalCompte = totalCompte;
	}
	
	public void scanner(Caddie caddie) {
		double total = 0.0;
		System.out.println("=========================================");
		Date dateCourante = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
		System.out.println(formatDate.format(dateCourante));
		System.out.println("Caisse numero " + numero);
		System.out.println();
		for (int i = 0; i < caddie.nombreAchat(); i++) {
			Achat achat = caddie.getAchat(i);
			achat.afficher();
			total += achat.prixAchat();
		}
		totalCompte += total;
		System.out.println();
		System.out.println("Montant à payer :" + totalCompte + " Frs");
        System.out.println("=========================================");
	}
	
	public void totalCaisse() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "La caisse " + numero + " a encaisse " + totalCompte + " Frs aujourd'hui.";
	}
}
