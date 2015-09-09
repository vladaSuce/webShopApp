package model;

public class AkcijskaKategorija extends Kategorija {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5535066673537045888L;
	
	protected int popustProcenat;
	
	

	public AkcijskaKategorija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AkcijskaKategorija(String naziv, String opis, String podKategorija) {
		super(naziv, opis, podKategorija);
		// TODO Auto-generated constructor stub
	}

	public AkcijskaKategorija(String naziv, String opis) {
		super(naziv, opis);
		// TODO Auto-generated constructor stub
	}

	public AkcijskaKategorija(int popustProcenat) {
		super();
		this.popustProcenat = popustProcenat;
	}

	public int getPopustProcenat() {
		return popustProcenat;
	}

	public void setPopustProcenat(int popustProcenat) {
		this.popustProcenat = popustProcenat;
	}
	
}
