package assignment;

import java.util.*;

public class ExceptionMain {

	public static void main(String[] args) {

		accountClass1 ob = new accountClass1("David Warner", 1229, 1200);

		Scanner sc = new Scanner(System.in);
		String s;

		do {
			System.out.println("Enter the amount to withdraw: ");
			double amt = sc.nextDouble();

			try {
				amt = ob.withdraw(amt);
			} catch (ZeroBalanceException e) {
				System.out.println(e);
				break;
			}
			System.out.println("Do you wish to continue:(y/n):");
			s = sc.next();

		} while (s.charAt(0) == 'y' || s.charAt(0) == 'Y');

		sc.close();
		System.out.println("program ends here...");
	}

}
