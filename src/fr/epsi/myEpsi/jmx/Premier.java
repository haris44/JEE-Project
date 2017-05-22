package fr.epsi.myEpsi.jmx;

import java.security.Timestamp;
import java.util.Date;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.service.IMessageService;
import fr.epsi.myEpsi.service.MessageService;
import fr.epsi.myEpsi.service.UserService;

public class Premier implements PremierMBean {

	private static String name = "Premier MBEAN";
			private int valeur = 1000;
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getValue() {
		return valeur;
	}

	@Override
	public void setValue(int valeur) {
		this.valeur = valeur;
		
	}

	@Override
	public void refresh() {
		System.out.println("Refresh");
		
	}
	@Override
	public Integer getNumberFfMessage()
	{
		IMessageService messageService = new MessageService();
    	Integer messagesSize = messageService.getListOfMessages().size();
    	return messagesSize;
	}
	@Override 
	public void pushAdminMessage(String messageContenu)
	{
		MessageService messageService = new MessageService();
		UserService userService = new UserService();
		Message monMessage = new Message();
		monMessage.setAuthor(userService.getUserById("ADMIN"));
		monMessage.setStatus(Status.PUBLIC);
		monMessage.setCreationDate(new java.sql.Timestamp(new Date().getTime()));
		monMessage.setTitle("Admin Broadcast");
		monMessage.setContent(messageContenu);
		messageService.addMessage(monMessage);
	
	}

}
