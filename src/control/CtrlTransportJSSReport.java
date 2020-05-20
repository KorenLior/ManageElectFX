package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class CtrlTransportJSSReport {
	
	public JFrame getTransportReportData() {
	JFrame frame = new JFrame("Customer Orders Report");
	try {
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	try (Connection conn = DriverManager.getConnection(entity.ConstsDbElector.CONN_STR)){
	JasperPrint print = JasperFillManager.fillReport(
	getClass().getResourceAsStream("/boundary/RptTransportation.jasper"),
	 new HashMap<String, Object>(), conn);
	frame.getContentPane().add(new JRViewer(print));
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.pack();
	return frame;
	}catch (SQLException e) {
		 System.out.println("getTransportReport readFromDb Failure");
	 e.printStackTrace();
		}
	}catch (Exception e){
		System.out.println("getTransportReport readFromDb Failure2");
		 e.printStackTrace();
	}
	return frame;
	}
}
	
