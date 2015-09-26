package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import model.Namestaj;
import server.model.WebProdavnica;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(kategorijskiNamestaj, new TypeToken<List<Namestaj>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);

/*

		HttpSession session = request.getSession();
		session.setAttribute("katnamestaj", kategorijskiNamestaj);
		response.sendRedirect("Home.jsp");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Home.jsp");
	}

}
