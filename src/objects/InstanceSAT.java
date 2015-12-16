 /** 
  *  Asignatura: Complejidad Computacional
  *  Universidad de La Laguna.
  *  Curso: 2015-2016
  *  
  *  
  *  Autores: 
  * 	Germán Paz Méndez
  * 		Contacto: alu0100503647@edu.ull.es
  * 	Víctor Hernández Perez
  * 		Contacto: alu0100697032@edu.ull.es
  * 	Jose Manuel Hernández Hernández
  * 		Contacto: alu0100775846@edu.ull.es
  */
package objects;

import java.util.ArrayList;
import java.util.HashSet;

public class InstanceSAT {
	private ArrayList<Clause> clauses;
	private HashSet<String> literals;

	/** CONSTRUCTOR */
	public InstanceSAT() {
		this.clauses = new ArrayList<Clause>();
		this.literals = new HashSet<String>();
	}

	/** METHODS */
	@Override
	public String toString() {
		// Literales
		String U = "U = {";
		String delim = "";
		for (String s : literals) {
			U += delim + s;
			delim = ", ";
		}
		U += "}";

		// Clauses
		String C = "C = {";
		delim = "";
		for (Clause i : clauses) {
			C += delim + i.toString();
			delim = ", ";
		}
		C += "}";
		return (U + "\n" + C);
	}

	public void addClause(Clause c) {
		this.clauses.add(c);
	}

	public void addLiteral(String l) {
		this.literals.add(l);
	}
	
	public int numVariables() {
		return this.literals.size();
	}

	/** GETTERS and SETTERS */
	public ArrayList<Clause> getClauses() {
		return clauses;
	}

	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}

	public HashSet<String> getLiterals() {
		return literals;
	}

	public void setLiterals(HashSet<String> literal) {
		this.literals = literal;
	}

}
