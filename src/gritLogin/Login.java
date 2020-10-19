package gritLogin;

public class Login {
	
	private static String username;
	private static String password;

	public static void login(User user) {
		username = user.getUsername();
		password = user.getPassword();
		if(UsersReader.find(username, password)) {
			System.out.println("Login successful!");
		}
		else {
			System.out.println("Failed to login");
		}
		
	};
	
}
