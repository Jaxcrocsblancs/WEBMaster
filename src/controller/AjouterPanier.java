package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Random;

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
 * Servlet implementation class AjouterPanier
 */
@WebServlet("/AjouterPanier")
public class AjouterPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterPanier() {
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
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		try {
				Integer i = null;
				Random rand = new Random();
				String price = request.getParameter("prix");
				String quantite = request.getParameter("quantite");
				
		       PreparedStatement st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("insert into `Panier` values(null, ?, ?, ?, ?)"); 
		       st.setString(1,  (String) session.getAttribute("nom"));
		       st.setString(2, request.getParameter("produit")); 
		       st.setInt(3, i.parseInt(price)); 
		       st.setInt(4, i.parseInt(quantite));
		      
		       System.out.println("insertion");
		       System.out.println(st.toString());
		       
		       st.executeUpdate(); 
		       System.out.println("fin insersion");
		       ConnexionBDD.getInstance().closeCnx();
		       
		       request.getRequestDispatcher("/AccueilUser.jsp").forward(request, response);
		      
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
