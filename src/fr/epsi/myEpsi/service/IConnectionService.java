package fr.epsi.myEpsi.service;

import fr.epsi.myEpsi.beans.User;

public interface IConnectionService {

	boolean isAuthorized(User user);
}
