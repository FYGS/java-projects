import java.util.Random;


class Utils {
	// genere un entier entre 1 et max (compris)
	public static int randomInt(int max) {
		Random r = new Random();
		int val = r.nextInt();
		val = Math.abs(val);
		val = val % max;
		val += 1;
		return val;
	}
}

class Secret {
	
	public static void main(String[]  args){
		String message = "COURAGEFUYONS";
		String cryptage;

		// PARTIES A DECOMMENTER AU FUR ET A MESURE SELON l'ENONCE
		/*
		// TEST A CLE
		Code acle1 = new ACle("a cle", "EQUINOXE");
		System.out.print("Avec le code : " );
		acle1.affiche();
		cryptage  = acle1.code(message);
		System.out.print("Codage de " + message + " : ");
		System.out.println(cryptage);
		System.out.print("Decodage de " + cryptage + " : ");
		System.out.println(acle1.decode(cryptage));
		System.out.println("-----------------------------------");
		System.out.println();
		// FIN TEST A CLE
        */
		/*
		// TEST A CLE ALEATOIRE
		Code acle2 = new ACleAleatoire(5);
		System.out.print("Avec le code : " );
		acle2.affiche();
		cryptage  = acle2.code(message);
		System.out.print("Codage de " + message + " : ");
		System.out.println(cryptage);
		System.out.print("Decodage de " + cryptage + " : ");
		System.out.println(acle2.decode(cryptage));
		System.out.println("-----------------------------------");
		System.out.println();
		// FIN TEST A CLE ALEATOIRE 
		*/
		/*
		// TEST CESAR
		Code cesar1 = new Cesar("Cesar", 5);
		System.out.print("Avec le code : " );
		cesar1.affiche();
		cryptage = cesar1.code(message);
		System.out.print("Codage de " + message + " : ");
		System.out.println(cryptage);
		System.out.print("Decodage de " + cryptage + " : ");
		System.out.println(cesar1.decode(cryptage));
		System.out.println("-----------------------------------");
		System.out.println();
		// FIN TEST CESAR
		*/
		/*
		// TEST CODAGES
		System.out.println("Test CODAGES: ");
		System.out.println("------------- ");
		System.out.println();


		Code[] tab = {   // Decommentez la ligne suivante
				// si vous avez fait la classe Cesar
				new Cesar("cesar", 5),
				new ACle("a cle", "EQUINOXE") ,
				new ACleAleatoire(5),
				new ACleAleatoire(10)};
		
		Codages  codes = new Codages(tab);
		codes.test(message);
		// FIN TEST CODAGE
		*/
	}
}



