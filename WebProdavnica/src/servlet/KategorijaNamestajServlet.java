package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Namestaj;
import server.model.WebProdavnica;

/**
 * Servlet implementation class KategorijaNamestajServlet
 */
public class KategorijaNamestajServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KategorijaNamestajServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nazivKategorije =  request.getParameter("name");
		if(nazivKategorije==null){
			doPost(request, response);
		}
		WebProdavnica prodavnica = WebProdavnica.getInstance();
		ArrayList<Namestaj> kategorijskiNamestaj = prodavnica.getNamestajByKategorija(nazivKategorije);
		HttpSession session = request.getSession();
		session.setAttribute("katnamestaj", kategorijskiNamestaj);
		response.sendRedirect("Home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Home.jsp");
	}

}
