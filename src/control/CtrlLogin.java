package control;

import java.util.ArrayList;

import boundary.BdrEmployeeMenu;
import boundary.BdrManagerMenu;
import boundary.BdrTransportRepMenu;
import entity.Branch;
import entity.DbGetBranchList;
import entity.DbGetEmployeeList;
import entity.Employee;

public class CtrlLogin {

	public CtrlLogin(String id) {
		new DbGetEmployeeList();
		ArrayList<Employee> emplyeeList = DbGetEmployeeList.getEmployees();
		new DbGetBranchList();
		ArrayList<Branch> branchList = DbGetBranchList.getBranches();
		for(Employee employee:emplyeeList)
		{
			Integer idInt = Integer.parseInt(id);
			if (employee.getId() == idInt)
			{
				for (Branch branch:branchList)
				{
					
					if (branch.getBranchNum() == employee.getBranchNum())
					{
						if (branch.getManagerId() == idInt)
						{
							new BdrManagerMenu();
							break;
						}
						if (branch.getTransportRepId() == idInt)
						{
							new BdrTransportRepMenu();
							break;
						}
						new BdrEmployeeMenu();
					}
				}
			}
		}
	}
}
