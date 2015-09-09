package model;

import java.io.Serializable;

public class Namestaj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8788340150841584203L;
	protected Salon salon;
	protected Kategorija kategorija;
	protected String sifra;
	protected String naziv;
	protected String boja;
	protected String zemljaProizvodnje;
	protected String nazivProizvodjaca;
	protected double jedinicnaCena;
	protected int kolicinaUMagacinu;
	protected int godinaProizvodnje;
	protected byte[] multimedia;
	public Namestaj(){}
	public Namestaj(Salon salon, Kategorija kategorija, String sifra,
			String naziv, String boja, String zemljaProizvodnje,
			String nazivProizvodjaca, double jedinicnaCena,
			int kolicinaUMagacinu, int godinaProizvodnje, byte[] multimedia) {
		super();
		this.salon = salon;
		this.kategorija = kategorija;
		this.sifra = sifra;
		this.naziv = naziv;
		this.boja = boja;
		this.zemljaProizvodnje = zemljaProizvodnje;
		this.nazivProizvodjaca = nazivProizvodjaca;
		this.jedinicnaCena = jedinicnaCena;
		this.kolicinaUMagacinu = kolicinaUMagacinu;
		this.godinaProizvodnje = godinaProizvodnje;
		this.multimedia = multimedia;
	}
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	public String getZemljaProizvodnje() {
		return zemljaProizvodnje;
	}
	public void setZemljaProizvodnje(String zemljaProizvodnje) {
		this.zemljaProizvodnje = zemljaProizvodnje;
	}
	public String getNazivProizvodjaca() {
		return nazivProizvodjaca;
	}
	public void setNazivProizvodjaca(String nazivProizvodjaca) {
		this.nazivProizvodjaca = nazivProizvodjaca;
	}
	public double getJedinicnaCena() {
		return jedinicnaCena;
	}
	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}
	public int getKolicinaUMagacinu() {
		return kolicinaUMagacinu;
	}
	public void setKolicinaUMagacinu(int kolicinaUMagacinu) {
		this.kolicinaUMagacinu = kolicinaUMagacinu;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public byte[] getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(byte[] multimedia) {
		this.multimedia = multimedia;
	}
	@Override
	public String toString() {
		return "Namestaj [salon=" + salon + ", kategorija=" + kategorija
				+ ", sifra=" + sifra + ", naziv=" + naziv + ", boja=" + boja
				+ ", zemljaProizvodnje=" + zemljaProizvodnje
				+ ", nazivProizvodjaca=" + nazivProizvodjaca
				+ ", jedinicnaCena=" + jedinicnaCena + ", kolicinaUMagacinu="
				+ kolicinaUMagacinu + ", godinaProizvodnje="
				+ godinaProizvodnje + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		Namestaj namestaj = (Namestaj)obj;
		if(getSifra().trim().equalsIgnoreCase(namestaj.getSifra().trim()))
			return true;
		else
			return false;
	}
}
