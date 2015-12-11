package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import sat.Instance;

public class LoadSAT {

	/** MÉTODOS */
	public static void LoadSATofFile(String archivo,Instance instance) throws FileNotFoundException, IOException {
        String cadena;
        FileReader fileReader = new FileReader(archivo);		
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
    	// SALTAMOS COMENTARIOS INICIALES
    	cadena = bufferedReader.readLine();
    	while (cadena.charAt(0)=='#'){	// Si la cadena[0] contiene '#':
    		cadena = bufferedReader.readLine();		// Salto de linea
    	}
    	
    	// LINE 1: literals
    	String [] literalsSet = cadena.split(" ");		// Partimos cadena
	    
	    
	    // LINEA 7 Y SIGUIENTES: Delta (Transiciones)
	    while ((cadena = bufferedReader.readLine()) != null)   {
	    	
	    	partirCadena = cadena.split("#");
	    	partirCadena[0]= partirCadena[0].trim();
	    	String [] transicion = partirCadena[0].split(" ");
	    	
	    	// metemos en cada estado ya cargado su transicion
	    	if (maquinaTuring.posicionEstado(transicion[0]) != -1) {
	    		
	    		// Conseguimos el estado asociado 
	    		Estado estadoP = maquinaTuring.getEstado(maquinaTuring.posicionEstado(transicion[0]));
	    		
	    		// Creamos la transicion a añadir
	    		Transicion transP = new Transicion( transicion[1] + ";" 
	    											+ transicion[3] + ";" 
													+ transicion[4], 
													transicion[2]);
	    		
	    		// Añadimos la transicion al estado
	    		estadoP.agregarTransicion(transP);
	    		
	    	}
		    
	    }	
	    
        bufferedReader.close();
    }
}
