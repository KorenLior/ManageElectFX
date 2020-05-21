package control;

import java.util.ArrayList;

import entity.Branch;
import entity.DbGetBranchList;
import entity.DbGetEmployeeList;
import entity.Employee;

class CtrlLogin {
	//TODO HASH permission for greater security
	private int permission = -5555;
	private ArrayList<Employee> emplyeeList;
	public int getPermission()
	{
		return permission;
	}
	public CtrlLogin(int id) throws Exception {
		
		emplyeeList = DbGetEmployeeList.getEmployees();
		new DbGetBranchList();
		ArrayList<Branch> branchList = DbGetBranchList.getBranches();
		CtrlSystemInfo ctrlSystemInfo = new CtrlSystemInfo();
		
		
		if (ctrlSystemInfo.getManagerId()==id)
		{
			permission = 3;
			return;
		}
		for (Branch branch:branchList)
		{
			
			if (branch.getManagerId() == id)
			{
				permission = 2;
				return;
			}
			if (branch.getTransportRepId() == id)
			{
				permission = 1;
				return;
			}
		}
		if (emplyeeList.isEmpty()) {
			throw new Exception("EmployeeList empty");
		}
		for(Employee employee:emplyeeList)
		{
			
			if (employee.getId() == id)
			{
				permission = 0;
			}
		}
	}
}
