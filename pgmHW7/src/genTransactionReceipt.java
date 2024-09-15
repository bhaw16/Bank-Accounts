import java.util.Calendar;

public abstract class genTransactionReceipt {
	//instance field definitions
		protected TransactionTicket ticket;
		protected boolean successIndicatorFlag;
		protected String reasonForFailure;
		protected double preTransactionBalance;
		protected double postTransactionBalance;
		protected Calendar postTransactionMaturityDate;
		
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
		public genTransactionReceipt() {
			ticket = new TransactionTicket();
			successIndicatorFlag = true;
			reasonForFailure = "";
			preTransactionBalance = 0.00;
			postTransactionBalance = 0.00;
			postTransactionMaturityDate = null;
		}
		
		public genTransactionReceipt(TransactionReceipt receipt) {
			this.ticket = receipt.getTransactionTicket();
			this.successIndicatorFlag = receipt.getSuccessIndicatorFlag();
			this.reasonForFailure = receipt.getReasonForFailure();
			this.preTransactionBalance = receipt.getPreTransactionBalance();
			this.postTransactionBalance = receipt.getPostTransactionBalance();
			this.postTransactionMaturityDate = receipt.getPostTransactionMaturityDate();
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
		public genTransactionReceipt(TransactionTicket ticket, double preTransactionBalance,
		double postTransactionBalance, Calendar postTransactionMaturityDate) {
			this.ticket = ticket;
			successIndicatorFlag = true;
			reasonForFailure = "";
			this.preTransactionBalance = preTransactionBalance;
			this.postTransactionBalance = postTransactionBalance;
			this.postTransactionMaturityDate = postTransactionMaturityDate;
		}
		
		public genTransactionReceipt(TransactionTicket ticket, boolean successIndicatorFlag, String reasonForFailure,
		double preTransactionBalance, double postTransactionBalance) {
			this.ticket = ticket;
			this.successIndicatorFlag = successIndicatorFlag;
			this.reasonForFailure = reasonForFailure;
			this.preTransactionBalance = preTransactionBalance;
			this.postTransactionBalance = postTransactionBalance;
			postTransactionMaturityDate = null;
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
		public genTransactionReceipt(TransactionTicket ticket, double preTransactionBalance,
		double postTransactionBalance) {
			this.ticket = ticket;
			successIndicatorFlag = true;
			reasonForFailure = "";
			this.preTransactionBalance = preTransactionBalance;
			this.postTransactionBalance = postTransactionBalance;
			postTransactionMaturityDate = null;
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
		public genTransactionReceipt(TransactionTicket ticket, Calendar postTransactionMaturityDate) {
			this.ticket = ticket;
			successIndicatorFlag = true;
			reasonForFailure = "";
			preTransactionBalance = 0.00;
			postTransactionBalance = 0.00;
			this.postTransactionMaturityDate = postTransactionMaturityDate;
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
		public genTransactionReceipt(TransactionTicket ticket, String reasonForFailure, double preTransactionBalance,
		double postTransactionBalance, Calendar postTransactionMaturityDate) {
			this.ticket = ticket;
			successIndicatorFlag = false;
			this.reasonForFailure = reasonForFailure;
			this.preTransactionBalance = preTransactionBalance;
			this.postTransactionBalance = postTransactionBalance;
			this.postTransactionMaturityDate = postTransactionMaturityDate;
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
		public genTransactionReceipt(TransactionTicket ticket, String reasonForFailure, double preTransactionBalance,
		double postTransactionBalance) {
			this.ticket = ticket;
			successIndicatorFlag = false;
			this.reasonForFailure = reasonForFailure;
			this.preTransactionBalance = preTransactionBalance;
			this.postTransactionBalance = postTransactionBalance;
			postTransactionMaturityDate = null;
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
		public genTransactionReceipt(TransactionTicket ticket, String reasonForFailure) {
			this.ticket = ticket;
			successIndicatorFlag = false;
			this.reasonForFailure = reasonForFailure;
			preTransactionBalance = 0.00;
			postTransactionBalance = 0.00;
			postTransactionMaturityDate = null;
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
		public genTransactionReceipt(TransactionTicket ticket) {
			this.ticket = ticket;
			successIndicatorFlag = true;
			reasonForFailure = "";
			preTransactionBalance = 0.00;
			postTransactionBalance = 0.00;
			postTransactionMaturityDate = null;
		}
		
		public String toString() {
			String mdate = "N/A";
			String newMDate = "N/A";
			String failure;
			String success;
			if (successIndicatorFlag) {
				success = "Yes";
			}
			else {
				success = "No";
				
			}
			if ((!(reasonForFailure.equals("")))) {
				failure = reasonForFailure;
			}
			else {
				failure = "N/A";
			}
			if (ticket.getTermOfCD() != null) {
				if (ticket.getOldMaturityDate() != null) {
					mdate = (ticket.getOldMaturityDate().get(Calendar.MONTH) + 1) + "/" +
					ticket.getOldMaturityDate().get(Calendar.DAY_OF_MONTH) + "/" +
					ticket.getOldMaturityDate().get(Calendar.YEAR);
				}
				else {
					mdate = (ticket.getTermOfCD().get(Calendar.MONTH) + 1) + "/" +
					ticket.getTermOfCD().get(Calendar.DAY_OF_MONTH) + "/" +
					ticket.getTermOfCD().get(Calendar.YEAR);
				}
				if (successIndicatorFlag && (ticket.getTypeOfTransaction().equals("Deposit")
					|| ticket.getTypeOfTransaction().equals("Withdrawal")
					|| ticket.getTypeOfTransaction().equals("New Account"))) {
					if (ticket.getTypeOfTransaction().equals("New Account")) {
						mdate = "N/A";
					}
					newMDate = (ticket.getTermOfCD().get(Calendar.MONTH) + 1) + "/" +
					ticket.getTermOfCD().get(Calendar.DAY_OF_MONTH) + "/" +
					ticket.getTermOfCD().get(Calendar.YEAR);
				}
			}
			return ticket.toString() + "\nOld Maturity Date: " + mdate + "\nSuccess: " + success + 
			"\nReason for Failure/Message: " + failure + String.format("\nPre Transaction Balance: $%.2f", preTransactionBalance)
			+ String.format("\nPost Transaction Balance: $%.2f", postTransactionBalance)
			+ "\nNew Maturity Date: " + newMDate + "\n";
		}
		public abstract TransactionTicket getTransactionTicket();
		public abstract boolean getSuccessIndicatorFlag();
		public abstract double getPreTransactionBalance();
		public abstract double getPostTransactionBalance();
		protected abstract void setTransactionTicket(TransactionTicket ticket);
		protected abstract void setSuccessIndicatorFlag(boolean newFlag);
		protected abstract void setReasonForFailure(String str);
		protected abstract void setPreTransactionBalance(double newBalance);
		protected abstract void setPostTransactionBalance(double newBalance);
		protected abstract void setPostTransactionMaturityDate(Calendar newDate);
}
