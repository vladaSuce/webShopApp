package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DodatnaUsluga;
import server.model.WebProdavnica;

import com.google.gson.JsonObject;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class DodatneUslugeServlet
 */
public class DodatneUslugeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodatneUslugeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
			response.sendRedirect("./LoginForm.jsp");
		String parametri = request.getParameter("name");
		String[] nizParametara=parametri.split("\\?");
		String nazivDodUSl  = nizParametara[0];
		String function =nizParametara[1];
		WebProdavnica prodavnica = WebProdavnica.getInstance();
		try {
			DodatnaUsluga usluga = prodavnica.loadDodatnaUsluga(nazivDodUSl);
			if(function.equals("delete")){
				prodavnica.deleteUsluga(usluga);
				ArrayList<DodatnaUsluga> usluge = prodavnica.getAllDodatneUsluge();
				request.getSession().setAttribute("dodatneUsluge", usluge);
				response.sendRedirect("./DodatneUsluge.jsp");
			}
			else{
				response.sendRedirect("./EditDodatnaUsluga.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
