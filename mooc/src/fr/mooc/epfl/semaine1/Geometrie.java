/**
 * 
 */
package fr.mooc.epfl.semaine1;

import java.util.Scanner;

/**
 * @author Fernand SOUALO
 *
 */
public class Geometrie {
	private final static Scanner clavier = new Scanner(System.in);
	private final static int NBRE_OF_POINTS = 3;
	private Point[] sommets;
	
	public Geometrie() {
		int nombreOfPoints = 0;
		sommets = new Point[NBRE_OF_POINTS];
		do {
			double x = 0.0;
			double y = 0.0;
			System.out.println("Construction d'un nouveau point");
			System.out.print("	Veuillez entrer x: ");
			x = clavier.nextDouble();
			System.out.print("	Veuillez entrer y: ");
			y = clavier.nextDouble();
			
			sommets[nombreOfPoints] = new Point(x, y);
			nombreOfPoints++;
		} while (nombreOfPoints < NBRE_OF_POINTS);
		perimetre(sommets);
	}
	
	private double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}
	
	private void perimetre(Point[] sommets) {
		double d1 = distance(sommets[0], sommets[1]);
		double d2 = distance(sommets[1], sommets[2]);
		double d3 = distance(sommets[2], sommets[0]);
		double res = d1 + d2 + d3;
		System.out.println("Périmètre :" + res);
		if (d1 == d2 || d1 == d3 || d2 == d3) {
			System.out.println("Le triangle est isocèle");
		}
	}
}
