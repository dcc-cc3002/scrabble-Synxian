package cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory;

import cl.uchile.dcc.scrabble.types.ScrString;

/**
 * Class that implements Flyweight method for ScrString
 */
import java.util.Hashtable;

public class ScrStringFactory {
    /**
     * the hashtable that contains existing ScrString objects
     */
    private final static Hashtable<String, ScrString> strHashtable = new Hashtable<>();

    /**
     * Checks if a ScrString with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the ScrString Object with the given value
     */
    public static ScrString get(String value) {
        ScrString scr = strHashtable.get(value);
        if (scr == null) {
            scr = new ScrString(value);
            strHashtable.put(value, scr);
        }
        return scr;
    }
}
