package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import utils.CannotDeleteMessageException;

public interface IMessageService {

	List<Message> getListOfMessages(User user);
	List<Message> getListOfMessages();
	Message getMessage(Long id);
	void addMessage(Message message);
	void updateMessageStatus(Message message, int status);
	void deleteMessage(Message message, User connected) throws CannotDeleteMessageException;

}
