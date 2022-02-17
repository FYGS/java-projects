package fr.mooc.epfl.semaine3;

import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    protected String code;
    protected int annee;
    protected String pays;
    protected double valeurFaciale;
    
    public Timbre(String code, int annee, String pays, double valeurFaciale) {
		this.code = code;
		this.annee = annee;
		this.pays = pays;
		this.valeurFaciale = valeurFaciale;
	}
    
    public Timbre() {
		this(CODE_DEFAUT, ANNEE_COURANTE, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
	}
    
    public Timbre(String code) {
		this(code, ANNEE_COURANTE, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
	}
    
    public Timbre(String code, int annee) {
		this(code, annee, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
	}
    
    public Timbre(String code, int annee, String pays) {
		this(code, annee, pays, VALEUR_TIMBRE_DEFAUT);
	}
    
    public double vente() {
    	double prix = .0;
    	if (age() < 5) {
    		prix = valeurFaciale;
    	} 
    	else {
    		prix = valeurFaciale * age() * 2.5;
    	}
		return prix;
	}
    
    public int age() {
		return ANNEE_COURANTE - annee;
	}
    
    /**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @return the valeurFaciale
	 */
	public double getValeurFaciale() {
		return valeurFaciale;
	}

	@Override
    	public String toString() {
    		String str = "Timbre de code " + code;
    			   str += " datant de " + annee;
    			   str += " (provenance" + pays + ")";
    			   str += " ayant pour valeur faciale " + valeurFaciale + " francs";
    		return str;
    	}
}

class Commemoratif extends Timbre {
    
    public Commemoratif(String code, int anneeEmission, String pays, double valeurFaciale) {
		super(code, anneeEmission, pays, valeurFaciale);
	}
    
    public Commemoratif() {
		this(CODE_DEFAUT, ANNEE_COURANTE, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
	}
    
    @Override
    public double vente() {
    	return 2 * super.vente();
    }
    
    @Override
    public String toString() {
    	String str = super.toString() + "\n";
    	       str += "Timbre celebrant un evenement";
    	return str;
    }
}

class Rare extends Timbre {
    private int nombreExemplaires;
    
    public Rare(String code, int anneeEmission, String pays, double valeurFaciale, int nombreExemplaires) {
		super(code, anneeEmission, pays, valeurFaciale);
		this.nombreExemplaires = nombreExemplaires;
	}
    
    public Rare(int nombreExemplaires) {
		this(CODE_DEFAUT, ANNEE_COURANTE, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT, nombreExemplaires);
	}
    
    public int getExemplaires() {
    	return nombreExemplaires;
    }
    
    @Override
    public double vente() {
    	double prixBase = .0;
    	if (nombreExemplaires < 100) {
    		prixBase = PRIX_BASE_1;    		
    	}
    	else if (nombreExemplaires >= 100 && nombreExemplaires < 1000) {
    		prixBase = PRIX_BASE_2;
    	}
    	else {
    		prixBase = PRIX_BASE_3;
    	}
    	return prixBase * (age() / 10.);
    }
    
    @Override
    public String toString() {
    	String str = super.toString() + "\n";
    		   str += "Nombre d’exemplaires -> " + nombreExemplaires;
    	return str;
    }
}
	
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}


