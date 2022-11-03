package learnJava;

public class StringBuilderEx {

	public static void main(String[] args) {

		// immutable concept of String
		String s = "Scarllet";

		System.out.println(s + " Johanasson");

		s = s + " Johanasson";
		String s1 = s + " Johanasson";
		System.out.println(s);
		System.out.println(s1);

		String s2 = " Johanasson";

		// String imp conversions

		// char to String
		char ch = 'c';

		String chstr = Character.toString(ch);
		System.out.println("char ch=" + ch + " to String:" + chstr);

		// String to char

		String yesno = "c";

		ch = yesno.charAt(0);
		System.out.println("String " + yesno + " to char:" + ch);
		System.out.println(ch);

		// char to unicode value

		ch = 'A';
		Character x = ch; // auto-boxing char to Character

		int charval = Character.getNumericValue(ch);

		System.out.println("char ch=" + ch + " to Unicode value:" + charval);

		// important methods of string

		String str = "Let's learn something";

		String str1 = str.substring(6, 8);
		System.out.println(str1);

		str1 = str.substring(5);
		System.out.println(str1);

		System.out.println(str.toLowerCase());

		// String to char array
		char[] arr = str.toCharArray();
		System.out.println(arr);

	}

}
