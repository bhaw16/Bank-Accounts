public abstract class genDepositor {
	protected Name name;
	protected String SSN;
	
	public genDepositor() {
		name = new Name();
		SSN = "";
	}
	
	/*Constructor Depositor()
	 * Input:
	 * name - Name object
	 * SSN - String representing the SSN of the new Depositor
	 * Process:
	 * Sets the Name to the Name passed in to the constructor
	 * Sets the SSN to the String passed in to the constructor
	 * Output:
	 * Creates a new Depositor object with a Name of name and SSN of SSN
	 */
	public genDepositor(Name name, String SSN) {
		//sets the parameters of the Depositor w/ the parameters passed in
		this.name = name;
		this.SSN = SSN;
	}
	
	/*Copy Constructor Depositor()
	 * Input:
	 * person - Depositor object
	 * Process:
	 * Sets the Name to the Name of the Depositor passed in to the constructor
	 * Sets the SSN to the SSN of the Depositor passed in to the constructor
	 * Output:
	 * Creates a new Depositor object with a Name of name and SSN of SSN
	 */
	public genDepositor(Depositor person) {
		//sets the parameters of the Depositor w/ the parameters passed in
		this.name = person.getName();
		this.SSN = person.getSSN();
	}
	
	public String toString() {
		return name.toString().concat(String.format("%8s", SSN));
	}
	
	public abstract boolean equals(Depositor person);
	public abstract Name getName();
	public abstract String getSSN();
	protected abstract void setName(Name name);
	protected abstract void setSSN(String str);
}
