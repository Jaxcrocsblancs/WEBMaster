package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnexionBDD;

/**
 * Servlet implementation class Servelet
 */
@WebServlet("/Servelet")
public class Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String laRequette = "SELECT * FROM `User` WHERE 1" ;
	
		try {
			Statement statement = ConnexionBDD.getInstance().getCnx().createStatement();
			
			
			/* Exécution d'une requête de lecture */
		    ResultSet resultat = statement.executeQuery( laRequette);

			/* Récupération des données du résultat de la requête de lecture */
			
		    while ( resultat.next() ) {
				String user = resultat.getString( "pseudo" );
			    String mdp = resultat.getString( "mdp" );
			    boolean admin = resultat.getBoolean("admin");
			    System.out.println(user+" "+mdp+" "+admin);
		    }
			
			
			
			
			//inserData.executeUpdate(laRequette);
			ConnexionBDD.getInstance().closeCnx();
		} catch (SQLException e) {
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
