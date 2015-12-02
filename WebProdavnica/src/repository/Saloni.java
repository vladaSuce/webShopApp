package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import model.Salon;

public class Saloni implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4217180814367395612L;

	private static String SALONI_DATOTEKA="C:/WebShopVlada/saloni.dat";
	private static Saloni instance;
	protected ArrayList<Salon>saloni;

	private Saloni(){
		saloni = new ArrayList<Salon>();
		loadSaloni();
	}


	public ArrayList<Salon> getSaloni() {
		return saloni;
	}
	public void setSaloni(ArrayList<Salon> saloni) {
		this.saloni = saloni;
	}
	public static Saloni getInstance(){
		if (instance!=null){
			return instance;
		}
		return new Saloni();
	}

	private void loadSaloni() {
		try{
			saloni.clear();
			URL resource =null;
			File f  = new File(SALONI_DATOTEKA);
			FileInputStream fis = null;
			ObjectInputStream object = null;

			try{
				fis= new FileInputStream(f);
				object = new ObjectInputStream(fis);

			}catch(Exception exp){
				f.createNewFile();	
				resource = getClass().getClassLoader().getResource("./datoteke/saloni.dat");
				fis= new FileInputStream(resource.getPath());
				object = new ObjectInputStream(fis);
			}

			saloni = (ArrayList<Salon>)object.readObject();
			object.close();
			fis.close();
		}catch(Exception exp){	
			saloni = new ArrayList<Salon>();
		}
	}

	private void saveSaloni() throws Exception{
		File f = new File(SALONI_DATOTEKA);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(saloni);
		oos.close();
	}
	public void addSalon(Salon salon) throws Exception{
		saloni.add(salon);	
		saveSaloni();
	}




}
