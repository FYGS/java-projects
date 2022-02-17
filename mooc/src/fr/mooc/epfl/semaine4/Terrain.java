/**
 * 
 */
package fr.mooc.epfl.semaine4;

/**
 * @author Fernand SOUALO
 *
 */
public class Terrain extends Carte {
	 private char couleur;
	 
	 public Terrain(char couleur) {
		 super(0);
		this.couleur = couleur;
		System.out.println("Un nouveau terrain.");
	}
	 
	 @Override
	public void afficher() {
		String str = "Un terrain ";
		switch (couleur) {
		case 'B':
			str += "blanc";
			break;
		case 'b':
			str += "bleu";
			break;
		case 'n':
			str += "noir";
			break;
		case 'r':
			str += "rougr";
			break;
		case 'v':
			str += "vert";
			break;
		default:
			break;
		}
		System.out.println(str);
		
	}
}
