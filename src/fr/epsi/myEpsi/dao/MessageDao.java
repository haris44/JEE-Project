package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;
import utils.DbUtils;

public class MessageDao implements IMessageDao {

	DbUtils db;
	UserService userService;
	
	public MessageDao(){
		db = new DbUtils();
		userService = new UserService();
	}
	@Override
	public List<Message> getListOfMessages(User user) {
		Connection cn = db.getConnection();
		ResultSet resultats = null;

		ArrayList messages = new ArrayList<Message>();
		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM MESSAGES WHERE USER_ID = ? OR STATUS = ? AND STATUS != ?");
			ps.setString(1, user.getId());
			ps.setInt(2, Status.PUBLIC.ordinal());
			ps.setInt(3, Status.ARCHIVED.ordinal());
			resultats = ps.executeQuery();
			    while (resultats.next()) {
			    	Message message = new Message();
			    	message.setId(resultats.getLong(1));
			    	message.setTitle(resultats.getString(2));
			    	message.setContent(resultats.getString(3));
			    	message.setAuthor(userService.getUserById(resultats.getString(4)));
			    	message.setCreationDate(resultats.getTimestamp(5));
			    	message.setUpdateDate(resultats.getTimestamp(6));
			    	message.setStatus(Status.fromOrdinal(resultats.getInt(7)));
			    	messages.add(message);
			     }	   

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		Connection cn = db.getConnection();
		ResultSet resultats = null;
		
		try {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM MESSAGES WHERE ID = ?");
			ps.setLong(1, id);
			resultats = ps.executeQuery();
			    while (resultats.next()) {
			    	Message message = new Message();
			    	message.setId(resultats.getLong(1));
			    	message.setTitle(resultats.getString(2));
			    	message.setContent(resultats.getString(3));
			    	message.setAuthor(userService.getUserById(resultats.getString(4)));
			    	message.setCreationDate(resultats.getTimestamp(5));
			    	message.setUpdateDate(resultats.getTimestamp(6));
			    	message.setStatus(Status.fromOrdinal(resultats.getInt(7)));
			    	return message;
			     }	   

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public void addMessage(Message message) {

		long nextId = 0;
		ResultSet resultats = null;
		Connection cn = db.getConnection();	
		try {
			String sqlIdentifier = "select MAX(ID) from MESSAGES";
			PreparedStatement pst = cn.prepareStatement(sqlIdentifier);
			resultats = pst.executeQuery();
			while (resultats.next()) {
				nextId = resultats.getLong(1) + 1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO MESSAGES(ID, TITLE, CONTENT, USER_ID, CREATION_DATE, UPDATE_DATE, STATUS) VALUES (?,?,?,?,?,?,?)");
			ps.setLong(1, nextId);
			ps.setString(2, message.getTitle());
			ps.setString(3, message.getContent());
			ps.setString(4, message.getAuthor().getId());
			ps.setTimestamp(5, message.getCreationDate());
			ps.setTimestamp(6, message.getUpdateDate());
			ps.setInt(7, message.getStatus().ordinal());
			ps.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		Connection cn = db.getConnection();		
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE messages SET status = ? WHERE id = ?");
			ps.setInt(1, status);
			ps.setLong(2, message.getId());
			ps.execute();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMessage(Message message) {
		Connection cn = db.getConnection();		
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM messages WHERE id = ?");
			ps.setLong(1, message.getId());
			ps.execute();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		
	}

}
