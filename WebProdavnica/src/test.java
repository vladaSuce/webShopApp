import model.Korisnik;
import model.Korisnik.Uloga;
import repository.Korisnici;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Korisnici korisnici = Korisnici.getInstance();
		Korisnik k = new Korisnik();
		k.seteMail("kupac@webshopapp.com");
		k.setIme("kupac");
		k.setKontaktTelefon("");
		k.setKorisnickoIme("kupac");
		k.setLozinka("kupac");
		k.setUloga(Uloga.kupac);
		try {
			korisnici.addKorisnik(k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
