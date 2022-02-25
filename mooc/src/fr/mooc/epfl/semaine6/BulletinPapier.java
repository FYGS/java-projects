/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class BulletinPapier extends Vote {
	private boolean estSigne;
	
	public BulletinPapier(String nomPostulant, int date, int dateLimite, boolean estSigne) {
		super(nomPostulant, date, dateLimite);
		this.estSigne = estSigne;
	}

	@Override
	public boolean estInvalide() {
		return estSigne == false;
	}
	
	@Override
	public String toString() {
		return "vote par bulletin papier" + super.toString();
	}

}
