package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class DbGetElectorList {

	public DbGetElectorList() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Elector> getElectors() {
		 ArrayList<Elector> results = new ArrayList<Elector>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbElector.SQL_SEL_ELECTOR);

		 ResultSet rs = stmt.executeQuery()) {
			 while (rs.next()) {
				 Elector res = readFromDb(rs);
				 results.add(res);
		 }
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	public ArrayList<Elector> getElectors(int ballotNum) {
		ArrayList<Elector> results = new ArrayList<Elector>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbElector.SQL_SEL_ELECTOR_BALLOT
				 + String.valueOf(ballotNum));

		 ResultSet rs = stmt.executeQuery()) {
			 while (rs.next()) {
				 Elector res = readFromDb(rs);
				 results.add(res);
		 }
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	
	public Elector getElector(int electorId) {
		Elector result = null;
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbElector.SQL_SEL_ELECTOR_ID
				 + String.valueOf(electorId));

		 ResultSet rs = stmt.executeQuery()) {
			 rs.next();
			 result = readFromDb(rs);
			 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return result;
	}
	
	
	private Elector readFromDb(ResultSet rs) throws SQLException {
		
			 int i = 1;

			 int id = rs.getInt(i++);
			 String firstName = rs.getString(i++);
			 String lastName = rs.getString(i++);
			 String address = rs.getString(i++);
			 int phoneNum = rs.getInt(i++);
			 int ballotNum = rs.getInt(i++);
			 int serialNum = rs.getInt(i++);
			 int rideId = rs.getInt(i++);
			 Time rideTime = rs.getTime(i++);
		
		return new Elector(id, ballotNum, serialNum, rideId, rideTime,
				firstName, lastName, address, phoneNum);
	}
}
