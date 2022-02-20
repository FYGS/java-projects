import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Position {
	private double x;
	private double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Position() {
		this(0., 0.);
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		String str = "(" + x + ", " + y + ")";
		return str;
	}
}

class Neurone {
	private Position position;
	protected double signalInterne;
	private double facteurAttenuation;
	protected ArrayList<Neurone> connexions;
	
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
		signalInterne = stimulus * getAttenuation();
		for (Neurone n : connexions) {
			n.recoitStimulus(getSignal());
		}
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

class NeuroneCumulatif extends Neurone {
	public NeuroneCumulatif(Position position, double facteurAttenuation) {
		super(position, facteurAttenuation);
	}
	
	@Override
	public void recoitStimulus(double stimulus) {
		signalInterne += stimulus * getAttenuation();
		for (Neurone n : connexions) {
			n.recoitStimulus(getSignal());
		}
	}
}

class Cerveau {
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
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class SimulateurNeurone {

    public static void main(String[] args) {
        // TEST DE LA PARTIE 1
        System.out.println("Test de la partie 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);

        neuron1.connexion(neuron2);
        neuron2.connexion(neuron3);
        neuron1.recoitStimulus(10);

        System.out.println("Signaux : ");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("Premiere connexion du neurone 1");
        System.out.println(neuron1.getConnexion(0));


        // FIN TEST DE LA PARTIE 1

        // TEST DE LA PARTIE 2
        System.out.println("Test de la partie 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.recoitStimulus(10);
        neuron5.recoitStimulus(10);
        System.out.println("Signal du neurone cumulatif  -> " + neuron5.getSignal());

        // FIN TEST DE LA PARTIE 2

        // TEST DE LA PARTIE 3
        System.out.println();
        System.out.println("Test de la partie 3:");
        System.out.println("--------------------");
        Cerveau cerveau = new Cerveau();

        // parametres de construction du neurone:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeurone(new Position(0,0), 0.5);
        cerveau.ajouterNeurone(new Position(0,1), 0.2);
        cerveau.ajouterNeurone(new Position(1,0), 1.0);

        // parametres de construction du neurone cumulatif:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeuroneCumulatif(new Position(1,1), 0.8);
        cerveau.creerConnexions();
        cerveau.stimuler(0, 10);

        System.out.println("Signal du 3eme neurone -> " + cerveau.sonder(3));
        System.out.println(cerveau);
        // FIN TEST DE LA PARTIE 3
    }
}
