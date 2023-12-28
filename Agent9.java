import java.util.ArrayList;
// LYES SID ALI 21220655

public class Agent9 {

	//ATTRIBUTS
	private int lig;
	private int col;
	private ArrayList<Joyau> sac; 
	private Grille g;
	private String nom;
	
	//CONTSTRUCTEUR
	public Agent9(String nom,Grille grille){
		this.sac = new ArrayList<Joyau>();
		this.lig = 0;
		this.col = 0;
		this.nom = nom;
		g = grille;
	}

	//METHODES
	public String toString(){
		String vide = "";
		if(sacVide()) vide = "Son sac est vide";
		else vide = "contient "+nbJoyeau()+" joyeaux";
		return "Agent "+nom+" en ("+this.lig+","+this.col+"), "+vide+", sa fortune est de "+this.fortune()+" pièces d'or";
	}

	public boolean sacVide(){    
		return (sac.size() == 0);
	}

	public int nbJoyeau(){
		int s = 0;
		for(Joyau j : sac){
			s = (s+1)*j.getQuantite();
		}
		return s;
	}

	public void seDeplacer(int xnew, int ynew) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException{

		if(ynew > g.nbColonnes || ynew < 0){
			throw new DeplacementIncorrectException("Deplacement horizontal impossible");
		}
		if(xnew > g.nbLignes || xnew < 0){
			throw new DeplacementIncorrectException("Deplacement vertical impossible");
		}

		this.lig = xnew;  /* On effectue le déplacement */
		this.col = ynew; 

		if(g.getCase(xnew,ynew) instanceof Joyau){  /* Si la case contient un joyau */
			sac.add((Joyau) g.getCase(xnew,ynew));  /* On l'ajoute a son sac */
			g.videCase(xnew,ynew);    /* On vide la case */
		} 

		if(g.getCase(xnew,ynew) instanceof Gardien){     /* Si la case contient un gardien */
			System.out.println(nom+" rencontre un gardien !");
			sac.clear();    /* On vide son sac */
		}
	}

	public void seDeplacer(int xnew, int ynew,int f) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException, InterruptedException{

		if(ynew > g.nbColonnes || ynew < 0){
			throw new DeplacementIncorrectException("Deplacement horizontal impossible");
		}
		if(xnew > g.nbLignes || xnew < 0){
			throw new DeplacementIncorrectException("Deplacement vertical impossible");
		}

		this.lig = xnew;
		this.col = ynew;

		if(g.getCase(xnew,ynew) instanceof Joyau){ 
			sac.add((Joyau) g.getCase(xnew,ynew));
			g.videCase(xnew,ynew);
		} 

		if(g.getCase(xnew,ynew) instanceof Gardien){
			System.out.println("\n"+nom+" rencontre un gardien et il se bat avec lui ! ... %@$!#");  
			Thread.sleep(2000);
			Gardien gar = (Gardien) g.getCase(xnew,ynew);

			if(gar.getPv()<= f) {          /* Si la gardien perd le combat, (si il n'a pas assez de pv) */
				System.out.println(nom+" a gagné le combat ! Le gardien n'est plus sur la grille.");
				gar.setPv(gar.getPv());;    /* les pv seront mis a 0 */
				g.videCase(xnew,ynew);     /* On vide sa case (RIP) */
			}
			else{  /* Si le gardien gagne le combat */
				System.out.println(nom+" a perdu le combat ! Son sac est maintenant vide.");
				sac.clear();   /* On vide le sac de l'agent */
				gar.setPv(f);  /* On diminue les pv du gardien */
			}	
			Thread.sleep(2000); 
		}
	}

	public int fortune(){
		int s = 0;
		for(Joyau j : sac){
			s += j.getPrix();
		}
		return s;
	}

	public ArrayList<Joyau> contenuSac(){
		return sac;
    }
	
	/* Getteurs */
	public int getLig(){
		return this.lig;
	}

	public int getCol(){
		return this.col;
	}

	public String getNom(){
		return this.nom;
	}

}