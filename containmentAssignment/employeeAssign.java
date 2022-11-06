package containmentAssignment;

import java.util.*;

public class employeeAssign{

	private int empId;
	private String empName;
	private double empSalary;
	private int empDeptNo;
	
	private List<DepartmentAssign> deptList;

	//PARAMETARIZED CONSTRUCTOR
	public employeeAssign(int empId, String empName, double empSalary, int empDeptNo) {
		//super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDeptNo = empDeptNo;
		
		this.deptList = new ArrayList<DepartmentAssign>();
	}
	
/************************************** CONSTRUCTOR OVERLOADING *****************************/
	
	//DEFAULT CONSTRUCTOR
	public employeeAssign()
	{
		/*this.empId = 4;
		this.empName = "Deepu";
		this.empSalary = 32600.200;
		this.empDeptNo = 014;*/
	}
	
	//COPY CONSTRUCTOR
	public employeeAssign(employeeAssign e)
	{
		this.empId = e.empId;
		this.empName = e.empName;
		this.empSalary = e.empSalary;
		this.empDeptNo = e.empDeptNo;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		if(empSalary > 0)
		{
			this.empSalary = empSalary;
		}
		else
		{
			System.out.println("Enter valid salary!!!");
		}
	}
	public int getEmpDeptNo() {
		return empDeptNo;
	}
	public void setEmpDeptNo(int empDeptNo) {
		this.empDeptNo = empDeptNo;
	}
	public int getEmpId() {
		return empId;
	}
	
	public List<DepartmentAssign> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DepartmentAssign> deptList) {
		this.deptList = deptList;
	}

/******************************** FUNCTION OVERLOADING *****************************/
	public double calcSal()
	{
		return this.empSalary *12;
	}
	
	public double calcSal(double bonus)
	{
		return (this.empSalary *12) + bonus;
	}
	
    //e1.equals(e2)
    
    @Override
    public boolean equals(Object obj)  //obj = e2
    {
        return this.empId == ((employeeAssign)obj).empId;
    }

}
