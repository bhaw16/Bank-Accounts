import java.util.Calendar;

public class TransactionTicket extends genTransactionTicket {
	// instance field definitions
	/*
	 * private int acctNum; private Calendar dateOfTransaction; private String
	 * typeOfTransaction; private double amountOfTransaction; private Calendar
	 * termOfCD; private Check check; private Calendar oldMaturityDate;
	 */

	/*
	 * Constructor TransactionTicket() (No-Arg) Input: none Process: Sets the
	 * account number that the transaction is being performed (acctNum) on to 0 Sets
	 * the transaction type to null Strings Sets the transaction date to today's
	 * date Sets the term of the CD (how may months until it matures; the maturity
	 * date) to null Sets the date of the Check to null Output: Sets the account
	 * number that the transaction is being performed (acctNum) on to 0 Sets the
	 * transaction type to null Strings Sets the transaction date to today's date
	 * Sets the term of the CD (how may months until it matures; the maturity date)
	 * to null Sets the date of the Check to null
	 */
	public TransactionTicket() {
		super();
	}

	/*
	 * Copy Constructor TransactionTicket() Input: ticket - TransactionTicket object
	 * Process: Sets the account number that the transaction is being performed
	 * (acctNum) on to that of ticket Sets the transaction type to that of tickets
	 * Sets the transaction date to that of ticket Sets the term of the CD (how may
	 * months until it matures; the maturity date) to that of ticket Sets the date
	 * of the Check to that of ticket Output: Sets the account number that the
	 * transaction is being performed (acctNum) on to that of ticket Sets the
	 * transaction type to that of ticket Sets the transaction date to that of
	 * ticket Sets the term of the CD (how may months until it matures; the maturity
	 * date) to that of ticket Sets the date of the Check to that of ticket
	 */
	public TransactionTicket(TransactionTicket ticket) {
		super(ticket);
	}

	/*
	 * Constructor TransactionTicket() Input: acctNum - account number that the
	 * transaction is being performed on typeOfTransaction - the type of transaction
	 * to be performed dateOfTransaction - the day the transaction is being
	 * performed Process: Sets the account number that the transaction is being
	 * performed (acctNum) on to 0 Sets the transaction type to null Strings Sets
	 * the transaction date to today's date Sets the term of the CD (how may months
	 * until it matures; the maturity date) to null Sets the date of the Check to
	 * null Output: Sets the account number that the transaction is being performed
	 * (acctNum) on to 0 Sets the transaction type to null Strings Sets the
	 * transaction date to today's date Sets the term of the CD (how may months
	 * until it matures; the maturity date) to null Sets the date of the Check to
	 * null
	 */
	public TransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction) {
		super(acctNum, typeOfTransaction, dateOfTransaction);
	}

	/*
	 * Constructor TransactionTicket() Input: acctNum - account number that the
	 * transaction is being performed on typeOfTransaction - the type of transaction
	 * to be performed dateOfTransaction - the day the transaction is being
	 * performed amountOfTransaction - how much money is involved w/ the transaction
	 * Process: Sets the account number that the transaction is being performed
	 * (acctNum) on to acctNum Sets the transaction type to typeOfTransaction Sets
	 * the transaction date to dateOfTransaction Sets the term of the CD (how may
	 * months until it matures; the maturity date) to null Sets the date of the
	 * Check to null Output: Sets the account number that the transaction is being
	 * performed (acctNum) on to 0 Sets the transaction type to null Strings Sets
	 * the transaction date to today's date Sets the term of the CD (how may months
	 * until it matures; the maturity date) to null Sets the date of the Check to
	 * null
	 */
	public TransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
	double amountOfTransaction) {
		super(acctNum, typeOfTransaction, dateOfTransaction, amountOfTransaction);
	}

	/*
	 * Constructor TransactionTicket() Input: acctNum - account number that the
	 * transaction is being performed on typeOfTransaction - the type of transaction
	 * to be performed dateOfTransaction - the day the transaction is being
	 * performed amountOfTransaction - how much money is involved w/ the transaction
	 * termOfCD - the maturity date of the CD that the transaction is being
	 * performed on Process: Sets the account number that the transaction is being
	 * performed (acctNum) on to acctNum Sets the transaction type to
	 * typeOfTransaction Sets the transaction date to dateOfTransaction Sets the
	 * transaction amount to amountOfTransaction Sets the term of the CD (how may
	 * months until it matures; the maturity date) to termOfCD Sets the date of the
	 * Check to null Output: Sets the account number that the transaction is being
	 * performed (acctNum) on to 0 Sets the transaction type to null Strings Sets
	 * the transaction date to today's date Sets the transaction amount to the
	 * passed in double Sets the term of the CD (how may months until it matures;
	 * the maturity date) to termOfCD Sets the date of the Check to null
	 */
	public TransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
	double amountOfTransaction, Calendar termOfCD) {
		super(acctNum, typeOfTransaction, dateOfTransaction, amountOfTransaction, termOfCD);
	}

	public TransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
	double amountOfTransaction, Calendar termOfCD, Calendar oldMaturityDate) {
		super(acctNum, typeOfTransaction, dateOfTransaction, amountOfTransaction, termOfCD, oldMaturityDate);
	}

	/*
	 * Constructor TransactionTicket() Input: acctNum - account number that the
	 * transaction is being performed on typeOfTransaction - the type of transaction
	 * to be performed dateOfTransaction - the day the transaction is being
	 * performed amountOfTransaction - how much money is involved w/ the transaction
	 * termOfCD - the maturity date of the CD that the transaction is being
	 * performed on dateOfCheck - the date on the check being cleared Process: Sets
	 * the account number that the transaction is being performed (acctNum) on to
	 * acctNum Sets the transaction type to typeOfTransaction Sets the transaction
	 * date to dateOfTransaction Sets the transaction amount to amountOfTransaction
	 * Sets the term of the CD (how may months until it matures; the maturity date)
	 * to termOfCD Sets the date of the Check to dateOfCheck Output: Sets the
	 * account number that the transaction is being performed (acctNum) on to 0 Sets
	 * the transaction type to null Strings Sets the transaction date to today's
	 * date Sets the transaction amount to the passed in double Sets the term of the
	 * CD (how may months until it matures; the maturity date) to termOfCD Sets the
	 * date of the Check to dateOfCheck
	 */
	public TransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
	double amountOfTransaction, Calendar termOfCD, Check check) {
		super(acctNum, typeOfTransaction, dateOfTransaction, amountOfTransaction, termOfCD, check);
	}

	/*
	 * Constructor TransactionTicket() Input: acctNum - account number that the
	 * transaction is being performed on typeOfTransaction - the type of transaction
	 * to be performed dateOfTransaction - the day the transaction is being
	 * performed termOfCD - the maturity date of the CD that the transaction is
	 * being performed on Process: Sets the account number that the transaction is
	 * being performed (acctNum) on to acctNum Sets the transaction type to
	 * typeOfTransaction Sets the transaction date to dateOfTransaction Sets the
	 * transaction amount to $0.00 Sets the term of the CD (how may months until it
	 * matures; the maturity date) to termOfCD Sets the date of the Check to null
	 * Output: Sets the account number that the transaction is being performed
	 * (acctNum) on to 0 Sets the transaction type to null Strings Sets the
	 * transaction date to today's date Sets the term of the CD (how may months
	 * until it matures; the maturity date) to termOfCD Sets the date of the Check
	 * to null
	 */
	public TransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction, Calendar termOfCD) {
		super(acctNum, typeOfTransaction, dateOfTransaction, termOfCD);
	}

	public TransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction, Calendar termOfCD,
	Calendar oldMaturityDate) {
		super(acctNum, typeOfTransaction, dateOfTransaction, termOfCD, oldMaturityDate);
	}

	/*
	 * public String toString() { //String ticket; String tDate =
	 * (dateOfTransaction.get(Calendar.MONTH) + 1) + "/" +
	 * dateOfTransaction.get(Calendar.DAY_OF_MONTH) + "/" +
	 * dateOfTransaction.get(Calendar.YEAR); //String mdate; String checkDate =
	 * "N/A";
	 * 
	 * if (getTermOfCD() != null) { //checkDate = getCheck().toString(); if
	 * ((!(getTypeOfTransaction().equals("New Account"))) &&
	 * (!(getTypeOfTransaction().equals("Deposit"))) &&
	 * (!(getTypeOfTransaction().equals("Withdrawal")))) { mdate =
	 * (getTermOfCD().get(Calendar.MONTH) + 1) + "/" +
	 * getTermOfCD().get(Calendar.DAY_OF_MONTH) + "/" +
	 * getTermOfCD().get(Calendar.YEAR); } else { if
	 * (((getTypeOfTransaction().equals("Deposit"))) ||
	 * ((getTypeOfTransaction().equals("Withdrawal")))) { mdate =
	 * (oldMaturityDate.get(Calendar.MONTH) + 1) + "/" +
	 * oldMaturityDate.get(Calendar.DAY_OF_MONTH) + "/" +
	 * oldMaturityDate.get(Calendar.YEAR); } else { if
	 * (getTypeOfTransaction().equals("Clear Check")) { checkDate =
	 * getCheck().toString(); } mdate = "N/A"; } } } else { mdate = "N/A";
	 * 
	 * }
	 * 
	 * if (getCheck().getAcctNum() != 0) { checkDate = getCheck().toString(); }
	 * 
	 * ticket = String.format("\n%-30s%-30s", getTypeOfTransaction(), tDate) +
	 * String.format("$%9.2f", getAmountOfTransaction()) + String.format("%20s",
	 * " ") + String.format("%30s", checkDate);
	 * 
	 * return String.format("\n%-30s%-30s%-30s", getAcctNum(),
	 * getTypeOfTransaction(), tDate) + String.format("$%9.2f",
	 * getAmountOfTransaction()) + String.format("%30s", checkDate mdate) +
	 * String.format("%20s", " "); }
	 */

	/*
	 * Method getAcctNum() Input: none Process: returns the account number that the
	 * transaction is being performed on Output: returns the account number that the
	 * transaction is being performed on
	 */
	public int getAcctNum() {
		// returns the account number that the transaction is being performed on
		return acctNum;
	}

	/*
	 * Method getDateOfTransaction() Input: none Process: returns the day that the
	 * transaction is being performed on Output: returns the day that the
	 * transaction is being performed on
	 */
	public Calendar getDateOfTransaction() {
		// returns the day that the transaction is being performed on
		if (dateOfTransaction == null) {
			return null;
		} else {
			Calendar newDate = Calendar.getInstance();
			newDate.set(dateOfTransaction.get(Calendar.YEAR), dateOfTransaction.get(Calendar.MONTH),
					dateOfTransaction.get(Calendar.DAY_OF_MONTH));
			return newDate;
		}
	}

	/*
	 * Method getAmountOfTransaction() Input: none Process: returns the day that the
	 * transaction is being performed on Output: returns the day that the
	 * transaction is being performed on
	 */
	public double getAmountOfTransaction() {
		// returns the day that the transaction is being performed on
		return amountOfTransaction;
	}

	public Calendar getOldMaturityDate() {
		if (oldMaturityDate == null) {
			return null;
		} else {
			Calendar newDate = Calendar.getInstance();
			newDate.set(oldMaturityDate.get(Calendar.YEAR), oldMaturityDate.get(Calendar.MONTH),
					oldMaturityDate.get(Calendar.DAY_OF_MONTH));
			return newDate;
		}
	}

	/*
	 * Method getTermOfCD() Input: none Process: returns the term of CD for the CD
	 * that the transaction is being performed on Output: returns the term of CD for
	 * the CD that the transaction is being performed on
	 */
	public Calendar getTermOfCD() {
		// returns the maturity date of the CD that the transaction is being performed
		// on
		if (termOfCD == null) {
			return null;
		} else {
			Calendar newDate = Calendar.getInstance();
			newDate.set(termOfCD.get(Calendar.YEAR), termOfCD.get(Calendar.MONTH), termOfCD.get(Calendar.DAY_OF_MONTH));
			return newDate;
		}
	}

	public Check getCheck() {
		return new Check(check);
	}

	/*
	 * Method getTypeOfTransaction() Input: none Process: returns the the type of
	 * transaction is being performed Output: returns the the type of transaction is
	 * being performed
	 */
	public String getTypeOfTransaction() {
		// returns the the type of transaction is being performed
		return typeOfTransaction;
	}

	/*
	 * Method setAcctNum() Input: newNum - the account number that the current
	 * account number will be set to Process: Assigns newNum to acctNum Output:
	 * Assigns newNum to acctNum
	 */
	protected void setAcctNum(int newNum) {
		// Assigns newNum to acctNum
		acctNum = newNum;
	}

	/*
	 * Method setDateOfTransaction() Input: newDate - the date that the current
	 * transaction date will be set to Process: Assigns newDate to dateOfTransaction
	 * Output: Assigns newDate to dateOfTransaction
	 */
	protected void setDateOfTransaction(Calendar newDate) {
		// Assigns newDate to dateOfTransaction
		dateOfTransaction = newDate;
	}

	/*
	 * Method setAmountOfTransaction() Input: newAmount - the amount that the
	 * current transaction amount will be set to Process: Assigns newAmount to
	 * amountOfTransaction Output: Assigns newAmount to amountOfTransaction
	 */
	protected void setAmountOfTransaction(double newAmount) {
		// Assigns newAmount to amountOfTransaction
		amountOfTransaction = newAmount;
	}

	/*
	 * Method setTermOfCD() Input: newAmount - the CD maturity date that the current
	 * CD maturity date will be set to Process: Assigns newTerm to termOfCD Output:
	 * Assigns newTerm to termOfCD
	 */
	protected void setTermOfCD(Calendar newTerm) {
		// Assigns newTerm to termOfCD
		termOfCD = newTerm;
	}
}
