package boundary;

import java.io.IOException;
import java.util.function.UnaryOperator;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

import javafx.scene.layout.VBox;


public class BdrMainCtrl{
	public Button contactElectorBtn, updateContactBtn;
	public TextField electorId;
	public BdrMainCtrl()
	{
		
	}
	public void contactElectorHndlr() throws Exception
	{
		String idTxt = electorId.getText();
		if (idTxt.isEmpty())
		{
			Main.electorInfoPopup();
		}
		else
		{
			int idInt = Integer.parseInt(idTxt);
			Main.electorInfoPopup(idInt);
		}
	}
	public void ballotInfoHndlr()
	{
		//TODO
	}

	public void updateContactHndlr()
	{
		//TODO: open udate contact info form
	}
	public void bdrTransportMngHndlr()
	{
		//TODO: check user permission lvl. open TransportMng Screen
	}
	public void bdrCampaignMngHndlr()
	{
		//TODO
	}
	public void bdrBranchMngHndlr()
	{
		//TODO
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
		electorId.setTextFormatter(textFormatter);
	}

}
