package cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeInt;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;

import java.util.Hashtable;

/**
 * Class that implements Flyweight method for Int nodes
 */
public class NodeIntFactory {
    /**
     * the hashtable that contains existing NodeInt objects
     */
    private final static Hashtable<Integer, NodeInt> binHashtable = new Hashtable<>();

    /**
     * Checks if a NodeInt with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the NodeInt Object with the given value
     */
    public static NodeInt get(int value) {
        NodeInt scr = binHashtable.get(value);
        if (scr == null) {
            ScrInt scrObj = ScrTypesFactory.getScrIntFlyweight(value);
            scr = new NodeInt(scrObj);
            binHashtable.put(value, scr);
        }
        return scr;
    }
}
