package cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory;

import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;

import java.util.Hashtable;

/**
 * Class that implements Flyweight method for ScrFloat
 */
public class ScrFloatFactory {
    /**
     * the hashtable that contains existing ScrFloat objects
     */
    private final static Hashtable<Double, ScrFloat> floatHash = new Hashtable<>();

    /**
     * Checks if a ScrFloat with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the ScrFloat Object with the given value
     */
    public static ScrFloat get(double value) {
        ScrFloat scr = floatHash.get(value);
        if (scr == null) {
            scr = new ScrFloat(value);
            floatHash.put(value, scr);
        }
        return scr;
    }
}
