package boundary;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.UnaryOperator;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;

public class BdrElectorInfoPopup {

	public Button btnLoad;
	public Button btnCancel;
	public Button btnSaveContactForm;
	public TextField id;
	public Label electorLabel;
	public DatePicker datePicker;
	public ChoiceBox<String> planToVote;
	public ChoiceBox<String> supportParty;
	public ChoiceBox<String> intrestedInClass;
	public CheckBox cbRideRequired;
	public CheckBox cbContactAnswered;
	public TextField txtPickupFrom;
	public TextField txtPickupUntil;
	
	
	private int loadedId = 0;
	private SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	
	public BdrElectorInfoPopup() {
	}
	
	public void setStage(int id)
	{
		String electorTxt = Main.ctrlInterface.getElector(id);
		if (!electorTxt.isEmpty())
		{
			electorLabel.setText(electorTxt);
		}
		planToVote.getItems().addAll("Yes","No","Undecided");
		supportParty.getItems().addAll("Yes","No","Undecided");
		intrestedInClass.getItems().addAll("Yes","No");	
	}
	public void setStage()
	{
		planToVote.getItems().addAll("Yes","No","Undecided");
		supportParty.getItems().addAll("Yes","No","Undecided");
		intrestedInClass.getItems().addAll("Yes","No");
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
		id.setTextFormatter(textFormatter);
	}
	
	public void btnCancelAct(InputEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public void btnSaveAct()
	{

		Date  date =  Date.valueOf(datePicker.getValue().toString());
		if(loadedId==0)
		{
			return;
		}
		if (!(cbContactAnswered.isArmed()))
		{
			Main.ctrlInterface.contactElector(loadedId, date,"No","","","","","","");
		}
		else
		{
			if (!cbRideRequired.isArmed())
			{
				Main.ctrlInterface.contactElector(loadedId, date,"Yes", planToVote.getValue(),
						supportParty.getValue(), intrestedInClass.getValue(),
						"No", "" , "");
			}
			else
			{
				Main.ctrlInterface.contactElector(loadedId, date,"Yes", planToVote.getValue(),
						supportParty.getValue(), intrestedInClass.getValue(),
						"Yes", txtPickupFrom.getText() , txtPickupUntil.getText());
			}
		}
		
	}
	
	public void btnLoadAct()
	{
		int idInt = 0;
		idInt = Integer.parseInt(id.getAccessibleText().toString());
		loadedId = idInt;
		electorLabel.setText(Main.ctrlInterface.getElector(idInt));
	}
	
	public void cbEnableFormAct()
	{
		if (cbContactAnswered.isArmed())
		{
			planToVote.setDisable(false);
			supportParty.setDisable(false);
			intrestedInClass.setDisable(false);
			cbRideRequired.setDisable(false);
			txtPickupFrom.setDisable(false);
			txtPickupUntil.setDisable(false);
			try {
				txtPickupFrom.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			planToVote.setDisable(true);
			supportParty.setDisable(true);
			intrestedInClass.setDisable(true);
			cbRideRequired.setDisable(true);
			txtPickupFrom.setDisable(true);
			txtPickupUntil.setDisable(true);
		}
	}
}
