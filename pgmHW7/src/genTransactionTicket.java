import java.util.Calendar;

public abstract class genTransactionTicket {
	// instance field definitions
	protected int acctNum;
	protected Calendar dateOfTransaction;
	protected String typeOfTransaction;
	protected double amountOfTransaction;
	protected Calendar termOfCD;
	protected Check check;
	protected Calendar oldMaturityDate;

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
	public genTransactionTicket() {
		acctNum = 0;
		typeOfTransaction = "";
		dateOfTransaction = Calendar.getInstance();
		amountOfTransaction = 0.00;
		termOfCD = null;
		check = null;
		oldMaturityDate = null;
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
	public genTransactionTicket(TransactionTicket ticket) {
		this.acctNum = ticket.getAcctNum();
		this.typeOfTransaction = ticket.getTypeOfTransaction();
		this.dateOfTransaction = ticket.getDateOfTransaction();
		this.amountOfTransaction = ticket.getAmountOfTransaction();
		this.termOfCD = ticket.getTermOfCD();
		this.check = ticket.getCheck();
		this.oldMaturityDate = ticket.getOldMaturityDate();
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
	public genTransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction) {
		this.acctNum = acctNum;
		this.typeOfTransaction = typeOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		amountOfTransaction = 0.00;
		termOfCD = null;
		this.check = new Check();
		oldMaturityDate = null;
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
	public genTransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
			double amountOfTransaction) {
		this.acctNum = acctNum;
		this.typeOfTransaction = typeOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		this.amountOfTransaction = amountOfTransaction;
		termOfCD = null;
		this.check = new Check();
		oldMaturityDate = null;
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
	public genTransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
			double amountOfTransaction, Calendar termOfCD) {
		this.acctNum = acctNum;
		this.typeOfTransaction = typeOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		this.amountOfTransaction = amountOfTransaction;
		this.termOfCD = termOfCD;
		this.check = new Check();
		oldMaturityDate = null;
	}

	public genTransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
			double amountOfTransaction, Calendar termOfCD, Calendar oldMaturityDate) {
		this.acctNum = acctNum;
		this.typeOfTransaction = typeOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		this.amountOfTransaction = amountOfTransaction;
		this.termOfCD = termOfCD;
		this.check = new Check();
		this.oldMaturityDate = oldMaturityDate;
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
	public genTransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction,
			double amountOfTransaction, Calendar termOfCD, Check check) {
		this.acctNum = acctNum;
		this.typeOfTransaction = typeOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		this.amountOfTransaction = amountOfTransaction;
		this.termOfCD = termOfCD;
		this.check = check;
		oldMaturityDate = null;
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
	public genTransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction, Calendar termOfCD) {
		this.acctNum = acctNum;
		this.typeOfTransaction = typeOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		amountOfTransaction = 0.00;
		this.termOfCD = termOfCD;
		this.check = new Check();
		oldMaturityDate = null;
	}

	public genTransactionTicket(int acctNum, String typeOfTransaction, Calendar dateOfTransaction, Calendar termOfCD,
			Calendar oldMaturityDate) {
		this.acctNum = acctNum;
		this.typeOfTransaction = typeOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		amountOfTransaction = 0.00;
		this.termOfCD = termOfCD;
		this.check = new Check();
		this.oldMaturityDate = oldMaturityDate;
	}

	public String toString() {
		// String ticket;
		String tDate = (dateOfTransaction.get(Calendar.MONTH) + 1) + "/" + dateOfTransaction.get(Calendar.DAY_OF_MONTH)
				+ "/" + dateOfTransaction.get(Calendar.YEAR);

		String checkDate = "N/A";
		if (check.getAcctNum() != 0) {
			checkDate = check.toString();
		}
		/*
		 * ticket = String.format("\n%-30s%-30s", getTypeOfTransaction(), tDate) +
		 * String.format("$%9.2f", getAmountOfTransaction()) + String.format("%20s",
		 * " ") + String.format("%30s", checkDate);
		 */
		/*
		 * return String.format("\n%-30s%-30s%-30s", acctNum, typeOfTransaction, tDate)
		 * + String.format("$%9.2f", amountOfTransaction) + String.format("%30s",
		 * checkDate mdate) + String.format("%20s", " ");
		 */
		return "Account Number: " + acctNum + "\nTransaction Requested: " + typeOfTransaction
		+ "\nDate of Transaction: " + tDate + String.format("\nAmount of Transaction: $%.2f", amountOfTransaction)
		+ "\nDate of Check: " + checkDate;
	}

	public abstract int getAcctNum();

	public abstract Calendar getDateOfTransaction();

	public abstract double getAmountOfTransaction();

	public abstract Calendar getOldMaturityDate();

	public abstract Calendar getTermOfCD();

	public abstract Check getCheck();

	public abstract String getTypeOfTransaction();

	protected abstract void setAcctNum(int newNum);

	protected abstract void setDateOfTransaction(Calendar newDate);

	protected abstract void setAmountOfTransaction(double newAmount);

	protected abstract void setTermOfCD(Calendar newTerm);
}
