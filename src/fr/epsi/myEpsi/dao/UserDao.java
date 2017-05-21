package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hsqldb.jdbcDriver;

import fr.epsi.myEpsi.beans.User;

public class UserDao implements IUserDao{

	@Override
	public List<User> getListOfUsers() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		Connection con;
		
		ResultSet resultats = null;
		String requete = "SELECT * FROM USERS";
		ArrayList user = new ArrayList<User>();
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
			   Statement stmt = con.createStatement();
			   resultats = stmt.executeQuery(requete);
			    while (resultats.next()) {
			    	user.add(new User(resultats.getString(1), resultats.getString(2), resultats.getBoolean(3)));
			     }	   

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return user;

	}

	@Override
	public User getUserById(String id) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		Connection con;
		ResultSet resultats = null;

		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
			ps.setString(1, id);
			Statement stmt = con.createStatement();
			   resultats = ps.executeQuery();
			    while (resultats.next()) {
			    	return new User(resultats.getString(1), resultats.getString(2), resultats.getBoolean(3));
			     }	   

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection con;
		ResultSet resultats = null;
		
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?)");
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.getAdministrator());
			ps.execute();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User user) {
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection con;
		ResultSet resultats = null;
		
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("UPDATE users SET password = ?, isadministrator = ? WHERE id = ?");
			ps.setString(1, user.getPassword());
			ps.setBoolean(2, user.getAdministrator());
			ps.setString(3, user.getId());
			ps.execute();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(User user) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?");
			ps.setString(1, user.getId());
			ps.execute();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

}
