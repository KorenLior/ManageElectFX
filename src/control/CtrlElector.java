package control;

import entity.ConstsDbElector;
import entity.DbGetElectorList;
import entity.Elector;

class CtrlElector {
	
	public static int getElectorPhone(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		int result = res.getPhoneNumber();
		return result;
	}
	
	public static String getElectorName(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		String result = res.getLastName() + res.getFirstName();
		return result;
	}
	
	public static String getElectorAddress(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		String result = res.getAddress();
		return result;
	}
	
	public static String getElectorInfo(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		String result = res.toString();
		return result;
	}
	
}
