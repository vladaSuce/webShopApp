package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Racun implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7002957384751192543L;
	protected ArrayList<Namestaj>listaNamestaja;
	protected double porez;
	protected double ukupnaCena;
	protected String datumVreme;
	protected Korisnik kupac;
	
	public Racun(){}

	public Racun( double porez,
			double ukupnaCena, String datumVreme, Korisnik kupac) {
		super();
		this.porez = porez;
		this.ukupnaCena = ukupnaCena;
		this.datumVreme = datumVreme;
		this.kupac = kupac;
	}

	public ArrayList<Namestaj> getListaNamestaja() {
		return listaNamestaja;
	}

	public void setListaNamestaja(ArrayList<Namestaj> listaNamestaja) {
		this.listaNamestaja = listaNamestaja;
	}

	public double getPorez() {
		return porez;
	}

	public void setPorez(double porez) {
		this.porez = porez;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public String getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(String datumVreme) {
		this.datumVreme = datumVreme;
	}

	public Korisnik getKupac() {
		return kupac;
	}

	public void setKupac(Korisnik kupac) {
		this.kupac = kupac;
	}

	@Override
	public String toString() {
		return "Racun [listaNamestaja=" + listaNamestaja + ", porez=" + porez
				+ ", ukupnaCena=" + ukupnaCena + ", datumVreme=" + datumVreme
				+ ", kupac=" + kupac + "]";
	}
	
	
	
}
