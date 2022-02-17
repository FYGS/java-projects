/**
 * 
 */
package fr.mooc.epfl.semaine5;

/**
 * @author Fernand SOUALO
 *
 */
public class ApproximationPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(approximationPI(2000));

	}
	
	public static double approximationPI(int nombrePoint) {
		double pi = .0;
		int accumulateur = 0;
		for (int x = 0; x <= nombrePoint; x++) {
			for (int y = 0; y <= nombrePoint; y++) {
				double distance = (x * x) + (y * y);
				if (distance <= (nombrePoint * nombrePoint)) {
					accumulateur += 1;
				}
			}
		}
		pi = (4. * (accumulateur - nombrePoint - 1) + 1) / (nombrePoint * nombrePoint);
		return pi;
		
	}

}
