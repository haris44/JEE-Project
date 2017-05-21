package fr.epsi.myEpsi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;
import utils.DbUtils;

public class TestConnection {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		
	//	 List<User> users = dao.getListOfUsers();
	//	System.out.println(users.get(0).getId());
	
		// User users = dao.getUserById("ADMIN");
		// System.out.println(users.getPassword());
		
		 // User users = new User();
		 // users.setId("BANQUE");
		 // users.setPassword("Plouf");
		 // users.setAdministrator(false);
		 // dao.addUser(users);

		// User users2 = dao.getUserById("BANQUE");
		// System.out.println(users2.getPassword());
		 

		// User users = dao.getUserById("BANQUE");
		// System.out.println(users.getAdministrator());
		// dao.deleteUser(users);
		// User users2 = dao.getUserById("BANQUE");	

		DbUtils db = new DbUtils();
		Connection cn = db.getConnection();
		ResultSet resultats = null;
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement("DELETE FROM MESSAGES WHERE ID >= 0");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		// User user = new User("ADMIN", "Bill", true);
		//ArrayList messages = new ArrayList<Message>();
		//try {
		//	PreparedStatement ps = cn.prepareStatement("SELECT * FROM MESSAGES");
			// ps.setString(1, user.getId());
			// ps.setInt(2, Status.PUBLIC.ordinal());
			// ps.setInt(3, Status.ARCHIVED.ordinal());
		//	resultats = ps.executeQuery();
			//	    while (resultats.next()) {
		//	    	Message message = new Message();
			    	//	    	message.setId(resultats.getLong(1));
		   	//	    	message.setTitle(resultats.getString(2));
		//	    	message.setContent(resultats.getString(3));
			    	//	    	message.setAuthor(user);
			    	//	    	message.setCreationDate(resultats.getTimestamp(5));
		//		    	message.setUpdateDate(resultats.getTimestamp(6));
		//	    	message.setStatus(Status.valueOf(resultats.getString(7)));
		//	    	messages.add(message);
			     }	   

	//} catch (SQLException e1) {
	//	e1.printStackTrace();
	//}
		
	//	System.out.println(messages);
	// }
	 
	
}