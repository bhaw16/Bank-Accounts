public class AccountNotFound extends Exception {
	/*Constructor AccountNotFound()
	 * Input:
	 * acctNumber - requested 6-digit account number that
	 * was not found in the ArrayList of SavingsAccount
	 * objects, causing the exception to be thrown
	 * Process:
	 * creates a new AccountNotFound instance with an error message
	 * that says that the requested account number does not exist;
	 * this constructor is called when the exception is thrown
	 * Output:
	 * An AccountNotFound exception with an error message
	 * detailing why the exception was thrown
	 */
	public AccountNotFound(int acctNumber) {
		super("Error: Account number " + acctNumber + " does not exist.\n");
	}
}
