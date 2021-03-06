package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DodatnaUsluga;
import model.Kategorija;
import model.Korisnik;
import server.model.WebProdavnica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class AddKategorijaServlet
 */
public class AddKategorijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKategorijaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
			response.sendRedirect("./LoginForm.jsp");
		response.setContentType("application/json"); 
		HttpSession session = request.getSession();
		// get received JSON data from request
		System.out.println("tuuuu sam");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		// deserialize JOSN to Java object
		Gson gson = new GsonBuilder().create();
		Kategorija kategorija = gson.fromJson(json, Kategorija.class);
		System.out.println(kategorija);
		WebProdavnica prodavnica = WebProdavnica.getInstance();
		updateKategorije(kategorija, prodavnica);
		ArrayList<Kategorija>kategorije =  prodavnica.getAllKategorije();
		ArrayList<Kategorija>rootKategorije =  prodavnica.getAllRootKategorije();
		session.setAttribute("kategorije", rootKategorije);
		session.setAttribute("kategorijeSvihNivoa", kategorije);
		session.setAttribute("tempKategorija", null);
		redirect(response);
	
	}
	protected void redirect(HttpServletResponse response) {
		
		try {
			JsonObject re = new JsonObject();
			re.addProperty("url", "Home.jsp");
			response.getWriter().print(re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void updateKategorije(Kategorija kategorija,
			WebProdavnica prodavnica) {
		try {
			prodavnica.dodajKategoriju(kategorija);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
