/**
 * 
 */
package fr.mooc.epfl.semaine3;

/**
 * @author Fernand SOUALO
 *
 */
public class EtudiantEchange extends Etudiant {
	private String universiteOrigine;
	
	public EtudiantEchange(String nom, int annee, String section, String universiteOrigine) {
		super(nom, annee, section);
		this.universiteOrigine = universiteOrigine;
	}
	
	@Override
	public void afficher() {
		System.out.print(this);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "  Uni d'origine : " + universiteOrigine + "\n";
		return str;
	}
}
