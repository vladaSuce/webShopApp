package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.model.WebProdavnica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Korisnik;

/**
 * Servlet implementation class RemoveUserServlet
 */
public class RemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Korisnik user = (Korisnik)request.getAttribute("user");
		if(user!=null){
			response.setContentType("application/json"); 
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String json = "";
			if(br != null){
				json = br.readLine();
			}
			Gson gson = new GsonBuilder().create();
			Korisnik korisnik = gson.fromJson(json, Korisnik.class);
			WebProdavnica prodavnica = WebProdavnica.getInstance();
			Korisnik korisnikZaBrisanje = prodavnica.loadKorisnik(korisnik.getKorisnickoIme());
			if(korisnikZaBrisanje!=null  ){
				if( !korisnikZaBrisanje.equals(user)){
					try {
						prodavnica.removeKorisnik(korisnikZaBrisanje.getKorisnickoIme());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					response.sendError(401,"Can't delete logged usser");
				}
			}
			else{

				response.sendError(401,"User not found");

			}

		}
		else {
			response.sendError(401,"User nog logged");
			response.sendRedirect("./loginUserServlet");
		}
	}

}
