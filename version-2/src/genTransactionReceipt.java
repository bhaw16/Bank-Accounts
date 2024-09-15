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
		 * Sets the reasonForFailure to null Strings
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
		
		public genTransactionReceipt(TransactionTicket ticket, boolean successIndicatorFlag, String reasonForFailure,
		double preTransactionBalance, double postTransactionBalance, Calendar postTransactionMaturityDate) {
			this.ticket = ticket;
			this.successIndicatorFlag = successIndicatorFlag;
			this.reasonForFailure = reasonForFailure;
			this.preTransactionBalance = preTransactionBalance;
			this.postTransactionBalance = postTransactionBalance;
			this.postTransactionMaturityDate = postTransactionMaturityDate;
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
			String receipt = ticket.toString();
			String mdate = "";
			String newMDate = "";
			String failure;
			String success;
			if (successIndicatorFlag) {
				success = "Yes";
			}
			else {
				success = "No";
			}
			receipt += "\nSuccess: " + success;
			if ((!(reasonForFailure.equals("")))) {
				failure = reasonForFailure;
			}
			else {
				failure = "";
			}
			if ((!(failure.equals("")))) {
				receipt += "\nReason for Failure/Message: " + failure;
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
						mdate = "";
					}
					newMDate = (ticket.getTermOfCD().get(Calendar.MONTH) + 1) + "/" +
					ticket.getTermOfCD().get(Calendar.DAY_OF_MONTH) + "/" +
					ticket.getTermOfCD().get(Calendar.YEAR);
				}
			}
			if ((!(mdate.equals("")))) {
				receipt += "\nOld Maturity Date: " + mdate;
			}
			if ((!(newMDate.equals("")))) {
				receipt += "\nNew Maturity Date: " + newMDate;
			}
			if ((!(failure.equals("Error: Account number " + ticket.getAcctNum() + " does not exist.")))) {
				receipt += String.format("\nPre Transaction Balance: $%.2f", preTransactionBalance)
				+ String.format("\nPost Transaction Balance: $%.2f", postTransactionBalance);
			}
			return receipt + "\n";
		}
		
		public String getTransactionReceiptString() {
			String failure = "";
			if (reasonForFailure.equals("")) {
				for (int i = 0; i < 50; i++) {
					failure += " ";
				}
			}
			else {
				failure = reasonForFailure;
			}
			String postTransactionMaturityDateString = "";
			if (postTransactionMaturityDate == null) {
				for (int i = 0; i < 10; i++) {
					postTransactionMaturityDateString += " ";
				}
			}
			else {
				postTransactionMaturityDateString = (postTransactionMaturityDate.get(Calendar.MONTH) + 1) + "/"
				+ postTransactionMaturityDate.get(Calendar.DAY_OF_MONTH) + "/"
				+ postTransactionMaturityDate.get(Calendar.YEAR);
			}
			return String.format("%-86s%-5b%-85s%-10s%-10.2f%-10.2f", ticket.getTransactionTicketString(), successIndicatorFlag, failure,
			postTransactionMaturityDateString, preTransactionBalance, postTransactionBalance);
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
