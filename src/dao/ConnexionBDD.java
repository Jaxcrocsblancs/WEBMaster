package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnexionBDD {

	private static volatile ConnexionBDD instance;
	private Connection cnx = null; 
	
	private ConnexionBDD() {
		System.out.println("TEST CONNEXION");
		try {
			
			Properties p = new Properties();
			p.load(Thread.currentThread().getContextClassLoader().
						getResourceAsStream("confBDD.properties"));

			// chargement du driver
			Class.forName(p.getProperty("driver"));  
			
			cnx = DriverManager.getConnection(p.getProperty("url"),
					p.getProperty("user"), p.getProperty("pwd"));
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERREUR SQL");
			e.printStackTrace();
		}
	} 
	
	public static synchronized ConnexionBDD getInstance() {
		if(instance==null)
			instance = new ConnexionBDD();
		return instance;
	}

	public Connection getCnx() {
		System.out.println("cnx: "+cnx==null);
		return cnx;
	}

	public void closeCnx() throws SQLException{
		if(cnx!=null){
			cnx.close();
			instance=null;
		}
	}
}
