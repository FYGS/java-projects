/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class BulletinCourrier extends BulletinPapier implements CheckBulletin {
	public BulletinCourrier(String nomPostulant, int date, int dateLimite, boolean estSigne) {
		super(nomPostulant, date, dateLimite, estSigne);
	}

	@Override
	public boolean estInvalide() {
		return super.estInvalide() || !checkDate();
	}

	@Override
	public boolean checkDate() {
		if (getDate() <= getDateLimite()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "envoi par courrier d’un " + super.toString();
	}
}
