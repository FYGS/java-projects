import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.print("Hello World !\n");
		System.out.println("My name est Fernand");
		System.out.println("I'm gratuated.");
		
		boolean t = true;
		char a = 'a';
		int entier = 32;
		long ca = 524L;
		float pi = 3.1416f;
		double e = 2.08d;
		String s = new String("Ca va !");
		
		System.out.println("t = " + t + " a = " + a + " entier = " + entier + " ca = " + ca + " pi = " + pi + " s = " + s);

		// lecture depuis le clavier
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez saisir un mot");
		String str = sc.nextLine();
		System.out.println("Vous avez saisi : " + str);
		
		System.out.println("Entrez un nombre entier");
		int nombre = sc.nextInt();
		System.out.println("Vous avez saisi : " + nombre);
		
		System.out.println("Entrez un caract�re");
		
		// on vide la ligne avant d'en lire une autre
		sc.nextLine();
		
		String strr = sc.nextLine();
		char car = strr.charAt(0);
		System.out.println("Vous avez saisi le caract�re : " + car);
		System.out.println("FIN");
		
	}

}
