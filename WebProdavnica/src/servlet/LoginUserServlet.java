package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.model.WebProdavnica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.DodatnaUsluga;
import model.Kategorija;
import model.Korisnik;
import model.Korisnik.Uloga;
import model.Namestaj;
import model.Racun;
import model.Salon;

/**
 * Servlet implementation class LoginUserServlet
 */
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUserServlet() {
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
		try{



			HttpSession session = request.getSession();

			Korisnik user =(Korisnik)session.getAttribute("user");


			response.setContentType("application/json"); 
			// get received JSON data from request
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String json = "";
			if(br != null){
				json = br.readLine();
			}
			// deserialize JOSN to Java object
			Gson gson = new GsonBuilder().create();
			Korisnik korisnik = gson.fromJson(json, Korisnik.class);
			WebProdavnica prodavnica = WebProdavnica.getInstance();
			JsonObject result = new JsonObject();

			if(loginSucessfull(korisnik, prodavnica)){
				// TODO: write some logic to check whether user exist or not, return statusCode other than 200 in response

				// put page name for redirection in result JSON
				korisnik=prodavnica.loadKorisnik(korisnik.getKorisnickoIme());
				session.setAttribute("user", korisnik);
				ArrayList<Salon> saloni = prodavnica.getSaloni();
				if(korisnik.getUloga().equals(Uloga.kupac)){
					Racun korpa = new Racun();
					korpa.setKupac(korisnik);
					korpa.setListaNamestaja(new ArrayList<Namestaj>());
					String pattern = "yyyy/MM/dd HH:mm:ss";
					SimpleDateFormat format = new SimpleDateFormat(pattern);
					Calendar cal = Calendar.getInstance();
					String datumVreme = format.format(cal.getTime());
					format = new SimpleDateFormat("dd/MM/yyyy");
					String datum = format.format(cal.getTime());
					korpa.setDatumVreme(datumVreme);
					korpa.setDatumKupovine(datum);
					session.setAttribute("korpa", korpa);
				}
				session.setAttribute("saloni", saloni);
				ArrayList<Kategorija> kategorije =  prodavnica.getAllRootKategorije();
				session.setAttribute("kategorije", kategorije);
				ArrayList<Kategorija> kategorijeSvihNivoa =  prodavnica.getAllKategorije();
				session.setAttribute("kategorijeSvihNivoa", kategorijeSvihNivoa);
				ArrayList<DodatnaUsluga>dodatneUsluge = prodavnica.getAllDodatneUsluge();
				session.setAttribute("dodatneUsluge", dodatneUsluge);
				String urlToRedirect = "Home.jsp";
				result.addProperty("url", urlToRedirect);
				//	result.add("type", "POST");
			}


			else{
				response.setStatus(404);
			}


			// put result into response
			//				System.out.println(result.toString());
			response.getWriter().write(result.toString());



		}catch(Exception exp){
			throw new ServletException(exp);
		}

	}

	protected boolean loginSucessfull(Korisnik korisnik, WebProdavnica prodavnica)
			throws Exception {
		return prodavnica.loginKorisnik(korisnik.getKorisnickoIme(), korisnik.getLozinka());
	}

}
