package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

import model.DodatnaUsluga;

public class DodatneUsluge {
	private static String DODATNE_USLUGE_DATOTEKA="C:/WebShopVlada/dodusl.dat";
	private static DodatneUsluge instance;
	protected ArrayList<DodatnaUsluga>usluge;
	public  static final int  pretragaPoNazivu = 1;
	public static final int pretragaPoOpisu = 2;

	private DodatneUsluge(){
		usluge =  new ArrayList<DodatnaUsluga>();
		loadDodatneUsluge();
	}

	private void saveDodatneUsluge() throws Exception{
		File f = new File(DODATNE_USLUGE_DATOTEKA);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(usluge);
		oos.close();
	}
	private void loadDodatneUsluge() {
		try{
			usluge.clear();
			URL resource =null;
			File f  = new File(DODATNE_USLUGE_DATOTEKA);
			FileInputStream fis = null;
			ObjectInputStream object = null;

			try{
				fis= new FileInputStream(f);
				object = new ObjectInputStream(fis);

			}catch(Exception exp){
				f.createNewFile();	
				resource = getClass().getClassLoader().getResource("./datoteke/dodusl.dat");
				fis= new FileInputStream(resource.getPath());
				object = new ObjectInputStream(fis);
			}
			
			usluge = (ArrayList<DodatnaUsluga>)object.readObject();
			object.close();
			fis.close();
		}catch(Exception exp){	
			usluge = new ArrayList<DodatnaUsluga>();
		}
	}
	public void addUsluga(DodatnaUsluga usluga) throws Exception{
		for(DodatnaUsluga usl : usluge){
			if(usl.equals(usluga))
			 throw new Exception("DodatnaUsluga sa nazivom:  "+usluga.getNaziv() + " vec postoji u sistemu" );
		}
		usluge.add(usluga);
		saveDodatneUsluge();
	}
	public void removeUsluga(String nazivUsluge) throws Exception{
		DodatnaUsluga usluga = loadUsluga(nazivUsluge);
		for(DodatnaUsluga uslugaTemp : usluge){
			if (uslugaTemp.equals(usluga)){
				usluge.remove(uslugaTemp);
				break;
			}
		}
		saveDodatneUsluge();
		loadDodatneUsluge();
	}
	public void editUsluga(DodatnaUsluga novaUsluga) throws Exception{
		for(DodatnaUsluga usluga : usluge){
			if (usluga.equals(novaUsluga)){
				usluge.remove(usluga);
				usluge.add(novaUsluga);
				saveDodatneUsluge();
			}
		}
	}

	public DodatnaUsluga loadUsluga(String nazivUsluge) throws Exception {
		DodatnaUsluga retVal = null;
		for(DodatnaUsluga usluga : usluge){
			if(usluga.getNaziv().trim().equalsIgnoreCase(nazivUsluge)){
				retVal=usluga;
				break;
			}
		}
		if (retVal==null)
			throw new Exception("DodatnaUsluga sa nazivom: "+nazivUsluge+" ne postoji u sistemu!");
		return retVal;
	}
	public ArrayList<DodatnaUsluga>pretragaUsluga(String unetTekst,int tipPretrage)throws Exception{
		ArrayList<DodatnaUsluga> retVal = new ArrayList<DodatnaUsluga>();
		switch(tipPretrage){
			case(pretragaPoNazivu):{
				for(DodatnaUsluga dodusl : usluge){
					if(dodusl.getNaziv().toLowerCase().contains(unetTekst.toLowerCase()))
						retVal.add(dodusl);
				}
				return retVal;
			}
			case(pretragaPoOpisu):{
				for(DodatnaUsluga dodusl : usluge){
					if(dodusl.getOpis().toLowerCase().contains(unetTekst.toLowerCase()))
						retVal.add(dodusl);
				}
				return retVal;
				
			}
			default :
				throw new Exception("Los kriterijum pretrage dodatnih usluga.");
			
		}
	}


	public ArrayList<DodatnaUsluga> getUsluge() {
		return usluge;
	}

	public void setUsluge(ArrayList<DodatnaUsluga> usluge) {
		this.usluge = usluge;
	}

	public static DodatneUsluge getInstance(){
		if(instance!=null){
			return instance;
		}
		else
			return new DodatneUsluge();
	}
}
