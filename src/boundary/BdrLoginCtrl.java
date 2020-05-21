package boundary;

import java.util.function.UnaryOperator;

import application.Main;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;


public class BdrLoginCtrl{
	public Button btnLogin;
	public TextField employeeId;
	public BdrLoginCtrl() {
	}
	public void btnLoginHandler()
	{
		
		String idTxt = employeeId.getText();
		if (idTxt==null)
		{
			return;
		}
		int idInt = Integer.parseInt(idTxt);
		Main.ctrlInterface.login(idInt);
		if (Main.ctrlInterface.getPermmission()>=0)
		{
			Main.mainScreen();
		}
		else
		{
			System.out.println("unrecognized employee ID");
		}
	}
	
	public void idTxtHandler()
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
