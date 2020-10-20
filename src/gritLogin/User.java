package gritLogin;

public class User {
	
	private static String username;
	private static String password;
	
	public User(String email, String pass) {
		username = email;
		password = pass;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}

}
