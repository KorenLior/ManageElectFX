package control;

import entity.DbGetElectorList;
import entity.Elector;

class CtrlElector {
	
	public int getElectorPhone(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		if (res==null)
		{
			return 0;
		}
		int result = res.getPhoneNumber();
		return result;
	}
	
	public String getElectorName(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		if (res==null)
		{
			return "";
		}
		String result = res.getLastName() + res.getFirstName();
		return result;
	}
	
	public String getElectorAddress(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		if (res==null)
		{
			return "";
		}
		String result = res.getAddress();
		return result;
	}
	
	public String getElectorInfo(int id) {
		Elector res = (new DbGetElectorList()).getElector(id);
		if (res==null)
		{
			return "";
		}
		String result = res.toString();
		return result;
	}
	
}
