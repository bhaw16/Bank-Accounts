public abstract class genName {
	//definition of instance fields
	protected String first;
	protected String last;
	
	public genName() {
		first = "";
		last = "";
	}
	
	/*Constructor genName()
	 * Input:
	 * first - String representing first name
	 * last - String representing last name
	 * Process:
	 * Sets the first name to the first String passed to the constructor
	 * Sets the last name to the second String passed to the constructor
	 * Output:
	 * Creates a New Name object with a first and last name of the String passed in to the constructor
	 */
	public genName(String first, String last) {
		//sets the parameters of the Name w/ the parameters passed in
		this.first = first;
		this.last = last;
	}
	
	/*Copy Constructor genName()
	 * Input:
	 * Name - name object
	 * Process:
	 * Sets the first name to the first name of the Name passed to the constructor
	 * Sets the last name to the last name of the Name passed to the constructor
	 * Output:
	 * Creates a New Name object with a first and last name of the String passed in to the constructor
	 */
	public genName(Name name) {
		//sets the parameters of the Name w/ the parameters passed in
		this.first = name.getFirstName();
		this.last = name.getLastName();
	}
	
	public String toString() {
		return String.format("%-20s%-20s", last, first);
	}
	
	public String getNameString() {
		return String.format("%-15s%-15s", first, last);
	}
	
	public abstract boolean equals(Name name);
	public abstract String getFirstName();
	public abstract String getLastName();
	protected abstract void setFirstName(String first);
	protected abstract void setLastName(String first);
}
