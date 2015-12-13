package sat.utils;

import java.util.ArrayList;

import sat.Literal;
import utils.Sys;

/**
 * Configuracion de literales.
 *
 * No puede ser solo un HashMap<Literal, Boolean>
 * porque necesitamos poder incrementar de una configuracion a la siguiente.
 * 
 * No puede ser solo un ArrayList<Literal> o ArrayList<Boolean>
 * porque necesitamos poder pasarle un literal y que devuelva un booleano.
 */
public class Config {
    
    ArrayList<String> literals;
    ArrayList<Boolean> rawValues;
    
    /** Constructor */
    public Config(ArrayList<String> literals){
        this.literals = literals;
        this.rawValues = new ArrayList<Boolean>();
        
        // A cada String, asignamos el valor false.
        for (String str : literals)
            rawValues.add(false);
    }
    
    /** Constructor 
     * @throws Exception */
    public Config(ArrayList<String> literals, ArrayList<Boolean> rawValues) throws Exception{
        if (literals.size() != rawValues.size()) 
            Sys.exception("Distinto numero de literales (%d) y raw values (%d)!", literals.size(), rawValues.size());
        this.literals = literals;
        this.rawValues = rawValues;
    }
    
    
    /** Devuelve una version incrementada de si misma */
    public Config returnSelfIncrement() throws Exception{
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
        
        return new Config(this.literals, newRawValues);
    }
    
    /*
     * Getters y setters.
     * Solo existen getters y setters conjuntos para evitar disparidad de datos.
     */
    
    public Boolean getValue(String literalName){
        return rawValues.get(literals.indexOf(literalName));
    }
}
