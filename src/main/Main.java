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
package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import objects.Instance3SAT;
import objects.InstanceSAT;
import solver.Solver;
import transform.To3SAT;
import utils.Loader;
import utils.Sys;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Cargamos Instancia SAT de un archivo.
		System.out.println("----- Fichero de carga -----");

		InstanceSAT inst = Loader.LoadInstanceFromFile("examples/To3SATcase4b.txt");
		// Imprimimos instancia

		System.out.println("\n----- Instancia SAT -----");
		Sys.out(inst);
		
		// SAT Satisfactible?
		System.out.println("\n----- ï¿½ Satisfacibilidad ? -----");
		Solver.solve(inst);
		
		// transform to 3sat
		System.out.println("\n----- SAT to 3SAT -----");
		Instance3SAT inst3 = To3SAT.to3SAT(inst);
		
		// Imprimimos instancia 3SAT
        System.out.println("\n----- Instancia 3SAT -----");
        Sys.out(inst);
		
		// 3SAT Satisfactible?
        System.out.println("\n----- ï¿½ Satisfacibilidad ? -----");
        Solver.solve(inst3);
	}

}
