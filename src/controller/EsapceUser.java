package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class EsapceUser
 */
@WebFilter(
		urlPatterns = {"/EspaceUser.jsp"}
		)
public class EsapceUser implements Filter {

    /**
     * Default constructor. 
     */
    public EsapceUser() {
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
		HttpSession session = ((HttpServletRequest) request).getSession();
		RequestDispatcher rd;
		if(null == session.getAttribute("id")){
			 rd = request.getRequestDispatcher("/Authentification.jsp") ;
			
		}
		else {
			rd = request.getRequestDispatcher("/RecupeProduit") ;
		}
		 rd.forward(request, response) ;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
