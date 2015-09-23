package servlet;

import model.Kategorija;
import server.model.WebProdavnica;

public class DeleteKategorijaServlet extends AddKategorijaServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5785377402083988254L;

	@Override
	protected void updateKategorije(Kategorija kategorija,WebProdavnica prodavnica) {
		try {
			prodavnica.deleteKategorija(kategorija);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
