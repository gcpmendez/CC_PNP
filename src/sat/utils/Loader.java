package sat.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import sat.Clause;
import sat.Instance;
import sat.Literal;

public abstract class Loader {

    /** METHODS */
    public static String nameFile (int number) {
        String path = "examples/"; 
        
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 
        System.out.println(listOfFiles.length);
        
        return "examples/" + listOfFiles[number].getName();
    }
    
    public static Instance LoadInstanceFromFile(String path) throws FileNotFoundException, IOException {
        String cadena;
        Instance instance = new Instance();
        System.out.println(path);
        FileReader fileReader = new FileReader(path);       
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        ArrayList<String> literalNames = new ArrayList<String>();
        ArrayList<Clause> clauses = new ArrayList<Clause>();
        
        boolean C = false;
        cadena = bufferedReader.readLine();
        while ((cadena = bufferedReader.readLine()) != null) {
            if (cadena.charAt(0) == '#') {
                cadena = bufferedReader.readLine();
                C = true;
            }
            if (C) {    // CLAUSULAS
                String [] str = cadena.split(" ");
                ArrayList<Literal> literalsTemp = new ArrayList<Literal>();
                for (int i = 0; i < str.length; i++) {
                    if (str[i].contains("!")){
                        str[i] = str[i].replace("!", ""); // Quitamos el ! del nombre.
                        literalsTemp.add(new Literal(str[i],true)); // Nuevo literal que SI esta negado (negated=true).
                    }
                    else
                        literalsTemp.add(new Literal(str[i],false)); // Nuevo literal que NO esta negado (negated=false).
                }
                Clause Ci = new Clause();
                Ci.setLiteralsSet(literalsTemp);
                clauses.add(Ci);
            } else {    // LITERALES
                literalNames.add(cadena);
            }
        }
        instance.setLiterals(literalNames);
        instance.setClauses(clauses);
        
        bufferedReader.close();

        return instance;
    }
}
