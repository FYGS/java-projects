/**
 * 
 */
package fr.mooc.epfl.semaine4;

/**
 * @author Fernand SOUALO
 *
 */
public class RectangleColore extends Rectangle {
	private String couleur;
	
	public RectangleColore(double largeur, double hauteur, String couleur) {
		super(largeur, hauteur);
		this.couleur = couleur;
	}
	
	@Override
	public String toString() {
		String str = super.toString() + "\n";
		       str += " couleur = " + couleur;
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else if (getClass() != obj.getClass()) return false;
		RectangleColore rc = (RectangleColore)obj;
		return super.equals(obj) && couleur.equals(rc.couleur);
	}
}
