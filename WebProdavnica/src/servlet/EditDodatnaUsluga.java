package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

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
	@Override
	protected void redirect(HttpServletResponse response) {
		
		try {
			JsonObject re = new JsonObject();
			re.addProperty("url", "DodatneUsluge.jsp");
			response.getWriter().print(re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
