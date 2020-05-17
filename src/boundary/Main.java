package boundary;
	

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	
	
	
	public void start(Stage primaryStage) {
		try {

			AnchorPane loginLayout = FXMLLoader.load(getClass().getResource("BdrLoginFXML.fxml"));
			primaryStage.setScene(new Scene(loginLayout));
			primaryStage.setTitle("ManageElectFX");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
