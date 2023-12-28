
// Lyes SID ALI 21220655

public class TestSimulation{
	public static void main(String[] args) throws CaseNonPleineException,InterruptedException{
		
		System.out.println("Demarrage de la simulation...");
		Thread.sleep(2000);

		try{ 
			/* Creation de la grille, de l'agent et des contenus */
			Grille g = new Grille(5,5);
			Agent9 jb = new Agent9("James Bond", g);
			Contenu[] tab = new Contenu[10];

			for(int i=0; i<10; i++){
				boolean b = Math.random() < 0.5;       /* la probabilité d'avoir un joyau ou un gardien est la meme */
				if(b) tab[i] = JoyauAleatoire.generer(); /* Creation d'un joyau aleatoire a partir de la classe JoyauAleatoire */
				else{
					b = Math.random() < 0.5;   /* la probabilité d'avoir un gardien ou un gardien teleportable est la meme   */
					if(b)tab[i] = new GardienTeleprotable(g,1); 
					else tab[i] = new Gardien(1); 
				} 
			}

			Simulation s = new Simulation(g, jb, tab, 10);
			s.lance(10);   /* Lancement de la simulation */
			

		}

		/* Gestion des exceptions */
		catch(DeplacementIncorrectException e){
			System.out.println(e.getMessage());
		}
		catch(CoordonneesIncorrectesException e){
			System.out.println(e.getMessage());
		}
		
		catch(DebordementException e){
			System.out.println(e.getMessage());
		}
	

	}
}