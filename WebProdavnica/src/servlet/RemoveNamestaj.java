package servlet;

import model.Namestaj;
import server.model.WebProdavnica;

public class RemoveNamestaj extends AddNamestaj {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9207341850317215244L;

	@Override
	protected void updateNamestaj(Namestaj namestaj, WebProdavnica prodavnica) {
		try {
			prodavnica.removeNamestaj(namestaj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
