public class NegativeAmountEntered extends Exception {
	/* Constructor NegativeAmountEntered()
	 * Input:
	 * amount - negative entered amount that caused the exception to be thrown
	 * Process:
	 * creates a new NegativeAmountEntered instance with an error message that says
	 * that the amount entered is negative; this constructor is called when the exception is thrown
	 * Output:
	 * A NegativeAmountEntered exception with an error message
	 * detailing why the exception was thrown
	 */
	public NegativeAmountEntered(double amount) {
		super(String.format("Error: $%.2f is a negative amount.\n", amount));
	}
}
