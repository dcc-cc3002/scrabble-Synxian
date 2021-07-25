package cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory;

import cl.uchile.dcc.scrabble.types.numbers.ScrInt;

import java.util.Hashtable;

/**
 * Class that implements Flyweight method for ScrInt
 */
public class ScrIntFactory {
    /**
     * the hashtable that contains existing ScrInt objects
     */
    public static Hashtable<Integer, ScrInt> intHashtable = new Hashtable<>();

    /**
     * Checks if a ScrInt with the given value exists, if it does, returns the existing object, otherwise it creates
     * it and stores it in the hashtable
     * @param value the value contained by the Scr object to create/search
     * @return the ScrInt Object with the given value
     */
    public static ScrInt get(Integer value) {
        ScrInt scr = intHashtable.get(value);
        if (scr == null) {
            scr = new ScrInt(value);
            intHashtable.put(value, scr);
        }
        return scr;
    }
}
