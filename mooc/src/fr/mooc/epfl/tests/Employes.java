/**
 * 
 */
package fr.mooc.epfl.tests;

/**
 * @author Fernand SOUALO
 *
 */

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

 class Employe {
	public static final int TAUX_DEFAULT = 100;
	public static final int NOMBRE_TENTATIVES = 5;
	
	private final String nom;
	private double revenu;
	private int taux;
	private double prime;
	
	public Employe(String nom, double revenu, int taux) {
		this.nom = nom;
		this.revenu = revenu;
		if (taux < 10) {
			this.taux = 10;
		}
		else if (taux > 100) {
			this.taux = 100;
		}
		else {			
			this.taux = taux;
		}
		this.prime = 0.;
		
		System.out.println(newEmployeStr());
	}
	
	public Employe(String nom, double revenu) {
		this(nom, revenu, TAUX_DEFAULT);
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getTaux() {
		return taux;
	}
	
	public double getPrime() {
		return prime;
	}
	
	public double getRevenu() {
		return revenu;
	}
	
	public void setPrime(double prime) {
		if (isPrimeAllowed(prime)) {
			this.prime = prime;
		}
	}
	
	public double revenuAnnuel() {
		double base  = 12 * getRevenu() * getTaux() * 1.0 / 100;
	       base += getPrime();
	    return base;
	}
	
	public void demandePrime() {
		Scanner sc = new Scanner(System.in);
		int tentatives = 1;
		
		do {
			System.out.println("Montant de la prime souhaitée par " + getNom() + " ?");
			if (tentatives > 1) {
				sc.nextLine();
			}
			setPrime(readDouble(sc));
			++tentatives;
		} while (getPrime() == 0. && tentatives <= NOMBRE_TENTATIVES);
	}
	
	@Override
	public String toString() {
		String str  = getNom() + " :\n";
			   str += "  Taux d'occupation : " + getTaux() + "%. ";
			   str += "Salaire annuel : " + String.format("%.2f", revenuAnnuel());
			   str += " francs";
			   str += hasPrime() ? ", Prime : " + String.format("%.2f", getPrime()) + ".\n" : ".\n";
		return str;
	}
	
	protected String newEmployeStr() {
		return "Nous avons un nouvel employé : " + getNom() + ",";
	}
	
	private boolean hasPrime() {
		return getPrime() != 0.;
	}
	
	private boolean isPrimeAllowed(double prime) {
		return prime <= (0.02 * revenuAnnuel());
	}
	
	private double readDouble(Scanner sc) {
		double d = 0.;
		
		try {
			d = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("Vous devez introduire un nombre!");
		}
		if (!isPrimeAllowed(d)) {
			System.err.println("Trop cher!");
		}
		return d;
	}
	
}

class Manager extends Employe {
	public static final int FACTEUR_GAIN_CLIENT = 500;
	public static final int FACTEUR_GAIN_VOYAGE = 100;
	
	private int joursVoyages;
	private int nombreClients;
	
	public Manager(String nom, double revenu, int joursVoyages, int nombreClients, int taux) {
		super(nom, revenu, taux);
		this.joursVoyages = joursVoyages;
		this.nombreClients = nombreClients;
	}
	
	public Manager(String nom, double revenu, int joursVoyages, int nombreClients) {
		super(nom, revenu);
		this.joursVoyages = joursVoyages;
		this.nombreClients = nombreClients;
	}
	
	public int getJoursVoyages() {
		return joursVoyages;
	}
	
	public int getNombreClients() {
		return nombreClients;
	}
	
	@Override
	public String toString() {
		String str  = super.toString();
		       str += "  A voyagé " + getJoursVoyages() + " jours et apporté ";
		       str += getNombreClients() + " nouveaux clients.\n";
		return str;
	}
	@Override
	protected String newEmployeStr() {
		return super.newEmployeStr() + " c'est un manager.";
	}
	
	@Override
	public double revenuAnnuel() {
		double salaire = super.revenuAnnuel();
	       salaire += FACTEUR_GAIN_CLIENT * nombreClients;
	       salaire += FACTEUR_GAIN_VOYAGE * joursVoyages;
	    return salaire;
	}
}

class Programmeur extends Employe {
	public static final int FACTEUR_GAIN_PROJETS = 200;
	
	private int nombreProjetsAcheves;
	
	public Programmeur(String nom, double revenu, int nombreProjetsAcheves, int taux) {
		super(nom, revenu, taux);
		this.nombreProjetsAcheves = nombreProjetsAcheves;
	}
	
	public Programmeur(String nom, double revenu, int nombreProjetsAcheves) {
		super(nom, revenu);
		this.nombreProjetsAcheves = nombreProjetsAcheves;
	}
	
	public int getNombreProjetsAcheves() {
		return nombreProjetsAcheves;
	}
	
	@Override
	public String toString() {
		String str  = super.toString();
		       str += "  A mené à bien " +  getNombreProjetsAcheves() + " projet" + (getNombreProjetsAcheves() > 1 ? "s\n" : "\n");
		return str;
	}
	
	@Override
	protected String newEmployeStr() {
		return super.newEmployeStr() + " c'est un programmeur.";
	}
	
	@Override
	public double revenuAnnuel() {
		double salaire = super.revenuAnnuel();
	       salaire += FACTEUR_GAIN_PROJETS * nombreProjetsAcheves;
	    return salaire;
	}
}

class Testeur extends Employe {
	public static final int FACTEUR_GAIN_ERREURS = 10;
	
	private int nombreErreursCorriges;
	
	public Testeur(String nom, double revenu, int nombreErreursCorriges, int taux) {
		super(nom, revenu, taux);
		this.nombreErreursCorriges = nombreErreursCorriges;
	}
	
	public Testeur(String nom, double revenu, int nombreErreursCorriges) {
		super(nom, revenu);
		this.nombreErreursCorriges = nombreErreursCorriges;
	}
	
	public int getNombreErreursCorriges() {
		return nombreErreursCorriges;
	}
	
	@Override
	public String toString() {
		String str  = super.toString();
	       str += "  A corrigé " +  getNombreErreursCorriges() + " erreurs.\n";
	return str;
	}
	
	@Override
	protected String newEmployeStr() {
		return super.newEmployeStr() + " c'est un testeur.";
	}
	
	@Override
	public double revenuAnnuel() {
		double salaire = super.revenuAnnuel();
	       salaire += FACTEUR_GAIN_ERREURS * nombreErreursCorriges;
	    return salaire;
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Employes {
    public static void main(String[] args) {

        List<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4 ));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124, 50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2
    }
}