package solvers;

import java.util.ArrayList;

import objects.Clause;
import objects.Literal;
import objects.InstanceSAT;
import utils.Sys;

public abstract class Solver {
    
    static public boolean solve(InstanceSAT prob){
        // Construimos tabla de valores a probar
        
        ArrayList<String> literalNames = new ArrayList<String>();
        for(String ln : prob.getLiterals())
            literalNames.add(ln);
        
        PossibleConfigs possibleConfigs = new PossibleConfigs(literalNames);
        for (Config c : possibleConfigs){
            // Con tal de que una configuracion satisfaga el problema, el problema es satisfactible.
            // (Esto es porque en una problema SAT sólo se necesita una configuración de valores válida).
            Sys.fout("Para CONFIG = %s...", c);
            if (tryClauses(prob.getClauses(), c) == true){
                Sys.out("Satisface todas las clausulas! El problema ES SATISFACTIBLE. (BREAK)");
                return true;
            } else {
                Sys.out("No satisface todas las clausulas.");
            };
        }
        Sys.fout("Ninguna configuración vale! El problema NO ES SATISFACTIBLE.");
        return false; // Ninguna de las configuraciones devuelve true: el problema no es satisfactible.
    }
    
    /**
     * @param clauses Conjunto de clausulas a probar.
     * @param config Configuracion de valores de literales (cada literal a true o false).
     * @return Si todas las clausulas se cumplen para esta configuracion.
     */
    static private boolean tryClauses(ArrayList<Clause> clauses, Config config){
        String level = "\t"; // Nivel de indentacion de chivato.
        boolean showLevel = false; // Activar o no el chivato de este nivel.
        
        for(Clause c : clauses){
            if (showLevel) Sys.fout("%sPara CLAUSE = %s...", level, c);
            // Con tal de que un literal sea falso, la condicion no se cumple.
            // (Esto es porque en una problema SAT todas las clausulas estan unidas mediante AND).
            if (trySingleClause(c, config) == false){
                if (showLevel) Sys.out(level,"No se cumple! Esta configuracion no satisface todas las clausulas. (BREAK)");
                return false;
            } else {
                if (showLevel) Sys.out(level,"Se cumple.");
            }
        }
        Sys.fout("\tTodas las clausulas se cumplen.");
        return true; // Todas las clausulas devuelven true: la configuracion satisface el problema.
    }
    
    /**
     * @param prob Problema SAT.
     * @param config Configuracion de valores de literales (cada literal a true o false).
     * @return Si todas las clausulas se cumplen para esta configuracion.
     */
    static private boolean trySingleClause(Clause clause, Config config){
        String level = "\t\t"; // Nivel de indentacion de chivato.
        boolean showLevel = false; // Activar o no el chivato de este nivel.
        
        for(Literal l : clause.getLiterals()){
            if (showLevel) Sys.fout("%sPara LITERAL = %s...", level, l);
            // Con tal de que un literal sea verdadero, la clausula se cumple.
            // (Esto es porque en una clausula todos los literales estan unidos mediante OR).
            if (getLiteralValue(l, config) == true){
                if (showLevel) Sys.out(level,"Da TRUE! Se satisface la clausula. (BREAK)");
                return true; 
            } else {
                if (showLevel) Sys.out(level,"Da FALSE.");
            }
        }
        return false; // Ninguno de los literales devuelve true: la clausula no se cumple.
    }
    
    /** Obtener el valor real del literal, sabiendo la configuracion actual y si esta negado o no. */
    static private boolean getLiteralValue(Literal literal, Config config){
        // Obtenemos el valor real del literal de la tabla de valores (tambien llamada configuracion).
        boolean rawValue = config.getValue(literal.getName());
        
        // Según esté negado o no, daremos el valor invertido o el real.
        if (literal.isNegated()){
            return !rawValue;   // Devolvemos valor invertido.
        } else {
            return rawValue;    // Devolvemos valor real.
        }
    }
}
