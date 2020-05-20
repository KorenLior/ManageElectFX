package application;
	
import java.io.File;
import java.io.IOException;


import boundary.BdrElectorInfoPopup;
import boundary.BdrLoginCtrl;
import boundary.BdrMainCtrl;
import control.CtrlInterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	public static CtrlInterface ctrlInterface = new CtrlInterface(); 
	private static Stage primaryStage;
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrLoginFXML.fxml").toURI().toURL());
			loader.setController(new BdrLoginCtrl());
			AnchorPane loginLayout = loader.load();
			this.primaryStage.setScene(new Scene(loginLayout));
			this.primaryStage.setTitle("ManageElectFX");
			this.primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
//===============================================WIP===========================================================
//TODO:
//
//
//
//===========================================My Stuff==============================================================
		
	public static void mainScreen()
	{
		try {
			 
			FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrMainFXML.fxml").toURI().toURL());
			//FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrLoginFXML.fxml").toURI().toURL());
			loader.setController(new BdrMainCtrl());
			VBox mainLayout = loader.load();
			primaryStage.setScene(new Scene(mainLayout));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void electorInfoPopup()
	{
		try {
			FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrElectorInfoFXML.fxml").toURI().toURL());
			
			Stage electorInfoStage = new Stage();
			AnchorPane electorInfoLayout = loader.load();

			electorInfoStage.setScene(new Scene(electorInfoLayout));
			electorInfoStage.show();
	    } catch (IOException e) {
	        System.out.println("Failed to open Elector Info Popup");
	    }
	}
	public static void electorInfoPopup(int idInt)
	{
		try {
			FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrElectorInfoFXML.fxml").toURI().toURL());
			Stage electorInfoStage = new Stage();
			AnchorPane electorInfoLayout = loader.load();

			electorInfoStage.setScene(new Scene(electorInfoLayout));
			
			electorInfoStage.show();
	    } catch (IOException e) {
	        System.out.println("Failed to open Elector Info Popup2");
	    }
	}
}
