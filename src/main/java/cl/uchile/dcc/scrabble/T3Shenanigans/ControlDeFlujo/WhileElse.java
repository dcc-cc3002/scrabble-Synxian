package cl.uchile.dcc.scrabble.T3Shenanigans.ControlDeFlujo;

import cl.uchile.dcc.scrabble.AST.Nodes.ScrNode;
import cl.uchile.dcc.scrabble.AST.TreeNodes;
import cl.uchile.dcc.scrabble.MemoryOpFactory.TypesFactory.ScrTypesFactory;

/**
 * Class that handles the while-else loop for scrabble
 */
public class WhileElse implements TreeNodes {
    /**
     * this can be a tree, but at the end it must result in a nodeBool
     */
    private TreeNodes condition;

    private TreeNodes doThis;

    private TreeNodes elseDo;

    /**
     * the constructor method of the loop
     * @param condition the condition under the while will continue looping
     * @param doThis the instruction for the loop
     * @param elseDo what to do if the while condition isn't met/stop being true
     */
    public WhileElse(TreeNodes condition, TreeNodes doThis, TreeNodes elseDo){
        this.condition=condition;
        this.doThis=doThis;
        this.elseDo=elseDo;
    }


    /**
     * Executes the instruction while the condition is meet, if it stops being true, or even if it never was,
     * executes the else instruction
     * @return nothing, it just executes the instruction
     */
    @Override
    public ScrNode eval() {
        this.doThis.eval();
        while(condition.eval().getValue().equals(ScrTypesFactory.getScrBoolFlyweight(true))){
            this.doThis.eval();
        }
        this.elseDo.eval();
        return null;
    }
}
