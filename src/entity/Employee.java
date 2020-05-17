package entity;

import java.sql.Date;

public class Employee {
	private int id;
	private Date birthDate;
	private String gender;
	private String nationality;
	private boolean car;
	private int status, numChildren, branchNum;
	public Employee(int id, 
			Date birthDate, 
			String gender, 
			String nationality, 
			boolean car, 
			int status, 
			int numChildren,
			int branchNum) {
		this.id = id;
		this.birthDate = birthDate;
		this.branchNum = branchNum;
		this.birthDate = birthDate;
		this.car = car;
		this.id = id;
		this.status = status;
		this.numChildren = numChildren;
	}
	public int getId() {
		return id;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public String getGender() {
		return gender;
	}
	public String getNationality() {
		return nationality;
	}
	public boolean isCar() {
		return car;
	}
	public int getStatus() {
		return status;
	}
	public int getNumChildren() {
		return numChildren;
	}
	public int getBranchNum() {
		return branchNum;
	}
	@Override
	public String toString() {
		return "Employee [ID=" + id + ", birthDate=" + birthDate + ", gender=" + gender + ", nationality=" + nationality
				+ ", car=" + car + ", status=" + status + ", numChildren=" + numChildren + ", branchNum=" + branchNum
				+ "]";
	}

}
