package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.service.IMessageService;
import fr.epsi.myEpsi.service.MessageService;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/Messages")
public class Messages extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    private IMessageService messageService;
    Logger logger =  LogManager.getLogger(Messages.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
        messageService = new MessageService();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GET /Messages");
	    logger.debug(request);
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			logger.error("user not connected", request);
			  response.sendRedirect("Signin");
		} else {
			// Create List Of Status
			ArrayList<Status> listStatus;
			if(connected.getAdministrator()){
				listStatus = new ArrayList<Status>();
				listStatus.add(Status.PUBLIC);
			} else {
				listStatus = Status.getList();
			}
			
			// Get list Of messages
			List<Message> messages = messageService.getListOfMessages(connected);
			request.setAttribute("username", connected.getId());
			request.setAttribute("messages", messages);
			
			// Add Status for option form
			request.setAttribute("status", listStatus );
			request.getRequestDispatcher("Messages.jsp").forward(request, response);
		}
	}
}
