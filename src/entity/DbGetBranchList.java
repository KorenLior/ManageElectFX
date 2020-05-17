package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbGetBranchList {

	public DbGetBranchList() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static ArrayList<Branch> getBranches() {
		 ArrayList<Branch> results = new ArrayList<Branch>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbBranch.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbBranch.SQL_SEL_BRANCHES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 results.add(new Branch(rs.getInt(i++), rs.getInt(i++),rs.getInt(i++)));
		 }
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
}
