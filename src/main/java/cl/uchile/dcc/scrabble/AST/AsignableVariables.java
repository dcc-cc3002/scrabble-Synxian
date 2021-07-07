package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Class that's able to save a variable and assign its value later
 */
public class AsignableVariables implements TreeNodes {

    private ScrNode value;
    private final String key;

    /**
     * The constructor methos for this class, initially it only recieves the name of the variable
     * @param key the identification of the variable
     */
    public AsignableVariables(String key){
        this.key=key;
    }

    @Override
    public SType getValue() {
        return this.value.getValue();
    }

    @Override
    public ScrNode eval() {
        return this.value;
    }

    /**
     * sets the corresponding value to it key
     * @param value the value contained by the variable
     */
    public void setValue(ScrNode value) {
        this.value = value;
    }
}
