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
			AnchorPane loginLayout = loader.load();
			this.primaryStage.setScene(new Scene(loginLayout));
			this.primaryStage.setTitle("ManageElectFX");
			this.primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void mainScreen()
	{
		try {
			 
			FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrMainFXML.fxml").toURI().toURL());
			//FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrLoginFXML.fxml").toURI().toURL());
			VBox mainLayout = loader.load();
			primaryStage.setScene(new Scene(mainLayout));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	public static void electorInfoPopup()
	{
		Stage popupwindow = new Stage();
		
		try {
			FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrElectorInfo.fxml").toURI().toURL());
			
			AnchorPane popup = loader.load();
			popupwindow.setTitle("Contact Elector Form");
			popupwindow.setScene(new Scene(popup));
			BdrElectorInfoPopup bdrElectorInfoPopup = loader.getController();
			bdrElectorInfoPopup.setStage();
			popupwindow.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static void electorInfoPopup(int idInt) {
		Stage popupwindow = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\liork\\OneDrive\\Desktop\\Haifa Uni\\InfoSystemDev\\HW2\\ManageElectFX\\src\\boundary\\BdrElectorInfo.fxml").toURI().toURL());
			
			AnchorPane popup = loader.load();
			popupwindow.setTitle("Contact Elector Form");
			popupwindow.setScene(new Scene(popup));
			BdrElectorInfoPopup bdrElectorInfoPopup = loader.getController();
			bdrElectorInfoPopup.setStage(idInt);
			popupwindow.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
		}
	}
}
