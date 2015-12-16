package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import solver.Config;
import solver.PossibleConfigs;

public class InstanceVC {
	private ArrayList<String> V;
	private HashMap<String, String> E;
	private Integer k;
	
	public InstanceVC(ArrayList<String> V, HashMap<String, String> E, int k) {
		this.V = V;
		this.E = E;
		this.k = k;
	}

	public boolean solve(){

	    // Probamos a fuerza bruta todas las combinaciones posibles.
	    PossibleConfigs pc = new PossibleConfigs(this.V);
	    for (Config c : pc){
	        // Creamos una lista de los nodos del cover.
	        ArrayList<String> vertexCover = new ArrayList<String>();
	        // Agregamos los que esten a true en esta configuracion.
	        for (String str : this.V)
	            if (c.getValue(str)) vertexCover.add(str);
	        // Probamos suerte: que el cover cumpla las condiciones.
	        if (isMinimumVertexCover(vertexCover)) return true;
	    }
	    
	    // Si tras probar todas las configuraciones, ninguna vale, no hay solucion.
	    return false;
	}
	
	public boolean isMinimumVertexCover(ArrayList<String> vertexCover){
	    // El # nodos debe ser menor o igual que el valor k.
	    if (vertexCover.size() > k) return false;
	    // Tambien debera de cubrir todas las aristas del grafo.
	    return isVertexCover(vertexCover);
	}
	
	/** El subconjunto de nodos que se pasa es un vertex cover. */
	public boolean isVertexCover(ArrayList<String> vertexCover){
	    for (Map.Entry<String, String> edge : E.entrySet()) {
	        if (!vertexCover.contains(edge.getKey()) && !vertexCover.contains(edge.getValue()))
	            return false; // nodosCover debe de tener 1 o 2 nodos de cada vertice.
	    }
	    
	    return true;
	}
	
	public String toString(){
	    String str = "";
	    str += String.format("V=%s", V.toString());
	    str += String.format("\nE=%s", E.toString());
	    str += String.format("\nk=%s", k.toString());
	    
	    return str;
	}
}
