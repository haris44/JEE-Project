package utils;

public class CannotDeleteAdminException extends Exception{

	public CannotDeleteAdminException(){
		System.out.println("Cannot delete admin user");
	}
}
