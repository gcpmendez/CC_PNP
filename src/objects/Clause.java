 /** 
  *  Asignatura: Complejidad Computacional
  *  Universidad de La Laguna.
  *  Curso: 2015-2016
  *  
  *  
  *  Autores: 
  * 	Germ�n Paz M�ndez
  * 		Contacto: alu0100503647@edu.ull.es
  * 	V�ctor Hern�ndez Perez
  * 		Contacto: alu0100697032@edu.ull.es
  * 	Jose Manuel Hern�ndez Hern�ndez
  * 		Contacto: alu0100775846@edu.ull.es
  */
package objects;

import java.util.ArrayList;

public class Clause {
	private ArrayList<Literal> literals;

	/**
	 * Constructs and empty clause.
	 */
	public Clause() {
		this.literals = new ArrayList<Literal>();
	}

	/**
	 * Constructs a copy of the specified clause.
	 */
	public Clause(Clause clause) {
		this.literals = new ArrayList<Literal>(clause.getLiterals());
	}

	/** METHODS */
	@Override
	public String toString() {
		String str = "{";
		String delim = "";
		for (Literal i : literals) {
			str += delim + i.toString();
			delim = ",";
		}
		return (str + "}");
	}

	/**
	 * Returns the number of literals (same as the number of variables) in the
	 * clause.
	 */
	public int numLiterals() {
		return this.literals.size();
	}

	public void addLiteral(Literal l) {
		this.literals.add(l);
	}

	/** GETTERS and SETTERS */
	public ArrayList<Literal> getLiterals() {
		return literals;
	}

	public void setLiterals(ArrayList<Literal> literalsSet) {
		this.literals = literalsSet;
	}

}
