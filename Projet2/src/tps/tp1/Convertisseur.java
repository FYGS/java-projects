package tps.tp1;

import java.util.Scanner;

public class Convertisseur {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choixMenu = 0;
		float temperatureAConvertir = 0.0f, temperatureConvertie = 0.0f;
		char reponse = ' ';
		
		String menu1 = new String("CONVERTISSEUR DEGRES CELSIUS ET DEGRES FAHRENHEIT\n");
		menu1 += "-------------------------------------------------\n";
		String menu2 = "Choisissez le mode de conversion : \n";
		menu2 += "1 - Convertisseur Celsius - Fahrenheit\n";
		menu2 += "2 - Convertisseur Fahrenheit - Celsius\n";
		
		
		do {
			System.out.print(menu1);
			//choixMenu = sc.nextInt();
			
			do {
				System.out.println(menu2);
				choixMenu = sc.nextInt();
			}while(choixMenu != 1 && choixMenu != 2);
			
			System.out.println("Temperature � convertir : ");
			sc.nextLine(); // vider d'abord la ligne
			temperatureAConvertir = sc.nextFloat();
			
			switch(choixMenu) {
			case 1:
				System.out.print("�C -> �F: \t");
				temperatureConvertie = (9 * temperatureAConvertir) / 5 + 32;
				System.out.println(temperatureAConvertir + " �C correspond � : " + temperatureConvertie + " �F.");
				break;
			case 2:
				System.out.print("�F -> �C: \t");
				temperatureConvertie = ((temperatureAConvertir - 32) * 5) / 9;
				System.out.println(temperatureAConvertir + " �F correspond � : " + temperatureConvertie + " �C.");
				break;
			default:
				System.out.println("Choix incorrect !");
			}
			
			sc.nextLine(); // OK
			do {
				System.out.println("Souhaitez-vous convertir une autre temp�rature ?(0/N)");
				//sc.nextLine(); plante � la suite de deux caract�res
				reponse = sc.nextLine().charAt(0);
			}while(reponse != 'O' && reponse != 'N');
			
		}while(reponse == 'O');
		
		sc.close();
		System.out.println("Au revoir !");

	}

}
