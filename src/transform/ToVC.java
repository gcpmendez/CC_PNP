package transform;

import java.util.ArrayList;
import java.util.HashMap;

import objects.Clause;
import objects.Instance3SAT;
import objects.InstanceVC;
import objects.Literal;

public class ToVC {
    public static InstanceVC toVC(Instance3SAT inst3SAT) {
        ArrayList<String> V = new ArrayList<String>(); 
        HashMap<String,String> E = new HashMap<String,String>();
        
        // Por cada literal del 3SAT.
        for (String literalName : inst3SAT.getLiterals()){
            // Creamos nodo con su nombre y el opuesto.
            V.add(literalName);
            V.add("!" + literalName);
            // Los unimos.
            E.put(literalName, "!" + literalName);
        }
        
        Integer i = 0;
        // Por cada clausula del 3SAT.
        for (Clause clause : inst3SAT.getClauses()){
            // Para diferenciar nodos de distintas clausulas.s
            String prefix = i.toString() + "_";
            
            ArrayList<Literal> literals = clause.getLiterals();
            String[] litNames = new String[3];
            for (int j = 0; j < 3; j++){
                // Creamos nombre de nodo
                litNames[j] = literals.get(0).isNegated() ? "!" : "";
                litNames[j] += literals.get(j).toString();
                
                // Guardamos nodo
                V.add(prefix + litNames[j]);
            }
            
            // Creamos union de triangulo
            E.put(prefix + litNames[0], prefix + litNames[1]);
            E.put(prefix + litNames[1], prefix + litNames[2]);
            E.put(prefix + litNames[2], prefix + litNames[0]);

            // Unimos cada triangulo a su correspondiente nodo-literal
            E.put(prefix + litNames[0], litNames[0]);
            E.put(prefix + litNames[1], litNames[1]);
            E.put(prefix + litNames[2], litNames[2]);
            
            i++;
        }
        
        // Calculamos el valor k de la instancia de Vertex Cover.
        int m = inst3SAT.getLiterals().size();
        int l = inst3SAT.getLiterals().size();
        int k = m + 2*l;
        
        // Creamos instancia.
        return new InstanceVC(V,E,k);
    }
}
