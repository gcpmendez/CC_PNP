package SAT;

import java.util.ArrayList;

public class SATProblemInstance {
    private ArrayList<Clause> clauses;
    private ArrayList<Literals> literals;
    
    /*
     * Setters and getters.
     */
    
    public ArrayList<Clause> getClauses() {
        return clauses;
    }
    public void setClauses(ArrayList<Clause> clauses) {
        this.clauses = clauses;
    }
    public ArrayList<Literals> getLiterals() {
        return literals;
    }
    public void setLiterals(ArrayList<Literals> literals) {
        this.literals = literals;
    }
}
