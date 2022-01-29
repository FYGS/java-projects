/**
 * 
 */
package fr.mooc.epfl.semaine2;

/**
 * @author Fernand SOUALO
 *
 */
class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int poids;
    private int age;
    private String couleur;
    private int esperanceVie;
    private boolean clonee;
    
    public Souris(int poids, String couleur, int age, int esperanceVie, boolean clonee) {
    	this.poids = poids;
    	this.couleur = couleur;
    	this.age = age;
    	this.esperanceVie = esperanceVie;
    	this.clonee = clonee;
	}
    
    public Souris(int poids, String couleur, int age) {
    	this(poids, couleur, age, ESPERANCE_VIE_DEFAUT, false);
    	System.out.println("Une nouvelle souris !");
	}
    
    public Souris(int poids, String couleur) {
    	this(poids, couleur, 0);
	}
    
    public Souris(Souris autreSouris) {
    	this(autreSouris.poids, autreSouris.couleur, autreSouris.age, (4 * autreSouris.esperanceVie) / 5, true);
    	System.out.println("Clonage d’une souris !");
	}
    
    @Override
    public String toString() {
    	String str = "Une souris " + couleur;
    	if (clonee) {
    		str += ", clonee,";
    	}
    	str += " de " + age + " mois et pesant " + poids + " grammes";
    	return str;
    }
    
    public void vieillir() {
		age += 1;
		verifieAge();
	}
    
    public void evolue() {
		age = esperanceVie;
		verifieAge();
	}

	private void verifieAge() {
		if (clonee && age > (0.5 * esperanceVie)) {
			couleur = "verte";
		}
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}

