import java.io.*;
import java.util.*;

public class FinalExam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File testFile = new File("/Users/briannahawkins/eclipse-workspace/FinalExam/src/testCases.txt");	//open test cases file
		Scanner kybd = new Scanner(testFile);	//link it to Scanner for reading input
		PrintWriter outFile = new PrintWriter("/Users/briannahawkins/eclipse-workspace/FinalExam/src/pgmOutput.txt");	//open output file
		ArrayList<SavingsAccount> accts = new ArrayList<SavingsAccount>();	//initialize ArrayList of SavingsAccount objects
		readAccts(accts);	//fill in the ArrayList
		printAccts(accts, outFile);	//print the initial database
		char choice;	//initialize character representing user selection
		boolean notDone = true;	//flag variable used to end loop
		do {
			printMenu();	//print the menu of choices
			System.out.println("Enter your selction:\n");	//prompt user to make a menu selection
			choice = kybd.next().charAt(0);	//read-in user selection
			switch (choice) {
			//quit the program
			case 'q':
			case 'Q':
				notDone = false;	//change flag variable to false so iteration stops
				printAccts(accts, outFile);	//print the final database
				break;
			//get account balance
			case 'b':
			case 'B':
				getBalance(accts, kybd, outFile);	//perform get balance transaction
				break;
			//make deposit
			case 'd':
			case 'D':
				makeDeposit(accts, kybd, outFile);	//perform make deposit transaction
				break;
			//make withdrawal
			case 'w':
			case 'W':
				makeWithdrawal(accts, kybd, outFile);	//perform make withdrawal transaction
				break;
			//add interest
			case 'i':
			case 'I':
				addInterest(accts, kybd, outFile);	//perform add interest transactions
				break;
			//invalid menu selection
			default:
				outFile.println("Error: " + choice + " is an invalid menu selection. Try again.\n");	//print error message for invalid selection
				outFile.flush();	//flush the output buffer
			}
		} while (notDone);	//iterate while notDone is false so loop continues until the user quits
		kybd.close();	//close the Scanner
		outFile.close();	//close the output file
		System.out.println("The program is terminating");	//terminate the program
	}
	
	/*Method printMenu()
	 * Input:
	 * none
	 * Process:
	 * Prints the menu of choices
	 * Output:
	 * Prints the menu of choices
	 */
	public static void printMenu() {
		System.out.println("\nQ - quit the program");
		System.out.println("B - get account balance");
		System.out.println("D - make deposit");
		System.out.println("W - make withdrawal");
		System.out.println("I - add interest\n");
	}
	
	/*Method printAccts()
	 * Input:
	 * accts - ArrayList of SavingsAccount objects
	 * outFile - PrintWriter linked to output file for
	 * printing output
	 * Process:
	 * Prints table headers and then traverses accts
	 * and prints the account number and balance for every account.
	 * Output:
	 * prints account information to the output file
	 */
	public static void printAccts(ArrayList<SavingsAccount> accts, PrintWriter outFile) {
		outFile.printf("%-2s%-2s\n", " ", "Database of Bank Accounts");	//print table title
		outFile.printf("%-20s%-20s\n", "Account Number", "Balance");	//print table headers
		for (int i = 0; i < accts.size(); i++) {	//traverse accts
			outFile.printf("%-20s$%-20.2f\n", accts.get(i).getAcctNumber(), accts.get(i).getBalance());	//print account number and balance for every account
		}
		outFile.println();
		outFile.flush();	//flush the output buffer
	}
	
	/*Method readAccts()
	 * Input:
	 * accts - empty ArrayList of SavingsAccount objects to be filled in
	 * Process:
	 * Opens the database file and links it to a Scanner
	 * so its contents can be read in
	 * Until end of file is reached, a line of data is read in
	 * and the Strings containing the account number
	 * and balance are put into an array.
	 * Then, a new SavingsAccount instance is created by parsing
	 * the read-in data.
	 * Then, a new SavingsAccount instance is created using the SavingsAccount
	 * copy constructor
	 * Finally, the Scanner is closed.
	 * Output:
	 * fills in accts using the data from the database file
	 */
	public static void readAccts(ArrayList<SavingsAccount> accts) throws IOException {
		File dbFile = new File("/Users/briannahawkins/eclipse-workspace/FinalExam/src/initAccts.txt");	//open initial database file
		Scanner sc = new Scanner(dbFile);	//link it to a Scanner
		while (sc.hasNext()) {	//read data until EOF is reached
			String line;	//initialize String representing one line of data
			line = sc.nextLine();	//read in a line of data
			String[] tokens = line.split(" ");	//put the account number and balance Strings in an array
			SavingsAccount acct = new SavingsAccount(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]));	//parse data to create the account
			accts.add(new SavingsAccount(acct));	//add the account to the database
		}
		sc.close();	//close the Scanner
	}
	
	/*Method findAcct()
	 * Input:
	 * reqAcct - requested account number
	 * accts - ArrayList of SavingsAccount objects
	 * Process:
	 * Traverses the ArrayList.
	 * If the account number at the current index
	 * equals reqAcct, the current index is returned
	 * (and as a result exiting the loop).
	 * Otherwise, check the next index and repeat until
	 * the account number is found or the iteration is complete.
	 * If the entire ArrayList has been searched and the account
	 * number is not found, an AccountNotFound exception is thrown.
	 * Output:
	 * index of the requested account number if it exists;
	 * AccountNotFound exception if it doesn't.
	 */
	public static int findAcct(int reqAcct, ArrayList<SavingsAccount> accts) throws AccountNotFound {
		for (int i = 0; i < accts.size(); i++) {	//traverse database of accounts
			if (reqAcct == accts.get(i).getAcctNumber()) {	//account found
				return i;	//return index of requested account
			}
		}
		throw new AccountNotFound(reqAcct);	//account doesn't exist
	}
	
	/*Method getBalance()
	 * Input:
	 * accts - ArrayList of SavingsAccount objects
	 * kybd - Scanner linked to test cases file for reading input
	 * outFile - PrintWriter linked to output file for
	 * printing output
	 * Process:
	 * Prompts the user for an account number and
	 * then prints the transaction type and the account number requested
	 * by the user;
	 * Calls findAcct() to try to find the requested account
	 * If it doesn't exist, the AccountNotFound exception that gets thrown
	 * is handled by printing the error message.
	 * Otherwise, the current account balance is printed.
	 * Output:
	 * Receipt detailing the transaction
	 */
	public static void getBalance(ArrayList<SavingsAccount> accts, Scanner kybd, PrintWriter outFile) {
		System.out.println("Enter an account number:");	//prompt for account number
		int reqAcct = kybd.nextInt();	//read-in account number
		outFile.println("Transaction Requested: Get Account Balance");	//details transaction type
		outFile.println("Account Number: " + reqAcct);	//details account number the transaction is being performed on
		try {
			int index = findAcct(reqAcct, accts);	//look for account in database
			outFile.printf("Current Balance: $%.2f\n", accts.get(index).getBalance());	//print current balance if it exists
		}
		catch (AccountNotFound e) {	//invalid account number
			outFile.print(e.getMessage());	//print error message saying that the account doesn't exist.
		}
		finally {
			outFile.println();
			outFile.flush();	//flush the output buffer
		}
	}
	
	/*Method makeDeposit()
	 * Input:
	 * accts - ArrayList of SavingsAccount objects
	 * kybd - Scanner linked to test cases file for reading input
	 * outFile - PrintWriter linked to output file for
	 * printing output
	 * Process:
	 * Prompts the user for an account number and
	 * then prints the transaction type and the account number requested
	 * by the user;
	 * Calls findAcct() to try to find the requested account
	 * If it doesn't exist, the AccountNotFound exception that gets thrown
	 * is handled by printing the error message.
	 * Otherwise, the old balance is printed and the user is prompted
	 * for an amount to deposit. This amount is printed
	 * and the account calls makeDeposit().
	 * If a NegativeAmountEntered exception is thrown, the error message is printed.
	 * Otherwise, the deposit is successful and the updated balance is printed.
	 * Output:
	 * Receipt detailing the transaction
	 */
	public static void makeDeposit(ArrayList<SavingsAccount> accts, Scanner kybd, PrintWriter outFile) {
		System.out.println("Enter an account number:");	//prompt for account number
		int reqAcct = kybd.nextInt();	//read-in account number
		outFile.println("Transaction Requested: Make Deposit");	//details transaction type
		outFile.println("Account Number: " + reqAcct);	//details account number the transaction is being performed on
		try {
			int index = findAcct(reqAcct, accts);	//look for account in database
			outFile.printf("Old Balance: $%.2f\n", accts.get(index).getBalance());	//print current balance if it exists
			System.out.println("Enter an amount to deposit:\n");	//prompt user for amount to deposit
			double amount = kybd.nextDouble();	//read-in amount to deposit
			outFile.printf("Amount to Deposit: $%.2f\n", amount);	//print deposit amount
			accts.get(index).makeDeposit(amount);	//make deposit
			outFile.printf("Current Balance: $%.2f\n", accts.get(index).getBalance());	//print updated balance if it's successful
		}
		catch (AccountNotFound | NegativeAmountEntered e) {
			outFile.print(e.getMessage());	//print error message that either says the account doesn't exist or the deposit amount is negative
		}
		finally {
			outFile.println();
			outFile.flush();	//flush the output buffer
		}
	}
	
	/*Method makeWithdrawal()
	 * Input:
	 * accts - ArrayList of SavingsAccount objects
	 * kybd - Scanner linked to test cases file for reading input
	 * outFile - PrintWriter linked to output file for
	 * printing output
	 * Process:
	 * Prompts the user for an account number and
	 * then prints the transaction type and the account number requested
	 * by the user;
	 * Calls findAcct() to try to find the requested account
	 * If it doesn't exist, the AccountNotFound exception that gets thrown
	 * is handled by printing the error message.
	 * Otherwise, the old balance is printed and the user is prompted
	 * for an amount to withdraw. This amount is printed
	 * and the account calls makeWithdrawal().
	 * If a NegativeAmountEntered or InsufficientFunds exception is thrown,
	 * the error message is printed.
	 * Otherwise, the deposit is successful and the updated balance is printed.
	 * Output:
	 * Receipt detailing the transaction
	 */
	public static void makeWithdrawal(ArrayList<SavingsAccount> accts, Scanner kybd, PrintWriter outFile) {
		System.out.println("Enter an account number:");	//prompt for account number
		int reqAcct = kybd.nextInt();	//read-in account number
		outFile.println("Transaction Requested: Make Withdrawal");	//details transaction type
		outFile.println("Account Number: " + reqAcct);	//details account number the transaction is being performed on
		try {
			int index = findAcct(reqAcct, accts);	//look for account in database
			outFile.printf("Old Balance: $%.2f\n", accts.get(index).getBalance());	//print current balance if it exists
			System.out.println("Enter an amount to withdraw:\n");	//prompt user for amount to withdraw
			double amount = kybd.nextDouble();	//read-in amount to withdraw
			outFile.printf("Amount to Withdraw: $%.2f\n", amount);	//print withdrawal amount
			accts.get(index).makeWithdrawal(amount);	//make withdrawal
			outFile.printf("Current Balance: $%.2f\n", accts.get(index).getBalance());	//print updated balance if it's successful
		}
		catch (AccountNotFound | NegativeAmountEntered | InsufficientFunds e) {
			outFile.print(e.getMessage());	/*print error message that either says the account doesn't exist,
			or the deposit amount is negative or there isn't enough money to make the withdrawal*/
		}
		finally {
			outFile.println();
			outFile.flush();	//flush the output buffer
		}
	}
	
	/*Method addInterest()
	 * Input:
	 * accts - ArrayList of SavingsAccount objects
	 * kybd - Scanner linked to test cases file for reading input
	 * outFile - PrintWriter linked to output file for
	 * printing output
	 * Process:
	 * Prompts the user for an account number and
	 * then prints the transaction type and the account number requested
	 * by the user;
	 * Calls findAcct() to try to find the requested account
	 * If it doesn't exist, the AccountNotFound exception that gets thrown
	 * is handled by printing the error message.
	 * Otherwise, the old balance is printed and the user is prompted
	 * for an interest rate in percent. This percentage is printed
	 * and the account calls addInterest().
	 * Output:
	 * Receipt detailing the transaction
	 */
	public static void addInterest(ArrayList<SavingsAccount> accts, Scanner kybd, PrintWriter outFile) {
		System.out.println("Enter an account number:");	//prompt for account number
		int reqAcct = kybd.nextInt();	//read-in account number
		outFile.println("Transaction Requested: Add Interest");	//details transaction type
		outFile.println("Account Number: " + reqAcct);	//details account number the transaction is being performed on
		try {
			int index = findAcct(reqAcct, accts);	//look for account in database
			outFile.printf("Old Balance: $%.2f\n", accts.get(index).getBalance());	//print current balance if it exists
			System.out.println("Enter an interest rate (in percent):\n");	//prompt for interest rate
			double percent = kybd.nextDouble();	//read-in interest rate
			outFile.printf("Interest Rate: %.2f%%\n", percent);	//print interest rate
			accts.get(index).addInterest(percent);	//add interest to current balance
			outFile.printf("Current Balance: $%.2f\n", accts.get(index).getBalance());	//prints updated balance
		}
		catch (AccountNotFound e) {
			outFile.print(e.getMessage());	//print error message saying that the account doesn't exist.
		}
		finally {
			outFile.println();
			outFile.flush();	//flush the output buffer
		}
	}
}
