package gritLogin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main  extends  Application {
	
	public static Label status = new Label ("Enter account data");

	@Override
	public void start(Stage stage)  {
	    
	    Pane pane = new Pane();
	    
	    TextField unameField = new TextField ();
	    unameField.setPromptText("Username");
	    TextField passField = new TextField ();
	    passField.setPromptText("Password");
	    
	    unameField.setLayoutX(100);
	    unameField.setLayoutY(150);
	    passField.setLayoutX(100);
	    passField.setLayoutY(180);
	    
	    Button submit = new Button("Submit");
	    submit.setOnAction((event) -> {
	    	submit(unameField.getText(), passField.getText());
	    });
	    
	    submit.setLayoutX(260);
	    submit.setLayoutY(160);
	    
	    status.setLayoutX(100);
	    status.setLayoutY(120);
	    
	    pane.getChildren().add(unameField);
	    pane.getChildren().add(passField);
	    pane.getChildren().add(submit);
	    pane.getChildren().add(status);
	    
	    Scene scene = new Scene (pane,400,400);
	    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    
	    stage.setScene(scene); 
	    stage.show();
		
	}
	
	public void submit(String email, String pass) {
		User user = new User(email, pass);
		Login.login(user);
	}
	
	public static void loginStatus(boolean login) {
		if(login) {
			status.setText("Login successful!");
		}else {
			status.setText("Email or password does not match requirements");
		}
	}

	public static void main(String[] args) {
		launch();
       }
	

}