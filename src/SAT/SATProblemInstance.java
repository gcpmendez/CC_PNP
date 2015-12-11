package SAT;

import java.util.ArrayList;

public class SATProblemInstance {
    private ArrayList<Clause> clauses;
    private ArrayList<Literal> literal;
    
    /*
     * Setters and getters.
     */
    
    public ArrayList<Clause> getClauses() {
        return clauses;
    }
    public void setClauses(ArrayList<Clause> clauses) {
        this.clauses = clauses;
    }
    public ArrayList<Literal> getLiterals() {
        return literal;
    }
    public void setLiterals(ArrayList<Literal> literal) {
        this.literal = literal;
    }
}
