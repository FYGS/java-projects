package cours.classes;

public class Capitale extends Ville {
	private String monument;
	
	public Capitale() {
		// constructeur classe mère
		super();
		this.monument = "Aucun";
	}
	
	public Capitale(String ville, int habitant, String pays, String monument) {
		// constructeur classe mère
		super(ville, habitant, pays);
		this.monument = monument;
	}
	
	public String toString() {
		String str = super.toString() + "\n \t ==>>" + this.monument + " en est un monument";
		
		System.out.println("Invocation de super.toString()");
		
		return str;
	}

	public String getMonument() {
		return monument;
	}

	public void setMonument(String monument) {
		this.monument = monument;
	}
	
	

}
