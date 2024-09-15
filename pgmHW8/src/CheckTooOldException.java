public class CheckTooOldException extends Exception {
	public CheckTooOldException() {
		super("Error: This check is older than 6 months.");
	}
}
