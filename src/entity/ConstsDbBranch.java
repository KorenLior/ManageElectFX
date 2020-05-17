package entity;

import java.net.URLDecoder;

public class ConstsDbBranch {

	public ConstsDbBranch() {
		// TODO Auto-generated constructor stub
	}
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	public static final String SQL_SEL_BRANCHES = "SELECT * FROM TblBranch";
	private static String getDBPath() {
		 try {
		String path = ConstsDbEmployee.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/file-name.accdb";
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
