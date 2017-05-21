package fr.epsi.myEpsi.service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IMessageDao;
import fr.epsi.myEpsi.dao.MessageDao;

public class MessageService implements IMessageService {

	IMessageDao messageDao;
	
	
	public MessageService(){
		messageDao = new MessageDao();
	}
	@Override
	public List<Message> getListOfMessages(User user) {
		return messageDao.getListOfMessages(user);
	}

	@Override
	public Message getMessage(Long id) {
		return messageDao.getMessage(id);
	}

	@Override
	public void addMessage(Message message) {
		messageDao.addMessage(message);
		
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		message.setUpdateDate(new Timestamp(new Date().getTime()));
		messageDao.updateMessageStatus(message, status);
		
	}


	
	@Override
	public void deleteMessage(Message message) {
		messageDao.deleteMessage(message);
	}

}
