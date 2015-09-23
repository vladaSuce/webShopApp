package repository;

import model.Salon;

public class SalonRepo {

	private static SalonRepo instance;
	protected Salon salon;
	
	public static SalonRepo getInstance(){
		if(instance==null)
			instance = new SalonRepo();
		return instance;
	}
	public SalonRepo(){
		this.salon = new Salon();
		salon.setAdresa("Novosadskog sajma 27");
		salon.setBrojZiroRacuna("840-0000000000123-97");
		salon.seteMail("salon@gmail.com");
		salon.setMaticniBroj("3003990850003");
		salon.setNaziv("Vladin salon namestaja");
		salon.setTelefon("021/547-160");
		salon.setPib("3003990103");
		salon.setWebPage("");
	}
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	
}
