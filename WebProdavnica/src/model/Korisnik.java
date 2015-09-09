package model;

import java.io.Serializable;

public class Korisnik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4385424943673326636L;

	public static enum Uloga{menadzer,prodavac,kupac}
	protected String korisnickoIme;
	protected String lozinka;
	protected String ime;
	protected Uloga uloga;
	protected String kontaktTelefon;
	protected String eMail;
	
	public Korisnik(){}

	public Korisnik(String korisnickoIme, String lozinka, String ime,
			Uloga uloga, String kontaktTelefon, String eMail) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.uloga = uloga;
		this.kontaktTelefon = kontaktTelefon;
		this.eMail = eMail;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Korisnik "
				+ "[\n"
				+ "korisnickoIme=" + korisnickoIme + "\n" 
				+ " lozinka= "+ lozinka +"\n "
				+ " ime= " + ime + "\n "
				+ " uloga= " + uloga + "\n"
				+ " kontaktTelefon= " + kontaktTelefon+ "\n"
				+ " eMail= " + eMail + "\n"
				+ "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		Korisnik korisnik = (Korisnik)obj;
		if(getKorisnickoIme().trim().equalsIgnoreCase(korisnik.getKorisnickoIme().trim()))
			return true;
		else return false;
	}
}
