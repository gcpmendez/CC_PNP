package sat;

import java.util.ArrayList;

public class Instance {
    private ArrayList<Clause> clauses;
    private ArrayList<Literal> literals;
    
    /** CONSTRUCTOR */
    public Instance() {
    	this.clauses = new ArrayList<Clause>();
    	this.literals = new ArrayList<Literal>();
    }
    
    /** METHODS */
    public String toString() {
    	// Literales
    	String U = "U = {";
    	String delim = "";
    	for (Literal i: literals) {
			U += delim + i.toString();
			delim = ", "; 
		}
    	U += "}";
    	
    	// Clauses
    	String C = "C = {";
    	delim = "";
    	for (Clause i: clauses) {
    		C += delim + i.toString();
    		delim = ", "; 
		}
    	C += "}";
    	return (U + "\n" + C);
    }
    
    /** GETTERS and SETTERS */
	public ArrayList<Clause> getClauses() {
		return clauses;
	}
	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}
	public ArrayList<Literal> getLiterals() {
		return literals;
	}
	public void setLiterals(ArrayList<Literal> literal) {
		this.literals = literal;
	}
    

    
}
