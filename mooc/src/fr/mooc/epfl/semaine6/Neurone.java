/**
 * 
 */
package fr.mooc.epfl.semaine6;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
public class Neurone {
	private Position position;
	protected double signalInterne;
	private double facteurAttenuation;
	private ArrayList<Neurone> connexions;
	
	public Neurone(Position position, double facteurAttenuation) {
		this.position = position;
		this.facteurAttenuation = facteurAttenuation;
		this.signalInterne = 0.;
		connexions = new ArrayList<Neurone>();
	}
	
	public Position getPosition() {
		return position;
	}
	
	public int getNbConnexions() {
		return connexions.size();
	}
	
	public Neurone getConnexion(int index) {
		if (isIndexValid(index)) {			
			return connexions.get(index);
		}
		return null;
	}
	
	private boolean isIndexValid(int index) {
		return index >= 0 && index < getNbConnexions();
	}
	
	public double getAttenuation() {
		return facteurAttenuation;
	}
	
	public double getSignal() {
		return signalInterne;
	}
	
	public void connexion(Neurone n) {
		if (n != null) {
			connexions.add(n);
		}
	}
	
	public void recoitStimulus(double stimulus) {
		setSignalInterne(stimulus);
		for (Neurone n : connexions) {
			n.recoitStimulus(getSignal());
		}
	}
	
	protected void setSignalInterne(double stimulus) {
		this.signalInterne = stimulus * getAttenuation();
	}
	
	private boolean areConnexionsEmpty() {
		return getNbConnexions() == 0;
	}
	
	@Override
	public String toString() {
		String str    = "Le neurone en position " + getPosition();
		       str   += " avec attenuation " + getAttenuation();
		       str   += areConnexionsEmpty() ? "  sans connexions" : " en connexion avec";
		       str   += "\n";
		for (int i = 0; i < getNbConnexions(); i++) {
			str += "  - un neurone en position " + getConnexion(i).getPosition() + "\n";
		}
		return str;
	}
}
