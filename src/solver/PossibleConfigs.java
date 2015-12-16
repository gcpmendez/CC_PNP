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
package solver;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que va devolviendo cada una de las posibles configuraciones de
 * literales. (Implementa la interfaz Iterable, para poder hacer un "for").
 */
public class PossibleConfigs implements Iterable<Config> {

	// Configuracion actual del ciclo.
	Config currentConfig;

	public PossibleConfigs(ArrayList<String> literalNames) {

		// Construimos la configuracion inicial: todos los literales a false.
		currentConfig = new Config(literalNames);
	}

	@Override
	public Iterator<Config> iterator() {
		return currentConfig;
	}
}
