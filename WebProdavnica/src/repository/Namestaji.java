package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

import model.DodatnaUsluga;
import model.Kategorija;
import model.ModelPretrageNamestajaDTO;
import model.Namestaj;
import model.RezultatPretrageDTO;

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
			namestaji = new ArrayList<Namestaj>();
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

				break;
			}
		}
		saveNamestaji();
	}
	public void editNamestaj(Namestaj noviNamestaj) throws Exception{
		for(Namestaj namestaj : namestaji){
			if (namestaj.equals(noviNamestaj)){
				namestaji.remove(namestaj);
				namestaji.add(noviNamestaj);

				break;
			}
		}
		saveNamestaji();
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
	public RezultatPretrageDTO pretraga(ModelPretrageNamestajaDTO info) throws Exception{
		ArrayList<Namestaj> namestaj = new ArrayList<Namestaj>();
		ArrayList<DodatnaUsluga> dodatneUsluge = new ArrayList<DodatnaUsluga>();
		RezultatPretrageDTO retVal= new RezultatPretrageDTO();
		return retVal;
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
			String nazivKategorije) throws Exception {
		ArrayList<Namestaj> retVal =  new ArrayList<Namestaj>();
		for(Namestaj n : namestaji){
			if(n.getKategorija().getNaziv().equals(nazivKategorije)){
				retVal.add(n);
			}
		}
		addPodKategorijaNamestaj(retVal,nazivKategorije);

		return retVal;
	}


	private void addPodKategorijaNamestaj(ArrayList<Namestaj> retVal,String naziv) throws Exception {
		Kategorija kategoija = Kategorije.getInstance().loadKategorija(naziv);
		if(kategoija.getPodKategorije()!=null && kategoija.getPodKategorije().size()>0){
			for(String nazivPodkategorije : kategoija.getPodKategorije()){
				addPodKategorijaNamestaj(retVal, nazivPodkategorije);
			}
		}
		for(Namestaj namestaj : namestaji){
			if(namestaj.getKategorija().getNaziv().equals(naziv)){
				if(!retVal.contains(namestaj)){
					retVal.add(namestaj);
				}
			}
		}
	}
}
