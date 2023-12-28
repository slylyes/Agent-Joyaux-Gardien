// Lyes SID ALI 21220655

/* La classe Uranium235 est instanciable qu'une seule fois car c'est le joyau le plus rare (et dangereux), on utilise pour ceci le pattern du singleton*/

public class Uranium235 extends Joyau {

	//ATTRIBUTS SINGLETON
	private static final Uranium235 u = new Uranium235(9000);

	//CONSTRUCTEUR PRIVE
	private Uranium235(int prix){
		super("Uranium235",1);	
		
	}

	//METHODE GETSINGLETON
	public static Uranium235 getUranium() {
		return u;
	}
}