
// LYES SID ALI 21220655

public class Simulation{

	//ATTRIBUTS
	private Grille g;
	private Agent9 jb;     /* Choix du nom jb pour l'attribut agent : jb = james bond (dans tout les autres fichiers c'est pareil, jb c'est un agent) */
	private Contenu[] tabContenu;

	//CONSTRUCTEUR
	public Simulation(Grille g, Agent9 jb, Contenu[] tab, int m) throws CoordonneesIncorrectesException, CaseNonPleineException, DebordementException{
		this.g = g;
		if(m > (g.nbColonnes*g.nbLignes)) throw new DebordementException();  /* Si on veut placer plus d'éléments que de cases disponibles, une exception est déclanchée */
		this.jb = jb;
		this.tabContenu = new Contenu[m];
		for(int i=0; i<m; i++){
			this.tabContenu[i] = tab[i];  
			int x = (int)(Math.random()*g.nbLignes);
			int y = (int)(Math.random()*g.nbColonnes);
			while(!g.caseEstVide(x,y)){                    /* Tant que la case n'est pas vide on genere de nouvelles coordonnées  */
				x = (int)(Math.random()*g.nbLignes);
				y = (int)(Math.random()*g.nbColonnes);
			}
			g.setCase(x,y,tab[i]);      /* On place le contenu sur la grille */
		}
	}

	//METHODES
	public String toString(){
		return (g.lesContenus()+"\n"+jb);
	}

	public void lance(int nbEtapes) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException, InterruptedException{
		for(int i=0; i<nbEtapes; i++){
			int xnew = -1;
			int ynew = -1;
			while(!g.sontValides(xnew,ynew)){       /* on s'assure que l'agent se deplacera forcement sur une case valide et ne sortira pas de la grille   */
				xnew = jb.getLig() + (int)(Math.random()*(3)-1);
				ynew = jb.getCol() + (int)(Math.random()*(3)-1);
			}
			
			
			// DEBUT TELEPORTATION ================
			for(Contenu c : tabContenu){
				if(c instanceof GardienTeleprotable) ((GardienTeleprotable)c).seTeleporter();    /* On fait téléporter les gardiens téléportables */
			}
			// FIN TELEPORTATION =================

			boolean b = Math.random() < 0.3;    /* 30% de chances pour que l'agent se deplace avec force */
			int f = (int)(Math.random()*(91)+10);     /* La force de l'agent est générée aléatoirement entre 10 et 100 */

			if(b) jb.seDeplacer(xnew, ynew, f);  /* Deplacement avec force  */
			else jb.seDeplacer(xnew, ynew);      /* Sinon deplacement simple sans force */

			/* On affiche la grille et diverses informations sur l'agent */
			System.out.println("Etape "+i+" : "+jb);                       
			g.affiche(7);
			System.out.println("===========================================");
			Thread.sleep(1000);
		}
		System.out.println("Fin de la simulation.");
	}
}