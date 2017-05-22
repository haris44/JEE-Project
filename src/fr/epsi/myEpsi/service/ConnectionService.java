package fr.epsi.myEpsi.service;

import fr.epsi.myEpsi.beans.User;

public class ConnectionService implements IConnectionService {

	IUserService userService; 
	
	public ConnectionService(){
		userService = new UserService();
	}
	
	@Override
	public boolean isAuthorized(User user) {
		User baseUser = userService.getUserById(user.getId());
		if(baseUser != null && baseUser.getPassword().equals(user.getPassword())){
			return true;
		}
		return false;
	}

}
