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

import java.util.HashSet;

// El 3SAT es un caso particular de SAT.
public class Instance3SAT extends InstanceSAT {
	private boolean valid;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param literals
	 */
	public Instance3SAT(HashSet<String> literals) {
		this.valid = false;
		this.setLiterals(literals);
	}

	/** GETTERS and SETTERS */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isValid() {
		return valid;
	}
}
