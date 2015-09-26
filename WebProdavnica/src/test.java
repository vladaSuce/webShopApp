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
		
	WebProdavnica prodavnica= WebProdavnica.getInstance();
	prodavnica.printKategorije();
	
//	Kategorija k = new Kategorija();
//	k.setNadKategorija(null);
//	k.setNaziv("Decije sobe");
//	k.setPodKategorije(null);
//	k.setOpis("");
//	prodavnica.dodajKategoriju(k);
//	Korisnici korisnici = Korisnici.getInstance();
//	Korisnik k = new Korisnik();
//	k.seteMail("menadzer@webshopapp.com");
//	k.setIme("menadzer");
//	k.setKontaktTelefon("");
//	k.setKorisnickoIme("menadzer");
//	k.setLozinka("menadzer");
//	k.setUloga(Uloga.menadzer);

//	
//	Kategorija k = new Kategorija();
//	k.setNadKategorija("Uvozne kuhinje");
//	k.setNaziv("Italijanske kuhinje");
//	k.setPodKategorije(null);
//	k.setOpis("");
//	prodavnica.dodajKategoriju(k);
//	
	
//	for(Namestaj n : prodavnica.getAllNamestaj()){
//		if(n.getNaziv().equals("Nika tafla kuhinja")){
//			System.out.println(n);
//			n.setSifra("s00290");
//			prodavnica.editNamestaj(n);
//		}
	
	

		
	

		
////		
//		
//		WebProdavnica prodavnica= WebProdavnica.getInstance();
		Namestaj n = new Namestaj();
		n.setBoja("Braon");
		n.setGodinaProizvodnje(2015);
		n.setKategorija(prodavnica.loadKategorija("Decije sobe"));
		n.setJedinicnaCena(73000);
		n.setKolicinaUMagacinu(10);
		n.setNaziv("KREVETAC SARA Z-22");
		n.setSalon(prodavnica.getSalon());
		n.setNazivProizvodjaca("SaraDOO");
		n.setSifra("s00580");
		prodavnica.addNmestaj(n);
//		prodavnica.printNamestaj();
//		prodavnica.printKategorije();
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
