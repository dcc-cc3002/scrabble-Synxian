package cl.uchile.dcc.scrabble.T3Shenanigans;


import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.AstFactory.AssignableVariablesFactory;

/**
 * class that handles variables actualizations when inserted in a Seq structure
 */
public class AssignToVariable implements TreeNodes {


    private String var;
    private TreeNodes value;

    /**
     * Constructor method of this class
     * @param var the variable
     * @param value the value of the variable
     */
    protected AssignToVariable(String var, TreeNodes value) {
        this.var=var;
        this.value=value;
    }

    /**
     * gets the id of the variable
     * @return the 'name' of the variable
     */
    public String getVar(){
        return this.var;
    }

    /**
     * Updates the variables value
     */
    @Override
    public ScrNode eval() {
        AssignableVariablesFactory.setVariable(this.getVar(), this.value.eval());
        return null;
    }
}
