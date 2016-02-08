import model.Salon;
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
	Salon salon =new Salon();
	salon.setAdresa("Novosadskog sajma 24");
	salon.setBrojZiroRacuna("841-0002000100123-97");
	salon.seteMail("salon2@gmail.com");
	salon.setMaticniBroj("1243990850003");
	salon.setNaziv("Testeric salon namestaja");
	salon.setTelefon("021/545-160");
	salon.setPib("2103990101");
	salon.setWebPage("");
	System.out.println(prodavnica.getAllRootKategorije());
	
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

//		prodavnica.printNamestaj();
//		prodavnica.printKategorije();
//		DodatnaUsluga dod =  new DodatnaUsluga();
//		dod.setNaziv("Prevoz robe van grad");
//		dod.setOpis("Troskovi prevoza robe do adrese kupca na udaljenost od pradavnice do 30 km");
//		dod.setCena(3000);
//		prodavnica.addDodatnaUsluga(dod);
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
