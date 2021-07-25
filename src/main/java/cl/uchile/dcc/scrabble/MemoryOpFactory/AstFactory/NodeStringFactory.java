package cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeString;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.ScrString;
;

import java.util.Hashtable;

/**
 * Class that implements Flyweight method for String nodes
 */
public class NodeStringFactory {
    /**
     * the hashtable that contains existing NodeString objects
     */
    private final static Hashtable<String, NodeString> floatNodeHashtable = new Hashtable<>();

    /**
     * Checks if a NodeString with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the NodeString Object with the given value
     */
    public static NodeString get(String value) {
        NodeString scr = floatNodeHashtable.get(value);
        if (scr == null) {
            ScrString scrObj = ScrTypesFactory.getScrStringFlyweight(value);
            scr = new NodeString(scrObj);
            floatNodeHashtable.put(value, scr);
        }
        return scr;
    }
}
