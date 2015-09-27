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
import model.ModelPretrageDTO;
import model.Namestaj;
import server.model.WebProdavnica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class PretragaNamestajaServlet
 */
public class PretragaNamestajaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PretragaNamestajaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
			response.sendRedirect("./LoginForm.jsp");
		response.setContentType("application/json"); 
		HttpSession session = request.getSession();
		// get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		// deserialize JOSN to Java object
		Gson gson = new GsonBuilder().create();
		ModelPretrageDTO pretraga = gson.fromJson(json, ModelPretrageDTO.class);
		WebProdavnica prodavnica = WebProdavnica.getInstance();
		int parametar_pretrage = 0;
		try{
			parametar_pretrage =Integer.parseInt( request.getParameter("pretraga"));
		}
		catch(Exception exp ){

		}
		
		try {
			ArrayList<Namestaj>rezultatPretrage = prodavnica.pretragaNamestaja(pretraga,parametar_pretrage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
