public class Depositor extends genDepositor{
	//definition of instance fields
	/*
	 * private Name name; private String SSN;
	 */
			
			public Depositor() {
				super();
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
			public Depositor(Name name, String SSN) {
				//sets the parameters of the Depositor w/ the parameters passed in
				super(name, SSN);
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
			public Depositor(Depositor person) {
				//sets the parameters of the Depositor w/ the parameters passed in
				super(person);
			}
			
			public boolean equals(Depositor person) {
				if (getName().equals(person.getName()) && getSSN().equals(person.getSSN())) {
					return true;
				}
				return false;
			}
			
			/*
			 * public String toString() { return
			 * getName().toString().concat(String.format("%8s", getSSN())); }
			 */
			
			/*Method getName()
			 * Input: none
			 * Process:
			 * returns the Name of the Depositor
			 * Output:
			 * returns the Name of the Depositor
			 */
			public Name getName() {
				//returns the name
				return new Name(name);
			}
			
			/*Method getSSN()
			 * Input: none
			 * Process:
			 * returns the SSN of the Depositor
			 * Output:
			 * returns the SSN of the Depositor
			 */
			public String getSSN() {
				//returns the SSN
				return SSN;
			}
			
			/*Method setName()
			 * Input:
			 * name - the Name object that will replace the Depositor's current Name
			 * Process:
			 * sets the Name of the Depositor to the Name passed in to the method
			 * Output:
			 * sets the Name of the Depositor to the Name passed in to the method
			 */
			protected void setName(Name name) {
				//sets the Name w/ the passed in parameter
				this.name = name;
			}
			
			/*Method setSSN()
			 * Input:
			 * SSN - the SSN object that will replace the Depositor's current Name
			 * Process:
			 * sets the SSN of the Depositor to the SSN passed in to the method
			 * Output:
			 * sets the SSN of the Depositor to the SSN passed in to the method
			 */
			protected void setSSN(String SSN) {
				//sets the SSN with the passed in parameter
				this.SSN = SSN;
			}
}
