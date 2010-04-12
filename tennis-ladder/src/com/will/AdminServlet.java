package com.will;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;


/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger log = Logger.getLogger(AdminServlet.class.getName());



    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doService(request, response);
	}

	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("hit!");
	    String user=request.getParameter("admin");
	    String passwd=request.getParameter("password");
	    String url=request.getParameter("redirectURL");
	    if((!"will".equalsIgnoreCase(user))||(!"tennis".equals(passwd))){
		log.warning("ahthentication failed!");
		log.warning("ip:"+request.getRemoteAddr());
		log.warning("user:"+user);
		log.warning("passwd:"+passwd);
		return;//do nothing
	    }
	    if(null==url||!url.startsWith("http://")){
		log.warning("invalid url:"+url);
	    }
	    getServletContext().setAttribute("redirectURL", url);
	    log.info("url:"+url);
	    PrintWriter out = response.getWriter();
	    out.println("new redirect url:"+url);

	}

}
