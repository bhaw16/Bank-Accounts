public class InsufficientFunds extends Exception {
	/* Constructor InsufficientFunds()
	 * Input:
	 * amount - amount greater than the current balance that caused the exception to be thrown
	 * Process:
	 * creates a new InsufficientFunds instance with an error message that says
	 * that you don't have enough money to withdraw amount from your account;
	 * this constructor is called when the exception is thrown
	 * Output:
	 * An InsufficientFunds exception with an error message
	 * detailing why the exception was thrown
	 */
	public InsufficientFunds(double amount) {
		super(String.format("Error: You do not have sufficient funds to withdraw $%.2f from your account.\n", amount));
	}
}
