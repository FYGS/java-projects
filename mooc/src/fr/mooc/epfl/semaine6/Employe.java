/**
 * 
 */
package fr.mooc.epfl.semaine6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Fernand SOUALO
 *
 */
public class Employe {
	public static final int TAUX_DEFAULT = 100;
	public static final int NOMBRE_TENTATIVES = 5;
	
	private final String nom;
	private int revenu;
	private int taux;
	private double prime;
	
	public Employe(String nom, int revenu, int taux) {
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
	
	public Employe(String nom, int revenu) {
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
	
	public void setPrime(double prime) {
		if (isPrimeAllowed(prime)) {
			this.prime = prime;
		}
	}
	
	public double revenuAnnuel() {
		return salaireBase();
	}
	
	public void demandePrime() {
		Scanner sc = new Scanner(System.in);
		int tentatives = 1;
		
		do {
			System.out.println("Montant de la prime souhaitée par " + getNom() + " ?");
			
			// vider le contenu avant nouvel essai
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
			   str += "  Taux d’occupation : " + getTaux() + "%. ";
			   str += "Salaire annuel : " + String.format("%.2f", revenuAnnuel());
			   str += " francs";
			   str += hasPrime() ? ", Prime: " + String.format("%.2f", getPrime()) + ".\n" : ".\n";
		return str;
	}
	
	protected String newEmployeStr() {
		return "Nous avons un nouvel employé : " + getNom();
	}
	
	protected double salaireBase() {
		double base  = 12 * revenu * taux * 1.0 / 100;
		       base += getPrime();
		return base;
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
