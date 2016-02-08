package model;

import java.util.ArrayList;

public class RezultatPretrageDTO {
	protected ArrayList<Namestaj>namestaj;
	protected ArrayList<DodatnaUsluga>dodatneUsluge;
	public ArrayList<Namestaj> getNamestaj() {
		return namestaj;
	}
	public void setNamestaj(ArrayList<Namestaj> namestaj) {
		this.namestaj = namestaj;
	}
	public ArrayList<DodatnaUsluga> getDodatneUsluge() {
		return dodatneUsluge;
	}
	public void setDodatneUsluge(ArrayList<DodatnaUsluga> dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
	}

}
