package cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory;

import cl.uchile.dcc.scrabble.types.ScrBool;


import java.util.Hashtable;

/**
 * Class that implements Flyweight method for ScrBool
 */
public class ScrBoolFactory {
    /**
     * the hashtable that contains existing ScrBool objects
     */
    private final static Hashtable<Boolean, ScrBool> boolHashtable = new Hashtable<>();

    /**
     * Checks if a ScrBool with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the ScrBool Object with the given value
     */
    public static ScrBool get(boolean value) {
        ScrBool scr = boolHashtable.get(value);
        if (scr == null) {
            scr = new cl.uchile.dcc.scrabble.types.ScrBool(value);
            boolHashtable.put(value, scr);
        }
        return scr;
    }
}
