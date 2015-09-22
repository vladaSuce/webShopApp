package servlet;

import model.Namestaj;
import server.model.WebProdavnica;

public class EditNamestaj extends AddNamestaj {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7030682213973076197L;

	@Override
	protected void updateNamestaj(Namestaj namestaj, WebProdavnica prodavnica) {
		try {
			prodavnica.editNamestaj(namestaj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
