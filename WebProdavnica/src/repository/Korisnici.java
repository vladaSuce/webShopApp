package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Korisnik;

public class Korisnici {
	public static Korisnici instance;
	private static String KORISNICI_DATOTEKA="korisnici.dat";
	protected ArrayList<Korisnik>korisnici;
	private Korisnici(){
		korisnici = new ArrayList<Korisnik>();
		loadKorisnici();
	}

	public void saveKorisnici(){
		try{
			File f = new File(KORISNICI_DATOTEKA);

			if (!f.exists()){
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(korisnici);
			oos.close();


		} catch (Exception e){
			e.printStackTrace();
		}
	}
	private void loadKorisnici(){
		try{
			korisnici.clear();
			File f = new File(KORISNICI_DATOTEKA);
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream object = new ObjectInputStream(fos);
			korisnici = (ArrayList<Korisnik>) object.readObject();
			object.close();
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	public void addKorisnik(Korisnik korisnik)  throws Exception{
		for(Korisnik k : korisnici){
			if(k.equals(korisnik))
				throw new Exception("Zeljeni korisnik "+korisnik.toString() + " je vec unet u sistem");
		}	
		korisnici.add(korisnik);	
		saveKorisnici();	

	}
	public Korisnik loadKorisnik(String userName){
		Korisnik retVal =null;
		for(Korisnik k :korisnici){
			if(k.getKorisnickoIme().equalsIgnoreCase(userName)){
				retVal=k;
				break;
			}
		}
		return retVal;
	}
	public void deleteKorisnik(String userName)throws Exception{
		Korisnik k= loadKorisnik(userName);
		if(k!=null){
			for(Korisnik korisnik :korisnici){
				if (korisnik.equals(k)){
					korisnici.remove(korisnik);
					saveKorisnici();
				}
			}
		}
		else{
			throw new Exception("Korisnik sa korisnickim imenom: "+userName+" ne postoji!");
		}

	}
	public void editKorisnik(Korisnik k){
		for(Korisnik korisnik :korisnici){
			if(korisnik.equals(k)){
				korisnici.remove(korisnik);
				korisnici.add(k);
				saveKorisnici();
				break;
			}
		}
	}
	public static Korisnici getInstance(){
		if(instance!=null)
			return instance;
		else 
			return new Korisnici();
	}
}
