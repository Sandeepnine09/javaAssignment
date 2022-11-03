package assignment;

import java.util.*;

public class HashAccountMap {

	public static void main(String[] args) {
		Map<account, Double> map = new HashMap<>();

		account a1 = new account("Sidharth Malhotra", 2, 25000);

		map.put(a1, a1.getBalance());

		account a = new account("Anuj Jain", 1, 15000);

		map.put(a, a.getBalance());

		map.put(new account("Ishika Raj", 3, 35000), 35000.0);

		System.out.println("Contains key AccountHolder Shiv with accno=11:"
				+ map.containsKey(new account("Shiv Nagar", 11, 35000)));

		System.out.println("Contains key AccountHolder Ishika with accno=3:"
				+ map.containsKey(new account("Ishika Raj", 3, 35000)));
		System.out.println("Contains value, balance value of 15000 rs:" + map.containsValue(15000.0));

		System.out.println(map);

		meth(map);

	}

	public static void meth(Map<account, Double> mp) {

		System.out.println("Inside meth method:" + mp.get(new account("Sidharth Malhotra", 2, 25000)));

	}
}
