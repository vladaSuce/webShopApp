package servlet;

import model.DodatnaUsluga;
import server.model.WebProdavnica;

public class EditDodatnaUsluga extends AddDodatnaUsluga {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7303593260261095821L;

	@Override
	protected void updateDodatnaUsluga(DodatnaUsluga dodatnaUsluga,WebProdavnica prodavnica) {

		try {
			prodavnica.editDodatnaUsluga(dodatnaUsluga);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
