package SAT;

public class Literal {
    // Nombre del literal
	private String name;
	// Si el literal esta negado
	private boolean negated;
	// Valor que esta tomando (antes de ser negada o no)
	private boolean rawValue;
	
	public Literal(String name, boolean negated, boolean rawValue){
	    this.name = name;
	    this.negated = negated;
	    this.rawValue = rawValue;
	}
	
	/**
	 * Si al crear no se pasa valor inicial, se asume true.
	 */
	public Literal(String name, boolean negated){
        this(name, negated, true);
    }
	
	/**
	 * Constructor de copia.
	 */
	public Literal(Literal other){
	    this(other.name, other.negated, other.rawValue);
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

    public boolean isRawValue() {
        return rawValue;
    }

    public void setRawValue(boolean rawValue) {
        this.rawValue = rawValue;
    }

    public String getName() {
        return name;
    }
}
