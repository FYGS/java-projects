/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public abstract class Vote {
	private final String nomPostulant;
	private int date;
	private int dateLimite;
	
	public Vote(String nomPostulant, int date, int dateLimite) {
		this.nomPostulant = nomPostulant;
		this.date = date;
		this.dateLimite = dateLimite;
	}
	
	public abstract boolean estInvalide();
	
	public int getDate() {
		return date;
	}
	
	public int getDateLimite() {
		return dateLimite;
	}
	
	public String getNomPostulant() {
		return nomPostulant;
	}
	
	@Override
	public String toString() {
		String str  = " pour " + nomPostulant + " -> ";
			   str += estInvalide() ? "in" : "";
			   str += "valide";
		return str;
	}
}
