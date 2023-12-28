// Lyes SID ALI 21220655

/* Cette classe est une sous classe de Gardien, Gardien teleportable permet de se deplacer sur la grille n'importe ou en se teleportant */

public class GardienTeleprotable extends Gardien implements Teleportable{

	//ATTRIBUTS
	private Grille g;   /* La grille dans laquelle il va se teleporter */

	//CONSTRUCTEUR
	public GardienTeleprotable(Grille g,int qt){
		super(qt);
		this.g = g;
	}	

	//METHODES
	public String toString(){
		return super.toString();
	}


	public void seTeleporter() throws CaseNonPleineException, CoordonneesIncorrectesException{

		int xnew = (int)(Math.random()*g.nbLignes);         /* On est sur que le gardien ne se teleportera jamais hors de la grille */
		int ynew = (int)(Math.random()*g.nbColonnes);

		boolean b = Math.random() < 0.7;   /* 70% de chances qu'il se teleporte */
		if(b && g.caseEstVide(xnew,ynew)){      /* On s'assure que la case ou il se teleportera est bien vide */
			GardienTeleprotable gar = (GardienTeleprotable)(g.videCase(getX(),getY()));  /* On le retire de la case et on le stock dans la variable gar */
			setPosition(xnew,ynew);   /* On change la position qui lui est associée */
			g.setCase(xnew,ynew,gar); /* On le place sur la grille dans la nouvelle case */
		} 
	}
}