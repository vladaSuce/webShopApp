package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

import model.ModelPretrageDTO;
import model.Namestaj;

public class Namestaji {


	private static String NAMESTAJ_DATOTETKA="C:/WebShopVlada/namestaji.dat";
	private static Namestaji instance;
	protected ArrayList<Namestaj>namestaji;

	private Namestaji(){
		namestaji =  new ArrayList<Namestaj>();
		loadNamestaji();
	}


	private void saveNamestaji() throws Exception{
		File f = new File(NAMESTAJ_DATOTETKA);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(namestaji);
		oos.close();
	}
	private void loadNamestaji() {
		try{
			namestaji.clear();
			File f  = new File(NAMESTAJ_DATOTETKA);
			FileInputStream fis = null;
			ObjectInputStream object = null;
			URL resource=null;
			try{
				fis= new FileInputStream(f);
				object = new ObjectInputStream(fis);

			}catch(Exception exp){
				f.createNewFile();	
				resource = getClass().getClassLoader().getResource("./datoteke/namestaji.dat");
				fis= new FileInputStream(resource.getPath());
				object = new ObjectInputStream(fis);
			}
			namestaji = (ArrayList<Namestaj>)object.readObject();
			object.close();
			fis.close();
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}

	public void addNamestaj(Namestaj namestaj) throws Exception{
		for(Namestaj n : namestaji){
			if(n.equals(namestaj))
				throw new Exception("Namestaj sa sifrom: "+namestaj.getSifra() + " vec postoji u sistemu" );
		}
		namestaji.add(namestaj);
		saveNamestaji();
	}
	public void removeNamestaj(String sifraNamestaja) throws Exception{
		Namestaj namestaj = loadNamestaj(sifraNamestaja);
		for(Namestaj namestajTemp : namestaji){
			if (namestajTemp.equals(namestaj)){
				namestaji.remove(namestajTemp);
				saveNamestaji();
				break;
			}
		}
	}
	public void editNamestaj(Namestaj noviNamestaj) throws Exception{
		for(Namestaj namestaj : namestaji){
			if (namestaj.equals(noviNamestaj)){
				namestaji.remove(namestaj);
				namestaji.add(noviNamestaj);
				saveNamestaji();
			}
		}
	}

	public Namestaj loadNamestaj(String sifraNamestaja) throws Exception {
		Namestaj retVal = null;
		for(Namestaj namestaj : namestaji){
			if(namestaj.getSifra().trim().equalsIgnoreCase(sifraNamestaja)){
				retVal=namestaj;
				break;
			}
		}
		if (retVal==null)
			throw new Exception("Namestaj sa sifrom: "+sifraNamestaja+" ne postoji u sistemu!");
		return retVal;
	}
	public ArrayList<Namestaj>pretragaNamestaja(ModelPretrageDTO info,int tipPretrage) throws Exception{
		ArrayList<Namestaj> retVal = new ArrayList<Namestaj>();
		switch(tipPretrage){
		case (TipPretrageNamestaja.PRETRAGA_PO_NAZIVU):{
			for (Namestaj n : namestaji){
					if(n.getNaziv().toLowerCase().contains(info.getNaziv().toLowerCase()))
						retVal.add(n);
			}
			return retVal;
		}
		case(TipPretrageNamestaja.PRETRAGA_PO_BOJI):{
			for (Namestaj n : namestaji){
				if(n.getBoja().toLowerCase().equals(info.getBoja().toLowerCase()))
					retVal.add(n);
		}
		return retVal;
		}
		case(TipPretrageNamestaja.PRETRAGA_PO_GODINI_PROIZVODNJE):{
			for (Namestaj n : namestaji){
				if(n.getGodinaProizvodnje()==info.getGodinaProizvodnje())
					retVal.add(n);
		}
		return retVal;
		}
		default :{
			throw new Exception("Neadekvatan tip pretrage!");
			}
		}
	}


	public ArrayList<Namestaj> getNamestaji() {
		return namestaji;
	}


	public void setNamestaji(ArrayList<Namestaj> namestaji) {
		this.namestaji = namestaji;
	}


	public static Namestaji getInstance(){
		if(instance!=null){
			return instance;
		}
		else
			return new Namestaji();
	}


	public ArrayList<Namestaj> getNamestajiByNazivKategorije(
			String nazivKategorije) {
		ArrayList<Namestaj> retVal =  new ArrayList<Namestaj>();
		for(Namestaj n : namestaji){
			//if(n.getKategorija().getNaziv().equals(nazivKategorije)|| (n.getKategorija().getPodKategorija().equals(nazivKategorije))){
			if(n.getKategorija().getNaziv().equals(nazivKategorije)){
				retVal.add(n);
			}
		}
		return retVal;
	}
}
