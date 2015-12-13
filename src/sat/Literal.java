package sat;

public class Literal {
	private String name;		// Literal name
	private boolean negated;	// negated?
	
	/** Constructor. */
	public Literal(String name, boolean negated){
	    this.name = name;
	    this.negated = negated;
	}
	
	/** Constructor de copia. */
	public Literal(Literal other){
	    this(other.name, other.negated);
	}
	
	@Override
	public String toString () {
		String str = "";
		if ( this.negated == false ) {
			str += "!" + name;
		} else {
			str += name;
		}
		return str;
	}

	/** GETTERS and SETTERS*/
    public boolean isNegated() {
        return negated;
    }

    public void setNegated(boolean negated) {
        this.negated = negated;
    }

    public String getName() {
        return name;
    }
}
