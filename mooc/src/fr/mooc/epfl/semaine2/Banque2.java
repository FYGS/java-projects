package fr.mooc.epfl.semaine2;

class Banque2 {

	public static void main(String[] args) {
		// Données pour tous les comptes privés (taux d'intérêt):
		double taux1 = 0.01;
		// Données pour tous les comptes d'épargne (taux d'intérêt):
		double taux2 = 0.02;
		// Données pour le premier client (nom et ville):
		Client pedro = new Client("Pedro", "Geneve", false);
		// Données pour le compte privé du premier client (solde):
		Compte comptePrivePedro = new Compte("prive", 1000.0, taux1);
		// Données pour le compte d'épargne du premier client (solde):
		Compte compteEpargnePedro = new Compte("d'epargne", 2000.0, taux2);
		pedro.addCompte(comptePrivePedro);
		pedro.addCompte(compteEpargnePedro);

		// Données pour le deuxieme client (nom et ville):
		Client alexandra = new Client("Alexandra", "Lausanne", true);
		// Données pour le compte privé du deuxieme client (solde):
		Compte comptePriveAlexandra = new Compte("prive", 3000.0, taux1);
		// Données pour le compte d'épargne du deuxieme client (solde):
		Compte compteEpargneAlexandra = new Compte("d'epargne", 4000.0, taux2);
		alexandra.addCompte(comptePriveAlexandra);
		alexandra.addCompte(compteEpargneAlexandra);

		// Afficher les données du premier client:
		pedro.afficher();
		// Afficher les données du deuxième client:
		alexandra.afficher();

		// Bouclement du compte privé et épargne du premier client:
		pedro.bouclerComptes();
		// Bouclement du compte privé du deuxième client:
		alexandra.bouclerComptes();

		// Afficher les données du premier client:
		pedro.afficher();
		// Afficher les données du deuxième client:
		alexandra.afficher();
	}
}