public class InvalidAmountException extends Exception {
	public InvalidAmountException(double amount) {
		super(String.format("Error: $%.2f is an invalid amount.", amount));
	}
	
	public InvalidAmountException(Account account) {
		super(String.format("Error: Account number " + account.getAcctNum() + " does not have a balance of $%.2f.", 0.00));
	}
}
