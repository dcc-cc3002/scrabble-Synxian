package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.types.SType;

/**
 * Class that's able to save a variable and assign its value later
 */
public class AssignableVariables implements TreeNodes, ITreeNodes {

    private ScrNode value;
    private final String key;

    /**
     * The constructor method for this class, initially it only receives the name of the variable
     * @param key the identification of the variable
     */
    public AssignableVariables(String key){
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
     * sets the corresp|onding value to it's key
     * @param value the value contained by the variable
     */
    public void setValue(ScrNode value) {
        this.value = value;
    }
}
