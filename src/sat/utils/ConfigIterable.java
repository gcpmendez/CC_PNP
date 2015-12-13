package sat.utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  Config que ademas te dice cual es el siguiente config, y si lo hay o no.
 *  
 *  Necesaria para poder utilizar la clase PossibleConfigs, que nos permite
 *  iterar por todas las configuraciones posibles de unos literales dados.
 */
public class ConfigIterable extends Config implements Iterator<Config>{

    public ConfigIterable(ArrayList<String> literalNames) {
        super(literalNames);
    }

    public ConfigIterable(ArrayList<String> literalNames, ArrayList<Boolean> rawValues) throws Exception {
        super(literalNames, rawValues);
    }

    @Override
    public boolean hasNext() {
        // Si algun literal esta a false, se podra incrementar la configuracion
        // y por tanto existiran mas posibilidades (elementos).
        for (Boolean b : rawValues){
            if (b == false) return true;
        }
        // Todos los valores a true == 11111... == no hay mas posibilidades (elementos)! 
        return false;
    }

    @Override
    public ConfigIterable next() {
        try {
            return returnSelfIncrement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    
    /** Devuelve una version incrementada de si misma */
    private ConfigIterable returnSelfIncrement() throws Exception{
        ArrayList<Boolean> newRawValues = this.rawValues;
        int i = newRawValues.size()-1;  // Nos ponemos al final.
        
        // Vamos de derecha a izquierda (<<--).
        while(i >= 0){
            // Ignoramos los 1s, pero paramos si encontramos un 0.
            if(newRawValues.get(i) == false) break;
            i--;
        }
        
        // Nos quedamos en el primer 0 desde la derecha. Lo cambiamos a 1.
        newRawValues.set(i, true);
        
        // Vamos de izquierda a derecha (-->>).
        while (i < newRawValues.size()){
            // Convertimos a 0s todos los 1s que antes ignoramos.
            newRawValues.set(i, false);
            i++;
        }
        
        return new ConfigIterable(this.literalNames, newRawValues);
    }
}
