package assignment;

import java.util.*;

public class TreeSetAccount {

	public static void main(String[] args) {

		/******* Comparable interface **********/

		SortedSet<account> st = new TreeSet<>();

		account acc = new account("Arjun", 2240, 12000);

		st.add(acc);

		account acc1 = new account("Suraj", 3943, 17640);

		st.add(acc1);

		st.add(new account("Sahil", 2512, 19103));
		st.add(new account("Joshua", 3522, 14104));
		st.add(new account("Arjun", 2240, 18862));

		System.out.println(st.size());

		System.out.println(st.contains(acc));
		
		

		/********* Comparator interface **********/

		System.out.println("Sorting based on employee's dept number...");
		method(new ComparatorEmp());
	}

	public static void method(Comparator<employee> c) {

		SortedSet<employee> st1 = new TreeSet<employee>(c);

		employee e11 = new employee(2, "Arjun", 2240.76, 102);

		st1.add(e11);

		employee e1 = new employee(1, "Suraj", 2900.89, 101);

		st1.add(e1);

		st1.add(new employee(4, "Sahil", 3512.78, 104));
		st1.add(new employee(3, "Joshua", 3522.34, 103));

		System.out.println(st1);
	}

}
