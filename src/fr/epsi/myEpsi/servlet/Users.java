package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.UserService;
import utils.CannotDeleteAdminException;
import utils.DuplicateUserException;

/**
 * Servlet implementation class Users
 */

@WebServlet("/Users")
public class Users extends HttpServlet {
	
	IUserService userService;
	Logger logger =  LogManager.getLogger(Users.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        userService = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GET /Users");
	    logger.debug(request);
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			  response.sendRedirect("Signin");
		} else if(!connected.getAdministrator()){
			  response.sendRedirect("Messages");
		} else {
			List<User> users = userService.getListOfUsers();
			request.setAttribute("user", users);
			request.getRequestDispatcher("Users.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User connected = (User) request.getSession().getAttribute("user");
		if(connected != null && request.getParameter("action") != null && request.getParameter("action").equals("DELETE")) {
			this.doDelete(request, response);
		} else if(connected != null &&request.getParameter("action") != null && request.getParameter("action").equals("PUT")) {
			this.doPut(request, response);
		} else if(request.getParameter("password").equals(request.getParameter("repassword"))){   
			User user = new User();
			user.setId(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));
			user.setAdministrator(Boolean.parseBoolean(request.getParameter("admin")));
			try {
				userService.addUser(user);
			} catch (DuplicateUserException e) {
				logger.error("Cannot create two user with same ID");
			}
			response.sendRedirect("Users");
		} else {
			response.sendRedirect("Users");
		}
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("login");
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			  response.sendRedirect("Signin");
		} else {
			User user = userService.getUserById(id);
			try {
				userService.deleteUser(user);
			} catch (CannotDeleteAdminException e) {
				logger.error("cannot delete user");
			}
			response.sendRedirect("Users");
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("login");
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			  response.sendRedirect("Signin");
		} else if(request.getParameter("password").equals(request.getParameter("repassword"))) {
			User user = new User();
			user.setId(id);
			user.setPassword(request.getParameter("password"));
			user.setAdministrator(Boolean.parseBoolean(request.getParameter("admin")));
			userService.updateUser(user);
			response.sendRedirect("Users");
		} else {
			response.sendRedirect("Users");
		}
	}

}
