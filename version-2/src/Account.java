import java.io.*;
import java.util.*;

public class Account extends genAccount {
	// definition of instance fields
	/*
	 * private Depositor person; private int acctNum; private String acctType;
	 * protected double balance; protected String acctStatus; protected
	 * ArrayList<TransactionReceipt> transactionHistory;
	 */

	public Account(Account acct) throws IOException {
		super(acct);
	}

	public Account() throws IOException {
		super();
	}

	public Account(String str) throws IOException {
		super(str);
	}

	/*
	 * Constructor Account() Input: person - Depositor object acctNum - int
	 * representing an account number acctType - String representing the account
	 * type balance - double representing the account balance Process: Sets the
	 * Depositor to the Depositor object passed to the constructor Sets the acctNum
	 * to the int passed to the constructor Sets the acctType to the String passed
	 * to the constructor Sets the balance to the double passed to the constructor
	 * Sets the maturity date of the account to null Creates a new ArrayList
	 * representing the transaction history Output: creates a new Account with a
	 * Depositor person, int (account number) acctNum, String (account type)
	 * acctType, double (account balance) balance and Calendar (maturity date)
	 * maturityDate of null Creates a new ArrayList representing the transaction
	 * history
	 */
	public Account(Depositor person, int acctNum, String acctType, double balance) throws IOException {
		super(person, acctNum, acctType, balance);
	}


	/*
	 * Constructor Account() Input: person - Depositor object acctNum - int
	 * representing an account number acctType - String representing the account
	 * type balance - double representing the account balance Calendar - date that
	 * you are allowed to perform transactions on the CD transactionHistory -
	 * arrayList of TransactionReceipts representing transaction history Process:
	 * Sets the Depositor to the Depositor object passed to the constructor Sets the
	 * acctNum to the int passed to the constructor Sets the acctType to the String
	 * passed to the constructor Sets the balance to the double passed to the
	 * constructor Sets the maturityDate to the Calendar object passed to the
	 * constructor Sets the transactionHistory to the ArrayList passed in Output:
	 * creates a new Account with a Depositor person, int (account number) acctNum,
	 * String (account type) acctType, double (account balance) balance and Calendar
	 * (CD maturity date) maturity date Sets the transactionHistory to the ArrayList
	 * passed in
	 */
	public Account(Depositor person, int acctNum, String acctType, double balance,
	String str, String transactionHistory) throws IOException {
		// sets the parameters of the Account w/ the parameters passed in
		super(person, acctNum, acctType, balance, str, transactionHistory);
	}

	/*
	 * Constructor Account() Input: person - Depositor object acctNum - int
	 * representing an account number acctType - String representing the account
	 * type balance - double representing the account balance Calendar - date that
	 * you are allowed to perform transactions on the CD transactionHistory -
	 * arrayList of TransactionReceipts representing transaction history Process:
	 * Sets the Depositor to the Depositor object passed to the constructor Sets the
	 * acctNum to the int passed to the constructor Sets the acctType to the String
	 * passed to the constructor Sets the balance to the double passed to the
	 * constructor Sets the maturityDate to the Calendar object passed to the
	 * constructor Sets the transactionHistory to the ArrayList passed in Output:
	 * creates a new Account with a Depositor person, int (account number) acctNum,
	 * String (account type) acctType, double (account balance) balance and Calendar
	 * (CD maturity date) maturity date Sets the transactionHistory to the ArrayList
	 * passed in
	 */
	public Account(Depositor person, int acctNum, String acctType, double balance,
	String transactionHistory) throws IOException {
		// sets the parameters of the BankAccount w/ the parameters passed in
		super(person, acctNum, acctType, balance, transactionHistory);
	}

	/*
	 * Constructor Account() Input: acctNum - int representing the account number
	 * Process: Sets the Depositor to a new Depositor object (which has all of its
	 * instance fields as null) Sets the acctNum to the int passed to the
	 * constructor Sets the acctType to a null String Sets the balance to a double
	 * value of 0.00 Sets the maturityDate to null Creates a new ArrayList
	 * representing the transaction history Output: creates a new Account with a
	 * Depositor of a first and last name "" and "" and an SSN "", int (account
	 * number) acctNum, String (account type) "", double (account balance) 0.00 and
	 * Calendar (maturity date) maturityDate of null Creates a new ArrayList
	 * representing the transaction history
	 */
	public Account(int acctNum) throws IOException {
		// sets acctNum w/ passed in int and sets object parameters to null and balance
		// to 0.00
		super(acctNum);
	}

	/*
	 * Constructor Account() Input: acctNum - int representing the account number
	 * Process: Sets the Depositor to a new Depositor object (which has all of its
	 * instance fields as null) Sets the acctNum to the int passed to the
	 * constructor Sets the acctType to a null String Sets the balance to a double
	 * value of 0.00 Sets the maturityDate to null Creates a new ArrayList
	 * representing the transaction history Output: creates a new Account with a
	 * Depositor of a first and last name "" and "" and an SSN "", int (account
	 * number) acctNum, String (account type) "", double (account balance) 0.00 and
	 * Calendar (maturity date) maturityDate of null Creates a new ArrayList
	 * representing the transaction history
	 */
	public Account(int acctNum, String str) throws IOException {
		// sets acctNum w/ passed in int and sets object parameters to null and balance
		// to 0.00
		super(acctNum, str);
	}

	/*
	 * public String toString() { String mdate;
	 * 
	 * if (getAcctType().equals("CD")) { mdate = maturityDate.get((Calendar.MONTH))
	 * + 1 + "/" + maturityDate.get(Calendar.DAY_OF_MONTH) + "/" +
	 * maturityDate.get(Calendar.YEAR); } else {
	 * 
	 * mdate = "N/A"; // } return String.format("%20s",
	 * person.toString()).concat(String.format("%-11s%-20s%-20s%-20s%-20s", " ",
	 * acctNum, acctType, mdate, acctStatus) + String.format("$%9.2f",
	 * getAcctBalance()) + "\n"); }
	 */

	public Account(Depositor person, int acctNum, String acctType, double balance, String acctStatus,
	int numTransactions, String transactionHistory) throws IOException {
		// TODO Auto-generated constructor stub
		super(person, acctNum, acctType, balance, acctStatus, numTransactions, transactionHistory);
	}

	

	public boolean equals(Account other) throws IOException {
		boolean transactionHistoryEqual = true;
		for (int i = 0; i < getNumTransactions(); i++) {
			if ((!(TransactionReceiptAt(i).equals(other.TransactionReceiptAt(i))))) {
				transactionHistoryEqual = false;
				break;
			}
		}
		if (getDepositor().equals(other.getDepositor()) && getAcctNum() == other.getAcctNum()
				&& acctType.equals(other.getAcctType()) && getAcctStatus().equals(other.getAcctStatus())
				&& getAcctBalance() == other.getAcctBalance()
				&& transactionHistoryEqual)
		/*
		 * && maturityDate.get(Calendar.YEAR) ==
		 * other.getMaturityDate().get(Calendar.YEAR) &&
		 * maturityDate.get(Calendar.DAY_OF_MONTH) ==
		 * other.getMaturityDate().get(Calendar.DAY_OF_MONTH) &&
		 * maturityDate.get(Calendar.MONTH) ==
		 * other.getMaturityDate().get(Calendar.MONTH)
		 */ {
			return true;
		}
		return false;
	}

	/*
	 * Method getDepositor() Input: none Process: returns the Depositor of the
	 * Account Output: returns the Depositor of the Account
	 */
	public Depositor getDepositor() {
		// returns Depositor of Account
		return new Depositor(person);
	}

	/*
	 * Method getAcctNum() Input: none Process: returns the account number of the
	 * Account Output: returns the account number of the Account
	 */
	public int getAcctNum() {
		// returns the account number
		return acctNum;
	}

	/*
	 * Method getAcctType() Input: none Process: returns the account type of the
	 * Account Output: returns the account type of the Account
	 */

	public String getAcctType() {
		// returns the account type
		return acctType;
	}

	/*
	 * Method getAcctBalance() Input: none Process: returns the balance of the
	 * Account Output: returns the balance of the Account
	 */
	public double getAcctBalance() {
		// returns the balance
		return balance;
	}

	/*
	 * Method getMaturityDate() Input: none Process: returns the maturity date of
	 * the Account Output: returns the maturity date of the Account
	 */
	/*
	 * public Calendar getMaturityDate() { // returns the maturity date of the
	 * Account return maturityDate; }
	 */

	/*
	 * Method getAcctStatus() Input: none Process: returns the status of the Account
	 * Output: returns the status of the Account
	 */
	public String getAcctStatus() {
		// returns the status of the Account
		return acctStatus;
	}
	
	public int getNumTransactions() {
		return numTransactions;
	}

	/*
	 * Method getTransactionHistory() Input: none Process: returns the transaction
	 * history of the Account Output: returns the transaction history of the Account
	 */
	public String getTransactionHistory() {
		// returns the transaction history of the Account
		return transactionHistory;
	}

	public Calendar getMaturityDate() {
		return null;
	}
	
	public TransactionReceipt TransactionReceiptAt(int index) throws IOException {
		RandomAccessFile history = new RandomAccessFile(transactionHistory, "rw");
		history.seek((index) * (206 * 2));
		char[] tHistory = new char[206];
		String transactionHistoryString;
		int i = 0;
		while (i < 206) {
			tHistory[i] = history.readChar();
			i++;
		}
		transactionHistoryString = new String(tHistory);
		int acctNum = Integer.parseInt(transactionHistoryString.substring(0, 6));
		String typeOfTransaction = transactionHistoryString.substring(6, 36).trim();
		double amountOfTransaction = Double.parseDouble(transactionHistoryString.substring(36, 46).trim());
		String[] dateFields1 = transactionHistoryString.substring(46, 56).trim().split("/");
		Calendar tDate = Calendar.getInstance();
		tDate.set(Integer.parseInt(dateFields1[2]), (Integer.parseInt(dateFields1[0]) - 1), Integer.parseInt(dateFields1[1]));
		Calendar termOfCD = Calendar.getInstance();
		if (transactionHistoryString.substring(56, 66).trim().equals("")) {
			termOfCD = null;
		}
		else {
			String[] dateFields2 = transactionHistoryString.substring(56, 66).trim().split("/");
			termOfCD.set(Integer.parseInt(dateFields2[2]), (Integer.parseInt(dateFields2[0]) - 1), Integer.parseInt(dateFields2[1]));
		}
		Calendar checkDate = Calendar.getInstance();
		if (transactionHistoryString.substring(66, 76).trim().equals("")) {
			checkDate = null;
		}
		else {
			String[] dateFields3 = transactionHistoryString.substring(66, 76).trim().split("/");
			checkDate.set(Integer.parseInt(dateFields3[2]), (Integer.parseInt(dateFields3[0]) - 1), Integer.parseInt(dateFields3[1]));
		}
		Check check = new Check(acctNum, amountOfTransaction, checkDate);
		Calendar oldMaturityDate = Calendar.getInstance();
		if (transactionHistoryString.substring(76, 86).trim().equals("")) {
			oldMaturityDate = null;
		}
		else {
			String[] dateFields3 = transactionHistoryString.substring(76, 86).trim().split("/");
			oldMaturityDate.set(Integer.parseInt(dateFields3[2]), (Integer.parseInt(dateFields3[0]) - 1), Integer.parseInt(dateFields3[1]));
		}
		TransactionTicket ticket = new TransactionTicket(acctNum, typeOfTransaction, tDate, amountOfTransaction,
		termOfCD, oldMaturityDate, check);
		boolean successIndicatorFlag = Boolean.parseBoolean(transactionHistoryString.substring(86, 91).trim());
		String reasonForFailure = transactionHistoryString.substring(91, 176).trim();
		Calendar postTransactionMaturityDate = Calendar.getInstance();
		if (transactionHistoryString.substring(176, 186).trim().equals("")) {
			postTransactionMaturityDate = null;
		}
		else {
			String[] dateFields4 = transactionHistoryString.substring(176, 186).trim().split("/");
			postTransactionMaturityDate.set(Integer.parseInt(dateFields4[2]), (Integer.parseInt(dateFields4[0]) - 1),
			Integer.parseInt(dateFields4[1]));
		}
		double amount1 = Double.parseDouble(transactionHistoryString.substring(186, 196));
		double amount2 = Double.parseDouble(transactionHistoryString.substring(196, 206));
		TransactionReceipt receipt = new TransactionReceipt(new TransactionTicket(ticket), successIndicatorFlag, reasonForFailure,
		amount1, amount2, postTransactionMaturityDate);
		return new TransactionReceipt(receipt);
	}
	
	/*
	 * Method getTransactionHistory() Input: receipt - TransactionReceipt detailing
	 * a transaction previously performed on the account Process: adds receipt to
	 * the transaction history Output: adds receipt to the transaction history
	 */
	public void addTransaction(TransactionReceipt receipt) throws IOException {
		// adds receipt to the transaction history
		RandomAccessFile history = new RandomAccessFile(transactionHistory, "rw");
		history.setLength((numTransactions + 1) * (206 * 2));
		history.seek(history.length() - (206 * 2));
		history.writeChars(receipt.getTransactionReceiptString());
		numTransactions++;
	}

	public TransactionReceipt getBalance(TransactionTicket ticket) throws IOException {
		return new TransactionReceipt(new TransactionTicket(ticket));
	}

	public TransactionReceipt makeDeposit(TransactionTicket ticket) throws AccountClosedException, InvalidAmountException,
	CDMaturityDateException, IOException {
		return new TransactionReceipt(new TransactionTicket(ticket));
	}

	public TransactionReceipt makeWithdrawal(TransactionTicket ticket) throws AccountClosedException, InvalidAmountException,
	InsufficientFundsException, CDMaturityDateException, IOException {
		return new TransactionReceipt(new TransactionTicket(ticket));
	}

	public TransactionReceipt clearCheck(Check check, TransactionTicket ticket) throws InvalidAccountException, AccountClosedException,
	InvalidAmountException, InsufficientFundsException, CheckTooOldException, PostDatedCheckException, IOException {
		return new TransactionReceipt(new TransactionTicket(ticket));
	}

	public TransactionReceipt reopenAcct(TransactionTicket ticket) throws InvalidAccountException, IOException {
		return new TransactionReceipt(new TransactionTicket(ticket));
	}

	public TransactionReceipt closeAcct(TransactionTicket ticket) throws InvalidAccountException, IOException {
		return new TransactionReceipt(new TransactionTicket(ticket));
	}

	/*
	 * Method setDepositor() Input: person - Depositor object that will replace the
	 * current Depositor of the account Process: sets the Depositor of the account
	 * to the Depositor passed in to the method Output: sets the Depositor of the
	 * account to the Depositor passed in to the method
	 */
	protected void setDepositor(Depositor person) {
		// sets the Depositor w/ the passed in parameter
		this.person = person;
	}

	/*
	 * Method setAcctNum() Input: newNum - account number that will replace the
	 * current account number Process: sets the account number of the account to the
	 * int passed in to the method Output: sets the account number of the account to
	 * the int passed in to the method
	 */
	protected void setAcctNum(int newNum) {
		// sets the account number w/ the passed in parameter
		acctNum = newNum;
	}

	/*
	 * Method setAcctType() Input: newType - account number that will replace the
	 * current account type Process: sets the account type to the String passed in
	 * to the method Output: sets the account type to the String passed in to the
	 * method
	 */
	protected void setAcctType(String newType) {
		// sets the account type w/ the passed in parameter
		acctType = newType;
	}

	/*
	 * Method setBalance() Input: newBalance - balance that will replace the current
	 * account balance Process: sets the balance of the account to the double passed
	 * in to the method Output: sets the balance number of the account to the double
	 * passed in to the method
	 */
	protected void setBalance(double newBalance) {
		// sets the balance w/ the passed in parameter
		balance = newBalance;
	}

	/*
	 * Method setBalance() Input: newMaturityDate - maturity date that will replace
	 * the current maturity date Process: sets the maturity date of the account to
	 * the Calendar object passed in to the method Output: sets the maturity date of
	 * the account to the double Calendar object in to the method
	 */
	/*
	 * private void setMaturityDate(Calendar newMaturityDate) { // sets the maturity
	 * date w/ the passed in parameter maturityDate = newMaturityDate; }
	 */

	protected void setAcctStatus(String str) {
		acctStatus = str;
	}
}