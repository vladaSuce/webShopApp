package servlet;

import model.DodatnaUsluga;
import server.model.WebProdavnica;

public class RemoveDodatnaUsluga extends AddDodatnaUsluga {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8715907748957553061L;

	@Override
	protected void updateDodatnaUsluga(DodatnaUsluga dodatnaUsluga,WebProdavnica prodavnica) {
		try {
			prodavnica.removeDodatnaUsluga(dodatnaUsluga);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
