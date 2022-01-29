package fr.mooc.epfl.semaine1;

public class Patient {
	private double masse;
	private double hauteur;
	
	public void init(double p, double t) {
		if (p > 0.0 && t > 0.0) {
			masse = p;
			hauteur = t;
		} else {
			masse = 0.0;
			hauteur = 0.0;
		}
	}

	public void afficher() {
		System.out.printf("Patient : %.1f kg pour %.1f m\n", masse, hauteur);
	}
	
	private double poids() {
		return masse;
	}
	
	private double taille() {
		return hauteur;
	}
	
	public double imc() {
		if (taille() == 0.0) {
			return 0.0;
		}
		return poids() / Math.pow(taille(), 2);
	}
}
