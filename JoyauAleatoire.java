// Lyes SID ALI 21220655

/* Cette classe sert uniquement a créer differentes sous classes de joyau aléatoirement  */

/* 
La methode generer() s'assure que un joyau sera forcement créée : 30% de chances d'avoir un Rubis sinon 60% de chances d'avoir un Safran 
sinon 90% de chances d'avoir un Diamant, et si malgré toutes ces probabilités aucun Joyau n'a été crée alors on crée l'Uranium235, ce qui fait de ce joyau le plus rare 
*/

public class JoyauAleatoire {
	
	public static Joyau generer() {

		boolean b = Math.random() < 0.3;     
		if(b) return new Rubis(1);
		else{
			b = Math.random() < 0.6;
			if(b) return new Safran(1);
			else{
				b = Math.random() < 0.9;
				if(b) return new Diamant(1);
				else return Uranium235.getUranium();
			}
		}

	}
}