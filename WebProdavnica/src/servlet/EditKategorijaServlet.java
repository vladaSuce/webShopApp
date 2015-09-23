package servlet;

import model.Kategorija;
import server.model.WebProdavnica;

public class EditKategorijaServlet extends AddKategorijaServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1051413224805001576L;

	@Override
	protected void updateKategorije(Kategorija kategorija,WebProdavnica prodavnica) {
		try {
			prodavnica.editKategoriju(kategorija);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
