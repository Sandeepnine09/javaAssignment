package collectionFrameworks;

import classObjects.employee;

public class ObjectEquality {

	public static void main(String[] args) {

		employee e1 = new employee(1, "Arjun", 20000, 011);

		employee e = e1;

		// Employee e = new Employee(2,"Amit", 18456.500, 013);

		System.out.println(e == e1); // true , == checks whether object is actually same (same memory)

		e.setEmpSalary(25060);

		System.out.println("e1's salary: " + e1.getEmpSalary());

		employee e2 = new employee(1, "Arjun", 20000, 011);

		System.out.println("==:" + (e1 == e2)); // == gives false //application pov e1 and e2 are meaningfully same

		System.out.println("equals: " + e1.equals(e2)); // used to check if two reference are meaning fully same (in our
														// application)

		// Object class equals method works similar to == operator
		int no = 5, no1 = 5;

		System.out.println(no == no1);

	}
}
