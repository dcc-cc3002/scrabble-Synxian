package cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory;

import cl.uchile.dcc.scrabble.AST.AssignableVariables;
import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;

import java.util.Hashtable;

/**
 * The Flyweight factory vor the assignable variables
 */
public class AssignableVariablesFactory {
    /**
     * the hashtable that stores each variable
     */
    public static Hashtable<String, AssignableVariables> varHashtable = new Hashtable<>();

    /**
     * Checks if a AssignableVariable with the given key exists, if it does, returns the existing object, otherwise it creates it
     * @param key the key of the variable
     * @return a AssignableVariable object
     */
    public static AssignableVariables get(String key) {
        AssignableVariables variable = varHashtable.get(key);
        if (variable == null) {
            variable= new AssignableVariables(key);
            varHashtable.put(key,variable);
            return variable;
        }
        return variable;
    }

    /**
     * Sets the value of the key variable
     * @param key the name of the variable
     * @param value the value to be set
     */
    public static void setVariable(String key, ScrNode value){
        AssignableVariables variable = get(key);
        variable.setValue(value);
        varHashtable.put(key, variable);
    }

    /**
     * Sets the value of the NodeInt variable
     * @param key the key of the variable
     * @param value the value of the node
     */
    public static void setAssignableNodeInt(String key, int value){
        setVariable(key, NodeTypeFactory.getNodeIntFlyweight(value));
    }

    /**
     * Sets the value of the NodeFloat variable
     * @param key the key of the variable
     * @param value the value of the node
     */
    public static void setAssignableNodeFloat(String key, double value){
        setVariable(key, NodeTypeFactory.getNodeFloatFlyweight(value));
    }

    /**
     * Sets the value of the NodeBinary variable
     * @param key the key of the variable
     * @param value the value of the node
     */
    public static void setAssignableNodeBinary(String key, String value){
        setVariable(key, NodeTypeFactory.getNodeBinaryFlyweight(value));
    }

    /**
     * Sets the value of the NodeBool variable
     * @param key the key of the variable
     * @param value the value of the node
     */
    public static void setAssignableNodeBool(String key, boolean value){
        setVariable(key, NodeTypeFactory.getNodeBoolFlyweight(value));
    }

    /**
     * Sets the value of the NodeString variable
     * @param key the key of the variable
     * @param value the value of the node
     */
    public static void setAssignableNodeString(String key, String value){
        setVariable(key, NodeTypeFactory.getNodeStringFlyweight(value));
    }

}
