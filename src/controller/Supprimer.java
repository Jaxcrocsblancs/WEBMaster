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

import com.mysql.jdbc.PreparedStatement;

import dao.ConnexionBDD;

/**
 * Servlet implementation class Supprimer
 */
@WebServlet("/Supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userb = request.getParameter("userbefore");
		String user = request.getParameter("user");
		String mdp = request.getParameter("mdp");
		String admin = request.getParameter("admin");
		PreparedStatement st;
		try {
		if(userb.equalsIgnoreCase(user)) {
			System.out.println("suppresion");
			st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("delete from User where pseudo=?");
			st.setString(1, userb);
		}
		else {
			System.out.println("modification");
			st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("UPDATE User SET pseudo=?,mdp=?,admin=? WHERE pseudo=?");
			st.setString(1, user);
			st.setString(2, mdp);
			st.setBoolean(3,Boolean.getBoolean(admin));
			st.setString(4, userb);
		}
				
			st.executeUpdate(); 
			System.out.println("fin insersion");
			String laRequette = "SELECT * FROM User WHERE 1" ;
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
			ConnexionBDD.getInstance().closeCnx();
			RequestDispatcher rd = request.getRequestDispatcher("EspaceAdmin.jsp") ;
			if(rd!=null)
				rd.forward(request, response) ;
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
