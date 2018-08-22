package Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to store the variables and their values
 */
public class SymbolTable {

    private Map< String, Integer > symboltable = new HashMap<>();

    /**
     * Constructor
     */
    public SymbolTable() {}

    /**
     * See if the variable is present
     * @param var : variable name
     * @return true or false
     */
    public boolean exists( String var ) {
        return symboltable.containsKey( var );
    }

    /**
     * Get the value of the given variable.
     * @param var: variable name
     * @return value of variable
     */
    public int get( String var ) {
        if ( !symboltable.containsKey( var ) ) {
            Errors.error( "Variable is not present", 0 );
        }
        return symboltable.get( var );
    }

    /**
     * Update or put var name and value
     * @param  var: variable name
     * @param value  variable value
     */
    public void put( String var, int value ) {
        symboltable.put( var, value );
    }

    /**
     * Show on standard output the values of all the variables in the table.
     */
    public void dump() {
        System.out.println( "Symbol Table Contents:" );
        for ( String var: symboltable.keySet() ) {
            System.out.println(var+":"+symboltable.get(var));
        }
    }
}