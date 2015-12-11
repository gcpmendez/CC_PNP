package sat;

public class Literals {
	private String literal;
	private boolean negate;
	
	/** METHODS */
	public String toString () {
		if ( this.negate == true ) {
			return ("¬" + literal);
		} else {
			return literal;
		}
	}
	
	/** GETTERS and SETTERS */
	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public boolean isNegate() {
		return negate;
	}

	public void setNegate(boolean negate) {
		this.negate = negate;
	}


}
