package boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import entity.ConstsDbBranch;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class BdrTransportRepMenu{

	public JFrame PrintReport()
	{ 
		try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR)) {
		JasperPrint print = JasperFillManager.fillReport(

		getClass().getResourceAsStream("src\\boundary\\TransportationRep.jasper"),
		 new HashMap<String, Object>(), conn);
		JFrame frame = new JFrame("Customer Orders Report");
		frame.getContentPane().add(new JRViewer(print));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		return frame;
		} catch (JRException e) 
		{
			System.out.println("Failure to create Transport Report Frame JRException");
		}catch(SQLException e)
		{
			System.out.println("Failure to create Transport Report Frame SQLxception");
		}
		}catch(ClassNotFoundException ea){
			System.out.println("Failure to create Transport Report Frame");
		}
		return null;
		}
}
