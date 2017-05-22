package fr.epsi.myEpsi.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;
import utils.CannotDeleteAdminException;
import utils.CannotDeleteMessageException;
import utils.DuplicateUserException;

public class MessageServiceTest {

	@Before
	public void init() {
		IMessageService messageService = new MessageService();
		IUserService userService = new UserService();
		User user = new User("jmdoudou", "test", false);
		try {
			userService.addUser(user);
			Message message = new Message();
			message.setAuthor(user);
			message.setContent("test");
			message.setTitle("test");
			message.setStatus(Status.PRIVATE);
			messageService.addMessage(message);
			Message message2 = new Message();
			message2.setAuthor(user);
			message2.setContent("test");
			message2.setTitle("test");
			message2.setStatus(Status.ARCHIVED);
			
		} catch (DuplicateUserException e) {
			fail("cannot create user");
		}
	}
	
	@Test
	public void YouCannotDeleteMessageOfOtherUser() {
		User userd = new User("jmdoudoux", "test", false);
		IMessageService messageService = new MessageService();
		IUserService userService = new UserService();
		User author = userService.getUserById("jmdoudou");
		List<Message> message = messageService.getListOfMessages(author);
		try {
			messageService.deleteMessage(message.get(0), userd);
			fail("You can delete message of other user");	
		} catch (CannotDeleteMessageException e) {}
	
	}
	
	@Test
	public void YouCannotViewPrivateAndArchivedMessageOfOtherUser() {
		User userd = new User("jmdoudoux", "test", false);
		IMessageService messageService = new MessageService();
		List<Message> messages = messageService.getListOfMessages(userd);
		assertEquals(messages.size(), 0);
	}
	
	@After
	public void after() {
		IMessageService messageService = new MessageService();
		IUserService userService = new UserService();
		User user = userService.getUserById("jmdoudou");
		List<Message> list = messageService.getListOfMessages(user);
		for(Message mess : list){
			try {
				messageService.deleteMessage(mess, user);
			} catch (CannotDeleteMessageException e) {}
		}
		try {
			userService.deleteUser(user);
		} catch (CannotDeleteAdminException e) {
			e.printStackTrace();
		}
	}

}
