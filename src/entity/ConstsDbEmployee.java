package entity;

import java.net.URLDecoder;

public class ConstsDbEmployee {
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	public static final String SQL_SEL_EMPLOYEES = "SELECT * FROM TblEmployee";
	public ConstsDbEmployee() {
		// TODO Auto-generated constructor stub
	}
	private static String getDBPath() {
		 try {
		String path = ConstsDbEmployee.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/DbManageElect.accdb";
		} else {
		 decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/entity/DbManageElect.accdb";
		}
		} catch (Exception e) {
		 e.printStackTrace();
		 return null;
		}
	}

}
