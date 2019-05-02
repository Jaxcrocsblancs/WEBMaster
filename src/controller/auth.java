package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnexionBDD;

/**
 * Servlet implementation class auth
 */
@WebServlet("/auth")
public class auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public auth() {
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
		
		String name = request.getParameter("nom"); 
		String mdp = request.getParameter("mdp");
		String laRequette = "SELECT * FROM `User` WHERE 1" ;
		try {
			/*Connexion BDD*/
			Statement statement = ConnexionBDD.getInstance().getCnx().createStatement();

			/* Exécution d'une requête de lecture */
			ResultSet resultat = statement.executeQuery(laRequette);

			/* Récupération des données du résultat de la requête de lecture */
			System.out.println("Debut while");
			RequestDispatcher rd = null;
			while ( resultat.next() ) {
				System.out.println("boucle");
				String nomUtilisateur = resultat.getString( "pseudo" );
			    String motDePasseUtilisateur = resultat.getString( "mdp" );
			    boolean admin = resultat.getBoolean("admin");
			    
			    /*UserFind*/
			    if(name.equalsIgnoreCase(nomUtilisateur) && mdp.equalsIgnoreCase(motDePasseUtilisateur) && admin==false) {
			    	System.out.println("aze");
			    	String laRequetteProduit = "SELECT * FROM `Produit` WHERE 1" ;
			    	Statement statement2 = ConnexionBDD.getInstance().getCnx().createStatement();
			    	ResultSet resultatBis = statement2.executeQuery(laRequetteProduit);
			    	ArrayList<String> listeNom = new ArrayList<String>();
			    	ArrayList<Integer> listePrix = new ArrayList<Integer>();
			    	while ( resultatBis.next() ) {
			    		listeNom.add(resultatBis.getString( "nom" ));
			    		listePrix.add(resultatBis.getInt( "prix" ));
			    		
			    	}
			        request.setAttribute("listNom", listeNom);
					request.setAttribute("listPrix", listePrix);
			    	rd = request.getRequestDispatcher("EspaceUser.jsp") ;
					//rd.forward(request, response) ;
			    }
			    /*AdminFind*/
			    else  if(name.equalsIgnoreCase(nomUtilisateur) && mdp.equalsIgnoreCase(motDePasseUtilisateur) && admin==true) {
			    	System.out.println("admin");
			    	Cookie co = new Cookie("admin", "ok");
					response.addCookie(co);
					Statement statement2 = ConnexionBDD.getInstance().getCnx().createStatement();
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
			    	rd = request.getRequestDispatcher("EspaceAdmin.jsp") ;
					//rd.forward(request, response) ;
			    }
			}
			
			/*Fermeture connexion*/
			ConnexionBDD.getInstance().closeCnx();
			if(rd!=null)
				rd.forward(request, response) ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*String name = request.getParameter("nom"); 
		String mdp = request.getParameter("mdp");
		if( name != null && mdp != null) {
			//response.getWriter().append(name+" "+mdp+" "+(name == "admin")+" "+(mdp == "admin"));
			if(name.equals("admin") && mdp.equals("admin")) {
				Cookie co = new Cookie("admin", "ok");
				response.addCookie(co);
				
				RequestDispatcher rd = request.getRequestDispatcher("EspaceAdmin.jsp") ;
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("EspaceUser.jsp") ;
				rd.forward(request, response) ;
			}
		}
		doGet(request, response);*/
	}

}


/*
String name = request.getParameter("nom"); 
String mdp = request.getParameter("mdp");
if( name != null && mdp != null) {
	//response.getWriter().append(name+" "+mdp+" "+(name == "admin")+" "+(mdp == "admin"));
	if(name.equals("admin") && mdp.equals("admin")) {
		Cookie co = new Cookie("admin", "ok");
		response.addCookie(co);
		
		RequestDispatcher rd = request.getRequestDispatcher("EspaceAdmin.jsp") ;
		rd.forward(request, response);
	}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("EspaceUser.jsp") ;
		rd.forward(request, response) ;
	}
}
doGet(request, response);*/