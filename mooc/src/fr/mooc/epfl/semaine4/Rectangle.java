/**
 * 
 */
package fr.mooc.epfl.semaine4;

/**
 * @author Fernand SOUALO
 *
 */
public class Rectangle {
	private double largeur;
	private double hauteur;
	
	public Rectangle(double largeur, double hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	/**
	 * @return the largeur
	 */
	public double getLargeur() {
		return largeur;
	}

	/**
	 * @return the hauteur
	 */
	public double getHauteur() {
		return hauteur;
	}
	
	@Override
	public String toString() {
		String str = "Rectangle :\n";
			   str += " largeur = " + largeur + "\n";
			   str += " hauteur = " + hauteur;
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		else {
			if (getClass() != obj.getClass()) {
				return false;
			}
			else {
				Rectangle r = (Rectangle)obj;
				return largeur == r.largeur &&
					   hauteur == r.hauteur;
			}
		}
	}

}
