package cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory;

import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;


import java.util.Hashtable;

/**
 * Class that implements Flyweight method for ScrBinary
 */
public class ScrBinaryFactory {

    /**
     * the hashtable that contains existing ScrBinary objects
     */
    private final static Hashtable<String, ScrBinary> binHashtable = new Hashtable<>();

    /**
     * Checks if a ScrBinary with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the ScrBinary Object with the given value
     */
    public static ScrBinary get(String value) {
        ScrBinary scr = binHashtable.get(value);
        if (scr == null) {
            scr = new ScrBinary(value);
            binHashtable.put(value, scr);
        }
        return scr;
    }
}
