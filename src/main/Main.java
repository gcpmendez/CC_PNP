package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import sat.Instance;
import sat.utils.Loader;
import sat.utils.Solver;
import utils.Sys;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Cargamos Instancia SAT de un archivo.
		Instance inst = Loader.LoadInstanceFromFile("examples/SAT1example.txt");
		// Imprimimos instancia
    	Sys.out(inst);
		// Satisfactible?
    	Sys.out(Solver.solve(inst));
    	// inst.solve();
	}
	
}
