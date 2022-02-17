/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;
import java.util.Collections;

class Vehicule implements Comparable<Vehicule> {
	private final String nom;
	private double vitesseMax;
	private int poids;
	private int niveauCarburant;
	
	public Vehicule() {
		this.nom = "Anonyme";
		this.vitesseMax = 130.;
		this.poids = 1000;
		this.niveauCarburant = 0;
	}
	
	public Vehicule(String nom, double vitesseMax, int poids, int niveauCarburant) {
		this.nom = nom;
		this.vitesseMax = vitesseMax;
		this.poids = poids;
		this.niveauCarburant = niveauCarburant;
	}
	
	@Override
	public String toString() {
		String str = nom + " -> vitesse max = ";
		       str += vitesseMax + " km/h, poids = ";
		       str += poids + " kg";
		return str;
	}
	
	public boolean meilleur(Vehicule autreVehicule) {
		return autreVehicule != null
			   && performance() > autreVehicule.performance();
	}
	
	private double performance() {
		return vitesseMax / poids;
	}
	
	public boolean estDeuxRoues() {
		return false;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the vitesseMax
	 */
	public double getVitesseMax() {
		return vitesseMax;
	}

	/**
	 * @return the poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * @return the niveauCarburant
	 */
	public int getCarburant() {
		return niveauCarburant;
	}
	
	public void setCarburant(int niveau) {
		if (niveau >= 0) {
			niveauCarburant = niveau;
		}
	}

	@Override
	public int compareTo(Vehicule o) {
		if (performance() > o.performance()) {
			return 1;
		}
		if (performance() < o.performance()) {
			return -1;
		}
		return 0;
	}
}

class Voiture extends Vehicule {
	private String categorie;
	
	public Voiture(String nom, double vitesseMax, int poids, int niveauCarburant, String categorie) {
		super(nom, vitesseMax, poids, niveauCarburant);
		this.categorie = categorie;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		       str += ", Voiture de " + categorie;
		return str;
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}
}

class Moto extends Vehicule {
	private boolean aSideCar;
	
	public Moto(String nom, double vitesseMax, int poids, int niveauCarburant, boolean aSideCar) {
		super(nom, vitesseMax, poids, niveauCarburant);
		this.aSideCar = aSideCar;
	}
	
	public Moto(String nom, double vitesseMax, int poids, int niveauCarburant) {
		super(nom, vitesseMax, poids, niveauCarburant);
		this.aSideCar = false;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		       str += ", Moto" + (aSideCar ? ", avec sidecar" : "");
		return str;
	}
	
	@Override
	public boolean estDeuxRoues() {
		if (!aSideCar) {
			return true;
		}
		return super.estDeuxRoues();
	}
}

class GrandPrix extends Rallye {
	private ArrayList<Vehicule> vehicules;
	
	public GrandPrix() {
		super();
		vehicules = new ArrayList<Vehicule>();
	}
	
	public void ajouter(Vehicule v) {
		vehicules.add(v);
	}
	
	public void run(int tours) {
		if (!check()) {
			System.out.println("Pas de Grand Prix");
			return;
		}
		
		for (int t = tours; t > 0; --t) {	
            if (isEmpty()) {
                System.out.println("Elimination de tous les vehicules");
                return;
            }
            			
			for (int i = 0; i < vehicules.size(); ++i) {
				Vehicule v = vehicules.get(i);
				v.setCarburant(v.getCarburant() - 1);
				if (v.getCarburant() <= 0) {
					vehicules.remove(v);
				}
			}
		}
		
		if (isEmpty()) {
			System.out.println("Elimination de tous les vehicules");
			return;
		}
		
		Vehicule meilleur = Collections.max(vehicules);
		
		System.out.println("Le gagnant du grand prix est :");
		System.out.println(meilleur);
	}

	@Override
	public boolean check() {
		boolean first = vehicules.get(0).estDeuxRoues();
		for (Vehicule v: vehicules) {
			if (v.estDeuxRoues() != first) {
				return false;
			}
		}
		return true;
	}

    private boolean isEmpty() {
        return vehicules.size() == 0;
    }
	
}

abstract class Rallye {
	public abstract boolean check();
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

    public static void main(String[] args) {

        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

        // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3

        // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4
    }
}
