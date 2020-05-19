package control;

import java.util.ArrayList;

import entity.Branch;
import entity.DbGetBranchList;
import entity.DbGetEmployeeList;
import entity.Employee;

class CtrlLogin {
	private int permission = -5555;
	public int getPermission()
	{
		return permission;
	}
	public CtrlLogin(int id) {
		
		ArrayList<Employee> emplyeeList = (new DbGetEmployeeList()).getEmployees();
		new DbGetBranchList();
		ArrayList<Branch> branchList = DbGetBranchList.getBranches();
		CtrlSystemInfo ctrlSystemInfo = new CtrlSystemInfo();
		
		
		if (ctrlSystemInfo.getManagerId()==id)
		{
			permission = 3;
			return;
		}
		for(Employee employee:emplyeeList)
		{
			
			if (employee.getId() == id)
			{
				permission = 0;
				for (Branch branch:branchList)
				{
					if (branch.getBranchNum() == employee.getBranchNum())
					{
						if (branch.getManagerId() == id)
						{
							permission = 2;
						}
						if (branch.getTransportRepId() == id)
						{
							permission = 1;
						}
					}
				}
			}
		}
	}
}
