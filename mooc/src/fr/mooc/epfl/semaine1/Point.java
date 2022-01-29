/**
 * 
 */
package fr.mooc.epfl.semaine1;

/**
 * @author Fernand SOUALO
 *
 */
public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
}
