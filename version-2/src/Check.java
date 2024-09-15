import java.util.Calendar;

public class Check {
	//instance field definitions
	private int acctNum;
	private double amountOfCheck;
	private Calendar dateOfCheck;
	
	/*Constructor Check() (No-Arg)
	 * Input:
	 * none
	 * Process:
	 * Sets the account number that the check will be cleared on to 0
	 * Sets the amount of the check to $0.00
	 * Sets the date of the check to null
	 * Output:
	 * Sets the account number that the check will be cleared on to 0
	 * Sets the amount of the check to $0.00
	 * Sets the date of the check to null
	 */
	public Check() {
		acctNum = 0;
		amountOfCheck = 0.00;
		dateOfCheck = null;
	}
	
	public Check(Check check) {
		this.acctNum = check.getAcctNum();
		this.amountOfCheck = check.getAmountOfCheck();
		this.dateOfCheck = check.getDateOfCheck();
	}
	
	public String toString() {
		String checkDate = "";
		if (acctNum != 0 && dateOfCheck != null) {
			checkDate = (getDateOfCheck().get(Calendar.MONTH) + 1) + "/"	+ getDateOfCheck().get(Calendar.DAY_OF_MONTH) + "/"
			+ getDateOfCheck().get(Calendar.YEAR);
		}
		return checkDate;
	}
	
	/*Constructor Check() (No-Arg)
	 * Input:
	 * acctNum - account number that the check will be cleared on
	 * amountOfCheck - amount of the check
	 * dateOfCheck - date of the check
	 * Process:
	 * Sets the account number that the check will be cleared on to acctNum
	 * Sets the amount of the check to amountOfCheck
	 * Sets the date of the check to dateOfCheck
	 * Output:
	 * Sets the account number that the check will be cleared on to acctNum
	 * Sets the amount of the check to amountOfCheck
	 * Sets the date of the check to dateOfCheck
	 */
	public Check(int acctNum, double amountOfCheck, Calendar dateOfCheck) {
		this.acctNum = acctNum;
		this.amountOfCheck = amountOfCheck;
		this.dateOfCheck = dateOfCheck;
	}
	
	/*Method getAcctNum()
	 * Input:
	 * none
	 * Process:
	 * returns the account number of the Account that the check will be cleared on
	 * Output:
	 * returns the account number of the Account that the check will be cleared on
	 */
	public int getAcctNum() {
		//returns the account number of the Account that the check will be cleared on
		return acctNum;
	}
	
	/*Method getAmountOfCheck()
	 * Input:
	 * none
	 * Process:
	 * returns the amount of the check
	 * Output:
	 * returns the amount of the check
	 */
	public double getAmountOfCheck() {
		//returns the mount of the check
		return amountOfCheck;
	}
	
	/*Method getDateOfCheck()
	 * Input:
	 * none
	 * Process:
	 * Constructs a new Calendar object
	 * Sets the object's data members to those of this Check's date
	 * returns the new object
	 * Output:
	 * Constructs a new Calendar object
	 * Sets the object's data members to those of this Check's date
	 * returns the new object
	 */
	public Calendar getDateOfCheck() {
		//returns the date on this check
		return dateOfCheck;
	}
	
	/*Method setAcctNum()
	 * Input:
	 * newNum - account number that will replace the current account number
	 * Process:
	 * sets the account number of the account to the int passed in to the method
	 * Output:
	 * sets the account number of the account to the int passed in to the method
	 */
	private void setAcctNum(int newNum) {
		//sets the account number of the account to the int passed in to the method
		acctNum = newNum;
	}
	
	/*Method setAmountOfCheck()
	 * Input:
	 * newAmount - check amount that will replace the current check amount
	 * Process:
	 * sets the check amount of the account to newAmount
	 * Output:
	 * sets the check amount of the account to newAmount
	 */
	private void setAmountOfCheck(double newAmount) {
		//sets the check amount of the account to newAmount
		amountOfCheck = newAmount;
	}
	
	/*Method setDateOfCheck()
	 * Input:
	 * newDate - check date that will replace the current check date
	 * Process:
	 * sets the check date of the account to newDate
	 * Output:
	 * sets the check date of the account to newDate
	 */
	private void setDateOfCheck(Calendar newDate) {
		//sets the check date of the account to newDate
		dateOfCheck = newDate;
	}
}