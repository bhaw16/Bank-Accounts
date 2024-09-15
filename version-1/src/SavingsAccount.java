import java.util.*;

public class SavingsAccount extends Account {
	public SavingsAccount() {
		super("Savings");
	}
	
	public SavingsAccount(Depositor person, int acctNum, double balance) {
		super(person, acctNum, "Savings", balance);
	}
	
	public SavingsAccount(Depositor person, int acctNum, double balance,
	String str, ArrayList<TransactionReceipt> transactionHistory) {
		super(person, acctNum, "Savings", balance, str, transactionHistory);
	}
	
	public SavingsAccount(Depositor person, int acctNum, String acctType, double balance,
	ArrayList<TransactionReceipt> transactionHistory) {
		super(person, acctNum, "Savings", balance, "Open", transactionHistory);
	}

	public SavingsAccount(int acctNum) {
		super(acctNum, "Savings");
	}
	
	public SavingsAccount(SavingsAccount acct) {
		super(acct);
	}
	
	public SavingsAccount(Depositor person, int acctNum, String acctType, double balance) {
		super(person, acctNum, acctType, balance);
	}
	
	public SavingsAccount(Depositor person, int acctNum, String acctType, double balance,
	String str, ArrayList<TransactionReceipt> transactionHistory) {
		super(person, acctNum, acctType, balance, str, transactionHistory);
	}

	public SavingsAccount(int acctNum, String acctType) {
		super(acctNum, acctType);
	}
	
	public SavingsAccount(String acctType) {
		super(acctType);
	}
	
	/*
	 * Method getBalance() Input: ticket - filled out TransactionTicket Process:
	 * returns a TransactionReceipt detailing the current account balance and adds
	 * it to the transaction history Output: receipt - TransactionReceipt detailing
	 * the current account balance and adds it to the transaction history
	 */
	public TransactionReceipt getBalance(TransactionTicket ticket) {
		TransactionReceipt receipt = new TransactionReceipt(ticket, getAcctBalance(), getAcctBalance());
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}

	/*
	 * Method makeDeposit() Input: ticket - filled out TransactionTicket Process: If
	 * the account is a CD and the maturity date hasn't been reached yet, a
	 * TransactionReceipt with an error message detailing this is returned and added
	 * to the transaction history. Otherwise, if the deposit amount is invalid, a
	 * TransactionReceipt with an error message detailing this is returned and added
	 * to the transaction history. Otherwise, the deposit is made and a
	 * TransactionReceipt detailing the old and new balance is returned and added to
	 * the transaction history. Output: receipt - TransactionReceipt detailing the
	 * deposit transaction
	 */
	public TransactionReceipt makeDeposit(TransactionTicket ticket/* , Calendar date */) {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " is closed.",
					getAcctBalance(), getAcctBalance());
		}
		else if (ticket.getAmountOfTransaction() <= 0.00) { // maturity date reached (if CD), invalid amount
			receipt = new TransactionReceipt(ticket,
			String.format("Error: $%.2f is an invalid amount.", ticket.getAmountOfTransaction()),
			getAcctBalance(), getAcctBalance());
		}
		else { // maturity date reached (if CD), valid amount
			this.balance = getAcctBalance() + ticket.getAmountOfTransaction();
			// setMaturityDate(date);
			receipt = new TransactionReceipt(ticket, getAcctBalance() - ticket.getAmountOfTransaction(),
			getAcctBalance()/* , date */);
			Bank.addToAllTotal(ticket.getAmountOfTransaction());
			Bank.addToSavingsTotal(ticket.getAmountOfTransaction());
			/*
			 * switch (acctType) { case "Checking":
			 * Bank.addToCheckingTotal(ticket.getAmountOfTransaction()); break; case
			 * "Savings": Bank.addToSavingsTotal(ticket.getAmountOfTransaction()); break;
			 * default: Bank.addToCDTotal(ticket.getAmountOfTransaction()); break; }
			 */
		}
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}

	/*
	 * Method makeWithdrawal() Input: ticket - filled out TransactionTicket Process:
	 * If the account is a CD and the maturity date hasn't been reached yet, a
	 * TransactionReceipt with an error message detailing this is returned.
	 * Otherwise, if the deposit amount is invalid, a TransactionReceipt with an
	 * error message detailing this is returned. Otherwise, if the account has
	 * insufficient funds, a TransactionReceipt with an error message detailing this
	 * is returned added to the transaction history. Otherwise, the withdrawal is
	 * made and a TransactionReceipt detailing the old and new balance is returned
	 * and added to the transaction history. Output: receipt - TransactionReceipt
	 * detailing the deposit transaction
	 */
	public TransactionReceipt makeWithdrawal(TransactionTicket ticket /*Calendar date*/) {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " is closed.",
					getAcctBalance(), getAcctBalance());
		}
		else if (ticket.getAmountOfTransaction() <= 0.00) { // maturity date reached (if CD), invalid amount
			receipt = new TransactionReceipt(ticket,
					String.format("Error: $%.2f is an invalid amount.", ticket.getAmountOfTransaction()),
					getAcctBalance(), getAcctBalance());
		}
		else if (getAcctBalance() - ticket.getAmountOfTransaction() < 0.00) { // maturity date reached (if CD), valid
																				// amount, insufficient funds
			receipt = new TransactionReceipt(ticket, String.format("Error: You do not have sufficient funds to withdraw $%.2f from your account.",
			ticket.getAmountOfTransaction()), getAcctBalance(), getAcctBalance());
		}
		else {
			this.balance = getAcctBalance() - ticket.getAmountOfTransaction(); // maturity date reached (if CD), valid
																			// amount, sufficient funds
			// setMaturityDate(date);
			receipt = new TransactionReceipt(ticket, getAcctBalance() + ticket.getAmountOfTransaction(),
			getAcctBalance());
			Bank.subtractFromAllTotal(ticket.getAmountOfTransaction());
			Bank.subtractFromSavingsTotal(ticket.getAmountOfTransaction());
		}
		/*
		 * switch (acctType) { case "Checking":
		 * Bank.subtractFromCheckingTotal(ticket.getAmountOfTransaction()); break; case
		 * "Savings": Bank.subtractFromSavingsTotal(ticket.getAmountOfTransaction());
		 * break; default: Bank.subtractFromCDTotal(ticket.getAmountOfTransaction());
		 * break; }
		 */
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}

	/*
	 * Method clearCheck() Input: ticket - filled out TransactionTicket check - the
	 * Check that will be cleared from the account Process: If the account is not a
	 * checking account, a TransactionReceipt with an error message detailing this
	 * is returned and added to the transaction history. Otherwise, if the check is
	 * older than six months, a TransactionReceipt with an error message detailing
	 * this is returned and added to the transaction history. Otherwise, if the
	 * check date hasn't been reached yet, a TransactionReceipt with an error
	 * message detailing this is returned and added to the transaction history.
	 * Otherwise, makeWithdrawal() is called. If an error message is produced saying
	 * the account has insufficient funds, a $2.50 penalty fee is incurred and a
	 * TransactionReceipt with an error message detailing this is returned and added
	 * to the transaction history. Output: receipt - TransactionReceipt detailing
	 * the deposit transaction
	 */
	public TransactionReceipt clearCheck(Check check, TransactionTicket ticket) {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " is closed.",
			getAcctBalance(), getAcctBalance());
		}
		else /* if (!(getAcctType().equalsIgnoreCase("Checking"))) */ { // invalid account type
			receipt = new TransactionReceipt(ticket,
			"Error: Account number " + ticket.getAcctNum() + " is not a checking account.", getAcctBalance(),
			getAcctBalance());
			
		} /*
			 * else if ((check.getDateOfCheck().get(Calendar.YEAR) <
			 * ticket.getDateOfTransaction().get(Calendar.YEAR) ||
			 * (((check.getDateOfCheck().get(Calendar.MONTH) <
			 * ticket.getDateOfTransaction().get(Calendar.MONTH) - 6)) &&
			 * (check.getDateOfCheck().get(Calendar.YEAR) == ticket.getDateOfTransaction()
			 * .get(Calendar.YEAR)))) || (((check.getDateOfCheck().get(Calendar.MONTH) ==
			 * ticket.getDateOfTransaction().get(Calendar.MONTH) - 6) &&
			 * check.getDateOfCheck().get(Calendar.DAY_OF_MONTH) <
			 * ticket.getDateOfTransaction() .get(Calendar.DAY_OF_MONTH)) &&
			 * (check.getDateOfCheck().get(Calendar.YEAR) == ticket.getDateOfTransaction()
			 * .get(Calendar.YEAR)))) { // check is older than 6 months receipt = new
			 * TransactionReceipt(ticket, "Error: This check is older than 6 months.",
			 * getAcctBalance(), getAcctBalance()); addTransaction(new
			 * TransactionReceipt(receipt)); } else if ((check.getDateOfCheck()
			 * .get(Calendar.DAY_OF_YEAR) >
			 * (ticket.getDateOfTransaction().get(Calendar.DAY_OF_YEAR)) &&
			 * (check.getDateOfCheck().get(Calendar.YEAR) ==
			 * (ticket.getDateOfTransaction().get(Calendar.YEAR))) ||
			 * (check.getDateOfCheck().get(Calendar.YEAR) >
			 * (ticket.getDateOfTransaction().get(Calendar.YEAR))))) { // check date not
			 * reached yet receipt = new TransactionReceipt(ticket,
			 * "Error: The date of this check has not been reached yet.", getAcctBalance(),
			 * getAcctBalance()); addTransaction(new TransactionReceipt(receipt)); } else {
			 * // valid check date receipt = new TransactionReceipt(makeWithdrawal(ticket,
			 * null)); if (receipt.getReasonForFailure() .equals(String.format(
			 * "Error: You do not have sufficient funds to withdraw $%.2f from your account."
			 * , ticket.getAmountOfTransaction()))) { // insufficient funds
			 * setBalance(getAcctBalance() - 2.50); receipt = new TransactionReceipt(ticket,
			 * String.format("Your check bounced because you do " +
			 * "not have sufficient funds to withdraw $%.2f from your account.\n" +
			 * "You have incurred a penalty fee of $%.2f.", check.getAmountOfCheck(), 2.50),
			 * getAcctBalance() + 2.50, getAcctBalance());
			 * transactionHistory.set(transactionHistory.size() - 1, new
			 * TransactionReceipt(receipt)); Bank.subtractFromCheckingTotal(2.50); } }
			 */
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}

	/*
	 * Method closeAcct() Input: ticket - a filled out TransactionTicket Process: If
	 * the account is already closed, the TransactionReceipt returned has an error
	 * message describing this Otherwise, the account is closed and the
	 * TransactionReceipt returned is added to the transaction history Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt closeAcct(TransactionTicket ticket) {
		TransactionReceipt receipt;
		if (this.getAcctStatus().equalsIgnoreCase("Closed")) { // invalid account status
			receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " is already closed.",
					getAcctBalance(), getAcctBalance());
		} else { // valid account status
			this.acctStatus = "Closed";
			receipt = new TransactionReceipt(ticket, getAcctBalance(), getAcctBalance());
		}
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}

	/*
	 * Method reopenAcct() Input: ticket - a filled out TransactionTicket Process:
	 * If the account is already open, the TransactionReceipt returned has an error
	 * message describing this Otherwise, the account is opened and the
	 * TransactionReceipt returned is added to the transaction history Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt reopenAcct(TransactionTicket ticket) {
		TransactionReceipt receipt;
		if (this.getAcctStatus().equalsIgnoreCase("Open")) { // invalid account status
			receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " is already open.",
					getAcctBalance(), getAcctBalance());
		} else { // valid account status
			this.acctStatus = "Open";
			receipt = new TransactionReceipt(ticket, getAcctBalance(), getAcctBalance());
		}
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}
}