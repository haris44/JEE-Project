package fr.epsi.myEpsi.servlet;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.IMessageService;
import fr.epsi.myEpsi.service.MessageService;

/**
 * Servlet implementation class Message
 */
@WebServlet("/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMessageService messageService;
	Logger logger =  LogManager.getLogger(Message.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message() {
        super();
        messageService = new MessageService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String test = request.getParameter("id");

		User connected = (User) request.getSession().getAttribute("user");	
		ArrayList<Status> listStatus = Status.getList();
	
		if(test != null && connected != null){
			logger.info("GET /Message");
			logger.debug(request);
			fr.epsi.myEpsi.beans.Message message = messageService.getMessage(Long.parseLong(request.getParameter("id"))); 
			request.setAttribute("message", message );
			request.setAttribute("status", listStatus );
			request.getRequestDispatcher("Message.jsp").forward(request, response);
		} else {
			 response.sendRedirect("Messages");
		}
	}

	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("POST /Message");
		logger.debug(request);
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
				logger.error("User not connectd",request);
			  response.sendRedirect("Signin");
		} else if(request.getParameter("action") != null && request.getParameter("action").equals("DELETE")) {
			this.doDelete(request, response);
		} else if(request.getParameter("action") != null && request.getParameter("action").equals("PUT")) {
			this.doPut(request, response);
		}else {   
			fr.epsi.myEpsi.beans.Message message = new fr.epsi.myEpsi.beans.Message();
			message.setTitle(request.getParameter("title"));
		    message.setContent(request.getParameter("content"));
		    message.setCreationDate(new Timestamp(new Date().getTime()));
		    message.setUpdateDate(new Timestamp(new Date().getTime()));
		    message.setAuthor(connected); 
		    message.setStatus(Status.valueOf(request.getParameter("status")));
		    messageService.addMessage(message);
		    response.sendRedirect("Messages");
		}
	 }
	
	/** 
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User connected = (User) request.getSession().getAttribute("user");
		String id = request.getParameter("id");
		if(id != null && connected != null){
			fr.epsi.myEpsi.beans.Message message = messageService.getMessage(Long.parseLong(request.getParameter("id"))); 
			messageService.deleteMessage(message);
			response.sendRedirect("Messages");
		} else {
			 response.sendRedirect("Signin");
		}
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			  response.sendRedirect("Signin");
		} else {
			fr.epsi.myEpsi.beans.Message message = messageService.getMessage(Long.parseLong(request.getParameter("id")));
		    messageService.updateMessageStatus(message, Status.valueOf(request.getParameter("status")).ordinal());
		    response.sendRedirect("Messages");
		}
	}
}
