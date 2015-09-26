package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Namestaj;
import model.Racun;

public class Racuni {
	private static String RACUNI_DATOTEKA="C:/WebShopVlada/racuni.dat";
	private static Racuni instance;
	protected ArrayList<Racun>racuni;


	private Racuni(){
		racuni =  new ArrayList<Racun>();
		loadRacuni();
	}

	private void saveRacuni() throws Exception{
		File f = new File(RACUNI_DATOTEKA);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(racuni);
		oos.close();
	}
	private void loadRacuni() {
		try{
			racuni.clear();
			URL resource =null;
			File f  = new File(RACUNI_DATOTEKA);
			FileInputStream fis = null;
			ObjectInputStream object = null;

			try{
				fis= new FileInputStream(f);
				object = new ObjectInputStream(fis);

			}catch(Exception exp){
				f.createNewFile();	
				resource = getClass().getClassLoader().getResource("./datoteke/racuni.dat");
				fis= new FileInputStream(resource.getPath());
				object = new ObjectInputStream(fis);
			}
			
			racuni = (ArrayList<Racun>)object.readObject();
			object.close();
			fis.close();
		}catch(Exception exp){	
			racuni = new ArrayList<Racun>();
		}
	}
	public void addRacun(Racun racun) throws Exception{
		racuni.add(racun);	
		saveRacuni();
	}



	public ArrayList<Racun> loadRacunByDatum(String datumRacuna) throws Exception {
		ArrayList<Racun> retVal = new ArrayList<Racun>();
		for(Racun racun : racuni){
			if(racun.getDatumKupovine().equalsIgnoreCase(datumRacuna)){
				
				retVal.add(racun);
			}
		}

		return retVal;
	}
	


	public ArrayList<Racun> getRacuni() {
		return racuni;
	}



	public static Racuni getInstance(){
		if(instance!=null){
			return instance;
		}
		else
			return new Racuni();
	}

	public ArrayList<Racun> getProdajaOdDo(String datumOd, String datumDo) throws ParseException {
		ArrayList<Racun>retVal =  new ArrayList<Racun>();
		for(Racun r:racuni){
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			Date datumRacuna = format.parse(r.getDatumVreme());
			Date datumod = format.parse(datumOd);
			Date datumdo = format.parse(datumDo);
			if((datumRacuna.compareTo(datumod)>=0)&&(datumRacuna.compareTo(datumdo)<=0)){
				retVal.add(r);
			}
		}
		return retVal;
	}
	public ArrayList<Racun> getProdajaOdDoKategorija(String datumOd, String datumDo,String kategorija) throws ParseException {
		ArrayList<Racun>racunifilter =  new ArrayList<Racun>();
		for(Racun r:racuni){
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			Date datumRacuna = format.parse(r.getDatumVreme());
			Date datumod = format.parse(datumOd);
			Date datumdo = format.parse(datumDo);
			if((datumRacuna.compareTo(datumod)>=0)&&(datumRacuna.compareTo(datumdo)<=0)){
				racunifilter.add(r);
			}
		}
		for(Racun r:racunifilter){
			for(Namestaj namestaj : r.getListaNamestaja()){
				if(!namestaj.getKategorija().equals(kategorija)){
					racunifilter.remove(r);
					break;
				}
			}
		}
		return racunifilter;
	}
}
