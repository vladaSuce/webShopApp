package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ModelPretrageNamestajaDTO;
import model.RezultatPretrageDTO;
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
		ModelPretrageNamestajaDTO pretraga = gson.fromJson(json, ModelPretrageNamestajaDTO.class);
		WebProdavnica prodavnica = WebProdavnica.getInstance();

		
		
		try {
			RezultatPretrageDTO rezultatPretrage = prodavnica.pretragaNamestaja(pretraga);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
