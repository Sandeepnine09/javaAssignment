package learnJava;

public class WrapperClassEx {

	public static void main(String[] args) {

		String s = " 10";
		// String to Integer

		int no = Integer.parseInt(s.trim());
		System.out.println(++no);

		// binary string to primitive decimal int
		String s1 = "1010";
		int no1 = Integer.parseInt(s1, 2);
		System.out.println(no1);

		// Integer to String

		Integer ob = no;
		String s2 = ob.toString();
		System.out.println("int " + no + " to (decimal) String:" + s2);

		s2 = Integer.toBinaryString(no);
		System.out.println("primtive int " + no + " to Binary String:" + s2);

		// Integer to double primitive

		int n = 100;
		double d = n;

		// double primitive to int
		double cost = 45.50;
		// int n1 = (int) cost; //use wrapper class instead

		Double dd = cost;
		int n1 = dd.intValue();
		System.out.println(n1);

		// double primitive to long
		long l = dd.longValue();
		System.out.println(l);

		// int to byte
		Integer val = 123;

		byte b = val.byteValue();
		System.out.println("int " + val + " to byte:" + b);

		// int to short
		Integer i = 123;
		short sn = i.shortValue();
		System.out.println("int primitive " + 123 + " to short primitive" + sn);

	}

}
