package fr.epsi.myEpsi.servlet;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.ConnectionService;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger =  LogManager.getLogger(Signin.class.getName());
	private UserService userService;
	private ConnectionService connectionService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        userService = new UserService();
        connectionService = new ConnectionService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    logger.info("GET /Signin");
	    logger.debug(request);
		request.getRequestDispatcher("Signin.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    logger.info("POST /Signin");
	    logger.debug(request);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	     
	       User user = new User(username, password, false);
	        System.out.println(connectionService.isAuthorized(user));
	        if (user.getPassword() != null && user.getId() != null && connectionService.isAuthorized(user) ) {
	            request.getSession().setAttribute("user", userService.getUserById(username));
	            response.sendRedirect("Messages");
	        } 
	        else { 
	        	logger.error("Signin error",username,password,request);
	        	request.getRequestDispatcher("Signin.jsp").forward(request, response);
	        }
	}
	

}
