package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import objects.Instance3SAT;
import objects.InstanceSAT;
import solvers.Solver;
import transforms.To3SAT;
import utils.Loader;
import utils.Sys;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Cargamos Instancia SAT de un archivo.
    	System.out.println("----- Fichero de carga -----");
        InstanceSAT inst = Loader.LoadInstanceFromFile("examples/SAT1example.txt");
        // Imprimimos instancia
        System.out.println("\n----- Instancia SAT -----");
        Sys.out(inst);
        // Satisfactible?
        System.out.println("\n----- ¿ Satisfacibilidad ? -----");
        Solver.solve(inst);
        // transform to 3sat
        System.out.println("\n----- SAT to 3SAT -----");
        Instance3SAT inst3 = new Instance3SAT(null);
        inst3 = To3SAT.to3SAT(inst);
        System.out.println(inst3.toString());
    }
    
}
