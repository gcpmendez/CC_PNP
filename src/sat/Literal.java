package sat;

public class Literal {
    // Nombre del literal.
	private String name;
	
	// Si el literal esta negado o no.
	private boolean negated;
	
	/** Constructor. */
	public Literal(String name, boolean negated){
	    this.name = name;
	    this.negated = negated;
	}
	
	/** Constructor de copia. */
	public Literal(Literal other){
	    this(other.name, other.negated);
	}
	
	public String toString () {
		String str = "";
		if ( this.negated == true ) {
			str += "�" + name;
		} else {
			str += name;
		}
		return str;
	}
	
	/*
	 * Getters and setters.
	 */

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
