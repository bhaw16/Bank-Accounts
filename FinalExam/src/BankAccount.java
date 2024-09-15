public abstract class BankAccount {
	//instance field definitions
	protected int acctNumber;
	protected double balance;
	
	/* Constructor BankAccount()
	 * Input:
	 * acctNumber - int representing the 6-digit account number
	 * balance - double representing the account balance in dollars and cents
	 * Process:
	 * Assigns the value of acctNumber to the BankAccount's account number
	 * and the value of balance to its balance to create a new BankAcount instance
	 * Output:
	 * Assigns the value of acctNumber to the BankAccount's account number
	 * and the value of balance to its balance to create a new BankAcount instance
	 */
	public BankAccount(int acctNumber, double balance) {
		this.acctNumber = acctNumber;
		this.balance = balance;
	}
	
	/* Copy Constructor BankAccount()
	 * Input:
	 * acct - account used to create a new BankAccount instance
	 * Process:
	 * Assigns the acct's account number to the BankAccount's account number
	 * and the acct's balance to the BankAccount's balance
	 * to create a new BankAcount instance with the same content
	 * Output:
	 * Assigns the acct's account number to the BankAccount's account number
	 * and the acct's balance to the BankAccount's balance
	 * to create a new BankAcount instance with the same content
	 */
	public BankAccount(SavingsAccount acct) {
		this.acctNumber = acct.getAcctNumber();
		this.balance = acct.getBalance();
	}
	
	public abstract double getBalance();	//returns the account's balance; to be implemented in SavingsAccount
	public abstract void makeDeposit(double amount) throws NegativeAmountEntered;	/*adds amount to the balance;
	to be implemented in SavingsAccount*/
	public abstract void makeWithdrawal(double amount) throws NegativeAmountEntered, InsufficientFunds;	/*subtracts amount from the
	balance; to be implemented in SavingsAccount*/
}
