package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import dao.ConnexionBDD;

/**
 * Servlet implementation class AjouterPanier
 */
@WebServlet("/AjouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterProduit() {
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
		try {
	       PreparedStatement st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("insert into `Produit` values(?, ?, ?)"); 
	       st.setString(1, request.getParameter("produit")); 
	       st.setString(2, request.getParameter("prix")); 
	       st.setString(3, request.getParameter("quantite"));
	       System.out.println("insertion");
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
