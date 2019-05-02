package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnexionBDD;

/**
 * Servlet implementation class RecupeUser
 */
@WebServlet("/RecupeUser")
public class RecupeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupeUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String laRequette = "SELECT * FROM `User` WHERE 1" ;
			Statement statement2= ConnexionBDD.getInstance().getCnx().createStatement();
			
	    	ResultSet resultatBis = statement2.executeQuery(laRequette);
	    	ArrayList<String> listeUser = new ArrayList<String>();
	    	ArrayList<String> listeMdp = new ArrayList<String>();
	    	ArrayList<Boolean> listeAdmin = new ArrayList<Boolean>();
	    	while ( resultatBis.next() ) {
	    		listeUser.add(resultatBis.getString( "pseudo" ));
	    		listeMdp.add(resultatBis.getString( "mdp" ));
	    		listeAdmin.add(resultatBis.getBoolean("admin"));
	    	}
	        request.setAttribute("listUser", listeUser);
			request.setAttribute("listMdp", listeMdp);
			request.setAttribute("listAdmin", listeAdmin);
			RequestDispatcher rd = request.getRequestDispatcher("EspaceAdmin/User.jsp") ;
			/*Fermeture connexion*/
			ConnexionBDD.getInstance().closeCnx();
			if(rd!=null)
				rd.forward(request, response) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
