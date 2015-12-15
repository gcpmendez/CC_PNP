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

public class Literal {
	private String name; // Literal name
	private boolean negated; // negated?

	/** Constructor. */
	public Literal(String name, boolean negated) {
		this.name = name;
		this.negated = negated;
	}

	/** Constructor de copia. */
	public Literal(Literal other) {
		this(other.name, other.negated);
	}

	@Override
	public String toString() {
		String str = "";
		if (this.negated) {
			str += "!" + name;
		} else {
			str += name;
		}
		return str;
	}

	/** GETTERS and SETTERS */
	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public String getName() {
		return name;
	}
}
