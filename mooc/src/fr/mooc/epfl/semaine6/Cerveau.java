/**
 * 
 */
package fr.mooc.epfl.semaine6;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
public class Cerveau {
	private ArrayList<Neurone> neurones;
	
	public Cerveau() {
		neurones = new ArrayList<Neurone>();
	}
	
	public int getNbNeurones() {
		return neurones.size();
	}
	
	public Neurone getNeurone(int index) {
		if (isIndexValid(index)) {			
			return neurones.get(index);
		}
		return null;
	}
	
	public void ajouterNeurone(Position pos, double attenuation) {
		neurones.add(new Neurone(pos, attenuation));
	}
	
	public void ajouterNeuroneCumulatif(Position pos, double attenuation) {
		neurones.add(new NeuroneCumulatif(pos, attenuation));
	}
	
	public void stimuler(int index, double stimulus) {
		Neurone n = getNeurone(index);
		if (n != null) {
			n.recoitStimulus(stimulus);
		}
	}
	
	public double sonder(int index) {
		Neurone n = getNeurone(index);
		return n.getSignal();
	}
	
	public void creerConnexions() {
		Neurone neuroneIndex0 = getNeurone(0);
		if (neuroneIndex0 != null) {
			neuroneIndex0.connexion(getNeurone(1));
			neuroneIndex0.connexion(getNeurone(2));
		}
		for (int i = 0; i < (getNbNeurones() - 2); i++) {
			if (i == 0) {
				continue;
			}
			if ((i % 2) != 0) {
				Neurone currentNeurone = getNeurone(i);
				Neurone nextNeurone = getNeurone(i + 1);
				if (currentNeurone != null) {
					currentNeurone.connexion(nextNeurone);
				}
				if (nextNeurone != null) {
					nextNeurone.connexion(getNeurone(i + 2));
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "\n*----------*\n\n";
		      str += "Le cerveau contient " + getNbNeurones() + " neurone(s)\n";
		for (Neurone n : neurones) {
			str += n.toString() + "\n";
		}
		str += "*----------*\n\n";
		return str;
	}
	
	private boolean isIndexValid(int index) {
		return index >= 0 && index < getNbNeurones();
	}
}
