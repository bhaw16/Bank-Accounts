public class InvalidAccountException extends Exception {
	public InvalidAccountException(int acctNum) {
		super("Error: Account number " + acctNum + " does not exist.");
	}
	
	public InvalidAccountException(Account account) {
		super("Error: Account number " + account.getAcctNum() + " already exists.");
	}
	
	public InvalidAccountException(Check check) {
		super("Error: Account number " + check.getAcctNum() + " is not a checking account.");
	}
	
	public InvalidAccountException(Account account, String acctStatus) {
		super("Error: Account number " + account.getAcctNum() + " is already " + acctStatus.toLowerCase() + ".");
	}
	
	public InvalidAccountException(String acctType) {
		super("Error: " + acctType + " is an invalid account type.\n");
	}
}
