/**
 * 
 */
package fr.mooc.epfl.semaine6;

import java.util.ArrayList;

/**
 * @author Fernand SOUALO
 *
 */
public class Scrutin {
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
				String nom = vote.getNomPostulant();
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
			int candNum = Utils.randomInt(getNombrePostulants() - 1);
			boolean estSigne = ((i % 2) == 0) ? false : true;
			
			if ((i % 3) == 0) {
				Postulant postulant = getPostulant(candNum);
				if (postulant != null) {
					votes.add(new BulletinElectronique(postulant.getNom(), jour, jour));
				}
			}
			else if ((i % 3) == 1) {
				Postulant postulant = getPostulant(candNum);
				if (postulant != null) {
					votes.add(new BulletinPapier(postulant.getNom(), jour, jour, estSigne));
				}
			}
			else if ((i % 3) == 2) {
				Postulant postulant = getPostulant(candNum);
				if (postulant != null) {
					votes.add(new BulletinCourrier(postulant.getNom(), jour, jour, estSigne));
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
		String nomGagnant = "";
		
		for (int i = 0; i < (getNombrePostulants() - 1); i++) {
			Postulant current = getPostulant(i);
			Postulant next = getPostulant(i + 1);
			if (current.getVotes() <= next.getVotes()) {
				nomGagnant = next.getNom();
			}
			else {
				nomGagnant = current.getNom();
			}
		}
		return nomGagnant;
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
		for (int i = 0; i < postulants.size(); i++) {
			Postulant copie = new Postulant(postulants.get(i));
			if (b) {
				copie.init();
			}
			this.postulants.add(copie);
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
