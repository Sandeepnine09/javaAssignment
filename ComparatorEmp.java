package assignment;

import java.util.*;

public class ComparatorEmp implements Comparator<employee>{

	public int compare(employee e1, employee e2)
	{
		System.out.println("Comparing e1's deptno: " + e1.getEmpDeptNo() + " with e2's deptno: " + e2.getEmpDeptNo());
		return (int)(e1.getEmpDeptNo() - e2.getEmpDeptNo());
	}
}
