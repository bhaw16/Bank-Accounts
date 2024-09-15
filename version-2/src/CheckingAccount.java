import java.io.*;
import java.util.*;

public class CheckingAccount extends Account {
	public CheckingAccount() throws IOException {
		super("Checking");
	}

	public CheckingAccount(Depositor person, int acctNum, double balance) throws IOException {
		super(person, acctNum, "Checking", balance);
	}

	public CheckingAccount(Depositor person, int acctNum, double balance, String str,
	String transactionHistory) throws IOException {
		super(person, acctNum, "Checking", balance, str, transactionHistory);
	}

	public CheckingAccount(Depositor person, int acctNum, double balance,
	String transactionHistory) throws IOException {
		super(person, acctNum, "Checking", balance, "Open", transactionHistory);
	}

	public CheckingAccount(int acctNum) throws IOException {
		super(acctNum, "Checking");
	}

	public CheckingAccount(CheckingAccount acct) throws IOException {
		super(acct);
	}
	
	public CheckingAccount(Depositor person, int acctNum, double balance,
	String transactionHistory, int numTransactions, Calendar maturityDate)
	throws IOException {
		super(person, acctNum, "Checking", balance, "Open", numTransactions, transactionHistory);
	}
	
	public CheckingAccount(Depositor person, int acctNum, double balance, String acctStatus,
	String transactionHistory, int numTransactions)
	throws IOException {
		super(person, acctNum, "Checking", balance, acctStatus, numTransactions, transactionHistory);
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

	public TransactionReceipt makeDeposit(TransactionTicket ticket) throws AccountClosedException, InvalidAmountException,
	IOException {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			throw new AccountClosedException(this);
			/*
			 * receipt = new TransactionReceipt(ticket, "Error: Account number " +
			 * ticket.getAcctNum() + " is closed.", getAcctBalance(), getAcctBalance());
			 */
		}
		else if (ticket.getAmountOfTransaction() <= 0.00) { // maturity date reached (if CD), invalid amount
			throw new InvalidAmountException(ticket.getAmountOfTransaction());
			/*
			 * receipt = new TransactionReceipt(ticket,
			 * String.format("Error: $%.2f is an invalid amount.",
			 * ticket.getAmountOfTransaction()), getAcctBalance(), getAcctBalance());
			 */
		}
		else { // maturity date reached (if CD), valid amount
			this.balance = getAcctBalance() + ticket.getAmountOfTransaction();
			receipt = new TransactionReceipt(ticket, getAcctBalance() - ticket.getAmountOfTransaction(),
			getAcctBalance());
			Bank.addToAllTotal(ticket.getAmountOfTransaction());
			Bank.addToCheckingTotal(ticket.getAmountOfTransaction());
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

	public TransactionReceipt makeWithdrawal(TransactionTicket ticket) throws AccountClosedException, InvalidAmountException,
	InsufficientFundsException, IOException {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			throw new AccountClosedException(this);
			/*
			 * receipt = new TransactionReceipt(ticket, "Error: Account number " +
			 * ticket.getAcctNum() + " is closed.", getAcctBalance(), getAcctBalance());
			 */
		}
		else if (ticket.getAmountOfTransaction() <= 0.00) { // maturity date reached (if CD), invalid amount
			throw new InvalidAmountException(ticket.getAmountOfTransaction());
			/*
			 * receipt = new TransactionReceipt(ticket,
			 * String.format("Error: $%.2f is an invalid amount.",
			 * ticket.getAmountOfTransaction()), getAcctBalance(), getAcctBalance());
			 */
		}
		else if (balance - ticket.getAmountOfTransaction() < 0.00) {
			if (ticket.getTypeOfTransaction().equals("Clear Check")) {
				throw new InsufficientFundsException(ticket.getCheck());
			}
			else {
				throw new InsufficientFundsException(ticket.getAmountOfTransaction());
			}
			/*
			 * receipt = new TransactionReceipt(ticket, String.
			 * format("Error: You do not have sufficient funds to withdraw $%.2f from your account."
			 * , ticket.getAmountOfTransaction()), getAcctBalance(), getAcctBalance());
			 */
		}
		else {
			double amount;
			String str;
			if (balance < 2500.00) {
				amount = ticket.getAmountOfTransaction() + 1.50;
				str = String.format(
						"You have incurred a $%.2f service fee because your account balance is below $%.2f.", 1.50,
						2500.00);
			} else {
				amount = ticket.getAmountOfTransaction();
				str = "";
			}
			balance -= amount;
			receipt = new TransactionReceipt(ticket, true, str, balance + amount, balance);
			Bank.subtractFromAllTotal(amount);
			Bank.subtractFromCheckingTotal(amount);
		}
		addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}

	public TransactionReceipt clearCheck(Check check, TransactionTicket ticket) throws InvalidAccountException, AccountClosedException,
	InvalidAmountException, InsufficientFundsException, CheckTooOldException, PostDatedCheckException, IOException {
		TransactionReceipt receipt;
		if (getAcctStatus().equalsIgnoreCase("Closed")) {
			throw new AccountClosedException(this);
			/*
			 * receipt = new TransactionReceipt(ticket, "Error: Account number " +
			 * ticket.getAcctNum() + " is closed.", getAcctBalance(), getAcctBalance());
			 * addTransaction(new TransactionReceipt(receipt));
			 */
		}
		else if ((check.getDateOfCheck().get(Calendar.YEAR) < ticket.getDateOfTransaction().get(Calendar.YEAR)
		|| (((check.getDateOfCheck().get(Calendar.MONTH) < ticket.getDateOfTransaction().get(Calendar.MONTH) - 6))
		&& (check.getDateOfCheck().get(Calendar.YEAR) == ticket.getDateOfTransaction().get(Calendar.YEAR))))
		|| (((check.getDateOfCheck().get(Calendar.MONTH) == ticket.getDateOfTransaction().get(Calendar.MONTH) - 6)
		&& check.getDateOfCheck().get(Calendar.DAY_OF_MONTH) < ticket.getDateOfTransaction().get(Calendar.DAY_OF_MONTH))
		&& (check.getDateOfCheck().get(Calendar.YEAR) == ticket.getDateOfTransaction().get(Calendar.YEAR)))) {
			// check is older than 6 months
			throw new CheckTooOldException();
			/*
			 * receipt = new TransactionReceipt(ticket,
			 * "Error: This check is older than 6 months.", getAcctBalance(),
			 * getAcctBalance()); addTransaction(new TransactionReceipt(receipt));
			 */
		}
		else if ((check.getDateOfCheck().get(Calendar.DAY_OF_YEAR) > (ticket.getDateOfTransaction().get(Calendar.DAY_OF_YEAR))
		&& (check.getDateOfCheck().get(Calendar.YEAR) == (ticket.getDateOfTransaction().get(Calendar.YEAR)))
		|| (check.getDateOfCheck().get(Calendar.YEAR) > (ticket.getDateOfTransaction().get(Calendar.YEAR))))) {
			// check date not reached yet
			throw new PostDatedCheckException();
			/*
			 * receipt = new TransactionReceipt(ticket,
			 * "Error: The date of this check has not been reached yet.", getAcctBalance(),
			 * getAcctBalance()); addTransaction(new TransactionReceipt(receipt));
			 */
		}
		else {
			receipt = new TransactionReceipt(makeWithdrawal(ticket));
		}
		return new TransactionReceipt(receipt);
	}

	/*
	 * Method closeAcct() Input: ticket - a filled out TransactionTicket Process: If
	 * the account is already closed, the TransactionReceipt returned has an error
	 * message describing this Otherwise, the account is closed and the
	 * TransactionReceipt returned is added to the transaction history Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt closeAcct(TransactionTicket ticket) throws InvalidAccountException, IOException {
		TransactionReceipt receipt;
		if (this.getAcctStatus().equalsIgnoreCase("Closed")) { // invalid account status
			throw new InvalidAccountException(this, acctStatus);
			/*
			 * receipt = new TransactionReceipt(ticket, "Account number " +
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
			 * receipt = new TransactionReceipt(ticket, "Account number " +
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
