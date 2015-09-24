import model.DodatnaUsluga;
import model.Kategorija;
import model.Korisnik;
import model.Korisnik.Uloga;
import model.Namestaj;
import repository.DodatneUsluge;
import repository.Kategorije;
import repository.Korisnici;
import repository.Namestaji;
import server.model.WebProdavnica;


public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Korisnici korisnici = Korisnici.getInstance();
//		Korisnik k = new Korisnik();
//		k.seteMail("kupac@webshopapp.com");
//		k.setIme("kupac");
//		k.setKontaktTelefon("");
//		k.setKorisnickoIme("kupac");
//		k.setLozinka("kupac");
//		k.setUloga(Uloga.kupac);
//		try {
//			korisnici.addKorisnik(k);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//		DodatneUsluge dodusl = DodatneUsluge.getInstance();
//		DodatnaUsluga usluga = new DodatnaUsluga("test", "opis", 123);
//		dodusl.addUsluga(usluga);
		
//		Kategorije kat = Kategorije.getInstance();
//		Kategorija k = new Kategorija("Bastenski namestaj", "bambus");
//		kat.addKategorija(k);
		
		WebProdavnica prodavnica= WebProdavnica.getInstance();
		Namestaj n = new Namestaj();
		n.setBoja("Braon");
		n.setGodinaProizvodnje(2015);
		n.setKategorija(prodavnica.loadKategorija("Dnevne sobe"));
		n.setJedinicnaCena(72575);
		n.setKolicinaUMagacinu(10);
		n.setNaziv("MODULARNI SET: FRONTAL");
		n.setSalon(prodavnica.getSalon());
		n.setNazivProizvodjaca("vitorog");
		n.setSifra("00402");
		prodavnica.addNmestaj(n);
		prodavnica.printNamestaj();
		prodavnica.printKategorije();
//		DodatnaUsluga dod =  new DodatnaUsluga();
//		dod.setNaziv("Izrada posebnog stofa");
//		dod.setOpis("Troskovi izrade stofa koji je van stof karte");
//		dod.setCena(3000);
//		prodavnica.printDodUSL();//(dod);
//		Kategorija k = new Kategorija();
//		k.setNaziv("Dnevne sobe");
//		k.setOpis("");
	//	prodavnica.dodajKategoriju(k);
//		prodavnica.removeKorisnik(prodavnica.loadKorisnik("vlada"));
		//prodavnica.removeKorisnik(prodavnica.loadKorisnik("nela"));
//		prodavnica.removeKorisnik(prodavnica.loadKorisnik("nela"));
	}
}
