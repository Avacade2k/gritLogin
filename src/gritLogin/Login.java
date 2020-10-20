package gritLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
	
	private static String username;
	private static String password;

	public static void login(User user) {
		username = user.getUsername();
		password = user.getPassword();
		
		if(validateUsername()) {
			if(validatePassword()) {
				System.out.println("Login successful!");
				Main.loginStatus(true);
			}
			else {
				System.out.println("Password does not match requirements");
				Main.loginStatus(false);
			}
		}
		else {
			System.out.println("Username does not match requirements");
			Main.loginStatus(false);
		}
	};
	
	static boolean validateUsername() {
		String regex = ".*(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\]).*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(username); 
		return m.matches();
	}
	
	static boolean validatePassword() {
		String regex = "^(?=(.*[0-9]){2,})"
                + "(?=(.*[a-z]){2,})(?=(.*[A-Z]){2,})"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{7,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password); 
		return m.matches();
	}
	
}
