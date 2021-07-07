package cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeBool;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.ScrBool;

import java.util.Hashtable;

/**
 * Class that implements Flyweight method for Bool nodes
 */
public class NodeBoolFactory {
    /**
     * the hashtable that contains existing NodeBool objects
     */
    private final static Hashtable<Boolean, NodeBool> floatNodeHashtable = new Hashtable<>();

    /**
     * Checks if a NodeBool with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the NodeBool Object with the given value
     */
    public static NodeBool get(boolean value) {
        NodeBool scr = floatNodeHashtable.get(value);
        if (scr == null) {
            ScrBool scrObj = ScrTypesFactory.getScrBoolFlyweight(value);
            scr = new NodeBool(scrObj);
            floatNodeHashtable.put(value, scr);
        }
        return scr;
    }
}
