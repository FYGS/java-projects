/**
 * 
 */
package fr.mooc.epfl.semaine1;

/**
 * @author Fernand SOUALO
 *
 */
public class TestCercle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Cercle c1 = new Cercle(Math.sqrt(5.0), 1.0, 2.0); Cercle c2 = new
		 * Cercle(2.25, -2.0, 1.0); Cercle c3 = new Cercle(1.0, -2.0, -5.0);
		 * 
		 * System.out.println("Surface de c1 : " + c1.surface());
		 * System.out.println("Surface de c2 : " + c2.surface());
		 * System.out.println("Surface de c3 : " + c3.surface()); afficherPosition("c1",
		 * c1, 0.0, 0.0); afficherPosition("c2", c2, 0.0, 0.0); afficherPosition("c3",
		 * c3, 0.0, 0.0);
		 */

//		// MAGICIEN
//		Spectateur spectateur = new Spectateur();
//		spectateur.arriver();
//		Assistant assistant = new Assistant();
//		
//		Magicien magicien = new Magicien();
//		magicien.tourDeMagie(spectateur, assistant);
		
		// GEOMETRIE
		Geometrie geometrie = new Geometrie();
	}

	
	/**
	 * @param nom
	 * @param c
	 * @param x
	 * @param y
	 */
	private static void afficherPosition(String nom, Cercle c, double x, double y) {
		System.out.print("Position du point (" + x + ", " + y + ") : ");
		if (c.estInterieur(x,y))
		{
		System.out.print("dans ");
		}
		else
		{
		System.out.print("hors de ");
		}
		System.out.println(nom);

	}

}
