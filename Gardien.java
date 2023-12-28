
// LYES SID ALI 21220655

public class Gardien extends Contenu{

	//ATTRIBUTS
	protected int pv;  // points de vie du gardien

	//CONSTRUCTEUR
	public Gardien(int qt){
		super("Gardien",qt);
		this.pv = 200;   /* initialise ses points de vie a 200 (maximum) */
	}

	//METHODES
	public String toString(){
		return super.toString()+" pts de vie : "+this.pv;
	}

	public int getPv(){       /* Getteur pour les pv */
		return this.pv;
	}

	public void setPv(int f){
		this.pv = this.pv -f;    /* Setteur pour reduire les pv du gardien lorsqu'il se bat avec un agent */
	}
}