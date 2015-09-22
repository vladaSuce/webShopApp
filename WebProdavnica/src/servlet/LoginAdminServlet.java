package servlet;

import model.Korisnik;
import server.model.WebProdavnica;

public class LoginAdminServlet extends LoginUserServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4703233134946252386L;

	@Override
	protected boolean loginSucessfull(Korisnik korisnik, WebProdavnica prodavnica)
			throws Exception {
		return prodavnica.loginAdmin(korisnik.getKorisnickoIme(), korisnik.getLozinka());
	}
}
