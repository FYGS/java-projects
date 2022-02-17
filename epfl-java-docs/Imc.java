/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
public class Patient {
	private double masse;
	private double hauteur;
	
	public void init(double p, double t) {
		if (p >= 0.0 && t >= 0.0) {
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
	
	public double poids() {
		return masse;
	}
	
	public double taille() {
		return hauteur;
	}
	
	public double imc() {
		if (taille() == 0.0) {
			return 0.0;
		}
		return poids() / Math.pow(taille(), 2);
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}