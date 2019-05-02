package controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class tes
 */
@WebFilter(
		urlPatterns = {"/EspaceAdmin.jsp"}
		)
public class Filtre implements Filter {

    /**
     * Default constructor. 
     */
    public Filtre() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Cookie[] listeCookies = req.getCookies();
		boolean admin = false;
		if(listeCookies != null) {
			for(Cookie c: listeCookies) {
				String Cname = c.getName();
				String Cvalue = c.getValue();
				if(Cname =="admin" && Cvalue =="ok") {
					admin = true;
				}
			
			}
		}
		if(!admin) {
			RequestDispatcher rd =request.getRequestDispatcher("Authentification.jsp");
			rd.forward(request, response);
		}
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
