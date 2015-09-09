package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Kategorija;

public class Kategorije {
	private static String KATEGORIJE_DATOTETKA="kategorije.dat";
	private static Kategorije instance;
	protected ArrayList<Kategorija>kategorije;

	private Kategorije(){
		kategorije =  new ArrayList<Kategorija>();
		loadKategorije();
	}

	private void saveKategorije() throws Exception{
		File f = new File(KATEGORIJE_DATOTETKA);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(kategorije);
		oos.close();
	}
	private void loadKategorije() {
		try{
			kategorije.clear();
			File f = new File(KATEGORIJE_DATOTETKA);
			if(!f.exists()){
				f.createNewFile();
			}
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			kategorije = (ArrayList<Kategorija>)ois.readObject();
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}
	public void addKategorija(Kategorija kategorija) throws Exception{
		for(Kategorija kat : kategorije){
			if(kat.equals(kategorija))
			 throw new Exception("Kategorija sa nazivom:  "+kategorija.getNaziv() + " vec postoji u sistemu" );
		}
		kategorije.add(kategorija);
		saveKategorije();
	}
	public void removeKategorija(String nazivKategorije) throws Exception{
		Kategorija kategorija = loadKategorija(nazivKategorije);
		for(Kategorija kategorijaTemp : kategorije){
			if (kategorijaTemp.equals(kategorija)){
				kategorije.remove(kategorijaTemp);
				saveKategorije();
				break;
			}
		}
	}
	public void editKategorija(Kategorija novaKategorija) throws Exception{
		for(Kategorija kategorija : kategorije){
			if (kategorija.equals(novaKategorija)){
				kategorije.remove(kategorija);
				kategorije.add(novaKategorija);
				saveKategorije();
			}
		}
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
}
