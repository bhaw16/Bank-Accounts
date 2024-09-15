import java.io.*;
import java.util.*;

public class SavingsAccount extends Account {
	public SavingsAccount() throws IOException {
		super("Savings");
	}
	
	public SavingsAccount(Depositor person, int acctNum, double balance) throws IOException {
		super(person, acctNum, "Savings", balance);
	}
	
	public SavingsAccount(Depositor person, int acctNum, double balance,
	String str, String transactionHistory) throws IOException {
		super(person, acctNum, "Savings", balance, str, transactionHistory);
	}
	
	public SavingsAccount(Depositor person, int acctNum, double balance,
	String transactionHistory) throws IOException {
		super(person, acctNum, "Savings", balance, "Open", transactionHistory);
	}

	public SavingsAccount(int acctNum) throws IOException {
		super(acctNum, "Savings");
	}
	
	public SavingsAccount(SavingsAccount acct) throws IOException {
		super(acct);
	}
	
	public SavingsAccount(Depositor person, int acctNum, String acctType, double balance)
	throws IOException {
		super(person, acctNum, acctType, balance);
	}
	
	public SavingsAccount(Depositor person, int acctNum, String acctType, double balance,
	String transactionHistory) throws IOException {
		super(person, acctNum, acctType, balance, transactionHistory);
	}
	
	public SavingsAccount(Depositor person, int acctNum, String acctType, double balance,
	String str, String transactionHistory) throws IOException {
		super(person, acctNum, acctType, balance, str, transactionHistory);
	}

	public SavingsAccount(int acctNum, String acctType) throws IOException {
		super(acctNum, acctType);
	}
	
	public SavingsAccount(String acctType) throws IOException {
		super(acctType);
	}
	
	public SavingsAccount(Depositor person, int acctNum, String acctType, double balance, String acctStatus,
	int numTransactions, String transactionHistory) throws IOException {
		// TODO Auto-generated constructor stub
		super(person, acctNum, acctType, balance, acctStatus, numTransactions, transactionHistory);
	}
	
	public SavingsAccount(Depositor person, int acctNum, double balance, String acctStatus,
	int numTransactions, String transactionHistory) throws IOException {
		// TODO Auto-generated constructor stub
		super(person, acctNum, "Savings", balance, acctStatus, numTransactions, transactionHistory);
	}

	/*
	 * Method getBalance() Input: ticket - filled out TransactionTicket Process:
	 * returns a TransactionReceipt detailing the current account balance and adds
	 * it to the transaction history Output: receipt - TransactionReceipt detailing
	 * the current account balance and adds it to the transaction history
	 */
	public TransactionReceipt getBalance(TransactionTicket ticket) throws IOException {
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
	public TransactionReceipt makeDeposit(TransactionTicket ticket) throws AccountClosedException, InvalidAmountException,
	CDMaturityDateException, IOException {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			throw new AccountClosedException(this);
		}
		else if (ticket.getAmountOfTransaction() <= 0.00) { // maturity date reached (if CD), invalid amount
			throw new InvalidAmountException(ticket.getAmountOfTransaction());
		}
		else { // maturity date reached (if CD), valid amount
			this.balance = getAcctBalance() + ticket.getAmountOfTransaction();
			receipt = new TransactionReceipt(ticket, getAcctBalance() - ticket.getAmountOfTransaction(),
			getAcctBalance()/* , date */);
			Bank.addToAllTotal(ticket.getAmountOfTransaction());
			Bank.addToSavingsTotal(ticket.getAmountOfTransaction());
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
	public TransactionReceipt makeWithdrawal(TransactionTicket ticket) throws AccountClosedException, InvalidAmountException,
	InsufficientFundsException, CDMaturityDateException, IOException {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			throw new AccountClosedException(this);
		}
		else if (ticket.getAmountOfTransaction() <= 0.00) { // maturity date reached (if CD), invalid amount
			throw new InvalidAmountException(ticket.getAmountOfTransaction());
		}
		else if (getAcctBalance() - ticket.getAmountOfTransaction() < 0.00) { // maturity date reached (if CD), valid
																				// amount, insufficient funds
			throw new InsufficientFundsException(ticket.getAmountOfTransaction());
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
	public TransactionReceipt clearCheck(Check check, TransactionTicket ticket) throws InvalidAccountException, AccountClosedException {
		//TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			throw new AccountClosedException(this);
		}
		else { // invalid account type
			throw new InvalidAccountException(check);
		}
	}

	/*
	 * Method closeAcct() Input: ticket - a filled out TransactionTicket Process: If
	 * the account is already closed, the TransactionReceipt returned has an error
	 * message describing this Otherwise, the account is closed and the
	 * TransactionReceipt returned is added to the transaction history Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt closeAcct(TransactionTicket ticket) throws InvalidAccountException,
	IOException {
		TransactionReceipt receipt;
		if (this.getAcctStatus().equalsIgnoreCase("Closed")) { // invalid account status
			throw new InvalidAccountException(this, acctStatus);
			/*
			 * receipt = new TransactionReceipt(ticket, "Error: Account number " +
			 * ticket.getAcctNum() + " is already closed.", getAcctBalance(),
			 * getAcctBalance());
			 */
		}
		else { // valid account status
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
	public TransactionReceipt reopenAcct(TransactionTicket ticket) throws InvalidAccountException,
	IOException {
		TransactionReceipt receipt;
		if (this.getAcctStatus().equalsIgnoreCase("Open")) { // invalid account status
			throw new InvalidAccountException(this, acctStatus);
			/*
			 * receipt = new TransactionReceipt(ticket, "Error: Account number " +
			 * ticket.getAcctNum() + " is already open.", getAcctBalance(),
			 * getAcctBalance());
			 */
		}
		else { // valid account status
			this.acctStatus = "Open";
			receipt = new TransactionReceipt(ticket, getAcctBalance(), getAcctBalance());
		}
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}
}