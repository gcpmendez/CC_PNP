package solver;

import java.util.ArrayList;
import java.util.Iterator;

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
public class Config implements Iterator<Config>{
    
    ArrayList<String> literalNames;
    ArrayList<Boolean> rawValues;
    
    /*
     * CONSTRUCTORES
     */
    
    /** Constructor */
    public Config(ArrayList<String> literalNames){
        this.literalNames = literalNames;
        //this.rawValues = new ArrayList<Boolean>();
        this.rawValues = null;
        
        // A cada String, asignamos el valor false.
        //for (String str : literalNames)
        //    rawValues.add(false);
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
     * METODOS DE ITERABLE
     */
    
    @Override
    public boolean hasNext() {
        // Caso especial: La config actual acaba de ser creada y es null.
        if (this.rawValues == null) return true;
        // Si algun literal esta a false, se podra incrementar la configuracion
        // y por tanto existiran mas posibilidades (elementos).
        for (Boolean b : rawValues){
            if (b == false) return true;
        }
        // Todos los valores a true == 11111... == no hay mas posibilidades (elementos)! 
        return false;
    }

    @Override
    public Config next() {
        try {
            return this.returnSelfIncrement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /** Devuelve una version incrementada de si misma */
    private Config returnSelfIncrement() throws Exception{
        // Caso especial: La config actual acaba de ser creada y es null.
        // Creamos la verdadera configuracion inicial, con valores a 0.
        if (this.rawValues == null){
          this.rawValues = new ArrayList<Boolean>();
          for (String str : literalNames)
              rawValues.add(false);
          return this;
        }
        
        // Hacemos una copia de los valores raw, que usaremos.
        ArrayList<Boolean> newRawValues = this.rawValues;
        // Nos ponemos al final.
        int i = newRawValues.size()-1;
        
        // Primero, vamos de derecha a izquierda (<<--).
        while(i >= 0){
            // Ignoramos los 1s, pero paramos si encontramos un 0.
            if(newRawValues.get(i) == false) break;
            i--;
        }
        
        // Nos quedamos en el primer 0 desde la derecha. Lo cambiamos a 1.
        newRawValues.set(i, true);
        i++; // Y nos movemos a la derecha.
        
        // Ahora, vamos de izquierda a derecha (-->>).
        while (i < newRawValues.size()){
            // Convertimos a 0s todos los 1s que antes ignoramos.
            newRawValues.set(i, false);
            i++;
        }
        
        return new Config(this.literalNames, newRawValues);
    }
    
    /*
     * METODOS OBJECT
     */
    
    public String toString(){
        String str = "[";
        for (int i = 0; i < literalNames.size(); i++){
            if(i > 0) str += ", ";
            String rawValue = rawValues.get(i).toString();
            rawValue = rawValues.get(i) ? "1" : "0";    // Comentar si se quiere true/false en vez de 1/0.
            str += String.format("%s= %s", literalNames.get(i), rawValue);   
        }
        str += "]";
        return str;
    }
    
    /*
     * GETTERS Y SETTERS.
     * Solo existen getters y setters conjuntos para evitar disparidad de datos.
     */
    
    public Boolean getValue(String literalName){
        return rawValues.get(literalNames.indexOf(literalName));
    }
}
