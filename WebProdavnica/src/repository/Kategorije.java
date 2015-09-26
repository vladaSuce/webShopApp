package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

import model.Kategorija;
import model.Namestaj;

public class Kategorije {
	private static String KATEGORIJE_DATOTETKA="/C:/WebShopVlada/kategorije.dat";
	private static Kategorije instance;
	protected ArrayList<Kategorija>kategorije;

	private Kategorije(){
		kategorije =  new ArrayList<Kategorija>();
		loadKategorije();
	}

	public void saveKategorije() throws Exception{
		File f = new File(KATEGORIJE_DATOTETKA);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(kategorije);
		oos.close();
	}
	public void loadKategorije() {
		try{
			kategorije.clear();
			URL resource =null;
			File f  = new File(KATEGORIJE_DATOTETKA);
			FileInputStream fis = null;
			ObjectInputStream object = null;

			try{
				fis= new FileInputStream(f);
				object = new ObjectInputStream(fis);

			}catch(Exception exp){
				f.createNewFile();	
				resource = getClass().getClassLoader().getResource("./datoteke/kategorije.dat");
				fis= new FileInputStream(resource.getPath());
				object = new ObjectInputStream(fis);
			}
			
			kategorije = (ArrayList<Kategorija>)object.readObject();
			object.close();
			fis.close();
		}catch(Exception exp){
			kategorije =  new ArrayList<Kategorija>();
		}
	}
	public void addKategorija(Kategorija kategorija) throws Exception{
		for(Kategorija kat : kategorije){
			if(kat.equals(kategorija))
			 throw new Exception("Kategorija sa nazivom:  "+kategorija.getNaziv() + " vec postoji u sistemu" );
		}
		if(kategorija.getNadKategorija()!=null && (!kategorija.getNadKategorija().trim().equals(""))){
			boolean nadjenPredak = false;
			for(Kategorija kat : kategorije){
				if(kategorija.getNadKategorija().equals(kat.getNaziv())){
					nadjenPredak = true;
					if(kat.getPodKategorije()==null)
						kat.setPodKategorije(new ArrayList<String>());
					kat.getPodKategorije().add(kategorija.getNaziv());
					editKategorija(kat);
					break;
				}
			}
			if(!nadjenPredak)
				throw new Exception("Nije pronadjen predak: "+kategorija.getNadKategorija()+" za kategoriju "+kategorija.getNaziv());
		}
		loadKategorije();
		kategorije.add(kategorija);
		saveKategorije();
	}
	public synchronized void  removeKategorija(String nazivKategorije) throws Exception{
		Kategorija kategorija = loadKategorija(nazivKategorije);
		for(Namestaj n : Namestaji.getInstance().namestaji){
			if(n.getKategorija().equals(kategorija)){
				n.setKategorija(null);
				Namestaji.getInstance().editNamestaj(n);
			}
				
		}
		for(Kategorija kategorijaTemp : kategorije){
			if(kategorijaTemp.getNadKategorija().equals(kategorija.getNaziv())){
				if(kategorijaTemp.getPodKategorije()!=null)
					removeKategorija(kategorijaTemp.getNaziv());
				kategorije.remove(kategorijaTemp);
			}
		}
		kategorije.remove(kategorija);
		saveKategorije();
	}
	public void editKategorija(Kategorija novaKategorija) throws Exception{
		for(Kategorija kategorija : kategorije){
			if (kategorija.equals(novaKategorija)){
				kategorije.remove(kategorija);
				kategorije.add(novaKategorija);
				break;
			}
		}
		saveKategorije();
	}

	public Kategorija loadKategorija(String nazivKategorije) throws Exception {
		Kategorija retVal = null;
		for(Kategorija kategorija : kategorije){
			if(kategorija.getNaziv().trim().equalsIgnoreCase(nazivKategorije)){
				retVal=kategorija;
				break;
			}
		}
		if (retVal==null)
			throw new Exception("Kategorija sa nazivom: "+nazivKategorije+" ne postoji u sistemu!");
		return retVal;
	}


	public static Kategorije getInstance(){
		if(instance!=null){
			return instance;
		}
		else
			return new Kategorije();
	}
	public ArrayList<Kategorija> getAllRootKategorija(){
		ArrayList<Kategorija> retVal = new ArrayList<Kategorija>();
		for(Kategorija kat : kategorije){
			if(kat.getNadKategorija()==null || kat.getNadKategorija().trim().equals("")){
				retVal.add(kat);
			}
		}
		return retVal;
	}
	public ArrayList<Kategorija>getAllKategorija(){
		return kategorije;
	}

	public ArrayList<Kategorija> getAllPodKategorije(String nazivNadKategorije) {
		ArrayList<Kategorija> retVal = new ArrayList<Kategorija>();
		for(Kategorija kat : kategorije){
			if(kat.getNadKategorija()!=null && (!kat.getNadKategorija().trim().equals(""))&& kat.getNadKategorija().equals(nazivNadKategorije)){
				retVal.add(kat);
			}
		}
		return retVal;
	}
}
