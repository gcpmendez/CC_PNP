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
    public Config returnSelfIncrement(){
        int i = rawValues.size()-1; // Empezando desde el ultimo...
        while(i >= 0){
            // if()
            i--;
        }
        // for (int i = rawValues.size()-1; i >= 0; i--){
            
        // }
        return new Config(new ArrayList<String>());
    }
    
    /*
     * Getters y setters.
     * Solo existen getters y setters conjuntos para evitar disparidad de datos.
     */
    
    public Boolean get(String literalName){
        return rawValues.get(literals.indexOf(literalName));
    }
    
    public Boolean get(int index){
        return rawValues.get(index);
    }
}
