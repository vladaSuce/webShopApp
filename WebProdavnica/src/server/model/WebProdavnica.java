package server.model;

import java.util.ArrayList;

import model.DodatnaUsluga;
import model.Kategorija;
import model.Korisnik;
import model.ModelPretrageDTO;
import model.Namestaj;
import model.Racun;
import model.Salon;
import repository.DodatneUsluge;
import repository.Kategorije;
import repository.Korisnici;
import repository.Namestaji;
import repository.Racuni;
import repository.SalonRepo;
import repository.TipPretrageNamestaja;



public class WebProdavnica {

	private DodatneUsluge usluge ;
	private Kategorije kategorije ;
	private Korisnici korisnici ;
	private Namestaji namestaji ;	
	private SalonRepo salonRepo;
	private Racuni racuni;
	private static WebProdavnica instance;

	public WebProdavnica(){
		korisnici = Korisnici.getInstance();
		salonRepo = SalonRepo.getInstance();
		usluge = DodatneUsluge.getInstance();
		kategorije = Kategorije.getInstance();
		namestaji = Namestaji.getInstance();
		racuni = Racuni.getInstance();

	}
	public static WebProdavnica getInstance(){
		if(instance!=null){
			return instance;
		}
		else
			return new WebProdavnica();
	}

	public synchronized Kategorija loadKategorija(String katNaziv) throws Exception{
		return kategorije.loadKategorija(katNaziv);
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
	public synchronized ArrayList<Namestaj>pretragaNamestaja(ModelPretrageDTO dto,int tipPretrage) throws Exception{
		return namestaji.pretragaNamestaja(dto, tipPretrage);
	}
	public synchronized boolean loginKorisnik(String userName,String password) throws Exception{
		return korisnici.loginKorisnik(userName, password);
	}
	public synchronized boolean loginAdmin(String userName,String password) throws Exception{
		return korisnici.loginAdmin(userName, password);
	}
	public synchronized Korisnik loadKorisnik(String userName){
		return korisnici.loadKorisnik(userName);
	}
	public synchronized Salon getSalon (){
		return salonRepo.getSalon();
	}
	public synchronized void printKorisnici(){
		for(int i =0;i<korisnici.getAllKorisnik().size();i++){
			System.out.println("korisnik :"+i+" "+korisnici.getAllKorisnik().get(i));
		}
	}
	public synchronized void printKategorije(){
		if(kategorije!=null){
			for(int i =0;i<kategorije.getAllKategorija().size();i++){
				System.out.println("kategorija :"+i+" "+kategorije.getAllKategorija().get(i).toString());
			}
		}

	}
	public synchronized void printDodUSL(){
		if(usluge!=null){
			for(int i =0;i<usluge.getUsluge().size();i++){
				System.out.println("usluga :"+i+" "+usluge.getUsluge().get(i));
			}
		}

	}

	public synchronized void printNamestaj(){
		if(namestaji!=null){
			for(int i =0;i<namestaji.getNamestaji().size();i++){
				System.out.println("namestaj :"+i+" "+namestaji.getNamestaji().get(i));
			}
		}

	}
	public synchronized ArrayList<Kategorija>getAllKategorije(){
		return kategorije.getAllKategorija();
	}
	public synchronized ArrayList<Kategorija>getAllRootKategorije(){
		return kategorije.getAllRootKategorija();
	}
	public synchronized ArrayList<DodatnaUsluga>getAllDodatneUsluge(){
		return usluge.getUsluge();
	}
	
	public synchronized ArrayList<Namestaj>getAllNamestaj(){
		return namestaji.getNamestaji();
	}
	public synchronized ArrayList<Namestaj>getNamestajByKategorija(String nazivKategorije) throws Exception{
		return namestaji.getNamestajiByNazivKategorije(nazivKategorije);
	}
	public synchronized ArrayList<Racun>getAllRacuni(){
		return racuni.getRacuni();
	}
	public synchronized void addRacun(Racun r) throws Exception{
		racuni.addRacun(r);
	}
	public ArrayList<Racun>getProdajaPoDanu(String datum) throws Exception{
		return racuni.loadRacunByDatum(datum);
	}
	public ArrayList<Racun>getProdajaOdDo(String datumOd,String datumDo) throws Exception{
		return racuni.getProdajaOdDo(datumOd,datumDo);
	}
	public ArrayList<Racun>getProdajaOdDo(String datumOd,String datumDo,String kategorija) throws Exception{
		return racuni.getProdajaOdDoKategorija(datumOd, datumDo, kategorija);
	}
	public ArrayList<Kategorija>getAllPodKategorije(String nazivNadKategorije){
		return kategorije.getAllPodKategorije(nazivNadKategorije);
	}
	public void removeAllKategorije() throws Exception{
		while(kategorije.getAllKategorija().size()>0)
		kategorije.removeKategorija(kategorije.getAllKategorija().get(0).getNaziv());
	}
}
