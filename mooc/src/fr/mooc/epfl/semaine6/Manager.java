/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class Manager extends Employe {
	public static final int FACTEUR_GAIN_CLIENT = 500;
	public static final int FACTEUR_GAIN_VOYAGE = 100;
	
	private int joursVoyages;
	private int nombreClients;
	
	public Manager(String nom, int revenu, int joursVoyages, int nombreClients) {
		super(nom, revenu);
		this.joursVoyages = joursVoyages;
		this.nombreClients = nombreClients;
	}
	
	public int getJoursVoyages() {
		return joursVoyages;
	}
	
	public int getNombreClients() {
		return nombreClients;
	}
	
	@Override
	public String toString() {
		String str  = super.toString();
		       str += "  A voyagé " + getJoursVoyages() + " jours et apporté ";
		       str += getNombreClients() + " nouveaux clients.\n";
		return str;
	}
	@Override
	protected String newEmployeStr() {
		return super.newEmployeStr() + ", c'est un manager.";
	}
	
	@Override
	protected double salaireBase() {
		double salaire = super.salaireBase();
		       salaire += FACTEUR_GAIN_CLIENT * nombreClients;
		       salaire += FACTEUR_GAIN_VOYAGE * joursVoyages;
		return salaire;
	}
}
