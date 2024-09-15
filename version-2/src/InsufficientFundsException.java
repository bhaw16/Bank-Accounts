public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(double amount) {
		super(String.format("You do not have sufficient funds to withdraw $%.2f from your account.", amount));
	}
	
	public InsufficientFundsException(Check check) {
		super(String.format("Check bounced; insufficient funds for withdrawal of $%.2f. Your penalty is $%.2f.", check.getAmountOfCheck(), 2.50));
	}
}
