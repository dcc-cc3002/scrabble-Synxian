package cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeBinary;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;

import java.util.Hashtable;

/**
 * Class that implements Flyweight method for Binary nodes
 */
public class NodeBinaryFactory {
    /**
     * the hashtable that contains existing NodeBinary objects
     */
    private final static Hashtable<String, NodeBinary> binHashtable = new Hashtable<>();

    /**
     * Checks if a NodeBinary with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the NodeBinary Object with the given value
     */
    public static NodeBinary get(String value) {
        NodeBinary scr = binHashtable.get(value);
        if (scr == null) {
            ScrBinary scrObj = ScrTypesFactory.getScrBinaryFlyweight(value);
            scr = new NodeBinary(scrObj);
            binHashtable.put(value, scr);
        }
        return scr;
    }
}
