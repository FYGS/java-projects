class  Unite  {
	private  boolean  enVie;
	private  int  pointsDeVie;
}

class  Hache  {}

class  Arc  {}

interface  Nain  {
	public  void  frappeAvecHache();
}

interface  Elfe  {
	public  void  tireFleche();
}

interface  Magicien  {
	public  void  lanceSort();
}

interface  Cavalier  {
	public  void  chevauche();
}

class  NainMagicien extends  Unite  implements Nain,  Magicien  {
	private  int  taille;
	private  Hache  hache;
	public  void  frappeAvecHache() {};
	public  void  lanceSort() {};
}

class  NainCavalier   extends  Unite  implements  Nain,  Cavalier  {
	private  int  taille;
	private  Hache  hache;
	public  void  frappeAvecHache() {};
	public  void  chevauche() {};
}

class  ElfeMagicien   extends  Unite  implements  Elfe,  Magicien  {
	private  int  poids;
	private  Arc  arc;
	public  void  tireFleche() {};
	public  void  lanceSort() {};
}

class  ElfeCavalier extends  Unite  implements Elfe,  Cavalier  {
	private  int  poids;
	private  Arc  arc;
	public  void  tireFleche() {};
	public  void  chevauche() {};
}