import java.io.*;
import java.util.*;

public class Bank {
	//definition of instance fields;
	private ArrayList<Account> accounts;
	private static double totalAmountInSavingsAccts = 0.00;
	private static double totalAmountInCheckingAccts = 0.00;
	private static double totalAmountInCDAccts = 0.00;
	private static double totalAmountInAllAccts = 0.00;
	
	/*Constructor Bank()
	 * Input:
	 * none
	 * Process:
	 * Initializes an ArrayList of accounts
	 * Output:
	 * Initializes an ArrayList of accounts
	 */
	public Bank() {
		accounts = new ArrayList<Account>();
	}
	
	public static void addToSavingsTotal(double val) {
		totalAmountInSavingsAccts += val;
	}
	
	public static void addToCheckingTotal(double val) {
		totalAmountInCheckingAccts += val;
	}
	
	public static void addToCDTotal(double val) {
		totalAmountInCDAccts += val;
	}
	
	public static void addToAllTotal(double val) {
		totalAmountInAllAccts += val;
	}
	
	public static void subtractFromSavingsTotal(double val) {
		totalAmountInSavingsAccts -= val;
	}
	
	public static void subtractFromCheckingTotal(double val) {
		totalAmountInCheckingAccts -= val;
	}
	
	public static void subtractFromCDTotal(double val) {
		totalAmountInCDAccts -= val;
	}
	
	public static void subtractFromAllTotal(double val) {
		totalAmountInAllAccts -= val;
	}
	
	public int acctNumberAt(int index) {
		return accounts.get(index).getAcctNum();
	}
	
	/*Method getNumActiveAccounts()
	 * Input:
	 * none
	 * Process:
	 * returns the number of accounts in the bank
	 * Output:
	 * returns the number of accounts in the bank
	 */
	public int getNumAccounts() {
		//returns the number of active accounts in the bank
		return accounts.size();
	}
	
	public static double getTotalAmountInAllAccts() {
		return totalAmountInAllAccts;
	}
	
	public static double getTotalAmountInSavingsAccts() {
		return totalAmountInSavingsAccts;
	}
	
	public static double getTotalAmountInCheckingAccts() {
		return totalAmountInCheckingAccts;
	}
	
	public static double getTotalAmountInCDAccts() {
		return totalAmountInCDAccts;
	}
	
	/* Method findAcct()
	 * Input:
	 *  acctNum - requested account number
	 * Process:
	 *  Performs a linear search on the account array for the requested account
	 * Output:
	 *  If found, the index of the requested account is returned
	 *  Otherwise, returns -1
	 */
	public int findAcct(int acctNum) {
		int index = -1;
		for (int i = 0; i < getNumAccounts(); i++) {
			if (accounts.get(i).getAcctNum() == acctNum) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/*Method getAccount()
	 * Input:
	 * acctNum - requested account number
	 * Process:
	 * returns the account at the index of the requested account number, which is obtained by calling findAcct()
	 * Output:
	 * returns the account at the index of the requested account number
	 */
	public Account getAccount(int acctNum) {
		//returns the account at the index of the requested account number
		Account account;
		switch(accounts.get(findAcct(acctNum)).getAcctType()) {
		case "Savings":
			account = getSavingsAccount(acctNum);
			break;
		case "Checking":
			account = getCheckingAccount(acctNum);
			break;
		default:
			account = getCDAccount(acctNum);
		}
		return account;
	}
	
	public SavingsAccount getSavingsAccount(int acctNum) {
		return new SavingsAccount((SavingsAccount)accounts.get(findAcct(acctNum)));
	}
	
	public CheckingAccount getCheckingAccount(int acctNum) {
		return new CheckingAccount((CheckingAccount)accounts.get(findAcct(acctNum)));
	}
	
	public CDAccount getCDAccount(int acctNum) {
		return new CDAccount((CDAccount)accounts.get(findAcct(acctNum)));
	}
	
	/*Method getBalance()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Process:
	 * If the requested account number doesn't exist, the TransactionReceipt returned has an error message describing this
	 * Otherwise, the TransactionReceipt returned is the TransactionReceipt returned by the getBalance() method of the Account class
	 * Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt getBalance(TransactionTicket ticket) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index == -1) {	//invalid account
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " does not exist.");
		}
		
		else {	//valid account
			receipt = accounts.get(index).getBalance(ticket);
		}
		return new TransactionReceipt(receipt);
	}
	
	/*Method makeDeposit()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Process:
	 * If the requested account number doesn't exist, the TransactionReceipt returned has an error message describing this
	 * Otherwise, the TransactionReceipt returned is the TransactionReceipt returned by the makeDeposit() method of the Account class
	 * Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt makeDeposit(TransactionTicket ticket) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index == -1) {	//invalid account
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " does not exist.");
		}
		
		else {	//valid account
			/*
			 * Account ac = null; for (int i = 0; i < accounts.size(); i++) { if
			 * (accounts.get(i).getAcctNum() == ticket.getAcctNum()) { ac = accounts.get(i);
			 * break; } }
			 */
			receipt = accounts.get(index).makeDeposit(ticket);
		}
		return new TransactionReceipt(receipt);
	}
	
	/*Method makeWithdrawal()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Process:
	 * If the requested account number doesn't exist, the TransactionReceipt returned has an error message describing this
	 * Otherwise, the TransactionReceipt returned is the TransactionReceipt returned by the makeWithdrawal() method of the Account class
	 * Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt makeWithdrawal(TransactionTicket ticket) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index == -1) {	//invalid account
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " does not exist.");
		}
		
		else {	//valid account
			receipt = accounts.get(index).makeWithdrawal(new TransactionTicket(ticket));
		}
		return new TransactionReceipt(receipt);
	}
	
	/*Method clearCheck()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Process:
	 * If the requested account number doesn't exist, the TransactionReceipt returned has an error message describing this
	 * Otherwise, the TransactionReceipt returned is the TransactionReceipt returned by the clearCheck() method of the Account class
	 * Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt clearCheck(Check check, TransactionTicket ticket) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index == -1) {	//invalid account
			receipt = new TransactionReceipt(ticket, "Error: Account number " + check.getAcctNum() + " does not exist.");
		}
		
		else {	//valid account
			receipt = accounts.get(index).clearCheck(check, ticket);
				
		}
		return new TransactionReceipt(receipt);
	}
	
	/*Method openNewAccount()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Account - account to be added to the database
	 * Process:
	 * If the requested account does not exist, the TransactionReceipt returned has an error message describing this
	 * Otherwise, a new account with the passed in parameters is appended to the end of the ArrayList of accounts,
	 * constructing the TransactionReceipt to be returned to have a TransactionTicket ticket
	 * and postTransactionMaturityDate equal to the maturity date of the new account
	 * The TransactionReceipt returned is added to the transaction history of either the existing account'
	 * if the transaction failed or the new account if the transaction succeeded.
	 * Output:
	 * receipt - TransactionReceipt indicating either a failure due to the database being full or the requested account existing
	 * or success in creating the account, in which a new account is added to the next available spot in the array of accounts and
	 */
	public TransactionReceipt openNewAcct(TransactionTicket ticket, Account account) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index != -1) {		//invalid account
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " already exists.", getAccount(ticket.getAcctNum()).getAcctBalance(),
			getAccount(ticket.getAcctNum()).getAcctBalance());
		}
		
		else {	//valid account
			//adds account to ArrayList of accounts
			accounts.add(account);
			receipt = new TransactionReceipt(ticket, 0.00, ticket.getAmountOfTransaction(), ticket.getTermOfCD());
			Bank.addToAllTotal(ticket.getAmountOfTransaction());
			switch(accounts.get(findAcct(ticket.getAcctNum())).getAcctType()) {
			case "Checking":
				Bank.addToCheckingTotal(ticket.getAmountOfTransaction());
				break;
			case "Savings":
				Bank.addToSavingsTotal(ticket.getAmountOfTransaction());
				break;
			default:
				Bank.addToCDTotal(ticket.getAmountOfTransaction());
				break;
			}
		}
		index = accounts.size() - 1;
		accounts.get(index).addTransaction(new TransactionReceipt(receipt));
		return new TransactionReceipt(receipt);
	}
	
	/*Method deleteAccount()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Process:
	 * If the requested account doesn't exist, the TransactionReceipt returned has an error message describing this
	 * Otherwise, if the account has a zero balance the TransactionReceipt returned has an error message describing this
	 * Otherwise, the account at the index containing the account to be deleted
	 * is replaced with a new account that has the parameters of the account to be deleted except its account status is closed,
	 * which "closes" the account. It is then removed from the ArrayList of accounts
	 * If the account is not deleted, the TransactionReceipt is added to the transaction history
	 * Output:
	 * receipt - TransactionReceipt indicating either a non-zero balance or the requested account not existing
	 * or success in deleting the account, in which the requested account is closed and removed from the ArrayList
	 */
	public TransactionReceipt deleteAcct(TransactionTicket ticket) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index == -1) {	//invalid account
			receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " does not exist.");
		}
		
		else if (accounts.get(index).getAcctBalance() != 0.00) {	//valid account, invalid balance
			receipt = new TransactionReceipt(ticket, String.format("Account number "+ ticket.getAcctNum() + " does not have a balance of $%.2f", 0.00),
			accounts.get(index).getAcctBalance(), accounts.get(index).getAcctBalance());
			accounts.get(index).addTransaction(new TransactionReceipt(receipt));
		}
		
		else {	//valid account, valid balance
				accounts.remove(index);	/*removes the account at the index of the requested account*/
				receipt = new TransactionReceipt(ticket);
			}
		return new TransactionReceipt(receipt);
	}
	
	/*Method reopenAcct()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Process:
	 * If the requested account doesn't exist, the TransactionReceipt returned has an error message describing this.
	 * Otherwise, the TransactionReceipt returned is the TransactionReceipt returned by the reopenAcct() method of the Account class
	 * Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt reopenAcct(TransactionTicket ticket) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index == -1) {	//invalid account
			receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " does not exist.");
		}
		else {	//valid account
			receipt = accounts.get(index).reopenAcct(ticket);
		}
		return new TransactionReceipt(receipt);
	}
	
	/*Method closeAcct()
	 * Input:
	 * ticket - a filled out TransactionTicket
	 * Process:
	 * If the requested account doesn't exist, the TransactionReceipt returned has an error message describing this.
	 * Otherwise, the TransactionReceipt returned is the TransactionReceipt returned by the closeAcct() method of the Account class
	 * Output:
	 * receipt - TransactonReceipt detailing the transaction upon its completion
	 */
	public TransactionReceipt closeAcct(TransactionTicket ticket) {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		if (index == -1) {	//invalid account
			receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " does not exist.");
		}
		else {	//valid account
			receipt = accounts.get(index).closeAcct(ticket);
		}
		return new TransactionReceipt(receipt);
	}
}
