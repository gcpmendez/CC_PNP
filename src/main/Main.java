package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import sat.Instance;
import utils.LoadSAT;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Creamos una instancia a cargar
		Instance inst = new Instance();
		// Cargamos SAT
		LoadSAT.LoadSATofFile("src/examples/SAT1example.txt", inst);
		// Imprimimos instancia
    	System.out.println(inst.toString());
		// Satisfactible?
    	inst.solve();
	}
	
}
