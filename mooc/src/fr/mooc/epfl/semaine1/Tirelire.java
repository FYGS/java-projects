package fr.mooc.epfl.semaine1;

public class Tirelire {
	private double montant;
	
	public double getMontant() {
		return montant;
	}
	
	public void afficher() {
		String str = "Vous ";
		str += getMontant() <= 0.0 ? 
				"etes sans le sou." :
				"avez : " + getMontant() + " euros dans votre tirelire.";
		System.out.println(str);
	}
	
	public void secouer() {
		if (getMontant() > 0.0) {
			System.out.println("Bing bing");
		}
	}
	
	public void remplir(double montant) {
		if (montant > 0.0) {
			this.montant = montant;
		}
	}
	
	public void vider() {
		montant = 0.0;
	}
	
	public void puiser(double montant) {
		if (montant > 0.0) {
			if (montant < this.montant) {
				this.montant -= montant;
			} else {
				this.montant = 0.0;
			}
		}
	}
	
	public double calculerSolde(double budget) {
		if (budget <= 0.0) {
			return montant;
		}
		return montant - budget;
	}
}
