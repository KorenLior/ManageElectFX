package boundary;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.UnaryOperator;

import application.Main;
import entity.Elector;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;

public class BdrElectorInfoPopup {

	public Button btnLoad;
	public Button btnTest;
	public Button btnCancel;
	public Button btnSaveContactForm;
	public TextField tfId;
	public Label electorLabel;
	public TextField txtDate;
	public ChoiceBox<String> planToVote;
	public ChoiceBox<String> supportParty;
	public ChoiceBox<String> intrestedInClass;
	public CheckBox cbRideRequired;
	public CheckBox cbContactAnswered;
	public TextField txtPickupFrom;
	public TextField txtPickupUntil;
	
	
	private int loadedId = 0;
	
	
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	
	
	
	
	
	
	
	public BdrElectorInfoPopup() {
	}
	
	public void setStage(int id)
	{
		String electorTxt = Main.ctrlInterface.getElector(id);
		if (electorTxt.isEmpty())
		{
			return;
		}
		electorLabel.setText(electorTxt);
	}
	public void btnLoadAct()
	{
		String idTxt = tfId.getText();
		int idInt = Integer.parseInt(idTxt);
		//System.out.println("bug1111: idInt = " + idInt);
		String electorTxt = Main.ctrlInterface.getElector(idTxt);
		electorLabel.setText(electorTxt);
		if (electorTxt!=null)
		{
			loadedId = idInt;
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
		tfId.setTextFormatter(textFormatter);
	}
	
	public void btnCancelAct(ActionEvent ae)
	{
		System.out.println("canceling New Contact Form");
		try
		{
			final Node source = (Node) ae.getSource();
		    final Stage stage = (Stage) source.getScene().getWindow();
		    stage.close();
		}
		catch (Exception e) {
			System.out.println("canceling New Contact Form Failure");
		}
	}
	
	public void btnSaveAct(ActionEvent ae)
	{
		String date = txtDate.getText();
		if(loadedId<=0)
		{
			System.out.print("InputBug ContactElector employee not logged in");
			return;
		}
		try {
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
		catch (Exception e) {
			System.out.print("ctrlInterface.contactElectorFailure");
		}
		
		final Node source = (Node) ae.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
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
				txtPickupFrom.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(timeFormat), timeFormat.parse("00:00")));
				txtPickupUntil.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(timeFormat), timeFormat.parse("00:00")));
				txtDate.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(dateFormat), dateFormat.parse("01/01/01")));
			} catch (ParseException e) {
				System.out.println("TextFormatter Failure");
				e.printStackTrace();
			}
			planToVote.getItems().addAll("Yes","No","Undecided");
			supportParty.getItems().addAll("Yes","No","Undecided");
			intrestedInClass.getItems().addAll("Yes","No");
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
