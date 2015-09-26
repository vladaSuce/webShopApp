package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Kategorija implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6644945537089463016L;
	protected String naziv;
	protected String opis;
	protected String nadKategorija;
	protected ArrayList<String> podKategorije;
	public Kategorija(){}
	public Kategorija(String naziv, String opis) {
		super();
		this.naziv = naziv;
		this.opis = opis;
	}
	public Kategorija(String naziv, String opis, String nadKategorija) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.nadKategorija = nadKategorija;
	}
	public Kategorija(String naziv, String opis, String nadKategorija,ArrayList<String> podKategorije) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.nadKategorija = nadKategorija;
		this.podKategorije = podKategorije;
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
	public String getNadKategorija() {
		return nadKategorija;
	}
	public void setNadKategorija(String nadKategorija) {
		this.nadKategorija = nadKategorija;
	}
	
	public ArrayList<String> getPodKategorije() {
		return podKategorije;
	}
	public void setPodKategorije(ArrayList<String> podKategorije) {
		this.podKategorije = podKategorije;
	}

	@Override
	public String toString() {
		return "Kategorija [naziv=" + naziv + ", opis=" + opis
				+ ", nadKategorija=" + nadKategorija + ", podKategorije="
				+ podKategorije + "]";
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
