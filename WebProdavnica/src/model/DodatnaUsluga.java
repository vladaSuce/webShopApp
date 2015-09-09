package model;

import java.io.Serializable;

public class DodatnaUsluga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2819206760986121403L;
	protected String naziv;
	protected String opis;
	protected double cena;
	
	public DodatnaUsluga(){}

	
	public DodatnaUsluga(String naziv, String opis, double cena) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
	}
	


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	@Override
	public String toString() {
		return "DodatnaUsluga [naziv=" + naziv + ", opis=" + opis + ", cena="
				+ cena + "]";
	}
	
}
