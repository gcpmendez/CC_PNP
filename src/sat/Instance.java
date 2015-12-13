package sat;

import java.util.ArrayList;

public class Instance {
    private ArrayList<Clause> clauses;
    private ArrayList<String> literalNames;
    
    /** CONSTRUCTOR */
    public Instance() {
    	this.clauses = new ArrayList<Clause>();
    	this.literalNames = new ArrayList<String>();
    }
    
    /** METHODS */
    public String toString() {
    	// Literales
    	String U = "U = {";
    	String delim = "";
    	for (String s : literalNames) {
			U += delim + s;
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
	public ArrayList<String> getLiterals() {
		return literalNames;
	}
	public void setLiterals(ArrayList<String> literal) {
		this.literalNames = literal;
	}
    

    
}
