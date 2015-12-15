package objects;

// El 3SAT es un caso particular de SAT.
public class Instance3SAT extends InstanceSAT {
	private boolean valid;
	
	/** CONSTRUCTOR */
	public Instance3SAT() {
		this.valid = false;
	}

	/** GETTERS and SETTERS */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public boolean isValid() {
		return valid;
	}
}
