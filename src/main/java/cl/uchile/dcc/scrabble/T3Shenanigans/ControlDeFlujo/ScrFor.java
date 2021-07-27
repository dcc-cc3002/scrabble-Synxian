package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;

/**
 * Class that handles the for loop for scrabble
 */
public class ScrFor implements TreeNodes {
    private TreeNodes init;
    /**
     * this can be a tree, but at the end it must result in a nodeBool
     */
    private TreeNodes stopCondition;
    private TreeNodes increment;
    private TreeNodes doThis;

    /**
     * The constructor method for the loop (very similar to the c initialization of a for loop)
     * @param init the variable to be constantly updated and compared in the condition, expected to be a Node Int or Float
     *             (and maybe binary wink wink)
     * @param condition the condition for the loop, when it stops being true, the for loop is going to end
     * @param increment the increment applied to the init param after each loop, expected to be a Node Int or float
     *                  (once again, it might even accept binary, wink)
     * @param doThis the instruction to be executed
     */
    public ScrFor(TreeNodes init, TreeNodes condition, TreeNodes increment, TreeNodes doThis){
        this.stopCondition=condition;
        this.increment=increment;
        this.doThis=doThis;
        this.init=init;
    }

    /**
     * Executes the instruction as long as the for is being used
     * @return nothing, it just executes the block of code
     */
    @Override
    public ScrNode eval() {
        this.init.eval();
        while(this.stopCondition.eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
            this.doThis.eval();
            this.increment.eval();
        }
        return null;
    }
}
