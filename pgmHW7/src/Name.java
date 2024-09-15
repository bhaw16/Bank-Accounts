public class Name extends genName{
	//definition of instance fields
	/*
	 * private String first; private String last;
	 */
			
			public Name() {
				super();
			}
			
			/*Constructor Name()
			 * Input:
			 * first - String representing first name
			 * last - String representing last name
			 * Process:
			 * Sets the first name to the first String passed to the constructor
			 * Sets the last name to the second String passed to the constructor
			 * Output:
			 * Creates a New Name object with a first and last name of the String passed in to the constructor
			 */
			public Name(String first, String last) {
				//sets the parameters of the Name w/ the parameters passed in
				super(first, last);
			}
			
			/*Copy Constructor Name()
			 * Input:
			 * Name - name object
			 * Process:
			 * Sets the first name to the first name of the Name passed to the constructor
			 * Sets the last name to the last name of the Name passed to the constructor
			 * Output:
			 * Creates a New Name object with a first and last name of the String passed in to the constructor
			 */
			public Name(Name name) {
				//sets the parameters of the Name w/ the parameters passed in
				super(name);
			}
			
			/*
			 * public String toString() { //return String.format("%-20s%-20s",
			 * getLastName(), getFirstName()); return super.toString(); }
			 */
			
			public boolean equals(Name name) {
				if (getFirstName().equals(name.getFirstName()) && getLastName().equals(name.getLastName())) {
					return true;
				}
				return false;
			}
			
			/*Method getFirstName()
			 * Input: none
			 * Process:
			 * returns the first name of the Name
			 * Output:
			 * returns the first name of the Name
			 */
			public String getFirstName() {
				//returns the first name
				return first;
			}
			
			/*Method getLastName()
			 * Input: none
			 * Process:
			 * returns a new last name with the same content of the current last name
			 * Output:
			 * returns a new last name with the same content of the current last name
			 */
			public String getLastName() {
				//returns the last name
				return last;
			}
			
			/*Method setFirstName()
			 * Input:
			 * newFirst - the String that will replace the current first name
			 * Process:
			 * sets the first name of the Name to the String passed in to the method
			 * Output:
			 * sets the first name of the Name to the String passed in to the method
			 */
			protected void setFirstName(String newFirst) {
				//sets the first name w/ passed in parameter
				first = newFirst;
			}
			
			/*Method setLastName()
			 * Input:
			 * newLast - the String that will replace the current last name
			 * Process:
			 * sets the first name of the Name to the String passed in to the method
			 * Output:
			 * sets the first name of the Name to the String passed in to the method
			 */
			protected void setLastName(String newLast) {
				//sets the last name w/ passed in parameter
				last = newLast;
			}
}
