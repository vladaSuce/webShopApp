package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

import model.Korisnik;
import model.Korisnik.Uloga;

public class Korisnici {
	public static Korisnici instance;
	private static String KORISNICI_DATOTEKA="C:/WebShopVlada/korisnici.dat";
	protected ArrayList<Korisnik>korisnici;
	private Korisnici(){
		korisnici = new ArrayList<Korisnik>();
		loadKorisnici();
	}

	public void saveKorisnici(){
		try{

			File f = new File(KORISNICI_DATOTEKA);
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
			URL resource =null;
			File f  = new File(KORISNICI_DATOTEKA);
			FileInputStream fis = null;
			ObjectInputStream object = null;

			try{
				fis= new FileInputStream(f);
				object = new ObjectInputStream(fis);

			}catch(Exception exp){
				File direktorijum= new File("C:/WebShopVlada");
				direktorijum.mkdir();
				f.createNewFile();	
				resource = getClass().getClassLoader().getResource("./datoteke/korisnici.dat");
				fis= new FileInputStream(resource.getPath());
				object = new ObjectInputStream(fis);
			}
			korisnici = (ArrayList<Korisnik>) object.readObject();
			object.close();
			fis.close();
		} catch (Exception e){
			korisnici = new ArrayList<Korisnik>();
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
	public boolean loginKorisnik(String userName,String password){
		boolean retVal =false;
		for(Korisnik k :korisnici){
			if(k.getKorisnickoIme().equals(userName)&& k.getLozinka().equals(password)&& k.getUloga()!=Uloga.prodavac){
				retVal =true;
				break;
			}
		}
		return retVal;
	}
	public boolean loginAdmin(String userName,String password){
		boolean retVal =false;
		for(Korisnik k :korisnici){
			if(k.getKorisnickoIme().equals(userName)&& k.getLozinka().equals(password)){
				if(k.getUloga().equals(Uloga.prodavac))
					retVal =true;
				else
					retVal=false;
				break;
			}
		}
		return retVal;
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
	public ArrayList<Korisnik> getAllKorisnik(){
		return korisnici;
	}
}
