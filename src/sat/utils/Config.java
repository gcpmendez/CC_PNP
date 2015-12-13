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
    
    ArrayList<String> literalNames;
    ArrayList<Boolean> rawValues;
    
    /** Constructor */
    public Config(ArrayList<String> literalNames){
        this.literalNames = literalNames;
        this.rawValues = new ArrayList<Boolean>();
        
        // A cada String, asignamos el valor false.
        for (String str : literalNames)
            rawValues.add(false);
    }
    
    /** Constructor 
     * @throws Exception */
    public Config(ArrayList<String> literals, ArrayList<Boolean> rawValues) throws Exception{
        if (literals.size() != rawValues.size()) 
            Sys.exception("Distinto numero de literales (%d) y raw values (%d)!", literals.size(), rawValues.size());
        this.literalNames = literals;
        this.rawValues = rawValues;
    }
    
    /*
     * Getters y setters.
     * Solo existen getters y setters conjuntos para evitar disparidad de datos.
     */
    
    public Boolean getValue(String literalName){
        return rawValues.get(literalNames.indexOf(literalName));
    }
}
