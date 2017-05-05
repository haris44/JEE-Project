package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.User;

public interface IUserDao {

	List<User> getListOfUsers();
	User getUserById(String id);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	
}
