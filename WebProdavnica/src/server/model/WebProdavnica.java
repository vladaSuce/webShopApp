package server.model;

import java.util.ArrayList;

import model.DodatnaUsluga;
import model.Kategorija;
import model.Korisnik;
import model.ModelPretrageDTO;
import model.Namestaj;
import repository.DodatneUsluge;
import repository.Kategorije;
import repository.Korisnici;
import repository.Namestaji;
import repository.TipPretrageNamestaja;



public class WebProdavnica {

	private DodatneUsluge usluge ;
	private Kategorije kategorije ;
	private Korisnici korisnici ;
	private Namestaji namestaji ;	

	public WebProdavnica(){
		usluge = DodatneUsluge.getInstance();
		kategorije = Kategorije.getInstance();
		korisnici = Korisnici.getInstance();
		namestaji = Namestaji.getInstance();

	}

	public synchronized void dodajKategoriju(Kategorija kat) throws Exception{
		kategorije.addKategorija(kat);
	}
	public synchronized void editKategoriju(Kategorija kat) throws Exception{
		kategorije.editKategorija(kat);
	}
	public synchronized void deleteKategorija(Kategorija kat) throws Exception{
		kategorije.removeKategorija(kat.getNaziv());
	}
	public synchronized void deleteKategorija(String kategorijaNaziv) throws Exception{
		kategorije.removeKategorija(kategorijaNaziv);
	}
	public synchronized void addDodatnaUsluga(DodatnaUsluga usluga) throws Exception{
		usluge.addUsluga(usluga);
	}
	public synchronized void removeDodatnaUsluga(DodatnaUsluga usluga) throws Exception{
		usluge.removeUsluga(usluga.getNaziv());
	}
	public synchronized void removeDodatnaUsluga(String uslugaNaziv) throws Exception{
		usluge.removeUsluga(uslugaNaziv);
	}
	public synchronized void editDodatnaUsluga(DodatnaUsluga usluga) throws Exception{
		usluge.editUsluga(usluga);
	}
	public synchronized ArrayList<DodatnaUsluga>pretragaUslugaPoNazivu(String naziv) throws Exception{
		return usluge.pretragaUsluga(naziv, DodatneUsluge.pretragaPoNazivu);
	}
	public synchronized ArrayList<DodatnaUsluga>pretragaUslugaPoOpisu(String opis) throws Exception{
		return usluge.pretragaUsluga(opis, DodatneUsluge.pretragaPoOpisu);
	}
	public synchronized void addKorisnik(Korisnik korisnik) throws Exception{
		korisnici.addKorisnik(korisnik);
	}
	public synchronized void removeKorisnik(Korisnik korisnik) throws Exception{
		korisnici.deleteKorisnik(korisnik.getKorisnickoIme());
	}
	public synchronized void removeKorisnik(String korisnickoIme) throws Exception{
		korisnici.deleteKorisnik(korisnickoIme);
	}
	public synchronized void editKorisnik(Korisnik korisnik) throws Exception{
		korisnici.editKorisnik(korisnik);
	}
	public synchronized void addNmestaj(Namestaj namestaj) throws Exception{
		namestaji.addNamestaj(namestaj);
	}
	public synchronized void editNamestaj(Namestaj namestaj) throws Exception{
		namestaji.editNamestaj(namestaj);
	}
	public synchronized void removeNamestaj(String sifraNamestaja) throws Exception{
		namestaji.removeNamestaj(sifraNamestaja);
	}
	public synchronized void removeNamestaj(Namestaj namestaj) throws Exception{
		namestaji.removeNamestaj(namestaj.getSifra());
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoNazivu(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_NAZIVU);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoOpseguCena(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_OPSEGU_CENA);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoRaspolozivojKolicini(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_RASPOLOZIVOJ_KOLICINI);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoOpisu(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_OPISU);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoTipu(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_TIPU);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoZemljiProizvodnje(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_ZEMLJI_PROIZVODNJE);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoBoji(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_BOJI);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoGodiniProizvodnje(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_GODINI_PROIZVODNJE);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaPoNazivuProizvodjaca(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.PRETRAGA_PO_NAZIVU_PROIZVODJACA);
	}
	public synchronized ArrayList<Namestaj>pretragaNamestajaMULTY(ModelPretrageDTO dto) throws Exception{
		return namestaji.pretragaNamestaja(dto, TipPretrageNamestaja.MULTI_PRETRAGA);
	}
}
