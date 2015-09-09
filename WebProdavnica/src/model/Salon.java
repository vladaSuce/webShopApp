package model;

import java.io.Serializable;

public class Salon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3314813896685003412L;
	protected String naziv;
	protected String adresa;
	protected String telefon;
	protected String eMail;
	protected String webPage;
	protected String pib;
	protected String maticniBroj;
	protected String brojZiroRacuna;
	
	protected Salon(){}

	public Salon(String naziv, String adresa, String telefon, String eMail,
			String webPage, String pib, String maticniBroj,
			String brojZiroRacuna) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.eMail = eMail;
		this.webPage = webPage;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.brojZiroRacuna = brojZiroRacuna;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public String getBrojZiroRacuna() {
		return brojZiroRacuna;
	}

	public void setBrojZiroRacuna(String brojZiroRacuna) {
		this.brojZiroRacuna = brojZiroRacuna;
	}

	@Override
	public String toString() {
		return "Salon [naziv=" + naziv + ", adresa=" + adresa + ", telefon="
				+ telefon + ", eMail=" + eMail + ", webPage=" + webPage
				+ ", pib=" + pib + ", maticniBroj=" + maticniBroj
				+ ", brojZiroRacuna=" + brojZiroRacuna + "]";
	}
	

}
