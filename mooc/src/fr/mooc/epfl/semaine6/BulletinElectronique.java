/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class BulletinElectronique extends Vote implements CheckBulletin {
	
	public BulletinElectronique(String nomPostulant, int date, int dateLimite) {
		super(nomPostulant, date, dateLimite);
	}

	@Override
	public boolean estInvalide() {
		return !checkDate();
	}

	@Override
	public boolean checkDate() {
		if (getDate() <= (getDateLimite() - 2)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "vote electronique" + super.toString();
	}

}
