package com.will;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.will.data.entity.Configuration;
import com.will.mail.MailTemplate;
import com.will.service.DataStoreService;
import com.will.service.MailerService;


/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger log = Logger.getLogger(AdminServlet.class.getName());
	 private static DataStoreService dataService=new DataStoreService();
	 private static MailerService mailService=new MailerService();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {

        super();
        log.info("Application started");
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
	    log.info("hit!");
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
	    Configuration c=new Configuration();
	    c.setProperty(Configuration.PROPERTIES.URL_REDIRECT);
	    c.setValue(url);
	    c.setUpdateBy(user+"@"+request.getRemoteAddr());

//	     service=new DataStoreService();
	    dataService.saveConfig(c);

	    mailService.sendMail(new MailTemplate());

//	    getServletContext().setAttribute("redirectURL", url);
//	    Constants.REDIRECT_URL=url;
	    System.out.println("new config:"+c);
	    PrintWriter out = response.getWriter();
	    out.println("new redirect url:"+url);

	}

	public static String getRedirectURL(){

	    return dataService.getRedirectURL();
	}

}
