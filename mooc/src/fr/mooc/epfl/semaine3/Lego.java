/**
 * 
 */
package fr.mooc.epfl.semaine3;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Liste {
	protected ArrayList<Piece> pieces;
	protected int tailleMaximale;
	
	public Liste(int tailleMaximale) {
		pieces = new ArrayList<>();
		this.tailleMaximale = tailleMaximale;
	}
	
	public int taille() {
		return pieces.size();
	}
	
	public int tailleMax() {
		return tailleMaximale;
	}
}

class Construction {
	protected ArrayList<Composant> composants;
	protected int tailleMaximale;
	
	public Construction(int tailleMax) {
		composants = new ArrayList<>();
		tailleMaximale = tailleMax;
	}
	
	public int taille() {
		return composants.size();
	}
	
	public int tailleMax() {
		return tailleMaximale;
	}
	
	public void ajouterComposant(Piece p, int qte) {
		if (p != null) {
			if (taille() < tailleMax()) {
				composants.add(new Composant(p, qte));
			}
			else {
				System.out.println("Ajout de composant impossible");
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < taille(); i++) {
			str += composants.get(i).getPiece().toString();
			str += " (quantite " + composants.get(i).getQuantite() + ")\n";
		}
		return str;
	}
}

class Piece {
	protected String nom;
	
	public Piece(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}

class Simple extends Piece {
	private String orientation;
	
	public Simple(String nom, String orientation) {
		super(nom);
		this.orientation = orientation;
	}
	
	public Simple(String nom) {
		this(nom, "aucune");
	}

	/**
	 * @return the orientation
	 */
	public String getOrientation() {
		return orientation;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
			   str += orientation != "aucune" ? " " + orientation : "";
		return str;
	}
}

class Composee extends Piece {
	private ArrayList<Piece> pieces;
	private int nombreMax;
	
	public Composee(String nom, int nombreMax) {
		super(nom);
		pieces = new ArrayList<>();
		this.nombreMax = nombreMax;
	}
	
	public int taille() {
		return pieces.size();
	}
	
	public int tailleMax() {
		return nombreMax;
	}
	
	public void construire(Piece piece) {
		if (piece != null) {
			if (taille() < tailleMax()) {				
				pieces.add(piece);
			}
			else {
				System.out.println("Construction impossible");
			}
		}
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		if (taille() > 0) {
			str += " (";
		}
		for(int i = 0; i < taille(); i++) {
			str += pieces.get(i).toString();
			if (i != (taille() - 1)) {
				str += ",";
			}
			else {
				str += ")";
			}
		}
		return str;
	}
}

class Composant {
	private Piece piece;
	private int quantite;
	
	public Composant(Piece piece, int quantite) {
		this.piece = piece;
		this.quantite = quantite;
	}

	/**
	 * @return the piece
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
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

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}

