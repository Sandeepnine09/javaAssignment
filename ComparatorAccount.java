package assignment;

import java.util.*;

public class ComparatorAccount implements Comparator<account>{
	
	public int compare(account ac1, account ac2)
	{
		System.out.println("Comparing ac1's acctHolderName: " + ac1.getAccountHolderName() + " with ac2's acctHolderName: " + ac2.getAccountHolderName());
		return (int)(ac1.getAccountHolderName().length() - ac2.getAccountHolderName().length());
	}

}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

