import java.io.*;
import java.util.*;

public class Bank {
	//definition of instance fields;
	private RandomAccessFile accounts;
	private int numAccts = 0;
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
	public Bank() throws IOException {
		accounts = new RandomAccessFile("BankAccounts.dat", "rw");
		accounts.setLength(0);
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
	
	public Account acctAt(int index) throws IOException {
		Account account;
		accounts.seek(index * (174 * 2));
		char[] acct = new char[174];
		for (int i = 0; i < 174; i++) {
			acct[i] = accounts.readChar();
		}
		String AccountString = new String(acct);
		String first = AccountString.substring(0, 15).trim();
		String last = AccountString.substring(15, 30).trim();
		Name name = new Name(first, last);
		String SSN = AccountString.substring(30, 39);
		Depositor person = new Depositor(name, SSN);
		int acctNum = Integer.parseInt(AccountString.substring(39, 45));
		String acctType = AccountString.substring(45, 55).trim();
		String acctStatus = AccountString.substring(55, 61).trim();
		double balance = Double.parseDouble(AccountString.substring(61, 71).trim());
		String filename = AccountString.substring(71, 161).trim();
		int numTransactions = Integer.parseInt(AccountString.substring(161, 164).trim());
		Calendar maturityDate = Calendar.getInstance();
		if (AccountString.substring(164, 174).trim().equals("")) {
			maturityDate = null;
		}
		else {
			String[] dateFields = AccountString.substring(164, 174).trim().split("/");
			maturityDate.set(Integer.parseInt(dateFields[2]), (Integer.parseInt(dateFields[0]) - 1),
			Integer.parseInt(dateFields[1]));
		}
		switch(acctType) {
		case "CD":
			account = new CDAccount(person, acctNum, balance,
			acctStatus, filename, numTransactions, maturityDate);
			break;
		case "Savings":
			account = new SavingsAccount(person, acctNum, balance,
			acctStatus, numTransactions, filename);
			break;
		default:
			account = new CheckingAccount(person, acctNum, balance,
			acctStatus, filename, numTransactions);
			break;
		}
		return account;
	}
	
	public int acctNumberAt(int index) throws IOException {
		accounts.seek(index * (174 * 2));
		return acctAt(index).getAcctNum();
	}
	
	/*Method getNumActiveAccounts()
	 * Input:
	 * none
	 * Process:
	 * returns the number of accounts in the bank
	 * Output:
	 * returns the number of accounts in the bank
	 */
	public int getNumAccounts() throws IOException {
		//returns the number of active accounts in the bank
		return numAccts;
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
	public int findAcct(int acctNum) throws IOException {
		int index = -1;
		for (int i = 0; i < numAccts; i++) {
			if (acctAt(i).getAcctNum() == acctNum) {
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
	public Account getAccount(int acctNum) throws IOException {
		//returns the account at the index of the requested account number
		Account account;
		switch(acctAt(findAcct(acctNum)).getAcctType()) {
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
	
	public SavingsAccount getSavingsAccount(int acctNum) throws IOException {
		return new SavingsAccount((SavingsAccount)acctAt(findAcct(acctNum)));
	}
	
	public CheckingAccount getCheckingAccount(int acctNum) throws IOException {
		return new CheckingAccount((CheckingAccount)acctAt(findAcct(acctNum)));
	}
	
	public CDAccount getCDAccount(int acctNum) throws IOException {
		return new CDAccount((CDAccount)acctAt(findAcct(acctNum)));
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
	public TransactionReceipt getBalance(TransactionTicket ticket) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		Account account;
		try {
			if (index == -1) { //invalid account
				 throw new InvalidAccountException(ticket.getAcctNum());
			}
			else {	//valid account
				account = acctAt(index);
				receipt = account.getBalance(ticket);
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		catch (InvalidAccountException e) {
			receipt = new TransactionReceipt(ticket, e.getMessage());
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
	public TransactionReceipt makeDeposit(TransactionTicket ticket) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		Account account;
		try {
			if (index == -1) {	//invalid account
				throw new InvalidAccountException(ticket.getAcctNum());
			}
			else {	//valid account
				account = acctAt(index);
				receipt = account.makeDeposit(ticket);
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		catch (InvalidAccountException | AccountClosedException | InvalidAmountException
		| CDMaturityDateException e) {
			if (e.getMessage().equals("Error: Account number " + ticket.getAcctNum() + " does not exist.")) {
				receipt = new TransactionReceipt(ticket, e.getMessage());
			}
			else {
				account = acctAt(index);
				receipt = new TransactionReceipt(ticket, e.getMessage(),
				account.getAcctBalance(), account.getAcctBalance(),
				account.getMaturityDate());
				account.addTransaction(new TransactionReceipt(receipt));
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
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
	public TransactionReceipt makeWithdrawal(TransactionTicket ticket) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		Account account;
		try {
			if (index == -1) {	//invalid account
				throw new InvalidAccountException(ticket.getAcctNum());
			}
			else {	//valid account
				account = acctAt(index);
				receipt = account.makeWithdrawal(new TransactionTicket(ticket));
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		catch (InvalidAccountException | AccountClosedException | InvalidAmountException
		| InsufficientFundsException | CDMaturityDateException e) {
			if (e.getMessage().equals("Error: Account number " + ticket.getAcctNum() + " does not exist.")) {
				receipt = new TransactionReceipt(ticket, e.getMessage());
			}
			else {
				account = acctAt(index);
				receipt = new TransactionReceipt(ticket, e.getMessage(),
				account.getAcctBalance(), account.getAcctBalance(),
				account.getMaturityDate());
				account.addTransaction(new TransactionReceipt(receipt));
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
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
	public TransactionReceipt clearCheck(Check check, TransactionTicket ticket) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		Account account;
		try {
			if (index == -1) {	//invalid account
				throw new InvalidAccountException(ticket.getAcctNum());
				//receipt = new TransactionReceipt(ticket, "Error: Account number " + check.getAcctNum() + " does not exist.");
			}
			else {	//valid account
				account = acctAt(index);
				receipt = account.clearCheck(check, ticket);
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		catch (InvalidAccountException | AccountClosedException | InvalidAmountException
		| CheckTooOldException | PostDatedCheckException e) {
			if (e.getMessage().equals("Error: Account number " + ticket.getAcctNum() + " does not exist.")) {
				receipt = new TransactionReceipt(ticket, e.getMessage());
			}
			else {
				account = acctAt(index);
				receipt = new TransactionReceipt(ticket, e.getMessage(), account.getAcctBalance(),
				account.getAcctBalance(), account.getMaturityDate());
				account.addTransaction(new TransactionReceipt(receipt));
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		catch (InsufficientFundsException e) {
			account = acctAt(index);
			Account checking = new CheckingAccount(account.getDepositor(), account.getAcctNum(),
			account.getAcctBalance() - 2.50, account.getTransactionHistory());
			receipt = new TransactionReceipt(ticket, e.getMessage(), checking.getAcctBalance() + 2.50, checking.getAcctBalance());
			checking.addTransaction(new TransactionReceipt(receipt));
			Bank.subtractFromAllTotal(2.50);
			Bank.subtractFromCheckingTotal(2.50);
			accounts.seek(index * (174 * 2));
			for (int i = 0; i < 174; i += 174) {
				accounts.writeChars(checking.getAcctString());
			}
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
	public TransactionReceipt openNewAcct(TransactionTicket ticket, Account account) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		try {
			if (index != -1) {		//invalid account
				throw new InvalidAccountException(acctAt(index));
			}
			else {	//valid account
			//adds account to ArrayList of accounts
				index = (int)accounts.length() - (174 * 2);
				receipt = new TransactionReceipt(ticket, 0.00, ticket.getAmountOfTransaction(), ticket.getTermOfCD());
				Bank.addToAllTotal(ticket.getAmountOfTransaction());
				account.addTransaction(new TransactionReceipt(receipt));
				accounts.setLength((numAccts + 1) * (174 * 2));
				accounts.seek(accounts.length() - (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
				numAccts++;
				switch(account.getAcctType()) {
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
		}
		catch (InvalidAccountException e) {
			account = acctAt(index);
			receipt = new TransactionReceipt(ticket, e.getMessage(), account.getAcctBalance(),
			account.getAcctBalance(), account.getMaturityDate());
			account.addTransaction(new TransactionReceipt(receipt));
			accounts.seek(index * (174 * 2));
			for (int i = 0; i < 174; i += 174) {
				accounts.writeChars(account.getAcctString());
			}
		}
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
	public TransactionReceipt deleteAcct(TransactionTicket ticket) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		Account account;
		try {
			if (index == -1) {	//invalid account
				throw new InvalidAccountException(ticket.getAcctNum());
				//receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " does not exist.");
			}
			else {
				account = acctAt(index);
				if (account.getAcctBalance() != 0.00) {	//valid account, invalid balance
					throw new InvalidAmountException(account);
				}
				else {	//valid account, valid balance
					/*removes the account at the index of the requested account*/
					account = acctAt(numAccts - 1);
					accounts.seek(index * (174 * 2));
					for (int i = 0; i < 174; i += 174) {
						accounts.writeChars(account.getAcctString());
					}
					accounts.setLength((numAccts - 1) * (174 * 2));
					numAccts--;
					receipt = new TransactionReceipt(ticket);
				}
			}
		}
		catch (InvalidAccountException e) {
			receipt = new TransactionReceipt(ticket, e.getMessage());
		}
		catch (InvalidAmountException e) {
			account = acctAt(index);
			receipt = new TransactionReceipt(ticket, e.getMessage(), account.getAcctBalance(),
			account.getAcctBalance(), account.getMaturityDate());
			account.addTransaction(new TransactionReceipt(receipt));
			accounts.seek(index * (174 * 2));
			for (int i = 0; i < 174; i += 174) {
				accounts.writeChars(account.getAcctString());
			}
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
	public TransactionReceipt reopenAcct(TransactionTicket ticket) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		Account account;
		try {
			if (index == -1) {	//invalid account
				throw new InvalidAccountException(ticket.getAcctNum());
				//receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " does not exist.");
			}
			else {	//valid account
				account = acctAt(index);
				receipt = account.reopenAcct(ticket);
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		catch (InvalidAccountException e) {
			if (e.getMessage().equals("Error: Account number " + ticket.getAcctNum() + " does not exist.")) {
				receipt = new TransactionReceipt(ticket, e.getMessage());
			}
			else {
				account = acctAt(index);
				receipt = new TransactionReceipt(ticket, e.getMessage(),
				account.getAcctBalance(), account.getAcctBalance(),
				account.getMaturityDate());
				account.addTransaction(new TransactionReceipt(receipt));
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
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
	public TransactionReceipt closeAcct(TransactionTicket ticket) throws IOException {
		TransactionReceipt receipt;
		int index = findAcct(ticket.getAcctNum());
		Account account;
		try {
			if (index == -1) {	//invalid account
				throw new InvalidAccountException(ticket.getAcctNum());
				//receipt = new TransactionReceipt(ticket, "Account number " + ticket.getAcctNum() + " does not exist.");
			}
			else {	//valid account
				account = acctAt(index);
				receipt = account.closeAcct(ticket);
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		catch (InvalidAccountException e) {
			if (e.getMessage().equals("Error: Account number " + ticket.getAcctNum() + " does not exist.")) {
				receipt = new TransactionReceipt(ticket, e.getMessage());
			}
			else {
				account = acctAt(index);
				receipt = new TransactionReceipt(ticket, e.getMessage(),
				account.getAcctBalance(), account.getAcctBalance(),
				account.getMaturityDate());
				account.addTransaction(new TransactionReceipt(receipt));
				accounts.seek(index * (174 * 2));
				for (int i = 0; i < 174; i += 174) {
					accounts.writeChars(account.getAcctString());
				}
			}
		}
		return new TransactionReceipt(receipt);
	}
}
