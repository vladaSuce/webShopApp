import model.DodatnaUsluga;
import model.Kategorija;
import model.Korisnik;
import model.Korisnik.Uloga;
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
		prodavnica.printKorisnici();
	}
}
