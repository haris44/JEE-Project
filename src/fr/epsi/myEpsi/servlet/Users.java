package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class Users
 */

@WebServlet("/Users")
public class Users extends HttpServlet {
	
	IUserService service = new UserService();
	Logger logger =  LogManager.getLogger(Users.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("get Users");
		List<User> user = service.getListOfUsers();
		request.setAttribute("user", user);
		request.getRequestDispatcher("Users.jsp").forward(request, response);
	}

}
