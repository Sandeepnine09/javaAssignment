package assignment;

public class account implements Comparable<account>{

	private String accountHolderName;
	private int acctNo;
	private double balance;

	public account(String accountHolderName, int acctNo, double balance) {
		super();
		this.accountHolderName = accountHolderName;
		this.acctNo = acctNo;
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAcctNo() {
		return acctNo;
	}

	public void deposit(double amt) {
		this.balance = this.balance + amt;
	}

	@Override
	    public String toString() {
	        return "[accountHolderName=" + accountHolderName + ", acctNo=" + acctNo + ", balance=" + balance + "]";
	}
	
	@Override
	public int compareTo(account a)
	{
		return this.acctNo - a.acctNo;
	}

}
