package fr.epsi.myEpsi.servlet;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Version
 */
@WebServlet("/Version")
public class Version extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger =  LogManager.getLogger(Version.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Version() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    logger.info("GET /Version");
	    logger.debug(request);
		request.getRequestDispatcher("Version.jsp").forward(request, response);
	}

}
