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
 * Servlet implementation class SupprimerProduit
 */
@WebServlet("/SupprimerProduit")
public class SupprimerProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String produitb = request.getParameter("produitbefore");
		String produit = request.getParameter("produit");
		String prix = request.getParameter("prix");
		String quantite = request.getParameter("quantite");		
		
		PreparedStatement st;
		try {
		if(produitb.equalsIgnoreCase(produit)) {
			System.out.println("suppresion");
			st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("delete from `Produit` where nom=?");
			st.setString(1, produitb);
		}
		else {
			System.out.println("modification");
			st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("UPDATE `Produit` SET nom=?,prix=?,quantite=? WHERE nom=?");
			st.setString(1, produit);
			st.setString(2, prix);
			st.setString(3,quantite);
			st.setString(4, produitb);
		}
				
			st.executeUpdate(); 
			System.out.println("fin insersion");
			ConnexionBDD.getInstance().closeCnx();
			RequestDispatcher rd = request.getRequestDispatcher("/RecupeProduit") ;
			if(rd!=null)
				rd.forward(request, response) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
