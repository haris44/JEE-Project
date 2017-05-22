package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDao;
import utils.CannotDeleteAdminException;
import utils.DuplicateUserException;

public class UserService implements IUserService{

	IUserDao dao = new UserDao();
	
	@Override
	public List<User> getListOfUsers() {
		return dao.getListOfUsers();
	}

	@Override
	public User getUserById(String id) {
		return dao.getUserById(id);
	}

	@Override
	public void addUser(User user) throws DuplicateUserException {
		if(getUserById(user.getId()) == null){
			dao.addUser(user);	
		} else {
			throw new DuplicateUserException();
		}
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) throws CannotDeleteAdminException {
		if(!user.getAdministrator()){
			dao.deleteUser(user);
		} else {
			throw new CannotDeleteAdminException();
		}
		
	}

}
