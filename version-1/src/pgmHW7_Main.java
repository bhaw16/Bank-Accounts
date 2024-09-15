import java.io.*;
import java.util.*;

public class pgmHW7_Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// variable declarations for the transaction choice and to keep track of whether
		// or not the program has been quit
		char choice;
		boolean notDone = true;

		// open input test cases file
		File testFile = new File("/Users/briannahawkins/eclipse-workspace/pgmHW7/src/TestCases7.txt");
		// create Scanner object
		Scanner kybd = new Scanner(testFile);
		// open the output file
		PrintWriter outFile = new PrintWriter("/Users/briannahawkins/eclipse-workspace/pgmHW7/src/pgmOutput7.txt");

		/* first part */
		/* fill and print initial database */
		Bank bank = new Bank();
		readAccts(bank);
		printAccts(bank, outFile);
		/* second part */
		/* prompts for a transaction and then */
		/* call functions to process the requested transaction */
		do {
			menu();
			choice = kybd.next().charAt(0);
			switch (choice) {
			case 'q':
			case 'Q':
				notDone = false;
				printAccts(bank, outFile);
				break;
			case 'w':
			case 'W':
				withdrawal(bank, kybd, outFile);
				break;
			case 'd':
			case 'D':
				deposit(bank, kybd, outFile);
				break;
			case 'c':
			case 'C':
				clearCheck(bank, kybd, outFile);
				break;
			case 'n':
			case 'N':
				newAcct(bank, kybd, outFile);
				break;
			case 'b':
			case 'B':
				balance(bank, kybd, outFile);
				break;
			case 'i':
			case 'I':
				accountInfo(bank, kybd, outFile);
				break;
			case 'h':
			case 'H':
				accountInfoHistory(bank, kybd, outFile);
				break;
			case 's':
			case 'S':
				closeAcct(bank, kybd, outFile);
				break;
			case 'r':
			case 'R':
				reopenAcct(bank, kybd, outFile);
				break;
			case 'x':
			case 'X':
				deleteAcct(bank, kybd, outFile);
				break;
			default:
				outFile.println("Error: " + choice + " is an invalid selection. Try again.\n");
				outFile.flush();
			}
		} while (notDone);
		// close the output file
		outFile.close();
		// close the test cases input file
		kybd.close();
		System.out.println("\nThe program is terminating");
	}

	/*
	 * Method menu() Input: none Process: Prints the menu of transaction choices
	 * Output: Prints the menu of transaction choices
	 */
	public static void menu() {
		System.out.println("\nSelect one of the following transactions:");
		System.out.println("\t****************************");
		System.out.println("\t    List of Choices         ");
		System.out.println("\t****************************");
		System.out.println("\t     W -- Withdrawal");
		System.out.println("\t     D -- Deposit");
		System.out.println("\t     C -- Clear Check");
		System.out.println("\t     N -- New Account");
		System.out.println("\t     B -- Balance Inquiry");
		System.out.println("\t     I -- Account Info (w/o Transaction History)");
		System.out.println("\t     H -- Account Info plus Transaction History");
		System.out.println("\t     S -- Close Account (close (shut), but do not delete the account)");
		System.out.println("\t     R -- Reopen Account");
		System.out.println("\t     X -- Delete Account");
		System.out.println("\t     Q -- Quit\n");
		System.out.print("\tEnter your selection: ");
	}

	/*
	 * Method printAccts() Input: bank - Bank containing ArrayList of bank accounts
	 * outFile - reference to the output file Process: Prints the database of
	 * accounts and balances Output: Prints the database of accounts and balances
	 */
	public static void printAccts(Bank bank, PrintWriter outFile) {
		outFile.printf("\n%85s\n", "Database of Bank Accounts");
		outFile.printf("\n%30s", "Total Balance: ");
		outFile.printf("$%.2f", Bank.getTotalAmountInAllAccts());
		outFile.printf("%30s", "Total Savings Balance: ");
		outFile.printf("$%.2f", Bank.getTotalAmountInSavingsAccts());
		outFile.printf("%30s", "Total Checking Balance: ");
		outFile.printf("$%.2f", Bank.getTotalAmountInCheckingAccts());
		outFile.printf("%30s", "Total CD Balance: ");
		outFile.printf("$%.2f", Bank.getTotalAmountInCDAccts());
		outFile.println("\n");
		outFile.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Last Name", "First Name", "SSN", "Account Number",
				"Account Type", "Maturity Date", "Account Status", "Balance");
		for (int i = 0; i < bank.getNumAccounts(); i++) {
			outFile.println(bank.getAccount(bank.acctNumberAt(i)));
		}
		// flush the output file
		outFile.flush();
	}

	/*
	 * Method readAccts() Input: account - reference to ArrayList of accounts
	 * Process: Reads the initial database of accounts using split() Output: Fills
	 * in the initial account array and returns the number of active accounts
	 */
	public static void readAccts(Bank bank) throws IOException {
		File dbFile = new File("/Users/briannahawkins/eclipse-workspace/pgmHW7/src/initAccounts7.txt");
		Scanner sc = new Scanner(dbFile);
		while (sc.hasNext()) {
			String line;
			line = sc.nextLine();
			String tokens[] = line.split(" ");
			Name name = new Name(tokens[0], tokens[1]);
			Depositor person = new Depositor(name, tokens[2]);
			Calendar today = Calendar.getInstance();
			Calendar maturityDate;
			Account account;
			TransactionTicket ticket;
			if (tokens.length == 7) {
				maturityDate = Calendar.getInstance();
				String[] dateFields = tokens[6].split("/");
				maturityDate.set(Integer.parseInt(dateFields[2]), (Integer.parseInt(dateFields[0]) - 1),
				Integer.parseInt(dateFields[1]));
				final Calendar maturitydate = maturityDate;
				ticket = new TransactionTicket(Integer.parseInt(tokens[4]), "New Account", today, Double.parseDouble(tokens[5]), maturitydate);
				account = new CDAccount(person, Integer.parseInt(tokens[4]), Double.parseDouble(tokens[5]),
				ticket.getTermOfCD());	
			} 
			else {
				ticket = new TransactionTicket(Integer.parseInt(tokens[4]), "New Account", today, Double.parseDouble(tokens[5]));
				switch (tokens[3]) {
				case "Savings":
					account = new SavingsAccount(person, ticket.getAcctNum(), ticket.getAmountOfTransaction());
					break;
				default:
					account = new CheckingAccount(person, ticket.getAcctNum(), ticket.getAmountOfTransaction());
					break;
				}
			}

			bank.openNewAcct(ticket, account);
		}
		sc.close(); // close the initial database file
	}

	/*
	 * Method balance() Input: bank - Bank containing ArrayList of accounts kybd -
	 * reference to the test cases input file outFile - the output file Process:
	 * Initializes a TransactionTicket detailing what the transaction is calls
	 * getBalance() on the created bank object and assigns the result to a new
	 * TransactionReceipt receipt Output: prints the transaction details
	 */
	public static void balance(Bank bank, Scanner kybd, PrintWriter outFile) {
		System.out.println("\nEnter account number: ");
		int acctNum = kybd.nextInt();
		Calendar today = Calendar.getInstance();
		/*
		 * System.out.println("Enter today's date: "); String date = kybd.next();
		 * String[] dateFields = date.split("/");
		 * today.set(Integer.parseInt(dateFields[2]), Integer.parseInt(dateFields[0]) -
		 * 1, Integer.parseInt(dateFields[1]));
		 */
		TransactionTicket ticket;
		// fill out TransactionTicket
		if (bank.findAcct(acctNum) != -1 && bank.getAccount(acctNum).getAcctType().equals("CD")) {
			Calendar maturityDate = bank.getCDAccount(acctNum).getMaturityDate();
			ticket = new TransactionTicket(acctNum, "Balance Inquiry", today, maturityDate);
		}
		else {
			ticket = new TransactionTicket(acctNum, "Balance Inquiry", today);
		}
		/*
		 * outFile.println("\nTransaction Requested: " + ticket.getTypeOfTransaction());
		 * outFile.println("Transaction Date: " + date);
		 */
		TransactionReceipt receipt = bank.getBalance(new TransactionTicket(ticket));
		outFile.println(receipt);
		/*
		 * if (receipt.getSuccessIndicatorFlag()) { outFile.println("Account Number: " +
		 * ticket.getAcctNum()); outFile.printf("Current Balance: $%.2f\n\n",
		 * receipt.getPostTransactionBalance()); } else {
		 * outFile.println(receipt.getReasonForFailure() + "\n"); }
		 */
		outFile.flush();
	}

	/*
	 * Method deposit() Input: bank - Bank containing ArrayList of accounts kybd -
	 * reference to the test cases input file outFile - the output file Process:
	 * Initializes a TransactionTicket detailing what the transaction is calls
	 * makeDeposit() on the created bank object and assigns the result to a new
	 * TransactionReceipt receipt If the transaction is successful and the account
	 * is a CD, a new TransactionReceipt is created with all of the previous
	 * TransactionReceipt's parameters plus the new maturity date entered by the
	 * user and replaces the CD with a new CD w/ the previous CD's parameters except
	 * for the maturity date, which will be the one entered by the user. Output:
	 * prints the transaction details
	 */
	public static void deposit(Bank bank, Scanner kybd, PrintWriter outFile) {
		System.out.println("\nEnter account number: "); // prompt user for account number
		int acctNum = kybd.nextInt(); // read-in account number
		Calendar today = Calendar.getInstance(); // initialize today's date
		System.out.println("Enter today's date: "); // prompts user for today's date
		/*
		 * String date = kybd.next(); // read-in today's date // set today's date using
		 * .split() String[] dateFields = date.split("/");
		 * today.set(Integer.parseInt(dateFields[2]), Integer.parseInt(dateFields[0]) -
		 * 1, Integer.parseInt(dateFields[1]));
		 */
		System.out.println("Enter an amount to deposit: "); // prompt user for amount
		double amount = kybd.nextDouble(); // read-in amount
		TransactionTicket ticket;
		// fill out TransactionTicket
		if (bank.findAcct(acctNum) != -1
				&& bank.getAccount(acctNum).getAcctType().equals("CD") /* instanceof CDAccount */) {
			System.out.println("Choose a new maturity date for the CD (in months): "); // prompt user for maturity
			// date
			int MDate = kybd.nextInt(); // read-in maturity date
			// keep reading-in maturity date until user puts in a valid date
			boolean validDate;
			do {
				switch (MDate) {
				case 6:
					validDate = true;
					break;
				case 12:
					validDate = true;
					break;
				case 18:
					validDate = true;
					break;
				case 24:
					validDate = true;
					break;
				default:
					validDate = false;
					outFile.println("Error: " + MDate + " months is an invalid maturity date. Try again.");
					MDate = Integer.parseInt(kybd.next());
				}
			} while (!validDate);
			Calendar termOfCD = Calendar.getInstance();
			termOfCD.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
			termOfCD.add(Calendar.MONTH, MDate);
			Calendar maturityDate = Calendar.getInstance();
			maturityDate.set(bank.getCDAccount(acctNum).getMaturityDate().get(Calendar.YEAR),
					bank.getCDAccount(acctNum).getMaturityDate().get(Calendar.MONTH),
					bank.getCDAccount(acctNum).getMaturityDate().get(Calendar.DAY_OF_MONTH));
			final Calendar maturitydate = maturityDate;
			ticket = new TransactionTicket(acctNum, "Deposit", today, amount, termOfCD, maturitydate);
		}
		else {
			ticket = new TransactionTicket(acctNum, "Deposit", today, amount);
		}
		TransactionReceipt receipt;
		receipt = bank.makeDeposit(ticket); // make deposit
		outFile.println(receipt);
		outFile.flush();
	}

	/*
	 * Method withdrawal() Input: bank - Bank containing ArrayList of accounts kybd
	 * - reference to the test cases input file outFile - the output file Process:
	 * Initializes a TransactionTicket detailing what the transaction is calls
	 * makeWithdrawal() on the created bank object and assigns the result to a new
	 * TransactionReceipt receipt If the transaction is successful and the account
	 * is a CD, a new TransactionReceipt is created with all of the previous
	 * TransactionReceipt's parameters plus the new maturity date entered by the
	 * user and replaces the CD with a new CD w/ the previous CD's parameters except
	 * for the maturity date, which will be the one entered by the user. Output:
	 * prints the transaction details
	 */
	public static void withdrawal(Bank bank, Scanner kybd, PrintWriter outFile) {
		System.out.println("\nEnter account number: "); // prompt user for account number
		int acctNum = kybd.nextInt(); // read-in account number
		Calendar today = Calendar.getInstance(); // initialize today's date
		/*
		 * System.out.println("Enter today's date: "); // prompts user for today's date
		 * String date = kybd.next(); // read-in today's date // set today's date using
		 * .split() String[] dateFields = date.split("/");
		 * today.set(Integer.parseInt(dateFields[2]), Integer.parseInt(dateFields[0]) -
		 * 1, Integer.parseInt(dateFields[1]));
		 */

		System.out.println("Enter an amount to withdraw: "); // prompt user for amount
		double amount = kybd.nextDouble(); // read-in amount
		TransactionTicket ticket;
		// fill out TransactionTicket
		if (bank.findAcct(acctNum) != -1 && bank.getAccount(acctNum).getAcctType().equals("CD")) {
			System.out.println("Choose a new maturity date for the CD (in months): "); // prompt user for maturity
			// date
			int MDate = kybd.nextInt(); // read-in maturity date
			// keep reading-in maturity date until user puts in a valid date
			boolean validDate;
			do {
				switch (MDate) {
				case 6:
					validDate = true;
					break;
				case 12:
					validDate = true;
					break;
				case 18:
					validDate = true;
					break;
				case 24:
					validDate = true;
					break;
				default:
					validDate = false;
					outFile.println("Error: " + MDate + " months is an invalid maturity date. Try again.");
					MDate = Integer.parseInt(kybd.next());
				}
			} while (!validDate);
			Calendar termOfCD = Calendar.getInstance();
			termOfCD.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
			termOfCD.add(Calendar.MONTH, MDate);
			Calendar maturityDate = Calendar.getInstance();
			maturityDate.set(bank.getCDAccount(acctNum).getMaturityDate().get(Calendar.YEAR),
					bank.getCDAccount(acctNum).getMaturityDate().get(Calendar.MONTH),
					bank.getCDAccount(acctNum).getMaturityDate().get(Calendar.DAY_OF_MONTH));
			final Calendar maturitydate = maturityDate;
			ticket = new TransactionTicket(acctNum, "Withdrawal", today, amount, termOfCD, maturitydate);
		}
		else {
			ticket = new TransactionTicket(acctNum, "Withdrawal", today, amount);
		}
		TransactionReceipt receipt;
		receipt = bank.makeWithdrawal(ticket); // make withdrawal
		outFile.println(receipt);
		outFile.flush();
	}
	/*
	 * else { outFile.println(receipt.getReasonForFailure() + "\n"); }
	 */

	/*
	 * Method clearCheck() Input: bank - Bank containing ArrayList of accounts kybd
	 * - reference to the test cases input file outFile - the output file Process:
	 * Initializes a TransactionTicket detailing what the transaction is calls
	 * clearCheck() on the created bank object and assigns the result to a new
	 * TransactionReceipt receipt Output: prints the transaction details
	 */
	public static void clearCheck(Bank bank, Scanner kybd, PrintWriter outFile) {
		System.out.println("\nEnter account number: "); // prompt user for account number
		int acctNum = kybd.nextInt(); // read-in account number
		Calendar today = Calendar.getInstance(); // initialize today's date
		/*
		 * System.out.println("Enter today's date: "); // prompts user for today's date
		 * String date = kybd.next(); // read-in today's date // set today's date using
		 * .split() String[] dateFields = date.split("/");
		 * today.set(Integer.parseInt(dateFields[2]), Integer.parseInt(dateFields[0]) -
		 * 1, Integer.parseInt(dateFields[1]));
		 */
		System.out.println("What is the amount of the check?"); // prompt user for amount
		double amountOfCheck = kybd.nextDouble(); // read-in amount
		System.out.println("What is the date of the check?"); // prompts user for check date
		Calendar dateOfCheck = Calendar.getInstance(); // read-in check date
		// set check date using .split();
		String[] dOC = kybd.next().split("/");
		dateOfCheck.set(Integer.parseInt(dOC[2]), (Integer.parseInt(dOC[0]) - 1), Integer.parseInt(dOC[1]));
		Check check = new Check(acctNum, amountOfCheck, dateOfCheck); // initialize check
		/*
		 * outFile.println("\nTransaction Requested: " + "Clear Check");
		 * outFile.println("Transaction Date: " + date);
		 * outFile.println("Date of Check: " +
		 * (check.getDateOfCheck().get(Calendar.MONTH) + 1) + "/" +
		 * check.getDateOfCheck().get(Calendar.DAY_OF_MONTH) + "/" +
		 * check.getDateOfCheck().get(Calendar.YEAR));
		 * outFile.println("Account Number: " + acctNum);
		 */
		TransactionTicket ticket;
		// fill out TransactionTicket
		if (bank.findAcct(acctNum) != -1 && bank.getAccount(acctNum).getAcctType().equals("CD")) {
			ticket = new TransactionTicket(acctNum, "Clear Check", today, amountOfCheck,
					bank.getCDAccount(acctNum).getMaturityDate(), check);
		}
		else {
			ticket = new TransactionTicket(acctNum, "Clear Check", today, amountOfCheck, null, check);
		}
		TransactionReceipt receipt = bank.clearCheck(check, ticket); // clear check
		outFile.println(receipt);
		outFile.flush();
	}

	/*
	 * Method newAcct() Input: bank - Bank containing ArrayList of accounts kybd -
	 * reference to the test cases input file outFile - the output file Process:
	 * Prompts the user for account number, date, name, SSN, account type and
	 * initial opening deposit (plus maturity date if the account created is a CD)
	 * Initializes a TransactionTicket detailing what the transaction is calls
	 * openNewAcct() on the created bank object and assigns the result to a new
	 * TransactionReceipt receipt Output: prints the transaction details
	 */
	public static void newAcct(Bank bank, Scanner kybd, PrintWriter outFile) {
		System.out.println("\nEnter account number: "); // prompt user for account number
		int acctNum = kybd.nextInt(); // read-in account number
		Calendar today = Calendar.getInstance(); // initialize today's date
		/*
		 * System.out.println("Enter today's date: "); // prompts user for today's date
		 * String date = kybd.next(); // read-in today's date // set today's date using
		 * .split() String[] dateFields = date.split("/");
		 * today.set(Integer.parseInt(dateFields[2]), Integer.parseInt(dateFields[0]) -
		 * 1, Integer.parseInt(dateFields[1]));
		 */
		System.out.println("Enter your first name: "); // prompts user for first name
		String first = kybd.next(); // read-in first name
		System.out.println("Enter your last name: "); // prompts user for last name
		String last = kybd.next(); // read-in last name
		Name name = new Name(first, last); // initialize Name
		System.out.println("Enter your SSN: "); // prompt user for SSN
		String SSN = kybd.next(); // read=in SSN
		Depositor person = new Depositor(name, SSN); // initialize Depositor
		System.out.println("What type of account do you want to open?"); // prompt user for account type
		/*
		 * outFile.println("\nTransaction Date: " + date); // read-in account type
		 * outFile.println("Transaction Requested: New Account");
		 */
		Calendar maturityDate = Calendar.getInstance(); // initialize maturity date
		maturityDate.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
		String acctType = kybd.next(); // read-in account type
		// keep reading-in account type until the user puts in a valid account type
		boolean validAcctType;
		do {
			switch (acctType) {
			case "CD":
				validAcctType = true;
				break;
			case "Checking":
				validAcctType = true;
				break;
			case "Savings":
				validAcctType = true;
				break;
			default:
				validAcctType = false;
				outFile.println("Error: " + acctType + " is an invalid account type. Try again.");
				acctType = kybd.next();
			}
		} while (!validAcctType);
		if (acctType.equals("CD")) { // account is a CD
			System.out.println("Choose the maturity date of the CD (in months): "); // prompt user for maturity date of
																					// new account
			int MDate = kybd.nextInt(); // read-in maturity date
			// keep reading-in maturity date until user inputs a valid maturity date
			boolean validDate;
			do {
				switch (MDate) {
				case 6:
					validDate = true;
					break;
				case 12:
					validDate = true;
					break;
				case 18:
					validDate = true;
					break;
				case 24:
					validDate = true;
					break;
				default:
					validDate = false;
					outFile.println("Error: " + MDate + " months is an invalid maturity date. Try again.");
					MDate = Integer.parseInt(kybd.next());
				}
			} while (!validDate);
			maturityDate.add(Calendar.MONTH, MDate);
		} else { // account is not a CD
			maturityDate = null; // set maturity date to null
		}

		System.out.println("Enter your initial opening deposit"); // prompt user for initial opening deposit
		double balance = kybd.nextDouble(); // read-in initial opening deposit
		// fill out TransactionTicket
		TransactionTicket ticket;
		// Calendar oldMaturityDate;
		if ((bank.findAcct(acctNum) != -1 && bank.getAccount(acctNum).getAcctType().equalsIgnoreCase("CD"))) {
			ticket = new TransactionTicket(acctNum, "New Account", today, balance,
					bank.getCDAccount(acctNum).getMaturityDate());
		}
		else {
			ticket = new TransactionTicket(acctNum, "New Account", today, balance, maturityDate);
		}

		// create account to be added
		Account account;
		final Calendar maturitydate = new TransactionTicket(ticket).getTermOfCD();
		switch (acctType) {
		case "CD":
			account = new CDAccount(person, ticket.getAcctNum(), ticket.getAmountOfTransaction(), maturitydate);
			break;
		case "Savings":
			account = new SavingsAccount(person, ticket.getAcctNum(), ticket.getAmountOfTransaction());
			break;
		default:
			account = new CheckingAccount(person, ticket.getAcctNum(), ticket.getAmountOfTransaction());
			break;
		}

		// add account
		TransactionReceipt receipt = bank.openNewAcct(new TransactionTicket(ticket), account);
		outFile.println(receipt);
		printAccts(bank, outFile);
		outFile.flush();
	}

	/*
	 * Method deleteAcct() Input: bank - Bank containing ArrayList of accounts kybd
	 * - reference to the test cases input file outFile - the output file Process:
	 * Prompts the user for account number and date Initializes a TransactionTicket
	 * detailing what the transaction is calls deleteAcct() on the created bank
	 * object and assigns the result to a new TransactionReceipt receipt Output:
	 * prints the transaction details
	 */
	public static void deleteAcct(Bank bank, Scanner kybd, PrintWriter outFile) {
		System.out.println("\nEnter account number: "); // prompt user for account number
		int acctNum = kybd.nextInt(); // read-in account number
		Calendar today = Calendar.getInstance(); // initialize today's date
		/*
		 * System.out.println("Enter today's date: "); // prompt user for today's date
		 * String date = kybd.next(); // read-in today's date // set today's date using
		 * .split() String[] dateFields = date.split("/");
		 * today.set(Integer.parseInt(dateFields[2]), Integer.parseInt(dateFields[0]) -
		 * 1, Integer.parseInt(dateFields[1]));
		 */
		// fill out TransactionTicket
		TransactionTicket ticket;
		// fill out TransactionTicket
		if (bank.findAcct(acctNum) != -1 && bank.getAccount(acctNum).getAcctType().equals("CD")) {
			ticket = new TransactionTicket(acctNum, "Delete Account", today,
					bank.getCDAccount(acctNum).getMaturityDate());
		} else {
			ticket = new TransactionTicket(acctNum, "Delete Account", today);
		}
		TransactionReceipt receipt = bank.deleteAcct(new TransactionTicket(ticket));
		outFile.println(receipt);
		printAccts(bank, outFile);
		outFile.flush();
	}

	/*
	 * Method accountInfo() bank - Bank containing ArrayList of accounts outFile -
	 * reference to the output file kybd - reference to the "test cases" input file
	 * Process: The user is prompted for a social security number. The input is then
	 * assigned to a new string reqSSN. The user is then prompted for today's date.
	 * Then, a boolean SSNFound is initialized as false. Then, the account array is
	 * traversed until the last active account. If the social security number of the
	 * account at the current index is equal to reqSSN, SSNFound is set to true (if
	 * it hasn't already been set to true) and the table headers are printed and the
	 * complete account information for the account at the current index is printed
	 * to the output file as a table. However, if the traversal has reached the last
	 * active account in the database and SSNFound is still false (meaning that
	 * there is no account with the SSN put in by the user), an error message is
	 * printed saying that no accounts exist for the requested security number.
	 * Output: For a non-existing SSN, an error message is printed saying that no
	 * accounts exist for that SSN. Otherwise, the complete account information for
	 * all of the accounts with the requested SSN is printed as a table.
	 */
	public static void accountInfo(Bank bank, Scanner kybd, PrintWriter outFile) {
		outFile.println("\nTransaction Requested: Account Info w/o Transaction History");
		System.out.println("\nEnter your social security number: "); // prompt user for SSN
		String reqSSN = kybd.next(); // read-in SSN
		outFile.println("SSN: " + reqSSN);
		Calendar today = Calendar.getInstance();
		// System.out.println("Enter today's date: ");
		/*
		 * String date = kybd.next(); // read-in date String[] dateFields =
		 * date.split("/"); today.set(Integer.parseInt(dateFields[2]),
		 * Integer.parseInt(dateFields[0]) - 1, Integer.parseInt(dateFields[1]));
		 */
		String date = (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.DAY_OF_MONTH) + "/"
				+ today.get(Calendar.YEAR);
		outFile.println("Transaction Date: " + date + "\n");
		boolean SSNFound = false; // flag variable for whether or not the indicated SSN exists
		for (int i = 0; i < bank.getNumAccounts(); i++) { // traverse active database
			if (bank.getAccount(bank.acctNumberAt(i)).getDepositor().getSSN().equals(reqSSN)) { // account at the
																								// current index
				// equals the indicated SSN
				if (!SSNFound) { // if SSNFound hasn't already been set to true
					SSNFound = true; // sets SSNFound to true
					outFile.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Last Name", "First Name", "SSN",
							"Account Number", "Account Type", "Maturity Date", "Account Status", "Balance"); // prints
																												// table
																												// headers
				}
				// print complete account information for the account at the current index
				outFile.println(bank.getAccount(bank.acctNumberAt(i)));
			}
			if (i == bank.getNumAccounts() - 1
					&& (!SSNFound)) { /*
										 * if the last index has been reached and the indicated SSN hasn't been found in
										 * the database yet
										 */
				outFile.println("Error: No accounts exist for this SSN.");
			}
		}
		outFile.println();
		outFile.flush(); // flush the output file
	}

	/*
	 * Method accountInfoHistory() bank - Bank containing ArrayList of accounts
	 * outFile - reference to the output file kybd - reference to the "test cases"
	 * input file Process: The user is prompted for a social security number. The
	 * input is then assigned to a new string reqSSN. The user is then prompted for
	 * today's date. Then, a boolean SSNFound is initialized as false. Then, the
	 * account array is traversed until the last active account. If the social
	 * security number of the account at the current index is equal to reqSSN,
	 * SSNFound is set to true (if it hasn't already been set to true) 
	 * and the complete account information for the account at
	 * the current index is printed to the output file as a table. If the account
	 * has transaction history, the complete transaction history for that account is
	 * printed to the output file as a table. Otherwise, an error message is printed
	 * saying that there is no transaction history for the current account. This is
	 * repeated with the next account if there is one. However, if the traversal has
	 * reached the last active account in the database and SSNFound is still false
	 * (meaning that there is no account with the SSN put in by the user), an error
	 * message is printed saying that no accounts exist for the requested security
	 * number. Output: For a non-existing SSN, an error message is printed saying
	 * that no accounts exist for that SSN. Otherwise, the complete account
	 * information for all of the accounts with the requested SSN is printed as a
	 * table. For accounts with transaction history, the complete transaction
	 * history for that account is printed as a table. Otherwise, an error message
	 * is printed saying that there is no transaction history for that account. This
	 * is repeated with any other accounts that match the requested SSN.
	 */
	public static void accountInfoHistory(Bank bank, Scanner kybd, PrintWriter outFile) {
		outFile.println("\nTransaction Requested: Account Info plus Transaction History");
		System.out.println("\nEnter your social security number: "); // prompt user for SSN
		String reqSSN = kybd.next(); // read-in SSN
		outFile.println("SSN: " + reqSSN);
		Calendar today = Calendar.getInstance();
		// System.out.println("Enter today's date: ");
		/*
		 * String date = kybd.next(); // read-in date String[] dateFields =
		 * date.split("/"); today.set(Integer.parseInt(dateFields[2]),
		 * Integer.parseInt(dateFields[0]) - 1, Integer.parseInt(dateFields[1]));
		 */
		String date = (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.DAY_OF_MONTH) + "/"
				+ today.get(Calendar.YEAR);
		outFile.println("Transaction Date: " + date + "\n");
		boolean SSNFound = false; // flag variable for whether or not the indicated SSN exists
		for (int i = 0; i < bank.getNumAccounts(); i++) { // traverse active database
			if (bank.getAccount(bank.acctNumberAt(i)).getDepositor().getSSN().equals(reqSSN)) { // account at the
																								// current index
				// equals the indicated SSN
				if (!SSNFound) { // if SSNFound hasn't already been set to true
					SSNFound = true; // sets SSNFound to true
					outFile.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Last Name", "First Name", "SSN",
							"Account Number", "Account Type", "Maturity Date", "Account Status", "Balance"); // prints
																												// table
																												// headers
				}
				// print complete account information for the account at the current index
				outFile.println("\n" + bank.getAccount(bank.acctNumberAt(i)));
				outFile.printf("\n%85s\n\n", "Transaction History for Account Number " + bank.acctNumberAt(i));
				for (int j = 0; j < bank.getAccount(bank.acctNumberAt(i)).getTransactionHistory().size(); j++) { //traverse account transaction history
					// print complete transaction history for the transaction history at the current index
					outFile.println(bank.getAccount(bank.acctNumberAt(i)).getTransactionHistory().get(j));
				}
			}
			if (i == bank.getNumAccounts() - 1
					&& (!SSNFound)) { /*
										 * if the last index has been reached and the indicated SSN hasn't been found in
										 * the database yet
										 */
				outFile.println("Error: No accounts exist for this SSN.");
			}
		}
		outFile.println();
		outFile.flush(); // flush the output file
	}

	/*
	 * Method closeAcct() Input: bank - Bank containing ArrayList of accounts kybd -
	 * reference to the test cases input file outFile - the output file Process:
	 * Prompts the user for account number and date Initializes a TransactionTicket
	 * detailing what the transaction is calls closeAcct() on the created bank
	 * object and assigns the result to a new TransactionReceipt receipt Output:
	 * prints the transaction details
	 */
	public static void closeAcct(Bank bank, Scanner kybd, PrintWriter outFile) {
		/* outFile.println("\nTransaction Requested: Close Account"); */
		System.out.println("Enter the account number: ");
		int acctNum = kybd.nextInt();
		// System.out.println("Enter today's date: ");
		/*
		 * String date = kybd.next(); String[] dateFields = date.split("/");
		 */
		/* outFile.println("Transaction Date: " + date); */
		Calendar today = Calendar.getInstance();
		/*
		 * today.set(Integer.parseInt(dateFields[2]), ((Integer.parseInt(dateFields[0]))
		 * - 1), Integer.parseInt(dateFields[1]));
		 */
		// fill out TransactionTicket
		TransactionTicket ticket;
		if (bank.findAcct(acctNum) != -1 && bank.getAccount(acctNum).getAcctType().equals("CD")) {
			ticket = new TransactionTicket(acctNum, "Close Account", today, 0.00,
					bank.getCDAccount(acctNum).getMaturityDate());
		}
		else {
			ticket = new TransactionTicket(acctNum, "Close Account", today, 0.00);
		}
		TransactionReceipt receipt = bank.closeAcct(ticket);
		outFile.println(receipt);
		/*
		 * if (receipt.getSuccessIndicatorFlag()) { outFile.println("Account closed: " +
		 * ticket.getAcctNum()); } else { outFile.println("Error: " +
		 * receipt.getReasonForFailure() + "\n"); }
		 */
		printAccts(bank, outFile);
		outFile.flush(); // flush the output file
	}

	/*
	 * Method reopenAcct() Input: bank - Bank containing ArrayList of accounts kybd
	 * - reference to the test cases input file outFile - the output file Process:
	 * Prompts the user for account number and date Initializes a TransactionTicket
	 * detailing what the transaction is calls reopenAcct() on the created bank
	 * object and assigns the result to a new TransactionReceipt receipt Output:
	 * prints the transaction details
	 */
	public static void reopenAcct(Bank bank, Scanner kybd, PrintWriter outFile) {
		/* outFile.println("\nTransaction Requested: Reopen Account"); */
		System.out.println("Enter the account number: ");
		int acctNum = kybd.nextInt();
		/*
		 * System.out.println("Enter today's date: "); String date = kybd.next();
		 * String[] dateFields = date.split("/");
		 */
		/* outFile.println("Transaction Date: " + date); */
		Calendar today = Calendar.getInstance();
		/*
		 * today.set(Integer.parseInt(dateFields[2]), ((Integer.parseInt(dateFields[0]))
		 * - 1), Integer.parseInt(dateFields[1]));
		 */
		// fill out TransactionTicket
		TransactionTicket ticket;
		if (bank.findAcct(acctNum) != -1 && bank.getAccount(acctNum).getAcctType().equals("CD")) {
			ticket = new TransactionTicket(acctNum, "Reopen Account", today, 0.00,
					bank.getCDAccount(acctNum).getMaturityDate());
		}
		else {
			ticket = new TransactionTicket(acctNum, "Reopen Account", today, 0.00);
		}
		TransactionReceipt receipt = bank.reopenAcct(ticket); // reopen account
		outFile.println(receipt);
		/*
		 * if (receipt.getSuccessIndicatorFlag()) { outFile.println("Account reopened: "
		 * + ticket.getAcctNum() + "\n"); } else { outFile.println("Error: " +
		 * receipt.getReasonForFailure() + "\n"); }
		 */
		printAccts(bank, outFile);
		outFile.flush(); // flush the output file
	}
}
