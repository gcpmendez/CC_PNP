package objects;

import java.util.ArrayList;

// El 3SAT es un caso particular de SAT.
public class Instance3SAT extends InstanceSAT {
	private boolean valid;
	
	/** CONSTRUCTOR 
	 * @param literals */
	public Instance3SAT(ArrayList<String> literals) {
		this.valid = false;
		this.setLiterals(literals);
	}

	/** GETTERS and SETTERS */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public boolean isValid() {
		return valid;
	}
}
