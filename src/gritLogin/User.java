package gritLogin;

public class User {
	
	private static String username;
	private static String password;
	
	public User(String uname, String pass) {
		username = uname;
		password = pass;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}

}
