
// LYES SID ALI 21220655

/* La classe Joyau est abstraite car on souhaite spécifier précisement quel est le joyau qu'on va instancier */

public abstract class Joyau extends Contenu {
	
	//ATTRIBUTS
	private final int prix;
	public static final int PRIX_MAX = 9000;
	public static final int PRIX_MIN = 1;

	//CONTSTRUCTEUR
	public Joyau(String type,int qt) {        /* Un constructeur qui crée un joyau avec un prix aleatoire */
		super(type,qt);
		this.prix = (int)(Math.random()*(9000)+1) * qt;
	}
	public Joyau(String type,int prix, int qt) {       /* Un constructeur qui crée un joyau avec un prix donné*/
		super("Joyeau",qt); 
		this.prix = prix * qt;
	}

	//METHODES
	public String toString(){
		return super.toString()+" prix = "+this.prix;
	}
	public int getPrix(){      /* Getteur pour le prix */
		return this.prix;
	}
	
}