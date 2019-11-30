package cours.classes;

import java.util.Objects; // Java 7

public class Ville {
	
	/*
	 *  Variables d'instance: 
	 *    -> public par d�faut
	 * */
	protected String nomVille;
	protected String nomPays;
	protected int nombreHabitants;
	
	protected char categorie;
	
	// variables de classe : mot-cl� 'static'
	// Elles sont communes � toutes les instances de la classe
	protected static int nombreInstances = 0;
	public static int nombreinstancesBis = 0;
	
	// constructeur par d�faut
	public Ville() {
		System.out.println("Cr�ation d'une ville !");
		
		this.nombreInstances++;
		this.nombreinstancesBis++;
		
		this.nomVille = "Inconu";
		this.nomPays = "Inconnu";
		this.nombreHabitants = 0;
		this.setCategorie();
	}
	
	public Ville(String ville, int habitant, String pays) {
		System.out.println("Cr�ation d'une ville avec des param�tres !");
		
		this.nombreInstances++;
		this.nombreinstancesBis++;
		
		this.nomVille = ville;
		this.nomPays = pays;
		this.nombreHabitants = habitant;
		this.setCategorie();
	}
	
	//************* ACCESSEURS **********
	
	// Retourne le nom de la ville
	public String getNomVille() {
		return this.nomVille;
	}
	
	// Retourne le nom du pays
	public String getNomPays() {
		return this.nomPays;
	}
	
	// Retourne le nombre d'habitants
	public int getNombreHabitants() {
		return this.nombreHabitants;
	}
	
	public char getCategorie() {
		return this.categorie;
	}
	
	// methode de classe : 'static'
	public static int getNombreInstance() {
		return nombreInstances;
	}
	
	
	//************* MUTATEURS **********

	// D�finit le nom de la Ville
	public void setNomVille(String nom) {
		this.nomVille = nom;
	}
	
	// D�finit le nom du pays
	public void setNomPays(String pays) {
		this.nomPays = pays;
	}
	
	// D�finit le nombre d'habitants
	public void setNombreHabitants(int nombre) {
		this.nombreHabitants = nombre;
	}
	
	// interne � la classe
	private void setCategorie() {
		int bornesSuperieures[] = {0, 1__000, 10__000, 100_000, 5_00_000, 1_000_000, 5_000_000, 10_000_000};
		char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		
		int i = 0;
		while(i < bornesSuperieures.length && this.nombreHabitants > bornesSuperieures[i])
			i++;
		this.categorie = categories[i];
		
	}
	
	// Retourne la description de la ville
	public String toString() {
		return "\t" + this.nomVille + " est une ville de " + this.nomPays + ", elle comporte: " + this.nombreHabitants + " habitant(s) => elle est donc de cat�gorie : " + this.categorie;
	}
	
	// Comparer villes
	public String comparer(Ville ville) {
		String str = new String();
		
		if(ville.nombreHabitants > this.nombreHabitants)
			str = ville.nomVille + " est plus peupl�e que " + this.nomVille;
		else
			str = this.nomVille + " est plus peupl�e que " + ville.nomVille;
		
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categorie;
		result = prime * result + ((nomPays == null) ? 0 : nomPays.hashCode());
		result = prime * result + ((nomVille == null) ? 0 : nomVille.hashCode());
		result = prime * result + nombreHabitants;
		return result;
	}

	// Depuis Java 7, devient:
	//public int hashCode() {
	//	return Objects.hash(categorie, nomPays, nomVille, nombreHabitants);
	//}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ville other = (Ville) obj;
		if (categorie != other.categorie)
			return false;
		if (nomPays == null) {
			if (other.nomPays != null)
				return false;
		} else if (!nomPays.equals(other.nomPays))
			return false;
		if (nomVille == null) {
			if (other.nomVille != null)
				return false;
		} else if (!nomVille.equals(other.nomVille))
			return false;
		if (nombreHabitants != other.nombreHabitants)
			return false;
		return true;
	}
	
	// depuis java 7
	/*
	 * public boolean equals(Object obj) {
  //On v�rifie si les r�f�rences d'objets sont identiques
  if (this == obj)
    return true;

  //On s'assure que les objets sont du m�me type, ici de type Ville
  if (getClass() != obj.getClass())
    return false;
	
  //Maintenant, on compare les attributs de nos objets
  Ville other = (Ville) obj;

  return Objects.equals(other.getCategorie(), this.getCategorie()) &&
	 Objects.equals(other.getNom(), this.getNom()) &&
	 Objects.equals(other.getNombreHabitants(), this.getNombreHabitants()) &&
	 Objects.equals(other.getNomPays(), this.getNomPays());
}
	 * 
	 * */
	
	
	
}
