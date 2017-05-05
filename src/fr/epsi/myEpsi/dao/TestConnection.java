package fr.epsi.myEpsi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.User;

public class TestConnection {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		
	//	 List<User> users = dao.getListOfUsers();
	//	System.out.println(users.get(0).getId());
	
		// User users = dao.getUserById("ADMIN");
		// System.out.println(users.getPassword());
		
		  User users = new User();
		  users.setId("BANQUE");
		  users.setPassword("Plouf");
		  users.setAdministrator(false);
		  dao.addUser(users);

		// User users2 = dao.getUserById("BANQUE");
		// System.out.println(users2.getPassword());
		 

		// User users = dao.getUserById("BANQUE");
		// System.out.println(users.getAdministrator());
		// dao.deleteUser(users);
		// User users2 = dao.getUserById("BANQUE");
	}
	
}