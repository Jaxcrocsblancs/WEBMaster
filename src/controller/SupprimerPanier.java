package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import dao.ConnexionBDD;

/**
 * Servlet implementation class SupprimerPanier
 */
@WebServlet("/SupprimerPanier")
public class SupprimerPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String quantiteb = request.getParameter("quantitebefore");
		String produit = request.getParameter("produit");
		String prix = request.getParameter("prix");
		String quantite = request.getParameter("quantite");		
		
		PreparedStatement st;
		try {
		if(quantiteb == quantite) {
			System.out.println("suppresion");
			st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("delete from `Panier` where user=? and nom = ?");
			st.setString(1, (String) session.getAttribute("nom"));
			st.setString(2, produit);
			
		}
		else {
			System.out.println("modification");
			st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("UPDATE `Panier` WHERE user = ? SET nom=?,prix=?,quantite=? WHERE quantite=?");
			st.setString(1, (String) session.getAttribute("nom"));
			st.setString(2, produit);
			st.setString(3, prix);
			st.setString(4,quantite);
			st.setInt(5, Integer.parseInt(quantiteb));
		}
				
			st.executeUpdate(); 
			System.out.println("fin insersion");
			ConnexionBDD.getInstance().closeCnx();
			RequestDispatcher rd = request.getRequestDispatcher("/AccueilUser.jsp") ;
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
