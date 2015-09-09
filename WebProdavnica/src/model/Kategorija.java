package model;

import java.io.Serializable;

public class Kategorija implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6644945537089463016L;
	protected String naziv;
	protected String opis;
	protected String podKategorija;
	public Kategorija(){}
	public Kategorija(String naziv, String opis) {
		super();
		this.naziv = naziv;
		this.opis = opis;
	}
	public Kategorija(String naziv, String opis, String podKategorija) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.podKategorija = podKategorija;
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
	public String getPodKategorija() {
		return podKategorija;
	}
	public void setPodKategorija(String podKategorija) {
		this.podKategorija = podKategorija;
	}
	@Override
	public String toString() {
		return "Kategorija [naziv=" + naziv + ", opis=" + opis
				+ ", podKategorija=" + podKategorija + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj== null)
			return false;
		Kategorija kata = (Kategorija)obj;
		if(getNaziv().trim().equalsIgnoreCase(kata.getNaziv().trim()))
			return true;
		else
			return false;
	}
	
}
