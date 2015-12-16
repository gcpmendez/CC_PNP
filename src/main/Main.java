package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import objects.Instance3SAT;
import objects.InstanceSAT;
import objects.InstanceVC;
import solver.Solver;
import transform.To3SAT;
import transform.ToVC;
import utils.Loader;
import utils.Sys;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Cargamos Instancia SAT de un archivo.
		System.out.println("----- Fichero de carga -----");
		InstanceSAT inst = Loader.LoadInstanceFromFile("examples/SAT1example.txt");
		
		// Imprimimos instancia SAT
		System.out.println("\n----- Instancia SAT -----");
		Sys.out(inst);
		
		// SAT Satisfactible?
		System.out.println("\n----- � Satisfacibilidad ? -----");
		Solver.solve(inst);
		
		// transform to 3sat
		System.out.println("\n----- SAT to 3SAT -----");
		Instance3SAT inst3 = To3SAT.to3SAT(inst);
		
		// Imprimimos instancia 3SAT
        System.out.println("\n----- Instancia 3SAT -----");
        Sys.out(inst);
		
		// 3SAT Satisfactible?
        System.out.println("\n----- � Satisfacibilidad ? -----");
        Solver.solve(inst3);
        
        // transform to vc
        System.out.println("\n----- SAT to 3SAT -----");
        InstanceVC instVC = ToVC.toVC(inst3);
        
        // Imprimimos instancia VC
        System.out.println("\n----- Instancia VC -----");
        Sys.out(instVC);
        
        // 3SAT Satisfactible?
        System.out.println("\n----- � Satisfacibilidad ? -----");
        instVC.solve();
	}

}
