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


@WebServlet("/Ajouter")
public class AjouterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUser() {
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
		String admin = request.getParameter("admin");
		if( admin.equalsIgnoreCase("true") || admin.equalsIgnoreCase("false")) {
			
			try {
				// Create a SQL query to insert data into demo table 
	            // demo table consists of two columns, so two '?' is used 
	            PreparedStatement st = (PreparedStatement) ConnexionBDD.getInstance().getCnx().prepareStatement("insert into User values(?, ?, ?)"); 
	            st.setString(1, request.getParameter("user")); 
	            st.setString(2, request.getParameter("mdp")); 
	            st.setBoolean(3, request.getParameter("admin").equalsIgnoreCase("true"));
	            System.out.println("insertion");
	            st.executeUpdate(); 
				System.out.println("fin insersion");
				ConnexionBDD.getInstance().closeCnx();
				RequestDispatcher rd = request.getRequestDispatcher("/RecupeUser") ;
				if(rd!=null)
					rd.forward(request, response) ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}


}
