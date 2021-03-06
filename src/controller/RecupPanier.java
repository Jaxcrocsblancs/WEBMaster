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
import javax.servlet.http.HttpSession;

import dao.ConnexionBDD;

/**
 * Servlet implementation class RecupPanier
 */
@WebServlet("/RecupPanier")
public class RecupPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		try {
			String laRequette = "SELECT * FROM `Panier` WHERE user = '" + session.getAttribute("nom") + "'" ;
			Statement statement2= ConnexionBDD.getInstance().getCnx().createStatement();
			
	    	ResultSet resultatBis = statement2.executeQuery(laRequette);
	    	ArrayList<String> listeProduit = new ArrayList<String>();
	    	ArrayList<String> listePrix = new ArrayList<String>();
	    	ArrayList<String> listeQuantite = new ArrayList<String>();
	    	while ( resultatBis.next() ) {
	    		listeProduit.add(resultatBis.getString( "nom" ));
	    		listePrix.add(resultatBis.getString( "prix" ));
	    		listeQuantite.add(resultatBis.getString("quantite"));
	    	}
	    	
	        request.setAttribute("listProduit", listeProduit);
			request.setAttribute("listPrix", listePrix);
			request.setAttribute("listQuantite", listeQuantite);
			RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp") ;
			/*Fermeture connexion*/
			ConnexionBDD.getInstance().closeCnx();
			if(rd!=null)
				rd.forward(request, response) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
