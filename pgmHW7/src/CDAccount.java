import java.util.*;

public class CDAccount extends SavingsAccount {
	//instance field unique to CD accounts; maturityDate
	private Calendar maturityDate;
	
	 public CDAccount() {
		 super("CD");
		 maturityDate = null;
	}
	 
	 public CDAccount(int acctNum) {
		 super(acctNum, "CD");
		 maturityDate = null;
	 }
	 
	 public CDAccount(Depositor person, int acctNum, double balance) {
		 super(person, acctNum, "CD", balance);
		 maturityDate = null;
	 }
	 
	 public CDAccount(Depositor person, int acctNum, double balance,
	 ArrayList<TransactionReceipt> transactionHistory) {
		 super(person, acctNum, balance, "CD", transactionHistory);
		 maturityDate = null;
	 }
	 
	 public CDAccount(Calendar maturityDate) {
		 super("CD");
		 this.maturityDate = maturityDate;
	}
	 
	 public CDAccount(int acctNum, Calendar maturityDate) {
		 super(acctNum, "CD");
		 this.maturityDate = maturityDate;
	 }
	 
	 public CDAccount(Depositor person, int acctNum, double balance, Calendar maturityDate) {
		 super(person, acctNum, "CD", balance);
		 this.maturityDate = maturityDate;
	 }
	 
	 public CDAccount(Depositor person, int acctNum, double balance,
	 ArrayList<TransactionReceipt> transactionHistory, Calendar maturityDate) {
		 super(person, acctNum, balance, "CD", transactionHistory);
		 this.maturityDate = maturityDate;
	 }
	 
	 public CDAccount(CDAccount acct) {
		 super(acct);
		 this.maturityDate = acct.getMaturityDate();
	 }
	 
	 public Calendar getMaturityDate() {
		 return maturityDate;
	 }
	 
	 boolean equals(CDAccount other) {
		 if (super.equals(other) && this.maturityDate.equals(other.getMaturityDate())) {
			 return true;
		 }
		 return false;
	 }
	 
	 public String toString() {
		 //tringBuilder str = new StringBuilder(super.toString());
		 String mdate = (maturityDate.get(Calendar.MONTH) + 1) + "/" + maturityDate.get(Calendar.DAY_OF_MONTH)
		 + "/" + maturityDate.get(Calendar.YEAR);
		 //str = new StringBuilder(str.replace(str.indexOf("N/A"), str.indexOf("N/A") + 3, mdate));
			/*
			 * str = new StringBuilder((str.replace(str.indexOf(acctStatus),
			 * str.indexOf(acctStatus.substring(acctStatus.length() - 1,
			 * acctStatus.length())) + 1, String.format(acctStatus, "%11s"))));
			 */
		return String.format("%20s", getDepositor().toString()).concat(String.format("%-11s%-20s%-20s%-20s%-20s", " ",
		getAcctNum(), getAcctType(), mdate, acctStatus) + String.format("$%9.2f", getAcctBalance()) + "\n");
	 }
	 
	 public TransactionReceipt makeDeposit(TransactionTicket ticket) {
		 TransactionReceipt receipt;
		 if (getAcctStatus().equalsIgnoreCase("Closed")) {
			receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " is closed.",
			getAcctBalance(), getAcctBalance());
		 }
		 else if (ticket.getDateOfTransaction().before(maturityDate)) {
			 receipt = new TransactionReceipt(ticket, "Error: This CD has not matured yet. Try again at a later date.",
			 getAcctBalance(), getAcctBalance(), maturityDate);
			 
		 }
		 else if (ticket.getAmountOfTransaction() <= 0.00) {
			 receipt = new TransactionReceipt(ticket, String.format("Error: $%.2f is an invalid amount.", ticket.getAmountOfTransaction()),
			 getAcctBalance(), getAcctBalance(), maturityDate);
		 }
		 else {
			 balance += ticket.getAmountOfTransaction();
			 maturityDate.set(ticket.getTermOfCD().get(Calendar.YEAR), ticket.getTermOfCD().get(Calendar.MONTH),
			 ticket.getTermOfCD().get(Calendar.DAY_OF_MONTH));
			 receipt = new TransactionReceipt(ticket, getAcctBalance() - ticket.getAmountOfTransaction(),
			 getAcctBalance(), maturityDate);
			 Bank.addToAllTotal(ticket.getAmountOfTransaction());
			 Bank.addToCDTotal(ticket.getAmountOfTransaction());
		 }
		 addTransaction(new TransactionReceipt(receipt));
		 return new TransactionReceipt(receipt);
	 }
	 public TransactionReceipt makeWithdrawal(TransactionTicket ticket) {
		 TransactionReceipt receipt;
		 if (getAcctStatus().equalsIgnoreCase("Closed")) {
			 receipt = new TransactionReceipt(ticket, "Error: Account number " + ticket.getAcctNum() + " is closed.",
			 getAcctBalance(), getAcctBalance());
		 }
		else if (ticket.getDateOfTransaction().before(maturityDate)) {
			 receipt = new TransactionReceipt(ticket, "Error: This CD has not matured yet. Try again at a later date.",
			 getAcctBalance(), getAcctBalance(), maturityDate);
			 
		 }
		 else if (ticket.getAmountOfTransaction() <= 0.00) {
			 receipt = new TransactionReceipt(ticket, String.format("Error: $%.2f is an invalid amount.", ticket.getAmountOfTransaction()),
			 getAcctBalance(), getAcctBalance(), maturityDate);
		 }
		 else if (balance - ticket.getAmountOfTransaction() < 0.00) {
			 receipt = new TransactionReceipt(ticket, String.format("Error: You do not have sufficient funds to withdraw $%.2f from your account.",
			 ticket.getAmountOfTransaction()), getAcctBalance(), getAcctBalance(), maturityDate);
		 }
		 else {
			 balance -= ticket.getAmountOfTransaction();
			 maturityDate.set(ticket.getTermOfCD().get(Calendar.YEAR), ticket.getTermOfCD().get(Calendar.MONTH),
			 ticket.getTermOfCD().get(Calendar.DAY_OF_MONTH));
			 receipt = new TransactionReceipt(ticket, getAcctBalance() + ticket.getAmountOfTransaction(),
			 getAcctBalance(), maturityDate);
			 Bank.subtractFromAllTotal(ticket.getAmountOfTransaction());
			 Bank.subtractFromCDTotal(ticket.getAmountOfTransaction());
		 }
		 addTransaction(new TransactionReceipt(receipt));
		 return new TransactionReceipt(receipt);
	 }
}
