/**
 * 
 */
package fr.mooc.epfl.semaine2;

/**
 * @author Fernand SOUALO
 *
 */
import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici
	private String nom;
	private boolean estPrime;
	
	public Auteur(String nom, boolean estPrime) {
		this.nom = nom;
		this.estPrime = estPrime;
		
		
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the estPrime
	 */
	public boolean getPrix() {
		return estPrime;
	}

}

class Oeuvre
{
 	// Completer la classe Oeuvre ici
	private String titre;
	private final Auteur auteur;
	private String langue;
	
	public Oeuvre(String titre, Auteur auteur, String langue) {
		this.titre = titre;
		this.auteur = auteur;
		this.langue = langue;
	}
	
	public Oeuvre(String titre, Auteur auteur) {
		this(titre, auteur, "francais");
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}


	/**
	 * @return the langue
	 */
	public String getLangue() {
		return langue;
	}

	/**
	 * @return the auteur
	 */
	public final Auteur getAuteur() {
		return auteur;
	}
	
	public void afficher() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String str = getTitre() + ", " + getAuteur().getNom();
		str += ", en " + getLangue();
		return str;
	}
}

// completer les autres classes ici

class Exemplaire
{
 	private Oeuvre oeuvre;
 	
 	public Exemplaire(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
		System.out.print("Nouvel exemplaire -> ");
		this.oeuvre.afficher();
	}
 	
 	public Exemplaire(Exemplaire autre) {
		this.oeuvre = autre.oeuvre;
		System.out.print("Copie d’un exemplaire de -> ");
		this.oeuvre.afficher();
	}
 	
 	public void afficher() {
		System.out.println(this);
	}
 	
 	@Override
 	public String toString() {
 		String str = "Un exemplaire de " + getOeuvre().toString();
 		return str;
 	}

	/**
	 * @return the oeuvre
	 */
	public Oeuvre getOeuvre() {
		return oeuvre;
	}
}

class Bibliotheque
{
 	private String nom;
 	private ArrayList<Exemplaire> exemplaires;
 	
 	public Bibliotheque(String nom) {
		this.nom = nom;
		exemplaires = new ArrayList<>();
		afficher();
	}
 	
 	public void afficher() {
		System.out.println(this);
	}
 	
 	@Override
 	public String toString() {
 		String str = "La bibliothèque " + nom + " est ouverte !";
 		return str;
 	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	public int getNbExemplaires() {
		return exemplaires.size();
	}
	
	public void stocker(Oeuvre oeuvre, int quantite) {
		int i = 1;
		while(i <= quantite) {			
			stocker(oeuvre);
			++i;
		}
	}
	
	public void stocker(Oeuvre oeuvre) {
		Exemplaire exemplaire = new Exemplaire(oeuvre);
		exemplaires.add(exemplaire);
	}
	
	public ArrayList<Exemplaire> listerExemplaires(String langue) {
		ArrayList<Exemplaire> resultats = new ArrayList<>();
		exemplaires.forEach(e -> {
			if (e.getOeuvre().getLangue() == langue) {
				resultats.add(e);
			}
		});
		
		if (langue.trim() == "") {
			return exemplaires;
		}
		return resultats;
	}
	
	public ArrayList<Exemplaire> listerExemplaires() {
		return listerExemplaires("");
	}
	
	public int compterExemplaires(Oeuvre oeuvre) {
		ArrayList<Exemplaire> resultats = new ArrayList<>();
		exemplaires.forEach(e -> {
			if (e.getOeuvre() == oeuvre) {
				resultats.add(e);
			}
		});
		return resultats.size();
	}
	
	public void afficherAuteur(boolean estPrime) {
		exemplaires.forEach(e -> {
			Auteur auteur = e.getOeuvre().getAuteur();
			if (estPrime) {
				if (auteur.getPrix()) {
					System.out.println(auteur.getNom());
				}
			}
			else {
				if (!auteur.getPrix()) {
					System.out.println(auteur.getNom());
				}
			}
		});
	}
	
    public void afficherAuteur() {
		afficherAuteur(true);
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");
        
        Exemplaire e1 = new Exemplaire(o4);
        Exemplaire e2 = new Exemplaire(e1);

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
        ArrayList<Exemplaire> arr = new ArrayList<Exemplaire>();
        arr.add(e1);
        arr.add(e2);
        afficherExemplaires(arr);
    }
}


