package model;

public class AkcijskiNamestaj extends Namestaj {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9119313410183510607L;
	protected String datumPocetka;
	protected String datumKraja;
	protected int popustProcenat;
	public AkcijskiNamestaj(String datumPocetka, String datumKraja,
			int popustProcenat) {
		super();
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.popustProcenat = popustProcenat;
	}
	public AkcijskiNamestaj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AkcijskiNamestaj(Salon salon, Kategorija kategorija, String sifra,
			String naziv, String boja, String zemljaProizvodnje,
			String nazivProizvodjaca, double jedinicnaCena,
			int kolicinaUMagacinu, int godinaProizvodnje, byte[] multimedia) {
		super(salon, kategorija, sifra, naziv, boja, zemljaProizvodnje,
				nazivProizvodjaca, jedinicnaCena, kolicinaUMagacinu, godinaProizvodnje,
				multimedia);
		// TODO Auto-generated constructor stub
	}
	public String getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public String getDatumKraja() {
		return datumKraja;
	}
	public void setDatumKraja(String datumKraja) {
		this.datumKraja = datumKraja;
	}
	public int getPopustProcenat() {
		return popustProcenat;
	}
	public void setPopustProcenat(int popustProcenat) {
		this.popustProcenat = popustProcenat;
	}
	
	
}
