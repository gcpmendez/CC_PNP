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
        
        ArrayList<Literal> literals = new ArrayList<Literal>();
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
                    if (str[i].contains("!"))
                        literalsTemp.add(new Literal(str[i].replace("!", ""),false));
                    else
                        literalsTemp.add(new Literal(str[i].replace("!", ""),true));
                }
                Clause Ci = new Clause();
                Ci.setLiteralsSet(literalsTemp);
                clauses.add(Ci);
            } else {    // LITERALES
                String [] str = cadena.split(" ");
                if (str[1].equals("T")) {
                    literals.add(new Literal(str[0],true));
                } else {
                    literals.add(new Literal(str[0],false));
                }
            }
        }
        instance.setLiterals(literals);
        instance.setClauses(clauses);
        
        bufferedReader.close();

        return instance;
    }
}
