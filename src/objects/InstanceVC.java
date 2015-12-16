package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utils.Sys;

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
	    ArrayList<String> cover = new ArrayList<String>();
	    
	    // PossibleConfigs pc = 
	    
	    return false;
	}
	
	/** El subconjunto de nodos que se pasa es un vertex cover. */
	public boolean isCover(ArrayList<String> vertexCover){
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
