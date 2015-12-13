package sat.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import sat.Literal;

/**
 * Clase que va devolviendo cada una de las posibles configuraciones de literales.
 * (Implementa la interfaz Enumeration, para poder hacer un "for").
 */
public class PossibleConfigs implements Enumeration<HashMap<String, Boolean>> {
    
    // Configuracion actual del ciclo.
    HashMap<String, Boolean> currentConfig;
    
    public PossibleConfigs(ArrayList<Literal> literals){
        
        // Construimos la configuracion inicial: todos los literales a false.
        currentConfig = new HashMap<String, Boolean>();
        for(Literal l : literals){
            currentConfig.put(l.getName(), false);
        }
    }
    
    @Override
    public boolean hasMoreElements() {
        // Si algun literal esta a false, se podra incrementar la configuracion
        // y por tanto existiran mas posibilidades (elementos).
        for (Boolean b : currentConfig.values()){
            if (b == false) return true;
        }
        // Todos los valores a true == 11111... == no hay mas posibilidades (elementos)! 
        return false;
    }

    @Override
    public HashMap<String, Boolean> nextElement() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /** Funcion interna que incrementa una configuracion para obtener otra nueva (ej: 011 -> 100) */
    private ArrayList<Boolean> aaaa(){
        // currentConfig.
        return new ArrayList<Boolean>();
    }
}
