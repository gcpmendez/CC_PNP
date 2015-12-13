package sat.utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que va devolviendo cada una de las posibles configuraciones de literales.
 * (Implementa la interfaz Iterable, para poder hacer un "for").
 */
public class PossibleConfigs implements Iterable<Config> {
    
    // Configuracion actual del ciclo.
    ConfigIterable currentConfig;
    
    public PossibleConfigs(ArrayList<String> literalNames){
        
        // Construimos la configuracion inicial: todos los literales a false.
        currentConfig = new ConfigIterable(literalNames);
    }

    @Override
    public Iterator<Config> iterator() {
        return currentConfig;
    }
}
