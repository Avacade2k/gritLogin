package gritLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersReader {
	
	private static List<User> users;

    public static synchronized void readUsers(){
        if(null == users){
            users = new ArrayList<User>();
            String File = ("users.csv");
            Scanner scan = new Scanner (UsersReader.class.getResourceAsStream(File));
            String line;
            while((line = scan.nextLine()) != null){
                String[] tokens = line.split(",");
                users.add(new User(tokens[1], tokens[2]));
            }
            scan.close();
        }
        System.out.println(users);
    }
    
    public static synchronized boolean find(String username, String password){
        if(null == users){
            throw new IllegalStateException("user list is not initialised");
        }

        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .filter(u -> u.getPassword().equals(password))
                .findFirst()
                .isPresent();
    }

}
