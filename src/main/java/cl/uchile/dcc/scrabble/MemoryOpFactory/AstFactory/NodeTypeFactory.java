package cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory;

import cl.uchile.dcc.scrabble.AST.Nodes.*;

/**
 * Class that implements Flyweight method for ScrTypes, by referring to the specific classes
 */
public class NodeTypeFactory {
    /**
     * Uses the NodeInt Object Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited NodeInt
     */
    public static NodeInt getNodeIntFlyweight(int value){
        return NodeIntFactory.get(value);
    }

    /**
     * Uses the NodeBool Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited NodeBool
     */
    public static NodeBool getNodeBoolFlyweight(boolean value){
        return NodeBoolFactory.get(value);
    }

    /**
     * Uses the NodeString Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited NodeString
     */
    public static NodeString getNodeStringFlyweight(String value){
        return NodeStringFactory.get(value);
    }

    /**
     * Uses the NodeFloat Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited NodeFloat
     */
    public static NodeFloat getNodeFloatFlyweight(double value){
        return NodeFloatFactory.get(value);
    }

    /**
     * Uses the NodeBinary Flyweight factory
     * @param value the value of the object to be sent to its corresponding Flyweight factory
     * @return the solicited NodeBinary
     */
    public static NodeBinary getNodeBinaryFlyweight(String value){
        return NodeBinaryFactory.get(value);
    }
}
