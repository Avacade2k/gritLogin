package gritLogin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main  extends  Application {

	@Override
	public void start(Stage stage)  {
		
	    String version = System.getProperty("java.version");
		
	    Label ver =new Label (version);
	    
	    StackPane pane = new StackPane();
	    
	    TextField unameField = new TextField ();
	    unameField.setPromptText("Username");
	    TextField passField = new TextField ();
	    passField.setPromptText("Password");
	    
	    Button submit = new Button("Submit");
	    submit.setOnAction((event) -> {
	    	submit(unameField.toString(), passField.toString());
	    });
	    
	    pane.getChildren().add(unameField);
	    pane.getChildren().add(passField);
	    pane.getChildren().add(submit);
	    
	    Scene scene = new Scene (pane,400,400);
	    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    
	    stage.setScene(scene); 
	    stage.show();
		
	}
	
	public void submit(String uname, String pass) {
		User user = new User(uname, pass);
		Login.login(user);
	}

	public static void main(String[] args) {
		launch();
       }
	

}