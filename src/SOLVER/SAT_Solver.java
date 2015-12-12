package SOLVER;

import java.util.ArrayList;
import java.util.HashMap;

import SAT.Literal;
import SAT.SATProblemInstance;

public abstract class SAT_Solver {
    
    static public boolean isSatisfiable(SATProblemInstance prob){
        
        // Numero total de literales en la instancia.
        int literalsNum = prob.getLiterals().size();
        
        // Primera configuracion posible, que cambiaremos para ir probando
        ArrayList<Literal> literalConfiguration = new ArrayList<Literal>();
        
        // Construimos la configuracion inicial y la final de variables
        for (int i =0; i < literalsNum; i++){
            literalConfiguration.add(new Literal(prob.getLiterals().get(i)));
        }
        
        // Para cada configuracion posible de las variables...
        boolean stop = false;
        while(!stop){
            break;  // TODO: esto pa que german no se queje xd
        }
        
        return false;
    }

    private boolean getValueOfLiteral(Literal literal, HashMap<String, Boolean> literalConfiguration){
        boolean rawValue = literalConfiguration.get(literal.getName());
        if (literal.isNegated()){
            return !rawValue;
        } else return rawValue;
    }
}
