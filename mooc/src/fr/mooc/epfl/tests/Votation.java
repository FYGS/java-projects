/**
 * 
 */
package fr.mooc.epfl.tests;

/**
 * @author Fernand SOUALO
 *
 */

import java.util.ArrayList;
import java.util.Random;

/*******************************************
 * Completez le programme à partir d'ici.
 *******************************************/
class Scrutin {
	private ArrayList<Postulant> postulants;
	private ArrayList<Vote> votes;
	private int nombreVotantsMaximal;
	private int date;
	
	public Scrutin(ArrayList<Postulant> postulants, int nombreVotantsMaximal, int date, boolean bool) {
		this.postulants = new ArrayList<Postulant>();
		this.votes = new ArrayList<Vote>();
		populate(postulants, bool);
		this.nombreVotantsMaximal = nombreVotantsMaximal;
		this.date = date;
	}
	
	public Scrutin(ArrayList<Postulant> postulants, int nombreVotantsMaximal, int date) {
		this(postulants, nombreVotantsMaximal, date, true);
	}
	
	public void compterVotes() {
		for (Vote vote : votes) {
			if (!vote.estInvalide()) {
				String nom = vote.getPostulant();
				Postulant postulant = getPostulant(nom);
				if (postulant != null) {
					postulant.elect();
				}
			}
		}
	}
	
	public void simuler(double taux, int jour) {
		int nbreVotants = (int)(nombreVotantsMaximal * taux);
		
		for (int i = 0; i < nbreVotants; i++) {
			int candNum = Utils.randomInt(getNombrePostulants());
			boolean estSigne = ((i % 2) == 0) ? false : true;
			
			if ((i % 3) == 0) {
				Postulant postulant = getPostulant(candNum);
				if (postulant != null) {
					votes.add(new BulletinElectronique(postulant.getNom(), jour, date));
				}
			}
			else if ((i % 3) == 1) {
				Postulant postulant = getPostulant(candNum);
				if (postulant != null) {
					votes.add(new BulletinPapier(postulant.getNom(), jour, date, estSigne));
				}
			}
			else if ((i % 3) == 2) {
				Postulant postulant = getPostulant(candNum);
				if (postulant != null) {
					votes.add(new BulletinCourrier(postulant.getNom(), jour, date, estSigne));
				}
			}
		}
		
		for (int i = 0; i < nbreVotants; i++) {
			System.out.println(votes.get(i));
		}
	}
	
	public int calculerVotants() {
		int votants = 0;
//		if (!isValid()) {
//			return votants;
//		}
		for (Postulant postulant : postulants) {
			votants += postulant.getVotes();
		}
		return votants;
	}
	
	public String gagnant() {
		Postulant winner = null;
		Postulant first = getPostulant(0);
		if (first != null) {
			winner = first;
		}
		
		for (int i = 1; i < getNombrePostulants(); i++) {
			Postulant current = getPostulant(i);
			if (current.getVotes() >= winner.getVotes()) {
				winner = current;
			}
		}
		return winner.getNom();
	}
	
	public void resultats() {
		String str = "";
		if (calculerVotants() == 0) {
			str = "Scrutin annulé, pas de votants\n";
		}
		else {
			str  = "Taux de participation -> ";
		    str += getPercentage(calculerVotants(), getNombreVotantsMaximal());
		    str += " pour cent\n";
		    str += "Nombre effectif de votants -> " + calculerVotants() + "\n";
		    str += "Le chef choisi est -> " + gagnant() + "\n\n";
		    str += "Répartition des electeurs\n";
		    for (Postulant p : postulants) {
		      str += p.getNom() + " -> " + getPercentage(p.getVotes(), calculerVotants());
		      str += " pour cent des électeurs\n";
		    }
		}
		
		 System.out.println(str);
	}
	
	private String getPercentage(int num, int denom) {
		return String.format("%.1f", num * 1.0 / denom * 100);
	}
	
	private void populate(ArrayList<Postulant> postulants, boolean b) {
		if (postulants != null) {
			for (int i = 0; i < postulants.size(); i++) {
				Postulant copie = null;
				Postulant got = postulants.get(i);
				if (got != null) {
					copie = new Postulant(got);
				}
				if (copie != null) {
					if (b) {
						copie.init();
					}
					this.postulants.add(copie);
				}
			}
		}
	}
	
	private int getNombrePostulants() {
		return this.postulants.size();
	}
	
	private int getNombreVotantsMaximal() {
//		return calculerVotants() + getNombrePostulants();
		return nombreVotantsMaximal;
	}
	
	private Postulant getPostulant(int index) {
		if (index >= 0 && index < getNombrePostulants()) {
			return this.postulants.get(index);
		}
		return null;
	}
	
	private Postulant getPostulant(String nom) {
		for (Postulant postulant : postulants) {			
			if (postulant.getNom() == nom) {
				return postulant;
			}
		}
		return null;
	}
	
//	private boolean isValid() {
//		return getNombrePostulants() <= getNombreVotantsMaximal();
//	}
	
}

abstract class Vote {
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
	
	public String getPostulant() {
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

class BulletinPapier extends Vote {
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

class BulletinElectronique extends Vote implements CheckBulletin {
	
	public BulletinElectronique(String nomPostulant, int date, int dateLimite) {
		super(nomPostulant, date, dateLimite);
	}

	@Override
	public boolean estInvalide() {
		return !checkDate();
	}

	@Override
	public boolean checkDate() {
		return getDate() <= (getDateLimite() - 2);
	}
	
	@Override
	public String toString() {
		return "vote electronique" + super.toString();
	}

}

class BulletinCourrier extends BulletinPapier implements CheckBulletin {
	public BulletinCourrier(String nomPostulant, int date, int dateLimite, boolean estSigne) {
		super(nomPostulant, date, dateLimite, estSigne);
	}

	@Override
	public boolean estInvalide() {
		return super.estInvalide() || !checkDate();
	}

	@Override
	public boolean checkDate() {
		return getDate() <= getDateLimite();
	}
	
	@Override
	public String toString() {
		return "envoi par courrier d'un " + super.toString();
	}
}

class Postulant {
	private final String nom;
	private int nombreElecteurs;
	
	public Postulant(String nom, int nombreElecteurs) {
		this.nom = nom;
		this.nombreElecteurs = nombreElecteurs;
	}
	
	public Postulant(String nom) {
		this(nom, 0);
	}
	
	public Postulant(Postulant autre) {
		this.nom = autre.nom;
		this.nombreElecteurs = autre.nombreElecteurs;
	}
	
	public void elect() {
		this.nombreElecteurs++;
	}
	
	public void init() {
		this.nombreElecteurs = 0;
	}
	
	public int getVotes() {
		return nombreElecteurs;
	}
	
	public String getNom() {
		return nom;
	}
}
interface CheckBulletin {
	boolean checkDate();
}
/*******************************************
 * Ne pas modifier les parties fournies
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

class Utils {

    private static final Random RANDOM = new Random();

    // NE PAS UTILISER CETTE METHODE DANS LES PARTIES A COMPLETER
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // génère un entier entre 0 et max (max non compris)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}

/**
 * Classe pour tester la simulation
 */

class Votation {

    public static void main(String args[]) {
        Utils.setSeed(20000);
        // TEST 1
        System.out.println("Test partie I:");
        System.out.println("--------------");

        ArrayList<Postulant> postulants = new ArrayList<Postulant>();
        postulants.add(new Postulant("Tarek Oxlama", 2));
        postulants.add(new Postulant("Nicolai Tarcozi", 3));
        postulants.add(new Postulant("Vlad Imirboutine", 2));
        postulants.add(new Postulant("Angel Anerckjel", 4));

        // 30 -> nombre maximal de votants
        // 15 jour du scrutin
        Scrutin scrutin = new Scrutin(postulants, 30, 15, false);

        scrutin.resultats();

        // FIN TEST 1

        // TEST 2
        System.out.println("Test partie II:");
        System.out.println("---------------");

        scrutin = new Scrutin(postulants, 20, 15);
        // tous les bulletins passent le check de la date
        // les parametres de simuler sont dans l'ordre:
        // le pourcentage de votants et le jour du vote
        scrutin.simuler(0.75, 12);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // seuls les bulletins papier non courrier passent
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // les bulletins electroniques ne passent pas
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();
        //FIN TEST 2

    }
}

