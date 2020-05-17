package boundary;

import java.io.IOException;
import java.util.function.UnaryOperator;

import control.CtrlLogin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BdrLoginCtrl {
	public Button btnLogin;
	public TextField employeeId;
	
	public void btnLoginHandler()
	{
		CtrlLogin login = new CtrlLogin(employeeId.getAccessibleText().toString());
		try {
			AnchorPane main = FXMLLoader.load(getClass().getResource("BdrMainFXML.fxml"));
			Stage stage = (Stage)btnLogin.getScene().getWindow();
			stage.setScene(new Scene(main));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void employeeIdHandler()
	{
		UnaryOperator<Change> filter = change -> {
		    String text = change.getText();

		    if (text.matches("[0-9]*")) {
		        return change;
		    }

		    return null;
		};
		TextFormatter<String> textFormatter = new TextFormatter<>(filter);
		employeeId.setTextFormatter(textFormatter);
	}
	

}
