/**
 * 
 */
package fr.mooc.epfl.semaine4;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class OptionVoyage {
	private final String nom;
	private double prixForfaitaire;
	
	public OptionVoyage(String nom, double prixForfaitaire) {
		this.nom = nom;
		this.prixForfaitaire = prixForfaitaire;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prixForfaitaire
	 */
	public double getPrix() {
		return prixForfaitaire;
	}
	
	@Override
	public String toString() {
		String str = getNom() + " -> " + getPrix() + " CHF";
		return str;
	}
}

class Transport extends OptionVoyage {
	public static final double TARIF_LONG = 1500.;
	public static final double TARIF_BASE = 200.;
	
	private boolean longTrajet;
	
	public Transport(String nom, double prixForfaitaire, boolean longTrajet) {
		super(nom, prixForfaitaire);
		this.longTrajet = longTrajet;
	}
	
	public Transport(String nom, double prixForfaitaire) {
		this(nom, prixForfaitaire, false);
	}
	
	@Override
	public double getPrix() {
		double prix = longTrajet
				? TARIF_LONG
				: TARIF_BASE;
		return prix + super.getPrix();
	}
}

class Sejour extends OptionVoyage {
	private int nombreNuits;
	private double prixParNuit;
	
	public Sejour(String nom, double prixForfaitaire, int nombreNuits, double prixParNuit) {
		super(nom, prixForfaitaire);
		this.nombreNuits = nombreNuits;
		this.prixParNuit = prixParNuit;
	}
	
	@Override
	public double getPrix() {
		return (nombreNuits * prixParNuit) + super.getPrix();
	}
}

class KitVoyage {
	private ArrayList<OptionVoyage> options;
	private final String depart;
	private final String destination;
	
	public KitVoyage(String depart, String destination) {
		this.depart = depart;
		this.destination = destination;
		options = new ArrayList<OptionVoyage>();
	}
	
	public void ajouterOption(OptionVoyage option) {
		if (option != null) {
			options.add(option);
		}
	}
	
	public void annuler() {
		options.clear();
	}
	
	public int getNbOptions() {
		return options.size();
	}
	
	public double prix() {
		double total = .0;
		for (OptionVoyage opt : options) {
			total += opt.getPrix();
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		String str = "Voyage de " + depart + " à " + destination + ", avec pour options :\n";
		for (OptionVoyage opt : options) {
			str += "  - " + opt.toString() + "\n";
		}
		str += "Prix total: " + prix() + " CHF";
		return str;
	}
}

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}
