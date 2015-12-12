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
    	for (int i = 0; i < this.literals.size(); i++) {
			U += this.literals.get(i);
			if (i != this.literals.size()-1) { U += ", "; }
		}
    	U += "}";
    	
    	// Cla�sulas
    	String C = "C = {";
    	for (int i = 0; i < this.clauses.size(); i++) {
    		C += this.clauses.get(i).toString();
    		if (i != this.clauses.size()-1) { C += ", "; }
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
