public class InvalidMenuSelectionException extends Exception {
	public InvalidMenuSelectionException(char choice) {
		super("Error: " + choice + " is an invalid selection. Try again.\n");
	}
}
