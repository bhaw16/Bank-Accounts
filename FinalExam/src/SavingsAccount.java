
public class SavingsAccount extends BankAccount implements Interest {
	/* Constructor SavingsAccount()
	 * Input:
	 * acctNumber - int representing the 6-digit account number
	 * balance - double representing the account balance in dollars and cents
	 * Process:
	 * Creates a new SavingsAccount instance using the super constructor
	 * (BankAccount constructor)
	 * Output:
	 * Creates a new SavingsAccount instance using the super constructor
	 * (BankAccount constructor)
	 */
	public SavingsAccount(int acctNumber, double balance) {
		super(acctNumber, balance);
		// TODO Auto-generated constructor stub
	}
	
	/* Copy Constructor SavingsAccount()
	 * Input:
	 * acct - account used to create a new BankAccount instance
	 * Process:
	 * Creates a new SavingsAccount instance using the copy constructor
	 * from the superclass (BankAccount copy constructor)
	 * Output:
	 * Creates a new SavingsAccount instance using the copy constructor
	 * from the superclass (BankAccount copy constructor)
	 */
	public SavingsAccount(SavingsAccount acct) {
		super(acct);
		// TODO Auto-generated constructor stub
	}
	
	/* Method addInterest()
	 * Input:
	 * percent - double representing the interest rate in percent
	 * Process:
	 * sets percent to its decimal form by dividing it by 100
	 * to calculate how much money will be added to the balance
	 * adds the current balance multiplied by percent's decimal form
	 * to the current balance
	 * Output:
	 * the current balance w/ added interest of percent%
	 */
	@Override
	public void addInterest(double percent) {
		// TODO Auto-generated method stub
		percent /= 100;	//get percentage as decimal
		balance += (balance * percent);	//multiply balance by decimal form of interest rate and add it to the current balance
	}
	
	/* Method getAcctNumber()
	 * Input:
	 * none
	 * Process:
	 * returns the account's 6-digit account number (acctNumber)
	 * Output:
	 * returns the account's 6-digit account number (acctNumber)
	 */
	public int getAcctNumber() {
		return acctNumber;
	}
	
	/* Method getBalance()
	 * Input:
	 * none
	 * Process:
	 * returns the account's current balance (balance)
	 * Output:
	 * returns the account's current balance (balance)
	 */
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	
	/* Method makeDeposit()
	 * Input:
	 * amount - amount to be deposited (added to the current balance)
	 * Process:
	 * If amount is negative (less than 0.00),
	 * a NegativeAmountEntered exception is thrown
	 * Otherwise, amount is added to the current balance
	 * Output:
	 * NegativeAmountEntered exception if amount is negative;
	 * amount added to current balance otherwise
	 */
	@Override
	public void makeDeposit(double amount) throws NegativeAmountEntered {
		// TODO Auto-generated method stub
		if (amount < 0.00) {	//invalid amount
			throw new NegativeAmountEntered(amount);
		}
		else {	//valid amount
			balance += amount;	//make deposit
		}
	}
	
	/* Method makeWithdrawal()
	 * Input:
	 * amount - amount to be withdrawn (subtracted from the current balance)
	 * Process:
	 * If amount is negative (less than 0.00),
	 * a NegativeAmountEntered exception is thrown
	 * Otherwise, if the withdrawal would result in a
	 * negative balance (insufficient funds),
	 * an InsufficientFunds exception is thrown
	 * Otherwise, amount is added to the current balance
	 * Output:
	 * NegativeAmountEntered exception if amount is negative;
	 * InsufficientFunds exception if amount is greater;
	 * than the current balance
	 * amount subtracted from current balance otherwise
	 */
	@Override
	public void makeWithdrawal(double amount) throws NegativeAmountEntered, InsufficientFunds {
		// TODO Auto-generated method stub
		if (amount < 0.00) {	//invalid amount
			throw new NegativeAmountEntered(amount);
		}
		else if (balance - amount < 0.00) {	//insufficient funds
			throw new InsufficientFunds(amount);
		}
		else {	//valid amount
			balance -= amount;	//make withdrawal
		}
	}

}
