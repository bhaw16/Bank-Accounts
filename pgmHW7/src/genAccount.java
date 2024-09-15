import java.util.ArrayList;

public abstract class genAccount {
	// definition of instance fields
		protected Depositor person;
		protected int acctNum;
		protected String acctType;
		protected double balance;
		protected String acctStatus;
		protected ArrayList<TransactionReceipt> transactionHistory;

		public genAccount(Account acct) {
			this.person = acct.getDepositor();
			this.acctNum = acct.getAcctNum();
			this.acctType = acct.getAcctType();
			this.balance = acct.getAcctBalance();
			// this.maturityDate = acct.getMaturityDate();
			this.acctStatus = acct.getAcctStatus();
			this.transactionHistory = acct.getTransactionHistory();
		}

		public genAccount() {
			person = new Depositor();
			acctNum = 0;
			acctType = "";
			balance = 0.00;
			// maturityDate = null;
			acctStatus = "Open";
			transactionHistory = new ArrayList<TransactionReceipt>();
		}
		
		public genAccount(String str) {
			person = new Depositor();
			acctNum = 0;
			acctType = str;
			balance = 0.00;
			// maturityDate = null;
			acctStatus = "Open";
			transactionHistory = new ArrayList<TransactionReceipt>();
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
		public genAccount(Depositor person, int acctNum, String acctType, double balance) {
			// sets the parameters of the BankAccount w/ the parameters passed in
			this.person = person;
			this.acctNum = acctNum;
			this.acctType = acctType;
			this.balance = balance;
			// maturityDate = null;
			acctStatus = "Open";
			transactionHistory = new ArrayList<TransactionReceipt>();
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
		public genAccount(Depositor person, int acctNum, String acctType, double balance,
				/* Calendar maturityDate */ String str, ArrayList<TransactionReceipt> transactionHistory) {
			// sets the parameters of the Account w/ the parameters passed in
			this.person = person;
			this.acctNum = acctNum;
			this.acctType = acctType;
			this.balance = balance;
			// this.maturityDate = maturityDate;
			acctStatus = str;
			this.transactionHistory = transactionHistory;
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
		public genAccount(Depositor person, int acctNum, String acctType, double balance,
				/* Calendar maturityDate */ ArrayList<TransactionReceipt> transactionHistory) {
			// sets the parameters of the BankAccount w/ the parameters passed in
			this.person = person;
			this.acctNum = acctNum;
			this.acctType = acctType;
			this.balance = balance;
			// this.maturityDate = maturityDate;
			acctStatus = "Closed";
			this.transactionHistory = transactionHistory;
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
		public genAccount(int acctNum) {
			// sets acctNum w/ passed in int and sets object parameters to null and balance
			// to 0.00
			person = new Depositor();
			this.acctNum = acctNum;
			acctType = "";
			balance = 0.00;
			// maturityDate = null;
			acctStatus = "Open";
			transactionHistory = new ArrayList<TransactionReceipt>();
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
		public genAccount(int acctNum, String str) {
			// sets acctNum w/ passed in int and sets object parameters to null and balance
			// to 0.00
			person = new Depositor();
			this.acctNum = acctNum;
			acctType = str;
			balance = 0.00;
			// maturityDate = null;
			acctStatus = "Open";
			transactionHistory = new ArrayList<TransactionReceipt>();
		}

		public String toString() {
			String mdate;
			/*
			 * if (getAcctType().equals("CD")) { mdate = maturityDate.get((Calendar.MONTH))
			 * + 1 + "/" + maturityDate.get(Calendar.DAY_OF_MONTH) + "/" +
			 * maturityDate.get(Calendar.YEAR); } else {
			 */
			mdate = "N/A";
			// }
			return String.format("%20s", person.toString()).concat(String.format("%-11s%-20s%-20s%-20s%-20s", " ",
			acctNum, acctType, mdate, acctStatus) + String.format("$%9.2f", balance) + "\n");
		}
		
		public abstract boolean equals(Account other);
		public abstract Depositor getDepositor();
		public abstract int getAcctNum();
		public abstract String getAcctType();
		public abstract double getAcctBalance();
		public abstract String getAcctStatus();
		public abstract ArrayList<TransactionReceipt> getTransactionHistory();
		public abstract void addTransaction(TransactionReceipt receipt);
		public abstract TransactionReceipt getBalance(TransactionTicket ticket);
		public abstract TransactionReceipt makeDeposit(TransactionTicket ticket);
		public abstract TransactionReceipt makeWithdrawal(TransactionTicket ticket);
		public abstract TransactionReceipt clearCheck(Check check, TransactionTicket ticket);
		public abstract TransactionReceipt reopenAcct(TransactionTicket ticket);
		public abstract TransactionReceipt closeAcct(TransactionTicket ticket);
		protected abstract void setDepositor(Depositor person);
		protected abstract void setAcctNum(int newNum);
		protected abstract void setAcctType(String newType);
		protected abstract void setBalance(double newBalance);
		protected abstract void setAcctStatus(String str);
}
