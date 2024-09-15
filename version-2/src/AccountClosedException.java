
public class AccountClosedException extends Exception {
	public AccountClosedException(Account account) {
		super("Error: Account number " + account.getAcctNum() + " is closed.");
	}
}
