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
public class SupprimerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUser() {
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
			ConnexionBDD.getInstance().closeCnx();
			RequestDispatcher rd = request.getRequestDispatcher("/RecupeUser") ;
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
