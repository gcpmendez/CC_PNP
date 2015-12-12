package sat;

import java.util.ArrayList;

public class Instance {
    private ArrayList<Clause> clauses;
    private ArrayList<Literal> literal;
    
    /** CONSTRUCTOR */
    public Instance() {
    	this.clauses = new ArrayList<Clause>();
    	this.literal = new ArrayList<Literal>();
    }
    
    /** METHODS */
    public String toString() {
    	// Literales
    	String U = "U = {";
    	for (int i = 0; i < this.literal.size(); i++) {
			U += this.literal.get(i).getLiteral();
			if (i != this.literal.size()-1) { U += ", "; }
		}
    	U += "}";
    	
    	// Claúsulas
    	String C = "C = {";
    	for (int i = 0; i < this.clauses.size(); i++) {
    		C += this.clauses.get(i).toString();
    		if (i != this.clauses.size()-1) { C += ", "; }
		}
    	C += "}";
    	return (U + "\n" + C);
    }
    
    public void solve() {
    	boolean result = true;
    	for (int i = 0; i < clauses.size(); i++) {
    		for (int j = 0; j < clauses.get(i).getLiteralsSet().size(); j++) {
    				// Busqueda del valor booleano del literal
    				for (int j2 = 0; j2 < literal.size(); j2++) {
						if(clauses.get(i).getLiteralsSet().get(j).toString() == literal.get(j2).getLiteral()){
							if (j == 0) {
			    				result = clauses.get(i).getLiteralsSet().get(j).isNegate();
							} else {
			    				result = result || clauses.get(i).getLiteralsSet().get(j).isNegate();
			    			}
						}
					}
			}
    		System.out.println(result);
		}
    }
    
    /** GETTERS and SETTERS */
	public ArrayList<Clause> getClauses() {
		return clauses;
	}
	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}
	public ArrayList<Literal> getLiteral() {
		return literal;
	}
	public void setLiteral(ArrayList<Literal> literal) {
		this.literal = literal;
	}
    

    
}
