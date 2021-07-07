package cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory;

import cl.uchile.dcc.scrabble.types.ScrBool;
import cl.uchile.dcc.scrabble.types.ScrString;
import cl.uchile.dcc.scrabble.types.numbers.ScrBinary;
import cl.uchile.dcc.scrabble.types.numbers.ScrFloat;
import cl.uchile.dcc.scrabble.types.numbers.ScrInt;

/**
 * Class that implements Flyweight method for ScrTypes, by referring to the specific classes
 */
public class ScrTypesFactory {

    /**
     * Uses the ScrInt Object Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited ScrInt
     */
    public static ScrInt getScrIntFlyweight(int value){
        return ScrIntFactory.get(value);
    }

    /**
     * Uses the ScrBool Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited ScrBool
     */
    public static ScrBool getScrBoolFlyweight(boolean value){
        return ScrBoolFactory.get(value);
    }

    /**
     * Uses the ScrString Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited ScrString
     */
    public static ScrString getScrStringFlyweight(String value){
        return ScrStringFactory.get(value);
    }

    /**
     * Uses the ScrFloat Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited ScrFloat
     */
    public static ScrFloat getScrFloatFlyweight(double value){
        return ScrFloatFactory.get(value);
    }

    /**
     * Uses the ScrBinary Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited ScrBinary
     */
    public static ScrBinary getScrBinaryFlyweight(String value){
        return ScrBinaryFactory.get(value);
    }
}
