/**
 * 
 */
package fr.mooc.epfl.semaine1;

/**
 * @author Fernand SOUALO
 *
 */
public class Cercle {
	private double rayon;
	private double x;
	private double y;
	public Cercle(double rayon, double x, double y) {
		setRayon(rayon);
		setCentre(x, y);
	}
	
	/**
	 * @param rayon the rayon to set
	 */
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	/**
	 * @param centre the centre to set
	 */
	public void setCentre(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double surface() {
		return Math.PI * rayon * rayon;
	}
	
	public boolean estInterieur(double x, double y) {
		return ((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y)) <= (rayon * rayon);
	}
}
