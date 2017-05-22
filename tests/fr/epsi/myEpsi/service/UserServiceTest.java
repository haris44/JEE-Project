package fr.epsi.myEpsi.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import fr.epsi.myEpsi.beans.User;
import utils.CannotDeleteAdminException;
import utils.DuplicateUserException;

public class UserServiceTest {

	@Test
	public void CannotCreateTwoAccountWithSameMail() {
		IUserService userService = new UserService();
		User userTest = new User("nathan@gmail.com", "jee", false);			
		try{
			userService.addUser(userTest);
			userService.addUser(userTest);
			fail("You can add two user with same id");
		} catch (DuplicateUserException e){ }
		
	}
	
	@Test
	public void CannotDeleteAdmin() {
		IUserService userService = new UserService();
		User admin = userService.getUserById("ADMIN");
		try{
			userService.deleteUser(admin);
			fail("You can delete admin user");
		} catch (CannotDeleteAdminException e){ }
		
	}

}
