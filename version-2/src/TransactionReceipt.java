import java.util.Calendar;

public class TransactionReceipt extends genTransactionReceipt {
	//instance field definitions
	/*
	 * private TransactionTicket ticket; private boolean successIndicatorFlag;
	 * private String reasonForFailure; private double preTransactionBalance;
	 * private double postTransactionBalance; private Calendar
	 * postTransactionMaturityDate;
	 */
	
	/*Constructor TransactionReceipt() (No-Arg)
	 * Input:
	 * none
	 * Process:
	 * Initializes the TransactionTicket using the no-arg TransactionTicket constructor
	 * Sets successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 * Output:
	 * Initializes the TransactionTicket using the no-arg TransactionTicket constructor
	 * Sets successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 */
	public TransactionReceipt() {
		super();
	}
	
	public TransactionReceipt(TransactionReceipt receipt) {
		super(receipt);
	}
	
	/*Constructor TransactionReceipt()
	 * Input:
	 * ticket - filled out TransactionTicket
	 * preTransactionBalance - old account balance
	 * postTransactionBalance - new account balance
	 * postTransactionMaturityDate - new CD maturity date
	 * Process:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to postTransactionMaturityDate
	 * Output:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to postTransactionMaturityDate
	 */
	public TransactionReceipt(TransactionTicket ticket, double preTransactionBalance,
	double postTransactionBalance, Calendar postTransactionMaturityDate) {
		super(ticket, preTransactionBalance, postTransactionBalance, postTransactionMaturityDate);
	}
	
	public TransactionReceipt(TransactionTicket ticket, boolean successIndicatorFlag, String reasonForFailure,
	double preTransactionBalance, double postTransactionBalance) {
		super(ticket, successIndicatorFlag, reasonForFailure, preTransactionBalance, postTransactionBalance);
	}
	
	/*Constructor TransactionReceipt()
	 * Input:
	 * ticket - filled out TransactionTicket
	 * preTransactionBalance - old account balance
	 * postTransactionBalance - new account balance
	 * Process:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 * Output:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 */
	public TransactionReceipt(TransactionTicket ticket, double preTransactionBalance,
	double postTransactionBalance) {
		super(ticket, preTransactionBalance, postTransactionBalance);
	}
	
	/*Constructor TransactionReceipt()
	 * Input:
	 * ticket - filled out TransactionTicket
	 * postTransactionMaturityDate - new CD maturity date
	 * Process:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to postTransactionMaturityDate
	 * Output:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to postTransactionMaturityDate
	 */
	public TransactionReceipt(TransactionTicket ticket, Calendar postTransactionMaturityDate) {
		super(ticket, postTransactionMaturityDate);
	}
	
	/*Constructor TransactionReceipt()
	 * Input:
	 * ticket - filled out TransactionTicket
	 * preTransactionBalance - old account balance
	 * postTransactionBalance - new account balance
	 * postTransactionMaturityDate - new CD maturity date
	 * Process:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to postTransactionMaturityDate
	 * Output:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to postTransactionMaturityDate
	 */
	public TransactionReceipt(TransactionTicket ticket, String reasonForFailure, double preTransactionBalance,
	double postTransactionBalance, Calendar postTransactionMaturityDate) {
		super(ticket, reasonForFailure, preTransactionBalance, postTransactionBalance, postTransactionMaturityDate);
	}
	
	public TransactionReceipt(TransactionTicket ticket, boolean successIndicatorFlag, String reasonForFailure,
	double preTransactionBalance, double postTransactionBalance, Calendar postTransactionMaturityDate) {
		super(ticket, successIndicatorFlag, reasonForFailure, preTransactionBalance, postTransactionBalance,
		postTransactionMaturityDate);
	}
	
	/*Constructor TransactionReceipt()
	 * Input:
	 * ticket - filled out TransactionTicket
	 * reasonForFailure - String explaining why the transaction failed
	 * preTransactionBalance - old account balance
	 * postTransactionBalance - new account balance
	 * Process:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 * Output:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to preTransactionBalance
	 * Sets the postTransactionBalance to postTransactionBalance
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 */
	public TransactionReceipt(TransactionTicket ticket, String reasonForFailure, double preTransactionBalance,
	double postTransactionBalance) {
		super(ticket, reasonForFailure, preTransactionBalance, postTransactionBalance);
	}
	
	/*Constructor TransactionReceipt()
	 * Input:
	 * ticket - filled out TransactionTicket
	 * reasonForFailure - String explaining why the transaction failed
	 * Process:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 * Output:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to false
	 * Sets the reasonfForFailure to reasonForFailure
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 */
	public TransactionReceipt(TransactionTicket ticket, String reasonForFailure) {
		super(ticket, reasonForFailure);
	}
	
	/*Constructor TransactionReceipt()
	 * Input:
	 * ticket - filled out TransactionTicket
	 * Process:
	 * Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 * Output:
	* Sets the TransactionTicket to ticket
	 * Sets the successIndicatorFlag to true
	 * Sets the reasonfForFailure to null Strings
	 * Sets the preTransactionBalance to $0.00
	 * Sets the postTransactionBalance to $0.00
	 * Sets the postTransactionMaturityDate (how may months until it matures after the transaction) to null
	 */
	public TransactionReceipt(TransactionTicket ticket) {
		super(ticket);
	}
	
	
	/*Method getTransactionTicket()
	 * Input:
	 * none
	 * Process:
	 * returns ticket
	 * Output:
	 * returns ticket
	 */
	public TransactionTicket getTransactionTicket() {
		//returns ticket
		return new TransactionTicket(ticket);
	}
	
	/*Method getSuccessIndicatorFlag()
	 * Input:
	 * none
	 * Process:
	 * returns successIndicatorFlag
	 * Output:
	 * returns successIndicatorFlag
	 */
	public boolean getSuccessIndicatorFlag() {
		//returns successIndicatorFlag
		return successIndicatorFlag;
	}
	
	/*Method getReasonForFailure()
	 * Input:
	 * none
	 * Process:
	 * returns reasonForFailure
	 * Output:
	 * returns reasonForFailure
	 */
	public String getReasonForFailure() {
		//returns reasonForFailure
		return reasonForFailure;
	}
	
	/*Method getPreTransactionBalance()
	 * Input:
	 * none
	 * Process:
	 * returns preTransactionBalance
	 * Output:
	 * returns preTransactionBalance
	 */
	public double getPreTransactionBalance() {
		//returns preTransactionBalance
		return preTransactionBalance;
	}
	
	/*Method getPostTransactionBalance()
	 * Input:
	 * none
	 * Process:
	 * returns postTransactionBalance
	 * Output:
	 * returns postTransactionBalance
	 */
	public double getPostTransactionBalance() {
		//returns postTransactionBalance
		return postTransactionBalance;
	}
	
	/*Method getPostTransactionMaturityDate()
	 * Input:
	 * none
	 * Process:
	 * returns postTransactionMaturityDate
	 * Output:
	 * returns postTransactionMaturityDate
	 */
	public Calendar getPostTransactionMaturityDate() {
		//returns postTransactionMaturityDate
		if (postTransactionMaturityDate == null) {
			return null;
		}
		else {
			Calendar newDate = Calendar.getInstance();
			newDate.set(postTransactionMaturityDate.get(Calendar.YEAR), postTransactionMaturityDate.get(Calendar.MONTH),
			postTransactionMaturityDate.get(Calendar.DAY_OF_MONTH));
			return newDate;
		}
	}
	
	/*Method setTransactionTicket()
	 * Input:
	 * ticket - new TransactionTicket
	 * Process:
	 * Sets ticket to the ticket passed in
	 * Output:
	 * Sets ticket to the ticket passed in
	 */
	protected void setTransactionTicket(TransactionTicket ticket) {
		//Sets ticket to the ticket passed in
		this.ticket = ticket;
	}
	
	/*Method setTransactionTicket()
	 * Input:
	 * new Flag - new successIndicatorFlag
	 * Process:
	 * Sets successIndicatorFlag to newFlag
	 * Output:
	 * Sets successIndicatorFlag to newFlag
	 */
	protected void setSuccessIndicatorFlag(boolean newFlag) {
		//Sets successIndicatorFlag to newFlag
		successIndicatorFlag = newFlag;
	}
	
	/*Method setReasonForFailure()
	 * Input:
	 * str - new reasonForFailure
	 * Process:
	 * Sets reasonForFailure to str
	 * Output:
	 * Sets reasonForFailure to str
	 */
	protected void setReasonForFailure(String str) {
		//Sets reasonForFailure to str
		reasonForFailure = str;
	}
	
	/*Method setPreTransactionBalance()
	 * Input:
	 * newBalance - new preTransactionBalance
	 * Process:
	 * Sets preTransactionBalance to newBalance
	 * Output:
	 * Sets preTransactionBalance to newBalance
	 */
	protected void setPreTransactionBalance(double newBalance) {
		//Sets preTransactionBalance to newBalance
		preTransactionBalance = newBalance;
	}
	
	/*Method setPostTransactionBalance()
	 * Input:
	 * newBalance - new postTransactionBalance
	 * Process:
	 * Sets postTransactionBalance to newBalance
	 * Output:
	 * Sets postTransactionBalance to newBalance
	 */
	protected void setPostTransactionBalance(double newBalance) {
		//Sets postTransactionBalance to newBalance
		postTransactionBalance = newBalance;
	}
	
	/*Method setReasonForFailure()
	 * Input:
	 * newDate - new CD maturity date
	 * Process:
	 * Sets postTransactionMaturityDate to newDate
	 * Output:
	 * Sets postTransactionMaturityDate to newDate
	 */
	protected void setPostTransactionMaturityDate(Calendar newDate) {
		//Sets postTransactionMaturityDate to newDate
		postTransactionMaturityDate = newDate;
	}
}
