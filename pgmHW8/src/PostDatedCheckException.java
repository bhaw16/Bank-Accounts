public class PostDatedCheckException extends Exception {
	public PostDatedCheckException() {
		super("Error: The date of this check has not been reached yet.");
	}
}
