/**
 * 
 */
package cours.classes;

/**
 * @author Fernand SOUALO
 *
 */
public class Tigre extends Felin {

	public Tigre(){

	  }
	  public Tigre(String couleur, int poids){
	    this.couleur = couleur;
	    this.poids = poids;
	  }
	        
	  void crier() {
	    System.out.println("Je grogne tr�s fort !");
	  } 
}
