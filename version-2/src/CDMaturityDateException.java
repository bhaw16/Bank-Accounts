public class CDMaturityDateException extends Exception {
	public CDMaturityDateException() {
		super("Error: This CD has not matured yet. Try again at a later date.");
	}
	
	public CDMaturityDateException(int MDate) {
		super("Error: " + MDate + " months is an invalid maturity date.\n");
	}
}
