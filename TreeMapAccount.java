package assignment;

import java.util.*;

public class TreeMapAccount {

	public static void main(String[] args) {

		SortedMap<account, Double> smp = new TreeMap<>();

		account a1 = new account("Raj Malhotra", 25000, 10);

		smp.put(a1, a1.getBalance());

		account a = new account("Rahul Singh", 15000, 30);

		smp.put(a, a.getBalance());

		smp.put(new account("Sangeeta Shah", 35000, 20), 35000.0);


		System.out.println(smp);

		System.out.println("Sorting account keys....");
		func(new ComparatorAccount());
	}
	

	public static void func(Comparator<account> c) {
		TreeMap<account, Double> smp = new TreeMap<>(c);

		account a11 = new account("Raj Malhotra", 25000, 10);

		smp.put(a11, a11.getBalance());

		account aa = new account("Rahul Singh", 15000, 30);

		smp.put(aa, aa.getBalance());

		smp.put(new account("Sangeeta Shah", 35000, 20), 35000.0);
		smp.put(new account("Raj Malhotra", 25000, 10), 25000.0);

		System.out.println(smp);

	}
}
