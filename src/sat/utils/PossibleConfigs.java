package sat.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import sat.Literal;

/**
 * Clase que va devolviendo cada una de las posibles configuraciones de literales.
 * (Implementa la interfaz Enumeration, para poder hacer un "for").
 */
public class PossibleConfigs implements Enumeration<Config> {
    
    // Configuracion actual del ciclo.
    Config currentConfig;
    
    public PossibleConfigs(ArrayList<String> literalNames){
        
        // Construimos la configuracion inicial: todos los literales a false.
        currentConfig = new Config(literalNames);
    }
    
    @Override
    public boolean hasMoreElements() {
        // Si algun literal esta a false, se podra incrementar la configuracion
        // y por tanto existiran mas posibilidades (elementos).
        for (Boolean b : currentConfig.getRawValues()){
            if (b == false) return true;
        }
        // Todos los valores a true == 11111... == no hay mas posibilidades (elementos)! 
        return false;
    }

    @Override
    public Config nextElement() {
        try {
            currentConfig = currentConfig.returnSelfIncrement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentConfig;
    }
    
    /** Funcion interna que incrementa una configuracion para obtener otra nueva (ej: 011 -> 100) */
    private ArrayList<Boolean> aaaa(){
        // currentConfig.
        return new ArrayList<Boolean>();
    }
}
