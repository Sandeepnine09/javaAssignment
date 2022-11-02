package assignment;

public class accountClass1 {

	private String accountHolderName;
	private int acctNo;
	private double balance;

	public accountClass1(String accountHolderName, int acctNo, double balance) {
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

	public double withdraw(double amount) throws ZeroBalanceException {
		if(this.balance<=0.0){
        	throw new ZeroBalanceException(this.balance,this.acctNo);
        }
		else if (amount <= this.balance) {
			this.balance = this.balance - amount;
			System.out.println("Current Balance is " + this.balance + " after withdrawing amt: " + amount);
		}

		return amount;
	}

	@Override
	    public String toString() {
	        return "Account:- [accountHolderName=" + accountHolderName + ", acctNo=" + acctNo + ", balance=" + balance + "]";
	}

}
