package fr.mooc.epfl.semaine6;

import java.util.Scanner;
import java.util.ArrayList;

class SafeProject {
	
	private final static int NB_PROJECTS = 3;
	
	public static void main(String[] args) {
		ArrayList<Project> projects = new ArrayList<Project>();
		
		do {
			Project project = new Project();
			/*try {*/
				project.readProject();
			/*} catch (WrongDurationException | NameTooLongException e) {
				e.printStackTrace();
			}*/
			projects.add(project);
		} while (projects.size() < NB_PROJECTS);
		
		System.out.println("Parfait !");
		System.out.println("Voici les projets enregistres:");
		System.out.println("--------------");
		for (int i = 0; i < projects.size(); i++) {
			System.out.println("Project " + (i + 1));
			System.out.println(projects.get(i));
		}
		System.out.println("--------------");
	}

}

class Project {

	private String name = null;
	private String subject = null;
	private int duration = -1;

	public Project() {}

	public void readProject() /*throws WrongDurationException, NameTooLongException*/ {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Donnez le nom du projet : ");
			try {
				name = readString(scanner);
			} catch (NameTooLongException e) {
				System.err.println("[" + e.getMessage() + "]");
			}
		} while (name == null);
		
		do {
			System.out.println("Donnez le sujet du projet : ");
			try {
				subject = readString(scanner);
			} catch (NameTooLongException e) {
				System.err.println("[" + e.getMessage() + "]");
			}
		} while (subject == null);
		
		do {
			System.out.println("Donnez la durée du projet : ");
			try {
				duration = readInt(scanner);
			} catch (WrongDurationException e) {
				System.err.println("[" + e.getMessage() + "]");
			}
		} while (duration < 0);
	}
	
	private String readString(Scanner sc) throws NameTooLongException {
		String str = sc.nextLine();
		if (str.length() > 50) {
			throw new NameTooLongException("Value shouldn't exceed 50 characters");
		}
		return str;
	}

	private int readInt(Scanner sc) throws WrongDurationException {
		String str = sc.nextLine();
		int number;
		try {
			number = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new WrongDurationException(str + " is not a number !");
		}
		if (number <= 0) {
			throw new WrongDurationException("Duration should be strictly positive !");
		}
		return number;
	}
	
	@Override
	public String toString() {
		String str  = "  Name: " + name;
		       str += "\n  Subject: " + subject;
		       str += "\n  Duration: " + duration;
		return str;
	}
}

