package model;

public class ModelPretrageDTO {

	protected String naziv;
	protected double cenaOd;
	protected double cenaDo;
	protected int raspolozivaKolicina;
	protected String opis;
	protected String nazivTipa;
	protected String zemljaProizvodnje;
	protected int godinaProizvodnje;
	protected String boja;
	protected String nazivProizvodjaca;
	
	
	
	
	public ModelPretrageDTO(String naziv, double cenaOd, double cenaDo,
			int raspolozivaKolicina, String opis, String nazivTipa,
			String zemljaProizvodnje, int godinaProizvodnje, String boja,
			String nazivProizvodjaca) {
		super();
		this.naziv = naziv;
		this.cenaOd = cenaOd;
		this.cenaDo = cenaDo;
		this.raspolozivaKolicina = raspolozivaKolicina;
		this.opis = opis;
		this.nazivTipa = nazivTipa;
		this.zemljaProizvodnje = zemljaProizvodnje;
		this.godinaProizvodnje = godinaProizvodnje;
		this.boja = boja;
		this.nazivProizvodjaca = nazivProizvodjaca;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCenaOd() {
		return cenaOd;
	}
	public void setCenaOd(double cenaOd) {
		this.cenaOd = cenaOd;
	}
	public double getCenaDo() {
		return cenaDo;
	}
	public void setCenaDo(double cenaDo) {
		this.cenaDo = cenaDo;
	}
	public int getRaspolozivaKolicina() {
		return raspolozivaKolicina;
	}
	public void setRaspolozivaKolicina(int raspolozivaKolicina) {
		this.raspolozivaKolicina = raspolozivaKolicina;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getNazivTipa() {
		return nazivTipa;
	}
	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}
	public String getZemljaProizvodnje() {
		return zemljaProizvodnje;
	}
	public void setZemljaProizvodnje(String zemljaProizvodnje) {
		this.zemljaProizvodnje = zemljaProizvodnje;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	public String getNazivProizvodjaca() {
		return nazivProizvodjaca;
	}
	public void setNazivProizvodjaca(String nazivProizvodjaca) {
		this.nazivProizvodjaca = nazivProizvodjaca;
	}
	
	
	}
