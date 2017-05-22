package utils;

public class CannotDeleteMessageException extends Exception {

	public CannotDeleteMessageException(){
		System.out.println("You are not authorized to delete this message");
	}
}
