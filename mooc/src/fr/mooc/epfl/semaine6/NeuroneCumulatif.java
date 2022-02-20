/**
 * 
 */
package fr.mooc.epfl.semaine6;

/**
 * @author Fernand SOUALO
 *
 */
public class NeuroneCumulatif extends Neurone {
	public NeuroneCumulatif(Position position, double facteurAttenuation) {
		super(position, facteurAttenuation);
	}
	
	@Override
	protected void setSignalInterne(double stimulus) {
		this.signalInterne += stimulus * getAttenuation();
	}
}
