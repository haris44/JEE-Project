package utils;

public class DuplicateUserException extends Exception {

	public DuplicateUserException(){
		System.out.println("Cannot create user");
	}
}
