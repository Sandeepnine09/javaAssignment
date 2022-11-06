package containmentAssignment;

import java.util.*;

public class ContainmentMain {

	public static void main(String[] args) {

		List<employeeAssign> empList = new ArrayList<employeeAssign>();

		employeeAssign e1 = new employeeAssign(101, "Anil Kumble", 22000, 1101);

		employeeAssign e2 = new employeeAssign(102, "Ankita Sharma", 21000, 1101);
		empList.add(e1);
		empList.add(e2);

		DepartmentAssign d1 = new DepartmentAssign(1102, "Developer", 2, "Palak Jha");

		DepartmentAssign d2 = new DepartmentAssign(1101, "QA Tester", 6, "Royal Naidu");

		e1.getDeptList().add(d1);
		e1.getDeptList().add(d2);
		
		empList.forEach(e -> { 
			if (e.getEmpId() == 101) { 
				System.out.println(e);
				System.out.println(e.getDeptList());

				List<DepartmentAssign> lemp = e.getDeptList();

				DepartmentAssign d = lemp.get(0);
				System.out.println(d);

			}

		});

	}

}