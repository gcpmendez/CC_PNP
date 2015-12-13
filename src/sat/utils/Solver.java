package sat.utils;

import java.util.ArrayList;
import java.util.HashMap;

import sat.Clause;
import sat.Instance;
import sat.Literal;

public abstract class Solver {
    
    static public boolean solve(Instance prob){
        // Construimos tabla de valores a probar
        
        ArrayList<String> literalNames = new ArrayList<String>();
        for(Literal l : prob.getLiterals())
            literalNames.add(l.getName());
        
        PossibleConfigs possibleConfigs = new PossibleConfigs(literalNames);
        // for (Config c : possibleConfigs){
            
        // }
        return false; // Ninguna de las configuraciones devuelve true: el problema no es satisfactible.
    }
    
    /**
     * @param clauses Conjunto de clausulas a probar.
     * @param config Configuracion de valores de literales (cada literal a true o false).
     * @return Si todas las clausulas se cumplen para esta configuracion.
     */
    static private boolean tryClauses(ArrayList<Clause> clauses, HashMap<String, Boolean> config){
        for(Clause c : clauses){
            // Con tal de que un literal sea falso, la condicion no se cumple.
            // (Esto es porque en una problema SAT todas las clausulas estan unidas mediante AND).
            if (trySingleClause(c, config) == true) return false; 
        }
        return true; // Todas las clausulas devuelven true: la configuracion satisface el problema.
    }
    
    /**
     * @param prob Problema SAT.
     * @param config Configuracion de valores de literales (cada literal a true o false).
     * @return Si todas las clausulas se cumplen para esta configuracion.
     */
    static private boolean trySingleClause(Clause clause, HashMap<String, Boolean> config){
        for(Literal l : clause.getLiteralsSet()){
            // Con tal de que un literal sea verdadero, la clausula se cumple.
            // (Esto es porque en una clausula todos los literales estan unidos mediante OR).
            if (getLiteralValue(l, config) == true) return true; 
        }
        return false; // Ninguno de los literales devuelve true: la clausula no se cumple.
    }
    
    /** Obtener el valor real del literal, sabiendo la configuracion actual y si esta negado o no. */
    static private boolean getLiteralValue(Literal literal, HashMap<String, Boolean> config){
        // Obtenemos el valor real del literal de la tabla de valores (tambien llamada configuracion).
        boolean rawValue = config.get(literal.getName());
        
        // Según esté negado o no, daremos el valor invertido o el real.
        if (literal.isNegated()){
            return !rawValue;   // Devolvemos valor invertido.
        } else {
            return rawValue;    // Devolvemos valor real.
        }
    }
}
