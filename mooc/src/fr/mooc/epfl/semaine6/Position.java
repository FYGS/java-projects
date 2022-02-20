/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class Position {
	private double x;
	private double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Position() {
		this(0., 0.);
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		String str = "(" + x + ", " + y + ")";
		return str;
	}
}
