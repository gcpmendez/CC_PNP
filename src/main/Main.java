package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import sat.Instance;
import sat.utils.Loader;
import sat.utils.Solver;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Cargamos Instancia SAT de un archivo.
		Instance inst = Loader.LoadInstanceFromFile("examples/SAT1example.txt");
		// Imprimimos instancia
    	System.out.println(inst.toString());
		// Satisfactible?
    	Solver.solve(inst);
    	// inst.solve();
	}
	
}
