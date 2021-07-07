package cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory;

import cl.uchile.dcc.scrabble.AST.Nodes.NodeFloat;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;

import java.util.Hashtable;

/**
 * Class that implements Flyweight method for Float nodes
 */
public class NodeFloatFactory {
    /**
     * the hashtable that contains existing NodeFloat objects
     */
    private final static Hashtable<Double, NodeFloat> floatNodeHashtable = new Hashtable<>();

    /**
     * Checks if a NodeFloat with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the NodeFloat Object with the given value
     */
    public static NodeFloat get(double value) {
        NodeFloat scr = floatNodeHashtable.get(value);
        if (scr == null) {
            ScrFloat scrObj = ScrTypesFactory.getScrFloatFlyweight(value);
            scr = new NodeFloat(scrObj);
            floatNodeHashtable.put(value, scr);
        }
        return scr;
    }
}
